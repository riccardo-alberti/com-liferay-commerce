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

package com.liferay.commerce.rule.type.standard.internal;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.ToLongFunction;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.type.CommerceRuleType;
import com.liferay.commerce.rule.type.standard.internal.constants.CommerceRuleConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Riccardo Alberti
 */
@Component(
	immediate = true,
	property = {
		"commerce.rule.type.key=" + CommerceRuleConstants.TYPE_ADDED_ALL,
		"commerce.rule.type.order:Integer=50"
	},
	service = CommerceRuleType.class
)
public class AddedAllCommerceRuleTypeImpl
	implements CommerceRuleType {

	@Override
	public boolean evaluate(
			CommerceRule commerceRule,
			CommerceContext commerceContext)
		throws PortalException {

		CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

		if (commerceOrder == null) {
			return false;
		}

		List<CommerceOrderItem> commerceOrderItems =
			commerceOrder.getCommerceOrderItems();

		Stream<CommerceOrderItem> stream = commerceOrderItems.stream();

		LongStream longStream = stream.mapToLong(_getOrderItemToLongFunction());

		long[] orderItemDefinitionIds = longStream.toArray();

		String settingsProperty = commerceRule.getSettingsProperty(
				commerceRule.getType());

		long[] cpDefinitionIds = StringUtil.split(settingsProperty, 0L);

		return ArrayUtil.containsAll(orderItemDefinitionIds, cpDefinitionIds);
	}

	@Override
	public String getKey() {
		return CommerceRuleConstants.TYPE_ADDED_ALL;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "has-all-of-these-products");
	}

	private ToLongFunction<CommerceOrderItem> _getOrderItemToLongFunction() {
		return new ToLongFunction<CommerceOrderItem>() {

			@Override
			public long applyAsLong(CommerceOrderItem commerceOrderItem) {
				try {
					return commerceOrderItem.getCPDefinitionId();
				}
				catch (PortalException pe) {
					if (_log.isDebugEnabled()) {
						_log.debug(pe, pe);
					}

					return 0;
				}
			}

		};
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddedAllCommerceRuleTypeImpl.class);

}