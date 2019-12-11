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

import com.liferay.commerce.price.modifier.exception.NoSuchPriceModifierRelException;
import com.liferay.commerce.price.modifier.model.CommercePriceModifierRel;
import com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelImpl;
import com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelModelImpl;
import com.liferay.commerce.price.modifier.service.persistence.CommercePriceModifierRelPersistence;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the commerce price modifier rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Riccardo Alberti
 * @generated
 */
public class CommercePriceModifierRelPersistenceImpl
	extends BasePersistenceImpl<CommercePriceModifierRel>
	implements CommercePriceModifierRelPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercePriceModifierRelUtil</code> to access the commerce price modifier rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercePriceModifierRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCommercePriceModifierId;
	private FinderPath
		_finderPathWithoutPaginationFindByCommercePriceModifierId;
	private FinderPath _finderPathCountByCommercePriceModifierId;

	/**
	 * Returns all the commerce price modifier rels where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @return the matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCommercePriceModifierId(
		long commercePriceModifierId) {

		return findByCommercePriceModifierId(
			commercePriceModifierId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the commerce price modifier rels where commercePriceModifierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @return the range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCommercePriceModifierId(
		long commercePriceModifierId, int start, int end) {

		return findByCommercePriceModifierId(
			commercePriceModifierId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels where commercePriceModifierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCommercePriceModifierId(
		long commercePriceModifierId, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		return findByCommercePriceModifierId(
			commercePriceModifierId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels where commercePriceModifierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCommercePriceModifierId(
		long commercePriceModifierId, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCommercePriceModifierId;
				finderArgs = new Object[] {commercePriceModifierId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCommercePriceModifierId;
			finderArgs = new Object[] {
				commercePriceModifierId, start, end, orderByComparator
			};
		}

		List<CommercePriceModifierRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifierRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifierRel commercePriceModifierRel : list) {
					if (commercePriceModifierId !=
							commercePriceModifierRel.
								getCommercePriceModifierId()) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE);

			query.append(
				_FINDER_COLUMN_COMMERCEPRICEMODIFIERID_COMMERCEPRICEMODIFIERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceModifierId);

				list = (List<CommercePriceModifierRel>)QueryUtil.list(
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
	 * Returns the first commerce price modifier rel in the ordered set where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel findByCommercePriceModifierId_First(
			long commercePriceModifierId,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel =
			fetchByCommercePriceModifierId_First(
				commercePriceModifierId, orderByComparator);

		if (commercePriceModifierRel != null) {
			return commercePriceModifierRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceModifierId=");
		msg.append(commercePriceModifierId);

		msg.append("}");

		throw new NoSuchPriceModifierRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier rel in the ordered set where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier rel, or <code>null</code> if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByCommercePriceModifierId_First(
		long commercePriceModifierId,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		List<CommercePriceModifierRel> list = findByCommercePriceModifierId(
			commercePriceModifierId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier rel in the ordered set where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel findByCommercePriceModifierId_Last(
			long commercePriceModifierId,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel =
			fetchByCommercePriceModifierId_Last(
				commercePriceModifierId, orderByComparator);

		if (commercePriceModifierRel != null) {
			return commercePriceModifierRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceModifierId=");
		msg.append(commercePriceModifierId);

		msg.append("}");

		throw new NoSuchPriceModifierRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier rel in the ordered set where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier rel, or <code>null</code> if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByCommercePriceModifierId_Last(
		long commercePriceModifierId,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		int count = countByCommercePriceModifierId(commercePriceModifierId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifierRel> list = findByCommercePriceModifierId(
			commercePriceModifierId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifier rels before and after the current commerce price modifier rel in the ordered set where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierRelId the primary key of the current commerce price modifier rel
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel[] findByCommercePriceModifierId_PrevAndNext(
			long commercePriceModifierRelId, long commercePriceModifierId,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = findByPrimaryKey(
			commercePriceModifierRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifierRel[] array =
				new CommercePriceModifierRelImpl[3];

			array[0] = getByCommercePriceModifierId_PrevAndNext(
				session, commercePriceModifierRel, commercePriceModifierId,
				orderByComparator, true);

			array[1] = commercePriceModifierRel;

			array[2] = getByCommercePriceModifierId_PrevAndNext(
				session, commercePriceModifierRel, commercePriceModifierId,
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

	protected CommercePriceModifierRel getByCommercePriceModifierId_PrevAndNext(
		Session session, CommercePriceModifierRel commercePriceModifierRel,
		long commercePriceModifierId,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE);

		query.append(
			_FINDER_COLUMN_COMMERCEPRICEMODIFIERID_COMMERCEPRICEMODIFIERID_2);

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
			query.append(CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(commercePriceModifierId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifierRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifierRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifier rels where commercePriceModifierId = &#63; from the database.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 */
	@Override
	public void removeByCommercePriceModifierId(long commercePriceModifierId) {
		for (CommercePriceModifierRel commercePriceModifierRel :
				findByCommercePriceModifierId(
					commercePriceModifierId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifierRel);
		}
	}

	/**
	 * Returns the number of commerce price modifier rels where commercePriceModifierId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @return the number of matching commerce price modifier rels
	 */
	@Override
	public int countByCommercePriceModifierId(long commercePriceModifierId) {
		FinderPath finderPath = _finderPathCountByCommercePriceModifierId;

		Object[] finderArgs = new Object[] {commercePriceModifierId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIERREL_WHERE);

			query.append(
				_FINDER_COLUMN_COMMERCEPRICEMODIFIERID_COMMERCEPRICEMODIFIERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceModifierId);

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
		_FINDER_COLUMN_COMMERCEPRICEMODIFIERID_COMMERCEPRICEMODIFIERID_2 =
			"commercePriceModifierRel.commercePriceModifierId = ?";

	private FinderPath _finderPathWithPaginationFindByCPM_CN;
	private FinderPath _finderPathWithoutPaginationFindByCPM_CN;
	private FinderPath _finderPathCountByCPM_CN;

	/**
	 * Returns all the commerce price modifier rels where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @return the matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCPM_CN(
		long commercePriceModifierId, long classNameId) {

		return findByCPM_CN(
			commercePriceModifierId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifier rels where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @return the range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCPM_CN(
		long commercePriceModifierId, long classNameId, int start, int end) {

		return findByCPM_CN(
			commercePriceModifierId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCPM_CN(
		long commercePriceModifierId, long classNameId, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		return findByCPM_CN(
			commercePriceModifierId, classNameId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCPM_CN(
		long commercePriceModifierId, long classNameId, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCPM_CN;
				finderArgs = new Object[] {
					commercePriceModifierId, classNameId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCPM_CN;
			finderArgs = new Object[] {
				commercePriceModifierId, classNameId, start, end,
				orderByComparator
			};
		}

		List<CommercePriceModifierRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifierRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifierRel commercePriceModifierRel : list) {
					if ((commercePriceModifierId !=
							commercePriceModifierRel.
								getCommercePriceModifierId()) ||
						(classNameId !=
							commercePriceModifierRel.getClassNameId())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE);

			query.append(_FINDER_COLUMN_CPM_CN_COMMERCEPRICEMODIFIERID_2);

			query.append(_FINDER_COLUMN_CPM_CN_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceModifierId);

				qPos.add(classNameId);

				list = (List<CommercePriceModifierRel>)QueryUtil.list(
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
	 * Returns the first commerce price modifier rel in the ordered set where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel findByCPM_CN_First(
			long commercePriceModifierId, long classNameId,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = fetchByCPM_CN_First(
			commercePriceModifierId, classNameId, orderByComparator);

		if (commercePriceModifierRel != null) {
			return commercePriceModifierRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceModifierId=");
		msg.append(commercePriceModifierId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append("}");

		throw new NoSuchPriceModifierRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier rel in the ordered set where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier rel, or <code>null</code> if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByCPM_CN_First(
		long commercePriceModifierId, long classNameId,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		List<CommercePriceModifierRel> list = findByCPM_CN(
			commercePriceModifierId, classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier rel in the ordered set where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel findByCPM_CN_Last(
			long commercePriceModifierId, long classNameId,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = fetchByCPM_CN_Last(
			commercePriceModifierId, classNameId, orderByComparator);

		if (commercePriceModifierRel != null) {
			return commercePriceModifierRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("commercePriceModifierId=");
		msg.append(commercePriceModifierId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append("}");

		throw new NoSuchPriceModifierRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier rel in the ordered set where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier rel, or <code>null</code> if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByCPM_CN_Last(
		long commercePriceModifierId, long classNameId,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		int count = countByCPM_CN(commercePriceModifierId, classNameId);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifierRel> list = findByCPM_CN(
			commercePriceModifierId, classNameId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifier rels before and after the current commerce price modifier rel in the ordered set where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierRelId the primary key of the current commerce price modifier rel
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel[] findByCPM_CN_PrevAndNext(
			long commercePriceModifierRelId, long commercePriceModifierId,
			long classNameId,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = findByPrimaryKey(
			commercePriceModifierRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifierRel[] array =
				new CommercePriceModifierRelImpl[3];

			array[0] = getByCPM_CN_PrevAndNext(
				session, commercePriceModifierRel, commercePriceModifierId,
				classNameId, orderByComparator, true);

			array[1] = commercePriceModifierRel;

			array[2] = getByCPM_CN_PrevAndNext(
				session, commercePriceModifierRel, commercePriceModifierId,
				classNameId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePriceModifierRel getByCPM_CN_PrevAndNext(
		Session session, CommercePriceModifierRel commercePriceModifierRel,
		long commercePriceModifierId, long classNameId,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE);

		query.append(_FINDER_COLUMN_CPM_CN_COMMERCEPRICEMODIFIERID_2);

		query.append(_FINDER_COLUMN_CPM_CN_CLASSNAMEID_2);

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
			query.append(CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(commercePriceModifierId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifierRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifierRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifier rels where commercePriceModifierId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 */
	@Override
	public void removeByCPM_CN(long commercePriceModifierId, long classNameId) {
		for (CommercePriceModifierRel commercePriceModifierRel :
				findByCPM_CN(
					commercePriceModifierId, classNameId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(commercePriceModifierRel);
		}
	}

	/**
	 * Returns the number of commerce price modifier rels where commercePriceModifierId = &#63; and classNameId = &#63;.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID
	 * @param classNameId the class name ID
	 * @return the number of matching commerce price modifier rels
	 */
	@Override
	public int countByCPM_CN(long commercePriceModifierId, long classNameId) {
		FinderPath finderPath = _finderPathCountByCPM_CN;

		Object[] finderArgs = new Object[] {
			commercePriceModifierId, classNameId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIERREL_WHERE);

			query.append(_FINDER_COLUMN_CPM_CN_COMMERCEPRICEMODIFIERID_2);

			query.append(_FINDER_COLUMN_CPM_CN_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(commercePriceModifierId);

				qPos.add(classNameId);

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
		_FINDER_COLUMN_CPM_CN_COMMERCEPRICEMODIFIERID_2 =
			"commercePriceModifierRel.commercePriceModifierId = ? AND ";

	private static final String _FINDER_COLUMN_CPM_CN_CLASSNAMEID_2 =
		"commercePriceModifierRel.classNameId = ?";

	private FinderPath _finderPathWithPaginationFindByCN_CPK;
	private FinderPath _finderPathWithoutPaginationFindByCN_CPK;
	private FinderPath _finderPathCountByCN_CPK;

	/**
	 * Returns all the commerce price modifier rels where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCN_CPK(
		long classNameId, long classPK) {

		return findByCN_CPK(
			classNameId, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifier rels where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @return the range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCN_CPK(
		long classNameId, long classPK, int start, int end) {

		return findByCN_CPK(classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCN_CPK(
		long classNameId, long classPK, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		return findByCN_CPK(
			classNameId, classPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findByCN_CPK(
		long classNameId, long classPK, int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCN_CPK;
				finderArgs = new Object[] {classNameId, classPK};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCN_CPK;
			finderArgs = new Object[] {
				classNameId, classPK, start, end, orderByComparator
			};
		}

		List<CommercePriceModifierRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifierRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePriceModifierRel commercePriceModifierRel : list) {
					if ((classNameId !=
							commercePriceModifierRel.getClassNameId()) ||
						(classPK != commercePriceModifierRel.getClassPK())) {

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

			query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE);

			query.append(_FINDER_COLUMN_CN_CPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CN_CPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				list = (List<CommercePriceModifierRel>)QueryUtil.list(
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
	 * Returns the first commerce price modifier rel in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel findByCN_CPK_First(
			long classNameId, long classPK,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = fetchByCN_CPK_First(
			classNameId, classPK, orderByComparator);

		if (commercePriceModifierRel != null) {
			return commercePriceModifierRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPriceModifierRelException(msg.toString());
	}

	/**
	 * Returns the first commerce price modifier rel in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce price modifier rel, or <code>null</code> if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByCN_CPK_First(
		long classNameId, long classPK,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		List<CommercePriceModifierRel> list = findByCN_CPK(
			classNameId, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce price modifier rel in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel findByCN_CPK_Last(
			long classNameId, long classPK,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = fetchByCN_CPK_Last(
			classNameId, classPK, orderByComparator);

		if (commercePriceModifierRel != null) {
			return commercePriceModifierRel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPriceModifierRelException(msg.toString());
	}

	/**
	 * Returns the last commerce price modifier rel in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce price modifier rel, or <code>null</code> if a matching commerce price modifier rel could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByCN_CPK_Last(
		long classNameId, long classPK,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		int count = countByCN_CPK(classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<CommercePriceModifierRel> list = findByCN_CPK(
			classNameId, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce price modifier rels before and after the current commerce price modifier rel in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param commercePriceModifierRelId the primary key of the current commerce price modifier rel
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel[] findByCN_CPK_PrevAndNext(
			long commercePriceModifierRelId, long classNameId, long classPK,
			OrderByComparator<CommercePriceModifierRel> orderByComparator)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = findByPrimaryKey(
			commercePriceModifierRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifierRel[] array =
				new CommercePriceModifierRelImpl[3];

			array[0] = getByCN_CPK_PrevAndNext(
				session, commercePriceModifierRel, classNameId, classPK,
				orderByComparator, true);

			array[1] = commercePriceModifierRel;

			array[2] = getByCN_CPK_PrevAndNext(
				session, commercePriceModifierRel, classNameId, classPK,
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

	protected CommercePriceModifierRel getByCN_CPK_PrevAndNext(
		Session session, CommercePriceModifierRel commercePriceModifierRel,
		long classNameId, long classPK,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
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

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE);

		query.append(_FINDER_COLUMN_CN_CPK_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_CN_CPK_CLASSPK_2);

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
			query.append(CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePriceModifierRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CommercePriceModifierRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce price modifier rels where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 */
	@Override
	public void removeByCN_CPK(long classNameId, long classPK) {
		for (CommercePriceModifierRel commercePriceModifierRel :
				findByCN_CPK(
					classNameId, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercePriceModifierRel);
		}
	}

	/**
	 * Returns the number of commerce price modifier rels where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching commerce price modifier rels
	 */
	@Override
	public int countByCN_CPK(long classNameId, long classPK) {
		FinderPath finderPath = _finderPathCountByCN_CPK;

		Object[] finderArgs = new Object[] {classNameId, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMERCEPRICEMODIFIERREL_WHERE);

			query.append(_FINDER_COLUMN_CN_CPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CN_CPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_CN_CPK_CLASSNAMEID_2 =
		"commercePriceModifierRel.classNameId = ? AND ";

	private static final String _FINDER_COLUMN_CN_CPK_CLASSPK_2 =
		"commercePriceModifierRel.classPK = ?";

	public CommercePriceModifierRelPersistenceImpl() {
		setModelClass(CommercePriceModifierRel.class);
	}

	/**
	 * Caches the commerce price modifier rel in the entity cache if it is enabled.
	 *
	 * @param commercePriceModifierRel the commerce price modifier rel
	 */
	@Override
	public void cacheResult(CommercePriceModifierRel commercePriceModifierRel) {
		entityCache.putResult(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			commercePriceModifierRel.getPrimaryKey(), commercePriceModifierRel);

		commercePriceModifierRel.resetOriginalValues();
	}

	/**
	 * Caches the commerce price modifier rels in the entity cache if it is enabled.
	 *
	 * @param commercePriceModifierRels the commerce price modifier rels
	 */
	@Override
	public void cacheResult(
		List<CommercePriceModifierRel> commercePriceModifierRels) {

		for (CommercePriceModifierRel commercePriceModifierRel :
				commercePriceModifierRels) {

			if (entityCache.getResult(
					CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceModifierRelImpl.class,
					commercePriceModifierRel.getPrimaryKey()) == null) {

				cacheResult(commercePriceModifierRel);
			}
			else {
				commercePriceModifierRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all commerce price modifier rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercePriceModifierRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce price modifier rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommercePriceModifierRel commercePriceModifierRel) {
		entityCache.removeResult(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			commercePriceModifierRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CommercePriceModifierRel> commercePriceModifierRels) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommercePriceModifierRel commercePriceModifierRel :
				commercePriceModifierRels) {

			entityCache.removeResult(
				CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierRelImpl.class,
				commercePriceModifierRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new commerce price modifier rel with the primary key. Does not add the commerce price modifier rel to the database.
	 *
	 * @param commercePriceModifierRelId the primary key for the new commerce price modifier rel
	 * @return the new commerce price modifier rel
	 */
	@Override
	public CommercePriceModifierRel create(long commercePriceModifierRelId) {
		CommercePriceModifierRel commercePriceModifierRel =
			new CommercePriceModifierRelImpl();

		commercePriceModifierRel.setNew(true);
		commercePriceModifierRel.setPrimaryKey(commercePriceModifierRelId);

		commercePriceModifierRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return commercePriceModifierRel;
	}

	/**
	 * Removes the commerce price modifier rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel that was removed
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel remove(long commercePriceModifierRelId)
		throws NoSuchPriceModifierRelException {

		return remove((Serializable)commercePriceModifierRelId);
	}

	/**
	 * Removes the commerce price modifier rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel that was removed
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel remove(Serializable primaryKey)
		throws NoSuchPriceModifierRelException {

		Session session = null;

		try {
			session = openSession();

			CommercePriceModifierRel commercePriceModifierRel =
				(CommercePriceModifierRel)session.get(
					CommercePriceModifierRelImpl.class, primaryKey);

			if (commercePriceModifierRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriceModifierRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercePriceModifierRel);
		}
		catch (NoSuchPriceModifierRelException nsee) {
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
	protected CommercePriceModifierRel removeImpl(
		CommercePriceModifierRel commercePriceModifierRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercePriceModifierRel)) {
				commercePriceModifierRel =
					(CommercePriceModifierRel)session.get(
						CommercePriceModifierRelImpl.class,
						commercePriceModifierRel.getPrimaryKeyObj());
			}

			if (commercePriceModifierRel != null) {
				session.delete(commercePriceModifierRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commercePriceModifierRel != null) {
			clearCache(commercePriceModifierRel);
		}

		return commercePriceModifierRel;
	}

	@Override
	public CommercePriceModifierRel updateImpl(
		CommercePriceModifierRel commercePriceModifierRel) {

		boolean isNew = commercePriceModifierRel.isNew();

		if (!(commercePriceModifierRel instanceof
				CommercePriceModifierRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commercePriceModifierRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					commercePriceModifierRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercePriceModifierRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommercePriceModifierRel implementation " +
					commercePriceModifierRel.getClass());
		}

		CommercePriceModifierRelModelImpl commercePriceModifierRelModelImpl =
			(CommercePriceModifierRelModelImpl)commercePriceModifierRel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (commercePriceModifierRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				commercePriceModifierRel.setCreateDate(now);
			}
			else {
				commercePriceModifierRel.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commercePriceModifierRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				commercePriceModifierRel.setModifiedDate(now);
			}
			else {
				commercePriceModifierRel.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commercePriceModifierRel.isNew()) {
				session.save(commercePriceModifierRel);

				commercePriceModifierRel.setNew(false);
			}
			else {
				commercePriceModifierRel =
					(CommercePriceModifierRel)session.merge(
						commercePriceModifierRel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommercePriceModifierRelModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				commercePriceModifierRelModelImpl.getCommercePriceModifierId()
			};

			finderCache.removeResult(
				_finderPathCountByCommercePriceModifierId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCommercePriceModifierId,
				args);

			args = new Object[] {
				commercePriceModifierRelModelImpl.getCommercePriceModifierId(),
				commercePriceModifierRelModelImpl.getClassNameId()
			};

			finderCache.removeResult(_finderPathCountByCPM_CN, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCPM_CN, args);

			args = new Object[] {
				commercePriceModifierRelModelImpl.getClassNameId(),
				commercePriceModifierRelModelImpl.getClassPK()
			};

			finderCache.removeResult(_finderPathCountByCN_CPK, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCN_CPK, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((commercePriceModifierRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCommercePriceModifierId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePriceModifierRelModelImpl.
						getOriginalCommercePriceModifierId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceModifierId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceModifierId,
					args);

				args = new Object[] {
					commercePriceModifierRelModelImpl.
						getCommercePriceModifierId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePriceModifierId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePriceModifierId,
					args);
			}

			if ((commercePriceModifierRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCPM_CN.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceModifierRelModelImpl.
						getOriginalCommercePriceModifierId(),
					commercePriceModifierRelModelImpl.getOriginalClassNameId()
				};

				finderCache.removeResult(_finderPathCountByCPM_CN, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCPM_CN, args);

				args = new Object[] {
					commercePriceModifierRelModelImpl.
						getCommercePriceModifierId(),
					commercePriceModifierRelModelImpl.getClassNameId()
				};

				finderCache.removeResult(_finderPathCountByCPM_CN, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCPM_CN, args);
			}

			if ((commercePriceModifierRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCN_CPK.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					commercePriceModifierRelModelImpl.getOriginalClassNameId(),
					commercePriceModifierRelModelImpl.getOriginalClassPK()
				};

				finderCache.removeResult(_finderPathCountByCN_CPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCN_CPK, args);

				args = new Object[] {
					commercePriceModifierRelModelImpl.getClassNameId(),
					commercePriceModifierRelModelImpl.getClassPK()
				};

				finderCache.removeResult(_finderPathCountByCN_CPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCN_CPK, args);
			}
		}

		entityCache.putResult(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			commercePriceModifierRel.getPrimaryKey(), commercePriceModifierRel,
			false);

		commercePriceModifierRel.resetOriginalValues();

		return commercePriceModifierRel;
	}

	/**
	 * Returns the commerce price modifier rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriceModifierRelException {

		CommercePriceModifierRel commercePriceModifierRel = fetchByPrimaryKey(
			primaryKey);

		if (commercePriceModifierRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriceModifierRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercePriceModifierRel;
	}

	/**
	 * Returns the commerce price modifier rel with the primary key or throws a <code>NoSuchPriceModifierRelException</code> if it could not be found.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel
	 * @throws NoSuchPriceModifierRelException if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel findByPrimaryKey(
			long commercePriceModifierRelId)
		throws NoSuchPriceModifierRelException {

		return findByPrimaryKey((Serializable)commercePriceModifierRelId);
	}

	/**
	 * Returns the commerce price modifier rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel, or <code>null</code> if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommercePriceModifierRel commercePriceModifierRel =
			(CommercePriceModifierRel)serializable;

		if (commercePriceModifierRel == null) {
			Session session = null;

			try {
				session = openSession();

				commercePriceModifierRel =
					(CommercePriceModifierRel)session.get(
						CommercePriceModifierRelImpl.class, primaryKey);

				if (commercePriceModifierRel != null) {
					cacheResult(commercePriceModifierRel);
				}
				else {
					entityCache.putResult(
						CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
						CommercePriceModifierRelImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceModifierRelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commercePriceModifierRel;
	}

	/**
	 * Returns the commerce price modifier rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commercePriceModifierRelId the primary key of the commerce price modifier rel
	 * @return the commerce price modifier rel, or <code>null</code> if a commerce price modifier rel with the primary key could not be found
	 */
	@Override
	public CommercePriceModifierRel fetchByPrimaryKey(
		long commercePriceModifierRelId) {

		return fetchByPrimaryKey((Serializable)commercePriceModifierRelId);
	}

	@Override
	public Map<Serializable, CommercePriceModifierRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommercePriceModifierRel> map =
			new HashMap<Serializable, CommercePriceModifierRel>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommercePriceModifierRel commercePriceModifierRel =
				fetchByPrimaryKey(primaryKey);

			if (commercePriceModifierRel != null) {
				map.put(primaryKey, commercePriceModifierRel);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierRelImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CommercePriceModifierRel)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE_PKS_IN);

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

			for (CommercePriceModifierRel commercePriceModifierRel :
					(List<CommercePriceModifierRel>)q.list()) {

				map.put(
					commercePriceModifierRel.getPrimaryKeyObj(),
					commercePriceModifierRel);

				cacheResult(commercePriceModifierRel);

				uncachedPrimaryKeys.remove(
					commercePriceModifierRel.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
					CommercePriceModifierRelImpl.class, primaryKey, nullModel);
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
	 * Returns all the commerce price modifier rels.
	 *
	 * @return the commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce price modifier rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @return the range of commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce price modifier rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePriceModifierRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce price modifier rels
	 * @param end the upper bound of the range of commerce price modifier rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce price modifier rels
	 */
	@Override
	public List<CommercePriceModifierRel> findAll(
		int start, int end,
		OrderByComparator<CommercePriceModifierRel> orderByComparator,
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

		List<CommercePriceModifierRel> list = null;

		if (useFinderCache) {
			list = (List<CommercePriceModifierRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMERCEPRICEMODIFIERREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCEPRICEMODIFIERREL;

				sql = sql.concat(
					CommercePriceModifierRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<CommercePriceModifierRel>)QueryUtil.list(
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
	 * Removes all the commerce price modifier rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommercePriceModifierRel commercePriceModifierRel : findAll()) {
			remove(commercePriceModifierRel);
		}
	}

	/**
	 * Returns the number of commerce price modifier rels.
	 *
	 * @return the number of commerce price modifier rels
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
					_SQL_COUNT_COMMERCEPRICEMODIFIERREL);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return CommercePriceModifierRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce price modifier rel persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCommercePriceModifierId = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCommercePriceModifierId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCommercePriceModifierId =
			new FinderPath(
				CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
				CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
				CommercePriceModifierRelImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCommercePriceModifierId",
				new String[] {Long.class.getName()},
				CommercePriceModifierRelModelImpl.
					COMMERCEPRICEMODIFIERID_COLUMN_BITMASK |
				CommercePriceModifierRelModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByCommercePriceModifierId = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCommercePriceModifierId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCPM_CN = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCPM_CN",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCPM_CN = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCPM_CN",
			new String[] {Long.class.getName(), Long.class.getName()},
			CommercePriceModifierRelModelImpl.
				COMMERCEPRICEMODIFIERID_COLUMN_BITMASK |
			CommercePriceModifierRelModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			CommercePriceModifierRelModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByCPM_CN = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPM_CN",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByCN_CPK = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCN_CPK",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCN_CPK = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED,
			CommercePriceModifierRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCN_CPK",
			new String[] {Long.class.getName(), Long.class.getName()},
			CommercePriceModifierRelModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			CommercePriceModifierRelModelImpl.CLASSPK_COLUMN_BITMASK |
			CommercePriceModifierRelModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByCN_CPK = new FinderPath(
			CommercePriceModifierRelModelImpl.ENTITY_CACHE_ENABLED,
			CommercePriceModifierRelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCN_CPK",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CommercePriceModifierRelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COMMERCEPRICEMODIFIERREL =
		"SELECT commercePriceModifierRel FROM CommercePriceModifierRel commercePriceModifierRel";

	private static final String
		_SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE_PKS_IN =
			"SELECT commercePriceModifierRel FROM CommercePriceModifierRel commercePriceModifierRel WHERE commercePriceModifierRelId IN (";

	private static final String _SQL_SELECT_COMMERCEPRICEMODIFIERREL_WHERE =
		"SELECT commercePriceModifierRel FROM CommercePriceModifierRel commercePriceModifierRel WHERE ";

	private static final String _SQL_COUNT_COMMERCEPRICEMODIFIERREL =
		"SELECT COUNT(commercePriceModifierRel) FROM CommercePriceModifierRel commercePriceModifierRel";

	private static final String _SQL_COUNT_COMMERCEPRICEMODIFIERREL_WHERE =
		"SELECT COUNT(commercePriceModifierRel) FROM CommercePriceModifierRel commercePriceModifierRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"commercePriceModifierRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommercePriceModifierRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommercePriceModifierRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierRelPersistenceImpl.class);

}