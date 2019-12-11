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

import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.model.CommercePriceModifierRel;
import com.liferay.commerce.price.modifier.service.base.CommercePriceModifierRelLocalServiceBaseImpl;
import com.liferay.commerce.price.modifier.util.comparator.CommercePriceModifierRelCreateDateComparator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * The implementation of the commerce price modifier rel local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRelLocalServiceBaseImpl
 */
public class CommercePriceModifierRelLocalServiceImpl
	extends CommercePriceModifierRelLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalServiceUtil</code>.
	 */
	@Override
	public CommercePriceModifierRel addCommercePriceModifierRel(
			long commercePriceModifierId, String className, long classPK,
			ServiceContext serviceContext)
		throws PortalException {

		// Commerce price modifier rel

		User user = userLocalService.getUser(serviceContext.getUserId());

		long commercePriceModifierRelId = counterLocalService.increment();

		CommercePriceModifierRel commercePriceModifierRel =
			commercePriceModifierRelPersistence.create(
				commercePriceModifierRelId);

		commercePriceModifierRel.setCompanyId(user.getCompanyId());
		commercePriceModifierRel.setUserId(user.getUserId());
		commercePriceModifierRel.setUserName(user.getFullName());
		commercePriceModifierRel.setCommercePriceModifierId(
			commercePriceModifierId);
		commercePriceModifierRel.setClassName(className);
		commercePriceModifierRel.setClassPK(classPK);

		commercePriceModifierRelPersistence.update(commercePriceModifierRel);

		// Commerce price modifier

		reindexCommercePriceModifier(commercePriceModifierId);

		return commercePriceModifierRel;
	}

	@Override
	public CommercePriceModifierRel deleteCommercePriceModifierRel(
			CommercePriceModifierRel commercePriceModifierRel)
		throws PortalException {

		// Commerce price modifier rel

		commercePriceModifierRelPersistence.remove(commercePriceModifierRel);

		// Commerce price modifier

		reindexCommercePriceModifier(
			commercePriceModifierRel.getCommercePriceModifierId());

		return commercePriceModifierRel;
	}

	@Override
	public CommercePriceModifierRel deleteCommercePriceModifierRel(
			long commercePriceModifierRelId)
		throws PortalException {

		CommercePriceModifierRel commercePriceModifierRel =
			commercePriceModifierRelPersistence.findByPrimaryKey(
				commercePriceModifierRelId);

		return commercePriceModifierRelLocalService.
			deleteCommercePriceModifierRel(commercePriceModifierRel);
	}

	@Override
	public void deleteCommercePriceModifierRels(long commercePriceModifierId)
		throws PortalException {

		List<CommercePriceModifierRel> commercePriceModifierRels =
			commercePriceModifierRelPersistence.findByCommercePriceModifierId(
				commercePriceModifierId);

		for (CommercePriceModifierRel commercePriceModifierRel :
				commercePriceModifierRels) {

			commercePriceModifierRelLocalService.deleteCommercePriceModifierRel(
				commercePriceModifierRel);
		}
	}

	@Override
	public void deleteCommercePriceModifierRels(String className, long classPK)
		throws PortalException {

		List<CommercePriceModifierRel> commercePriceModifierRels =
			commercePriceModifierRelPersistence.findByCN_CPK(
				classNameLocalService.getClassNameId(className), classPK);

		for (CommercePriceModifierRel commercePriceModifierRel :
				commercePriceModifierRels) {

			commercePriceModifierRelLocalService.deleteCommercePriceModifierRel(
				commercePriceModifierRel);
		}
	}

	@Override
	public CommercePriceModifierRel fetchCommercePriceModifierRel(
		String className, long classPK) {

		return commercePriceModifierRelPersistence.fetchByCN_CPK_First(
			classNameLocalService.getClassNameId(className), classPK,
			new CommercePriceModifierRelCreateDateComparator());
	}

	@Override
	public long[] getClassPKs(long commercePriceModifierId, String className) {
		return ListUtil.toLongArray(
			commercePriceModifierRelPersistence.findByCPM_CN(
				commercePriceModifierId,
				classNameLocalService.getClassNameId(className)),
			CommercePriceModifierRel::getClassPK);
	}

	@Override
	public List<CommercePriceModifierRel> getCommercePriceModifierRels(
		long commercePriceModifierId, String className) {

		return commercePriceModifierRelPersistence.findByCPM_CN(
			commercePriceModifierId,
			classNameLocalService.getClassNameId(className));
	}

	@Override
	public List<CommercePriceModifierRel> getCommercePriceModifierRels(
		long commercePriceModifierId, String className, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		return commercePriceModifierRelPersistence.findByCPM_CN(
			commercePriceModifierId,
			classNameLocalService.getClassNameId(className), start, end,
			orderByComparator);
	}

	@Override
	public int getCommercePriceModifierRelsCount(
		long commercePriceModifierId, String className) {

		return commercePriceModifierRelPersistence.countByCPM_CN(
			commercePriceModifierId,
			classNameLocalService.getClassNameId(className));
	}

	protected void reindexCommercePriceModifier(long commercePriceModifierId)
		throws PortalException {

		CommercePriceModifier commercePriceModifier =
			commercePriceModifierLocalService.getCommercePriceModifier(
				commercePriceModifierId);

		Indexer<CommercePriceModifier> indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(CommercePriceModifier.class);

		indexer.reindex(commercePriceModifier);
	}

}