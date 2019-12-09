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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CommerceRule. This utility wraps
 * <code>com.liferay.commerce.rule.service.impl.CommerceRuleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Riccardo Alberti
 * @see CommerceRuleService
 * @generated
 */
public class CommerceRuleServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.rule.service.impl.CommerceRuleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommerceRuleServiceUtil</code> to access the commerce rule remote service.
	 */
	public static com.liferay.commerce.rule.model.CommerceRule addCommerceRule(
			String type, String typeSettings, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommerceRule(
			type, typeSettings, description, serviceContext);
	}

	public static com.liferay.commerce.rule.model.CommerceRule getCommerceRule(
			long commerceRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommerceRule(commerceRuleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CommerceRuleService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CommerceRuleService, CommerceRuleService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CommerceRuleService.class);

		ServiceTracker<CommerceRuleService, CommerceRuleService>
			serviceTracker =
				new ServiceTracker<CommerceRuleService, CommerceRuleService>(
					bundle.getBundleContext(), CommerceRuleService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}