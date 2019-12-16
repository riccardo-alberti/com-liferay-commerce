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

package com.liferay.commerce.price.modifier.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.model.CommerceMoney;
import com.liferay.commerce.currency.service.CommerceCurrencyLocalService;
import com.liferay.commerce.currency.test.util.CommerceCurrencyTestUtil;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.price.CommerceProductPrice;
import com.liferay.commerce.price.CommerceProductPriceCalculation;
import com.liferay.commerce.price.CommerceProductPriceCalculationRegistry;
import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.list.service.CommercePriceEntryLocalService;
import com.liferay.commerce.price.modifer.test.util.CommercePriceListTestUtil;
import com.liferay.commerce.price.modifer.test.util.CommercePriceModifierTestUtil;
import com.liferay.commerce.price.modifier.constants.CommercePriceModifierConstants;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalService;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil;
import com.liferay.commerce.product.service.CommerceCatalogLocalServiceUtil;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.product.test.util.CPTestUtil;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.test.util.CommerceTestUtil;
import com.liferay.commerce.test.util.TestCommerceContext;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerTestRule;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import org.frutilla.FrutillaRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Riccardo Alberti
 */
@RunWith(Arquillian.class)
public class CommercePriceModifierTest {

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

		_commerceAccount = CommerceTestUtil.addAccount(
			_user.getGroupId(), _user.getUserId());

