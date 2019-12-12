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

package com.liferay.commerce.price.modifier.service.impl;

import com.liferay.commerce.price.modifier.model.CommercePriceModifierRel;
import com.liferay.commerce.price.modifier.service.base.CommercePriceModifierRelServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * The implementation of the commerce price modifier rel remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierRelService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRelServiceBaseImpl
 */
public class CommercePriceModifierRelServiceImpl
	extends CommercePriceModifierRelServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierRelServiceUtil</code> to access the commerce price modifier rel remote service.
	 */
	@Override
	public CommercePriceModifierRel addCommercePriceModifierRel(
			long commercePriceModifierId, String className, long classPK,
			ServiceContext serviceContext)
		throws PortalException {

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(), commercePriceModifierId, ActionKeys.UPDATE);

		return commercePriceModifierRelLocalService.addCommercePriceModifierRel(
			commercePriceModifierId, className, classPK, serviceContext);
	}

	@Override
	public void deleteCommercePriceModifierRel(long commercePriceModifierRelId)
		throws PortalException {

		CommercePriceModifierRel commercePriceModifierRel =
			commercePriceModifierRelLocalService.getCommercePriceModifierRel(
				commercePriceModifierRelId);

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(),
			commercePriceModifierRel.getCommercePriceModifierId(),
			ActionKeys.UPDATE);

		commercePriceModifierRelLocalService.deleteCommercePriceModifierRel(
			commercePriceModifierRel);
	}

	@Override
	public CommercePriceModifierRel fetchCommercePriceModifierRel(
			String className, long classPK)
		throws PortalException {

		CommercePriceModifierRel commercePriceModifierRel =
			commercePriceModifierRelLocalService.fetchCommercePriceModifierRel(
				className, classPK);

		if (commercePriceModifierRel != null) {
			_commercePriceModifierResourcePermission.check(
				getPermissionChecker(),
				commercePriceModifierRel.getCommercePriceModifierId(),
				ActionKeys.UPDATE);
		}

		return commercePriceModifierRel;
	}

	@Override
	public long[] getClassPKs(long commercePriceModifierRelId, String className)
		throws PortalException {

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(), commercePriceModifierRelId,
			ActionKeys.UPDATE);

		return commercePriceModifierRelLocalService.getClassPKs(
			commercePriceModifierRelId, className);
	}

	@Override
	public CommercePriceModifierRel getCommercePriceModifierRel(
			long commercePriceModifierRelId)
		throws PortalException {

		CommercePriceModifierRel commercePriceModifierRel =
			commercePriceModifierRelLocalService.getCommercePriceModifierRel(
				commercePriceModifierRelId);

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(),
			commercePriceModifierRel.getCommercePriceModifierId(),
			ActionKeys.UPDATE);

		return commercePriceModifierRel;
	}

	@Override
	public List<CommercePriceModifierRel> getCommercePriceModifierRels(
			long commercePriceModifierRelId, String className)
		throws PortalException {

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(), commercePriceModifierRelId,
			ActionKeys.UPDATE);

		return commercePriceModifierRelLocalService.
			getCommercePriceModifierRels(commercePriceModifierRelId, className);
	}

	@Override
	public List<CommercePriceModifierRel> getCommercePriceModifierRels(
			long commercePriceModifierRelId, String className, int start,
			int end,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws PortalException {

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(), commercePriceModifierRelId,
			ActionKeys.UPDATE);

		return commercePriceModifierRelLocalService.
			getCommercePriceModifierRels(
				commercePriceModifierRelId, className, start, end,
				orderByComparator);
	}

	@Override
	public int getCommercePriceModifierRelsCount(
			long commercePriceModifierRelId, String className)
		throws PortalException {

		_commercePriceModifierResourcePermission.check(
			getPermissionChecker(), commercePriceModifierRelId,
			ActionKeys.UPDATE);

		return commercePriceModifierRelLocalService.
			getCommercePriceModifierRelsCount(
				commercePriceModifierRelId, className);
	}

	private static volatile ModelResourcePermission<CommercePriceModifierRel>
		_commercePriceModifierResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				CommercePriceModifierRelServiceImpl.class,
				"_commercePriceModifierResourcePermission",
				CommercePriceModifierRel.class);

}