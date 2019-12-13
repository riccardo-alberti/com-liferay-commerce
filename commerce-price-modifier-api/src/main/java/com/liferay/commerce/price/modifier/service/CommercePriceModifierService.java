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

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.math.BigDecimal;

import java.util.List;

/**
 * Provides the remote service interface for CommercePriceModifier. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=commerce",
		"json.web.service.context.path=CommercePriceModifier"
	},
	service = CommercePriceModifierService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CommercePriceModifierService extends BaseService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceModifierServiceUtil} to access the commerce price modifier remote service. Add custom service methods to <code>com.liferay.commerce.price.modifier.service.impl.CommercePriceModifierServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierServiceUtil</code> to access the commerce price modifier remote service.
	 *
	 * @throws PortalException
	 */
	public CommercePriceModifier addCommercePriceModifier(
			long userId, long groupId, String description, String title,
			String target, String modifierType, BigDecimal modifierAmount,
			double priority, boolean active, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, ServiceContext serviceContext)
		throws PortalException;

	public CommercePriceModifier deleteCommercePriceModifier(
			long commercePriceModifierId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommercePriceModifier fetchByExternalReferenceCode(
			long companyId, String externalReferenceCode)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommercePriceModifier fetchCommercePriceModifier(
			long commercePriceModifierId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CommercePriceModifier getCommercePriceModifier(
			long commercePriceModifierId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CommercePriceModifier> getCommercePriceModifiers(
			long companyId, String target)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCommercePriceModifiersCount() throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BaseModelSearchResult<CommercePriceModifier>
			searchCommercePriceModifiers(
				long companyId, String keywords, int status, int start, int end,
				Sort sort)
		throws PortalException;

	public CommercePriceModifier updateCommercePriceModifier(
			long commercePriceModifierId, long groupId, String description,
			String title, String target, String modifierType,
			BigDecimal modifierAmount, double priority, boolean active,
			int displayDateMonth, int displayDateDay, int displayDateYear,
			int displayDateHour, int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear,
			int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, ServiceContext serviceContext)
		throws PortalException;

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
		throws PortalException;

}