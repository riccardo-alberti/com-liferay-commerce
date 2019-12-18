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

import com.liferay.commerce.price.list.exception.NoSuchPriceListContractRelException;
import com.liferay.commerce.price.list.model.CommercePriceListContractRel;
import com.liferay.commerce.price.list.model.impl.CommercePriceListContractRelImpl;
import com.liferay.commerce.price.list.model.impl.CommercePriceListContractRelModelImpl;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListContractRelPersistence;
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
 * The persistence implementation for the commerce price list contract rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class CommercePriceListContractRelPersistenceImpl
	extends BasePersistenceImpl<CommercePriceListContractRel>
	implements CommercePriceListContractRelPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercePriceListContractRelUtil</code> to access the commerce price list contract rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercePriceListContractRelImpl.class.getName();

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
	 * Returns all the commerce price list contract rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list contract rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @return the range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		List<CommercePriceListContractRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListContractRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListContractRel commercePriceListContractRel :
						list) {

					if (!uuid.equals(commercePriceListContractRel.getUuid())) {
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

			query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
				query.append(
					CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommercePriceListContractRel>)QueryUtil.list(
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
	 * Returns the first commerce price list contract rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByUuid_First(
			String uuid,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (commercePriceListContractRel != null) {
			return commercePriceListContractRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceListContractRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list contract rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByUuid_First(
		String uuid,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		List<CommercePriceListContractRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list contract rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByUuid_Last(
			String uuid,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (commercePriceListContractRel != null) {
			return commercePriceListContractRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceListContractRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list contract rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListContractRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price list contract rels before and after the current commerce price list contract rel in the ordered set where uuid = &#63;.
	 *
	 * @param commercePriceListContractRelId the primary key of the current commerce price list contract rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel[] findByUuid_PrevAndNext(
			long commercePriceListContractRelId, String uuid,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		uuid = Objects.toString(uuid, "");

		CommercePriceListContractRel commercePriceListContractRel =
			findByPrimaryKey(commercePriceListContractRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListContractRel[] array =
				new CommercePriceListContractRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commercePriceListContractRel, uuid, orderByComparator,
				true);

			array[1] = commercePriceListContractRel;

			array[2] = getByUuid_PrevAndNext(
				session, commercePriceListContractRel, uuid, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePriceListContractRel getByUuid_PrevAndNext(
		Session session,
		CommercePriceListContractRel commercePriceListContractRel, String uuid,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
			query.append(CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
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
						commercePriceListContractRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListContractRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list contract rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommercePriceListContractRel commercePriceListContractRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commercePriceListContractRel);
		}
	}

	/**
	 * Returns the number of commerce price list contract rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce price list contract rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
		"commercePriceListContractRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commercePriceListContractRel.uuid IS NULL OR commercePriceListContractRel.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the commerce price list contract rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list contract rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @return the range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		List<CommercePriceListContractRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListContractRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListContractRel commercePriceListContractRel :
						list) {

					if (!uuid.equals(commercePriceListContractRel.getUuid()) ||
						(companyId !=
							commercePriceListContractRel.getCompanyId())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
				query.append(
					CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommercePriceListContractRel>)QueryUtil.list(
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
	 * Returns the first commerce price list contract rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (commercePriceListContractRel != null) {
			return commercePriceListContractRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceListContractRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list contract rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		List<CommercePriceListContractRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list contract rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (commercePriceListContractRel != null) {
			return commercePriceListContractRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceListContractRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list contract rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListContractRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price list contract rels before and after the current commerce price list contract rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commercePriceListContractRelId the primary key of the current commerce price list contract rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel[] findByUuid_C_PrevAndNext(
			long commercePriceListContractRelId, String uuid, long companyId,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		uuid = Objects.toString(uuid, "");

		CommercePriceListContractRel commercePriceListContractRel =
			findByPrimaryKey(commercePriceListContractRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListContractRel[] array =
				new CommercePriceListContractRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commercePriceListContractRel, uuid, companyId,
				orderByComparator, true);

			array[1] = commercePriceListContractRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, commercePriceListContractRel, uuid, companyId,
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

	protected CommercePriceListContractRel getByUuid_C_PrevAndNext(
		Session session,
		CommercePriceListContractRel commercePriceListContractRel, String uuid,
		long companyId,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
			query.append(CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
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
						commercePriceListContractRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListContractRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list contract rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommercePriceListContractRel commercePriceListContractRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceListContractRel);
		}
	}

	/**
	 * Returns the number of commerce price list contract rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce price list contract rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
		"commercePriceListContractRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commercePriceListContractRel.uuid IS NULL OR commercePriceListContractRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commercePriceListContractRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCommercePriceListId;
	private FinderPath _finderPathWithoutPaginationFindByCommercePriceListId;
	private FinderPath _finderPathCountByCommercePriceListId;

	/**
	 * Returns all the commerce price list contract rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByCommercePriceListId(
		long commercePriceListId) {

		return findByCommercePriceListId(
			commercePriceListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list contract rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @return the range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end) {

		return findByCommercePriceListId(commercePriceListId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		return findByCommercePriceListId(
			commercePriceListId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		List<CommercePriceListContractRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListContractRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListContractRel commercePriceListContractRel :
						list) {

					if (commercePriceListId !=
							commercePriceListContractRel.
								getCommercePriceListId()) {

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

			query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

			query.append(
				_FINDER_COLUMN_COMMERCEPRICELISTID_COMMERCEPRICELISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(
					CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceListId);

				list = (List<CommercePriceListContractRel>)QueryUtil.list(
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
	 * Returns the first commerce price list contract rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByCommercePriceListId_First(
			long commercePriceListId,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByCommercePriceListId_First(
				commercePriceListId, orderByComparator);

		if (commercePriceListContractRel != null) {
			return commercePriceListContractRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceListId=");
		msg.append(commercePriceListId);

		msg.append("}");

		throw new NoSuchPriceListContractRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list contract rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByCommercePriceListId_First(
		long commercePriceListId,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		List<CommercePriceListContractRel> list = findByCommercePriceListId(
			commercePriceListId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list contract rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByCommercePriceListId_Last(
			long commercePriceListId,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByCommercePriceListId_Last(
				commercePriceListId, orderByComparator);

		if (commercePriceListContractRel != null) {
			return commercePriceListContractRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceListId=");
		msg.append(commercePriceListId);

		msg.append("}");

		throw new NoSuchPriceListContractRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list contract rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByCommercePriceListId_Last(
		long commercePriceListId,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		int count = countByCommercePriceListId(commercePriceListId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListContractRel> list = findByCommercePriceListId(
			commercePriceListId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price list contract rels before and after the current commerce price list contract rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListContractRelId the primary key of the current commerce price list contract rel
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel[] findByCommercePriceListId_PrevAndNext(
			long commercePriceListContractRelId, long commercePriceListId,
			OrderByComparator<CommercePriceListContractRel> orderByComparator)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			findByPrimaryKey(commercePriceListContractRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListContractRel[] array =
				new CommercePriceListContractRelImpl[3];

			array[0] = getByCommercePriceListId_PrevAndNext(
				session, commercePriceListContractRel, commercePriceListId,
				orderByComparator, true);

			array[1] = commercePriceListContractRel;

			array[2] = getByCommercePriceListId_PrevAndNext(
				session, commercePriceListContractRel, commercePriceListId,
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

	protected CommercePriceListContractRel getByCommercePriceListId_PrevAndNext(
		Session session,
		CommercePriceListContractRel commercePriceListContractRel,
		long commercePriceListId,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
			query.append(CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
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
						commercePriceListContractRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListContractRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list contract rels where commercePriceListId = &#63; from the database.
	 *
	 * @param commercePriceListId the commerce price list ID
	 */
	@Override
	public void removeByCommercePriceListId(long commercePriceListId) {
		for (CommercePriceListContractRel commercePriceListContractRel :
				findByCommercePriceListId(
					commercePriceListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceListContractRel);
		}
	}

	/**
	 * Returns the number of commerce price list contract rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list contract rels
	 */
	@Override
	public int countByCommercePriceListId(long commercePriceListId) {
		FinderPath finderPath = _finderPathCountByCommercePriceListId;

		Object[] finderArgs = new Object[] {commercePriceListId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCONTRACTREL_WHERE);

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
			"commercePriceListContractRel.commercePriceListId = ?";

	private FinderPath _finderPathFetchByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns the commerce price list contract rel where commerceContractId = &#63; and commercePriceListId = &#63; or throws a <code>NoSuchPriceListContractRelException</code> if it could not be found.
	 *
	 * @param commerceContractId the commerce contract ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel findByC_C(
			long commerceContractId, long commercePriceListId)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel = fetchByC_C(
			commerceContractId, commercePriceListId);

		if (commercePriceListContractRel == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("commerceContractId=");
			msg.append(commerceContractId);

			msg.append(", commercePriceListId=");
			msg.append(commercePriceListId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPriceListContractRelException(msg.toString());
		}

		return commercePriceListContractRel;
	}

	/**
	 * Returns the commerce price list contract rel where commerceContractId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commerceContractId the commerce contract ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByC_C(
		long commerceContractId, long commercePriceListId) {

		return fetchByC_C(commerceContractId, commercePriceListId, true);
	}

	/**
	 * Returns the commerce price list contract rel where commerceContractId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commerceContractId the commerce contract ID
	 * @param commercePriceListId the commerce price list ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price list contract rel, or <code>null</code> if a matching commerce price list contract rel could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByC_C(
		long commerceContractId, long commercePriceListId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {commerceContractId, commercePriceListId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_C, finderArgs, this);
		}

		if (result instanceof CommercePriceListContractRel) {
			CommercePriceListContractRel commercePriceListContractRel =
				(CommercePriceListContractRel)result;

			if ((commerceContractId !=
					commercePriceListContractRel.getCommerceContractId()) ||
				(commercePriceListId !=
					commercePriceListContractRel.getCommercePriceListId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMMERCECONTRACTID_2);

			query.append(_FINDER_COLUMN_C_C_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commerceContractId);

				qPos.add(commercePriceListId);

				List<CommercePriceListContractRel> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_C, finderArgs, list);
					}
				}
				else {
					CommercePriceListContractRel commercePriceListContractRel =
						list.get(0);

					result = commercePriceListContractRel;

					cacheResult(commercePriceListContractRel);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByC_C, finderArgs);
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
			return (CommercePriceListContractRel)result;
		}
	}

	/**
	 * Removes the commerce price list contract rel where commerceContractId = &#63; and commercePriceListId = &#63; from the database.
	 *
	 * @param commerceContractId the commerce contract ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the commerce price list contract rel that was removed
	 */
	@Override
	public CommercePriceListContractRel removeByC_C(
			long commerceContractId, long commercePriceListId)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel = findByC_C(
			commerceContractId, commercePriceListId);

		return remove(commercePriceListContractRel);
	}

	/**
	 * Returns the number of commerce price list contract rels where commerceContractId = &#63; and commercePriceListId = &#63;.
	 *
	 * @param commerceContractId the commerce contract ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list contract rels
	 */
	@Override
	public int countByC_C(long commerceContractId, long commercePriceListId) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {
			commerceContractId, commercePriceListId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCONTRACTREL_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMMERCECONTRACTID_2);

			query.append(_FINDER_COLUMN_C_C_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commerceContractId);

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

	private static final String _FINDER_COLUMN_C_C_COMMERCECONTRACTID_2 =
		"commercePriceListContractRel.commerceContractId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_COMMERCEPRICELISTID_2 =
		"commercePriceListContractRel.commercePriceListId = ?";

	public CommercePriceListContractRelPersistenceImpl() {
		setModelClass(CommercePriceListContractRel.class);

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
	 * Caches the commerce price list contract rel in the entity cache if it is enabled.
	 *
	 * @param commercePriceListContractRel the commerce price list contract rel
	 */
	@Override
	public void cacheResult(
		CommercePriceListContractRel commercePriceListContractRel) {

		entityCache.putResult(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			commercePriceListContractRel.getPrimaryKey(),
			commercePriceListContractRel);

		finderCache.putResult(
			_finderPathFetchByC_C,
			new Object[] {
				commercePriceListContractRel.getCommerceContractId(),
				commercePriceListContractRel.getCommercePriceListId()
			},
			commercePriceListContractRel);

		commercePriceListContractRel.resetOriginalValues();
	}

	/**
	 * Caches the commerce price list contract rels in the entity cache if it is enabled.
	 *
	 * @param commercePriceListContractRels the commerce price list contract rels
	 */
	@Override
	public void cacheResult(
		List<CommercePriceListContractRel> commercePriceListContractRels) {

		for (CommercePriceListContractRel commercePriceListContractRel :
				commercePriceListContractRels) {

			if (entityCache.getResult(
					CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListContractRelImpl.class,
					commercePriceListContractRel.getPrimaryKey()) == null) {

				cacheResult(commercePriceListContractRel);
			}
			else {
				commercePriceListContractRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commerce price list contract rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercePriceListContractRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce price list contract rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		CommercePriceListContractRel commercePriceListContractRel) {

		entityCache.removeResult(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			commercePriceListContractRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CommercePriceListContractRelModelImpl)commercePriceListContractRel,
			true);
	}

	@Override
	public void clearCache(
		List<CommercePriceListContractRel> commercePriceListContractRels) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommercePriceListContractRel commercePriceListContractRel :
				commercePriceListContractRels) {

			entityCache.removeResult(
				CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListContractRelImpl.class,
				commercePriceListContractRel.getPrimaryKey());

			clearUniqueFindersCache(
				(CommercePriceListContractRelModelImpl)
					commercePriceListContractRel,
				true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListContractRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommercePriceListContractRelModelImpl
			commercePriceListContractRelModelImpl) {

		Object[] args = new Object[] {
			commercePriceListContractRelModelImpl.getCommerceContractId(),
			commercePriceListContractRelModelImpl.getCommercePriceListId()
		};

		finderCache.putResult(
			_finderPathCountByC_C, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_C, args, commercePriceListContractRelModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		CommercePriceListContractRelModelImpl
			commercePriceListContractRelModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				commercePriceListContractRelModelImpl.getCommerceContractId(),
				commercePriceListContractRelModelImpl.getCommercePriceListId()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}

		if ((commercePriceListContractRelModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_C.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commercePriceListContractRelModelImpl.
					getOriginalCommerceContractId(),
				commercePriceListContractRelModelImpl.
					getOriginalCommercePriceListId()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}
	}

	/**
	 * Creates a new commerce price list contract rel with the primary key. Does not add the commerce price list contract rel to the database.
	 *
	 * @param commercePriceListContractRelId the primary key for the new commerce price list contract rel
	 * @return the new commerce price list contract rel
	 */
	@Override
	public CommercePriceListContractRel create(
		long commercePriceListContractRelId) {

		CommercePriceListContractRel commercePriceListContractRel =
			new CommercePriceListContractRelImpl();

		commercePriceListContractRel.setNew(true);
		commercePriceListContractRel.setPrimaryKey(
			commercePriceListContractRelId);

		String uuid = PortalUUIDUtil.generate();

		commercePriceListContractRel.setUuid(uuid);

		commercePriceListContractRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return commercePriceListContractRel;
	}

	/**
	 * Removes the commerce price list contract rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListContractRelId the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel that was removed
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel remove(
			long commercePriceListContractRelId)
		throws NoSuchPriceListContractRelException {

		return remove((Serializable)commercePriceListContractRelId);
	}

	/**
	 * Removes the commerce price list contract rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel that was removed
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel remove(Serializable primaryKey)
		throws NoSuchPriceListContractRelException {

		Session session = null;

		try {
			session = openSession();

			CommercePriceListContractRel commercePriceListContractRel =
				(CommercePriceListContractRel)session.get(
					CommercePriceListContractRelImpl.class, primaryKey);

			if (commercePriceListContractRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriceListContractRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercePriceListContractRel);
		}
		catch (NoSuchPriceListContractRelException nsee) {
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
	protected CommercePriceListContractRel removeImpl(
		CommercePriceListContractRel commercePriceListContractRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercePriceListContractRel)) {
				commercePriceListContractRel =
					(CommercePriceListContractRel)session.get(
						CommercePriceListContractRelImpl.class,
						commercePriceListContractRel.getPrimaryKeyObj());
			}

			if (commercePriceListContractRel != null) {
				session.delete(commercePriceListContractRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commercePriceListContractRel != null) {
			clearCache(commercePriceListContractRel);
		}

		return commercePriceListContractRel;
	}

	@Override
	public CommercePriceListContractRel updateImpl(
		CommercePriceListContractRel commercePriceListContractRel) {

		boolean isNew = commercePriceListContractRel.isNew();

		if (!(commercePriceListContractRel instanceof
				CommercePriceListContractRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					commercePriceListContractRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					commercePriceListContractRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercePriceListContractRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommercePriceListContractRel implementation " +
					commercePriceListContractRel.getClass());
		}

		CommercePriceListContractRelModelImpl
			commercePriceListContractRelModelImpl =
				(CommercePriceListContractRelModelImpl)
					commercePriceListContractRel;

		if (Validator.isNull(commercePriceListContractRel.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commercePriceListContractRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (commercePriceListContractRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				commercePriceListContractRel.setCreateDate(now);
			}
			else {
				commercePriceListContractRel.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commercePriceListContractRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commercePriceListContractRel.setModifiedDate(now);
			}
			else {
				commercePriceListContractRel.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commercePriceListContractRel.isNew()) {
				session.save(commercePriceListContractRel);

				commercePriceListContractRel.setNew(false);
			}
			else {
				commercePriceListContractRel =
					(CommercePriceListContractRel)session.merge(
						commercePriceListContractRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommercePriceListContractRelModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				commercePriceListContractRelModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				commercePriceListContractRelModelImpl.getUuid(),
				commercePriceListContractRelModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				commercePriceListContractRelModelImpl.getCommercePriceListId()
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
			if ((commercePriceListContractRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceListContractRelModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {
					commercePriceListContractRelModelImpl.getUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((commercePriceListContractRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceListContractRelModelImpl.getOriginalUuid(),
					commercePriceListContractRelModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					commercePriceListContractRelModelImpl.getUuid(),
					commercePriceListContractRelModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((commercePriceListContractRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCommercePriceListId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePriceListContractRelModelImpl.
						getOriginalCommercePriceListId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceListId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceListId,
					args);

				args = new Object[] {
					commercePriceListContractRelModelImpl.
						getCommercePriceListId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceListId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceListId,
					args);
			}
		}

		entityCache.putResult(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			commercePriceListContractRel.getPrimaryKey(),
			commercePriceListContractRel, false);

		clearUniqueFindersCache(commercePriceListContractRelModelImpl, false);
		cacheUniqueFindersCache(commercePriceListContractRelModelImpl);

		commercePriceListContractRel.resetOriginalValues();

		return commercePriceListContractRel;
	}

	/**
	 * Returns the commerce price list contract rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchPriceListContractRelException {

		CommercePriceListContractRel commercePriceListContractRel =
			fetchByPrimaryKey(primaryKey);

		if (commercePriceListContractRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriceListContractRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercePriceListContractRel;
	}

	/**
	 * Returns the commerce price list contract rel with the primary key or throws a <code>NoSuchPriceListContractRelException</code> if it could not be found.
	 *
	 * @param commercePriceListContractRelId the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel
	 * @throws NoSuchPriceListContractRelException if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel findByPrimaryKey(
			long commercePriceListContractRelId)
		throws NoSuchPriceListContractRelException {

		return findByPrimaryKey((Serializable)commercePriceListContractRelId);
	}

	/**
	 * Returns the commerce price list contract rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel, or <code>null</code> if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByPrimaryKey(
		Serializable primaryKey) {

		Serializable serializable = entityCache.getResult(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommercePriceListContractRel commercePriceListContractRel =
			(CommercePriceListContractRel)serializable;

		if (commercePriceListContractRel == null) {
			Session session = null;

			try {
				session = openSession();

				commercePriceListContractRel =
					(CommercePriceListContractRel)session.get(
						CommercePriceListContractRelImpl.class, primaryKey);

				if (commercePriceListContractRel != null) {
					cacheResult(commercePriceListContractRel);
				}
				else {
					entityCache.putResult(
						CommercePriceListContractRelModelImpl.
							ENTITY_CACHE_ENABLED,
						CommercePriceListContractRelImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListContractRelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commercePriceListContractRel;
	}

	/**
	 * Returns the commerce price list contract rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceListContractRelId the primary key of the commerce price list contract rel
	 * @return the commerce price list contract rel, or <code>null</code> if a commerce price list contract rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListContractRel fetchByPrimaryKey(
		long commercePriceListContractRelId) {

		return fetchByPrimaryKey((Serializable)commercePriceListContractRelId);
	}

	@Override
	public Map<Serializable, CommercePriceListContractRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommercePriceListContractRel> map =
			new HashMap<Serializable, CommercePriceListContractRel>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommercePriceListContractRel commercePriceListContractRel =
				fetchByPrimaryKey(primaryKey);

			if (commercePriceListContractRel != null) {
				map.put(primaryKey, commercePriceListContractRel);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListContractRelImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(
						primaryKey, (CommercePriceListContractRel)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE_PKS_IN);

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

			for (CommercePriceListContractRel commercePriceListContractRel :
					(List<CommercePriceListContractRel>)q.list()) {

				map.put(
					commercePriceListContractRel.getPrimaryKeyObj(),
					commercePriceListContractRel);

				cacheResult(commercePriceListContractRel);

				uncachedPrimaryKeys.remove(
					commercePriceListContractRel.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListContractRelImpl.class, primaryKey,
					nullModel);
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
	 * Returns all the commerce price list contract rels.
	 *
	 * @return the commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list contract rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @return the range of commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list contract rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListContractRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list contract rels
	 * @param end the upper bound of the range of commerce price list contract rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce price list contract rels
	 */
	@Override
	public List<CommercePriceListContractRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListContractRel> orderByComparator,
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

		List<CommercePriceListContractRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListContractRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCEPRICELISTCONTRACTREL;

				sql = sql.concat(
					CommercePriceListContractRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<CommercePriceListContractRel>)QueryUtil.list(
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
	 * Removes all the commerce price list contract rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommercePriceListContractRel commercePriceListContractRel :
				findAll()) {

			remove(commercePriceListContractRel);
		}
	}

	/**
	 * Returns the number of commerce price list contract rels.
	 *
	 * @return the number of commerce price list contract rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_COMMERCEPRICELISTCONTRACTREL);

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
		return CommercePriceListContractRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce price list contract rel persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CommercePriceListContractRelModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceListContractRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CommercePriceListContractRelModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceListContractRelModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceListContractRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCommercePriceListId = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommercePriceListId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCommercePriceListId = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCommercePriceListId", new String[] {Long.class.getName()},
			CommercePriceListContractRelModelImpl.
				COMMERCEPRICELISTID_COLUMN_BITMASK |
			CommercePriceListContractRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByCommercePriceListId = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCommercePriceListId", new String[] {Long.class.getName()});

		_finderPathFetchByC_C = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListContractRelImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CommercePriceListContractRelModelImpl.
				COMMERCECONTRACTID_COLUMN_BITMASK |
			CommercePriceListContractRelModelImpl.
				COMMERCEPRICELISTID_COLUMN_BITMASK);

		_finderPathCountByC_C = new FinderPath(
			CommercePriceListContractRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListContractRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(
			CommercePriceListContractRelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMMERCEPRICELISTCONTRACTREL =
		"SELECT commercePriceListContractRel FROM CommercePriceListContractRel commercePriceListContractRel";

	private static final String
		_SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE_PKS_IN =
			"SELECT commercePriceListContractRel FROM CommercePriceListContractRel commercePriceListContractRel WHERE commercePriceListContractRelId IN (";

	private static final String _SQL_SELECT_COMMERCEPRICELISTCONTRACTREL_WHERE =
		"SELECT commercePriceListContractRel FROM CommercePriceListContractRel commercePriceListContractRel WHERE ";

	private static final String _SQL_COUNT_COMMERCEPRICELISTCONTRACTREL =
		"SELECT COUNT(commercePriceListContractRel) FROM CommercePriceListContractRel commercePriceListContractRel";

	private static final String _SQL_COUNT_COMMERCEPRICELISTCONTRACTREL_WHERE =
		"SELECT COUNT(commercePriceListContractRel) FROM CommercePriceListContractRel commercePriceListContractRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"commercePriceListContractRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommercePriceListContractRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommercePriceListContractRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceListContractRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "order"});

}