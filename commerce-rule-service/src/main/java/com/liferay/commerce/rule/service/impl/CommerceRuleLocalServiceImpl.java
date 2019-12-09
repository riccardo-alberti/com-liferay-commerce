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

import com.liferay.commerce.rule.exception.CommerceRuleTypeException;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.service.base.CommerceRuleLocalServiceBaseImpl;
import com.liferay.commerce.rule.type.CommerceRuleType;
import com.liferay.commerce.rule.type.CommerceRuleTypeRegistry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.spring.extender.service.ServiceReference;

/**
 * The implementation of the commerce rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.rule.service.CommerceRuleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommerceRuleLocalServiceBaseImpl
 */
public class CommerceRuleLocalServiceImpl
	extends CommerceRuleLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.commerce.rule.service.CommerceRuleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.rule.service.CommerceRuleLocalServiceUtil</code>.
	 */
	
	public CommerceRule addCommerceRule(
			String type, String typeSettings, String description,
			ServiceContext serviceContext)
		throws PortalException {

		// Commerce rule

		User user = userLocalService.getUser(serviceContext.getUserId());

		validate(type);

		long commerceRuleId = counterLocalService.increment();

		CommerceRule commerceRule =
			commerceRulePersistence.create(commerceRuleId);

		commerceRule.setCompanyId(user.getCompanyId());
		commerceRule.setUserId(user.getUserId());
		commerceRule.setUserName(user.getFullName());
		commerceRule.setType(type);

		UnicodeProperties settingsProperties =
				commerceRule.getSettingsProperties();

		settingsProperties.put(type, typeSettings);

		commerceRule.setSettingsProperties(settingsProperties);
		
		commerceRule.setDescription(description);

		commerceRulePersistence.update(commerceRule);

		// Commerce rule

		return commerceRule;
	}
	
	protected void validate(String type) throws PortalException {
		CommerceRuleType commerceRuleType =
			_commerceRuleTypeRegistry.getCommerceRuleType(type);

		if (commerceRuleType == null) {
			throw new CommerceRuleTypeException();
		}
	}

	@ServiceReference(type = CommerceRuleTypeRegistry.class)
	private CommerceRuleTypeRegistry _commerceRuleTypeRegistry;
}