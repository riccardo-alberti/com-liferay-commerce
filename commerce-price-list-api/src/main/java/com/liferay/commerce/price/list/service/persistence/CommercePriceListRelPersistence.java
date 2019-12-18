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

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.price.list.exception.NoSuchPriceListRelException;
import com.liferay.commerce.price.list.model.CommercePriceListRel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the commerce price list rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRelUtil
 * @generated
 */
@ProviderType
public interface CommercePriceListRelPersistence
	extends BasePersistence<CommercePriceListRel> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommercePriceListRelUtil} to access the commerce price list rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CommercePriceListRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the commerce price list rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce price list rels
	 */
	public java.util.List<CommercePriceListRel> findByUuid(String uuid);

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
	public java.util.List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

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
	public java.util.List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

	/**
	 * Returns the commerce price list rels before and after the current commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param commercePriceListRelId the primary key of the current commerce price list rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public CommercePriceListRel[] findByUuid_PrevAndNext(
			long commercePriceListRelId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Removes all the commerce price list rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of commerce price list rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce price list rels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce price list rels
	 */
	public java.util.List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

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
	public java.util.List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

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
	public CommercePriceListRel[] findByUuid_C_PrevAndNext(
			long commercePriceListRelId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Removes all the commerce price list rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce price list rels
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the commerce price list rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rels
	 */
	public java.util.List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId);

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
	public java.util.List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end);

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
	public java.util.List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

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
	public java.util.List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByCommercePriceListId_First(
			long commercePriceListId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the first commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByCommercePriceListId_First(
		long commercePriceListId,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

	/**
	 * Returns the last commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByCommercePriceListId_Last(
			long commercePriceListId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the last commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByCommercePriceListId_Last(
		long commercePriceListId,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

	/**
	 * Returns the commerce price list rels before and after the current commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListRelId the primary key of the current commerce price list rel
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public CommercePriceListRel[] findByCommercePriceListId_PrevAndNext(
			long commercePriceListRelId, long commercePriceListId,
			com.liferay.portal.kernel.util.OrderByComparator
				<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException;

	/**
	 * Removes all the commerce price list rels where commercePriceListId = &#63; from the database.
	 *
	 * @param commercePriceListId the commerce price list ID
	 */
	public void removeByCommercePriceListId(long commercePriceListId);

	/**
	 * Returns the number of commerce price list rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list rels
	 */
	public int countByCommercePriceListId(long commercePriceListId);

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or throws a <code>NoSuchPriceListRelException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel findByC_CN(
			long classNameId, long commercePriceListId)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByC_CN(
		long classNameId, long commercePriceListId);

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	public CommercePriceListRel fetchByC_CN(
		long classNameId, long commercePriceListId, boolean useFinderCache);

	/**
	 * Removes the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the commerce price list rel that was removed
	 */
	public CommercePriceListRel removeByC_CN(
			long classNameId, long commercePriceListId)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the number of commerce price list rels where classNameId = &#63; and commercePriceListId = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list rels
	 */
	public int countByC_CN(long classNameId, long commercePriceListId);

	/**
	 * Caches the commerce price list rel in the entity cache if it is enabled.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 */
	public void cacheResult(CommercePriceListRel commercePriceListRel);

	/**
	 * Caches the commerce price list rels in the entity cache if it is enabled.
	 *
	 * @param commercePriceListRels the commerce price list rels
	 */
	public void cacheResult(
		java.util.List<CommercePriceListRel> commercePriceListRels);

	/**
	 * Creates a new commerce price list rel with the primary key. Does not add the commerce price list rel to the database.
	 *
	 * @param commercePriceListRelId the primary key for the new commerce price list rel
	 * @return the new commerce price list rel
	 */
	public CommercePriceListRel create(long commercePriceListRelId);

	/**
	 * Removes the commerce price list rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public CommercePriceListRel remove(long commercePriceListRelId)
		throws NoSuchPriceListRelException;

	public CommercePriceListRel updateImpl(
		CommercePriceListRel commercePriceListRel);

	/**
	 * Returns the commerce price list rel with the primary key or throws a <code>NoSuchPriceListRelException</code> if it could not be found.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	public CommercePriceListRel findByPrimaryKey(long commercePriceListRelId)
		throws NoSuchPriceListRelException;

	/**
	 * Returns the commerce price list rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel, or <code>null</code> if a commerce price list rel with the primary key could not be found
	 */
	public CommercePriceListRel fetchByPrimaryKey(long commercePriceListRelId);

	/**
	 * Returns all the commerce price list rels.
	 *
	 * @return the commerce price list rels
	 */
	public java.util.List<CommercePriceListRel> findAll();

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
	public java.util.List<CommercePriceListRel> findAll(int start, int end);

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
	public java.util.List<CommercePriceListRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator);

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
	public java.util.List<CommercePriceListRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommercePriceListRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the commerce price list rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of commerce price list rels.
	 *
	 * @return the number of commerce price list rels
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}