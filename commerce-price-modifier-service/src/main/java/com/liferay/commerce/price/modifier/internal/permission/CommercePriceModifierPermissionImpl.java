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

package com.liferay.commerce.price.modifier.internal.permission;

import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.permission.CommercePriceModifierPermission;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Alberti
 */
@Component(immediate = true, service = CommercePriceModifierPermission.class)
public class CommercePriceModifierPermissionImpl
	implements CommercePriceModifierPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker,
			CommercePriceModifier commercePriceModifier, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, commercePriceModifier, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, CommercePriceModifier.class.getName(),
				commercePriceModifier.getCommercePriceModifierId(), actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, long commercePriceModifierId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, commercePriceModifierId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, CommercePriceModifier.class.getName(),
				commercePriceModifierId, actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker,
			CommercePriceModifier commercePriceModifier, String actionId)
		throws PortalException {

		if (contains(
				permissionChecker,
				commercePriceModifier.getCommercePriceModifierId(), actionId)) {

			return true;
		}

		return false;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long commercePriceModifierId,
			String actionId)
		throws PortalException {

		CommercePriceModifier commercePriceModifier =
			_commercePriceModifierLocalService.getCommercePriceModifier(
				commercePriceModifierId);

		if (commercePriceModifier == null) {
			return false;
		}

		return _contains(permissionChecker, commercePriceModifier, actionId);
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker,
			long[] commercePriceModifierIds, String actionId)
		throws PortalException {

		if (ArrayUtil.isEmpty(commercePriceModifierIds)) {
			return false;
		}

		for (long commercePriceModifierId : commercePriceModifierIds) {
			if (!contains(
					permissionChecker, commercePriceModifierId, actionId)) {

				return false;
			}
		}

		return true;
	}

	private boolean _contains(
		PermissionChecker permissionChecker,
		CommercePriceModifier commercePriceModifier, String actionId) {

		if (permissionChecker.isCompanyAdmin(
				commercePriceModifier.getCompanyId()) ||
			permissionChecker.isOmniadmin()) {

			return true;
		}

		if (permissionChecker.hasOwnerPermission(
				permissionChecker.getCompanyId(),
				CommercePriceModifier.class.getName(),
				commercePriceModifier.getCommercePriceModifierId(),
				permissionChecker.getUserId(), actionId) &&
			(commercePriceModifier.getUserId() ==
				permissionChecker.getUserId())) {

			return true;
		}

		return permissionChecker.hasPermission(
			null, CommercePriceModifier.class.getName(),
			commercePriceModifier.getCommercePriceModifierId(), actionId);
	}

	@Reference
	private CommercePriceModifierLocalService
		_commercePriceModifierLocalService;

}