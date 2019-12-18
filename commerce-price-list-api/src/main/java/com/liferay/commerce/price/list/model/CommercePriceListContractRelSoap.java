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

package com.liferay.commerce.price.list.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.commerce.price.list.service.http.CommercePriceListContractRelServiceSoap}.
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class CommercePriceListContractRelSoap implements Serializable {

	public static CommercePriceListContractRelSoap toSoapModel(
		CommercePriceListContractRel model) {

		CommercePriceListContractRelSoap soapModel =
			new CommercePriceListContractRelSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCommercePriceListContractRelId(
			model.getCommercePriceListContractRelId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCommerceContractId(model.getCommerceContractId());
		soapModel.setCommercePriceListId(model.getCommercePriceListId());
		soapModel.setOrder(model.getOrder());
		soapModel.setLastPublishDate(model.getLastPublishDate());

		return soapModel;
	}

	public static CommercePriceListContractRelSoap[] toSoapModels(
		CommercePriceListContractRel[] models) {

		CommercePriceListContractRelSoap[] soapModels =
			new CommercePriceListContractRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommercePriceListContractRelSoap[][] toSoapModels(
		CommercePriceListContractRel[][] models) {

		CommercePriceListContractRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommercePriceListContractRelSoap
				[models.length][models[0].length];
		}
		else {
			soapModels = new CommercePriceListContractRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommercePriceListContractRelSoap[] toSoapModels(
		List<CommercePriceListContractRel> models) {

		List<CommercePriceListContractRelSoap> soapModels =
			new ArrayList<CommercePriceListContractRelSoap>(models.size());

		for (CommercePriceListContractRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CommercePriceListContractRelSoap[soapModels.size()]);
	}

	public CommercePriceListContractRelSoap() {
	}

	public long getPrimaryKey() {
		return _commercePriceListContractRelId;
	}

	public void setPrimaryKey(long pk) {
		setCommercePriceListContractRelId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCommercePriceListContractRelId() {
		return _commercePriceListContractRelId;
	}

	public void setCommercePriceListContractRelId(
		long commercePriceListContractRelId) {

		_commercePriceListContractRelId = commercePriceListContractRelId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCommerceContractId() {
		return _commerceContractId;
	}

	public void setCommerceContractId(long commerceContractId) {
		_commerceContractId = commerceContractId;
	}

	public long getCommercePriceListId() {
		return _commercePriceListId;
	}

	public void setCommercePriceListId(long commercePriceListId) {
		_commercePriceListId = commercePriceListId;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	private String _uuid;
	private long _commercePriceListContractRelId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _commerceContractId;
	private long _commercePriceListId;
	private int _order;
	private Date _lastPublishDate;

}