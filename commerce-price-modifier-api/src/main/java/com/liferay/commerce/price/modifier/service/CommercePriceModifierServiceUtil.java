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
 * Provides the remote service utility for CommercePriceModifier. This utility wraps
 * <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierService
 * @generated
 */
public class CommercePriceModifierServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierServiceUtil</code> to access the commerce price modifier remote service.
	 *
	 * @throws PortalException
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				addCommercePriceModifier(
					long userId, String description, String title,
					String target, String modifierType,
					java.math.BigDecimal modifierAmount, double priority,
					boolean active, int displayDateMonth, int displayDateDay,
					int displayDateYear, int displayDateHour,
					int displayDateMinute, int expirationDateMonth,
					int expirationDateDay, int expirationDateYear,
					int expirationDateHour, int expirationDateMinute,
					boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommercePriceModifier(
			userId, description, title, target, modifierType, modifierAmount,
			priority, active, displayDateMonth, displayDateDay, displayDateYear,
			displayDateHour, displayDateMinute, expirationDateMonth,
			expirationDateDay, expirationDateYear, expirationDateHour,
			expirationDateMinute, neverExpire, serviceContext);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				deleteCommercePriceModifier(long commercePriceModifierId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceModifier(
			commercePriceModifierId);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				fetchByExternalReferenceCode(
					long companyId, String externalReferenceCode)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				fetchCommercePriceModifier(long commercePriceModifierId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchCommercePriceModifier(commercePriceModifierId);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				getCommercePriceModifier(long commercePriceModifierId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifier(commercePriceModifierId);
	}

	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				getCommercePriceModifiers(long companyId, String target)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifiers(companyId, target);
	}

	public static int getCommercePriceModifiersCount()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifiersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				searchCommercePriceModifiers(
					long companyId, String keywords, int status, int start,
					int end, com.liferay.portal.kernel.search.Sort sort)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().searchCommercePriceModifiers(
			companyId, keywords, status, start, end, sort);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				updateCommercePriceModifier(
					long commercePriceModifierId, String description,
					String title, String target, String modifierType,
					java.math.BigDecimal modifierAmount, double priority,
					boolean active, int displayDateMonth, int displayDateDay,
					int displayDateYear, int displayDateHour,
					int displayDateMinute, int expirationDateMonth,
					int expirationDateDay, int expirationDateYear,
					int expirationDateHour, int expirationDateMinute,
					boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCommercePriceModifier(
			commercePriceModifierId, description, title, target, modifierType,
			modifierAmount, priority, active, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				upsertCommercePriceModifier(
					long userId, long commercePriceModifierId,
					String description, String title, String target,
					String modifierType, java.math.BigDecimal modifierAmount,
					double priority, boolean active, int displayDateMonth,
					int displayDateDay, int displayDateYear,
					int displayDateHour, int displayDateMinute,
					int expirationDateMonth, int expirationDateDay,
					int expirationDateYear, int expirationDateHour,
					int expirationDateMinute, String externalReferenceCode,
					boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().upsertCommercePriceModifier(
			userId, commercePriceModifierId, description, title, target,
			modifierType, modifierAmount, priority, active, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, externalReferenceCode,
			neverExpire, serviceContext);
	}

	public static CommercePriceModifierService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceModifierService, CommercePriceModifierService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceModifierService.class);

		ServiceTracker
			<CommercePriceModifierService, CommercePriceModifierService>
				serviceTracker =
					new ServiceTracker
						<CommercePriceModifierService,
						 CommercePriceModifierService>(
							 bundle.getBundleContext(),
							 CommercePriceModifierService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}