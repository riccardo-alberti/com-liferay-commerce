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

import com.liferay.commerce.price.modifier.service.CommercePriceModifierRelServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>CommercePriceModifierRelServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.commerce.price.modifier.model.CommercePriceModifierRel</code>, that is translated to a
 * <code>com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap</code>. Methods that SOAP
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
 * @see CommercePriceModifierRelServiceHttp
 * @generated
 */
public class CommercePriceModifierRelServiceSoap {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>CommercePriceModifierRelServiceUtil</code> to access the commerce price modifier rel remote service.
	 */
	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap
				addCommerceDiscountRel(
					long commerceDiscountId, String className, long classPK,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				returnValue =
					CommercePriceModifierRelServiceUtil.addCommerceDiscountRel(
						commerceDiscountId, className, classPK, serviceContext);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierRelSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCommercePriceModifierRel(
			long commercePriceModifierRelId)
		throws RemoteException {

		try {
			CommercePriceModifierRelServiceUtil.deleteCommercePriceModifierRel(
				commercePriceModifierRelId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap
				fetchCommercePriceModifierRel(String className, long classPK)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				returnValue =
					CommercePriceModifierRelServiceUtil.
						fetchCommercePriceModifierRel(className, classPK);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierRelSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long[] getClassPKs(
			long commercePriceModifierRelId, String className)
		throws RemoteException {

		try {
			long[] returnValue =
				CommercePriceModifierRelServiceUtil.getClassPKs(
					commercePriceModifierRelId, className);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap
				getCommercePriceModifierRel(long commercePriceModifierRelId)
			throws RemoteException {

		try {
			com.liferay.commerce.price.modifier.model.CommercePriceModifierRel
				returnValue =
					CommercePriceModifierRelServiceUtil.
						getCommercePriceModifierRel(commercePriceModifierRelId);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierRelSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap[]
				getCommercePriceModifierRels(
					long commercePriceModifierRelId, String className)
			throws RemoteException {

		try {
			java.util.List
				<com.liferay.commerce.price.modifier.model.
					CommercePriceModifierRel> returnValue =
						CommercePriceModifierRelServiceUtil.
							getCommercePriceModifierRels(
								commercePriceModifierRelId, className);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierRelSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static
		com.liferay.commerce.price.modifier.model.CommercePriceModifierRelSoap[]
				getCommercePriceModifierRels(
					long commercePriceModifierRelId, String className,
					int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.commerce.price.modifier.model.
							CommercePriceModifierRel> orderByComparator)
			throws RemoteException {

		try {
			java.util.List
				<com.liferay.commerce.price.modifier.model.
					CommercePriceModifierRel> returnValue =
						CommercePriceModifierRelServiceUtil.
							getCommercePriceModifierRels(
								commercePriceModifierRelId, className, start,
								end, orderByComparator);

			return com.liferay.commerce.price.modifier.model.
				CommercePriceModifierRelSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getCommercePriceModifierRelsCount(
			long commercePriceModifierRelId, String className)
		throws RemoteException {

		try {
			int returnValue =
				CommercePriceModifierRelServiceUtil.
					getCommercePriceModifierRelsCount(
						commercePriceModifierRelId, className);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CommercePriceModifierRelServiceSoap.class);

}