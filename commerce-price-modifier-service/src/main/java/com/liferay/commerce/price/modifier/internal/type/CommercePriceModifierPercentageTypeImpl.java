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

package com.liferay.commerce.price.modifier.internal.type;

import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.currency.model.CommerceMoneyFactory;
import com.liferay.commerce.price.modifier.constants.CommercePriceModifierConstants;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.type.CommercePriceModifierType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.math.BigDecimal;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Alberti
 */
@Component(
	immediate = true,
	property = {
		"commerce.price.modifier.type.key=" + CommercePriceModifierConstants.PERCENTAGE,
		"commerce.price.modifier.type.order:Integer=20"
	},
	service = CommercePriceModifierType.class
)
public class CommercePriceModifierPercentageTypeImpl
	implements CommercePriceModifierType {

	@Override
	public CommerceMoney evaluate(
			CommerceMoney originalCommerceMoney,
			CommercePriceModifier commercePriceModifier,
			CommerceCurrency commerceCurrency)
		throws PortalException {

		BigDecimal modifierAmount = commercePriceModifier.getModifierAmount();

		if (modifierAmount.compareTo(_ONE_HUNDRED) > 0) {
			return originalCommerceMoney;
		}

		BigDecimal percentage = BigDecimal.ONE.add(
			modifierAmount.divide(_ONE_HUNDRED));

		BigDecimal originalPrice = originalCommerceMoney.getPrice();

		BigDecimal modifiedPrice = originalPrice.multiply(percentage);

		return _commerceMoneyFactory.create(commerceCurrency, modifiedPrice);
	}

	@Override
	public String getKey() {
		return CommercePriceModifierConstants.PERCENTAGE;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "percentage");
	}

	@Override
	public Type getType() {
		return Type.PERCENTAGE;
	}

	private static final BigDecimal _ONE_HUNDRED = BigDecimal.valueOf(100);

	@Reference
	private CommerceMoneyFactory _commerceMoneyFactory;

}