		_commerceProductPriceCalculation =
			_commerceProductPriceCalculationRegistry.getCommerceProductPrice(
				"CommerceProductPLPriceCalculationImpl");
	}

	@Test
	public void testAddMultiplePriceListPriceModifierAbsolute()
		throws Exception {

		String name = RandomTestUtil.randomString();

		List<CommerceCatalog> commerceCatalogs =
			CommerceCatalogLocalServiceUtil.getCommerceCatalogs(
				_user.getCompanyId(), true);

		CommerceCatalog commerceCatalog = commerceCatalogs.get(0);

		CPInstance cpInstance = CPTestUtil.addCPInstance(
			commerceCatalog.getGroupId());

		CPDefinition cpDefinition =
			CPDefinitionLocalServiceUtil.getCPDefinition(
				cpInstance.getCPDefinitionId());

		_commercePriceList = CommercePriceListTestUtil.addCommercePriceList(
			commerceCatalog.getGroupId(), _commerceCurrency.getCode(), name,
			RandomTestUtil.randomDouble(), true, null, null, null);

		BigDecimal priceEntryPrice = BigDecimal.valueOf(10);
		BigDecimal promoPrice = BigDecimal.valueOf(0);

		_commercePriceEntryLocalService.addCommercePriceEntry(
			cpDefinition.getCProductId(), cpInstance.getCPInstanceUuid(),
			_commercePriceList.getCommercePriceListId(),
			RandomTestUtil.randomString(), priceEntryPrice, promoPrice,
			ServiceContextTestUtil.getServiceContext(
				_commercePriceList.getGroupId()));

		BigDecimal amount = BigDecimal.valueOf(1);

		CommerceContext commerceContext = new TestCommerceContext(
			_commerceCurrency, null, null, _user.getGroup(), _commerceAccount,
			null);

		_commercePriceModifier =
			CommercePriceModifierTestUtil.addCommercePriceModifierAbsolute(
				_user.getUserId(), _commercePriceList.getGroupId(),
				CommercePriceModifierConstants.TARGET_PRICELIST, amount, 10);

		CommercePriceModifierTestUtil.addCommercePriceModifierRelPricelist(
			_commercePriceModifier.getCommercePriceModifierId(),
			_commercePriceList.getGroupId(),
			_commercePriceList.getCommercePriceListId());

		amount = BigDecimal.valueOf(2);

		_commercePriceModifier =
			CommercePriceModifierTestUtil.addCommercePriceModifierAbsolute(
				_user.getUserId(), _commercePriceList.getGroupId(),
				CommercePriceModifierConstants.TARGET_PRICELIST, amount, 3);

		CommercePriceModifierTestUtil.addCommercePriceModifierRelPricelist(
			_commercePriceModifier.getCommercePriceModifierId(),
			_commercePriceList.getGroupId(),
			_commercePriceList.getCommercePriceListId());

		CommerceProductPrice commerceProductPrice =
			_commerceProductPriceCalculation.getCommerceProductPrice(
				cpInstance.getCPInstanceId(), 1, commerceContext);

		CommerceMoney finalCommerceMoney = commerceProductPrice.getFinalPrice();

		BigDecimal finalPrice = finalCommerceMoney.getPrice();

		BigDecimal discountedPrice = priceEntryPrice.subtract(amount);

		Assert.assertEquals(
			discountedPrice.doubleValue(), finalPrice.doubleValue(), 0);
	}

	@Test
	public void testAddPriceListPriceModifierAbsolute() throws Exception {
		String name = RandomTestUtil.randomString();

		List<CommerceCatalog> commerceCatalogs =
			CommerceCatalogLocalServiceUtil.getCommerceCatalogs(
				_user.getCompanyId(), true);

		CommerceCatalog commerceCatalog = commerceCatalogs.get(0);

		CPInstance cpInstance = CPTestUtil.addCPInstance(
			commerceCatalog.getGroupId());

		CPDefinition cpDefinition =
			CPDefinitionLocalServiceUtil.getCPDefinition(
				cpInstance.getCPDefinitionId());

		_commercePriceList = CommercePriceListTestUtil.addCommercePriceList(
			commerceCatalog.getGroupId(), _commerceCurrency.getCode(), name,
			RandomTestUtil.randomDouble(), true, null, null, null);

		BigDecimal priceEntryPrice = BigDecimal.valueOf(10);
		BigDecimal promoPrice = BigDecimal.valueOf(0);

		_commercePriceEntryLocalService.addCommercePriceEntry(
			cpDefinition.getCProductId(), cpInstance.getCPInstanceUuid(),
			_commercePriceList.getCommercePriceListId(),
			RandomTestUtil.randomString(), priceEntryPrice, promoPrice,
			ServiceContextTestUtil.getServiceContext(
				_commercePriceList.getGroupId()));

		BigDecimal amount = BigDecimal.valueOf(1);

		CommerceContext commerceContext = new TestCommerceContext(
			_commerceCurrency, null, null, _user.getGroup(), _commerceAccount,
			null);

		_commercePriceModifier =
			CommercePriceModifierTestUtil.addCommercePriceModifierAbsolute(
				_user.getUserId(), _commercePriceList.getGroupId(),
				CommercePriceModifierConstants.TARGET_PRICELIST, amount, 0);

		CommercePriceModifierTestUtil.addCommercePriceModifierRelPricelist(
			_commercePriceModifier.getCommercePriceModifierId(),
			_commercePriceList.getGroupId(),
			_commercePriceList.getCommercePriceListId());

		CommerceProductPrice commerceProductPrice =
			_commerceProductPriceCalculation.getCommerceProductPrice(
				cpInstance.getCPInstanceId(), 1, commerceContext);

		CommerceMoney finalCommerceMoney = commerceProductPrice.getFinalPrice();

		BigDecimal finalPrice = finalCommerceMoney.getPrice();

		BigDecimal discountedPrice = priceEntryPrice.subtract(amount);

		Assert.assertEquals(
			discountedPrice.doubleValue(), finalPrice.doubleValue(), 0);
	}

	/*
	@Test
	public void testAddPriceListPriceModifierAbsoluteWrongAmount()
		throws Exception {

		String name = RandomTestUtil.randomString();

		List<CommerceCatalog> commerceCatalogs =
			CommerceCatalogLocalServiceUtil.getCommerceCatalogs(
				_user.getCompanyId(), true);

		CommerceCatalog commerceCatalog = commerceCatalogs.get(0);

		CPInstance cpInstance = CPTestUtil.addCPInstance(
			commerceCatalog.getGroupId());

		CPDefinition cpDefinition =
			CPDefinitionLocalServiceUtil.getCPDefinition(
				cpInstance.getCPDefinitionId());

		_commercePriceList = CommercePriceListTestUtil.addCommercePriceList(
			commerceCatalog.getGroupId(), _commerceCurrency.getCode(), name,
			RandomTestUtil.randomDouble(), true, null, null, null);

		BigDecimal priceEntryPrice = BigDecimal.valueOf(10);
		BigDecimal promoPrice = BigDecimal.valueOf(0);

		_commercePriceEntryLocalService.addCommercePriceEntry(
			cpDefinition.getCProductId(), cpInstance.getCPInstanceUuid(),
			_commercePriceList.getCommercePriceListId(),
			RandomTestUtil.randomString(), priceEntryPrice, promoPrice,
			ServiceContextTestUtil.getServiceContext(
				_commercePriceList.getGroupId()));

		BigDecimal amount = BigDecimal.valueOf(11);

		CommerceContext commerceContext = new TestCommerceContext(
			_commerceCurrency, null, null, _user.getGroup(), _commerceAccount,
			null);

		_commercePriceModifier =
			_commercePriceModifierLocalService.addCommercePriceModifier(
				RandomTestUtil.randomString(), RandomTestUtil.randomString(),
				"pricelist", String.valueOf(_commercePriceList.getCommercePriceListId()), "absolute", amount,
				ServiceContextTestUtil.getServiceContext(_user.getGroupId()));

		CommerceProductPrice commerceProductPrice =
			_commerceProductPriceCalculation.getCommerceProductPrice(
				cpInstance.getCPInstanceId(), 1, commerceContext);

		CommerceMoney finalCommerceMoney = commerceProductPrice.getFinalPrice();

		BigDecimal finalPrice = finalCommerceMoney.getPrice();

		BigDecimal discountedPrice = priceEntryPrice;

		Assert.assertEquals(
			discountedPrice.doubleValue(), finalPrice.doubleValue(), 0);
	}

	@Test
	public void testAddPriceListPriceModifierPercentage() throws Exception {
		String name = RandomTestUtil.randomString();

		List<CommerceCatalog> commerceCatalogs =
			CommerceCatalogLocalServiceUtil.getCommerceCatalogs(
				_user.getCompanyId(), true);

		CommerceCatalog commerceCatalog = commerceCatalogs.get(0);

		CPInstance cpInstance = CPTestUtil.addCPInstance(
			commerceCatalog.getGroupId());

		CPDefinition cpDefinition =
			CPDefinitionLocalServiceUtil.getCPDefinition(
				cpInstance.getCPDefinitionId());

		_commercePriceList = CommercePriceListTestUtil.addCommercePriceList(
			commerceCatalog.getGroupId(), _commerceCurrency.getCode(), name,
			RandomTestUtil.randomDouble(), true, null, null, null);

		BigDecimal priceEntryPrice = BigDecimal.valueOf(10);
		BigDecimal promoPrice = BigDecimal.valueOf(0);

		_commercePriceEntryLocalService.addCommercePriceEntry(
			cpDefinition.getCProductId(), cpInstance.getCPInstanceUuid(),
			_commercePriceList.getCommercePriceListId(),
			RandomTestUtil.randomString(), priceEntryPrice, promoPrice,
			ServiceContextTestUtil.getServiceContext(
				_commercePriceList.getGroupId()));

		BigDecimal amount = BigDecimal.valueOf(10);

		CommerceContext commerceContext = new TestCommerceContext(
			_commerceCurrency, null, null, _user.getGroup(), _commerceAccount,
			null);

		_commercePriceModifier =
			_commercePriceModifierLocalService.addCommercePriceModifier(
				RandomTestUtil.randomString(), RandomTestUtil.randomString(),
				"pricelist", String.valueOf(_commercePriceList.getCommercePriceListId()), "percentage", amount,
				ServiceContextTestUtil.getServiceContext(_user.getGroupId()));

		BigDecimal discount = priceEntryPrice.multiply(amount);

		discount = discount.divide(BigDecimal.valueOf(100));

		CommerceProductPrice commerceProductPrice =
			_commerceProductPriceCalculation.getCommerceProductPrice(
				cpInstance.getCPInstanceId(), 1, commerceContext);

		CommerceMoney finalCommerceMoney = commerceProductPrice.getFinalPrice();

		BigDecimal finalPrice = finalCommerceMoney.getPrice();

		BigDecimal discountedPrice = priceEntryPrice.subtract(discount);

		Assert.assertEquals(
			discountedPrice.doubleValue(), finalPrice.doubleValue(), 0);
	}

	@Test
	public void testDeletePriceListPriceModifier() throws Exception {
		String name = RandomTestUtil.randomString();

		List<CommerceCatalog> commerceCatalogs =
				CommerceCatalogLocalServiceUtil.getCommerceCatalogs(
					_user.getCompanyId(), true);

			CommerceCatalog commerceCatalog = commerceCatalogs.get(0);

		BigDecimal amount = BigDecimal.valueOf(1);

		int commercePriceModifierCount =
			_commercePriceModifierLocalService.getCommercePriceModifiersCount();

		Assert.assertEquals(0, commercePriceModifierCount);

		_commercePriceList = CommercePriceListTestUtil.addCommercePriceList(
				commerceCatalog.getGroupId(), _commerceCurrency.getCode(), name,
				RandomTestUtil.randomDouble(), true, null, null, null);

		CommercePriceModifier commercePriceModifier =
			_commercePriceModifierLocalService.addCommercePriceModifier(
				RandomTestUtil.randomString(), RandomTestUtil.randomString(),
				"pricelist", String.valueOf(_commercePriceList.getCommercePriceListId()), "absolute", amount,
				ServiceContextTestUtil.getServiceContext(_user.getGroupId()));

		commercePriceModifierCount =
			_commercePriceModifierLocalService.getCommercePriceModifiersCount();

		Assert.assertEquals(1, commercePriceModifierCount);

		_commercePriceModifierLocalService.deleteCommercePriceModifier(
			commercePriceModifier);

		commercePriceModifierCount =
			_commercePriceModifierLocalService.getCommercePriceModifiersCount();

		Assert.assertEquals(0, commercePriceModifierCount);
	}*/

	@Rule
	public FrutillaRule frutillaRule = new FrutillaRule();

	@DeleteAfterTestRun
	private CommerceAccount _commerceAccount;

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

	@Inject
	private CommercePriceEntryLocalService _commercePriceEntryLocalService;

	@DeleteAfterTestRun
	private CommercePriceList _commercePriceList;

	@DeleteAfterTestRun
	private CommercePriceModifier _commercePriceModifier;

	@Inject
	private CommercePriceModifierLocalService
		_commercePriceModifierLocalService;

	private CommerceProductPriceCalculation _commerceProductPriceCalculation;

	@Inject
	private CommerceProductPriceCalculationRegistry
		_commerceProductPriceCalculationRegistry;

	@DeleteAfterTestRun
	private User _user;

	@Inject
	private UserLocalService _userLocalService;

}