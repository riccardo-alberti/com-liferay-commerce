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

package com.liferay.commerce.price.list.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.price.list.exception.NoSuchPriceListRelException;
import com.liferay.commerce.price.list.model.CommercePriceListRel;
import com.liferay.commerce.price.list.service.CommercePriceListRelLocalServiceUtil;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListRelPersistence;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListRelUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
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
public class CommercePriceListRelPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.commerce.price.list.service"));

	@Before
	public void setUp() {
		_persistence = CommercePriceListRelUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CommercePriceListRel> iterator =
			_commercePriceListRels.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListRel commercePriceListRel = _persistence.create(pk);

		Assert.assertNotNull(commercePriceListRel);

		Assert.assertEquals(commercePriceListRel.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		_persistence.remove(newCommercePriceListRel);

		CommercePriceListRel existingCommercePriceListRel =
			_persistence.fetchByPrimaryKey(
				newCommercePriceListRel.getPrimaryKey());

		Assert.assertNull(existingCommercePriceListRel);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCommercePriceListRel();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListRel newCommercePriceListRel = _persistence.create(pk);

		newCommercePriceListRel.setUuid(RandomTestUtil.randomString());

		newCommercePriceListRel.setCompanyId(RandomTestUtil.nextLong());

		newCommercePriceListRel.setUserId(RandomTestUtil.nextLong());

		newCommercePriceListRel.setUserName(RandomTestUtil.randomString());

		newCommercePriceListRel.setCreateDate(RandomTestUtil.nextDate());

		newCommercePriceListRel.setModifiedDate(RandomTestUtil.nextDate());

		newCommercePriceListRel.setClassNameId(RandomTestUtil.nextLong());

		newCommercePriceListRel.setClassPK(RandomTestUtil.nextLong());

		newCommercePriceListRel.setCommercePriceListId(
			RandomTestUtil.nextLong());

		newCommercePriceListRel.setOrder(RandomTestUtil.nextInt());

		newCommercePriceListRel.setLastPublishDate(RandomTestUtil.nextDate());

		_commercePriceListRels.add(
			_persistence.update(newCommercePriceListRel));

		CommercePriceListRel existingCommercePriceListRel =
			_persistence.findByPrimaryKey(
				newCommercePriceListRel.getPrimaryKey());

		Assert.assertEquals(
			existingCommercePriceListRel.getUuid(),
			newCommercePriceListRel.getUuid());
		Assert.assertEquals(
			existingCommercePriceListRel.getCommercePriceListRelId(),
			newCommercePriceListRel.getCommercePriceListRelId());
		Assert.assertEquals(
			existingCommercePriceListRel.getCompanyId(),
			newCommercePriceListRel.getCompanyId());
		Assert.assertEquals(
			existingCommercePriceListRel.getUserId(),
			newCommercePriceListRel.getUserId());
		Assert.assertEquals(
			existingCommercePriceListRel.getUserName(),
			newCommercePriceListRel.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCommercePriceListRel.getCreateDate()),
			Time.getShortTimestamp(newCommercePriceListRel.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCommercePriceListRel.getModifiedDate()),
			Time.getShortTimestamp(newCommercePriceListRel.getModifiedDate()));
		Assert.assertEquals(
			existingCommercePriceListRel.getClassNameId(),
			newCommercePriceListRel.getClassNameId());
		Assert.assertEquals(
			existingCommercePriceListRel.getClassPK(),
			newCommercePriceListRel.getClassPK());
		Assert.assertEquals(
			existingCommercePriceListRel.getCommercePriceListId(),
			newCommercePriceListRel.getCommercePriceListId());
		Assert.assertEquals(
			existingCommercePriceListRel.getOrder(),
			newCommercePriceListRel.getOrder());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCommercePriceListRel.getLastPublishDate()),
			Time.getShortTimestamp(
				newCommercePriceListRel.getLastPublishDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByCommercePriceListId() throws Exception {
		_persistence.countByCommercePriceListId(RandomTestUtil.nextLong());

		_persistence.countByCommercePriceListId(0L);
	}

	@Test
	public void testCountByC_CN() throws Exception {
		_persistence.countByC_CN(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByC_CN(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		CommercePriceListRel existingCommercePriceListRel =
			_persistence.findByPrimaryKey(
				newCommercePriceListRel.getPrimaryKey());

		Assert.assertEquals(
			existingCommercePriceListRel, newCommercePriceListRel);
	}

	@Test(expected = NoSuchPriceListRelException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CommercePriceListRel> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CommercePriceListRel", "uuid", true, "commercePriceListRelId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "classNameId", true,
			"classPK", true, "commercePriceListId", true, "order", true,
			"lastPublishDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		CommercePriceListRel existingCommercePriceListRel =
			_persistence.fetchByPrimaryKey(
				newCommercePriceListRel.getPrimaryKey());

		Assert.assertEquals(
			existingCommercePriceListRel, newCommercePriceListRel);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListRel missingCommercePriceListRel =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCommercePriceListRel);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CommercePriceListRel newCommercePriceListRel1 =
			addCommercePriceListRel();
		CommercePriceListRel newCommercePriceListRel2 =
			addCommercePriceListRel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercePriceListRel1.getPrimaryKey());
		primaryKeys.add(newCommercePriceListRel2.getPrimaryKey());

		Map<Serializable, CommercePriceListRel> commercePriceListRels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, commercePriceListRels.size());
		Assert.assertEquals(
			newCommercePriceListRel1,
			commercePriceListRels.get(
				newCommercePriceListRel1.getPrimaryKey()));
		Assert.assertEquals(
			newCommercePriceListRel2,
			commercePriceListRels.get(
				newCommercePriceListRel2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CommercePriceListRel> commercePriceListRels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commercePriceListRels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercePriceListRel.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CommercePriceListRel> commercePriceListRels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commercePriceListRels.size());
		Assert.assertEquals(
			newCommercePriceListRel,
			commercePriceListRels.get(newCommercePriceListRel.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CommercePriceListRel> commercePriceListRels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commercePriceListRels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercePriceListRel.getPrimaryKey());

		Map<Serializable, CommercePriceListRel> commercePriceListRels =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commercePriceListRels.size());
		Assert.assertEquals(
			newCommercePriceListRel,
			commercePriceListRels.get(newCommercePriceListRel.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CommercePriceListRelLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<CommercePriceListRel>() {

				@Override
				public void performAction(
					CommercePriceListRel commercePriceListRel) {

					Assert.assertNotNull(commercePriceListRel);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"commercePriceListRelId",
				newCommercePriceListRel.getCommercePriceListRelId()));

		List<CommercePriceListRel> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CommercePriceListRel existingCommercePriceListRel = result.get(0);

		Assert.assertEquals(
			existingCommercePriceListRel, newCommercePriceListRel);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"commercePriceListRelId", RandomTestUtil.nextLong()));

		List<CommercePriceListRel> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListRel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("commercePriceListRelId"));

		Object newCommercePriceListRelId =
			newCommercePriceListRel.getCommercePriceListRelId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"commercePriceListRelId",
				new Object[] {newCommercePriceListRelId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCommercePriceListRelId = result.get(0);

		Assert.assertEquals(
			existingCommercePriceListRelId, newCommercePriceListRelId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListRel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("commercePriceListRelId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"commercePriceListRelId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CommercePriceListRel newCommercePriceListRel =
			addCommercePriceListRel();

		_persistence.clearCache();

		CommercePriceListRel existingCommercePriceListRel =
			_persistence.findByPrimaryKey(
				newCommercePriceListRel.getPrimaryKey());

		Assert.assertEquals(
			Long.valueOf(existingCommercePriceListRel.getClassNameId()),
			ReflectionTestUtil.<Long>invoke(
				existingCommercePriceListRel, "getOriginalClassNameId",
				new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(existingCommercePriceListRel.getCommercePriceListId()),
			ReflectionTestUtil.<Long>invoke(
				existingCommercePriceListRel, "getOriginalCommercePriceListId",
				new Class<?>[0]));
	}

	protected CommercePriceListRel addCommercePriceListRel() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListRel commercePriceListRel = _persistence.create(pk);

		commercePriceListRel.setUuid(RandomTestUtil.randomString());

		commercePriceListRel.setCompanyId(RandomTestUtil.nextLong());

		commercePriceListRel.setUserId(RandomTestUtil.nextLong());

		commercePriceListRel.setUserName(RandomTestUtil.randomString());

		commercePriceListRel.setCreateDate(RandomTestUtil.nextDate());

		commercePriceListRel.setModifiedDate(RandomTestUtil.nextDate());

		commercePriceListRel.setClassNameId(RandomTestUtil.nextLong());

		commercePriceListRel.setClassPK(RandomTestUtil.nextLong());

		commercePriceListRel.setCommercePriceListId(RandomTestUtil.nextLong());

		commercePriceListRel.setOrder(RandomTestUtil.nextInt());

		commercePriceListRel.setLastPublishDate(RandomTestUtil.nextDate());

		_commercePriceListRels.add(_persistence.update(commercePriceListRel));

		return commercePriceListRel;
	}

	private List<CommercePriceListRel> _commercePriceListRels =
		new ArrayList<CommercePriceListRel>();
	private CommercePriceListRelPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}