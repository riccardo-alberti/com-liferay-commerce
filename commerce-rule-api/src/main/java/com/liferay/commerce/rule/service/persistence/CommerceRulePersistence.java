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

package com.liferay.commerce.rule.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.rule.exception.NoSuchRuleException;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the commerce rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommerceRuleUtil
 * @generated
 */
@ProviderType
public interface CommerceRulePersistence extends BasePersistence<CommerceRule> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommerceRuleUtil} to access the commerce rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CommerceRule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the commerce rules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching commerce rules
	 */
	public java.util.List<CommerceRule> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the commerce rules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @return the range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the commerce rules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commerce rules where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commerce rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce rule
	 * @throws NoSuchRuleException if a matching commerce rule could not be found
	 */
	public CommerceRule findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Returns the first commerce rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce rule, or <code>null</code> if a matching commerce rule could not be found
	 */
	public CommerceRule fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns the last commerce rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce rule
	 * @throws NoSuchRuleException if a matching commerce rule could not be found
	 */
	public CommerceRule findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Returns the last commerce rule in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce rule, or <code>null</code> if a matching commerce rule could not be found
	 */
	public CommerceRule fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns the commerce rules before and after the current commerce rule in the ordered set where companyId = &#63;.
	 *
	 * @param commerceRuleId the primary key of the current commerce rule
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce rule
	 * @throws NoSuchRuleException if a commerce rule with the primary key could not be found
	 */
	public CommerceRule[] findByCompanyId_PrevAndNext(
			long commerceRuleId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Removes all the commerce rules where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of commerce rules where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching commerce rules
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the commerce rules where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @return the matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtD_S(
		Date displayDate, int status);

	/**
	 * Returns a range of all the commerce rules where displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @return the range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtD_S(
		Date displayDate, int status, int start, int end);

	/**
	 * Returns an ordered range of all the commerce rules where displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtD_S(
		Date displayDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commerce rules where displayDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtD_S(
		Date displayDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commerce rule in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce rule
	 * @throws NoSuchRuleException if a matching commerce rule could not be found
	 */
	public CommerceRule findByLtD_S_First(
			Date displayDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Returns the first commerce rule in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce rule, or <code>null</code> if a matching commerce rule could not be found
	 */
	public CommerceRule fetchByLtD_S_First(
		Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns the last commerce rule in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce rule
	 * @throws NoSuchRuleException if a matching commerce rule could not be found
	 */
	public CommerceRule findByLtD_S_Last(
			Date displayDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Returns the last commerce rule in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce rule, or <code>null</code> if a matching commerce rule could not be found
	 */
	public CommerceRule fetchByLtD_S_Last(
		Date displayDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns the commerce rules before and after the current commerce rule in the ordered set where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param commerceRuleId the primary key of the current commerce rule
	 * @param displayDate the display date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce rule
	 * @throws NoSuchRuleException if a commerce rule with the primary key could not be found
	 */
	public CommerceRule[] findByLtD_S_PrevAndNext(
			long commerceRuleId, Date displayDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Removes all the commerce rules where displayDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 */
	public void removeByLtD_S(Date displayDate, int status);

	/**
	 * Returns the number of commerce rules where displayDate &lt; &#63; and status = &#63;.
	 *
	 * @param displayDate the display date
	 * @param status the status
	 * @return the number of matching commerce rules
	 */
	public int countByLtD_S(Date displayDate, int status);

	/**
	 * Returns all the commerce rules where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @return the matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtE_S(
		Date expirationDate, int status);

	/**
	 * Returns a range of all the commerce rules where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @return the range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtE_S(
		Date expirationDate, int status, int start, int end);

	/**
	 * Returns an ordered range of all the commerce rules where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtE_S(
		Date expirationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commerce rules where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce rules
	 */
	public java.util.List<CommerceRule> findByLtE_S(
		Date expirationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first commerce rule in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce rule
	 * @throws NoSuchRuleException if a matching commerce rule could not be found
	 */
	public CommerceRule findByLtE_S_First(
			Date expirationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Returns the first commerce rule in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce rule, or <code>null</code> if a matching commerce rule could not be found
	 */
	public CommerceRule fetchByLtE_S_First(
		Date expirationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns the last commerce rule in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce rule
	 * @throws NoSuchRuleException if a matching commerce rule could not be found
	 */
	public CommerceRule findByLtE_S_Last(
			Date expirationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Returns the last commerce rule in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce rule, or <code>null</code> if a matching commerce rule could not be found
	 */
	public CommerceRule fetchByLtE_S_Last(
		Date expirationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns the commerce rules before and after the current commerce rule in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param commerceRuleId the primary key of the current commerce rule
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce rule
	 * @throws NoSuchRuleException if a commerce rule with the primary key could not be found
	 */
	public CommerceRule[] findByLtE_S_PrevAndNext(
			long commerceRuleId, Date expirationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
				orderByComparator)
		throws NoSuchRuleException;

	/**
	 * Removes all the commerce rules where expirationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 */
	public void removeByLtE_S(Date expirationDate, int status);

	/**
	 * Returns the number of commerce rules where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @return the number of matching commerce rules
	 */
	public int countByLtE_S(Date expirationDate, int status);

	/**
	 * Caches the commerce rule in the entity cache if it is enabled.
	 *
	 * @param commerceRule the commerce rule
	 */
	public void cacheResult(CommerceRule commerceRule);

	/**
	 * Caches the commerce rules in the entity cache if it is enabled.
	 *
	 * @param commerceRules the commerce rules
	 */
	public void cacheResult(java.util.List<CommerceRule> commerceRules);

	/**
	 * Creates a new commerce rule with the primary key. Does not add the commerce rule to the database.
	 *
	 * @param commerceRuleId the primary key for the new commerce rule
	 * @return the new commerce rule
	 */
	public CommerceRule create(long commerceRuleId);

	/**
	 * Removes the commerce rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule that was removed
	 * @throws NoSuchRuleException if a commerce rule with the primary key could not be found
	 */
	public CommerceRule remove(long commerceRuleId) throws NoSuchRuleException;

	public CommerceRule updateImpl(CommerceRule commerceRule);

	/**
	 * Returns the commerce rule with the primary key or throws a <code>NoSuchRuleException</code> if it could not be found.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule
	 * @throws NoSuchRuleException if a commerce rule with the primary key could not be found
	 */
	public CommerceRule findByPrimaryKey(long commerceRuleId)
		throws NoSuchRuleException;

	/**
	 * Returns the commerce rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commerceRuleId the primary key of the commerce rule
	 * @return the commerce rule, or <code>null</code> if a commerce rule with the primary key could not be found
	 */
	public CommerceRule fetchByPrimaryKey(long commerceRuleId);

	/**
	 * Returns all the commerce rules.
	 *
	 * @return the commerce rules
	 */
	public java.util.List<CommerceRule> findAll();

	/**
	 * Returns a range of all the commerce rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @return the range of commerce rules
	 */
	public java.util.List<CommerceRule> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the commerce rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce rules
	 */
	public java.util.List<CommerceRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator);

	/**
	 * Returns an ordered range of all the commerce rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommerceRuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce rules
	 * @param end the upper bound of the range of commerce rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce rules
	 */
	public java.util.List<CommerceRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommerceRule>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the commerce rules from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of commerce rules.
	 *
	 * @return the number of commerce rules
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}