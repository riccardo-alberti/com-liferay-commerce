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

package com.liferay.commerce.price.modifier.service.impl;

import com.liferay.commerce.price.modifier.exception.CommercePriceModifierAmountException;
import com.liferay.commerce.price.modifier.exception.CommercePriceModifierDisplayDateException;
import com.liferay.commerce.price.modifier.exception.CommercePriceModifierExpirationDateException;
import com.liferay.commerce.price.modifier.exception.CommercePriceModifierTargetException;
import com.liferay.commerce.price.modifier.exception.CommercePriceModifierTitleException;
import com.liferay.commerce.price.modifier.exception.CommercePriceModifierTypeException;
import com.liferay.commerce.price.modifier.exception.NoSuchPriceModifierException;
import com.liferay.commerce.price.modifier.internal.search.CommercePriceModifierIndexer;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.base.CommercePriceModifierLocalServiceBaseImpl;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTargetRegistry;
import com.liferay.commerce.price.modifier.type.CommercePriceModifierType;
import com.liferay.commerce.price.modifier.type.CommercePriceModifierTypeRegistry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the commerce price modifier local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierLocalServiceBaseImpl
 */
public class CommercePriceModifierLocalServiceImpl
	extends CommercePriceModifierLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalServiceUtil</code>.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifier addCommercePriceModifier(
			long userId, long groupId, String description, String title,
			String target, String modifierType, BigDecimal modifierAmount,
			double priority, boolean active, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, ServiceContext serviceContext)
		throws PortalException {

		// Commerce price modifier

		User user = userLocalService.getUser(serviceContext.getUserId());

		validate(
			serviceContext.getCompanyId(), 0, title, target, modifierType,
			modifierAmount);

		Date now = new Date();

		Date displayDate = PortalUtil.getDate(
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, user.getTimeZone(),
			CommercePriceModifierDisplayDateException.class);

		Date expirationDate = null;

		if (!neverExpire) {
			expirationDate = PortalUtil.getDate(
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, user.getTimeZone(),
				CommercePriceModifierExpirationDateException.class);
		}

		long commercePriceModifierId = counterLocalService.increment();

		CommercePriceModifier commercePriceModifier =
			commercePriceModifierPersistence.create(commercePriceModifierId);

		commercePriceModifier.setCompanyId(user.getCompanyId());
		commercePriceModifier.setUserId(user.getUserId());
		commercePriceModifier.setUserName(user.getFullName());
		commercePriceModifier.setGroupId(groupId);
		commercePriceModifier.setDescription(description);
		commercePriceModifier.setTarget(target);
		commercePriceModifier.setTitle(title);
		commercePriceModifier.setModifierType(modifierType);
		commercePriceModifier.setModifierAmount(modifierAmount);
		commercePriceModifier.setPriority(priority);
		commercePriceModifier.setActive(active);
		commercePriceModifier.setDisplayDate(displayDate);
		commercePriceModifier.setExpirationDate(expirationDate);

		if ((expirationDate == null) || expirationDate.after(now)) {
			commercePriceModifier.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		else {
			commercePriceModifier.setStatus(WorkflowConstants.STATUS_EXPIRED);
		}

		commercePriceModifier.setStatusByUserId(user.getUserId());
		commercePriceModifier.setStatusDate(
			serviceContext.getModifiedDate(now));
		commercePriceModifier.setExpandoBridgeAttributes(serviceContext);

		commercePriceModifierPersistence.update(commercePriceModifier);

		// Resources

		resourceLocalService.addModelResources(
			commercePriceModifier, serviceContext);

		// Workflow

		return startWorkflowInstance(
			user.getUserId(), commercePriceModifier, serviceContext);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public CommercePriceModifier deleteCommercePriceModifier(
			CommercePriceModifier commercePriceModifier)
		throws PortalException {

		// Commerce price modifier rels

		commercePriceModifierRelLocalService.deleteCommercePriceModifierRels(
			commercePriceModifier.getCommercePriceModifierId());

		// Commerce price modifier

		commercePriceModifierPersistence.remove(commercePriceModifier);

		// Resources

		resourceLocalService.deleteResource(
			commercePriceModifier.getCompanyId(),
			CommercePriceModifier.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL,
			commercePriceModifier.getCommercePriceModifierId());

		// Expando

		expandoRowLocalService.deleteRows(
			commercePriceModifier.getCommercePriceModifierId());

		// Workflow

		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			commercePriceModifier.getCompanyId(), 0L,
			CommercePriceModifier.class.getName(),
			commercePriceModifier.getCommercePriceModifierId());

		return commercePriceModifier;
	}

	@Override
	public CommercePriceModifier deleteCommercePriceModifier(
			long commercePriceModifierId)
		throws PortalException {

		CommercePriceModifier commercePriceModifier =
			commercePriceModifierPersistence.findByPrimaryKey(
				commercePriceModifierId);

		return commercePriceModifierLocalService.deleteCommercePriceModifier(
			commercePriceModifier);
	}

	@Override
	public void deleteCommercePriceModifiers(long companyId)
		throws PortalException {

		List<CommercePriceModifier> commercePriceModifiers =
			commercePriceModifierPersistence.findByCompanyId(companyId);

		for (CommercePriceModifier commercePriceModifier :
				commercePriceModifiers) {

			commercePriceModifierLocalService.deleteCommercePriceModifier(
				commercePriceModifier);
		}
	}

	@Override
	public CommercePriceModifier fetchByExternalReferenceCode(
		long companyId, String externalReferenceCode) {

		if (Validator.isBlank(externalReferenceCode)) {
			return null;
		}

		return commercePriceModifierPersistence.fetchByC_ERC(
			companyId, externalReferenceCode);
	}

	@Override
	public List<CommercePriceModifier> getCommercePriceModifiers(
		long companyId, String target) {

		return commercePriceModifierPersistence.findByC_T(companyId, target);
	}

	@Override
	public BaseModelSearchResult<CommercePriceModifier>
			searchCommercePriceModifiers(
				long companyId, long[] groupIds, String keywords, int status,
				int start, int end, Sort sort)
		throws PortalException {

		SearchContext searchContext = buildSearchContext(
			companyId, groupIds, keywords, status, start, end, sort);

		return searchCommercePriceModifiers(searchContext);
	}

	public BaseModelSearchResult<CommercePriceModifier>
			searchCommercePriceModifiers(SearchContext searchContext)
		throws PortalException {

		Indexer<CommercePriceModifier> indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(CommercePriceModifier.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext, _SELECTED_FIELD_NAMES);

			List<CommercePriceModifier> commercePriceModifiers =
				getCommercePriceModifiers(hits);

			if (commercePriceModifiers != null) {
				return new BaseModelSearchResult<>(
					commercePriceModifiers, hits.getLength());
			}
		}

		throw new SearchException(
			"Unable to fix the search index after 10 attempts");
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifier updateCommercePriceModifier(
			long commercePriceModifierId, long groupId, String description,
			String title, String target, String modifierType,
			BigDecimal modifierAmount, double priority, boolean active,
			int displayDateMonth, int displayDateDay, int displayDateYear,
			int displayDateHour, int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(serviceContext.getUserId());

		CommercePriceModifier commercePriceModifier =
			commercePriceModifierPersistence.findByPrimaryKey(
				commercePriceModifierId);

		validate(
			serviceContext.getCompanyId(), commercePriceModifierId, title,
			target, modifierType, modifierAmount);

		Date now = new Date();

		Date displayDate = PortalUtil.getDate(
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, user.getTimeZone(),
			CommercePriceModifierDisplayDateException.class);

		Date expirationDate = null;

		if (!neverExpire) {
			expirationDate = PortalUtil.getDate(
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, user.getTimeZone(),
				CommercePriceModifierExpirationDateException.class);
		}

		commercePriceModifier.setGroupId(groupId);
		commercePriceModifier.setDescription(description);
		commercePriceModifier.setTarget(target);
		commercePriceModifier.setTitle(title);
		commercePriceModifier.setModifierType(modifierType);
		commercePriceModifier.setModifierAmount(modifierAmount);
		commercePriceModifier.setPriority(priority);
		commercePriceModifier.setActive(active);
		commercePriceModifier.setDisplayDate(displayDate);
		commercePriceModifier.setExpirationDate(expirationDate);

		if ((expirationDate == null) || expirationDate.after(now)) {
			commercePriceModifier.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		else {
			commercePriceModifier.setStatus(WorkflowConstants.STATUS_EXPIRED);
		}

		commercePriceModifier.setStatusByUserId(user.getUserId());
		commercePriceModifier.setStatusDate(
			serviceContext.getModifiedDate(now));
		commercePriceModifier.setExpandoBridgeAttributes(serviceContext);

		commercePriceModifierPersistence.update(commercePriceModifier);

		return startWorkflowInstance(
			user.getUserId(), commercePriceModifier, serviceContext);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifier updateStatus(
			long userId, long commercePriceModifierId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		CommercePriceModifier commercePriceModifier =
			commercePriceModifierPersistence.findByPrimaryKey(
				commercePriceModifierId);

		if ((status == WorkflowConstants.STATUS_APPROVED) &&
			(commercePriceModifier.getDisplayDate() != null) &&
			now.before(commercePriceModifier.getDisplayDate())) {

			status = WorkflowConstants.STATUS_SCHEDULED;
		}

		if (status == WorkflowConstants.STATUS_APPROVED) {
			Date expirationDate = commercePriceModifier.getExpirationDate();

			if ((expirationDate != null) && expirationDate.before(now)) {
				commercePriceModifier.setExpirationDate(null);
			}
		}

		if (status == WorkflowConstants.STATUS_EXPIRED) {
			commercePriceModifier.setExpirationDate(now);
		}

		commercePriceModifier.setStatus(status);
		commercePriceModifier.setStatusByUserId(user.getUserId());
		commercePriceModifier.setStatusByUserName(user.getFullName());
		commercePriceModifier.setStatusDate(
			serviceContext.getModifiedDate(now));

		commercePriceModifierPersistence.update(commercePriceModifier);

		return commercePriceModifier;
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePriceModifier upsertCommercePriceModifier(
			long userId, long commercePriceModifierId, long groupId,
			String description, String title, String target,
			String modifierType, BigDecimal modifierAmount, double priority,
			boolean active, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, String externalReferenceCode,
			boolean neverExpire, ServiceContext serviceContext)
		throws PortalException {

		// Update

		if (commercePriceModifierId > 0) {
			try {
				return commercePriceModifierLocalService.
					upsertCommercePriceModifier(
						userId, commercePriceModifierId, groupId, description,
						title, target, modifierType, modifierAmount, priority,
						active, displayDateMonth, displayDateDay,
						displayDateYear, displayDateHour, displayDateMinute,
						expirationDateMonth, expirationDateDay,
						expirationDateYear, expirationDateHour,
						expirationDateMinute, externalReferenceCode,
						neverExpire, serviceContext);
			}
			catch (NoSuchPriceModifierException nspme) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Unable to find price modifier with ID: " +
							commercePriceModifierId);
				}
			}
		}

		if (!Validator.isBlank(externalReferenceCode)) {
			CommercePriceModifier commercePriceModifier =
				commercePriceModifierPersistence.fetchByC_ERC(
					serviceContext.getCompanyId(), externalReferenceCode);

			if (commercePriceModifier != null) {
				return commercePriceModifierLocalService.
					updateCommercePriceModifier(
						commercePriceModifierId, groupId, description, title,
						target, modifierType, modifierAmount, priority, active,
						displayDateMonth, displayDateDay, displayDateYear,
						displayDateHour, displayDateMinute, expirationDateMonth,
						expirationDateDay, expirationDateYear,
						expirationDateHour, expirationDateMinute, neverExpire,
						serviceContext);
			}
		}

		// Add

		return commercePriceModifierLocalService.addCommercePriceModifier(
			userId, groupId, description, title, target, modifierType,
			modifierAmount, priority, active, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
	}

	protected SearchContext buildSearchContext(
		long companyId, long[] groupIds, String keywords, int status, int start,
		int end, Sort sort) {

		SearchContext searchContext = new SearchContext();

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();

		params.put("keywords", keywords);

		Map<String, Serializable> attributes = new HashMap<>();

		attributes.put(CommercePriceModifierIndexer.FIELD_GROUP_IDS, groupIds);
		attributes.put(Field.ENTRY_CLASS_PK, keywords);
		attributes.put(Field.STATUS, status);
		attributes.put(Field.TITLE, keywords);
		attributes.put("params", params);

		searchContext.setAttributes(attributes);

		searchContext.setCompanyId(companyId);
		searchContext.setStart(start);
		searchContext.setEnd(end);

		if (Validator.isNotNull(keywords)) {
			searchContext.setKeywords(keywords);
		}

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.setHighlightEnabled(false);
		queryConfig.setScoreEnabled(false);

		if (sort != null) {
			searchContext.setSorts(sort);
		}

		return searchContext;
	}

	protected List<CommercePriceModifier> getCommercePriceModifiers(Hits hits)
		throws PortalException {

		List<Document> documents = hits.toList();

		List<CommercePriceModifier> commercePriceModifiers = new ArrayList<>(
			documents.size());

		for (Document document : documents) {
			long commercePriceModifierId = GetterUtil.getLong(
				document.get(Field.ENTRY_CLASS_PK));

			CommercePriceModifier commerceDiscount = fetchCommercePriceModifier(
				commercePriceModifierId);

			if (commerceDiscount == null) {
				commercePriceModifiers = null;

				Indexer<CommercePriceModifier> indexer =
					IndexerRegistryUtil.getIndexer(CommercePriceModifier.class);

				long companyId = GetterUtil.getLong(
					document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (commercePriceModifiers != null) {
				commercePriceModifiers.add(commerceDiscount);
			}
		}

		return commercePriceModifiers;
	}

	protected CommercePriceModifier startWorkflowInstance(
			long userId, CommercePriceModifier commercePriceModifier,
			ServiceContext serviceContext)
		throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap<>();

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
			commercePriceModifier.getCompanyId(), 0L, userId,
			CommercePriceModifier.class.getName(),
			commercePriceModifier.getCommercePriceModifierId(),
			commercePriceModifier, serviceContext, workflowContext);
	}

	protected void validate(
			long companyId, long commercePriceModifierId, String title,
			String target, String modifierType, BigDecimal modifierAmount)
		throws PortalException {

		if (Validator.isNull(title)) {
			throw new CommercePriceModifierTitleException();
		}

		CommercePriceModifierTarget commercePriceModifierTarget =
			_commercePriceModifierTargetRegistry.getCommercePriceModifierTarget(
				target);

		if (commercePriceModifierTarget == null) {
			throw new CommercePriceModifierTargetException();
		}

		CommercePriceModifierType commercePriceModifierType =
			_commercePriceModifierTypeRegistry.getCommercePriceModifierType(
				modifierType);

		if (commercePriceModifierType == null) {
			throw new CommercePriceModifierTypeException();
		}

		if ((modifierAmount == null) ||
			(modifierAmount.compareTo(BigDecimal.ZERO) < 0)) {

			throw new CommercePriceModifierAmountException();
		}
	}

	private static final String[] _SELECTED_FIELD_NAMES = {
		Field.ENTRY_CLASS_PK, Field.COMPANY_ID, Field.UID
	};

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierLocalServiceImpl.class);

	@ServiceReference(type = CommercePriceModifierTargetRegistry.class)
	private CommercePriceModifierTargetRegistry
		_commercePriceModifierTargetRegistry;

	@ServiceReference(type = CommercePriceModifierTypeRegistry.class)
	private CommercePriceModifierTypeRegistry
		_commercePriceModifierTypeRegistry;

}