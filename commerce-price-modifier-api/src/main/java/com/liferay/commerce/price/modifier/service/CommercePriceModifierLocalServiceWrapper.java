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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommercePriceModifierLocalService}.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierLocalService
 * @generated
 */
public class CommercePriceModifierLocalServiceWrapper
	implements CommercePriceModifierLocalService,
			   ServiceWrapper<CommercePriceModifierLocalService> {

	public CommercePriceModifierLocalServiceWrapper(
		CommercePriceModifierLocalService commercePriceModifierLocalService) {

		_commercePriceModifierLocalService = commercePriceModifierLocalService;
	}

	/**
	 * Adds the commerce price modifier to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 * @return the commerce price modifier that was added
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		addCommercePriceModifier(
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				commercePriceModifier) {

		return _commercePriceModifierLocalService.addCommercePriceModifier(
			commercePriceModifier);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>CommercePriceModifierLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommercePriceModifierLocalServiceUtil</code>.
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			addCommercePriceModifier(
				long userId, long groupId, String description, String title,
				String target, String modifierType,
				java.math.BigDecimal modifierAmount, double priority,
				boolean active, int displayDateMonth, int displayDateDay,
				int displayDateYear, int displayDateHour, int displayDateMinute,
				int expirationDateMonth, int expirationDateDay,
				int expirationDateYear, int expirationDateHour,
				int expirationDateMinute, boolean neverExpire,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.addCommercePriceModifier(
			userId, groupId, description, title, target, modifierType,
			modifierAmount, priority, active, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
	}

	/**
	 * Creates a new commerce price modifier with the primary key. Does not add the commerce price modifier to the database.
	 *
	 * @param commercePriceModifierId the primary key for the new commerce price modifier
	 * @return the new commerce price modifier
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		createCommercePriceModifier(long commercePriceModifierId) {

		return _commercePriceModifierLocalService.createCommercePriceModifier(
			commercePriceModifierId);
	}

	/**
	 * Deletes the commerce price modifier from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 * @return the commerce price modifier that was removed
	 * @throws PortalException
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			deleteCommercePriceModifier(
				com.liferay.commerce.price.modifier.model.CommercePriceModifier
					commercePriceModifier)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.deleteCommercePriceModifier(
			commercePriceModifier);
	}

	/**
	 * Deletes the commerce price modifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier that was removed
	 * @throws PortalException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			deleteCommercePriceModifier(long commercePriceModifierId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.deleteCommercePriceModifier(
			commercePriceModifierId);
	}

	@Override
	public void deleteCommercePriceModifiers(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_commercePriceModifierLocalService.deleteCommercePriceModifiers(
			companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commercePriceModifierLocalService.dynamicQuery();
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

		return _commercePriceModifierLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierModelImpl</code>.
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

		return _commercePriceModifierLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierModelImpl</code>.
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

		return _commercePriceModifierLocalService.dynamicQuery(
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

		return _commercePriceModifierLocalService.dynamicQueryCount(
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

		return _commercePriceModifierLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		fetchByExternalReferenceCode(
			long companyId, String externalReferenceCode) {

		return _commercePriceModifierLocalService.fetchByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		fetchCommercePriceModifier(long commercePriceModifierId) {

		return _commercePriceModifierLocalService.fetchCommercePriceModifier(
			commercePriceModifierId);
	}

	/**
	 * Returns the commerce price modifier with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the commerce price modifier's external reference code
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		fetchCommercePriceModifierByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _commercePriceModifierLocalService.
			fetchCommercePriceModifierByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the commerce price modifier matching the UUID and group.
	 *
	 * @param uuid the commerce price modifier's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		fetchCommercePriceModifierByUuidAndGroupId(String uuid, long groupId) {

		return _commercePriceModifierLocalService.
			fetchCommercePriceModifierByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commercePriceModifierLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce price modifier with the primary key.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier
	 * @throws PortalException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			getCommercePriceModifier(long commercePriceModifierId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.getCommercePriceModifier(
			commercePriceModifierId);
	}

	/**
	 * Returns the commerce price modifier matching the UUID and group.
	 *
	 * @param uuid the commerce price modifier's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commerce price modifier
	 * @throws PortalException if a matching commerce price modifier could not be found
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			getCommercePriceModifierByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.
			getCommercePriceModifierByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the commerce price modifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of commerce price modifiers
	 */
	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
			getCommercePriceModifiers(int start, int end) {

		return _commercePriceModifierLocalService.getCommercePriceModifiers(
			start, end);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
			getCommercePriceModifiers(long companyId, String target) {

		return _commercePriceModifierLocalService.getCommercePriceModifiers(
			companyId, target);
	}

	/**
	 * Returns all the commerce price modifiers matching the UUID and company.
	 *
	 * @param uuid the UUID of the commerce price modifiers
	 * @param companyId the primary key of the company
	 * @return the matching commerce price modifiers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
			getCommercePriceModifiersByUuidAndCompanyId(
				String uuid, long companyId) {

		return _commercePriceModifierLocalService.
			getCommercePriceModifiersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of commerce price modifiers matching the UUID and company.
	 *
	 * @param uuid the UUID of the commerce price modifiers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching commerce price modifiers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
			getCommercePriceModifiersByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.commerce.price.modifier.model.
						CommercePriceModifier> orderByComparator) {

		return _commercePriceModifierLocalService.
			getCommercePriceModifiersByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of commerce price modifiers.
	 *
	 * @return the number of commerce price modifiers
	 */
	@Override
	public int getCommercePriceModifiersCount() {
		return _commercePriceModifierLocalService.
			getCommercePriceModifiersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _commercePriceModifierLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commercePriceModifierLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceModifierLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				searchCommercePriceModifiers(
					long companyId, long[] groupIds, String keywords,
					int status, int start, int end,
					com.liferay.portal.kernel.search.Sort sort)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.searchCommercePriceModifiers(
			companyId, groupIds, keywords, status, start, end, sort);
	}

	@Override
	public com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				searchCommercePriceModifiers(
					com.liferay.portal.kernel.search.SearchContext
						searchContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.searchCommercePriceModifiers(
			searchContext);
	}

	/**
	 * Updates the commerce price modifier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 * @return the commerce price modifier that was updated
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
		updateCommercePriceModifier(
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				commercePriceModifier) {

		return _commercePriceModifierLocalService.updateCommercePriceModifier(
			commercePriceModifier);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			updateCommercePriceModifier(
				long commercePriceModifierId, long groupId, String description,
				String title, String target, String modifierType,
				java.math.BigDecimal modifierAmount, double priority,
				boolean active, int displayDateMonth, int displayDateDay,
				int displayDateYear, int displayDateHour, int displayDateMinute,
				int expirationDateMonth, int expirationDateDay,
				int expirationDateYear, int expirationDateHour,
				int expirationDateMinute, boolean neverExpire,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.updateCommercePriceModifier(
			commercePriceModifierId, groupId, description, title, target,
			modifierType, modifierAmount, priority, active, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			updateStatus(
				long userId, long commercePriceModifierId, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.updateStatus(
			userId, commercePriceModifierId, status, serviceContext,
			workflowContext);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			upsertCommercePriceModifier(
				long userId, long commercePriceModifierId, long groupId,
				String description, String title, String target,
				String modifierType, java.math.BigDecimal modifierAmount,
				double priority, boolean active, int displayDateMonth,
				int displayDateDay, int displayDateYear, int displayDateHour,
				int displayDateMinute, int expirationDateMonth,
				int expirationDateDay, int expirationDateYear,
				int expirationDateHour, int expirationDateMinute,
				String externalReferenceCode, boolean neverExpire,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierLocalService.upsertCommercePriceModifier(
			userId, commercePriceModifierId, groupId, description, title,
			target, modifierType, modifierAmount, priority, active,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			externalReferenceCode, neverExpire, serviceContext);
	}

	@Override
	public CommercePriceModifierLocalService getWrappedService() {
		return _commercePriceModifierLocalService;
	}

	@Override
	public void setWrappedService(
		CommercePriceModifierLocalService commercePriceModifierLocalService) {

		_commercePriceModifierLocalService = commercePriceModifierLocalService;
	}

	private CommercePriceModifierLocalService
		_commercePriceModifierLocalService;

}