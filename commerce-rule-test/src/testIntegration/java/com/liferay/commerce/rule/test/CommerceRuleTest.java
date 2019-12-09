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

package com.liferay.commerce.rule.test;

import java.util.ArrayList;
import java.util.List;

import org.frutilla.FrutillaRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.service.CommerceCurrencyLocalService;
import com.liferay.commerce.currency.test.util.CommerceCurrencyTestUtil;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.product.test.util.CPTestUtil;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.commerce.rule.service.CommerceRuleService;
import com.liferay.commerce.rule.type.CommerceRuleType;
import com.liferay.commerce.rule.type.CommerceRuleTypeRegistry;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.test.util.CommerceInventoryTestUtil;
import com.liferay.commerce.test.util.CommerceTestUtil;
import com.liferay.commerce.test.util.TestCommerceContext;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerTestRule;

/**
 * @author Riccardo Alberti
 */
@RunWith(Arquillian.class)
public class CommerceRuleTest {
	
	@ClassRule
	@Rule
	public static AggregateTestRule aggregateTestRule = new AggregateTestRule(
		new LiferayIntegrationTestRule(), PermissionCheckerTestRule.INSTANCE);
	
	@Before
	public void setUp() throws Exception {
		_user = UserTestUtil.addUser();
		_commerceOrders = new ArrayList<>();

		_commerceCurrency = CommerceCurrencyTestUtil.addCommerceCurrency();

		_commerceChannel = CommerceTestUtil.addCommerceChannel(
			_commerceCurrency.getCode());
	}
	
	@Test
	public void testRuleAddedAll() throws Exception {
		List<CommerceRuleType> commerceRuleTypes = _commerceRuleTypRegistry.getCommerceRuleTypes();
		
		Assert.assertNotEquals(0, commerceRuleTypes.size());
		
		CommerceRuleType commerceRuleType = _commerceRuleTypRegistry.getCommerceRuleType("added-all");
		
		CommerceOrder commerceOrder = CommerceTestUtil.addB2CCommerceOrder(
				_user.getUserId(), _commerceChannel.getSiteGroupId(),
				_commerceCurrency);
		
		CPInstance cpInstance = CPTestUtil.addCPInstance();
		
		CommerceInventoryWarehouse commerceInventoryWarehouse =
				CommerceInventoryTestUtil.addCommerceInventoryWarehouse();

			CommerceTestUtil.addWarehouseCommerceChannelRel(
				commerceInventoryWarehouse.getCommerceInventoryWarehouseId(),
				_commerceChannel.getCommerceChannelId());

			CommerceInventoryTestUtil.addCommerceInventoryWarehouseItem(
				_user.getUserId(), commerceInventoryWarehouse, cpInstance.getSku(),
				10);
		
		CommerceTestUtil.addCommerceOrderItem(
				commerceOrder.getCommerceOrderId(),
				cpInstance.getCPInstanceId(), 1);
		
		CommerceRule commerceRule = _commerceRuleService.addCommerceRule("added-all", 
				String.valueOf(cpInstance.getCPDefinitionId()), RandomTestUtil.randomString() ,ServiceContextTestUtil.getServiceContext(_user.getGroupId()));
		
		CommerceContext commerceContext = new TestCommerceContext(
				commerceOrder.getCommerceCurrency(), _commerceChannel, null, null,
				null, commerceOrder);
		
		boolean commerceRuleEvaluate = commerceRuleType.evaluate(commerceRule, commerceContext);
		
		Assert.assertEquals(true, commerceRuleEvaluate);
	}
	
	@Inject
	private CommerceRuleTypeRegistry _commerceRuleTypRegistry;
	
	@Inject
	private CommerceRuleService _commerceRuleService;
	
	@Rule
	public FrutillaRule frutillaRule = new FrutillaRule();

	private CommerceChannel _commerceChannel;

	@Inject
	private CommerceChannelLocalService _commerceChannelLocalService;

	private CommerceCurrency _commerceCurrency;

	@Inject
	private CommerceCurrencyLocalService _commerceCurrencyLocalService;

	@Inject
	private CommerceInventoryWarehouseItemLocalService
		_commerceInventoryWarehouseItemLocalService;

	@Inject
	private CommerceOrderLocalService _commerceOrderLocalService;

	private List<CommerceOrder> _commerceOrders;
	private User _user;

	@Inject
	private UserLocalService _userLocalService;
}
