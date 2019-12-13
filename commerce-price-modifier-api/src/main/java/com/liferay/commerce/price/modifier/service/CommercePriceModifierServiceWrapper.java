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
 * Provides a wrapper for {@link CommercePriceModifierService}.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierService
 * @generated
 */
public class CommercePriceModifierServiceWrapper
	implements CommercePriceModifierService,
			   ServiceWrapper<CommercePriceModifierService> {

	public CommercePriceModifierServiceWrapper(
		CommercePriceModifierService commercePriceModifierService) {

		_commercePriceModifierService = commercePriceModifierService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierServiceUtil</code> to access the commerce price modifier remote service.
	 *
	 * @throws PortalException
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

		return _commercePriceModifierService.addCommercePriceModifier(
			userId, groupId, description, title, target, modifierType,
			modifierAmount, priority, active, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			deleteCommercePriceModifier(long commercePriceModifierId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.deleteCommercePriceModifier(
			commercePriceModifierId);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			fetchByExternalReferenceCode(
				long companyId, String externalReferenceCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.fetchByExternalReferenceCode(
			companyId, externalReferenceCode);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			fetchCommercePriceModifier(long commercePriceModifierId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.fetchCommercePriceModifier(
			commercePriceModifierId);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifier
			getCommercePriceModifier(long commercePriceModifierId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.getCommercePriceModifier(
			commercePriceModifierId);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				getCommercePriceModifiers(long companyId, String target)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.getCommercePriceModifiers(
			companyId, target);
	}

	@Override
	public int getCommercePriceModifiersCount()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.getCommercePriceModifiersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceModifierService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				searchCommercePriceModifiers(
					long companyId, String keywords, int status, int start,
					int end, com.liferay.portal.kernel.search.Sort sort)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierService.searchCommercePriceModifiers(
			companyId, keywords, status, start, end, sort);
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

		return _commercePriceModifierService.updateCommercePriceModifier(
			commercePriceModifierId, groupId, description, title, target,
			modifierType, modifierAmount, priority, active, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			serviceContext);
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

		return _commercePriceModifierService.upsertCommercePriceModifier(
			userId, commercePriceModifierId, groupId, description, title,
			target, modifierType, modifierAmount, priority, active,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			externalReferenceCode, neverExpire, serviceContext);
	}

	@Override
	public CommercePriceModifierService getWrappedService() {
		return _commercePriceModifierService;
	}

	@Override
	public void setWrappedService(
		CommercePriceModifierService commercePriceModifierService) {

		_commercePriceModifierService = commercePriceModifierService;
	}

	private CommercePriceModifierService _commercePriceModifierService;

}