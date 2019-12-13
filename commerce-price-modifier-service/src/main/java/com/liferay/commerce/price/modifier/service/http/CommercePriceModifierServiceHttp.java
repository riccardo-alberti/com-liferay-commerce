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

package com.liferay.commerce.price.modifier.service.http;

import com.liferay.commerce.price.modifier.service.CommercePriceModifierServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>CommercePriceModifierServiceUtil</code> service
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
 * @author Riccardo Alberti
 * @see CommercePriceModifierServiceSoap
 * @generated
 */
public class CommercePriceModifierServiceHttp {

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				addCommercePriceModifier(
					HttpPrincipal httpPrincipal, long userId, long groupId,
					String description, String title, String target,
					String modifierType, java.math.BigDecimal modifierAmount,
					double priority, boolean active, int displayDateMonth,
					int displayDateDay, int displayDateYear,
					int displayDateHour, int displayDateMinute,
					int expirationDateMonth, int expirationDateDay,
					int expirationDateYear, int expirationDateHour,
					int expirationDateMinute, boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"addCommercePriceModifier",
				_addCommercePriceModifierParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId, description, title, target,
				modifierType, modifierAmount, priority, active,
				displayDateMonth, displayDateDay, displayDateYear,
				displayDateHour, displayDateMinute, expirationDateMonth,
				expirationDateDay, expirationDateYear, expirationDateHour,
				expirationDateMinute, neverExpire, serviceContext);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				deleteCommercePriceModifier(
					HttpPrincipal httpPrincipal, long commercePriceModifierId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"deleteCommercePriceModifier",
				_deleteCommercePriceModifierParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceModifierId);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				fetchByExternalReferenceCode(
					HttpPrincipal httpPrincipal, long companyId,
					String externalReferenceCode)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"fetchByExternalReferenceCode",
				_fetchByExternalReferenceCodeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, externalReferenceCode);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				fetchCommercePriceModifier(
					HttpPrincipal httpPrincipal, long commercePriceModifierId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"fetchCommercePriceModifier",
				_fetchCommercePriceModifierParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceModifierId);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				getCommercePriceModifier(
					HttpPrincipal httpPrincipal, long commercePriceModifierId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"getCommercePriceModifier",
				_getCommercePriceModifierParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceModifierId);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				getCommercePriceModifiers(
					HttpPrincipal httpPrincipal, long companyId, String target)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"getCommercePriceModifiers",
				_getCommercePriceModifiersParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, target);

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
				<com.liferay.commerce.price.modifier.model.
					CommercePriceModifier>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getCommercePriceModifiersCount(
			HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"getCommercePriceModifiersCount",
				_getCommercePriceModifiersCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.search.BaseModelSearchResult
		<com.liferay.commerce.price.modifier.model.CommercePriceModifier>
				searchCommercePriceModifiers(
					HttpPrincipal httpPrincipal, long companyId,
					String keywords, int status, int start, int end,
					com.liferay.portal.kernel.search.Sort sort)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"searchCommercePriceModifiers",
				_searchCommercePriceModifiersParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, keywords, status, start, end, sort);

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

			return (com.liferay.portal.kernel.search.BaseModelSearchResult
				<com.liferay.commerce.price.modifier.model.
					CommercePriceModifier>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				updateCommercePriceModifier(
					HttpPrincipal httpPrincipal, long commercePriceModifierId,
					long groupId, String description, String title,
					String target, String modifierType,
					java.math.BigDecimal modifierAmount, double priority,
					boolean active, int displayDateMonth, int displayDateDay,
					int displayDateYear, int displayDateHour,
					int displayDateMinute, int expirationDateMonth,
					int expirationDateDay, int expirationDateYear,
					int expirationDateHour, int expirationDateMinute,
					boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"updateCommercePriceModifier",
				_updateCommercePriceModifierParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, commercePriceModifierId, groupId, description, title,
				target, modifierType, modifierAmount, priority, active,
				displayDateMonth, displayDateDay, displayDateYear,
				displayDateHour, displayDateMinute, expirationDateMonth,
				expirationDateDay, expirationDateYear, expirationDateHour,
				expirationDateMinute, neverExpire, serviceContext);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifier
				upsertCommercePriceModifier(
					HttpPrincipal httpPrincipal, long userId,
					long commercePriceModifierId, long groupId,
					String description, String title, String target,
					String modifierType, java.math.BigDecimal modifierAmount,
					double priority, boolean active, int displayDateMonth,
					int displayDateDay, int displayDateYear,
					int displayDateHour, int displayDateMinute,
					int expirationDateMonth, int expirationDateDay,
					int expirationDateYear, int expirationDateHour,
					int expirationDateMinute, String externalReferenceCode,
					boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CommercePriceModifierServiceUtil.class,
				"upsertCommercePriceModifier",
				_upsertCommercePriceModifierParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, commercePriceModifierId, groupId,
				description, title, target, modifierType, modifierAmount,
				priority, active, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute,
				expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, externalReferenceCode,
				neverExpire, serviceContext);

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

			return (com.liferay.commerce.price.modifier.model.
				CommercePriceModifier)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierServiceHttp.class);

	private static final Class<?>[] _addCommercePriceModifierParameterTypes0 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, java.math.BigDecimal.class, double.class,
			boolean.class, int.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class, int.class, int.class,
			boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[]
		_deleteCommercePriceModifierParameterTypes1 = new Class[] {long.class};
	private static final Class<?>[]
		_fetchByExternalReferenceCodeParameterTypes2 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _fetchCommercePriceModifierParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getCommercePriceModifierParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getCommercePriceModifiersParameterTypes5 =
		new Class[] {long.class, String.class};
	private static final Class<?>[]
		_getCommercePriceModifiersCountParameterTypes6 = new Class[] {};
	private static final Class<?>[]
		_searchCommercePriceModifiersParameterTypes7 = new Class[] {
			long.class, String.class, int.class, int.class, int.class,
			com.liferay.portal.kernel.search.Sort.class
		};
	private static final Class<?>[]
		_updateCommercePriceModifierParameterTypes8 = new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			String.class, java.math.BigDecimal.class, double.class,
			boolean.class, int.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class, int.class, int.class,
			boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[]
		_upsertCommercePriceModifierParameterTypes9 = new Class[] {
			long.class, long.class, long.class, String.class, String.class,
			String.class, String.class, java.math.BigDecimal.class,
			double.class, boolean.class, int.class, int.class, int.class,
			int.class, int.class, int.class, int.class, int.class, int.class,
			int.class, String.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}