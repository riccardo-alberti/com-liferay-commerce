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
import com.liferay.commerce.price.list.model.CommercePriceListRel;
import com.liferay.commerce.price.list.service.base.CommercePriceListRelServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import java.util.List;

/**
 * @author Riccardo Alberti
 */
public class CommercePriceListRelServiceImpl
	extends CommercePriceListRelServiceBaseImpl {

	@Override
	public CommercePriceListRel addCommercePriceListRel(
			long commercePriceListId, String className, long classPK, int order,
			ServiceContext serviceContext)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		return commercePriceListRelLocalService.addCommercePriceListRel(
			commercePriceListId, className, classPK, order, serviceContext);
	}

	@Override
	public void deleteCommercePriceListRel(long commercePriceListRelId)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		commercePriceListRelLocalService.deleteCommercePriceListRel(
			commercePriceListRelId);
	}

	@Override
	public CommercePriceListRel fetchCommercePriceListRel(
			long commercePriceListId, String className, long classPK)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		return commercePriceListRelLocalService.fetchCommercePriceListRel(
			commercePriceListId, className, classPK);
	}

	@Override
	public List<CommercePriceListRel> getCommercePriceListRels(
			long commercePriceListId)
		throws PortalException {

		PortalPermissionUtil.check(
			getPermissionChecker(),
			CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS);

		return commercePriceListRelLocalService.getCommercePriceListRels(
			commercePriceListId);
	}

}