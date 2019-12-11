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

package com.liferay.commerce.rule.service.impl;

import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.service.base.CommerceRuleServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the commerce rule remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.rule.service.CommerceRuleService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommerceRuleServiceBaseImpl
 */
public class CommerceRuleServiceImpl extends CommerceRuleServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.commerce.rule.service.CommerceRuleServiceUtil</code> to access the commerce rule remote service.
	 */
	public CommerceRule addCommerceRule(
			String description, String title, String type, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException {

		/*_commerceDiscountResourcePermission.check(
			getPermissionChecker(), commerceDiscountId, ActionKeys.UPDATE);*/

		return commerceRuleLocalService.addCommerceRule(
			description, title, type, typeSettings, serviceContext);
	}

	@Override
	public CommerceRule getCommerceRule(long commerceRuleId)
		throws PortalException {

		CommerceRule commerceRule = commerceRuleLocalService.getCommerceRule(
			commerceRuleId);

		/*_commerceDiscountResourcePermission.check(
			getPermissionChecker(),
			commerceDiscountRule.getCommerceDiscountId(), ActionKeys.UPDATE);*/

		return commerceRule;
	}

}