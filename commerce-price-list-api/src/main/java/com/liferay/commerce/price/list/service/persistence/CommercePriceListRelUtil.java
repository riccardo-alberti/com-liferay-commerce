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

package com.liferay.commerce.price.list.service.persistence;

import com.liferay.commerce.price.list.model.CommercePriceListRel;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the commerce price list rel service. This utility wraps <code>com.liferay.commerce.price.list.service.persistence.impl.CommercePriceListRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRelPersistence
 * @generated
 */
public class CommercePriceListRelUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CommercePriceListRel commercePriceListRel) {
		getPersistence().clearCache(commercePriceListRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CommercePriceListRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CommercePriceListRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommercePriceListRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommercePriceListRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CommercePriceListRel update(
		CommercePriceListRel commercePriceListRel) {

		return getPersistence().update(commercePriceListRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CommercePriceListRel update(
		CommercePriceListRel commercePriceListRel,
		ServiceContext serviceContext) {

		return getPersistence().update(commercePriceListRel, serviceContext);
	}

	/**
	 * Returns all the commerce price list rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the commerce price list rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @return the range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByUuid_First(
			String uuid,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByUuid_First(
		String uuid,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByUuid_Last(
			String uuid,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the commerce price list rels before and after the current commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param commercePriceListRelId the primary key of the current commerce price list rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public static CommercePriceListRel[] findByUuid_PrevAndNext(
			long commercePriceListRelId, String uuid,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByUuid_PrevAndNext(
			commercePriceListRelId, uuid, orderByComparator);
	}

	/**
	 * Removes all the commerce price list rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of commerce price list rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce price list rels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @return the range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the commerce price list rels before and after the current commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commercePriceListRelId the primary key of the current commerce price list rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public static CommercePriceListRel[] findByUuid_C_PrevAndNext(
			long commercePriceListRelId, String uuid, long companyId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByUuid_C_PrevAndNext(
			commercePriceListRelId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the commerce price list rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce price list rels
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the commerce price list rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId) {

		return getPersistence().findByCommercePriceListId(commercePriceListId);
	}

	/**
	 * Returns a range of all the commerce price list rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @return the range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end) {

		return getPersistence().findByCommercePriceListId(
			commercePriceListId, start, end);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().findByCommercePriceListId(
			commercePriceListId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list rels
	 */
	public static List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCommercePriceListId(
			commercePriceListId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByCommercePriceListId_First(
			long commercePriceListId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByCommercePriceListId_First(
			commercePriceListId, orderByComparator);
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByCommercePriceListId_First(
		long commercePriceListId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().fetchByCommercePriceListId_First(
			commercePriceListId, orderByComparator);
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByCommercePriceListId_Last(
			long commercePriceListId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByCommercePriceListId_Last(
			commercePriceListId, orderByComparator);
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByCommercePriceListId_Last(
		long commercePriceListId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().fetchByCommercePriceListId_Last(
			commercePriceListId, orderByComparator);
	}

	/**
	 * Returns the commerce price list rels before and after the current commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListRelId the primary key of the current commerce price list rel
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public static CommercePriceListRel[] findByCommercePriceListId_PrevAndNext(
			long commercePriceListRelId, long commercePriceListId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByCommercePriceListId_PrevAndNext(
			commercePriceListRelId, commercePriceListId, orderByComparator);
	}

	/**
	 * Removes all the commerce price list rels where commercePriceListId = &#63; from the database.
	 *
	 * @param commercePriceListId the commerce price list ID
	 */
	public static void removeByCommercePriceListId(long commercePriceListId) {
		getPersistence().removeByCommercePriceListId(commercePriceListId);
	}

	/**
	 * Returns the number of commerce price list rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list rels
	 */
	public static int countByCommercePriceListId(long commercePriceListId) {
		return getPersistence().countByCommercePriceListId(commercePriceListId);
	}

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or throws a <code>NoSuchPriceListRelException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel findByC_CN(
			long classNameId, long commercePriceListId)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByC_CN(classNameId, commercePriceListId);
	}

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByC_CN(
		long classNameId, long commercePriceListId) {

		return getPersistence().fetchByC_CN(classNameId, commercePriceListId);
	}

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public static CommercePriceListRel fetchByC_CN(
		long classNameId, long commercePriceListId, boolean useFinderCache) {

		return getPersistence().fetchByC_CN(
			classNameId, commercePriceListId, useFinderCache);
	}

	/**
	 * Removes the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the commerce price list rel that was removed
	 */
	public static CommercePriceListRel removeByC_CN(
			long classNameId, long commercePriceListId)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().removeByC_CN(classNameId, commercePriceListId);
	}

	/**
	 * Returns the number of commerce price list rels where classNameId = &#63; and commercePriceListId = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list rels
	 */
	public static int countByC_CN(long classNameId, long commercePriceListId) {
		return getPersistence().countByC_CN(classNameId, commercePriceListId);
	}

	/**
	 * Caches the commerce price list rel in the entity cache if it is enabled.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 */
	public static void cacheResult(CommercePriceListRel commercePriceListRel) {
		getPersistence().cacheResult(commercePriceListRel);
	}

	/**
	 * Caches the commerce price list rels in the entity cache if it is enabled.
	 *
	 * @param commercePriceListRels the commerce price list rels
	 */
	public static void cacheResult(
		List<CommercePriceListRel> commercePriceListRels) {

		getPersistence().cacheResult(commercePriceListRels);
	}

	/**
	 * Creates a new commerce price list rel with the primary key. Does not add the commerce price list rel to the database.
	 *
	 * @param commercePriceListRelId the primary key for the new commerce price list rel
	 * @return the new commerce price list rel
	 */
	public static CommercePriceListRel create(long commercePriceListRelId) {
		return getPersistence().create(commercePriceListRelId);
	}

	/**
	 * Removes the commerce price list rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public static CommercePriceListRel remove(long commercePriceListRelId)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().remove(commercePriceListRelId);
	}

	public static CommercePriceListRel updateImpl(
		CommercePriceListRel commercePriceListRel) {

		return getPersistence().updateImpl(commercePriceListRel);
	}

	/**
	 * Returns the commerce price list rel with the primary key or throws a <code>NoSuchPriceListRelException</code> if it could not be found.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public static CommercePriceListRel findByPrimaryKey(
			long commercePriceListRelId)
		throws com.liferay.commerce.price.list.exception.
			NoSuchPriceListRelException {

		return getPersistence().findByPrimaryKey(commercePriceListRelId);
	}

	/**
	 * Returns the commerce price list rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel, or <code>null</code> if a commerce price list rel with the primary key could not be found
	 */
	public static CommercePriceListRel fetchByPrimaryKey(
		long commercePriceListRelId) {

		return getPersistence().fetchByPrimaryKey(commercePriceListRelId);
	}

	/**
	 * Returns all the commerce price list rels.
	 *
	 * @return the commerce price list rels
	 */
	public static List<CommercePriceListRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the commerce price list rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @return the range of commerce price list rels
	 */
	public static List<CommercePriceListRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce price list rels
	 */
	public static List<CommercePriceListRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the commerce price list rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list rels
	 * @param end the upper bound of the range of commerce price list rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce price list rels
	 */
	public static List<CommercePriceListRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the commerce price list rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of commerce price list rels.
	 *
	 * @return the number of commerce price list rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CommercePriceListRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CommercePriceListRelPersistence, CommercePriceListRelPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CommercePriceListRelPersistence.class);

		ServiceTracker
			<CommercePriceListRelPersistence, CommercePriceListRelPersistence>
				serviceTracker =
					new ServiceTracker
						<CommercePriceListRelPersistence,
						 CommercePriceListRelPersistence>(
							 bundle.getBundleContext(),
							 CommercePriceListRelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}