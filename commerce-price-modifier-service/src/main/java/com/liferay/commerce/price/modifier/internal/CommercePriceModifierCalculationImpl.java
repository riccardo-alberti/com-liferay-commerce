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

package com.liferay.commerce.price.modifier.internal;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.currency.model.CommerceMoneyFactory;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.price.list.model.CommercePriceEntry;
import com.liferay.commerce.price.modifier.CommercePriceModifierCalculation;
import com.liferay.commerce.price.modifier.CommercePriceModifierValue;
import com.liferay.commerce.price.modifier.exception.InvalidPriceModifierTypeException;
import com.liferay.commerce.price.modifier.internal.search.CommercePriceModifierIndexer;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.commerce.price.modifier.type.CommercePriceModifierType;
import com.liferay.commerce.price.modifier.type.CommercePriceModifierTypeRegistry;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Alberti
 */
@Component(service = CommercePriceModifierCalculation.class)
public class CommercePriceModifierCalculationImpl
	implements CommercePriceModifierCalculation {

	@Override
	public CommercePriceModifierValue
			getOrderShippingCommercePriceModifierValue(
				CommerceOrder commerceOrder, BigDecimal shippingAmount,
				CommerceContext commerceContext)
		throws PortalException {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public CommercePriceModifierValue
			getOrderSubtotalCommercePriceModifierValue(
				CommerceOrder commerceOrder, BigDecimal subtotalAmount,
				CommerceContext commerceContext)
		throws PortalException {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public CommercePriceModifierValue getOrderTotalCommercePriceModifierValue(
			CommerceOrder commerceOrder, BigDecimal totalAmount,
			CommerceContext commerceContext)
		throws PortalException {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public CommercePriceModifierValue getPriceListPriceModifierValue(
			CommercePriceEntry commercePriceEntry, int quantity,
			CommerceContext commerceContext)
		throws PortalException {

		if (commercePriceEntry == null) {
			return null;
		}

		CPInstance cpInstance = commercePriceEntry.getCPInstance();

		SearchContext searchContext = buildSearchContext(
			cpInstance.getCompanyId(), 0, 0,
			commercePriceEntry.getCommercePriceListId(), 0,
			commerceContext.getCommerceAccountGroupIds(),
			CommercePriceModifierTarget.Type.APPLY_TO_PRICELIST);

		searchContext.setStart(0);
		searchContext.setEnd(1);

		Sort sort = SortFactoryUtil.create(
			Field.PRIORITY + "_Number_sortable", true);

		searchContext.setSorts(sort);

		return _getCommercePriceModifierValue(
			commercePriceEntry, quantity, commerceContext, searchContext);
	}

	@Override
	public CommercePriceModifierValue getProductPriceModifierValue(
			CommercePriceEntry commercePriceEntry, int quantity,
			CommerceContext commerceContext)
		throws PortalException {

		if (commercePriceEntry == null) {
			return null;
		}

		CPInstance cpInstance = commercePriceEntry.getCPInstance();

		SearchContext searchContext = buildSearchContext(
			cpInstance.getCompanyId(), cpInstance.getCPDefinitionId(),
			cpInstance.getCPInstanceId(),
			commercePriceEntry.getCommercePriceListId(), 0,
			commerceContext.getCommerceAccountGroupIds(),
			CommercePriceModifierTarget.Type.APPLY_TO_PRODUCT);

		return _getCommercePriceModifierValue(
			commercePriceEntry, quantity, commerceContext, searchContext);
	}

	protected SearchContext buildSearchContext(
		long companyId, long cpDefinitionId, long cpInstanceId,
		long commercePriceListId, long commerceOrderId,
		long[] commerceAccountGroupIds,
		CommercePriceModifierTarget.Type commercePriceModifierTargetType) {

		SearchContext searchContext = new SearchContext();

		Map<String, Serializable> attributes = new HashMap<>();

		attributes.put(CommercePriceModifierIndexer.FIELD_ACTIVE, true);
		attributes.put(
			CommercePriceModifierIndexer.FIELD_TARGET_TYPE,
			commercePriceModifierTargetType.toString());
		attributes.put(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
		attributes.put("commerceAccountGroupIds", commerceAccountGroupIds);
		attributes.put("commerceOrderId", commerceOrderId);
		attributes.put("commercePriceListId", commercePriceListId);
		attributes.put("cpDefinitionId", cpDefinitionId);
		attributes.put("cpInstanceId", cpInstanceId);

		searchContext.setAttributes(attributes);

		searchContext.setCompanyId(companyId);
		searchContext.setStart(QueryUtil.ALL_POS);
		searchContext.setEnd(QueryUtil.ALL_POS);

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.setHighlightEnabled(false);
		queryConfig.setScoreEnabled(false);

		return searchContext;
	}

	private CommercePriceModifierValue _getCommercePriceModifierValue(
			CommercePriceEntry commercePriceEntry, int quantity,
			CommerceContext commerceContext, SearchContext searchContext)
		throws PortalException {

		CommerceCurrency commerceCurrency =
			commerceContext.getCommerceCurrency();

		BaseModelSearchResult<CommercePriceModifier> baseModelSearchResult =
			_commercePriceModifierLocalService.searchCommercePriceModifiers(
				searchContext);

		List<CommercePriceModifier> commercePriceModifiers =
			baseModelSearchResult.getBaseModels();

		if (commercePriceModifiers == null) {
			return new CommercePriceModifierValue(
				0,
				commercePriceEntry.getPriceMoney(
					commerceCurrency.getCommerceCurrencyId()),
				null, null);
		}

		// Solve price modifier hierarchy

		for (CommercePriceModifier commercePriceModifier :
				baseModelSearchResult.getBaseModels()) {

			return _getCommercePriceModifierValueByType(
				commercePriceEntry, quantity, commercePriceModifier,
				commerceCurrency);
		}

		return null;
	}

	private CommercePriceModifierValue _getCommercePriceModifierValueByType(
			CommercePriceEntry commercePriceEntry, int quantity,
			CommercePriceModifier commercePriceModifier,
			CommerceCurrency commerceCurrency)
		throws PortalException {

		String modifierType = commercePriceModifier.getModifierType();

		CommercePriceModifierType commercePriceModifierType =
			_commercePriceModifierTypeRegistry.getCommercePriceModifierType(
				modifierType);

		if (commercePriceModifierType == null) {
			throw new InvalidPriceModifierTypeException(modifierType);
		}

		CommerceMoney modifiedCommerceMoney =
			commercePriceModifierType.evaluate(
				commercePriceEntry, quantity, commercePriceModifier,
				commerceCurrency);

		CommerceMoney originalCommerceMoney = commercePriceEntry.getPriceMoney(
			commerceCurrency.getCommerceCurrencyId());

		RoundingMode roundingMode = RoundingMode.valueOf(
			commerceCurrency.getRoundingMode());

		return new CommercePriceModifierValue(
			commercePriceModifier.getCommercePriceModifierId(),
			originalCommerceMoney, modifiedCommerceMoney,
			_getPriceModifierPercentage(
				modifiedCommerceMoney.getPrice(),
				originalCommerceMoney.getPrice(), roundingMode));
	}

	private BigDecimal _getPriceModifierPercentage(
		BigDecimal modifiedAmount, BigDecimal amount,
		RoundingMode roundingMode) {

		double actualPrice = modifiedAmount.doubleValue();
		double originalPrice = amount.doubleValue();

		double percentage = actualPrice / originalPrice;

		BigDecimal discountPercentage = new BigDecimal(percentage);

		discountPercentage = discountPercentage.multiply(_ONE_HUNDRED);

		MathContext mathContext = new MathContext(
			discountPercentage.precision(), roundingMode);

		return _ONE_HUNDRED.subtract(discountPercentage, mathContext);
	}

	private static final BigDecimal _ONE_HUNDRED = BigDecimal.valueOf(100);

	@Reference
	private CommerceMoneyFactory _commerceMoneyFactory;

	@Reference
	private CommercePriceModifierLocalService
		_commercePriceModifierLocalService;

	@Reference
	private CommercePriceModifierTypeRegistry
		_commercePriceModifierTypeRegistry;

}