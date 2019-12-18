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

package com.liferay.commerce.price.list.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CommercePriceListRel. This utility wraps
 * <code>com.liferay.commerce.price.list.service.impl.CommercePriceListRelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRelService
 * @generated
 */
public class CommercePriceListRelServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListRelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceListRelServiceUtil} to access the commerce price list rel remote service. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListRelServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			addCommercePriceListRel(
				long commercePriceListId, String className, long classPK,
				int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommercePriceListRel(
			commercePriceListId, className, classPK, order, serviceContext);
	}

	public static void deleteCommercePriceListRel(long commercePriceListRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCommercePriceListRel(commercePriceListRelId);
	}

	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			fetchCommercePriceListRel(
				long commercePriceListId, String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchCommercePriceListRel(
			commercePriceListId, className, classPK);
	}

	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListRel>
				getCommercePriceListRels(long commercePriceListId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceListRels(commercePriceListId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CommercePriceListRelService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceListRelService, CommercePriceListRelService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceListRelService.class);

		ServiceTracker<CommercePriceListRelService, CommercePriceListRelService>
			serviceTracker =
				new ServiceTracker
					<CommercePriceListRelService, CommercePriceListRelService>(
						bundle.getBundleContext(),
						CommercePriceListRelService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}