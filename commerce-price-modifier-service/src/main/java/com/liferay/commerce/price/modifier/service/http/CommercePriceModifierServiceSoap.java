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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>CommercePriceModifierServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.commerce.price.modifier.model.CommercePriceModifier</code>, that is translated to a
 * <code>com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierServiceHttp
 * @generated
 */
public class CommercePriceModifierServiceSoap {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierServiceUtil</code> to access the commerce price modifier remote service.
	 *
	 * @throws PortalException
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				addCommercePriceModifier(
					long userId, String description, String title,
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
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.addCommercePriceModifier(
						userId, description, title, target, modifierType,
						modifierAmount, priority, active, displayDateMonth,
						displayDateDay, displayDateYear, displayDateHour,
						displayDateMinute, expirationDateMonth,
						expirationDateDay, expirationDateYear,
						expirationDateHour, expirationDateMinute, neverExpire,
						serviceContext);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				deleteCommercePriceModifier(long commercePriceModifierId)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.
						deleteCommercePriceModifier(commercePriceModifierId);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				fetchByExternalReferenceCode(
					long companyId, String externalReferenceCode)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.
						fetchByExternalReferenceCode(
							companyId, externalReferenceCode);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				fetchCommercePriceModifier(long commercePriceModifierId)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.fetchCommercePriceModifier(
						commercePriceModifierId);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				getCommercePriceModifier(long commercePriceModifierId)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.getCommercePriceModifier(
						commercePriceModifierId);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap[]
				getCommercePriceModifiers(long companyId, String target)
			throws RemoteException {

		try {
			java.util.List
				<com.liferay.commerce.price.modifier.model.
					CommercePriceModifier> returnValue =
						CommercePriceModifierServiceUtil.
							getCommercePriceModifiers(companyId, target);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getCommercePriceModifiersCount() throws RemoteException {
		try {
			int returnValue =
				CommercePriceModifierServiceUtil.
					getCommercePriceModifiersCount();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				updateCommercePriceModifier(
					long commercePriceModifierId, String description,
					String title, String target, String modifierType,
					java.math.BigDecimal modifierAmount, double priority,
					boolean active, int displayDateMonth, int displayDateDay,
					int displayDateYear, int displayDateHour,
					int displayDateMinute, int expirationDateMonth,
					int expirationDateDay, int expirationDateYear,
					int expirationDateHour, int expirationDateMinute,
					boolean neverExpire,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.
						updateCommercePriceModifier(
							commercePriceModifierId, description, title, target,
							modifierType, modifierAmount, priority, active,
							displayDateMonth, displayDateDay, displayDateYear,
							displayDateHour, displayDateMinute,
							expirationDateMonth, expirationDateDay,
							expirationDateYear, expirationDateHour,
							expirationDateMinute, neverExpire, serviceContext);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierSoap
				upsertCommercePriceModifier(
					long userId, long commercePriceModifierId,
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
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifier
				returnValue =
					CommercePriceModifierServiceUtil.
						upsertCommercePriceModifier(
							userId, commercePriceModifierId, description, title,
							target, modifierType, modifierAmount, priority,
							active, displayDateMonth, displayDateDay,
							displayDateYear, displayDateHour, displayDateMinute,
							expirationDateMonth, expirationDateDay,
							expirationDateYear, expirationDateHour,
							expirationDateMinute, externalReferenceCode,
							neverExpire, serviceContext);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierServiceSoap.class);

}