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

import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.commerce.price.modifier.service.persistence.CommercePriceModifierPersistence;
import com.liferay.commerce.price.modifier.service.persistence.CommercePriceModifierRelPersistence;
import com.liferay.expando.kernel.service.persistence.ExpandoRowPersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce price modifier local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierLocalServiceImpl}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierLocalServiceImpl
 * @generated
 */
public abstract class CommercePriceModifierLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommercePriceModifierLocalService, IdentifiableOSGiService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommercePriceModifierLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce price modifier to the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 * @return the commerce price modifier that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifier addCommercePriceModifier(
		CommercePriceModifier commercePriceModifier) {

		commercePriceModifier.setNew(true);

		return commercePriceModifierPersistence.update(commercePriceModifier);
	}

	/**
	 * Creates a new commerce price modifier with the primary key. Does not add the commerce price modifier to the database.
	 *
	 * @param commercePriceModifierId the primary key for the new commerce price modifier
	 * @return the new commerce price modifier
	 */
	@Override
	@Transactional(enabled = false)
	public CommercePriceModifier createCommercePriceModifier(
		long commercePriceModifierId) {

		return commercePriceModifierPersistence.create(commercePriceModifierId);
	}

	/**
	 * Deletes the commerce price modifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier that was removed
	 * @throws PortalException if a commerce price modifier with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePriceModifier deleteCommercePriceModifier(
			long commercePriceModifierId)
		throws PortalException {

		return commercePriceModifierPersistence.remove(commercePriceModifierId);
	}

	/**
	 * Deletes the commerce price modifier from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 * @return the commerce price modifier that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePriceModifier deleteCommercePriceModifier(
			CommercePriceModifier commercePriceModifier)
		throws PortalException {

		return commercePriceModifierPersistence.remove(commercePriceModifier);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommercePriceModifier.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commercePriceModifierPersistence.findWithDynamicQuery(
			dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commercePriceModifierPersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commercePriceModifierPersistence.findWithDynamicQuery(
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
		return commercePriceModifierPersistence.countWithDynamicQuery(
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

		return commercePriceModifierPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommercePriceModifier fetchCommercePriceModifier(
		long commercePriceModifierId) {

		return commercePriceModifierPersistence.fetchByPrimaryKey(
			commercePriceModifierId);
	}

	/**
	 * Returns the commerce price modifier matching the UUID and group.
	 *
	 * @param uuid the commerce price modifier's UUID
	 * @param groupId the primary key of the group
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchCommercePriceModifierByUuidAndGroupId(
		String uuid, long groupId) {

		return commercePriceModifierPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the commerce price modifier with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the commerce price modifier's external reference code
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchCommercePriceModifierByReferenceCode(
		long companyId, String externalReferenceCode) {

		return commercePriceModifierPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the commerce price modifier with the primary key.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier
	 * @throws PortalException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier getCommercePriceModifier(
			long commercePriceModifierId)
		throws PortalException {

		return commercePriceModifierPersistence.findByPrimaryKey(
			commercePriceModifierId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commercePriceModifierLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommercePriceModifier.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePriceModifierId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commercePriceModifierLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommercePriceModifier.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePriceModifierId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commercePriceModifierLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CommercePriceModifier.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commercePriceModifierId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					if (modifiedDateCriterion != null) {
						Conjunction conjunction =
							RestrictionsFactoryUtil.conjunction();

						conjunction.add(modifiedDateCriterion);

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(
							RestrictionsFactoryUtil.gtProperty(
								"modifiedDate", "lastPublishDate"));

						Property lastPublishDateProperty =
							PropertyFactoryUtil.forName("lastPublishDate");

						disjunction.add(lastPublishDateProperty.isNull());

						conjunction.add(disjunction);

						modifiedDateCriterion = conjunction;
					}

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									CommercePriceModifier.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(
			portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<CommercePriceModifier>() {

				@Override
				public void performAction(
						CommercePriceModifier commercePriceModifier)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, commercePriceModifier);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					CommercePriceModifier.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commercePriceModifierLocalService.deleteCommercePriceModifier(
			(CommercePriceModifier)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commercePriceModifierPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the commerce price modifiers matching the UUID and company.
	 *
	 * @param uuid the UUID of the commerce price modifiers
	 * @param companyId the primary key of the company
	 * @return the matching commerce price modifiers, or an empty list if no matches were found
	 */
	@Override
	public List<CommercePriceModifier>
		getCommercePriceModifiersByUuidAndCompanyId(
			String uuid, long companyId) {

		return commercePriceModifierPersistence.findByUuid_C(uuid, companyId);
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
	public List<CommercePriceModifier>
		getCommercePriceModifiersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<CommercePriceModifier> orderByComparator) {

		return commercePriceModifierPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public CommercePriceModifier getCommercePriceModifierByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return commercePriceModifierPersistence.findByUUID_G(uuid, groupId);
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
	public List<CommercePriceModifier> getCommercePriceModifiers(
		int start, int end) {

		return commercePriceModifierPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce price modifiers.
	 *
	 * @return the number of commerce price modifiers
	 */
	@Override
	public int getCommercePriceModifiersCount() {
		return commercePriceModifierPersistence.countAll();
	}

	/**
	 * Updates the commerce price modifier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 * @return the commerce price modifier that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifier updateCommercePriceModifier(
		CommercePriceModifier commercePriceModifier) {

		return commercePriceModifierPersistence.update(commercePriceModifier);
	}

	/**
	 * Returns the commerce price modifier local service.
	 *
	 * @return the commerce price modifier local service
	 */
	public CommercePriceModifierLocalService
		getCommercePriceModifierLocalService() {

		return commercePriceModifierLocalService;
	}

	/**
	 * Sets the commerce price modifier local service.
	 *
	 * @param commercePriceModifierLocalService the commerce price modifier local service
	 */
	public void setCommercePriceModifierLocalService(
		CommercePriceModifierLocalService commercePriceModifierLocalService) {

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
	public com.liferay.commerce.price.modifier.service.
		CommercePriceModifierRelLocalService
			getCommercePriceModifierRelLocalService() {

		return commercePriceModifierRelLocalService;
	}

	/**
	 * Sets the commerce price modifier rel local service.
	 *
	 * @param commercePriceModifierRelLocalService the commerce price modifier rel local service
	 */
	public void setCommercePriceModifierRelLocalService(
		com.liferay.commerce.price.modifier.service.
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
			"com.liferay.commerce.price.modifier.model.CommercePriceModifier",
			commercePriceModifierLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.price.modifier.model.CommercePriceModifier");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommercePriceModifierLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommercePriceModifier.class;
	}

	protected String getModelClassName() {
		return CommercePriceModifier.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commercePriceModifierPersistence.getDataSource();

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

	@BeanReference(type = CommercePriceModifierLocalService.class)
	protected CommercePriceModifierLocalService
		commercePriceModifierLocalService;

	@BeanReference(type = CommercePriceModifierPersistence.class)
	protected CommercePriceModifierPersistence commercePriceModifierPersistence;

	@BeanReference(
		type = com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalService.class
	)
	protected com.liferay.commerce.price.modifier.service.
		CommercePriceModifierRelLocalService
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