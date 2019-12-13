/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.internal.price;

import com.liferay.commerce.account.constants.CommerceAccountConstants;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.model.CommerceAccountGroup;
import com.liferay.commerce.account.service.CommerceAccountGroupLocalService;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.currency.model.CommerceMoneyFactory;
import com.liferay.commerce.currency.service.CommerceCurrencyLocalService;
import com.liferay.commerce.discount.CommerceDiscountCalculation;
import com.liferay.commerce.price.CommerceProductPrice;
import com.liferay.commerce.price.CommerceProductPriceCalculation;
import com.liferay.commerce.price.list.model.CommercePriceEntry;
import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.list.model.CommerceTierPriceEntry;
import com.liferay.commerce.price.list.service.CommercePriceEntryLocalService;
import com.liferay.commerce.price.list.service.CommercePriceListLocalService;
import com.liferay.commerce.price.list.service.CommerceTierPriceEntryLocalService;
import com.liferay.commerce.price.modifier.CommercePriceModifierCalculation;
import com.liferay.commerce.price.modifier.CommercePriceModifierValue;
import com.liferay.commerce.product.constants.CPActionKeys;
import com.liferay.commerce.product.constants.CPConstants;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.service.CPInstanceLocalService;
import com.liferay.commerce.product.service.CommerceCatalogLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Alberti
 */
