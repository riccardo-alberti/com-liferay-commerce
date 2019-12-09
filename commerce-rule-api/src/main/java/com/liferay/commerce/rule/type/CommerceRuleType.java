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

package com.liferay.commerce.rule.type;

import java.util.Locale;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.portal.kernel.exception.PortalException;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Riccardo Alberti
 */
@ProviderType
public interface CommerceRuleType {

	public boolean evaluate(
			CommerceRule commerceRule,
			CommerceContext commerceContext)
		throws PortalException;

	public String getKey();

	public String getLabel(Locale locale);

}