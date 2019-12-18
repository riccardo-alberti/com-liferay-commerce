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

import com.liferay.commerce.price.list.exception.NoSuchPriceListChannelRelException;
import com.liferay.commerce.price.list.model.CommercePriceListChannelRel;
import com.liferay.commerce.price.list.model.impl.CommercePriceListChannelRelImpl;
import com.liferay.commerce.price.list.model.impl.CommercePriceListChannelRelModelImpl;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListChannelRelPersistence;
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
 * The persistence implementation for the commerce price list channel rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class CommercePriceListChannelRelPersistenceImpl
	extends BasePersistenceImpl<CommercePriceListChannelRel>
	implements CommercePriceListChannelRelPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercePriceListChannelRelUtil</code> to access the commerce price list channel rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercePriceListChannelRelImpl.class.getName();

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
	 * Returns all the commerce price list channel rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list channel rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @return the range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		List<CommercePriceListChannelRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListChannelRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListChannelRel commercePriceListChannelRel :
						list) {

					if (!uuid.equals(commercePriceListChannelRel.getUuid())) {
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

			query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
					CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommercePriceListChannelRel>)QueryUtil.list(
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
	 * Returns the first commerce price list channel rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByUuid_First(
			String uuid,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (commercePriceListChannelRel != null) {
			return commercePriceListChannelRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceListChannelRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list channel rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByUuid_First(
		String uuid,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		List<CommercePriceListChannelRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list channel rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByUuid_Last(
			String uuid,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (commercePriceListChannelRel != null) {
			return commercePriceListChannelRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceListChannelRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list channel rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListChannelRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price list channel rels before and after the current commerce price list channel rel in the ordered set where uuid = &#63;.
	 *
	 * @param commercePriceListChannelRelId the primary key of the current commerce price list channel rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel[] findByUuid_PrevAndNext(
			long commercePriceListChannelRelId, String uuid,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		uuid = Objects.toString(uuid, "");

		CommercePriceListChannelRel commercePriceListChannelRel =
			findByPrimaryKey(commercePriceListChannelRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListChannelRel[] array =
				new CommercePriceListChannelRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commercePriceListChannelRel, uuid, orderByComparator,
				true);

			array[1] = commercePriceListChannelRel;

			array[2] = getByUuid_PrevAndNext(
				session, commercePriceListChannelRel, uuid, orderByComparator,
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

	protected CommercePriceListChannelRel getByUuid_PrevAndNext(
		Session session,
		CommercePriceListChannelRel commercePriceListChannelRel, String uuid,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
			query.append(CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
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
						commercePriceListChannelRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListChannelRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list channel rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommercePriceListChannelRel commercePriceListChannelRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commercePriceListChannelRel);
		}
	}

	/**
	 * Returns the number of commerce price list channel rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce price list channel rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
		"commercePriceListChannelRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commercePriceListChannelRel.uuid IS NULL OR commercePriceListChannelRel.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the commerce price list channel rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list channel rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @return the range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		List<CommercePriceListChannelRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListChannelRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListChannelRel commercePriceListChannelRel :
						list) {

					if (!uuid.equals(commercePriceListChannelRel.getUuid()) ||
						(companyId !=
							commercePriceListChannelRel.getCompanyId())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
					CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommercePriceListChannelRel>)QueryUtil.list(
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
	 * Returns the first commerce price list channel rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (commercePriceListChannelRel != null) {
			return commercePriceListChannelRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceListChannelRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list channel rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		List<CommercePriceListChannelRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list channel rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (commercePriceListChannelRel != null) {
			return commercePriceListChannelRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceListChannelRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list channel rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListChannelRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price list channel rels before and after the current commerce price list channel rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commercePriceListChannelRelId the primary key of the current commerce price list channel rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel[] findByUuid_C_PrevAndNext(
			long commercePriceListChannelRelId, String uuid, long companyId,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		uuid = Objects.toString(uuid, "");

		CommercePriceListChannelRel commercePriceListChannelRel =
			findByPrimaryKey(commercePriceListChannelRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListChannelRel[] array =
				new CommercePriceListChannelRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commercePriceListChannelRel, uuid, companyId,
				orderByComparator, true);

			array[1] = commercePriceListChannelRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, commercePriceListChannelRel, uuid, companyId,
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

	protected CommercePriceListChannelRel getByUuid_C_PrevAndNext(
		Session session,
		CommercePriceListChannelRel commercePriceListChannelRel, String uuid,
		long companyId,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
			query.append(CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
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
						commercePriceListChannelRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListChannelRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list channel rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommercePriceListChannelRel commercePriceListChannelRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceListChannelRel);
		}
	}

	/**
	 * Returns the number of commerce price list channel rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce price list channel rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
		"commercePriceListChannelRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commercePriceListChannelRel.uuid IS NULL OR commercePriceListChannelRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commercePriceListChannelRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCommercePriceListId;
	private FinderPath _finderPathWithoutPaginationFindByCommercePriceListId;
	private FinderPath _finderPathCountByCommercePriceListId;

	/**
	 * Returns all the commerce price list channel rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByCommercePriceListId(
		long commercePriceListId) {

		return findByCommercePriceListId(
			commercePriceListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list channel rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @return the range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end) {

		return findByCommercePriceListId(commercePriceListId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		return findByCommercePriceListId(
			commercePriceListId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels where commercePriceListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findByCommercePriceListId(
		long commercePriceListId, int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		List<CommercePriceListChannelRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListChannelRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceListChannelRel commercePriceListChannelRel :
						list) {

					if (commercePriceListId !=
							commercePriceListChannelRel.
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

			query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

			query.append(
				_FINDER_COLUMN_COMMERCEPRICELISTID_COMMERCEPRICELISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(
					CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceListId);

				list = (List<CommercePriceListChannelRel>)QueryUtil.list(
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
	 * Returns the first commerce price list channel rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByCommercePriceListId_First(
			long commercePriceListId,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByCommercePriceListId_First(
				commercePriceListId, orderByComparator);

		if (commercePriceListChannelRel != null) {
			return commercePriceListChannelRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceListId=");
		msg.append(commercePriceListId);

		msg.append("}");

		throw new NoSuchPriceListChannelRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price list channel rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByCommercePriceListId_First(
		long commercePriceListId,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		List<CommercePriceListChannelRel> list = findByCommercePriceListId(
			commercePriceListId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price list channel rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByCommercePriceListId_Last(
			long commercePriceListId,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByCommercePriceListId_Last(
				commercePriceListId, orderByComparator);

		if (commercePriceListChannelRel != null) {
			return commercePriceListChannelRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceListId=");
		msg.append(commercePriceListId);

		msg.append("}");

		throw new NoSuchPriceListChannelRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price list channel rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByCommercePriceListId_Last(
		long commercePriceListId,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		int count = countByCommercePriceListId(commercePriceListId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceListChannelRel> list = findByCommercePriceListId(
			commercePriceListId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price list channel rels before and after the current commerce price list channel rel in the ordered set where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListChannelRelId the primary key of the current commerce price list channel rel
	 * @param commercePriceListId the commerce price list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel[] findByCommercePriceListId_PrevAndNext(
			long commercePriceListChannelRelId, long commercePriceListId,
			OrderByComparator<CommercePriceListChannelRel> orderByComparator)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			findByPrimaryKey(commercePriceListChannelRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceListChannelRel[] array =
				new CommercePriceListChannelRelImpl[3];

			array[0] = getByCommercePriceListId_PrevAndNext(
				session, commercePriceListChannelRel, commercePriceListId,
				orderByComparator, true);

			array[1] = commercePriceListChannelRel;

			array[2] = getByCommercePriceListId_PrevAndNext(
				session, commercePriceListChannelRel, commercePriceListId,
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

	protected CommercePriceListChannelRel getByCommercePriceListId_PrevAndNext(
		Session session,
		CommercePriceListChannelRel commercePriceListChannelRel,
		long commercePriceListId,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
			query.append(CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
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
						commercePriceListChannelRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceListChannelRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price list channel rels where commercePriceListId = &#63; from the database.
	 *
	 * @param commercePriceListId the commerce price list ID
	 */
	@Override
	public void removeByCommercePriceListId(long commercePriceListId) {
		for (CommercePriceListChannelRel commercePriceListChannelRel :
				findByCommercePriceListId(
					commercePriceListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceListChannelRel);
		}
	}

	/**
	 * Returns the number of commerce price list channel rels where commercePriceListId = &#63;.
	 *
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list channel rels
	 */
	@Override
	public int countByCommercePriceListId(long commercePriceListId) {
		FinderPath finderPath = _finderPathCountByCommercePriceListId;

		Object[] finderArgs = new Object[] {commercePriceListId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCHANNELREL_WHERE);

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
			"commercePriceListChannelRel.commercePriceListId = ?";

	private FinderPath _finderPathFetchByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns the commerce price list channel rel where commerceChannelId = &#63; and commercePriceListId = &#63; or throws a <code>NoSuchPriceListChannelRelException</code> if it could not be found.
	 *
	 * @param commerceChannelId the commerce channel ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByC_C(
			long commerceChannelId, long commercePriceListId)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel = fetchByC_C(
			commerceChannelId, commercePriceListId);

		if (commercePriceListChannelRel == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("commerceChannelId=");
			msg.append(commerceChannelId);

			msg.append(", commercePriceListId=");
			msg.append(commercePriceListId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPriceListChannelRelException(msg.toString());
		}

		return commercePriceListChannelRel;
	}

	/**
	 * Returns the commerce price list channel rel where commerceChannelId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commerceChannelId the commerce channel ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByC_C(
		long commerceChannelId, long commercePriceListId) {

		return fetchByC_C(commerceChannelId, commercePriceListId, true);
	}

	/**
	 * Returns the commerce price list channel rel where commerceChannelId = &#63; and commercePriceListId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commerceChannelId the commerce channel ID
	 * @param commercePriceListId the commerce price list ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price list channel rel, or <code>null</code> if a matching commerce price list channel rel could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByC_C(
		long commerceChannelId, long commercePriceListId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {commerceChannelId, commercePriceListId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_C, finderArgs, this);
		}

		if (result instanceof CommercePriceListChannelRel) {
			CommercePriceListChannelRel commercePriceListChannelRel =
				(CommercePriceListChannelRel)result;

			if ((commerceChannelId !=
					commercePriceListChannelRel.getCommerceChannelId()) ||
				(commercePriceListId !=
					commercePriceListChannelRel.getCommercePriceListId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMMERCECHANNELID_2);

			query.append(_FINDER_COLUMN_C_C_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commerceChannelId);

				qPos.add(commercePriceListId);

				List<CommercePriceListChannelRel> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_C, finderArgs, list);
					}
				}
				else {
					CommercePriceListChannelRel commercePriceListChannelRel =
						list.get(0);

					result = commercePriceListChannelRel;

					cacheResult(commercePriceListChannelRel);
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
			return (CommercePriceListChannelRel)result;
		}
	}

	/**
	 * Removes the commerce price list channel rel where commerceChannelId = &#63; and commercePriceListId = &#63; from the database.
	 *
	 * @param commerceChannelId the commerce channel ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the commerce price list channel rel that was removed
	 */
	@Override
	public CommercePriceListChannelRel removeByC_C(
			long commerceChannelId, long commercePriceListId)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel = findByC_C(
			commerceChannelId, commercePriceListId);

		return remove(commercePriceListChannelRel);
	}

	/**
	 * Returns the number of commerce price list channel rels where commerceChannelId = &#63; and commercePriceListId = &#63;.
	 *
	 * @param commerceChannelId the commerce channel ID
	 * @param commercePriceListId the commerce price list ID
	 * @return the number of matching commerce price list channel rels
	 */
	@Override
	public int countByC_C(long commerceChannelId, long commercePriceListId) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {
			commerceChannelId, commercePriceListId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICELISTCHANNELREL_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMMERCECHANNELID_2);

			query.append(_FINDER_COLUMN_C_C_COMMERCEPRICELISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commerceChannelId);

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

	private static final String _FINDER_COLUMN_C_C_COMMERCECHANNELID_2 =
		"commercePriceListChannelRel.commerceChannelId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_COMMERCEPRICELISTID_2 =
		"commercePriceListChannelRel.commercePriceListId = ?";

	public CommercePriceListChannelRelPersistenceImpl() {
		setModelClass(CommercePriceListChannelRel.class);

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
	 * Caches the commerce price list channel rel in the entity cache if it is enabled.
	 *
	 * @param commercePriceListChannelRel the commerce price list channel rel
	 */
	@Override
	public void cacheResult(
		CommercePriceListChannelRel commercePriceListChannelRel) {

		entityCache.putResult(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			commercePriceListChannelRel.getPrimaryKey(),
			commercePriceListChannelRel);

		finderCache.putResult(
			_finderPathFetchByC_C,
			new Object[] {
				commercePriceListChannelRel.getCommerceChannelId(),
				commercePriceListChannelRel.getCommercePriceListId()
			},
			commercePriceListChannelRel);

		commercePriceListChannelRel.resetOriginalValues();
	}

	/**
	 * Caches the commerce price list channel rels in the entity cache if it is enabled.
	 *
	 * @param commercePriceListChannelRels the commerce price list channel rels
	 */
	@Override
	public void cacheResult(
		List<CommercePriceListChannelRel> commercePriceListChannelRels) {

		for (CommercePriceListChannelRel commercePriceListChannelRel :
				commercePriceListChannelRels) {

			if (entityCache.getResult(
					CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListChannelRelImpl.class,
					commercePriceListChannelRel.getPrimaryKey()) == null) {

				cacheResult(commercePriceListChannelRel);
			}
			else {
				commercePriceListChannelRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commerce price list channel rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercePriceListChannelRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce price list channel rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		CommercePriceListChannelRel commercePriceListChannelRel) {

		entityCache.removeResult(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			commercePriceListChannelRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CommercePriceListChannelRelModelImpl)commercePriceListChannelRel,
			true);
	}

	@Override
	public void clearCache(
		List<CommercePriceListChannelRel> commercePriceListChannelRels) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommercePriceListChannelRel commercePriceListChannelRel :
				commercePriceListChannelRels) {

			entityCache.removeResult(
				CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListChannelRelImpl.class,
				commercePriceListChannelRel.getPrimaryKey());

			clearUniqueFindersCache(
				(CommercePriceListChannelRelModelImpl)
					commercePriceListChannelRel,
				true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListChannelRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommercePriceListChannelRelModelImpl
			commercePriceListChannelRelModelImpl) {

		Object[] args = new Object[] {
			commercePriceListChannelRelModelImpl.getCommerceChannelId(),
			commercePriceListChannelRelModelImpl.getCommercePriceListId()
		};

		finderCache.putResult(
			_finderPathCountByC_C, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_C, args, commercePriceListChannelRelModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		CommercePriceListChannelRelModelImpl
			commercePriceListChannelRelModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				commercePriceListChannelRelModelImpl.getCommerceChannelId(),
				commercePriceListChannelRelModelImpl.getCommercePriceListId()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}

		if ((commercePriceListChannelRelModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_C.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commercePriceListChannelRelModelImpl.
					getOriginalCommerceChannelId(),
				commercePriceListChannelRelModelImpl.
					getOriginalCommercePriceListId()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}
	}

	/**
	 * Creates a new commerce price list channel rel with the primary key. Does not add the commerce price list channel rel to the database.
	 *
	 * @param commercePriceListChannelRelId the primary key for the new commerce price list channel rel
	 * @return the new commerce price list channel rel
	 */
	@Override
	public CommercePriceListChannelRel create(
		long commercePriceListChannelRelId) {

		CommercePriceListChannelRel commercePriceListChannelRel =
			new CommercePriceListChannelRelImpl();

		commercePriceListChannelRel.setNew(true);
		commercePriceListChannelRel.setPrimaryKey(
			commercePriceListChannelRelId);

		String uuid = PortalUUIDUtil.generate();

		commercePriceListChannelRel.setUuid(uuid);

		commercePriceListChannelRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return commercePriceListChannelRel;
	}

	/**
	 * Removes the commerce price list channel rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceListChannelRelId the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel that was removed
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel remove(
			long commercePriceListChannelRelId)
		throws NoSuchPriceListChannelRelException {

		return remove((Serializable)commercePriceListChannelRelId);
	}

	/**
	 * Removes the commerce price list channel rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel that was removed
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel remove(Serializable primaryKey)
		throws NoSuchPriceListChannelRelException {

		Session session = null;

		try {
			session = openSession();

			CommercePriceListChannelRel commercePriceListChannelRel =
				(CommercePriceListChannelRel)session.get(
					CommercePriceListChannelRelImpl.class, primaryKey);

			if (commercePriceListChannelRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriceListChannelRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercePriceListChannelRel);
		}
		catch (NoSuchPriceListChannelRelException nsee) {
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
	protected CommercePriceListChannelRel removeImpl(
		CommercePriceListChannelRel commercePriceListChannelRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercePriceListChannelRel)) {
				commercePriceListChannelRel =
					(CommercePriceListChannelRel)session.get(
						CommercePriceListChannelRelImpl.class,
						commercePriceListChannelRel.getPrimaryKeyObj());
			}

			if (commercePriceListChannelRel != null) {
				session.delete(commercePriceListChannelRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commercePriceListChannelRel != null) {
			clearCache(commercePriceListChannelRel);
		}

		return commercePriceListChannelRel;
	}

	@Override
	public CommercePriceListChannelRel updateImpl(
		CommercePriceListChannelRel commercePriceListChannelRel) {

		boolean isNew = commercePriceListChannelRel.isNew();

		if (!(commercePriceListChannelRel instanceof
				CommercePriceListChannelRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					commercePriceListChannelRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					commercePriceListChannelRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercePriceListChannelRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommercePriceListChannelRel implementation " +
					commercePriceListChannelRel.getClass());
		}

		CommercePriceListChannelRelModelImpl
			commercePriceListChannelRelModelImpl =
				(CommercePriceListChannelRelModelImpl)
					commercePriceListChannelRel;

		if (Validator.isNull(commercePriceListChannelRel.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commercePriceListChannelRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (commercePriceListChannelRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				commercePriceListChannelRel.setCreateDate(now);
			}
			else {
				commercePriceListChannelRel.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commercePriceListChannelRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commercePriceListChannelRel.setModifiedDate(now);
			}
			else {
				commercePriceListChannelRel.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commercePriceListChannelRel.isNew()) {
				session.save(commercePriceListChannelRel);

				commercePriceListChannelRel.setNew(false);
			}
			else {
				commercePriceListChannelRel =
					(CommercePriceListChannelRel)session.merge(
						commercePriceListChannelRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommercePriceListChannelRelModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				commercePriceListChannelRelModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				commercePriceListChannelRelModelImpl.getUuid(),
				commercePriceListChannelRelModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				commercePriceListChannelRelModelImpl.getCommercePriceListId()
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
			if ((commercePriceListChannelRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceListChannelRelModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {
					commercePriceListChannelRelModelImpl.getUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((commercePriceListChannelRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceListChannelRelModelImpl.getOriginalUuid(),
					commercePriceListChannelRelModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					commercePriceListChannelRelModelImpl.getUuid(),
					commercePriceListChannelRelModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((commercePriceListChannelRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCommercePriceListId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePriceListChannelRelModelImpl.
						getOriginalCommercePriceListId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceListId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceListId,
					args);

				args = new Object[] {
					commercePriceListChannelRelModelImpl.
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
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			commercePriceListChannelRel.getPrimaryKey(),
			commercePriceListChannelRel, false);

		clearUniqueFindersCache(commercePriceListChannelRelModelImpl, false);
		cacheUniqueFindersCache(commercePriceListChannelRelModelImpl);

		commercePriceListChannelRel.resetOriginalValues();

		return commercePriceListChannelRel;
	}

	/**
	 * Returns the commerce price list channel rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriceListChannelRelException {

		CommercePriceListChannelRel commercePriceListChannelRel =
			fetchByPrimaryKey(primaryKey);

		if (commercePriceListChannelRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriceListChannelRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercePriceListChannelRel;
	}

	/**
	 * Returns the commerce price list channel rel with the primary key or throws a <code>NoSuchPriceListChannelRelException</code> if it could not be found.
	 *
	 * @param commercePriceListChannelRelId the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel
	 * @throws NoSuchPriceListChannelRelException if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel findByPrimaryKey(
			long commercePriceListChannelRelId)
		throws NoSuchPriceListChannelRelException {

		return findByPrimaryKey((Serializable)commercePriceListChannelRelId);
	}

	/**
	 * Returns the commerce price list channel rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel, or <code>null</code> if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByPrimaryKey(
		Serializable primaryKey) {

		Serializable serializable = entityCache.getResult(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommercePriceListChannelRel commercePriceListChannelRel =
			(CommercePriceListChannelRel)serializable;

		if (commercePriceListChannelRel == null) {
			Session session = null;

			try {
				session = openSession();

				commercePriceListChannelRel =
					(CommercePriceListChannelRel)session.get(
						CommercePriceListChannelRelImpl.class, primaryKey);

				if (commercePriceListChannelRel != null) {
					cacheResult(commercePriceListChannelRel);
				}
				else {
					entityCache.putResult(
						CommercePriceListChannelRelModelImpl.
							ENTITY_CACHE_ENABLED,
						CommercePriceListChannelRelImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListChannelRelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commercePriceListChannelRel;
	}

	/**
	 * Returns the commerce price list channel rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceListChannelRelId the primary key of the commerce price list channel rel
	 * @return the commerce price list channel rel, or <code>null</code> if a commerce price list channel rel with the primary key could not be found
	 */
	@Override
	public CommercePriceListChannelRel fetchByPrimaryKey(
		long commercePriceListChannelRelId) {

		return fetchByPrimaryKey((Serializable)commercePriceListChannelRelId);
	}

	@Override
	public Map<Serializable, CommercePriceListChannelRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommercePriceListChannelRel> map =
			new HashMap<Serializable, CommercePriceListChannelRel>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommercePriceListChannelRel commercePriceListChannelRel =
				fetchByPrimaryKey(primaryKey);

			if (commercePriceListChannelRel != null) {
				map.put(primaryKey, commercePriceListChannelRel);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceListChannelRelImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(
						primaryKey, (CommercePriceListChannelRel)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE_PKS_IN);

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

			for (CommercePriceListChannelRel commercePriceListChannelRel :
					(List<CommercePriceListChannelRel>)q.list()) {

				map.put(
					commercePriceListChannelRel.getPrimaryKeyObj(),
					commercePriceListChannelRel);

				cacheResult(commercePriceListChannelRel);

				uncachedPrimaryKeys.remove(
					commercePriceListChannelRel.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceListChannelRelImpl.class, primaryKey,
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
	 * Returns all the commerce price list channel rels.
	 *
	 * @return the commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price list channel rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @return the range of commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price list channel rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceListChannelRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price list channel rels
	 * @param end the upper bound of the range of commerce price list channel rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce price list channel rels
	 */
	@Override
	public List<CommercePriceListChannelRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceListChannelRel> orderByComparator,
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

		List<CommercePriceListChannelRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceListChannelRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMERCEPRICELISTCHANNELREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCEPRICELISTCHANNELREL;

				sql = sql.concat(
					CommercePriceListChannelRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<CommercePriceListChannelRel>)QueryUtil.list(
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
	 * Removes all the commerce price list channel rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommercePriceListChannelRel commercePriceListChannelRel :
				findAll()) {

			remove(commercePriceListChannelRel);
		}
	}

	/**
	 * Returns the number of commerce price list channel rels.
	 *
	 * @return the number of commerce price list channel rels
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
					_SQL_COUNT_COMMERCEPRICELISTCHANNELREL);

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
		return CommercePriceListChannelRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce price list channel rel persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CommercePriceListChannelRelModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceListChannelRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CommercePriceListChannelRelModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceListChannelRelModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceListChannelRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCommercePriceListId = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommercePriceListId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCommercePriceListId = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCommercePriceListId", new String[] {Long.class.getName()},
			CommercePriceListChannelRelModelImpl.
				COMMERCEPRICELISTID_COLUMN_BITMASK |
			CommercePriceListChannelRelModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByCommercePriceListId = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCommercePriceListId", new String[] {Long.class.getName()});

		_finderPathFetchByC_C = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceListChannelRelImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CommercePriceListChannelRelModelImpl.
				COMMERCECHANNELID_COLUMN_BITMASK |
			CommercePriceListChannelRelModelImpl.
				COMMERCEPRICELISTID_COLUMN_BITMASK);

		_finderPathCountByC_C = new FinderPath(
			CommercePriceListChannelRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceListChannelRelModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(
			CommercePriceListChannelRelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMMERCEPRICELISTCHANNELREL =
		"SELECT commercePriceListChannelRel FROM CommercePriceListChannelRel commercePriceListChannelRel";

	private static final String
		_SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE_PKS_IN =
			"SELECT commercePriceListChannelRel FROM CommercePriceListChannelRel commercePriceListChannelRel WHERE commercePriceListChannelRelId IN (";

	private static final String _SQL_SELECT_COMMERCEPRICELISTCHANNELREL_WHERE =
		"SELECT commercePriceListChannelRel FROM CommercePriceListChannelRel commercePriceListChannelRel WHERE ";

	private static final String _SQL_COUNT_COMMERCEPRICELISTCHANNELREL =
		"SELECT COUNT(commercePriceListChannelRel) FROM CommercePriceListChannelRel commercePriceListChannelRel";

	private static final String _SQL_COUNT_COMMERCEPRICELISTCHANNELREL_WHERE =
		"SELECT COUNT(commercePriceListChannelRel) FROM CommercePriceListChannelRel commercePriceListChannelRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"commercePriceListChannelRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommercePriceListChannelRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommercePriceListChannelRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceListChannelRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "order"});

}