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

package com.liferay.commerce.rule.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.rule.exception.NoSuchRuleException;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.service.CommerceRuleLocalServiceUtil;
import com.liferay.commerce.rule.service.persistence.CommerceRulePersistence;
import com.liferay.commerce.rule.service.persistence.CommerceRuleUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CommerceRulePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.commerce.rule.service"));

	@Before
	public void setUp() {
		_persistence = CommerceRuleUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CommerceRule> iterator = _commerceRules.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommerceRule commerceRule = _persistence.create(pk);

		Assert.assertNotNull(commerceRule);

		Assert.assertEquals(commerceRule.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CommerceRule newCommerceRule = addCommerceRule();

		_persistence.remove(newCommerceRule);

		CommerceRule existingCommerceRule = _persistence.fetchByPrimaryKey(
			newCommerceRule.getPrimaryKey());

		Assert.assertNull(existingCommerceRule);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCommerceRule();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommerceRule newCommerceRule = _persistence.create(pk);

		newCommerceRule.setCompanyId(RandomTestUtil.nextLong());

		newCommerceRule.setUserId(RandomTestUtil.nextLong());

		newCommerceRule.setUserName(RandomTestUtil.randomString());

		newCommerceRule.setCreateDate(RandomTestUtil.nextDate());

		newCommerceRule.setModifiedDate(RandomTestUtil.nextDate());

		newCommerceRule.setDescription(RandomTestUtil.randomString());

		newCommerceRule.setTitle(RandomTestUtil.randomString());

		newCommerceRule.setType(RandomTestUtil.randomString());

		newCommerceRule.setTypeSettings(RandomTestUtil.randomString());

		newCommerceRule.setDisplayDate(RandomTestUtil.nextDate());

		newCommerceRule.setExpirationDate(RandomTestUtil.nextDate());

		newCommerceRule.setLastPublishDate(RandomTestUtil.nextDate());

		newCommerceRule.setStatus(RandomTestUtil.nextInt());

		newCommerceRule.setStatusByUserId(RandomTestUtil.nextLong());

		newCommerceRule.setStatusByUserName(RandomTestUtil.randomString());

		newCommerceRule.setStatusDate(RandomTestUtil.nextDate());

		_commerceRules.add(_persistence.update(newCommerceRule));

		CommerceRule existingCommerceRule = _persistence.findByPrimaryKey(
			newCommerceRule.getPrimaryKey());

		Assert.assertEquals(
			existingCommerceRule.getCommerceRuleId(),
			newCommerceRule.getCommerceRuleId());
		Assert.assertEquals(
			existingCommerceRule.getCompanyId(),
			newCommerceRule.getCompanyId());
		Assert.assertEquals(
			existingCommerceRule.getUserId(), newCommerceRule.getUserId());
		Assert.assertEquals(
			existingCommerceRule.getUserName(), newCommerceRule.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommerceRule.getCreateDate()),
			Time.getShortTimestamp(newCommerceRule.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommerceRule.getModifiedDate()),
			Time.getShortTimestamp(newCommerceRule.getModifiedDate()));
		Assert.assertEquals(
			existingCommerceRule.getDescription(),
			newCommerceRule.getDescription());
		Assert.assertEquals(
			existingCommerceRule.getTitle(), newCommerceRule.getTitle());
		Assert.assertEquals(
			existingCommerceRule.getType(), newCommerceRule.getType());
		Assert.assertEquals(
			existingCommerceRule.getTypeSettings(),
			newCommerceRule.getTypeSettings());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommerceRule.getDisplayDate()),
			Time.getShortTimestamp(newCommerceRule.getDisplayDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommerceRule.getExpirationDate()),
			Time.getShortTimestamp(newCommerceRule.getExpirationDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommerceRule.getLastPublishDate()),
			Time.getShortTimestamp(newCommerceRule.getLastPublishDate()));
		Assert.assertEquals(
			existingCommerceRule.getStatus(), newCommerceRule.getStatus());
		Assert.assertEquals(
			existingCommerceRule.getStatusByUserId(),
			newCommerceRule.getStatusByUserId());
		Assert.assertEquals(
			existingCommerceRule.getStatusByUserName(),
			newCommerceRule.getStatusByUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommerceRule.getStatusDate()),
			Time.getShortTimestamp(newCommerceRule.getStatusDate()));
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByLtD_S() throws Exception {
		_persistence.countByLtD_S(
			RandomTestUtil.nextDate(), RandomTestUtil.nextInt());

		_persistence.countByLtD_S(RandomTestUtil.nextDate(), 0);
	}

	@Test
	public void testCountByLtE_S() throws Exception {
		_persistence.countByLtE_S(
			RandomTestUtil.nextDate(), RandomTestUtil.nextInt());

		_persistence.countByLtE_S(RandomTestUtil.nextDate(), 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CommerceRule newCommerceRule = addCommerceRule();

		CommerceRule existingCommerceRule = _persistence.findByPrimaryKey(
			newCommerceRule.getPrimaryKey());

		Assert.assertEquals(existingCommerceRule, newCommerceRule);
	}

	@Test(expected = NoSuchRuleException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CommerceRule> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CommerceRule", "commerceRuleId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"description", true, "title", true, "type", true, "typeSettings",
			true, "displayDate", true, "expirationDate", true,
			"lastPublishDate", true, "status", true, "statusByUserId", true,
			"statusByUserName", true, "statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CommerceRule newCommerceRule = addCommerceRule();

		CommerceRule existingCommerceRule = _persistence.fetchByPrimaryKey(
			newCommerceRule.getPrimaryKey());

		Assert.assertEquals(existingCommerceRule, newCommerceRule);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommerceRule missingCommerceRule = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCommerceRule);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CommerceRule newCommerceRule1 = addCommerceRule();
		CommerceRule newCommerceRule2 = addCommerceRule();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommerceRule1.getPrimaryKey());
		primaryKeys.add(newCommerceRule2.getPrimaryKey());

		Map<Serializable, CommerceRule> commerceRules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, commerceRules.size());
		Assert.assertEquals(
			newCommerceRule1,
			commerceRules.get(newCommerceRule1.getPrimaryKey()));
		Assert.assertEquals(
			newCommerceRule2,
			commerceRules.get(newCommerceRule2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CommerceRule> commerceRules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commerceRules.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CommerceRule newCommerceRule = addCommerceRule();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommerceRule.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CommerceRule> commerceRules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commerceRules.size());
		Assert.assertEquals(
			newCommerceRule,
			commerceRules.get(newCommerceRule.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CommerceRule> commerceRules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commerceRules.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CommerceRule newCommerceRule = addCommerceRule();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommerceRule.getPrimaryKey());

		Map<Serializable, CommerceRule> commerceRules =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commerceRules.size());
		Assert.assertEquals(
			newCommerceRule,
			commerceRules.get(newCommerceRule.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CommerceRuleLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CommerceRule>() {

				@Override
				public void performAction(CommerceRule commerceRule) {
					Assert.assertNotNull(commerceRule);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CommerceRule newCommerceRule = addCommerceRule();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommerceRule.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"commerceRuleId", newCommerceRule.getCommerceRuleId()));

		List<CommerceRule> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CommerceRule existingCommerceRule = result.get(0);

		Assert.assertEquals(existingCommerceRule, newCommerceRule);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommerceRule.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"commerceRuleId", RandomTestUtil.nextLong()));

		List<CommerceRule> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CommerceRule newCommerceRule = addCommerceRule();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommerceRule.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("commerceRuleId"));

		Object newCommerceRuleId = newCommerceRule.getCommerceRuleId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"commerceRuleId", new Object[] {newCommerceRuleId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCommerceRuleId = result.get(0);

		Assert.assertEquals(existingCommerceRuleId, newCommerceRuleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommerceRule.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("commerceRuleId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"commerceRuleId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CommerceRule addCommerceRule() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommerceRule commerceRule = _persistence.create(pk);

		commerceRule.setCompanyId(RandomTestUtil.nextLong());

		commerceRule.setUserId(RandomTestUtil.nextLong());

		commerceRule.setUserName(RandomTestUtil.randomString());

		commerceRule.setCreateDate(RandomTestUtil.nextDate());

		commerceRule.setModifiedDate(RandomTestUtil.nextDate());

		commerceRule.setDescription(RandomTestUtil.randomString());

		commerceRule.setTitle(RandomTestUtil.randomString());

		commerceRule.setType(RandomTestUtil.randomString());

		commerceRule.setTypeSettings(RandomTestUtil.randomString());

		commerceRule.setDisplayDate(RandomTestUtil.nextDate());

		commerceRule.setExpirationDate(RandomTestUtil.nextDate());

		commerceRule.setLastPublishDate(RandomTestUtil.nextDate());

		commerceRule.setStatus(RandomTestUtil.nextInt());

		commerceRule.setStatusByUserId(RandomTestUtil.nextLong());

		commerceRule.setStatusByUserName(RandomTestUtil.randomString());

		commerceRule.setStatusDate(RandomTestUtil.nextDate());

		_commerceRules.add(_persistence.update(commerceRule));

		return commerceRule;
	}

	private List<CommerceRule> _commerceRules = new ArrayList<CommerceRule>();
	private CommerceRulePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}