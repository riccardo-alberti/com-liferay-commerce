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
 * Provides the local service utility for CommercePriceListRel. This utility wraps
 * <code>com.liferay.commerce.price.list.service.impl.CommercePriceListRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRelLocalService
 * @generated
 */
public class CommercePriceListRelLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the commerce price list rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 * @return the commerce price list rel that was added
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
		addCommercePriceListRel(
			com.liferay.commerce.price.list.model.CommercePriceListRel
				commercePriceListRel) {

		return getService().addCommercePriceListRel(commercePriceListRel);
	}

	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			addCommercePriceListRel(
				long commercePriceListId, String className, long classPK,
				int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommercePriceListRel(
			commercePriceListId, className, classPK, order, serviceContext);
	}

	/**
	 * Creates a new commerce price list rel with the primary key. Does not add the commerce price list rel to the database.
	 *
	 * @param commercePriceListRelId the primary key for the new commerce price list rel
	 * @return the new commerce price list rel
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
		createCommercePriceListRel(long commercePriceListRelId) {

		return getService().createCommercePriceListRel(commercePriceListRelId);
	}

	/**
	 * Deletes the commerce price list rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws PortalException
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			deleteCommercePriceListRel(
				com.liferay.commerce.price.list.model.CommercePriceListRel
					commercePriceListRel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceListRel(commercePriceListRel);
	}

	/**
	 * Deletes the commerce price list rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws PortalException if a commerce price list rel with the primary key could not be found
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			deleteCommercePriceListRel(long commercePriceListRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceListRel(commercePriceListRelId);
	}

	public static void deleteCommercePriceListRels(long commercePriceListId) {
		getService().deleteCommercePriceListRels(commercePriceListId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListRelModelImpl</code>.
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

	public static com.liferay.commerce.price.list.model.CommercePriceListRel
		fetchCommercePriceListRel(long commercePriceListRelId) {

		return getService().fetchCommercePriceListRel(commercePriceListRelId);
	}

	public static com.liferay.commerce.price.list.model.CommercePriceListRel
		fetchCommercePriceListRel(
			long commercePriceListId, String className, long classPK) {

		return getService().fetchCommercePriceListRel(
			commercePriceListId, className, classPK);
	}

	/**
	 * Returns the commerce price list rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
		fetchCommercePriceListRelByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().fetchCommercePriceListRelByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce price list rel with the primary key.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel
	 * @throws PortalException if a commerce price list rel with the primary key could not be found
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			getCommercePriceListRel(long commercePriceListRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceListRel(commercePriceListRelId);
	}

	/**
	 * Returns the commerce price list rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list rel
	 * @throws PortalException if a matching commerce price list rel could not be found
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
			getCommercePriceListRelByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceListRelByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the commerce price list rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @return the range of commerce price list rels
	 */
	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListRel>
			getCommercePriceListRels(int start, int end) {

		return getService().getCommercePriceListRels(start, end);
	}

	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListRel>
			getCommercePriceListRels(long commercePriceListId) {

		return getService().getCommercePriceListRels(commercePriceListId);
	}

	/**
	 * Returns the number of commerce price list rels.
	 *
	 * @return the number of commerce price list rels
	 */
	public static int getCommercePriceListRelsCount() {
		return getService().getCommercePriceListRelsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the commerce price list rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 * @return the commerce price list rel that was updated
	 */
	public static com.liferay.commerce.price.list.model.CommercePriceListRel
		updateCommercePriceListRel(
			com.liferay.commerce.price.list.model.CommercePriceListRel
				commercePriceListRel) {

		return getService().updateCommercePriceListRel(commercePriceListRel);
	}

	public static CommercePriceListRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceListRelLocalService, CommercePriceListRelLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceListRelLocalService.class);

		ServiceTracker
			<CommercePriceListRelLocalService, CommercePriceListRelLocalService>
				serviceTracker =
					new ServiceTracker
						<CommercePriceListRelLocalService,
						 CommercePriceListRelLocalService>(
							 bundle.getBundleContext(),
							 CommercePriceListRelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}