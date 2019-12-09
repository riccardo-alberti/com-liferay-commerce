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

package com.liferay.commerce.rule.service.base;

import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.service.CommerceRuleLocalService;
import com.liferay.commerce.rule.service.persistence.CommerceRulePersistence;
import com.liferay.expando.kernel.service.persistence.ExpandoRowPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.service.persistence.WorkflowInstanceLinkPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce rule local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.rule.service.impl.CommerceRuleLocalServiceImpl}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see com.liferay.commerce.rule.service.impl.CommerceRuleLocalServiceImpl
 * @generated
 */
public abstract class CommerceRuleLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommerceRuleLocalService, IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceRuleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.rule.service.CommerceRuleLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce rule to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceRule addCommerceRule(CommerceRule commerceRule) {
		commerceRule.setNew(true);

		return commerceRulePersistence.update(commerceRule);
	}

	/**
	 * Creates a new commerce rule with the primary key. Does not add the commerce rule to the database.
	 *
	 * @param commerceRuleId the primary key for the new commerce rule
	 * @return the new commerce rule
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceRule createCommerceRule(long commerceRuleId) {
		return commerceRulePersistence.create(commerceRuleId);
	}

	/**
	 * Deletes the commerce rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule that was removed
	 * @throws PortalException if a commerce rule with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceRule deleteCommerceRule(long commerceRuleId)
		throws PortalException {

		return commerceRulePersistence.remove(commerceRuleId);
	}

	/**
	 * Deletes the commerce rule from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceRule deleteCommerceRule(CommerceRule commerceRule) {
		return commerceRulePersistence.remove(commerceRule);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommerceRule.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceRulePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commerceRulePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commerceRulePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceRulePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return commerceRulePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommerceRule fetchCommerceRule(long commerceRuleId) {
		return commerceRulePersistence.fetchByPrimaryKey(commerceRuleId);
	}

	/**
	 * Returns the commerce rule with the primary key.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule
	 * @throws PortalException if a commerce rule with the primary key could not be found
	 */
	@Override
	public CommerceRule getCommerceRule(long commerceRuleId)
		throws PortalException {

		return commerceRulePersistence.findByPrimaryKey(commerceRuleId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(commerceRuleLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceRule.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("commerceRuleId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commerceRuleLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CommerceRule.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceRuleId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(commerceRuleLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommerceRule.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("commerceRuleId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commerceRuleLocalService.deleteCommerceRule(
			(CommerceRule)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceRulePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<CommerceRule> getCommerceRules(int start, int end) {
		return commerceRulePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce rules.
	 *
	 * @return the number of commerce rules
	 */
	@Override
	public int getCommerceRulesCount() {
		return commerceRulePersistence.countAll();
	}

	/**
	 * Updates the commerce rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRule the commerce rule
	 * @return the commerce rule that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceRule updateCommerceRule(CommerceRule commerceRule) {
		return commerceRulePersistence.update(commerceRule);
	}

	/**
	 * Returns the commerce rule local service.
	 *
	 * @return the commerce rule local service
	 */
	public CommerceRuleLocalService getCommerceRuleLocalService() {
		return commerceRuleLocalService;
	}

	/**
	 * Sets the commerce rule local service.
	 *
	 * @param commerceRuleLocalService the commerce rule local service
	 */
	public void setCommerceRuleLocalService(
		CommerceRuleLocalService commerceRuleLocalService) {

		this.commerceRuleLocalService = commerceRuleLocalService;
	}

	/**
	 * Returns the commerce rule persistence.
	 *
	 * @return the commerce rule persistence
	 */
	public CommerceRulePersistence getCommerceRulePersistence() {
		return commerceRulePersistence;
	}

	/**
	 * Sets the commerce rule persistence.
	 *
	 * @param commerceRulePersistence the commerce rule persistence
	 */
	public void setCommerceRulePersistence(
		CommerceRulePersistence commerceRulePersistence) {

		this.commerceRulePersistence = commerceRulePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the workflow instance link local service.
	 *
	 * @return the workflow instance link local service
	 */
	public com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		getWorkflowInstanceLinkLocalService() {

		return workflowInstanceLinkLocalService;
	}

	/**
	 * Sets the workflow instance link local service.
	 *
	 * @param workflowInstanceLinkLocalService the workflow instance link local service
	 */
	public void setWorkflowInstanceLinkLocalService(
		com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
			workflowInstanceLinkLocalService) {

		this.workflowInstanceLinkLocalService =
			workflowInstanceLinkLocalService;
	}

	/**
	 * Returns the workflow instance link persistence.
	 *
	 * @return the workflow instance link persistence
	 */
	public WorkflowInstanceLinkPersistence
		getWorkflowInstanceLinkPersistence() {

		return workflowInstanceLinkPersistence;
	}

	/**
	 * Sets the workflow instance link persistence.
	 *
	 * @param workflowInstanceLinkPersistence the workflow instance link persistence
	 */
	public void setWorkflowInstanceLinkPersistence(
		WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence) {

		this.workflowInstanceLinkPersistence = workflowInstanceLinkPersistence;
	}

	/**
	 * Returns the expando row local service.
	 *
	 * @return the expando row local service
	 */
	public com.liferay.expando.kernel.service.ExpandoRowLocalService
		getExpandoRowLocalService() {

		return expandoRowLocalService;
	}

	/**
	 * Sets the expando row local service.
	 *
	 * @param expandoRowLocalService the expando row local service
	 */
	public void setExpandoRowLocalService(
		com.liferay.expando.kernel.service.ExpandoRowLocalService
			expandoRowLocalService) {

		this.expandoRowLocalService = expandoRowLocalService;
	}

	/**
	 * Returns the expando row persistence.
	 *
	 * @return the expando row persistence
	 */
	public ExpandoRowPersistence getExpandoRowPersistence() {
		return expandoRowPersistence;
	}

	/**
	 * Sets the expando row persistence.
	 *
	 * @param expandoRowPersistence the expando row persistence
	 */
	public void setExpandoRowPersistence(
		ExpandoRowPersistence expandoRowPersistence) {

		this.expandoRowPersistence = expandoRowPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.commerce.rule.model.CommerceRule",
			commerceRuleLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.rule.model.CommerceRule");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceRuleLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceRule.class;
	}

	protected String getModelClassName() {
		return CommerceRule.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceRulePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CommerceRuleLocalService.class)
	protected CommerceRuleLocalService commerceRuleLocalService;

	@BeanReference(type = CommerceRulePersistence.class)
	protected CommerceRulePersistence commerceRulePersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService.class
	)
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@ServiceReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;

	@ServiceReference(
		type = com.liferay.expando.kernel.service.ExpandoRowLocalService.class
	)
	protected com.liferay.expando.kernel.service.ExpandoRowLocalService
		expandoRowLocalService;

	@ServiceReference(type = ExpandoRowPersistence.class)
	protected ExpandoRowPersistence expandoRowPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}