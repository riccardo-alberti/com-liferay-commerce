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

package com.liferay.commerce.price.modifier.type;

import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

/**
 * @author Riccardo Alberti
 */
public interface CommercePriceModifierType {

	public CommerceMoney evaluate(
			CommerceMoney commerceMoney,
			CommercePriceModifier commercePriceModifier,
			CommerceCurrency commerceCurrency)
		throws PortalException;

	public String getKey();

	public String getLabel(Locale locale);

	public Type getType();

	public enum Type {

		ABSOLUTE("ABSOLUTE"), FORMULA("FORMULA"), PERCENTAGE("PERCENTAGE"), OVERRIDE("OVERRIDE");

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return getValue();
		}

		private Type(final String value) {
			_value = value;
		}

		private final String _value;

	}

}