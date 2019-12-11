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

import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierPricelistTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTargetRegistry;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashMap;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Alberti
 */
@Component(immediate = true, service = Indexer.class)
public class CommercePriceModifierIndexer
	extends BaseIndexer<CommercePriceModifier> {

	public static final String CLASS_NAME =
		CommercePriceModifierIndexer.class.getName();

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
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
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
				CommercePriceModifierPricelistTarget) {

			CommercePriceModifierPricelistTarget
				commercePriceModifierPricelistTarget =
					(CommercePriceModifierPricelistTarget)
						commercePriceModifierTarget;

			commercePriceModifierPricelistTarget.contributeDocument(
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

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierIndexer.class);

	@Reference
	private CommercePriceModifierLocalService
		_commercePriceModifierLocalService;

	@Reference
	private CommercePriceModifierTargetRegistry
		_commercePriceModifierTargetRegistry;

	@Reference
	private IndexWriterHelper _indexWriterHelper;

}