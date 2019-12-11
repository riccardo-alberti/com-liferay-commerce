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

package com.liferay.commerce.rule.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.io.IOException;

/**
 * The extended model implementation for the CommerceRule service. Represents a row in the &quot;CommerceRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.commerce.rule.model.CommerceRule</code> interface.
 * </p>
 *
 * @author Riccardo Alberti
 */
public class CommerceRuleImpl extends CommerceRuleBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a commerce rule model instance should use the {@link com.liferay.commerce.rule.model.CommerceRule} interface instead.
	 */
	public CommerceRuleImpl() {
	}

	@Override
	public UnicodeProperties getSettingsProperties() {
		if (_settingsProperties == null) {
			_settingsProperties = new UnicodeProperties(true);

			try {
				_settingsProperties.load(super.getTypeSettings());
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);
			}
		}

		return _settingsProperties;
	}

	@Override
	public String getSettingsProperty(String key) {
		UnicodeProperties settingsProperties = getSettingsProperties();

		return settingsProperties.getProperty(key);
	}

	@Override
	public void setSettingsProperties(UnicodeProperties settingsProperties) {
		_settingsProperties = settingsProperties;

		super.setTypeSettings(settingsProperties.toString());
	}

	@Override
	public void setTypeSettings(String settings) {
		_settingsProperties = null;

		super.setTypeSettings(settings);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceRuleImpl.class);

	private UnicodeProperties _settingsProperties;

}