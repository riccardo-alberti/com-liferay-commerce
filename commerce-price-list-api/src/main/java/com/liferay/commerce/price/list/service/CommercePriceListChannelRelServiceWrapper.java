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
 * Provides a wrapper for {@link CommercePriceListChannelRelService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListChannelRelService
 * @generated
 */
public class CommercePriceListChannelRelServiceWrapper
	implements CommercePriceListChannelRelService,
			   ServiceWrapper<CommercePriceListChannelRelService> {

	public CommercePriceListChannelRelServiceWrapper(
		CommercePriceListChannelRelService commercePriceListChannelRelService) {

		_commercePriceListChannelRelService =
			commercePriceListChannelRelService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceListChannelRelServiceUtil} to access the commerce price list channel rel remote service. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListChannelRelServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			addCommercePriceListChannelRel(
				long commercePriceListId, long commerceChannelId, int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListChannelRelService.
			addCommercePriceListChannelRel(
				commercePriceListId, commerceChannelId, order, serviceContext);
	}

	@Override
	public void deleteCommercePriceListChannelRel(
			long commercePriceListChannelRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_commercePriceListChannelRelService.deleteCommercePriceListChannelRel(
			commercePriceListChannelRelId);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListChannelRel
			fetchCommercePriceListChannelRel(
				long commercePriceListId, long commerceChannelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListChannelRelService.
			fetchCommercePriceListChannelRel(
				commercePriceListId, commerceChannelId);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListChannelRel>
				getCommercePriceListChannelRels(long commercePriceListId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListChannelRelService.
			getCommercePriceListChannelRels(commercePriceListId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceListChannelRelService.getOSGiServiceIdentifier();
	}

	@Override
	public CommercePriceListChannelRelService getWrappedService() {
		return _commercePriceListChannelRelService;
	}

	@Override
	public void setWrappedService(
		CommercePriceListChannelRelService commercePriceListChannelRelService) {

		_commercePriceListChannelRelService =
			commercePriceListChannelRelService;
	}

	private CommercePriceListChannelRelService
		_commercePriceListChannelRelService;

}