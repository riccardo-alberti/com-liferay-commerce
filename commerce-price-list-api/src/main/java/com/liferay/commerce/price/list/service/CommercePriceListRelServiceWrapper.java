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

package com.liferay.commerce.price.list.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommercePriceListRelService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRelService
 * @generated
 */
public class CommercePriceListRelServiceWrapper
	implements CommercePriceListRelService,
			   ServiceWrapper<CommercePriceListRelService> {

	public CommercePriceListRelServiceWrapper(
		CommercePriceListRelService commercePriceListRelService) {

		_commercePriceListRelService = commercePriceListRelService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceListRelServiceUtil} to access the commerce price list rel remote service. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListRelServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			addCommercePriceListRel(
				long commercePriceListId, String className, long classPK,
				int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelService.addCommercePriceListRel(
			commercePriceListId, className, classPK, order, serviceContext);
	}

	@Override
	public void deleteCommercePriceListRel(long commercePriceListRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_commercePriceListRelService.deleteCommercePriceListRel(
			commercePriceListRelId);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListRel
			fetchCommercePriceListRel(
				long commercePriceListId, String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelService.fetchCommercePriceListRel(
			commercePriceListId, className, classPK);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListRel>
				getCommercePriceListRels(long commercePriceListId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListRelService.getCommercePriceListRels(
			commercePriceListId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceListRelService.getOSGiServiceIdentifier();
	}

	@Override
	public CommercePriceListRelService getWrappedService() {
		return _commercePriceListRelService;
	}

	@Override
	public void setWrappedService(
		CommercePriceListRelService commercePriceListRelService) {

		_commercePriceListRelService = commercePriceListRelService;
	}

	private CommercePriceListRelService _commercePriceListRelService;

}