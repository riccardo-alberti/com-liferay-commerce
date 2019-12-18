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
 * Provides a wrapper for {@link CommercePriceListContractRelLocalService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListContractRelLocalService
 * @generated
 */
public class CommercePriceListContractRelLocalServiceWrapper
	implements CommercePriceListContractRelLocalService,
			   ServiceWrapper<CommercePriceListContractRelLocalService> {

	public CommercePriceListContractRelLocalServiceWrapper(
		CommercePriceListContractRelLocalService
			commercePriceListContractRelLocalService) {

		_commercePriceListContractRelLocalService =
			commercePriceListContractRelLocalService;
	}

	/**
	 * Adds the commerce price list contract rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListContractRel the commerce price list contract rel
	 * @return the commerce price list contract rel that was added
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
		addCommercePriceListContractRel(
			com.liferay.commerce.price.list.model.CommercePriceListContractRel
				commercePriceListContractRel) {

		return _commercePriceListContractRelLocalService.
			addCommercePriceListContractRel(commercePriceListContractRel);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			addCommercePriceListContractRel(
				long commercePriceListId, long commerceContractId, int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.
			addCommercePriceListContractRel(
				commercePriceListId, commerceContractId, order, serviceContext);
	}

	/**
	 * Creates a new commerce price list contract rel with the primary key. Does not add the commerce price list contract rel to the database.
	 *
	 * @param commercePriceListContractRelId the primary key for the new commerce price list contract rel
	 * @return the new commerce price list contract rel
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
		createCommercePriceListContractRel(
			long commercePriceListContractRelId) {

		return _commercePriceListContractRelLocalService.
			createCommercePriceListContractRel(commercePriceListContractRelId);
	}

	/**
	 * Deletes the commerce price list contract rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListContractRel the commerce price list contract rel
	 * @return the commerce price list contract rel that was removed
	 * @throws PortalException
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			deleteCommercePriceListContractRel(
				com.liferay.commerce.price.list.model.
					CommercePriceListContractRel commercePriceListContractRel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.
			deleteCommercePriceListContractRel(commercePriceListContractRel);
	}

	/**
	 * Deletes the commerce price list contract rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListContractRelId the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel that was removed
	 * @throws PortalException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			deleteCommercePriceListContractRel(
				long commercePriceListContractRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.
			deleteCommercePriceListContractRel(commercePriceListContractRelId);
	}

	@Override
	public void deleteCommercePriceListContractRels(long commercePriceListId) {
		_commercePriceListContractRelLocalService.
			deleteCommercePriceListContractRels(commercePriceListId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commercePriceListContractRelLocalService.dynamicQuery();
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

		return _commercePriceListContractRelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListContractRelModelImpl</code>.
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

		return _commercePriceListContractRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListContractRelModelImpl</code>.
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

		return _commercePriceListContractRelLocalService.dynamicQuery(
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

		return _commercePriceListContractRelLocalService.dynamicQueryCount(
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

		return _commercePriceListContractRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
		fetchCommercePriceListContractRel(long commercePriceListContractRelId) {

		return _commercePriceListContractRelLocalService.
			fetchCommercePriceListContractRel(commercePriceListContractRelId);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
		fetchCommercePriceListContractRel(
			long commercePriceListId, long commerceContractId) {

		return _commercePriceListContractRelLocalService.
			fetchCommercePriceListContractRel(
				commercePriceListId, commerceContractId);
	}

	/**
	 * Returns the commerce price list contract rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list contract rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
		fetchCommercePriceListContractRelByUuidAndCompanyId(
			String uuid, long companyId) {

		return _commercePriceListContractRelLocalService.
			fetchCommercePriceListContractRelByUuidAndCompanyId(
				uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commercePriceListContractRelLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce price list contract rel with the primary key.
	 *
	 * @param commercePriceListContractRelId the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel
	 * @throws PortalException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			getCommercePriceListContractRel(long commercePriceListContractRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.
			getCommercePriceListContractRel(commercePriceListContractRelId);
	}

	/**
	 * Returns the commerce price list contract rel with the matching UUID and company.
	 *
	 * @param uuid the commerce price list contract rel's UUID
	 * @param companyId the primary key of the company
	 * @return the matching commerce price list contract rel
	 * @throws PortalException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			getCommercePriceListContractRelByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.
			getCommercePriceListContractRelByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the commerce price list contract rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.list.model.impl.CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @return the range of commerce price list contract rels
	 */
	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListContractRel>
			getCommercePriceListContractRels(int start, int end) {

		return _commercePriceListContractRelLocalService.
			getCommercePriceListContractRels(start, end);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListContractRel>
			getCommercePriceListContractRels(long commercePriceListId) {

		return _commercePriceListContractRelLocalService.
			getCommercePriceListContractRels(commercePriceListId);
	}

	/**
	 * Returns the number of commerce price list contract rels.
	 *
	 * @return the number of commerce price list contract rels
	 */
	@Override
	public int getCommercePriceListContractRelsCount() {
		return _commercePriceListContractRelLocalService.
			getCommercePriceListContractRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _commercePriceListContractRelLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commercePriceListContractRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceListContractRelLocalService.
			getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the commerce price list contract rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListContractRel the commerce price list contract rel
	 * @return the commerce price list contract rel that was updated
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
		updateCommercePriceListContractRel(
			com.liferay.commerce.price.list.model.CommercePriceListContractRel
				commercePriceListContractRel) {

		return _commercePriceListContractRelLocalService.
			updateCommercePriceListContractRel(commercePriceListContractRel);
	}

	@Override
	public CommercePriceListContractRelLocalService getWrappedService() {
		return _commercePriceListContractRelLocalService;
	}

	@Override
	public void setWrappedService(
		CommercePriceListContractRelLocalService
			commercePriceListContractRelLocalService) {

		_commercePriceListContractRelLocalService =
			commercePriceListContractRelLocalService;
	}

	private CommercePriceListContractRelLocalService
		_commercePriceListContractRelLocalService;

}