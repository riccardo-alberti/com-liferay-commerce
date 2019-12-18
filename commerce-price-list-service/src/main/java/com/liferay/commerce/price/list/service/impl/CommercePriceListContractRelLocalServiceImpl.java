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

import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.list.model.CommercePriceListContractRel;
import com.liferay.commerce.price.list.service.base.CommercePriceListContractRelLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * @author Riccardo Alberti
 */
public class CommercePriceListContractRelLocalServiceImpl
	extends CommercePriceListContractRelLocalServiceBaseImpl {

	@Override
	public CommercePriceListContractRel addCommercePriceListContractRel(
			long commercePriceListId, long commerceContractId, int order,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(serviceContext.getUserId());

		CommercePriceListContractRel commercePriceListContractRel =
			commercePriceListContractRelPersistence.create(
				counterLocalService.increment());

		commercePriceListContractRel.setCompanyId(user.getCompanyId());
		commercePriceListContractRel.setUserId(user.getUserId());
		commercePriceListContractRel.setUserName(user.getFullName());
		commercePriceListContractRel.setCommerceContractId(commerceContractId);
		commercePriceListContractRel.setCommercePriceListId(
			commercePriceListId);
		commercePriceListContractRel.setOrder(order);
		commercePriceListContractRel.setExpandoBridgeAttributes(serviceContext);

		// Commerce price list

		reindexCommercePriceList(commercePriceListId);

		// Cache

		commercePriceListLocalService.cleanPriceListCache(
			serviceContext.getCompanyId());

		return commercePriceListContractRelPersistence.update(
			commercePriceListContractRel);
	}

	@Override
	public CommercePriceListContractRel deleteCommercePriceListContractRel(
			CommercePriceListContractRel commercePriceListContractRel)
		throws PortalException {

		commercePriceListContractRelPersistence.remove(
			commercePriceListContractRel);

		// Expando

		expandoRowLocalService.deleteRows(
			commercePriceListContractRel.getCommercePriceListContractRelId());

		// Commerce price list

		reindexCommercePriceList(
			commercePriceListContractRel.getCommercePriceListId());

		// Cache

		commercePriceListLocalService.cleanPriceListCache(
			commercePriceListContractRel.getCompanyId());

		return commercePriceListContractRel;
	}

	@Override
	public CommercePriceListContractRel deleteCommercePriceListContractRel(
			long commercePriceListContractRelId)
		throws PortalException {

		CommercePriceListContractRel commercePriceListContractRel =
			commercePriceListContractRelPersistence.findByPrimaryKey(
				commercePriceListContractRelId);

		return commercePriceListContractRelLocalService.
			deleteCommercePriceListContractRel(commercePriceListContractRel);
	}

	@Override
	public void deleteCommercePriceListContractRels(long commercePriceListId) {
		commercePriceListContractRelPersistence.removeByCommercePriceListId(
			commercePriceListId);
	}

	@Override
	public CommercePriceListContractRel fetchCommercePriceListContractRel(
		long commercePriceListId, long commerceContractId) {

		return commercePriceListContractRelPersistence.fetchByC_C(
			commercePriceListId, commerceContractId);
	}

	@Override
	public List<CommercePriceListContractRel> getCommercePriceListContractRels(
		long commercePriceListId) {

		return commercePriceListContractRelPersistence.
			findByCommercePriceListId(commercePriceListId);
	}

	protected void reindexCommercePriceList(long commercePriceListId)
		throws PortalException {

		Indexer<CommercePriceList> indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(CommercePriceList.class);

		indexer.reindex(CommercePriceList.class.getName(), commercePriceListId);
	}

}