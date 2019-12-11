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
 * Provides a wrapper for {@link CommercePriceModifierRelService}.
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRelService
 * @generated
 */
public class CommercePriceModifierRelServiceWrapper
	implements CommercePriceModifierRelService,
			   ServiceWrapper<CommercePriceModifierRelService> {

	public CommercePriceModifierRelServiceWrapper(
		CommercePriceModifierRelService commercePriceModifierRelService) {

		_commercePriceModifierRelService = commercePriceModifierRelService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierRelServiceUtil</code> to access the commerce price modifier rel remote service.
	 */
	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			addCommerceDiscountRel(
				long commerceDiscountId, String className, long classPK,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.addCommerceDiscountRel(
			commerceDiscountId, className, classPK, serviceContext);
	}

	@Override
	public void deleteCommercePriceModifierRel(long commercePriceModifierRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_commercePriceModifierRelService.deleteCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			fetchCommercePriceModifierRel(String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.fetchCommercePriceModifierRel(
			className, classPK);
	}

	@Override
	public long[] getClassPKs(long commercePriceModifierRelId, String className)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.getClassPKs(
			commercePriceModifierRelId, className);
	}

	@Override
	public com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
			getCommercePriceModifierRel(long commercePriceModifierRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.getCommercePriceModifierRel(
			commercePriceModifierRelId);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
				getCommercePriceModifierRels(
					long commercePriceModifierRelId, String className)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.getCommercePriceModifierRels(
			commercePriceModifierRelId, className);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifierRel>
				getCommercePriceModifierRels(
					long commercePriceModifierRelId, String className,
					int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.commerce.price.modifier.model.
							CommercePriceModifierRel> orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.getCommercePriceModifierRels(
			commercePriceModifierRelId, className, start, end,
			orderByComparator);
	}

	@Override
	public int getCommercePriceModifierRelsCount(
			long commercePriceModifierRelId, String className)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commercePriceModifierRelService.
			getCommercePriceModifierRelsCount(
				commercePriceModifierRelId, className);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commercePriceModifierRelService.getOSGiServiceIdentifier();
	}

	@Override
	public CommercePriceModifierRelService getWrappedService() {
		return _commercePriceModifierRelService;
	}

	@Override
	public void setWrappedService(
		CommercePriceModifierRelService commercePriceModifierRelService) {

		_commercePriceModifierRelService = commercePriceModifierRelService;
	}

	private CommercePriceModifierRelService _commercePriceModifierRelService;

}