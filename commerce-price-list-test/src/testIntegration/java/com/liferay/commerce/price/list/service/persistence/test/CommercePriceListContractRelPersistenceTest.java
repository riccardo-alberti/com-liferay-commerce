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
import com.liferay.commerce.price.list.exception.NoSuchPriceListContractRelException;
import com.liferay.commerce.price.list.model.CommercePriceListContractRel;
import com.liferay.commerce.price.list.service.CommercePriceListContractRelLocalServiceUtil;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListContractRelPersistence;
import com.liferay.commerce.price.list.service.persistence.CommercePriceListContractRelUtil;
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
public class CommercePriceListContractRelPersistenceTest {

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
		_persistence = CommercePriceListContractRelUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CommercePriceListContractRel> iterator =
			_commercePriceListContractRels.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListContractRel commercePriceListContractRel =
			_persistence.create(pk);

		Assert.assertNotNull(commercePriceListContractRel);

		Assert.assertEquals(commercePriceListContractRel.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		_persistence.remove(newCommercePriceListContractRel);

		CommercePriceListContractRel existingCommercePriceListContractRel =
			_persistence.fetchByPrimaryKey(
				newCommercePriceListContractRel.getPrimaryKey());

		Assert.assertNull(existingCommercePriceListContractRel);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCommercePriceListContractRel();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListContractRel newCommercePriceListContractRel =
			_persistence.create(pk);

		newCommercePriceListContractRel.setUuid(RandomTestUtil.randomString());

		newCommercePriceListContractRel.setCompanyId(RandomTestUtil.nextLong());

		newCommercePriceListContractRel.setUserId(RandomTestUtil.nextLong());

		newCommercePriceListContractRel.setUserName(
			RandomTestUtil.randomString());

		newCommercePriceListContractRel.setCreateDate(
			RandomTestUtil.nextDate());

		newCommercePriceListContractRel.setModifiedDate(
			RandomTestUtil.nextDate());

		newCommercePriceListContractRel.setCommerceContractId(
			RandomTestUtil.nextLong());

		newCommercePriceListContractRel.setCommercePriceListId(
			RandomTestUtil.nextLong());

		newCommercePriceListContractRel.setOrder(RandomTestUtil.nextInt());

		newCommercePriceListContractRel.setLastPublishDate(
			RandomTestUtil.nextDate());

		_commercePriceListContractRels.add(
			_persistence.update(newCommercePriceListContractRel));

		CommercePriceListContractRel existingCommercePriceListContractRel =
			_persistence.findByPrimaryKey(
				newCommercePriceListContractRel.getPrimaryKey());

		Assert.assertEquals(
			existingCommercePriceListContractRel.getUuid(),
			newCommercePriceListContractRel.getUuid());
		Assert.assertEquals(
			existingCommercePriceListContractRel.
				getCommercePriceListContractRelId(),
			newCommercePriceListContractRel.
				getCommercePriceListContractRelId());
		Assert.assertEquals(
			existingCommercePriceListContractRel.getCompanyId(),
			newCommercePriceListContractRel.getCompanyId());
		Assert.assertEquals(
			existingCommercePriceListContractRel.getUserId(),
			newCommercePriceListContractRel.getUserId());
		Assert.assertEquals(
			existingCommercePriceListContractRel.getUserName(),
			newCommercePriceListContractRel.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCommercePriceListContractRel.getCreateDate()),
			Time.getShortTimestamp(
				newCommercePriceListContractRel.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCommercePriceListContractRel.getModifiedDate()),
			Time.getShortTimestamp(
				newCommercePriceListContractRel.getModifiedDate()));
		Assert.assertEquals(
			existingCommercePriceListContractRel.getCommerceContractId(),
			newCommercePriceListContractRel.getCommerceContractId());
		Assert.assertEquals(
			existingCommercePriceListContractRel.getCommercePriceListId(),
			newCommercePriceListContractRel.getCommercePriceListId());
		Assert.assertEquals(
			existingCommercePriceListContractRel.getOrder(),
			newCommercePriceListContractRel.getOrder());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingCommercePriceListContractRel.getLastPublishDate()),
			Time.getShortTimestamp(
				newCommercePriceListContractRel.getLastPublishDate()));
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
	public void testCountByC_C() throws Exception {
		_persistence.countByC_C(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByC_C(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		CommercePriceListContractRel existingCommercePriceListContractRel =
			_persistence.findByPrimaryKey(
				newCommercePriceListContractRel.getPrimaryKey());

		Assert.assertEquals(
			existingCommercePriceListContractRel,
			newCommercePriceListContractRel);
	}

	@Test(expected = NoSuchPriceListContractRelException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CommercePriceListContractRel>
		getOrderByComparator() {

		return OrderByComparatorFactoryUtil.create(
			"CommercePriceListContractRel", "uuid", true,
			"commercePriceListContractRelId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"commerceContractId", true, "commercePriceListId", true, "order",
			true, "lastPublishDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		CommercePriceListContractRel existingCommercePriceListContractRel =
			_persistence.fetchByPrimaryKey(
				newCommercePriceListContractRel.getPrimaryKey());

		Assert.assertEquals(
			existingCommercePriceListContractRel,
			newCommercePriceListContractRel);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CommercePriceListContractRel missingCommercePriceListContractRel =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCommercePriceListContractRel);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CommercePriceListContractRel newCommercePriceListContractRel1 =
			addCommercePriceListContractRel();
		CommercePriceListContractRel newCommercePriceListContractRel2 =
			addCommercePriceListContractRel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercePriceListContractRel1.getPrimaryKey());
		primaryKeys.add(newCommercePriceListContractRel2.getPrimaryKey());

		Map<Serializable, CommercePriceListContractRel>
			commercePriceListContractRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(2, commercePriceListContractRels.size());
		Assert.assertEquals(
			newCommercePriceListContractRel1,
			commercePriceListContractRels.get(
				newCommercePriceListContractRel1.getPrimaryKey()));
		Assert.assertEquals(
			newCommercePriceListContractRel2,
			commercePriceListContractRels.get(
				newCommercePriceListContractRel2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CommercePriceListContractRel>
			commercePriceListContractRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(commercePriceListContractRels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercePriceListContractRel.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CommercePriceListContractRel>
			commercePriceListContractRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, commercePriceListContractRels.size());
		Assert.assertEquals(
			newCommercePriceListContractRel,
			commercePriceListContractRels.get(
				newCommercePriceListContractRel.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CommercePriceListContractRel>
			commercePriceListContractRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(commercePriceListContractRels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercePriceListContractRel.getPrimaryKey());

		Map<Serializable, CommercePriceListContractRel>
			commercePriceListContractRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, commercePriceListContractRels.size());
		Assert.assertEquals(
			newCommercePriceListContractRel,
			commercePriceListContractRels.get(
				newCommercePriceListContractRel.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CommercePriceListContractRelLocalServiceUtil.
				getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<CommercePriceListContractRel>() {

				@Override
				public void performAction(
					CommercePriceListContractRel commercePriceListContractRel) {

					Assert.assertNotNull(commercePriceListContractRel);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListContractRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"commercePriceListContractRelId",
				newCommercePriceListContractRel.
					getCommercePriceListContractRelId()));

		List<CommercePriceListContractRel> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CommercePriceListContractRel existingCommercePriceListContractRel =
			result.get(0);

		Assert.assertEquals(
			existingCommercePriceListContractRel,
			newCommercePriceListContractRel);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListContractRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"commercePriceListContractRelId", RandomTestUtil.nextLong()));

		List<CommercePriceListContractRel> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListContractRel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("commercePriceListContractRelId"));

		Object newCommercePriceListContractRelId =
			newCommercePriceListContractRel.getCommercePriceListContractRelId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"commercePriceListContractRelId",
				new Object[] {newCommercePriceListContractRelId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCommercePriceListContractRelId = result.get(0);

		Assert.assertEquals(
			existingCommercePriceListContractRelId,
			newCommercePriceListContractRelId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CommercePriceListContractRel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("commercePriceListContractRelId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"commercePriceListContractRelId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CommercePriceListContractRel newCommercePriceListContractRel =
			addCommercePriceListContractRel();

		_persistence.clearCache();

		CommercePriceListContractRel existingCommercePriceListContractRel =
			_persistence.findByPrimaryKey(
				newCommercePriceListContractRel.getPrimaryKey());

		Assert.assertEquals(
			Long.valueOf(
				existingCommercePriceListContractRel.getCommerceContractId()),
			ReflectionTestUtil.<Long>invoke(
				existingCommercePriceListContractRel,
				"getOriginalCommerceContractId", new Class<?>[0]));
		Assert.assertEquals(
			Long.valueOf(
				existingCommercePriceListContractRel.getCommercePriceListId()),
			ReflectionTestUtil.<Long>invoke(
				existingCommercePriceListContractRel,
				"getOriginalCommercePriceListId", new Class<?>[0]));
	}

	protected CommercePriceListContractRel addCommercePriceListContractRel()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		CommercePriceListContractRel commercePriceListContractRel =
			_persistence.create(pk);

		commercePriceListContractRel.setUuid(RandomTestUtil.randomString());

		commercePriceListContractRel.setCompanyId(RandomTestUtil.nextLong());

		commercePriceListContractRel.setUserId(RandomTestUtil.nextLong());

		commercePriceListContractRel.setUserName(RandomTestUtil.randomString());

		commercePriceListContractRel.setCreateDate(RandomTestUtil.nextDate());

		commercePriceListContractRel.setModifiedDate(RandomTestUtil.nextDate());

		commercePriceListContractRel.setCommerceContractId(
			RandomTestUtil.nextLong());

		commercePriceListContractRel.setCommercePriceListId(
			RandomTestUtil.nextLong());

		commercePriceListContractRel.setOrder(RandomTestUtil.nextInt());

		commercePriceListContractRel.setLastPublishDate(
			RandomTestUtil.nextDate());

		_commercePriceListContractRels.add(
			_persistence.update(commercePriceListContractRel));

		return commercePriceListContractRel;
	}

	private List<CommercePriceListContractRel> _commercePriceListContractRels =
		new ArrayList<CommercePriceListContractRel>();
	private CommercePriceListContractRelPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}