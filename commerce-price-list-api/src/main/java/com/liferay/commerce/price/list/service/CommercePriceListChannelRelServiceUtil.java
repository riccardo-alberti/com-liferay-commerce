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
 * Provides the remote service utility for CommercePriceListChannelRel. This utility wraps
 * <code>com.liferay.commerce.price.list.service.impl.CommercePriceListChannelRelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListChannelRelService
 * @generated
 */
public class CommercePriceListChannelRelServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListChannelRelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceListChannelRelServiceUtil} to access the commerce price list channel rel remote service. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListChannelRelServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				addCommercePriceListChannelRel(
					long commercePriceListId, long commerceChannelId, int order,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommercePriceListChannelRel(
			commercePriceListId, commerceChannelId, order, serviceContext);
	}

	public static void deleteCommercePriceListChannelRel(
			long commercePriceListChannelRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCommercePriceListChannelRel(
			commercePriceListChannelRelId);
	}

	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				fetchCommercePriceListChannelRel(
					long commercePriceListId, long commerceChannelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchCommercePriceListChannelRel(
			commercePriceListId, commerceChannelId);
	}

	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListChannelRel>
				getCommercePriceListChannelRels(long commercePriceListId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceListChannelRels(
			commercePriceListId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CommercePriceListChannelRelService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceListChannelRelService, CommercePriceListChannelRelService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceListChannelRelService.class);

		ServiceTracker
			<CommercePriceListChannelRelService,
			 CommercePriceListChannelRelService> serviceTracker =
				new ServiceTracker
					<CommercePriceListChannelRelService,
					 CommercePriceListChannelRelService>(
						 bundle.getBundleContext(),
						 CommercePriceListChannelRelService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}