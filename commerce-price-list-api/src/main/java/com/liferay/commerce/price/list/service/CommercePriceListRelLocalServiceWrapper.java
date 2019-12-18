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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommercePriceListRelLocalService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRelLocalService
 * @generated
 */
public class CommercePriceListRelLocalServiceWrapper
	implements CommercePriceListRelLocalService,
			   ServiceWrapper<CommercePriceListRelLocalService> {

	public CommercePriceListRelLocalServiceWrapper(
		CommercePriceListRelLocalService commercePriceListRelLocalService) {

		_commercePriceListRelLocalService = commercePriceListRelLocalService;
	}

	/**
	 * Adds the commerce price list rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 * @return the commerce price list rel that was added
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
		addCommercePriceListRel(
			com.liferay.commerce.price.list.model.CommercePriceListRel
				commercePriceListRel) {

		return _commercePriceListRelLocalService.addCommercePriceListRel(
			commercePriceListRel);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			addCommercePriceListRel(
				long commercePriceListId, String className, long classPK,
				int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.addCommercePriceListRel(
			commercePriceListId, className, classPK, order, serviceContext);
	}

	/**
	 * Creates a new commerce price list rel with the primary key. Does not add the commerce price list rel to the database.
	 *
	 * @param commercePriceListRelId the primary key for the new commerce price list rel
	 * @return the new commerce price list rel
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
		createCommercePriceListRel(long commercePriceListRelId) {

		return _commercePriceListRelLocalService.createCommercePriceListRel(
			commercePriceListRelId);
	}

	/**
	 * Deletes the commerce price list rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws PortalException
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			deleteCommercePriceListRel(
				com.liferay.commerce.price.list.model.CommercePriceListRel
					commercePriceListRel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.deleteCommercePriceListRel(
			commercePriceListRel);
	}

	/**
	 * Deletes the commerce price list rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws PortalException if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			deleteCommercePriceListRel(long commercePriceListRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.deleteCommercePriceListRel(
			commercePriceListRelId);
	}

	@Override
	public void deleteCommercePriceListRels(long commercePriceListId) {
		_commercePriceListRelLocalService.deleteCommercePriceListRels(
			commercePriceListId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commercePriceListRelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _commercePriceListRelLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _commercePriceListRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _commercePriceListRelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _commercePriceListRelLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _commercePriceListRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
		fetchCommercePriceListRel(long commercePriceListRelId) {

		return _commercePriceListRelLocalService.fetchCommercePriceListRel(
			commercePriceListRelId);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
		fetchCommercePriceListRel(
			long commercePriceListId, String className, long classPK) {

		return _commercePriceListRelLocalService.fetchCommercePriceListRel(
			commercePriceListId, className, classPK);
	}

	/**
	 * Returns the commerce price list rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
		fetchCommercePriceListRelByUuidAndCompanyId(
			String uuid, long companyId) {

		return _commercePriceListRelLocalService.
			fetchCommercePriceListRelByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commercePriceListRelLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce price list rel with the primary key.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel
	 * @throws PortalException if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			getCommercePriceListRel(long commercePriceListRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.getCommercePriceListRel(
			commercePriceListRelId);
	}

	/**
	 * Returns the commerce price list rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list rel
	 * @throws PortalException if a matching commerce price list rel could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			getCommercePriceListRelByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.
			getCommercePriceListRelByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListRel>
			getCommercePriceListRels(int start, int end) {

		return _commercePriceListRelLocalService.getCommercePriceListRels(
			start, end);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListRel>
			getCommercePriceListRels(long commercePriceListId) {

		return _commercePriceListRelLocalService.getCommercePriceListRels(
			commercePriceListId);
	}

	/**
	 * Returns the number of commerce price list rels.
	 *
	 * @return the number of commerce price list rels
	 */
	@Override
	public int getCommercePriceListRelsCount() {
		return _commercePriceListRelLocalService.
			getCommercePriceListRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _commercePriceListRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commercePriceListRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceListRelLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the commerce price list rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 * @return the commerce price list rel that was updated
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
		updateCommercePriceListRel(
			com.liferay.commerce.price.list.model.CommercePriceListRel
				commercePriceListRel) {

		return _commercePriceListRelLocalService.updateCommercePriceListRel(
			commercePriceListRel);
	}

	@Override
	public CommercePriceListRelLocalService getWrappedService() {
		return _commercePriceListRelLocalService;
	}

	@Override
	public void setWrappedService(
		CommercePriceListRelLocalService commercePriceListRelLocalService) {

		_commercePriceListRelLocalService = commercePriceListRelLocalService;
	}

	private CommercePriceListRelLocalService _commercePriceListRelLocalService;

}