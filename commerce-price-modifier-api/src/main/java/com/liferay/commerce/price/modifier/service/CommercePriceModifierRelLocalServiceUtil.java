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
 * Provides the local service utility for CommercePriceModifierRel. This utility wraps
 * <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRelLocalService
 * @generated
 */
public class CommercePriceModifierRelLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the commerce price modifier rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 * @return the commerce price modifier rel that was added
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			addCommercePriceModifierRel(
				com.liferay.commerce.price.modifier.model.
					CommercePriceModifierRel commercePriceModifierRel) {

		return getService().addCommercePriceModifierRel(
			commercePriceModifierRel);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>CommercePriceModifierRelLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>CommercePriceModifierRelLocalServiceUtil</code>.
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

	/**
	 * Creates a new commerce price modifier rel with the primary key. Does not add the commerce price modifier rel to the database.
	 *
	 * @param commercePriceModifierRelId the primary key for the new commerce price modifier rel
	 * @return the new commerce price modifier rel
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			createCommercePriceModifierRel(long commercePriceModifierRelId) {

		return getService().createCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	/**
	 * Deletes the commerce price modifier rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 * @return the commerce price modifier rel that was removed
	 * @throws PortalException
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				deleteCommercePriceModifierRel(
					com.liferay.commerce.price.modifier.model.
						CommercePriceModifierRel commercePriceModifierRel)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceModifierRel(
			commercePriceModifierRel);
	}

	/**
	 * Deletes the commerce price modifier rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel that was removed
	 * @throws PortalException if a commerce price modifier rel with the primary key could not be found
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				deleteCommercePriceModifierRel(long commercePriceModifierRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	public static void deleteCommercePriceModifierRels(
			long commercePriceModifierId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCommercePriceModifierRels(commercePriceModifierId);
	}

	public static void deleteCommercePriceModifierRels(
			String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCommercePriceModifierRels(className, classPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			fetchCommercePriceModifierRel(long commercePriceModifierRelId) {

		return getService().fetchCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			fetchCommercePriceModifierRel(String className, long classPK) {

		return getService().fetchCommercePriceModifierRel(className, classPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static long[] getClassPKs(
		long commercePriceModifierId, String className) {

		return getService().getClassPKs(commercePriceModifierId, className);
	}

	/**
	 * Returns the commerce price modifier rel with the primary key.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel
	 * @throws PortalException if a commerce price modifier rel with the primary key could not be found
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				getCommercePriceModifierRel(long commercePriceModifierRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	/**
	 * Returns a range of all the commerce price modifier rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @return the range of commerce price modifier rels
	 */
	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
			getCommercePriceModifierRels(int start, int end) {

		return getService().getCommercePriceModifierRels(start, end);
	}

	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
			getCommercePriceModifierRels(
				long commercePriceModifierId, String className) {

		return getService().getCommercePriceModifierRels(
			commercePriceModifierId, className);
	}

	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
			getCommercePriceModifierRels(
				long commercePriceModifierId, String className, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.commerce.price.modifier.model.
						CommercePriceModifierRel> orderByComparator) {

		return getService().getCommercePriceModifierRels(
			commercePriceModifierId, className, start, end, orderByComparator);
	}

	/**
	 * Returns the number of commerce price modifier rels.
	 *
	 * @return the number of commerce price modifier rels
	 */
	public static int getCommercePriceModifierRelsCount() {
		return getService().getCommercePriceModifierRelsCount();
	}

	public static int getCommercePriceModifierRelsCount(
		long commercePriceModifierId, String className) {

		return getService().getCommercePriceModifierRelsCount(
			commercePriceModifierId, className);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the commerce price modifier rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 * @return the commerce price modifier rel that was updated
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			updateCommercePriceModifierRel(
				com.liferay.commerce.price.modifier.model.
					CommercePriceModifierRel commercePriceModifierRel) {

		return getService().updateCommercePriceModifierRel(
			commercePriceModifierRel);
	}

	public static CommercePriceModifierRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceModifierRelLocalService,
		 CommercePriceModifierRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceModifierRelLocalService.class);

		ServiceTracker
			<CommercePriceModifierRelLocalService,
			 CommercePriceModifierRelLocalService> serviceTracker =
				new ServiceTracker
					<CommercePriceModifierRelLocalService,
					 CommercePriceModifierRelLocalService>(
						 bundle.getBundleContext(),
						 CommercePriceModifierRelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}