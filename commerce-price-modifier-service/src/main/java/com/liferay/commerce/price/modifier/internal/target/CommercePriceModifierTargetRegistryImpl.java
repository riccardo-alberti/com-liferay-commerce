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

package com.liferay.commerce.price.modifier.internal.target;

import com.liferay.commerce.price.modifier.internal.target.comparator.CommercePriceModifierTargetOrderComparator;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTarget;
import com.liferay.commerce.price.modifier.target.CommercePriceModifierTargetRegistry;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory.ServiceWrapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Riccardo Alberti
 */
@Component(
	immediate = true, service = CommercePriceModifierTargetRegistry.class
)
public class CommercePriceModifierTargetRegistryImpl
	implements CommercePriceModifierTargetRegistry {

	@Override
	public CommercePriceModifierTarget getCommercePriceModifierTarget(
		String key) {

		ServiceWrapper<CommercePriceModifierTarget>
			commercePriceModifierTargetServiceWrapper =
				_serviceTrackerMap.getService(key);

		if (commercePriceModifierTargetServiceWrapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"No CommercePriceModifierTarget registered with key " +
						key);
			}

			return null;
		}

		return commercePriceModifierTargetServiceWrapper.getService();
	}

	@Override
	public List<CommercePriceModifierTarget> getCommercePriceModifierTargets() {
		List<CommercePriceModifierTarget> commercePriceModifierTargets =
			new ArrayList<>();

		List<ServiceWrapper<CommercePriceModifierTarget>>
			commercePriceModifierTargetServiceWrappers =
				ListUtil.fromCollection(_serviceTrackerMap.values());

		Collections.sort(
			commercePriceModifierTargetServiceWrappers,
			_commercePriceModifierTargetServiceWrapperOrderComparator);

		for (ServiceWrapper<CommercePriceModifierTarget>
				commercePriceModifierTargetServiceWrapper :
					commercePriceModifierTargetServiceWrappers) {

			commercePriceModifierTargets.add(
				commercePriceModifierTargetServiceWrapper.getService());
		}

		return Collections.unmodifiableList(commercePriceModifierTargets);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, CommercePriceModifierTarget.class,
			"commerce.price.modifier.target.key",
			ServiceTrackerCustomizerFactory.
				<CommercePriceModifierTarget>serviceWrapper(bundleContext));
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierTargetRegistryImpl.class);

	private final Comparator<ServiceWrapper<CommercePriceModifierTarget>>
		_commercePriceModifierTargetServiceWrapperOrderComparator =
			new CommercePriceModifierTargetOrderComparator();
	private ServiceTrackerMap
		<String, ServiceWrapper<CommercePriceModifierTarget>>
			_serviceTrackerMap;

}