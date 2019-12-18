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

package com.liferay.commerce.price.list.service.persistence.impl;

import com.liferay.commerce.price.list.exception.NoSuchPriceListRelException;
import com.liferay.commerce.price.list.model.CommercePriceListRel;
import com.liferay.commerce.price.list.model.impl.CommercePriceListRelImpl;
import com.liferay.commerce.price.list.model.impl.CommercePriceListRelModelImpl;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListRelPersistence;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the commerce price list rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class CommercePriceListRelPersistenceImpl
	extends BasePersistenceImpl<CommercePriceListRel>
	implements CommercePriceListRelPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercePriceListRelUtil</code> to access the commerce price list rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercePriceListRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the commerce price list rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce price list rels
	 */
	@Override
	public List<CommercePriceListRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CommercePriceListRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CommercePriceListRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListRel commercePriceListRel : list) {
					if (!uuid.equals(commercePriceListRel.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<CommercePriceListRel>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel findByUuid_First(
			String uuid,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (commercePriceListRel != null) {
			return commercePriceListRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceListRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByUuid_First(
		String uuid,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		List<CommercePriceListRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel findByUuid_Last(
			String uuid,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (commercePriceListRel != null) {
			return commercePriceListRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceListRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CommercePriceListRel[] findByUuid_PrevAndNext(
			long commercePriceListRelId, String uuid,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		uuid = Objects.toString(uuid, "");

		CommercePriceListRel commercePriceListRel = findByPrimaryKey(
			commercePriceListRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListRel[] array = new CommercePriceListRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commercePriceListRel, uuid, orderByComparator, true);

			array[1] = commercePriceListRel;

			array[2] = getByUuid_PrevAndNext(
				session, commercePriceListRel, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePriceListRel getByUuid_PrevAndNext(
		Session session, CommercePriceListRel commercePriceListRel, String uuid,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceListRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommercePriceListRel commercePriceListRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commercePriceListRel);
		}
	}

	/**
	 * Returns the number of commerce price list rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce price list rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICELISTREL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"commercePriceListRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commercePriceListRel.uuid IS NULL OR commercePriceListRel.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce price list rels
	 */
	@Override
	public List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CommercePriceListRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CommercePriceListRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListRel commercePriceListRel : list) {
					if (!uuid.equals(commercePriceListRel.getUuid()) ||
						(companyId != commercePriceListRel.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				list = (List<CommercePriceListRel>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CommercePriceListRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (commercePriceListRel != null) {
			return commercePriceListRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceListRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		List<CommercePriceListRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CommercePriceListRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (commercePriceListRel != null) {
			return commercePriceListRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceListRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CommercePriceListRel[] findByUuid_C_PrevAndNext(
			long commercePriceListRelId, String uuid, long companyId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		uuid = Objects.toString(uuid, "");

		CommercePriceListRel commercePriceListRel = findByPrimaryKey(
			commercePriceListRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListRel[] array = new CommercePriceListRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commercePriceListRel, uuid, companyId,
				orderByComparator, true);

			array[1] = commercePriceListRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, commercePriceListRel, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePriceListRel getByUuid_C_PrevAndNext(
		Session session, CommercePriceListRel commercePriceListRel, String uuid,
		long companyId,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceListRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommercePriceListRel commercePriceListRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceListRel);
		}
	}

	/**
	 * Returns the number of commerce price list rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce price list rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICELISTREL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"commercePriceListRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commercePriceListRel.uuid IS NULL OR commercePriceListRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commercePriceListRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCommercePriceListId;
	private FinderPath _finderPathWithoutPaginationFindByCommercePriceListId;
	private FinderPath _finderPathCountByCommercePriceListId;

	/**
	 * Returns all the commerce price list rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rels
	 */
	@Override
	public List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId) {

		return findByCommercePriceListId(
			commercePriceListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end) {

		return findByCommercePriceListId(commercePriceListId, start, end, null);
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
	@Override
	public List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return findByCommercePriceListId(
			commercePriceListId, start, end, orderByComparator, true);
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
	@Override
	public List<CommercePriceListRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCommercePriceListId;
				finderArgs = new Object[] {commercePriceListId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCommercePriceListId;
			finderArgs = new Object[] {
				commercePriceListId, start, end, orderByComparator
			};
		}

		List<CommercePriceListRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListRel commercePriceListRel : list) {
					if (commercePriceListId !=
							commercePriceListRel.getCommercePriceListId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

			query.append(
				_FINDER_COLUMN_COMMERCEPRICELISTID_COMMERCEPRICELISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceListId);

				list = (List<CommercePriceListRel>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel findByCommercePriceListId_First(
			long commercePriceListId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel =
			fetchByCommercePriceListId_First(
				commercePriceListId, orderByComparator);

		if (commercePriceListRel != null) {
			return commercePriceListRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceListId=");
		msg.append(commercePriceListId);

		msg.append("}");

		throw new NoSuchPriceListRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByCommercePriceListId_First(
		long commercePriceListId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		List<CommercePriceListRel> list = findByCommercePriceListId(
			commercePriceListId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel findByCommercePriceListId_Last(
			long commercePriceListId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel =
			fetchByCommercePriceListId_Last(
				commercePriceListId, orderByComparator);

		if (commercePriceListRel != null) {
			return commercePriceListRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceListId=");
		msg.append(commercePriceListId);

		msg.append("}");

		throw new NoSuchPriceListRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByCommercePriceListId_Last(
		long commercePriceListId,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		int count = countByCommercePriceListId(commercePriceListId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListRel> list = findByCommercePriceListId(
			commercePriceListId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CommercePriceListRel[] findByCommercePriceListId_PrevAndNext(
			long commercePriceListRelId, long commercePriceListId,
			OrderByComparator<CommercePriceListRel> orderByComparator)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = findByPrimaryKey(
			commercePriceListRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListRel[] array = new CommercePriceListRelImpl[3];

			array[0] = getByCommercePriceListId_PrevAndNext(
				session, commercePriceListRel, commercePriceListId,
				orderByComparator, true);

			array[1] = commercePriceListRel;

			array[2] = getByCommercePriceListId_PrevAndNext(
				session, commercePriceListRel, commercePriceListId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePriceListRel getByCommercePriceListId_PrevAndNext(
		Session session, CommercePriceListRel commercePriceListRel,
		long commercePriceListId,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

		query.append(_FINDER_COLUMN_COMMERCEPRICELISTID_COMMERCEPRICELISTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(commercePriceListId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceListRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list rels where commercePriceListId = &#63; from the database.
	 *
	 * @param commercePriceListId the commerce price list ID
	 */
	@Override
	public void removeByCommercePriceListId(long commercePriceListId) {
		for (CommercePriceListRel commercePriceListRel :
				findByCommercePriceListId(
					commercePriceListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceListRel);
		}
	}

	/**
	 * Returns the number of commerce price list rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list rels
	 */
	@Override
	public int countByCommercePriceListId(long commercePriceListId) {
		FinderPath finderPath = _finderPathCountByCommercePriceListId;

		Object[] finderArgs = new Object[] {commercePriceListId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICELISTREL_WHERE);

			query.append(
				_FINDER_COLUMN_COMMERCEPRICELISTID_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceListId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMMERCEPRICELISTID_COMMERCEPRICELISTID_2 =
			"commercePriceListRel.commercePriceListId = ?";

	private FinderPath _finderPathFetchByC_CN;
	private FinderPath _finderPathCountByC_CN;

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or throws a <code>NoSuchPriceListRelException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rel
	 * @throws NoSuchPriceListRelException if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel findByC_CN(
			long classNameId, long commercePriceListId)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = fetchByC_CN(
			classNameId, commercePriceListId);

		if (commercePriceListRel == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", commercePriceListId=");
			msg.append(commercePriceListId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPriceListRelException(msg.toString());
		}

		return commercePriceListRel;
	}

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByC_CN(
		long classNameId, long commercePriceListId) {

		return fetchByC_CN(classNameId, commercePriceListId, true);
	}

	/**
	 * Returns the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price list rel, or <code>null</code> if a matching commerce price list rel could not be found
	 */
	@Override
	public CommercePriceListRel fetchByC_CN(
		long classNameId, long commercePriceListId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {classNameId, commercePriceListId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_CN, finderArgs, this);
		}

		if (result instanceof CommercePriceListRel) {
			CommercePriceListRel commercePriceListRel =
				(CommercePriceListRel)result;

			if ((classNameId != commercePriceListRel.getClassNameId()) ||
				(commercePriceListId !=
					commercePriceListRel.getCommercePriceListId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE);

			query.append(_FINDER_COLUMN_C_CN_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_CN_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(commercePriceListId);

				List<CommercePriceListRel> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_CN, finderArgs, list);
					}
				}
				else {
					CommercePriceListRel commercePriceListRel = list.get(0);

					result = commercePriceListRel;

					cacheResult(commercePriceListRel);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_CN, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CommercePriceListRel)result;
		}
	}

	/**
	 * Removes the commerce price list rel where classNameId = &#63; and commercePriceListId = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the commerce price list rel that was removed
	 */
	@Override
	public CommercePriceListRel removeByC_CN(
			long classNameId, long commercePriceListId)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = findByC_CN(
			classNameId, commercePriceListId);

		return remove(commercePriceListRel);
	}

	/**
	 * Returns the number of commerce price list rels where classNameId = &#63; and commercePriceListId = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list rels
	 */
	@Override
	public int countByC_CN(long classNameId, long commercePriceListId) {
		FinderPath finderPath = _finderPathCountByC_CN;

		Object[] finderArgs = new Object[] {classNameId, commercePriceListId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICELISTREL_WHERE);

			query.append(_FINDER_COLUMN_C_CN_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_CN_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(commercePriceListId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_CN_CLASSNAMEID_2 =
		"commercePriceListRel.classNameId = ? AND ";

	private static final String _FINDER_COLUMN_C_CN_COMMERCEPRICELISTID_2 =
		"commercePriceListRel.commercePriceListId = ?";

	public CommercePriceListRelPersistenceImpl() {
		setModelClass(CommercePriceListRel.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("order", "order_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the commerce price list rel in the entity cache if it is enabled.
	 *
	 * @param commercePriceListRel the commerce price list rel
	 */
	@Override
	public void cacheResult(CommercePriceListRel commercePriceListRel) {
		entityCache.putResult(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			commercePriceListRel.getPrimaryKey(), commercePriceListRel);

		finderCache.putResult(
			_finderPathFetchByC_CN,
			new Object[] {
				commercePriceListRel.getClassNameId(),
				commercePriceListRel.getCommercePriceListId()
			},
			commercePriceListRel);

		commercePriceListRel.resetOriginalValues();
	}

	/**
	 * Caches the commerce price list rels in the entity cache if it is enabled.
	 *
	 * @param commercePriceListRels the commerce price list rels
	 */
	@Override
	public void cacheResult(List<CommercePriceListRel> commercePriceListRels) {
		for (CommercePriceListRel commercePriceListRel :
				commercePriceListRels) {

			if (entityCache.getResult(
					CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListRelImpl.class,
					commercePriceListRel.getPrimaryKey()) == null) {

				cacheResult(commercePriceListRel);
			}
			else {
				commercePriceListRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commerce price list rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercePriceListRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce price list rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommercePriceListRel commercePriceListRel) {
		entityCache.removeResult(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			commercePriceListRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CommercePriceListRelModelImpl)commercePriceListRel, true);
	}

	@Override
	public void clearCache(List<CommercePriceListRel> commercePriceListRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommercePriceListRel commercePriceListRel :
				commercePriceListRels) {

			entityCache.removeResult(
				CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListRelImpl.class,
				commercePriceListRel.getPrimaryKey());

			clearUniqueFindersCache(
				(CommercePriceListRelModelImpl)commercePriceListRel, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommercePriceListRelModelImpl commercePriceListRelModelImpl) {

		Object[] args = new Object[] {
			commercePriceListRelModelImpl.getClassNameId(),
			commercePriceListRelModelImpl.getCommercePriceListId()
		};

		finderCache.putResult(
			_finderPathCountByC_CN, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_CN, args, commercePriceListRelModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CommercePriceListRelModelImpl commercePriceListRelModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				commercePriceListRelModelImpl.getClassNameId(),
				commercePriceListRelModelImpl.getCommercePriceListId()
			};

			finderCache.removeResult(_finderPathCountByC_CN, args);
			finderCache.removeResult(_finderPathFetchByC_CN, args);
		}

		if ((commercePriceListRelModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_CN.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commercePriceListRelModelImpl.getOriginalClassNameId(),
				commercePriceListRelModelImpl.getOriginalCommercePriceListId()
			};

			finderCache.removeResult(_finderPathCountByC_CN, args);
			finderCache.removeResult(_finderPathFetchByC_CN, args);
		}
	}

	/**
	 * Creates a new commerce price list rel with the primary key. Does not add the commerce price list rel to the database.
	 *
	 * @param commercePriceListRelId the primary key for the new commerce price list rel
	 * @return the new commerce price list rel
	 */
	@Override
	public CommercePriceListRel create(long commercePriceListRelId) {
		CommercePriceListRel commercePriceListRel =
			new CommercePriceListRelImpl();

		commercePriceListRel.setNew(true);
		commercePriceListRel.setPrimaryKey(commercePriceListRelId);

		String uuid = PortalUUIDUtil.generate();

		commercePriceListRel.setUuid(uuid);

		commercePriceListRel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return commercePriceListRel;
	}

	/**
	 * Removes the commerce price list rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListRel remove(long commercePriceListRelId)
		throws NoSuchPriceListRelException {

		return remove((Serializable)commercePriceListRelId);
	}

	/**
	 * Removes the commerce price list rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce price list rel
	 * @return the commerce price list rel that was removed
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListRel remove(Serializable primaryKey)
		throws NoSuchPriceListRelException {

		Session session = null;

		try {
			session = openSession();

			CommercePriceListRel commercePriceListRel =
				(CommercePriceListRel)session.get(
					CommercePriceListRelImpl.class, primaryKey);

			if (commercePriceListRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriceListRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercePriceListRel);
		}
		catch (NoSuchPriceListRelException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CommercePriceListRel removeImpl(
		CommercePriceListRel commercePriceListRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercePriceListRel)) {
				commercePriceListRel = (CommercePriceListRel)session.get(
					CommercePriceListRelImpl.class,
					commercePriceListRel.getPrimaryKeyObj());
			}

			if (commercePriceListRel != null) {
				session.delete(commercePriceListRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commercePriceListRel != null) {
			clearCache(commercePriceListRel);
		}

		return commercePriceListRel;
	}

	@Override
	public CommercePriceListRel updateImpl(
		CommercePriceListRel commercePriceListRel) {

		boolean isNew = commercePriceListRel.isNew();

		if (!(commercePriceListRel instanceof CommercePriceListRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commercePriceListRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					commercePriceListRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercePriceListRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommercePriceListRel implementation " +
					commercePriceListRel.getClass());
		}

		CommercePriceListRelModelImpl commercePriceListRelModelImpl =
			(CommercePriceListRelModelImpl)commercePriceListRel;

		if (Validator.isNull(commercePriceListRel.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commercePriceListRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (commercePriceListRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				commercePriceListRel.setCreateDate(now);
			}
			else {
				commercePriceListRel.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commercePriceListRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commercePriceListRel.setModifiedDate(now);
			}
			else {
				commercePriceListRel.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commercePriceListRel.isNew()) {
				session.save(commercePriceListRel);

				commercePriceListRel.setNew(false);
			}
			else {
				commercePriceListRel = (CommercePriceListRel)session.merge(
					commercePriceListRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommercePriceListRelModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				commercePriceListRelModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				commercePriceListRelModelImpl.getUuid(),
				commercePriceListRelModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				commercePriceListRelModelImpl.getCommercePriceListId()
			};

			finderCache.removeResult(
				_finderPathCountByCommercePriceListId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCommercePriceListId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((commercePriceListRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceListRelModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {commercePriceListRelModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((commercePriceListRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceListRelModelImpl.getOriginalUuid(),
					commercePriceListRelModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					commercePriceListRelModelImpl.getUuid(),
					commercePriceListRelModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((commercePriceListRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCommercePriceListId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePriceListRelModelImpl.
						getOriginalCommercePriceListId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceListId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceListId,
					args);

				args = new Object[] {
					commercePriceListRelModelImpl.getCommercePriceListId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceListId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceListId,
					args);
			}
		}

		entityCache.putResult(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			commercePriceListRel.getPrimaryKey(), commercePriceListRel, false);

		clearUniqueFindersCache(commercePriceListRelModelImpl, false);
		cacheUniqueFindersCache(commercePriceListRelModelImpl);

		commercePriceListRel.resetOriginalValues();

		return commercePriceListRel;
	}

	/**
	 * Returns the commerce price list rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price list rel
	 * @return the commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriceListRelException {

		CommercePriceListRel commercePriceListRel = fetchByPrimaryKey(
			primaryKey);

		if (commercePriceListRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriceListRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercePriceListRel;
	}

	/**
	 * Returns the commerce price list rel with the primary key or throws a <code>NoSuchPriceListRelException</code> if it could not be found.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel
	 * @throws NoSuchPriceListRelException if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListRel findByPrimaryKey(long commercePriceListRelId)
		throws NoSuchPriceListRelException {

		return findByPrimaryKey((Serializable)commercePriceListRelId);
	}

	/**
	 * Returns the commerce price list rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price list rel
	 * @return the commerce price list rel, or <code>null</code> if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListRel fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommercePriceListRel commercePriceListRel =
			(CommercePriceListRel)serializable;

		if (commercePriceListRel == null) {
			Session session = null;

			try {
				session = openSession();

				commercePriceListRel = (CommercePriceListRel)session.get(
					CommercePriceListRelImpl.class, primaryKey);

				if (commercePriceListRel != null) {
					cacheResult(commercePriceListRel);
				}
				else {
					entityCache.putResult(
						CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
						CommercePriceListRelImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListRelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commercePriceListRel;
	}

	/**
	 * Returns the commerce price list rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceListRelId the primary key of the commerce price list rel
	 * @return the commerce price list rel, or <code>null</code> if a commerce price list rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListRel fetchByPrimaryKey(long commercePriceListRelId) {
		return fetchByPrimaryKey((Serializable)commercePriceListRelId);
	}

	@Override
	public Map<Serializable, CommercePriceListRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommercePriceListRel> map =
			new HashMap<Serializable, CommercePriceListRel>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommercePriceListRel commercePriceListRel = fetchByPrimaryKey(
				primaryKey);

			if (commercePriceListRel != null) {
				map.put(primaryKey, commercePriceListRel);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListRelImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CommercePriceListRel)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMMERCEPRICELISTREL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CommercePriceListRel commercePriceListRel :
					(List<CommercePriceListRel>)q.list()) {

				map.put(
					commercePriceListRel.getPrimaryKeyObj(),
					commercePriceListRel);

				cacheResult(commercePriceListRel);

				uncachedPrimaryKeys.remove(
					commercePriceListRel.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListRelImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the commerce price list rels.
	 *
	 * @return the commerce price list rels
	 */
	@Override
	public List<CommercePriceListRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CommercePriceListRel> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CommercePriceListRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CommercePriceListRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CommercePriceListRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMERCEPRICELISTREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCEPRICELISTREL;

				sql = sql.concat(CommercePriceListRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<CommercePriceListRel>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the commerce price list rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommercePriceListRel commercePriceListRel : findAll()) {
			remove(commercePriceListRel);
		}
	}

	/**
	 * Returns the number of commerce price list rels.
	 *
	 * @return the number of commerce price list rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMERCEPRICELISTREL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommercePriceListRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce price list rel persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CommercePriceListRelModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceListRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CommercePriceListRelModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceListRelModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceListRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCommercePriceListId = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommercePriceListId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCommercePriceListId = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCommercePriceListId", new String[] {Long.class.getName()},
			CommercePriceListRelModelImpl.COMMERCEPRICELISTID_COLUMN_BITMASK |
			CommercePriceListRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByCommercePriceListId = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCommercePriceListId", new String[] {Long.class.getName()});

		_finderPathFetchByC_CN = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListRelImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_CN",
			new String[] {Long.class.getName(), Long.class.getName()},
			CommercePriceListRelModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			CommercePriceListRelModelImpl.COMMERCEPRICELISTID_COLUMN_BITMASK);

		_finderPathCountByC_CN = new FinderPath(
			CommercePriceListRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_CN",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CommercePriceListRelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMMERCEPRICELISTREL =
		"SELECT commercePriceListRel FROM CommercePriceListRel commercePriceListRel";

	private static final String _SQL_SELECT_COMMERCEPRICELISTREL_WHERE_PKS_IN =
		"SELECT commercePriceListRel FROM CommercePriceListRel commercePriceListRel WHERE commercePriceListRelId IN (";

	private static final String _SQL_SELECT_COMMERCEPRICELISTREL_WHERE =
		"SELECT commercePriceListRel FROM CommercePriceListRel commercePriceListRel WHERE ";

	private static final String _SQL_COUNT_COMMERCEPRICELISTREL =
		"SELECT COUNT(commercePriceListRel) FROM CommercePriceListRel commercePriceListRel";

	private static final String _SQL_COUNT_COMMERCEPRICELISTREL_WHERE =
		"SELECT COUNT(commercePriceListRel) FROM CommercePriceListRel commercePriceListRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"commercePriceListRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommercePriceListRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommercePriceListRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceListRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "order"});

}