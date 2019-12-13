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

package com.liferay.commerce.price.modifier;

import com.liferay.commerce.currency.model.CommerceMoney;

import java.math.BigDecimal;

/**
 * @author Riccardo Alberti
 */
public class CommercePriceModifierValue {

	public CommercePriceModifierValue(
		long id, CommerceMoney originalPrice, CommerceMoney modifiedPrice,
		BigDecimal modifiedPercentage) {

		_id = id;
		_originalPrice = originalPrice;
		_modifiedPrice = modifiedPrice;
		_modifiedPercentage = modifiedPercentage;
	}

	public long getId() {
		return _id;
	}

	public BigDecimal getModifiedPercentage() {
		return _modifiedPercentage;
	}

	public CommerceMoney getModifiedPrice() {
		return _modifiedPrice;
	}

	public CommerceMoney getOriginalPrice() {
		return _originalPrice;
	}

	private final long _id;
	private final BigDecimal _modifiedPercentage;
	private final CommerceMoney _modifiedPrice;
	private final CommerceMoney _originalPrice;

}