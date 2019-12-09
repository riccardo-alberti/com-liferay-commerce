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

package com.liferay.commerce.rule.type.standard.internal.display.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.commerce.product.item.selector.criterion.CPDefinitionItemSelectorCriterion;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.service.CommerceRuleService;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Riccardo Alberti
 */
public class AddedAllCommerceRuleDisplayContext {

	public AddedAllCommerceRuleDisplayContext(
		CommerceRuleService commerceRuleService,
		CPDefinitionService cpDefinitionService,
		HttpServletRequest httpServletRequest, ItemSelector itemSelector) {

		_commerceRuleService = commerceRuleService;
		_cpDefinitionService = cpDefinitionService;
		_httpServletRequest = httpServletRequest;
		_itemSelector = itemSelector;
	}

	public CommerceRule getCommerceRule()
		throws PortalException {

		if (_commerceRule != null) {
			return _commerceRule;
		}

		long commerceRuleId = ParamUtil.getLong(
			_httpServletRequest, "commerceRuleId");

		if (commerceRuleId > 0) {
			_commerceRule =
				_commerceRuleService.getCommerceRule(
					commerceRuleId);
		}

		return _commerceRule;
	}

	public List<CPDefinition> getCPDefinitions() throws PortalException {
		List<CPDefinition> cpDefinitions = new ArrayList<>();

		String[] cpDefinitionIds = StringUtil.split(getTypeSettings());

		for (String cpDefinitionId : cpDefinitionIds) {
			CPDefinition cpDefinition = _cpDefinitionService.fetchCPDefinition(
				GetterUtil.getLong(cpDefinitionId));

			if (cpDefinition != null) {
				cpDefinitions.add(cpDefinition);
			}
		}

		return cpDefinitions;
	}

	public String getItemSelectorUrl() throws PortalException {
		RequestBackedPortletURLFactory requestBackedPortletURLFactory =
			RequestBackedPortletURLFactoryUtil.create(_httpServletRequest);

		CPDefinitionItemSelectorCriterion cpDefinitionItemSelectorCriterion =
			new CPDefinitionItemSelectorCriterion();

		cpDefinitionItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			Collections.<ItemSelectorReturnType>singletonList(
				new UUIDItemSelectorReturnType()));

		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
			requestBackedPortletURLFactory, "productDefinitionsSelectItem",
			cpDefinitionItemSelectorCriterion);

		String checkedCPDefinitionIds = StringUtil.merge(
			getCheckedCPDefinitionIds());

		itemSelectorURL.setParameter(
			"checkedCPDefinitionIds", checkedCPDefinitionIds);
		itemSelectorURL.setParameter(
			"disabledCPDefinitionIds", checkedCPDefinitionIds);

		return itemSelectorURL.toString();
	}

	public String getTypeSettings() throws PortalException {
		CommerceRule commerceRule = getCommerceRule();

		if (commerceRule == null) {
			return StringPool.BLANK;
		}

		String type = BeanParamUtil.getString(
				commerceRule, _httpServletRequest, "type");

		return commerceRule.getSettingsProperty(type);
	}

	protected long[] getCheckedCPDefinitionIds() throws PortalException {
		return ListUtil.toLongArray(
			getCPDefinitions(), CPDefinition.CP_DEFINITION_ID_ACCESSOR);
	}

	private CommerceRule _commerceRule;
	private final CommerceRuleService _commerceRuleService;
	private final CPDefinitionService _cpDefinitionService;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;

}