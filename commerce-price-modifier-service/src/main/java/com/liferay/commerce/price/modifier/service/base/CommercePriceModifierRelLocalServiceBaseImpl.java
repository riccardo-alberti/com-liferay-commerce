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

package com.liferay.commerce.price.modifier.service.base;

import com.liferay.commerce.price.modifier.model.CommercePriceModifierRel;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalService;
import com.liferay.commerce.price.modifier.service.persistence.CommercePriceModifierPersistence;
import com.liferay.commerce.price.modifier.service.persistence.CommercePriceModifierRelPersistence;
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
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce price modifier rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierRelLocalServiceImpl}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierRelLocalServiceImpl
 * @generated
 */
public abstract class CommercePriceModifierRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommercePriceModifierRelLocalService, IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommercePriceModifierRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce price modifier rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 * @return the commerce price modifier rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifierRel addCommercePriceModifierRel(
		CommercePriceModifierRel commercePriceModifierRel) {

		commercePriceModifierRel.setNew(true);

		return commercePriceModifierRelPersistence.update(
			commercePriceModifierRel);
	}

	/**
	 * Creates a new commerce price modifier rel with the primary key. Does not add the commerce price modifier rel to the database.
	 *
	 * @param commercePriceModifierRelId the primary key for the new commerce price modifier rel
	 * @return the new commerce price modifier rel
	 */
	@Override
	@Transactional(enabled = false)
	public CommercePriceModifierRel createCommercePriceModifierRel(
		long commercePriceModifierRelId) {

		return commercePriceModifierRelPersistence.create(
			commercePriceModifierRelId);
	}

	/**
	 * Deletes the commerce price modifier rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel that was removed
	 * @throws PortalException if a commerce price modifier rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePriceModifierRel deleteCommercePriceModifierRel(
			long commercePriceModifierRelId)
		throws PortalException {

		return commercePriceModifierRelPersistence.remove(
			commercePriceModifierRelId);
	}

	/**
	 * Deletes the commerce price modifier rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 * @return the commerce price modifier rel that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePriceModifierRel deleteCommercePriceModifierRel(
			CommercePriceModifierRel commercePriceModifierRel)
		throws PortalException {

		return commercePriceModifierRelPersistence.remove(
			commercePriceModifierRel);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommercePriceModifierRel.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commercePriceModifierRelPersistence.findWithDynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commercePriceModifierRelPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commercePriceModifierRelPersistence.findWithDynamicQuery(
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
		return commercePriceModifierRelPersistence.countWithDynamicQuery(
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
		DynamicQuery dynamicQuery, Projection projection) {

		return commercePriceModifierRelPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommercePriceModifierRel fetchCommercePriceModifierRel(
		long commercePriceModifierRelId) {

		return commercePriceModifierRelPersistence.fetchByPrimaryKey(
			commercePriceModifierRelId);
	}

	/**
	 * Returns the commerce price modifier rel with the primary key.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel
	 * @throws PortalException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel getCommercePriceModifierRel(
			long commercePriceModifierRelId)
		throws PortalException {

		return commercePriceModifierRelPersistence.findByPrimaryKey(
			commercePriceModifierRelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commercePriceModifierRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommercePriceModifierRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePriceModifierRelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commercePriceModifierRelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommercePriceModifierRel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePriceModifierRelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commercePriceModifierRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommercePriceModifierRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePriceModifierRelId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commercePriceModifierRelLocalService.
			deleteCommercePriceModifierRel(
				(CommercePriceModifierRel)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commercePriceModifierRelPersistence.findByPrimaryKey(
			primaryKeyObj);
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
	@Override
	public List<CommercePriceModifierRel> getCommercePriceModifierRels(
		int start, int end) {

		return commercePriceModifierRelPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce price modifier rels.
	 *
	 * @return the number of commerce price modifier rels
	 */
	@Override
	public int getCommercePriceModifierRelsCount() {
		return commercePriceModifierRelPersistence.countAll();
	}

	/**
	 * Updates the commerce price modifier rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 * @return the commerce price modifier rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifierRel updateCommercePriceModifierRel(
		CommercePriceModifierRel commercePriceModifierRel) {

		return commercePriceModifierRelPersistence.update(
			commercePriceModifierRel);
	}

	/**
	 * Returns the commerce price modifier local service.
	 *
	 * @return the commerce price modifier local service
	 */
	public com.liferay.commerce.price.modifier.service.
		CommercePriceModifierLocalService
			getCommercePriceModifierLocalService() {

		return commercePriceModifierLocalService;
	}

	/**
	 * Sets the commerce price modifier local service.
	 *
	 * @param commercePriceModifierLocalService the commerce price modifier local service
	 */
	public void setCommercePriceModifierLocalService(
		com.liferay.commerce.price.modifier.service.
			CommercePriceModifierLocalService
				commercePriceModifierLocalService) {

		this.commercePriceModifierLocalService =
			commercePriceModifierLocalService;
	}

	/**
	 * Returns the commerce price modifier persistence.
	 *
	 * @return the commerce price modifier persistence
	 */
	public CommercePriceModifierPersistence
		getCommercePriceModifierPersistence() {

		return commercePriceModifierPersistence;
	}

	/**
	 * Sets the commerce price modifier persistence.
	 *
	 * @param commercePriceModifierPersistence the commerce price modifier persistence
	 */
	public void setCommercePriceModifierPersistence(
		CommercePriceModifierPersistence commercePriceModifierPersistence) {

		this.commercePriceModifierPersistence =
			commercePriceModifierPersistence;
	}

	/**
	 * Returns the commerce price modifier rel local service.
	 *
	 * @return the commerce price modifier rel local service
	 */
	public CommercePriceModifierRelLocalService
		getCommercePriceModifierRelLocalService() {

		return commercePriceModifierRelLocalService;
	}

	/**
	 * Sets the commerce price modifier rel local service.
	 *
	 * @param commercePriceModifierRelLocalService the commerce price modifier rel local service
	 */
	public void setCommercePriceModifierRelLocalService(
		CommercePriceModifierRelLocalService
			commercePriceModifierRelLocalService) {

		this.commercePriceModifierRelLocalService =
			commercePriceModifierRelLocalService;
	}

	/**
	 * Returns the commerce price modifier rel persistence.
	 *
	 * @return the commerce price modifier rel persistence
	 */
	public CommercePriceModifierRelPersistence
		getCommercePriceModifierRelPersistence() {

		return commercePriceModifierRelPersistence;
	}

	/**
	 * Sets the commerce price modifier rel persistence.
	 *
	 * @param commercePriceModifierRelPersistence the commerce price modifier rel persistence
	 */
	public void setCommercePriceModifierRelPersistence(
		CommercePriceModifierRelPersistence
			commercePriceModifierRelPersistence) {

		this.commercePriceModifierRelPersistence =
			commercePriceModifierRelPersistence;
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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.commerce.price.modifier.model.CommercePriceModifierRel",
			commercePriceModifierRelLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.price.modifier.model.CommercePriceModifierRel");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommercePriceModifierRelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommercePriceModifierRel.class;
	}

	protected String getModelClassName() {
		return CommercePriceModifierRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commercePriceModifierRelPersistence.getDataSource();

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

	@BeanReference(
		type = com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService.class
	)
	protected com.liferay.commerce.price.modifier.service.
		CommercePriceModifierLocalService commercePriceModifierLocalService;

	@BeanReference(type = CommercePriceModifierPersistence.class)
	protected CommercePriceModifierPersistence commercePriceModifierPersistence;

	@BeanReference(type = CommercePriceModifierRelLocalService.class)
	protected CommercePriceModifierRelLocalService
		commercePriceModifierRelLocalService;

	@BeanReference(type = CommercePriceModifierRelPersistence.class)
	protected CommercePriceModifierRelPersistence
		commercePriceModifierRelPersistence;

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

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}