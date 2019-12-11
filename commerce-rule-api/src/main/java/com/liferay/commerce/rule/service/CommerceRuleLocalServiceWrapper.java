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

package com.liferay.commerce.rule.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceRuleLocalService}.
 *
 * @author Riccardo Alberti
 * @see CommerceRuleLocalService
 * @generated
 */
public class CommerceRuleLocalServiceWrapper
	implements CommerceRuleLocalService,
			   ServiceWrapper<CommerceRuleLocalService> {

	public CommerceRuleLocalServiceWrapper(
		CommerceRuleLocalService commerceRuleLocalService) {

		_commerceRuleLocalService = commerceRuleLocalService;
	}

	/**
	 * Adds the commerce rule to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was added
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule addCommerceRule(
		com.liferay.commerce.rule.model.CommerceRule commerceRule) {

		return _commerceRuleLocalService.addCommerceRule(commerceRule);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>CommerceRuleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceRuleLocalServiceUtil</code>.
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule addCommerceRule(
			String description, String title, String type, String typeSettings,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleLocalService.addCommerceRule(
			description, title, type, typeSettings, serviceContext);
	}

	/**
	 * Creates a new commerce rule with the primary key. Does not add the commerce rule to the database.
	 *
	 * @param commerceRuleId the primary key for the new commerce rule
	 * @return the new commerce rule
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule createCommerceRule(
		long commerceRuleId) {

		return _commerceRuleLocalService.createCommerceRule(commerceRuleId);
	}

	/**
	 * Deletes the commerce rule from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was removed
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule deleteCommerceRule(
		com.liferay.commerce.rule.model.CommerceRule commerceRule) {

		return _commerceRuleLocalService.deleteCommerceRule(commerceRule);
	}

	/**
	 * Deletes the commerce rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule that was removed
	 * @throws PortalException if a commerce rule with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule deleteCommerceRule(
			long commerceRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleLocalService.deleteCommerceRule(commerceRuleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commerceRuleLocalService.dynamicQuery();
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

		return _commerceRuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.rule.model.impl.CommerceRuleModelImpl</code>.
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

		return _commerceRuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.rule.model.impl.CommerceRuleModelImpl</code>.
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

		return _commerceRuleLocalService.dynamicQuery(
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

		return _commerceRuleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _commerceRuleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.rule.model.CommerceRule fetchCommerceRule(
		long commerceRuleId) {

		return _commerceRuleLocalService.fetchCommerceRule(commerceRuleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commerceRuleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce rule with the primary key.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule
	 * @throws PortalException if a commerce rule with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule getCommerceRule(
			long commerceRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleLocalService.getCommerceRule(commerceRuleId);
	}

	/**
	 * Returns a range of all the commerce rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.rule.model.impl.CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @return the range of commerce rules
	 */
	@Override
	public java.util.List<com.liferay.commerce.rule.model.CommerceRule>
		getCommerceRules(int start, int end) {

		return _commerceRuleLocalService.getCommerceRules(start, end);
	}

	/**
	 * Returns the number of commerce rules.
	 *
	 * @return the number of commerce rules
	 */
	@Override
	public int getCommerceRulesCount() {
		return _commerceRuleLocalService.getCommerceRulesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commerceRuleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commerceRuleLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceRuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the commerce rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was updated
	 */
	@Override
	public com.liferay.commerce.rule.model.CommerceRule updateCommerceRule(
		com.liferay.commerce.rule.model.CommerceRule commerceRule) {

		return _commerceRuleLocalService.updateCommerceRule(commerceRule);
	}

	@Override
	public CommerceRuleLocalService getWrappedService() {
		return _commerceRuleLocalService;
	}

	@Override
	public void setWrappedService(
		CommerceRuleLocalService commerceRuleLocalService) {

		_commerceRuleLocalService = commerceRuleLocalService;
	}

	private CommerceRuleLocalService _commerceRuleLocalService;

}