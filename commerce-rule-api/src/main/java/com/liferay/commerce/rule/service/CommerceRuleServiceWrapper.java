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

package com.liferay.commerce.rule.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceRuleService}.
 *
 * @author Riccardo Alberti
 * @see CommerceRuleService
 * @generated
 */
public class CommerceRuleServiceWrapper
	implements CommerceRuleService, ServiceWrapper<CommerceRuleService> {

	public CommerceRuleServiceWrapper(CommerceRuleService commerceRuleService) {
		_commerceRuleService = commerceRuleService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommerceRuleServiceUtil</code> to access the commerce rule remote service.
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule addCommerceRule(
			String type, String typeSettings, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleService.addCommerceRule(
			type, typeSettings, description, serviceContext);
	}

	@Override
	public com.liferay.commerce.rule.model.CommerceRule getCommerceRule(
			long commerceRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleService.getCommerceRule(commerceRuleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commerceRuleService.getOSGiServiceIdentifier();
	}

	@Override
	public CommerceRuleService getWrappedService() {
		return _commerceRuleService;
	}

	@Override
	public void setWrappedService(CommerceRuleService commerceRuleService) {
		_commerceRuleService = commerceRuleService;
	}

	private CommerceRuleService _commerceRuleService;

}