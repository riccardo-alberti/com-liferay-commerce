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

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.price.list.model.CommercePriceEntry;
import com.liferay.portal.kernel.exception.PortalException;

import java.math.BigDecimal;

/**
 * @author Riccardo Alberti
 */
public interface CommercePriceModifierCalculation {

	public CommercePriceModifierValue
			getOrderShippingCommercePriceModifierValue(
				CommerceOrder commerceOrder, BigDecimal shippingAmount,
				CommerceContext commerceContext)
		throws PortalException;

	public CommercePriceModifierValue
			getOrderSubtotalCommercePriceModifierValue(
				CommerceOrder commerceOrder, BigDecimal subtotalAmount,
				CommerceContext commerceContext)
		throws PortalException;

	public CommercePriceModifierValue getOrderTotalCommercePriceModifierValue(
			CommerceOrder commerceOrder, BigDecimal totalAmount,
			CommerceContext commerceContext)
		throws PortalException;

	public CommercePriceModifierValue getPriceListPriceModifierValue(
			CommercePriceEntry commercePriceEntry, int quantity,
			CommerceContext commerceContext)
		throws PortalException;

	public CommercePriceModifierValue getProductPriceModifierValue(
			CommercePriceEntry commercePriceEntry, int quantity,
			CommerceContext commerceContext)
		throws PortalException;

}