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

package com.liferay.commerce.price.list.service.impl;

import com.liferay.commerce.price.list.constants.CommercePriceListActionKeys;
import com.liferay.commerce.price.list.model.CommercePriceListContractRel;
import com.liferay.commerce.price.list.service.base.CommercePriceListContractRelServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import java.util.List;

/**
 * @author Riccardo Alberti
 */
public class CommercePriceListContractRelServiceImpl
	extends CommercePriceListContractRelServiceBaseImpl {

	@Override
	public CommercePriceListContractRel addCommercePriceListContractRel(
			long commercePriceListId, long commerceContractId, int order,
			ServiceContext serviceContext)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		return commercePriceListContractRelLocalService.
			addCommercePriceListContractRel(
				commercePriceListId, commerceContractId, order, serviceContext);
	}

	@Override
	public void deleteCommercePriceListContractRel(
			long commercePriceListContractRelId)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		commercePriceListContractRelLocalService.
			deleteCommercePriceListContractRel(commercePriceListContractRelId);
	}

	@Override
	public CommercePriceListContractRel fetchCommercePriceListContractRel(
			long commercePriceListId, long commerceContractId)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		return commercePriceListContractRelLocalService.
			fetchCommercePriceListContractRel(
				commercePriceListId, commerceContractId);
	}

	@Override
	public List<CommercePriceListContractRel> getCommercePriceListContractRels(
			long commercePriceListId)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		return commercePriceListContractRelLocalService.
			getCommercePriceListContractRels(commercePriceListId);
	}

}