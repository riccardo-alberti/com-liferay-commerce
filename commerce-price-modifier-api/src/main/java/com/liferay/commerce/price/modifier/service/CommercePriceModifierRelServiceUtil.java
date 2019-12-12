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

package com.liferay.commerce.price.modifier.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CommercePriceModifierRel. This utility wraps
 * <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierRelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRelService
 * @generated
 */
public class CommercePriceModifierRelServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierRelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierRelServiceUtil</code> to access the commerce price modifier rel remote service.
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				addCommercePriceModifierRel(
					long commercePriceModifierId, String className,
					long classPK,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommercePriceModifierRel(
			commercePriceModifierId, className, classPK, serviceContext);
	}

	public static void deleteCommercePriceModifierRel(
			long commercePriceModifierRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCommercePriceModifierRel(commercePriceModifierRelId);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				fetchCommercePriceModifierRel(String className, long classPK)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchCommercePriceModifierRel(className, classPK);
	}

	public static long[] getClassPKs(
			long commercePriceModifierRelId, String className)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClassPKs(commercePriceModifierRelId, className);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				getCommercePriceModifierRel(long commercePriceModifierRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
				getCommercePriceModifierRels(
					long commercePriceModifierRelId, String className)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifierRels(
			commercePriceModifierRelId, className);
	}

	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
				getCommercePriceModifierRels(
					long commercePriceModifierRelId, String className,
					int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.commerce.price.modifier.model.
							CommercePriceModifierRel> orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifierRels(
			commercePriceModifierRelId, className, start, end,
			orderByComparator);
	}

	public static int getCommercePriceModifierRelsCount(
			long commercePriceModifierRelId, String className)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifierRelsCount(
			commercePriceModifierRelId, className);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CommercePriceModifierRelService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceModifierRelService, CommercePriceModifierRelService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceModifierRelService.class);

		ServiceTracker
			<CommercePriceModifierRelService, CommercePriceModifierRelService>
				serviceTracker =
					new ServiceTracker
						<CommercePriceModifierRelService,
						 CommercePriceModifierRelService>(
							 bundle.getBundleContext(),
							 CommercePriceModifierRelService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}