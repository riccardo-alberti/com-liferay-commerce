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

package com.liferay.commerce.rule.internal.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.liferay.commerce.rule.internal.type.comparator.CommerceRuleTypeOrderComparator;
import com.liferay.commerce.rule.type.CommerceRuleType;
import com.liferay.commerce.rule.type.CommerceRuleTypeRegistry;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory.ServiceWrapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

/**
 * @author Riccardo Alberti
 */
@Component(immediate = true, service = CommerceRuleTypeRegistry.class)
public class CommerceRuleTypeRegistryImpl
	implements CommerceRuleTypeRegistry {

	@Override
	public CommerceRuleType getCommerceRuleType(String key) {
		ServiceWrapper<CommerceRuleType>
			commerceRuleTypeServiceWrapper =
				_serviceTrackerMap.getService(key);

		if (commerceRuleTypeServiceWrapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"No CommerceRuleType registered with key " + key);
			}

			return null;
		}

		return commerceRuleTypeServiceWrapper.getService();
	}

	@Override
	public List<CommerceRuleType> getCommerceRuleTypes() {
		List<CommerceRuleType> commerceDiscountRuleTypes =
			new ArrayList<>();

		List<ServiceWrapper<CommerceRuleType>>
			commerceRuleTypeServiceWrappers = ListUtil.fromCollection(
				_serviceTrackerMap.values());

		Collections.sort(
				commerceRuleTypeServiceWrappers,
			_commerceRuleTypeServiceWrapperOrderComparator);

		for (ServiceWrapper<CommerceRuleType>
				commerceDiscountRuleTypeServiceWrapper :
					commerceRuleTypeServiceWrappers) {

			commerceDiscountRuleTypes.add(
				commerceDiscountRuleTypeServiceWrapper.getService());
		}

		return Collections.unmodifiableList(commerceDiscountRuleTypes);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, CommerceRuleType.class,
			"commerce.rule.type.key",
			ServiceTrackerCustomizerFactory.
				<CommerceRuleType>serviceWrapper(bundleContext));
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceRuleTypeRegistryImpl.class);

	private final Comparator<ServiceWrapper<CommerceRuleType>>
		_commerceRuleTypeServiceWrapperOrderComparator =
			new CommerceRuleTypeOrderComparator();
	private ServiceTrackerMap<String, ServiceWrapper<CommerceRuleType>>
		_serviceTrackerMap;

}