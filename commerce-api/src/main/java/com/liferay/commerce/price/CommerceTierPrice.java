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

package com.liferay.commerce.price;

import com.liferay.commerce.currency.model.CommerceMoney;

/**
 * @author Riccardo Alberti
 */
public class CommerceTierPrice {
	
	public CommerceTierPrice(int minQuantity, CommerceMoney unitPrice, CommerceMoney unitPromoPrice) {
		
		_minQuantity = minQuantity;
		_unitPrice = unitPrice;
		_unitPromoPrice = unitPromoPrice;
	}
	
	public int getMinQuantity() {
		return _minQuantity;
	}
		
	public CommerceMoney getUnitPrice() {
		return _unitPrice;
	}
	
	public CommerceMoney getUnitPromoPrice() {
		return _unitPromoPrice;
	}

	public void setUnitPrice(CommerceMoney unitPrice) {
		this._unitPrice = unitPrice;
	}

	public void setUnitPromoPrice(CommerceMoney unitPromoPrice) {
		this._unitPromoPrice = unitPromoPrice;
	}

	private final int _minQuantity;
	private CommerceMoney _unitPrice;
	private CommerceMoney _unitPromoPrice;
}
