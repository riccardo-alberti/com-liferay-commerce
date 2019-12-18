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
 * Provides the local service utility for CommercePriceListChannelRel. This utility wraps
 * <code>com.liferay.commerce.price.list.service.impl.CommercePriceListChannelRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListChannelRelLocalService
 * @generated
 */
public class CommercePriceListChannelRelLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListChannelRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the commerce price list channel rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListChannelRel the commerce price list channel rel
	 * @return the commerce price list channel rel that was added
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			addCommercePriceListChannelRel(
				com.liferay.commerce.price.list.model.
					CommercePriceListChannelRel commercePriceListChannelRel) {

		return getService().addCommercePriceListChannelRel(
			commercePriceListChannelRel);
	}

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

	/**
	 * Creates a new commerce price list channel rel with the primary key. Does not add the commerce price list channel rel to the database.
	 *
	 * @param commercePriceListChannelRelId the primary key for the new commerce price list channel rel
	 * @return the new commerce price list channel rel
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			createCommercePriceListChannelRel(
				long commercePriceListChannelRelId) {

		return getService().createCommercePriceListChannelRel(
			commercePriceListChannelRelId);
	}

	/**
	 * Deletes the commerce price list channel rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListChannelRel the commerce price list channel rel
	 * @return the commerce price list channel rel that was removed
	 * @throws PortalException
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				deleteCommercePriceListChannelRel(
					com.liferay.commerce.price.list.model.
						CommercePriceListChannelRel commercePriceListChannelRel)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceListChannelRel(
			commercePriceListChannelRel);
	}

	/**
	 * Deletes the commerce price list channel rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListChannelRelId the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel that was removed
	 * @throws PortalException if a commerce price list channel rel with the primary key could not be found
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				deleteCommercePriceListChannelRel(
					long commercePriceListChannelRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommercePriceListChannelRel(
			commercePriceListChannelRelId);
	}

	public static void deleteCommercePriceListChannelRels(
		long commercePriceListId) {

		getService().deleteCommercePriceListChannelRels(commercePriceListId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListChannelRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListChannelRelModelImpl</code>.
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
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			fetchCommercePriceListChannelRel(
				long commercePriceListChannelRelId) {

		return getService().fetchCommercePriceListChannelRel(
			commercePriceListChannelRelId);
	}

	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			fetchCommercePriceListChannelRel(
				long commercePriceListId, long commerceChannelId) {

		return getService().fetchCommercePriceListChannelRel(
			commercePriceListId, commerceChannelId);
	}

	/**
	 * Returns the commerce price list channel rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list channel rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			fetchCommercePriceListChannelRelByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().fetchCommercePriceListChannelRelByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce price list channel rel with the primary key.
	 *
	 * @param commercePriceListChannelRelId the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel
	 * @throws PortalException if a commerce price list channel rel with the primary key could not be found
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				getCommercePriceListChannelRel(
					long commercePriceListChannelRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceListChannelRel(
			commercePriceListChannelRelId);
	}

	/**
	 * Returns the commerce price list channel rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list channel rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list channel rel
	 * @throws PortalException if a matching commerce price list channel rel could not be found
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				getCommercePriceListChannelRelByUuidAndCompanyId(
					String uuid, long companyId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommercePriceListChannelRelByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the commerce price list channel rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @return the range of commerce price list channel rels
	 */
	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListChannelRel>
			getCommercePriceListChannelRels(int start, int end) {

		return getService().getCommercePriceListChannelRels(start, end);
	}

	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListChannelRel>
			getCommercePriceListChannelRels(long commercePriceListId) {

		return getService().getCommercePriceListChannelRels(
			commercePriceListId);
	}

	/**
	 * Returns the number of commerce price list channel rels.
	 *
	 * @return the number of commerce price list channel rels
	 */
	public static int getCommercePriceListChannelRelsCount() {
		return getService().getCommercePriceListChannelRelsCount();
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
	 * Updates the commerce price list channel rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListChannelRel the commerce price list channel rel
	 * @return the commerce price list channel rel that was updated
	 */
	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			updateCommercePriceListChannelRel(
				com.liferay.commerce.price.list.model.
					CommercePriceListChannelRel commercePriceListChannelRel) {

		return getService().updateCommercePriceListChannelRel(
			commercePriceListChannelRel);
	}

	public static CommercePriceListChannelRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceListChannelRelLocalService,
		 CommercePriceListChannelRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceListChannelRelLocalService.class);

		ServiceTracker
			<CommercePriceListChannelRelLocalService,
			 CommercePriceListChannelRelLocalService> serviceTracker =
				new ServiceTracker
					<CommercePriceListChannelRelLocalService,
					 CommercePriceListChannelRelLocalService>(
						 bundle.getBundleContext(),
						 CommercePriceListChannelRelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}