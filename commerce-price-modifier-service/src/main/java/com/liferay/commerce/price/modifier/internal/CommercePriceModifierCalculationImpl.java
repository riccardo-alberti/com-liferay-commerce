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
import com.liferay.commerce.price.list.model.CommercePriceEntry;
import com.liferay.commerce.price.modifier.CommercePriceModifierCalculation;
import com.liferay.commerce.price.modifier.CommercePriceModifierValue;
import com.liferay.commerce.price.modifier.constants.CommercePriceModifierConstants;
import com.liferay.commerce.price.modifier.exception.InvalidPriceModifierTypeException;
import com.liferay.commerce.price.modifier.internal.search.CommercePriceModifierIndexer;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringUtil;
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
	public CommercePriceModifierValue getPriceListPriceModifierValue(
			CommercePriceEntry commercePriceEntry,
			CommerceContext commerceContext)
		throws PortalException {

		if (commercePriceEntry == null) {
			return null;
		}

		CPInstance cpInstance = commercePriceEntry.getCPInstance();

		SearchContext searchContext = buildSearchContext(
			cpInstance.getCompanyId(), 0, 0,
			commercePriceEntry.getCommercePriceListId(),
			commerceContext.getCommerceAccountGroupIds(),
			CommercePriceModifierTarget.Type.APPLY_TO_PRICELIST);

		return _getCommercePriceModifierValue(
			commercePriceEntry, commerceContext, searchContext);
	}

	protected SearchContext buildSearchContext(
		long companyId, long cpDefinitionId, long cpInstanceId,
		long commercePriceListId, long[] commerceAccountGroupIds,
		CommercePriceModifierTarget.Type commerceDiscountTargetType) {

		SearchContext searchContext = new SearchContext();

		Map<String, Serializable> attributes = new HashMap<>();

		attributes.put(CommercePriceModifierIndexer.FIELD_ACTIVE, true);
		attributes.put(
			CommercePriceModifierIndexer.FIELD_TARGET_TYPE,
			commerceDiscountTargetType.toString());
		attributes.put(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
		attributes.put("commerceAccountGroupIds", commerceAccountGroupIds);
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
			CommercePriceEntry commercePriceEntry,
			CommerceContext commerceContext, SearchContext searchContext)
		throws PortalException {

		CommerceCurrency commerceCurrency =
			commerceContext.getCommerceCurrency();

		List<CommercePriceModifier> commercePriceModifiers =
			_commercePriceModifierLocalService.getCommercePriceModifiers(
				commercePriceEntry.getCompanyId(),
				CommercePriceModifierTarget.Type.APPLY_TO_PRICELIST.getValue());

		CommercePriceModifier commercePriceModifier =
			commercePriceModifiers.get(commercePriceModifiers.size() - 1);

		String settingsProperty = commercePriceModifier.getSettingsProperty(
			CommercePriceModifierTarget.Type.APPLY_TO_PRICELIST.getValue());

		long[] priceListIds = StringUtil.split(settingsProperty, 0L);

		if (ArrayUtil.contains(
				priceListIds, commercePriceEntry.getCommercePriceListId())) {

			return _getCommercePriceModifierValueByType(
				commercePriceEntry, commercePriceModifier, commerceCurrency);
		}

		return null;

		/*BaseModelSearchResult<CommercePriceModifier> baseModelSearchResult =
			_commercePriceModifierLocalService.searchCommercePriceModifiers(
				searchContext);

		CommerceCurrency commerceCurrency =
			commerceContext.getCommerceCurrency();

		for (CommercePriceModifier commercePriceModifier :
				baseModelSearchResult.getBaseModels()) {

			return _getCommercePriceModifierValueByType(
				commercePriceEntry, commercePriceModifier, commerceCurrency);
		}

		return null;*/
	}

	private CommercePriceModifierValue _getCommercePriceModifierValueByType(
			CommercePriceEntry commercePriceEntry,
			CommercePriceModifier commercePriceModifier,
			CommerceCurrency commerceCurrency)
		throws PortalException {

		String modifierType = commercePriceModifier.getModifierType();

		CommerceMoney originalCommerceMoney = commercePriceEntry.getPriceMoney(
			commerceCurrency.getCommerceCurrencyId());

		BigDecimal originalPrice = originalCommerceMoney.getPrice();

		BigDecimal modifiedPrice = null;
		CommerceMoney modifiedCommerceMoney = null;

		// VALIDATE

		if (modifierType.equals(CommercePriceModifierConstants.PERCENTAGE)) {
			BigDecimal modifierAmount =
				commercePriceModifier.getModifierAmount();

			BigDecimal percentage = BigDecimal.ONE.subtract(
				modifierAmount.divide(_ONE_HUNDRED));

			modifiedPrice = originalPrice.multiply(percentage);
		}
		else if (modifierType.equals(CommercePriceModifierConstants.ABSOLUTE)) {
			modifiedPrice = originalPrice.subtract(
				commercePriceModifier.getModifierAmount());
		}
		else if (modifierType.equals(CommercePriceModifierConstants.FORMULA)) {

			// TO DO

			throw new InvalidPriceModifierTypeException(modifierType);
		}
		else {
			throw new InvalidPriceModifierTypeException(modifierType);
		}

		if (modifiedPrice.compareTo(BigDecimal.ZERO) < 0) {
			modifiedPrice = originalPrice;
		}

		modifiedCommerceMoney = _commerceMoneyFactory.create(
			commerceCurrency, modifiedPrice);

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

}