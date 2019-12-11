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

package com.liferay.commerce.price.modifier.internal.target;

import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.modifier.constants.CommercePriceModifierConstants;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.model.CommercePriceModifierRel;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalService;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierPricelistTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.ExistsFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Alberti
 */
@Component(
	immediate = true,
	property = {
		"commerce.price.modifier.target.key=" + CommercePriceModifierConstants.TARGET_PRICELIST,
		"commerce.price.modifier.target.order:Integer=20"
	},
	service = {
		CommercePriceModifierPricelistTarget.class,
		CommercePriceModifierTarget.class
	}
)
public class ApplyToPricelistCommercePriceModifierTargetImpl
	implements CommercePriceModifierPricelistTarget,
			   CommercePriceModifierTarget {

	@Override
	public void contributeDocument(
		Document document, CommercePriceModifier commercePriceModifier) {

		List<CommercePriceModifierRel> commercePriceModifierRels =
			_commercePriceModifierRelLocalService.getCommercePriceModifierRels(
				commercePriceModifier.getCommercePriceModifierId(),
				CommercePriceModifier.class.getName());

		Stream<CommercePriceModifierRel> stream =
			commercePriceModifierRels.stream();

		LongStream longStream = stream.mapToLong(
			CommercePriceModifierRel::getClassPK);

		long[] commercePriceListIds = longStream.toArray();

		document.addKeyword("target_pricelist_ids", commercePriceListIds);
	}

	@Override
	public String getKey() {
		return CommercePriceModifierConstants.TARGET_PRICELIST;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "apply-to-pricelist");
	}

	@Override
	public Type getType() {
		return Type.APPLY_TO_PRICELIST;
	}

	@Override
	public void postProcessContextBooleanFilter(
		BooleanFilter contextBooleanFilter,
		CommercePriceList commercePriceList) {

		TermFilter termFilter = new TermFilter(
			"target_pricelist_ids",
			String.valueOf(commercePriceList.getCommercePriceListId()));

		Filter existFilter = new ExistsFilter("target_pricelist_ids");

		BooleanFilter existBooleanFilter = new BooleanFilter();

		existBooleanFilter.add(existFilter, BooleanClauseOccur.MUST_NOT);

		BooleanFilter fieldBooleanFilter = new BooleanFilter();

		fieldBooleanFilter.add(existBooleanFilter, BooleanClauseOccur.SHOULD);
		fieldBooleanFilter.add(termFilter, BooleanClauseOccur.SHOULD);

		contextBooleanFilter.add(fieldBooleanFilter, BooleanClauseOccur.MUST);
	}

	@Reference
	private CommercePriceModifierRelLocalService
		_commercePriceModifierRelLocalService;

}