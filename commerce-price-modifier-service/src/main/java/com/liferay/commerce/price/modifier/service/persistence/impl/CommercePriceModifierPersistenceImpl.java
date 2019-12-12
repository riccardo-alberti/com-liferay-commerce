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

package com.liferay.commerce.price.modifier.service.persistence.impl;

import com.liferay.commerce.price.modifier.exception.NoSuchPriceModifierException;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierImpl;
import com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierModelImpl;
import com.liferay.commerce.price.modifier.service.persistence.CommercePriceModifierPersistence;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Arrays;
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
 * The persistence implementation for the commerce price modifier service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Riccardo Alberti
 * @generated
 */
public class CommercePriceModifierPersistenceImpl
	extends BasePersistenceImpl<CommercePriceModifier>
	implements CommercePriceModifierPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercePriceModifierUtil</code> to access the commerce price modifier persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercePriceModifierImpl.class.getName();

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
	 * Returns all the commerce price modifiers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if (!uuid.equals(commercePriceModifier.getUuid())) {
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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

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
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByUuid_First(
			String uuid,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByUuid_First(
			uuid, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByUuid_First(
		String uuid,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByUuid_Last(
			String uuid,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByUuid_Last(
			uuid, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByUuid_Last(
		String uuid,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where uuid = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByUuid_PrevAndNext(
			long commercePriceModifierId, String uuid,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		uuid = Objects.toString(uuid, "");

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, commercePriceModifier, uuid, orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByUuid_PrevAndNext(
				session, commercePriceModifier, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePriceModifier getByUuid_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		String uuid, OrderByComparator<CommercePriceModifier> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
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
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifiers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommercePriceModifier commercePriceModifier :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

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
		"commercePriceModifier.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(commercePriceModifier.uuid IS NULL OR commercePriceModifier.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the commerce price modifier where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPriceModifierException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByUUID_G(String uuid, long groupId)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByUUID_G(
			uuid, groupId);

		if (commercePriceModifier == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPriceModifierException(msg.toString());
		}

		return commercePriceModifier;
	}

	/**
	 * Returns the commerce price modifier where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the commerce price modifier where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof CommercePriceModifier) {
			CommercePriceModifier commercePriceModifier =
				(CommercePriceModifier)result;

			if (!Objects.equals(uuid, commercePriceModifier.getUuid()) ||
				(groupId != commercePriceModifier.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<CommercePriceModifier> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CommercePriceModifier commercePriceModifier = list.get(0);

					result = commercePriceModifier;

					cacheResult(commercePriceModifier);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
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
			return (CommercePriceModifier)result;
		}
	}

	/**
	 * Removes the commerce price modifier where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the commerce price modifier that was removed
	 */
	@Override
	public CommercePriceModifier removeByUUID_G(String uuid, long groupId)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByUUID_G(
			uuid, groupId);

		return remove(commercePriceModifier);
	}

	/**
	 * Returns the number of commerce price modifiers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"commercePriceModifier.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(commercePriceModifier.uuid IS NULL OR commercePriceModifier.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"commercePriceModifier.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the commerce price modifiers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if (!uuid.equals(commercePriceModifier.getUuid()) ||
						(companyId != commercePriceModifier.getCompanyId())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

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
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
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

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByUuid_C_PrevAndNext(
			long commercePriceModifierId, String uuid, long companyId,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		uuid = Objects.toString(uuid, "");

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, commercePriceModifier, uuid, companyId,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByUuid_C_PrevAndNext(
				session, commercePriceModifier, uuid, companyId,
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

	protected CommercePriceModifier getByUuid_C_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		String uuid, long companyId,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
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
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifiers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CommercePriceModifier commercePriceModifier :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

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
		"commercePriceModifier.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(commercePriceModifier.uuid IS NULL OR commercePriceModifier.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"commercePriceModifier.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the commerce price modifiers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if (companyId != commercePriceModifier.getCompanyId()) {
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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByCompanyId_First(
			long companyId,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByCompanyId_First(
		long companyId,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByCompanyId_Last(
			long companyId,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByCompanyId_Last(
		long companyId,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where companyId = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByCompanyId_PrevAndNext(
			long commercePriceModifierId, long companyId,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, commercePriceModifier, companyId, orderByComparator,
				true);

			array[1] = commercePriceModifier;

			array[2] = getByCompanyId_PrevAndNext(
				session, commercePriceModifier, companyId, orderByComparator,
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

	protected CommercePriceModifier getByCompanyId_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		long companyId,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifiers where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (CommercePriceModifier commercePriceModifier :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"commercePriceModifier.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_T;
	private FinderPath _finderPathWithoutPaginationFindByC_T;
	private FinderPath _finderPathCountByC_T;

	/**
	 * Returns all the commerce price modifiers where companyId = &#63; and target = &#63;.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByC_T(
		long companyId, String target) {

		return findByC_T(
			companyId, target, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where companyId = &#63; and target = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByC_T(
		long companyId, String target, int start, int end) {

		return findByC_T(companyId, target, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where companyId = &#63; and target = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByC_T(
		long companyId, String target, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByC_T(
			companyId, target, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where companyId = &#63; and target = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByC_T(
		long companyId, String target, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		target = Objects.toString(target, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_T;
				finderArgs = new Object[] {companyId, target};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_T;
			finderArgs = new Object[] {
				companyId, target, start, end, orderByComparator
			};
		}

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if ((companyId != commercePriceModifier.getCompanyId()) ||
						!target.equals(commercePriceModifier.getTarget())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

			boolean bindTarget = false;

			if (target.isEmpty()) {
				query.append(_FINDER_COLUMN_C_T_TARGET_3);
			}
			else {
				bindTarget = true;

				query.append(_FINDER_COLUMN_C_T_TARGET_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindTarget) {
					qPos.add(target);
				}

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where companyId = &#63; and target = &#63;.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByC_T_First(
			long companyId, String target,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByC_T_First(
			companyId, target, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", target=");
		msg.append(target);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where companyId = &#63; and target = &#63;.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByC_T_First(
		long companyId, String target,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByC_T(
			companyId, target, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where companyId = &#63; and target = &#63;.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByC_T_Last(
			long companyId, String target,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByC_T_Last(
			companyId, target, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", target=");
		msg.append(target);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where companyId = &#63; and target = &#63;.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByC_T_Last(
		long companyId, String target,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByC_T(companyId, target);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByC_T(
			companyId, target, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where companyId = &#63; and target = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param companyId the company ID
	 * @param target the target
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByC_T_PrevAndNext(
			long commercePriceModifierId, long companyId, String target,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		target = Objects.toString(target, "");

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByC_T_PrevAndNext(
				session, commercePriceModifier, companyId, target,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByC_T_PrevAndNext(
				session, commercePriceModifier, companyId, target,
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

	protected CommercePriceModifier getByC_T_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		long companyId, String target,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

		query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

		boolean bindTarget = false;

		if (target.isEmpty()) {
			query.append(_FINDER_COLUMN_C_T_TARGET_3);
		}
		else {
			bindTarget = true;

			query.append(_FINDER_COLUMN_C_T_TARGET_2);
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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindTarget) {
			qPos.add(target);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifiers where companyId = &#63; and target = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 */
	@Override
	public void removeByC_T(long companyId, String target) {
		for (CommercePriceModifier commercePriceModifier :
				findByC_T(
					companyId, target, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where companyId = &#63; and target = &#63;.
	 *
	 * @param companyId the company ID
	 * @param target the target
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByC_T(long companyId, String target) {
		target = Objects.toString(target, "");

		FinderPath finderPath = _finderPathCountByC_T;

		Object[] finderArgs = new Object[] {companyId, target};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_C_T_COMPANYID_2);

			boolean bindTarget = false;

			if (target.isEmpty()) {
				query.append(_FINDER_COLUMN_C_T_TARGET_3);
			}
			else {
				bindTarget = true;

				query.append(_FINDER_COLUMN_C_T_TARGET_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindTarget) {
					qPos.add(target);
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

	private static final String _FINDER_COLUMN_C_T_COMPANYID_2 =
		"commercePriceModifier.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_T_TARGET_2 =
		"commercePriceModifier.target = ?";

	private static final String _FINDER_COLUMN_C_T_TARGET_3 =
		"(commercePriceModifier.target IS NULL OR commercePriceModifier.target = '')";

	private FinderPath _finderPathWithPaginationFindByLtD_S;
	private FinderPath _finderPathWithPaginationCountByLtD_S;

	/**
	 * Returns all the commerce price modifiers where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtD_S(
		Date displayDate, int status) {

		return findByLtD_S(
			displayDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtD_S(
		Date displayDate, int status, int start, int end) {

		return findByLtD_S(displayDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtD_S(
		Date displayDate, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByLtD_S(
			displayDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtD_S(
		Date displayDate, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByLtD_S;
		finderArgs = new Object[] {
			_getTime(displayDate), status, start, end, orderByComparator
		};

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if ((displayDate.getTime() <=
							commercePriceModifier.getDisplayDate().getTime()) ||
						(status != commercePriceModifier.getStatus())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			boolean bindDisplayDate = false;

			if (displayDate == null) {
				query.append(_FINDER_COLUMN_LTD_S_DISPLAYDATE_1);
			}
			else {
				bindDisplayDate = true;

				query.append(_FINDER_COLUMN_LTD_S_DISPLAYDATE_2);
			}

			query.append(_FINDER_COLUMN_LTD_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDisplayDate) {
					qPos.add(new Timestamp(displayDate.getTime()));
				}

				qPos.add(status);

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByLtD_S_First(
			Date displayDate, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByLtD_S_First(
			displayDate, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("displayDate<");
		msg.append(displayDate);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByLtD_S_First(
		Date displayDate, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByLtD_S(
			displayDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByLtD_S_Last(
			Date displayDate, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByLtD_S_Last(
			displayDate, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("displayDate<");
		msg.append(displayDate);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByLtD_S_Last(
		Date displayDate, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByLtD_S(displayDate, status);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByLtD_S(
			displayDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByLtD_S_PrevAndNext(
			long commercePriceModifierId, Date displayDate, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByLtD_S_PrevAndNext(
				session, commercePriceModifier, displayDate, status,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByLtD_S_PrevAndNext(
				session, commercePriceModifier, displayDate, status,
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

	protected CommercePriceModifier getByLtD_S_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		Date displayDate, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

		boolean bindDisplayDate = false;

		if (displayDate == null) {
			query.append(_FINDER_COLUMN_LTD_S_DISPLAYDATE_1);
		}
		else {
			bindDisplayDate = true;

			query.append(_FINDER_COLUMN_LTD_S_DISPLAYDATE_2);
		}

		query.append(_FINDER_COLUMN_LTD_S_STATUS_2);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDisplayDate) {
			qPos.add(new Timestamp(displayDate.getTime()));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifiers where displayDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 */
	@Override
	public void removeByLtD_S(Date displayDate, int status) {
		for (CommercePriceModifier commercePriceModifier :
				findByLtD_S(
					displayDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByLtD_S(Date displayDate, int status) {
		FinderPath finderPath = _finderPathWithPaginationCountByLtD_S;

		Object[] finderArgs = new Object[] {_getTime(displayDate), status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			boolean bindDisplayDate = false;

			if (displayDate == null) {
				query.append(_FINDER_COLUMN_LTD_S_DISPLAYDATE_1);
			}
			else {
				bindDisplayDate = true;

				query.append(_FINDER_COLUMN_LTD_S_DISPLAYDATE_2);
			}

			query.append(_FINDER_COLUMN_LTD_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDisplayDate) {
					qPos.add(new Timestamp(displayDate.getTime()));
				}

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_LTD_S_DISPLAYDATE_1 =
		"commercePriceModifier.displayDate IS NULL AND ";

	private static final String _FINDER_COLUMN_LTD_S_DISPLAYDATE_2 =
		"commercePriceModifier.displayDate < ? AND ";

	private static final String _FINDER_COLUMN_LTD_S_STATUS_2 =
		"commercePriceModifier.status = ?";

	private FinderPath _finderPathWithPaginationFindByLtE_S;
	private FinderPath _finderPathWithPaginationCountByLtE_S;

	/**
	 * Returns all the commerce price modifiers where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtE_S(
		Date expirationDate, int status) {

		return findByLtE_S(
			expirationDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtE_S(
		Date expirationDate, int status, int start, int end) {

		return findByLtE_S(expirationDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtE_S(
		Date expirationDate, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByLtE_S(
			expirationDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByLtE_S(
		Date expirationDate, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByLtE_S;
		finderArgs = new Object[] {
			_getTime(expirationDate), status, start, end, orderByComparator
		};

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if ((expirationDate.getTime() <=
							commercePriceModifier.
								getExpirationDate().getTime()) ||
						(status != commercePriceModifier.getStatus())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			boolean bindExpirationDate = false;

			if (expirationDate == null) {
				query.append(_FINDER_COLUMN_LTE_S_EXPIRATIONDATE_1);
			}
			else {
				bindExpirationDate = true;

				query.append(_FINDER_COLUMN_LTE_S_EXPIRATIONDATE_2);
			}

			query.append(_FINDER_COLUMN_LTE_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExpirationDate) {
					qPos.add(new Timestamp(expirationDate.getTime()));
				}

				qPos.add(status);

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByLtE_S_First(
			Date expirationDate, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByLtE_S_First(
			expirationDate, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expirationDate<");
		msg.append(expirationDate);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByLtE_S_First(
		Date expirationDate, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByLtE_S(
			expirationDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByLtE_S_Last(
			Date expirationDate, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByLtE_S_Last(
			expirationDate, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expirationDate<");
		msg.append(expirationDate);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByLtE_S_Last(
		Date expirationDate, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByLtE_S(expirationDate, status);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByLtE_S(
			expirationDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByLtE_S_PrevAndNext(
			long commercePriceModifierId, Date expirationDate, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByLtE_S_PrevAndNext(
				session, commercePriceModifier, expirationDate, status,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByLtE_S_PrevAndNext(
				session, commercePriceModifier, expirationDate, status,
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

	protected CommercePriceModifier getByLtE_S_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		Date expirationDate, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

		boolean bindExpirationDate = false;

		if (expirationDate == null) {
			query.append(_FINDER_COLUMN_LTE_S_EXPIRATIONDATE_1);
		}
		else {
			bindExpirationDate = true;

			query.append(_FINDER_COLUMN_LTE_S_EXPIRATIONDATE_2);
		}

		query.append(_FINDER_COLUMN_LTE_S_STATUS_2);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindExpirationDate) {
			qPos.add(new Timestamp(expirationDate.getTime()));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifiers where expirationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 */
	@Override
	public void removeByLtE_S(Date expirationDate, int status) {
		for (CommercePriceModifier commercePriceModifier :
				findByLtE_S(
					expirationDate, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByLtE_S(Date expirationDate, int status) {
		FinderPath finderPath = _finderPathWithPaginationCountByLtE_S;

		Object[] finderArgs = new Object[] {_getTime(expirationDate), status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			boolean bindExpirationDate = false;

			if (expirationDate == null) {
				query.append(_FINDER_COLUMN_LTE_S_EXPIRATIONDATE_1);
			}
			else {
				bindExpirationDate = true;

				query.append(_FINDER_COLUMN_LTE_S_EXPIRATIONDATE_2);
			}

			query.append(_FINDER_COLUMN_LTE_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExpirationDate) {
					qPos.add(new Timestamp(expirationDate.getTime()));
				}

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_LTE_S_EXPIRATIONDATE_1 =
		"commercePriceModifier.expirationDate IS NULL AND ";

	private static final String _FINDER_COLUMN_LTE_S_EXPIRATIONDATE_2 =
		"commercePriceModifier.expirationDate < ? AND ";

	private static final String _FINDER_COLUMN_LTE_S_STATUS_2 =
		"commercePriceModifier.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_S;
	private FinderPath _finderPathCountByG_C_S;
	private FinderPath _finderPathWithPaginationCountByG_C_S;

	/**
	 * Returns all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long groupId, long companyId, int status) {

		return findByG_C_S(
			groupId, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long groupId, long companyId, int status, int start, int end) {

		return findByG_C_S(groupId, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long groupId, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByG_C_S(
			groupId, companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long groupId, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_S;
				finderArgs = new Object[] {groupId, companyId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_S;
			finderArgs = new Object[] {
				groupId, companyId, status, start, end, orderByComparator
			};
		}

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if ((groupId != commercePriceModifier.getGroupId()) ||
						(companyId != commercePriceModifier.getCompanyId()) ||
						(status != commercePriceModifier.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByG_C_S_First(
			long groupId, long companyId, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByG_C_S_First(
			groupId, companyId, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByG_C_S_First(
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByG_C_S(
			groupId, companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByG_C_S_Last(
			long groupId, long companyId, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByG_C_S_Last(
			groupId, companyId, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByG_C_S_Last(
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByG_C_S(groupId, companyId, status);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByG_C_S(
			groupId, companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByG_C_S_PrevAndNext(
			long commercePriceModifierId, long groupId, long companyId,
			int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByG_C_S_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByG_C_S_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
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

	protected CommercePriceModifier getByG_C_S_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

		query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_S(
		long groupId, long companyId, int status) {

		return filterFindByG_C_S(
			groupId, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_S(
		long groupId, long companyId, int status, int start, int end) {

		return filterFindByG_C_S(groupId, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers that the user has permissions to view where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_S(
		long groupId, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_S(
				groupId, companyId, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);
		}
		else {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(
					_FILTER_ENTITY_ALIAS, CommercePriceModifierImpl.class);
			}
			else {
				q.addEntity(
					_FILTER_ENTITY_TABLE, CommercePriceModifierImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			qPos.add(status);

			return (List<CommercePriceModifier>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set of commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] filterFindByG_C_S_PrevAndNext(
			long commercePriceModifierId, long groupId, long companyId,
			int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_S_PrevAndNext(
				commercePriceModifierId, groupId, companyId, status,
				orderByComparator);
		}

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = filterGetByG_C_S_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = filterGetByG_C_S_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
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

	protected CommercePriceModifier filterGetByG_C_S_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);
		}
		else {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CommercePriceModifierImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CommercePriceModifierImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_S(
		long[] groupIds, long companyId, int status) {

		return filterFindByG_C_S(
			groupIds, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_S(
		long[] groupIds, long companyId, int status, int start, int end) {

		return filterFindByG_C_S(groupIds, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_S(
		long[] groupIds, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupIds)) {
			return findByG_C_S(
				groupIds, companyId, status, start, end, orderByComparator);
		}

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);
		}
		else {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (groupIds.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_C_S_GROUPID_7);

			query.append(StringUtil.merge(groupIds));

			query.append(")");

			query.append(")");

			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupIds);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(
					_FILTER_ENTITY_ALIAS, CommercePriceModifierImpl.class);
			}
			else {
				q.addEntity(
					_FILTER_ENTITY_TABLE, CommercePriceModifierImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(status);

			return (List<CommercePriceModifier>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the commerce price modifiers where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long[] groupIds, long companyId, int status) {

		return findByG_C_S(
			groupIds, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long[] groupIds, long companyId, int status, int start, int end) {

		return findByG_C_S(groupIds, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long[] groupIds, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByG_C_S(
			groupIds, companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_S(
		long[] groupIds, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		if (groupIds.length == 1) {
			return findByG_C_S(
				groupIds[0], companyId, status, start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(groupIds), companyId, status
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(groupIds), companyId, status, start, end,
				orderByComparator
			};
		}

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				_finderPathWithPaginationFindByG_C_S, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if (!ArrayUtil.contains(
							groupIds, commercePriceModifier.getGroupId()) ||
						(companyId != commercePriceModifier.getCompanyId()) ||
						(status != commercePriceModifier.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			if (groupIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_C_S_GROUPID_7);

				query.append(StringUtil.merge(groupIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CommercePriceModifier>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_C_S, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_C_S, finderArgs);
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
	 * Removes all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByG_C_S(long groupId, long companyId, int status) {
		for (CommercePriceModifier commercePriceModifier :
				findByG_C_S(
					groupId, companyId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByG_C_S(long groupId, long companyId, int status) {
		FinderPath finderPath = _finderPathCountByG_C_S;

		Object[] finderArgs = new Object[] {groupId, companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(status);

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

	/**
	 * Returns the number of commerce price modifiers where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByG_C_S(long[] groupIds, long companyId, int status) {
		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(groupIds), companyId, status
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_C_S, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			if (groupIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_C_S_GROUPID_7);

				query.append(StringUtil.merge(groupIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_C_S, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_C_S, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public int filterCountByG_C_S(long groupId, long companyId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_S(groupId, companyId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

		query.append(_FINDER_COLUMN_G_C_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status = &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public int filterCountByG_C_S(long[] groupIds, long companyId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupIds)) {
			return countByG_C_S(groupIds, companyId, status);
		}

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

		if (groupIds.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_C_S_GROUPID_7);

			query.append(StringUtil.merge(groupIds));

			query.append(")");

			query.append(")");

			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_C_S_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_S_STATUS_2);

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupIds);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_C_S_GROUPID_2 =
		"commercePriceModifier.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_S_GROUPID_7 =
		"commercePriceModifier.groupId IN (";

	private static final String _FINDER_COLUMN_G_C_S_COMPANYID_2 =
		"commercePriceModifier.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_S_STATUS_2 =
		"commercePriceModifier.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_NotS;
	private FinderPath _finderPathWithPaginationCountByG_C_NotS;

	/**
	 * Returns all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long groupId, long companyId, int status) {

		return findByG_C_NotS(
			groupId, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long groupId, long companyId, int status, int start, int end) {

		return findByG_C_NotS(groupId, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long groupId, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByG_C_NotS(
			groupId, companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long groupId, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByG_C_NotS;
		finderArgs = new Object[] {
			groupId, companyId, status, start, end, orderByComparator
		};

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if ((groupId != commercePriceModifier.getGroupId()) ||
						(companyId != commercePriceModifier.getCompanyId()) ||
						(status == commercePriceModifier.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Returns the first commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByG_C_NotS_First(
			long groupId, long companyId, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByG_C_NotS_First(
			groupId, companyId, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status!=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByG_C_NotS_First(
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		List<CommercePriceModifier> list = findByG_C_NotS(
			groupId, companyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByG_C_NotS_Last(
			long groupId, long companyId, int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByG_C_NotS_Last(
			groupId, companyId, status, orderByComparator);

		if (commercePriceModifier != null) {
			return commercePriceModifier;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", status!=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchPriceModifierException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByG_C_NotS_Last(
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		int count = countByG_C_NotS(groupId, companyId, status);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifier> list = findByG_C_NotS(
			groupId, companyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] findByG_C_NotS_PrevAndNext(
			long commercePriceModifierId, long groupId, long companyId,
			int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = getByG_C_NotS_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = getByG_C_NotS_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
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

	protected CommercePriceModifier getByG_C_NotS_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

		query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

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
			query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_NotS(
		long groupId, long companyId, int status) {

		return filterFindByG_C_NotS(
			groupId, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_NotS(
		long groupId, long companyId, int status, int start, int end) {

		return filterFindByG_C_NotS(
			groupId, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers that the user has permissions to view where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_NotS(
		long groupId, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_NotS(
				groupId, companyId, status, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);
		}
		else {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(
					_FILTER_ENTITY_ALIAS, CommercePriceModifierImpl.class);
			}
			else {
				q.addEntity(
					_FILTER_ENTITY_TABLE, CommercePriceModifierImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			qPos.add(status);

			return (List<CommercePriceModifier>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the commerce price modifiers before and after the current commerce price modifier in the ordered set of commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param commercePriceModifierId the primary key of the current commerce price modifier
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier[] filterFindByG_C_NotS_PrevAndNext(
			long commercePriceModifierId, long groupId, long companyId,
			int status,
			OrderByComparator<CommercePriceModifier> orderByComparator)
		throws NoSuchPriceModifierException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_C_NotS_PrevAndNext(
				commercePriceModifierId, groupId, companyId, status,
				orderByComparator);
		}

		CommercePriceModifier commercePriceModifier = findByPrimaryKey(
			commercePriceModifierId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier[] array = new CommercePriceModifierImpl[3];

			array[0] = filterGetByG_C_NotS_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
				orderByComparator, true);

			array[1] = commercePriceModifier;

			array[2] = filterGetByG_C_NotS_PrevAndNext(
				session, commercePriceModifier, groupId, companyId, status,
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

	protected CommercePriceModifier filterGetByG_C_NotS_PrevAndNext(
		Session session, CommercePriceModifier commercePriceModifier,
		long groupId, long companyId, int status,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);
		}
		else {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					query.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CommercePriceModifierImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CommercePriceModifierImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifier)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_NotS(
		long[] groupIds, long companyId, int status) {

		return filterFindByG_C_NotS(
			groupIds, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_NotS(
		long[] groupIds, long companyId, int status, int start, int end) {

		return filterFindByG_C_NotS(
			groupIds, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public List<CommercePriceModifier> filterFindByG_C_NotS(
		long[] groupIds, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupIds)) {
			return findByG_C_NotS(
				groupIds, companyId, status, start, end, orderByComparator);
		}

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);
		}
		else {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (groupIds.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_7);

			query.append(StringUtil.merge(groupIds));

			query.append(")");

			query.append(")");

			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(
				_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupIds);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(
					_FILTER_ENTITY_ALIAS, CommercePriceModifierImpl.class);
			}
			else {
				q.addEntity(
					_FILTER_ENTITY_TABLE, CommercePriceModifierImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(status);

			return (List<CommercePriceModifier>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the commerce price modifiers where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long[] groupIds, long companyId, int status) {

		return findByG_C_NotS(
			groupIds, companyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifiers where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long[] groupIds, long companyId, int status, int start, int end) {

		return findByG_C_NotS(groupIds, companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long[] groupIds, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findByG_C_NotS(
			groupIds, companyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findByG_C_NotS(
		long[] groupIds, long companyId, int status, int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
		boolean useFinderCache) {

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		if (groupIds.length == 1) {
			return findByG_C_NotS(
				groupIds[0], companyId, status, start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					StringUtil.merge(groupIds), companyId, status
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				StringUtil.merge(groupIds), companyId, status, start, end,
				orderByComparator
			};
		}

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				_finderPathWithPaginationFindByG_C_NotS, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifier commercePriceModifier : list) {
					if (!ArrayUtil.contains(
							groupIds, commercePriceModifier.getGroupId()) ||
						(companyId != commercePriceModifier.getCompanyId()) ||
						(status == commercePriceModifier.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			if (groupIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_7);

				query.append(StringUtil.merge(groupIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				list = (List<CommercePriceModifier>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByG_C_NotS, finderArgs,
						list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByG_C_NotS, finderArgs);
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
	 * Removes all the commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 */
	@Override
	public void removeByG_C_NotS(long groupId, long companyId, int status) {
		for (CommercePriceModifier commercePriceModifier :
				findByG_C_NotS(
					groupId, companyId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByG_C_NotS(long groupId, long companyId, int status) {
		FinderPath finderPath = _finderPathWithPaginationCountByG_C_NotS;

		Object[] finderArgs = new Object[] {groupId, companyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(status);

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

	/**
	 * Returns the number of commerce price modifiers where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByG_C_NotS(long[] groupIds, long companyId, int status) {
		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(groupIds), companyId, status
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByG_C_NotS, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			if (groupIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_7);

				query.append(StringUtil.merge(groupIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByG_C_NotS, finderArgs,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByG_C_NotS, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of commerce price modifiers that the user has permission to view where groupId = &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public int filterCountByG_C_NotS(long groupId, long companyId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_C_NotS(groupId, companyId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

		query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(companyId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of commerce price modifiers that the user has permission to view where groupId = any &#63; and companyId = &#63; and status &ne; &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching commerce price modifiers that the user has permission to view
	 */
	@Override
	public int filterCountByG_C_NotS(
		long[] groupIds, long companyId, int status) {

		if (!InlineSQLHelperUtil.isEnabled(groupIds)) {
			return countByG_C_NotS(groupIds, companyId, status);
		}

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

		if (groupIds.length > 0) {
			query.append("(");

			query.append(_FINDER_COLUMN_G_C_NOTS_GROUPID_7);

			query.append(StringUtil.merge(groupIds));

			query.append(")");

			query.append(")");

			query.append(WHERE_AND);
		}

		query.append(_FINDER_COLUMN_G_C_NOTS_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_NOTS_STATUS_2);

		query.setStringAt(
			removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			query.toString(), CommercePriceModifier.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupIds);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_C_NOTS_GROUPID_2 =
		"commercePriceModifier.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_NOTS_GROUPID_7 =
		"commercePriceModifier.groupId IN (";

	private static final String _FINDER_COLUMN_G_C_NOTS_COMPANYID_2 =
		"commercePriceModifier.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_NOTS_STATUS_2 =
		"commercePriceModifier.status != ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the commerce price modifier where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPriceModifierException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching commerce price modifier
	 * @throws NoSuchPriceModifierException if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (commercePriceModifier == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", externalReferenceCode=");
			msg.append(externalReferenceCode);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPriceModifierException(msg.toString());
		}

		return commercePriceModifier;
	}

	/**
	 * Returns the commerce price modifier where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the commerce price modifier where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce price modifier, or <code>null</code> if a matching commerce price modifier could not be found
	 */
	@Override
	public CommercePriceModifier fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_ERC, finderArgs, this);
		}

		if (result instanceof CommercePriceModifier) {
			CommercePriceModifier commercePriceModifier =
				(CommercePriceModifier)result;

			if ((companyId != commercePriceModifier.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					commercePriceModifier.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindExternalReferenceCode) {
					qPos.add(externalReferenceCode);
				}

				List<CommercePriceModifier> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"CommercePriceModifierPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CommercePriceModifier commercePriceModifier = list.get(0);

					result = commercePriceModifier;

					cacheResult(commercePriceModifier);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_ERC, finderArgs);
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
			return (CommercePriceModifier)result;
		}
	}

	/**
	 * Removes the commerce price modifier where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the commerce price modifier that was removed
	 */
	@Override
	public CommercePriceModifier removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(commercePriceModifier);
	}

	/**
	 * Returns the number of commerce price modifiers where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching commerce price modifiers
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE);

			query.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindExternalReferenceCode) {
					qPos.add(externalReferenceCode);
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

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"commercePriceModifier.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"commercePriceModifier.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(commercePriceModifier.externalReferenceCode IS NULL OR commercePriceModifier.externalReferenceCode = '')";

	public CommercePriceModifierPersistenceImpl() {
		setModelClass(CommercePriceModifier.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("active", "active_");

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
	 * Caches the commerce price modifier in the entity cache if it is enabled.
	 *
	 * @param commercePriceModifier the commerce price modifier
	 */
	@Override
	public void cacheResult(CommercePriceModifier commercePriceModifier) {
		entityCache.putResult(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			commercePriceModifier.getPrimaryKey(), commercePriceModifier);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				commercePriceModifier.getUuid(),
				commercePriceModifier.getGroupId()
			},
			commercePriceModifier);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				commercePriceModifier.getCompanyId(),
				commercePriceModifier.getExternalReferenceCode()
			},
			commercePriceModifier);

		commercePriceModifier.resetOriginalValues();
	}

	/**
	 * Caches the commerce price modifiers in the entity cache if it is enabled.
	 *
	 * @param commercePriceModifiers the commerce price modifiers
	 */
	@Override
	public void cacheResult(
		List<CommercePriceModifier> commercePriceModifiers) {

		for (CommercePriceModifier commercePriceModifier :
				commercePriceModifiers) {

			if (entityCache.getResult(
					CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceModifierImpl.class,
					commercePriceModifier.getPrimaryKey()) == null) {

				cacheResult(commercePriceModifier);
			}
			else {
				commercePriceModifier.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commerce price modifiers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercePriceModifierImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce price modifier.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommercePriceModifier commercePriceModifier) {
		entityCache.removeResult(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			commercePriceModifier.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CommercePriceModifierModelImpl)commercePriceModifier, true);
	}

	@Override
	public void clearCache(List<CommercePriceModifier> commercePriceModifiers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommercePriceModifier commercePriceModifier :
				commercePriceModifiers) {

			entityCache.removeResult(
				CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierImpl.class,
				commercePriceModifier.getPrimaryKey());

			clearUniqueFindersCache(
				(CommercePriceModifierModelImpl)commercePriceModifier, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommercePriceModifierModelImpl commercePriceModifierModelImpl) {

		Object[] args = new Object[] {
			commercePriceModifierModelImpl.getUuid(),
			commercePriceModifierModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, commercePriceModifierModelImpl,
			false);

		args = new Object[] {
			commercePriceModifierModelImpl.getCompanyId(),
			commercePriceModifierModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, commercePriceModifierModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		CommercePriceModifierModelImpl commercePriceModifierModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				commercePriceModifierModelImpl.getUuid(),
				commercePriceModifierModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((commercePriceModifierModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commercePriceModifierModelImpl.getOriginalUuid(),
				commercePriceModifierModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				commercePriceModifierModelImpl.getCompanyId(),
				commercePriceModifierModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((commercePriceModifierModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commercePriceModifierModelImpl.getOriginalCompanyId(),
				commercePriceModifierModelImpl.
					getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new commerce price modifier with the primary key. Does not add the commerce price modifier to the database.
	 *
	 * @param commercePriceModifierId the primary key for the new commerce price modifier
	 * @return the new commerce price modifier
	 */
	@Override
	public CommercePriceModifier create(long commercePriceModifierId) {
		CommercePriceModifier commercePriceModifier =
			new CommercePriceModifierImpl();

		commercePriceModifier.setNew(true);
		commercePriceModifier.setPrimaryKey(commercePriceModifierId);

		String uuid = PortalUUIDUtil.generate();

		commercePriceModifier.setUuid(uuid);

		commercePriceModifier.setCompanyId(CompanyThreadLocal.getCompanyId());

		return commercePriceModifier;
	}

	/**
	 * Removes the commerce price modifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier that was removed
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier remove(long commercePriceModifierId)
		throws NoSuchPriceModifierException {

		return remove((Serializable)commercePriceModifierId);
	}

	/**
	 * Removes the commerce price modifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce price modifier
	 * @return the commerce price modifier that was removed
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier remove(Serializable primaryKey)
		throws NoSuchPriceModifierException {

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifier commercePriceModifier =
				(CommercePriceModifier)session.get(
					CommercePriceModifierImpl.class, primaryKey);

			if (commercePriceModifier == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriceModifierException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercePriceModifier);
		}
		catch (NoSuchPriceModifierException nsee) {
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
	protected CommercePriceModifier removeImpl(
		CommercePriceModifier commercePriceModifier) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercePriceModifier)) {
				commercePriceModifier = (CommercePriceModifier)session.get(
					CommercePriceModifierImpl.class,
					commercePriceModifier.getPrimaryKeyObj());
			}

			if (commercePriceModifier != null) {
				session.delete(commercePriceModifier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commercePriceModifier != null) {
			clearCache(commercePriceModifier);
		}

		return commercePriceModifier;
	}

	@Override
	public CommercePriceModifier updateImpl(
		CommercePriceModifier commercePriceModifier) {

		boolean isNew = commercePriceModifier.isNew();

		if (!(commercePriceModifier instanceof
				CommercePriceModifierModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commercePriceModifier.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					commercePriceModifier);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercePriceModifier proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommercePriceModifier implementation " +
					commercePriceModifier.getClass());
		}

		CommercePriceModifierModelImpl commercePriceModifierModelImpl =
			(CommercePriceModifierModelImpl)commercePriceModifier;

		if (Validator.isNull(commercePriceModifier.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commercePriceModifier.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (commercePriceModifier.getCreateDate() == null)) {
			if (serviceContext == null) {
				commercePriceModifier.setCreateDate(now);
			}
			else {
				commercePriceModifier.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commercePriceModifierModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commercePriceModifier.setModifiedDate(now);
			}
			else {
				commercePriceModifier.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commercePriceModifier.isNew()) {
				session.save(commercePriceModifier);

				commercePriceModifier.setNew(false);
			}
			else {
				commercePriceModifier = (CommercePriceModifier)session.merge(
					commercePriceModifier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommercePriceModifierModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				commercePriceModifierModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				commercePriceModifierModelImpl.getUuid(),
				commercePriceModifierModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {commercePriceModifierModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompanyId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompanyId, args);

			args = new Object[] {
				commercePriceModifierModelImpl.getCompanyId(),
				commercePriceModifierModelImpl.getTarget()
			};

			finderCache.removeResult(_finderPathCountByC_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByC_T, args);

			args = new Object[] {
				commercePriceModifierModelImpl.getGroupId(),
				commercePriceModifierModelImpl.getCompanyId(),
				commercePriceModifierModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByG_C_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_S, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((commercePriceModifierModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceModifierModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {commercePriceModifierModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((commercePriceModifierModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceModifierModelImpl.getOriginalUuid(),
					commercePriceModifierModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					commercePriceModifierModelImpl.getUuid(),
					commercePriceModifierModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((commercePriceModifierModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompanyId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePriceModifierModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);

				args = new Object[] {
					commercePriceModifierModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompanyId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompanyId, args);
			}

			if ((commercePriceModifierModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByC_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceModifierModelImpl.getOriginalCompanyId(),
					commercePriceModifierModelImpl.getOriginalTarget()
				};

				finderCache.removeResult(_finderPathCountByC_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_T, args);

				args = new Object[] {
					commercePriceModifierModelImpl.getCompanyId(),
					commercePriceModifierModelImpl.getTarget()
				};

				finderCache.removeResult(_finderPathCountByC_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByC_T, args);
			}

			if ((commercePriceModifierModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceModifierModelImpl.getOriginalGroupId(),
					commercePriceModifierModelImpl.getOriginalCompanyId(),
					commercePriceModifierModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByG_C_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_S, args);

				args = new Object[] {
					commercePriceModifierModelImpl.getGroupId(),
					commercePriceModifierModelImpl.getCompanyId(),
					commercePriceModifierModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByG_C_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_S, args);
			}
		}

		entityCache.putResult(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			commercePriceModifier.getPrimaryKey(), commercePriceModifier,
			false);

		clearUniqueFindersCache(commercePriceModifierModelImpl, false);
		cacheUniqueFindersCache(commercePriceModifierModelImpl);

		commercePriceModifier.resetOriginalValues();

		return commercePriceModifier;
	}

	/**
	 * Returns the commerce price modifier with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price modifier
	 * @return the commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriceModifierException {

		CommercePriceModifier commercePriceModifier = fetchByPrimaryKey(
			primaryKey);

		if (commercePriceModifier == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriceModifierException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercePriceModifier;
	}

	/**
	 * Returns the commerce price modifier with the primary key or throws a <code>NoSuchPriceModifierException</code> if it could not be found.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier
	 * @throws NoSuchPriceModifierException if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier findByPrimaryKey(long commercePriceModifierId)
		throws NoSuchPriceModifierException {

		return findByPrimaryKey((Serializable)commercePriceModifierId);
	}

	/**
	 * Returns the commerce price modifier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price modifier
	 * @return the commerce price modifier, or <code>null</code> if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommercePriceModifier commercePriceModifier =
			(CommercePriceModifier)serializable;

		if (commercePriceModifier == null) {
			Session session = null;

			try {
				session = openSession();

				commercePriceModifier = (CommercePriceModifier)session.get(
					CommercePriceModifierImpl.class, primaryKey);

				if (commercePriceModifier != null) {
					cacheResult(commercePriceModifier);
				}
				else {
					entityCache.putResult(
						CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
						CommercePriceModifierImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceModifierImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commercePriceModifier;
	}

	/**
	 * Returns the commerce price modifier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceModifierId the primary key of the commerce price modifier
	 * @return the commerce price modifier, or <code>null</code> if a commerce price modifier with the primary key could not be found
	 */
	@Override
	public CommercePriceModifier fetchByPrimaryKey(
		long commercePriceModifierId) {

		return fetchByPrimaryKey((Serializable)commercePriceModifierId);
	}

	@Override
	public Map<Serializable, CommercePriceModifier> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommercePriceModifier> map =
			new HashMap<Serializable, CommercePriceModifier>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommercePriceModifier commercePriceModifier = fetchByPrimaryKey(
				primaryKey);

			if (commercePriceModifier != null) {
				map.put(primaryKey, commercePriceModifier);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CommercePriceModifier)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE_PKS_IN);

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

			for (CommercePriceModifier commercePriceModifier :
					(List<CommercePriceModifier>)q.list()) {

				map.put(
					commercePriceModifier.getPrimaryKeyObj(),
					commercePriceModifier);

				cacheResult(commercePriceModifier);

				uncachedPrimaryKeys.remove(
					commercePriceModifier.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceModifierImpl.class, primaryKey, nullModel);
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
	 * Returns all the commerce price modifiers.
	 *
	 * @return the commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @return the range of commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findAll(
		int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifiers
	 * @param end the upper bound of the range of commerce price modifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce price modifiers
	 */
	@Override
	public List<CommercePriceModifier> findAll(
		int start, int end,
		OrderByComparator<CommercePriceModifier> orderByComparator,
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

		List<CommercePriceModifier> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifier>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMERCEPRICEMODIFIER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCEPRICEMODIFIER;

				sql = sql.concat(CommercePriceModifierModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<CommercePriceModifier>)QueryUtil.list(
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
	 * Removes all the commerce price modifiers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommercePriceModifier commercePriceModifier : findAll()) {
			remove(commercePriceModifier);
		}
	}

	/**
	 * Returns the number of commerce price modifiers.
	 *
	 * @return the number of commerce price modifiers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMERCEPRICEMODIFIER);

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
		return CommercePriceModifierModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce price modifier persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CommercePriceModifierModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.DISPLAYDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.CREATEDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			CommercePriceModifierModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			CommercePriceModifierModelImpl.UUID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.DISPLAYDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.CREATEDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()},
			CommercePriceModifierModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.DISPLAYDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.CREATEDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByCompanyId = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByC_T = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByC_T = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_T",
			new String[] {Long.class.getName(), String.class.getName()},
			CommercePriceModifierModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.TARGET_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.DISPLAYDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.CREATEDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByC_T = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_T",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByLtD_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLtD_S",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByLtD_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByLtD_S",
			new String[] {Date.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByLtE_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLtE_S",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByLtE_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByLtE_S",
			new String[] {Date.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByG_C_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			CommercePriceModifierModelImpl.GROUPID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.STATUS_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.DISPLAYDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.CREATEDATE_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.PRIORITY_COLUMN_BITMASK);

		_finderPathCountByG_C_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByG_C_S = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_C_NotS = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_NotS",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByG_C_NotS = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_C_NotS",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathFetchByC_ERC = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			CommercePriceModifierModelImpl.COMPANYID_COLUMN_BITMASK |
			CommercePriceModifierModelImpl.
				EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			CommercePriceModifierModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CommercePriceModifierImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_COMMERCEPRICEMODIFIER =
		"SELECT commercePriceModifier FROM CommercePriceModifier commercePriceModifier";

	private static final String _SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE_PKS_IN =
		"SELECT commercePriceModifier FROM CommercePriceModifier commercePriceModifier WHERE commercePriceModifierId IN (";

	private static final String _SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE =
		"SELECT commercePriceModifier FROM CommercePriceModifier commercePriceModifier WHERE ";

	private static final String _SQL_COUNT_COMMERCEPRICEMODIFIER =
		"SELECT COUNT(commercePriceModifier) FROM CommercePriceModifier commercePriceModifier";

	private static final String _SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE =
		"SELECT COUNT(commercePriceModifier) FROM CommercePriceModifier commercePriceModifier WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"commercePriceModifier.commercePriceModifierId";

	private static final String _FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_WHERE =
		"SELECT DISTINCT {commercePriceModifier.*} FROM CommercePriceModifier commercePriceModifier WHERE ";

	private static final String
		_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {CommercePriceModifier.*} FROM (SELECT DISTINCT commercePriceModifier.commercePriceModifierId FROM CommercePriceModifier commercePriceModifier WHERE ";

	private static final String
		_FILTER_SQL_SELECT_COMMERCEPRICEMODIFIER_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN CommercePriceModifier ON TEMP_TABLE.commercePriceModifierId = CommercePriceModifier.commercePriceModifierId";

	private static final String _FILTER_SQL_COUNT_COMMERCEPRICEMODIFIER_WHERE =
		"SELECT COUNT(DISTINCT commercePriceModifier.commercePriceModifierId) AS COUNT_VALUE FROM CommercePriceModifier commercePriceModifier WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "commercePriceModifier";

	private static final String _FILTER_ENTITY_TABLE = "CommercePriceModifier";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"commercePriceModifier.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"CommercePriceModifier.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommercePriceModifier exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommercePriceModifier exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "active"});

}