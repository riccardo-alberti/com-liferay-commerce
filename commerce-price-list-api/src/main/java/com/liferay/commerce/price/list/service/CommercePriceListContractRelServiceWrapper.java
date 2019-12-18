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
 * Provides a wrapper for {@link CommercePriceListContractRelService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListContractRelService
 * @generated
 */
public class CommercePriceListContractRelServiceWrapper
	implements CommercePriceListContractRelService,
			   ServiceWrapper<CommercePriceListContractRelService> {

	public CommercePriceListContractRelServiceWrapper(
		CommercePriceListContractRelService
			commercePriceListContractRelService) {

		_commercePriceListContractRelService =
			commercePriceListContractRelService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceListContractRelServiceUtil} to access the commerce price list contract rel remote service. Add custom service methods to <code>com.liferay.commerce.price.list.service.impl.CommercePriceListContractRelServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			addCommercePriceListContractRel(
				long commercePriceListId, long commerceContractId, int order,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelService.
			addCommercePriceListContractRel(
				commercePriceListId, commerceContractId, order, serviceContext);
	}

	@Override
	public void deleteCommercePriceListContractRel(
			long commercePriceListContractRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_commercePriceListContractRelService.deleteCommercePriceListContractRel(
			commercePriceListContractRelId);
	}

	@Override
	public com.liferay.commerce.price.list.model.CommercePriceListContractRel
			fetchCommercePriceListContractRel(
				long commercePriceListId, long commerceContractId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelService.
			fetchCommercePriceListContractRel(
				commercePriceListId, commerceContractId);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListContractRel>
				getCommercePriceListContractRels(long commercePriceListId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceListContractRelService.
			getCommercePriceListContractRels(commercePriceListId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceListContractRelService.getOSGiServiceIdentifier();
	}

	@Override
	public CommercePriceListContractRelService getWrappedService() {
		return _commercePriceListContractRelService;
	}

	@Override
	public void setWrappedService(
		CommercePriceListContractRelService
			commercePriceListContractRelService) {

		_commercePriceListContractRelService =
			commercePriceListContractRelService;
	}

	private CommercePriceListContractRelService
		_commercePriceListContractRelService;

}