@Component(
	property = "commerce.price.calculation.key=CommerceProductPLPriceCalculationImpl",
	service = CommerceProductPriceCalculation.class
)
public class CommerceProductPLPriceCalculationImpl
	implements CommerceProductPriceCalculation {

	@Override
	public CommerceProductPrice getCommerceProductPrice(
			long cpInstanceId, int quantity, boolean secure,
			CommerceContext commerceContext)
		throws PortalException {

		if (secure && !_hasViewPricePermission(commerceContext)) {
			return null;
		}

		CPInstance cpInstance = _cpInstanceLocalService.getCPInstance(
			cpInstanceId);

		// Solve price list hierarchy

		CommercePriceList commercePriceList = _getPriceList(
			cpInstance.getGroupId(), commerceContext);

		// get currenct price entry

		CommercePriceEntry commercePriceEntry =
			_commercePriceEntryLocalService.fetchCommercePriceEntry(
				commercePriceList.getCommercePriceListId(),
				cpInstance.getCPInstanceUuid());

		// apply price list modifier // add support for tiered price entry

		CommercePriceModifierValue commercePriceListPriceModifierValue =
			_commercePriceModifierCalculation.getPriceListPriceModifierValue(
				commercePriceEntry, quantity, commerceContext);

		CommerceMoney priceListPrice =
			commercePriceListPriceModifierValue.getModifiedPrice();

		CommerceMoney promoPriceMoney = getPromoPrice(
			cpInstanceId, quantity, commerceContext.getCommerceCurrency(),
			secure, commerceContext);

		CommerceProductPriceImpl commerceProductPriceImpl =
			new CommerceProductPriceImpl();

		commerceProductPriceImpl.setQuantity(quantity);
		commerceProductPriceImpl.setUnitPrice(priceListPrice);
		commerceProductPriceImpl.setUnitPromoPrice(promoPriceMoney);
		commerceProductPriceImpl.setFinalPrice(priceListPrice);

		BigDecimal finalPrice = priceListPrice.getPrice();

		BigDecimal promoPrice = promoPriceMoney.getPrice();

		if ((promoPrice != null) &&
			(promoPrice.compareTo(BigDecimal.ZERO) > 0) &&
			(promoPrice.compareTo(priceListPrice.getPrice()) <= 0)) {

			finalPrice = promoPriceMoney.getPrice();
		}

		commerceProductPriceImpl.setFinalPrice(
			_commerceMoneyFactory.create(
				commerceContext.getCommerceCurrency(), finalPrice));

		/*

		// DISCOUNT PRODUCT CALCULATION

		CommerceDiscountValue commerceDiscountValue =
			_commerceDiscountCalculation.getProductCommerceDiscountValue(
				cpInstanceId, quantity, finalPrice, commerceContext);

		finalPrice = finalPrice.multiply(BigDecimal.valueOf(quantity));

		if (commerceDiscountValue != null) {
			CommerceMoney discountAmountMoney =
				commerceDiscountValue.getDiscountAmount();

			finalPrice = finalPrice.subtract(discountAmountMoney.getPrice());
		}

		commerceProductPriceImpl.setCommerceDiscountValue(
			commerceDiscountValue);

		// CALCULATE TAXES

		commerceProductPriceImpl.setFinalPrice(
			_commerceMoneyFactory.create(
				commerceContext.getCommerceCurrency(), finalPrice));*/

		return commerceProductPriceImpl;
	}

	@Override
	public CommerceProductPrice getCommerceProductPrice(
			long cpInstanceId, int quantity, CommerceContext commerceContext)
		throws PortalException {

		return getCommerceProductPrice(
			cpInstanceId, quantity, true, commerceContext);
	}

	@Override
	public CommerceMoney getFinalPrice(
			long cpInstanceId, int quantity, boolean secure,
			CommerceContext commerceContext)
		throws PortalException {

		if (secure && !_hasViewPricePermission(commerceContext)) {
			return null;
		}

		CommerceProductPrice commerceProductPrice = getCommerceProductPrice(
			cpInstanceId, quantity, commerceContext);

		if (commerceProductPrice == null) {
			return null;
		}

		return commerceProductPrice.getFinalPrice();
	}

	@Override
	public CommerceMoney getFinalPrice(
			long cpInstanceId, int quantity, CommerceContext commerceContext)
		throws PortalException {

		return getFinalPrice(cpInstanceId, quantity, true, commerceContext);
	}

	@Override
	public CommerceMoney getPromoPrice(
			long cpInstanceId, int quantity, CommerceCurrency commerceCurrency,
			boolean secure, CommerceContext commerceContext)
		throws PortalException {

		// PROMO CALCULATION

		if (secure && !_hasViewPricePermission(commerceContext)) {
			return null;
		}

		CPInstance cpInstance = _cpInstanceLocalService.getCPInstance(
			cpInstanceId);

		CommercePriceList commercePriceList = _getPriceList(
			cpInstance.getGroupId(), commerceContext);

		BigDecimal priceListPrice = _getPriceListPrice(
			cpInstanceId, quantity, commercePriceList,
			commerceContext.getCommerceCurrency(), true);

		return _commerceMoneyFactory.create(commerceCurrency, priceListPrice);
	}

	@Override
	public CommerceMoney getUnitMaxPrice(
			long cpDefinitionId, int quantity, boolean secure,
			CommerceContext commerceContext)
		throws PortalException {

		if (secure && !_hasViewPricePermission(commerceContext)) {
			return null;
		}

		CommerceMoney commerceMoney = null;
		BigDecimal maxPrice = BigDecimal.ZERO;

		List<CPInstance> cpInstances =
			_cpInstanceLocalService.getCPDefinitionInstances(
				cpDefinitionId, WorkflowConstants.STATUS_APPROVED,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		for (CPInstance cpInstance : cpInstances) {
			CommerceMoney cpInstanceCommerceMoney = getUnitPrice(
				cpInstance.getCPInstanceId(), quantity,
				commerceContext.getCommerceCurrency(), secure, commerceContext);

			if (maxPrice.compareTo(cpInstanceCommerceMoney.getPrice()) < 0) {
				commerceMoney = cpInstanceCommerceMoney;

				maxPrice = commerceMoney.getPrice();
			}
		}

		return commerceMoney;
	}

	@Override
	public CommerceMoney getUnitMaxPrice(
			long cpDefinitionId, int quantity, CommerceContext commerceContext)
		throws PortalException {

		return getUnitMaxPrice(cpDefinitionId, quantity, true, commerceContext);
	}

	@Override
	public CommerceMoney getUnitMinPrice(
			long cpDefinitionId, int quantity, boolean secure,
			CommerceContext commerceContext)
		throws PortalException {

		if (secure && !_hasViewPricePermission(commerceContext)) {
			return null;
		}

		CommerceMoney commerceMoney = null;
		BigDecimal minPrice = BigDecimal.ZERO;

		List<CPInstance> cpInstances =
			_cpInstanceLocalService.getCPDefinitionInstances(
				cpDefinitionId, WorkflowConstants.STATUS_APPROVED,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);

		for (CPInstance cpInstance : cpInstances) {
			CommerceMoney cpInstanceCommerceMoney = getUnitPrice(
				cpInstance.getCPInstanceId(), quantity,
				commerceContext.getCommerceCurrency(), secure, commerceContext);

			if ((commerceMoney == null) ||
				(minPrice.compareTo(cpInstanceCommerceMoney.getPrice()) > 0)) {

				commerceMoney = cpInstanceCommerceMoney;

				minPrice = commerceMoney.getPrice();
			}
		}

		return commerceMoney;
	}

	@Override
	public CommerceMoney getUnitMinPrice(
			long cpDefinitionId, int quantity, CommerceContext commerceContext)
		throws PortalException {

		return getUnitMinPrice(cpDefinitionId, quantity, true, commerceContext);
	}

	@Override
	public CommerceMoney getUnitPrice(
			long cpInstanceId, int quantity, CommerceCurrency commerceCurrency,
			boolean secure, CommerceContext commerceContext)
		throws PortalException {

		if (secure && !_hasViewPricePermission(commerceContext)) {
			return null;
		}

		CPInstance cpInstance = _cpInstanceLocalService.getCPInstance(
			cpInstanceId);

		CommercePriceList commercePriceList = _getPriceList(
			cpInstance.getGroupId(), commerceContext);

		BigDecimal priceListPrice = _getPriceListPrice(
			cpInstanceId, quantity, commercePriceList,
			commerceContext.getCommerceCurrency(), false);

		//priceListPrice = _getPLPriceModifierPrice(cpInstanceId, commercePriceList, commerceContext);

		return _commerceMoneyFactory.create(commerceCurrency, priceListPrice);
	}

	private CommercePriceList _getPriceList(
			long groupId, CommerceContext commerceContext)
		throws PortalException {

		CommerceAccount commerceAccount = commerceContext.getCommerceAccount();

		if (commerceAccount == null) {
			return null;
		}

		List<CommerceAccountGroup> commerceAccountGroups =
			_commerceAccountGroupLocalService.
				getCommerceAccountGroupsByCommerceAccountId(
					commerceAccount.getCommerceAccountId());

		Stream<CommerceAccountGroup> stream = commerceAccountGroups.stream();

		long[] commerceAccountGroupIds = stream.mapToLong(
			CommerceAccountGroup::getCommerceAccountGroupId
		).toArray();

		Optional<CommercePriceList> commercePriceList =
			_commercePriceListLocalService.getCommercePriceList(
				commerceAccount.getCompanyId(), groupId,
				commerceAccount.getCommerceAccountId(),
				commerceAccountGroupIds);

		if (!commercePriceList.isPresent()) {

			// There should always be a pricelist

			throw new PortalException("");
		}

		return commercePriceList.get();
	}

	private BigDecimal _getPriceListPrice(
			long cpInstanceId, int quantity,
			CommercePriceList commercePriceList,
			CommerceCurrency commerceCurrency, boolean promo)
		throws PortalException {

		BigDecimal price = null;

		CommercePriceEntry commercePriceEntry =
			_commercePriceEntryLocalService.fetchCommercePriceEntry(
				cpInstanceId, commercePriceList.getCommercePriceListId());

		if (commercePriceEntry != null) {
			price = commercePriceEntry.getPrice();

			if (commercePriceEntry.isHasTierPrice()) {
				CommerceTierPriceEntry commerceTierPriceEntry =
					_commerceTierPriceEntryLocalService.
						findClosestCommerceTierPriceEntry(
							commercePriceEntry.getCommercePriceEntryId(),
							quantity);

				if (commerceTierPriceEntry != null) {
					price = commerceTierPriceEntry.getPrice();
				}
			}

			CommerceCurrency priceListCurrency =
				_commerceCurrencyLocalService.getCommerceCurrency(
					commercePriceList.getCommerceCurrencyId());

			if (priceListCurrency.getCommerceCurrencyId() !=
					commerceCurrency.getCommerceCurrencyId()) {

				price = price.divide(
					priceListCurrency.getRate(),
					RoundingMode.valueOf(priceListCurrency.getRoundingMode()));

				price = price.multiply(commerceCurrency.getRate());
			}
		}

		return price;
	}

	private boolean _hasViewPricePermission(CommerceContext commerceContext)
		throws PortalException {

		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		CommerceAccount commerceAccount = commerceContext.getCommerceAccount();

		if ((commerceAccount != null) &&
			(commerceAccount.getType() ==
				CommerceAccountConstants.ACCOUNT_TYPE_BUSINESS)) {

			return _portletResourcePermission.contains(
				permissionChecker, commerceAccount.getCommerceAccountGroupId(),
				CPActionKeys.VIEW_PRICE);
		}

		return _portletResourcePermission.contains(
			permissionChecker, commerceContext.getSiteGroupId(),
			CPActionKeys.VIEW_PRICE);
	}

	@Reference
	private CommerceAccountGroupLocalService _commerceAccountGroupLocalService;

	@Reference
	private CommerceCatalogLocalService _commerceCatalogLocalService;

	@Reference
	private CommerceCurrencyLocalService _commerceCurrencyLocalService;

	@Reference
	private CommerceDiscountCalculation _commerceDiscountCalculation;

	@Reference
	private CommerceMoneyFactory _commerceMoneyFactory;

	@Reference
	private CommercePriceEntryLocalService _commercePriceEntryLocalService;

	@Reference
	private CommercePriceListLocalService _commercePriceListLocalService;

	@Reference
	private CommercePriceModifierCalculation _commercePriceModifierCalculation;

	@Reference
	private CommerceTierPriceEntryLocalService
		_commerceTierPriceEntryLocalService;

	@Reference
	private CPInstanceLocalService _cpInstanceLocalService;

	@Reference(target = "(resource.name=" + CPConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

}