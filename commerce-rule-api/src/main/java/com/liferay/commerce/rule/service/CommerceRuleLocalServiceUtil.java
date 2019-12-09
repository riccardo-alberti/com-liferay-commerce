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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CommerceRule. This utility wraps
 * <code>com.liferay.commerce.rule.service.impl.CommerceRuleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Riccardo Alberti
 * @see CommerceRuleLocalService
 * @generated
 */
public class CommerceRuleLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.rule.service.impl.CommerceRuleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the commerce rule to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was added
	 */
	public static com.liferay.commerce.rule.model.CommerceRule addCommerceRule(
		com.liferay.commerce.rule.model.CommerceRule commerceRule) {

		return getService().addCommerceRule(commerceRule);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>CommerceRuleLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>CommerceRuleLocalServiceUtil</code>.
	 */
	public static com.liferay.commerce.rule.model.CommerceRule addCommerceRule(
			String type, String typeSettings, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCommerceRule(
			type, typeSettings, description, serviceContext);
	}

	/**
	 * Creates a new commerce rule with the primary key. Does not add the commerce rule to the database.
	 *
	 * @param commerceRuleId the primary key for the new commerce rule
	 * @return the new commerce rule
	 */
	public static com.liferay.commerce.rule.model.CommerceRule
		createCommerceRule(long commerceRuleId) {

		return getService().createCommerceRule(commerceRuleId);
	}

	/**
	 * Deletes the commerce rule from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was removed
	 */
	public static com.liferay.commerce.rule.model.CommerceRule
		deleteCommerceRule(
			com.liferay.commerce.rule.model.CommerceRule commerceRule) {

		return getService().deleteCommerceRule(commerceRule);
	}

	/**
	 * Deletes the commerce rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule that was removed
	 * @throws PortalException if a commerce rule with the primary key could not be found
	 */
	public static com.liferay.commerce.rule.model.CommerceRule
			deleteCommerceRule(long commerceRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCommerceRule(commerceRuleId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.rule.model.impl.CommerceRuleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.rule.model.impl.CommerceRuleModelImpl</code>.
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

	public static com.liferay.commerce.rule.model.CommerceRule
		fetchCommerceRule(long commerceRuleId) {

		return getService().fetchCommerceRule(commerceRuleId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the commerce rule with the primary key.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule
	 * @throws PortalException if a commerce rule with the primary key could not be found
	 */
	public static com.liferay.commerce.rule.model.CommerceRule getCommerceRule(
			long commerceRuleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCommerceRule(commerceRuleId);
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
	public static java.util.List<com.liferay.commerce.rule.model.CommerceRule>
		getCommerceRules(int start, int end) {

		return getService().getCommerceRules(start, end);
	}

	/**
	 * Returns the number of commerce rules.
	 *
	 * @return the number of commerce rules
	 */
	public static int getCommerceRulesCount() {
		return getService().getCommerceRulesCount();
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
	 * Updates the commerce rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was updated
	 */
	public static com.liferay.commerce.rule.model.CommerceRule
		updateCommerceRule(
			com.liferay.commerce.rule.model.CommerceRule commerceRule) {

		return getService().updateCommerceRule(commerceRule);
	}

	public static CommerceRuleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommerceRuleLocalService, CommerceRuleLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CommerceRuleLocalService.class);

		ServiceTracker<CommerceRuleLocalService, CommerceRuleLocalService>
			serviceTracker =
				new ServiceTracker
					<CommerceRuleLocalService, CommerceRuleLocalService>(
						bundle.getBundleContext(),
						CommerceRuleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}