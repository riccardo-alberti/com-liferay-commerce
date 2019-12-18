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

package com.liferay.commerce.price.list.service.http;

import com.liferay.commerce.price.list.service.CommercePriceListChannelRelServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>CommercePriceListChannelRelServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListChannelRelServiceSoap
 * @generated
 */
public class CommercePriceListChannelRelServiceHttp {

	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				addCommercePriceListChannelRel(
					HttpPrincipal httpPrincipal, long commercePriceListId,
					long commerceChannelId, int order,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceListChannelRelServiceUtil.class,
				"addCommercePriceListChannelRel",
				_addCommercePriceListChannelRelParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceListId, commerceChannelId, order,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.commerce.price.list.model.
				CommercePriceListChannelRel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteCommercePriceListChannelRel(
			HttpPrincipal httpPrincipal, long commercePriceListChannelRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceListChannelRelServiceUtil.class,
				"deleteCommercePriceListChannelRel",
				_deleteCommercePriceListChannelRelParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceListChannelRelId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.list.model.CommercePriceListChannelRel
				fetchCommercePriceListChannelRel(
					HttpPrincipal httpPrincipal, long commercePriceListId,
					long commerceChannelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceListChannelRelServiceUtil.class,
				"fetchCommercePriceListChannelRel",
				_fetchCommercePriceListChannelRelParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceListId, commerceChannelId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.commerce.price.list.model.
				CommercePriceListChannelRel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List
		<com.liferay.commerce.price.list.model.CommercePriceListChannelRel>
				getCommercePriceListChannelRels(
					HttpPrincipal httpPrincipal, long commercePriceListId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceListChannelRelServiceUtil.class,
				"getCommercePriceListChannelRels",
				_getCommercePriceListChannelRelsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceListId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<com.liferay.commerce.price.list.model.
					CommercePriceListChannelRel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CommercePriceListChannelRelServiceHttp.class);

	private static final Class<?>[]
		_addCommercePriceListChannelRelParameterTypes0 = new Class[] {
			long.class, long.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[]
		_deleteCommercePriceListChannelRelParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_fetchCommercePriceListChannelRelParameterTypes2 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[]
		_getCommercePriceListChannelRelsParameterTypes3 = new Class[] {
			long.class
		};

}