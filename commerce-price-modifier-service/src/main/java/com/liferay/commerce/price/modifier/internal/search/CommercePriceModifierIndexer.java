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

package com.liferay.commerce.price.modifier.internal.search;

import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.list.service.CommercePriceListLocalService;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierPriceListTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierProductTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTargetRegistry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Riccardo Alberti
 */
@Component(immediate = true, service = Indexer.class)
public class CommercePriceModifierIndexer
	extends BaseIndexer<CommercePriceModifier> {

	public static final String CLASS_NAME =
		CommercePriceModifier.class.getName();

	public static final String FIELD_ACTIVE = "active";

	public static final String FIELD_EXTERNAL_REFERENCE_CODE =
		"externalReferenceCode";

	public static final String FIELD_GROUP_IDS = "groupIds";

	public static final String FIELD_TARGET_TYPE = "targetType";

	public CommercePriceModifierIndexer() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
			Field.GROUP_ID, Field.MODIFIED_DATE, Field.NAME,
			Field.SCOPE_GROUP_ID, Field.UID);
		setFilterSearch(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {

		int[] statuses = GetterUtil.getIntegerValues(
			searchContext.getAttribute(Field.STATUS), null);

		if (ArrayUtil.isEmpty(statuses)) {
			int status = GetterUtil.getInteger(
				searchContext.getAttribute(Field.STATUS),
				WorkflowConstants.STATUS_APPROVED);

			statuses = new int[] {status};
		}

		if (!ArrayUtil.contains(statuses, WorkflowConstants.STATUS_ANY)) {
			TermsFilter statusesTermsFilter = new TermsFilter(Field.STATUS);

			statusesTermsFilter.addValues(ArrayUtil.toStringArray(statuses));

			contextBooleanFilter.add(
				statusesTermsFilter, BooleanClauseOccur.MUST);
		}
		else {
			contextBooleanFilter.addTerm(
				Field.STATUS, String.valueOf(WorkflowConstants.STATUS_IN_TRASH),
				BooleanClauseOccur.MUST_NOT);
		}

		long commercePriceListId = GetterUtil.getLong(
			searchContext.getAttribute("commercePriceListId"));

		if (commercePriceListId > 0) {
			CommercePriceList commercePriceList =
				_commercePriceListLocalService.getCommercePriceList(
					commercePriceListId);

			for (CommercePriceModifierPriceListTarget
					commercePriceModifierPriceListTarget :
						_commercePriceModifierPriceListTargets) {

				commercePriceModifierPriceListTarget.
					postProcessContextBooleanFilter(
						contextBooleanFilter, commercePriceList);
			}
		}

		long cpDefinitionId = GetterUtil.getLong(
			searchContext.getAttribute("cpDefinitionId"));

		if (cpDefinitionId > 0) {
			CPDefinition cpDefinition =
				_cpDefinitionLocalService.getCPDefinition(cpDefinitionId);

			for (CommercePriceModifierProductTarget
					commercePriceModifierProductTarget :
						_commercePriceModifierProductTargets) {

				commercePriceModifierProductTarget.
					postProcessContextBooleanFilter(
						contextBooleanFilter, cpDefinition);
			}
		}
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {

		addSearchTerm(searchQuery, searchContext, Field.ENTRY_CLASS_PK, false);
		addSearchTerm(searchQuery, searchContext, Field.NAME, false);
		addSearchTerm(searchQuery, searchContext, Field.USER_NAME, false);
		addSearchTerm(
			searchQuery, searchContext, FIELD_EXTERNAL_REFERENCE_CODE, false);

		LinkedHashMap<String, Object> params =
			(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

		if (params != null) {
			String expandoAttributes = (String)params.get("expandoAttributes");

			if (Validator.isNotNull(expandoAttributes)) {
				addSearchExpando(searchQuery, searchContext, expandoAttributes);
			}
		}
	}

	@Override
	protected void doDelete(CommercePriceModifier commercePriceModifier)
		throws Exception {

		deleteDocument(
			commercePriceModifier.getCompanyId(),
			commercePriceModifier.getCommercePriceModifierId());
	}

	@Override
	protected Document doGetDocument(
			CommercePriceModifier commercePriceModifier)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("Indexing price modifier " + commercePriceModifier);
		}

		Document document = getBaseModelDocument(
			CLASS_NAME, commercePriceModifier);

		CommercePriceModifierTarget commercePriceModifierTarget =
			_commercePriceModifierTargetRegistry.getCommercePriceModifierTarget(
				commercePriceModifier.getTarget());

		CommercePriceModifierTarget.Type commercePriceModifierTargetType =
			commercePriceModifierTarget.getType();

		document.addText(Field.TITLE, commercePriceModifier.getTitle());

		document.addText(
			FIELD_TARGET_TYPE, commercePriceModifierTargetType.toString());
		document.addKeyword(FIELD_ACTIVE, commercePriceModifier.isActive());

		document.addKeyword(
			FIELD_EXTERNAL_REFERENCE_CODE,
			commercePriceModifier.getExternalReferenceCode());
		document.addNumber(
			Field.ENTRY_CLASS_PK,
			commercePriceModifier.getCommercePriceModifierId());
		document.addText(Field.TITLE, commercePriceModifier.getTitle());
		document.addNumberSortable(
			Field.PRIORITY, commercePriceModifier.getPriority());

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Document " + commercePriceModifier + " indexed successfully");
		}

		if (commercePriceModifierTarget instanceof
				CommercePriceModifierPriceListTarget) {

			CommercePriceModifierPriceListTarget
				commercePriceModifierPriceListTarget =
					(CommercePriceModifierPriceListTarget)
						commercePriceModifierTarget;

			commercePriceModifierPriceListTarget.contributeDocument(
				document, commercePriceModifier);
		}

		if (commercePriceModifierTarget instanceof
				CommercePriceModifierProductTarget) {

			CommercePriceModifierProductTarget
				commercePriceModifierProductTarget =
					(CommercePriceModifierProductTarget)
						commercePriceModifierTarget;

			commercePriceModifierProductTarget.contributeDocument(
				document, commercePriceModifier);
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(
			Document document, Locale locale, String snippet,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		Summary summary = createSummary(
			document, Field.ENTRY_CLASS_PK, Field.NAME);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(CommercePriceModifier commercePriceModifier)
		throws Exception {

		_indexWriterHelper.updateDocument(
			getSearchEngineId(), commercePriceModifier.getCompanyId(),
			getDocument(commercePriceModifier), isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		doReindex(
			_commercePriceModifierLocalService.getCommercePriceModifier(
				classPK));
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexCommercePriceModifiers(companyId);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		service = CommercePriceModifierPriceListTarget.class
	)
	protected void registerCommercePriceModifierPriceListTarget(
		CommercePriceModifierPriceListTarget
			commercePriceModifierPriceListTarget) {

		_commercePriceModifierPriceListTargets.add(
			commercePriceModifierPriceListTarget);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		service = CommercePriceModifierProductTarget.class
	)
	protected void registerCommercePriceModifierProductTarget(
		CommercePriceModifierProductTarget commercePriceModifierProductTarget) {

		_commercePriceModifierProductTargets.add(
			commercePriceModifierProductTarget);
	}

	protected void reindexCommercePriceModifiers(long companyId)
		throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			_commercePriceModifierLocalService.
				getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			(CommercePriceModifier commercePriceModifier) -> {
				try {
					indexableActionableDynamicQuery.addDocuments(
						getDocument(commercePriceModifier));
				}
				catch (PortalException pe) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Unable to index commerce price modifier " +
								commercePriceModifier.
									getCommercePriceModifierId(),
							pe);
					}
				}
			});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	protected void unregisterCommercePriceModifierPriceListTarget(
		CommercePriceModifierPriceListTarget
			commercePriceModifierPriceListTarget) {

		_commercePriceModifierPriceListTargets.remove(
			commercePriceModifierPriceListTarget);
	}

	protected void unregisterCommercePriceModifierProductTarget(
		CommercePriceModifierProductTarget commercePriceModifierProductTarget) {

		_commercePriceModifierProductTargets.remove(
			commercePriceModifierProductTarget);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierIndexer.class);

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

	@Reference
	private CommercePriceListLocalService _commercePriceListLocalService;

	@Reference
	private CommercePriceModifierLocalService
		_commercePriceModifierLocalService;

	private final List<CommercePriceModifierPriceListTarget>
		_commercePriceModifierPriceListTargets = new CopyOnWriteArrayList<>();
	private final List<CommercePriceModifierProductTarget>
		_commercePriceModifierProductTargets = new CopyOnWriteArrayList<>();

	@Reference
	private CommercePriceModifierTargetRegistry
		_commercePriceModifierTargetRegistry;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private IndexWriterHelper _indexWriterHelper;

}