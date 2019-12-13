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

package com.liferay.commerce.internal.price;

import com.liferay.commerce.price.CommerceProductPriceCalculation;
import com.liferay.commerce.price.CommerceProductPriceCalculationRegistry;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerCustomizerFactory.ServiceWrapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Riccardo Alberti
 */
@Component(
	immediate = true, service = CommerceProductPriceCalculationRegistry.class
)
public class CommerceProductPriceCalculationRegistryImpl
	implements CommerceProductPriceCalculationRegistry {

	@Override
	public CommerceProductPriceCalculation getCommerceProductPrice(String key) {
		ServiceWrapper<CommerceProductPriceCalculation>
			commerceProductPriceCalculationServiceWrapper =
				_serviceTrackerMap.getService(key);

		if (commerceProductPriceCalculationServiceWrapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"No CommerceProductPriceCalculation registered with key " +
						key);
			}

			return null;
		}

		return commerceProductPriceCalculationServiceWrapper.getService();
	}

	@Override
	public List<CommerceProductPriceCalculation> getCommerceProductPrices() {
		List<CommerceProductPriceCalculation> commerceProductPriceCalculations =
			new ArrayList<>();

		List<ServiceWrapper<CommerceProductPriceCalculation>>
			commerceProductPriceCalculationServiceWrappers =
				ListUtil.fromCollection(_serviceTrackerMap.values());

		for (ServiceWrapper<CommerceProductPriceCalculation>
				commerceProductPriceCalculationServiceWrapper :
					commerceProductPriceCalculationServiceWrappers) {

			commerceProductPriceCalculations.add(
				commerceProductPriceCalculationServiceWrapper.getService());
		}

		return Collections.unmodifiableList(commerceProductPriceCalculations);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, CommerceProductPriceCalculation.class,
			"commerce.price.calculation.key",
			ServiceTrackerCustomizerFactory.
				<CommerceProductPriceCalculation>serviceWrapper(bundleContext));
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceProductPriceCalculationRegistryImpl.class);

	private ServiceTrackerMap
		<String, ServiceWrapper<CommerceProductPriceCalculation>>
			_serviceTrackerMap;

}