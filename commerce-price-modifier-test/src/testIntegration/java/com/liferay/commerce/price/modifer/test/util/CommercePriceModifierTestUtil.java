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

package com.liferay.commerce.price.modifer.test.util;

import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.modifier.constants.CommercePriceModifierConstants;
import com.liferay.commerce.price.modifier.model.CommercePriceModifier;
import com.liferay.commerce.price.modifier.model.CommercePriceModifierRel;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierLocalServiceUtil;
import com.liferay.commerce.price.modifier.service.CommercePriceModifierRelLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Time;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Riccardo Alberti
 */
public class CommercePriceModifierTestUtil {

	public static CommercePriceModifier addCommercePriceModifier(
			long userId, long groupId, String target)
		throws Exception {

		User user = UserLocalServiceUtil.getUser(userId);

		long now = System.currentTimeMillis();

		Date displayDate = new Date(now - Time.HOUR);
		Date expirationDate = new Date(now + Time.DAY);

		Calendar displayCal = CalendarFactoryUtil.getCalendar(
			user.getTimeZone());

		displayCal.setTime(displayDate);

		int displayDateMonth = displayCal.get(Calendar.MONTH);
		int displayDateDay = displayCal.get(Calendar.DATE);
		int displayDateYear = displayCal.get(Calendar.YEAR);
		int displayDateHour = displayCal.get(Calendar.HOUR);
		int displayDateMinute = displayCal.get(Calendar.MINUTE);

		if (displayCal.get(Calendar.AM_PM) == Calendar.PM) {
			displayDateHour += 12;
		}

		Calendar expirationCal = CalendarFactoryUtil.getCalendar(
			user.getTimeZone());

		expirationCal.setTime(expirationDate);

		int expirationDateMonth = expirationCal.get(Calendar.MONTH);
		int expirationDateDay = expirationCal.get(Calendar.DATE);
		int expirationDateYear = expirationCal.get(Calendar.YEAR);
		int expirationDateHour = expirationCal.get(Calendar.HOUR);
		int expirationDateMinute = expirationCal.get(Calendar.MINUTE);

		if (expirationCal.get(Calendar.AM_PM) == Calendar.PM) {
			expirationDateHour += 12;
		}

		return CommercePriceModifierLocalServiceUtil.addCommercePriceModifier(
			userId, RandomTestUtil.randomString(),
			RandomTestUtil.randomString(), target,
			CommercePriceModifierConstants.PERCENTAGE, BigDecimal.valueOf(10),
			RandomTestUtil.nextDouble(), true, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, true,
			ServiceContextTestUtil.getServiceContext(groupId));
	}

	public static CommercePriceModifierRel addCommercePriceModifierRel(
			long commercePriceModifierId, long groupId, String className,
			long classPK)
		throws Exception {

		return CommercePriceModifierRelLocalServiceUtil.
			addCommercePriceModifierRel(
				commercePriceModifierId, className, classPK,
				ServiceContextTestUtil.getServiceContext(groupId));
	}

	public static CommercePriceModifierRel addCommercePriceModifierRelPricelist(
			long commercePriceModifierId, long groupId,
			long commercePriceListId)
		throws Exception {

		return addCommercePriceModifierRel(
			commercePriceModifierId, groupId, CommercePriceList.class.getName(),
			commercePriceListId);
	}

}