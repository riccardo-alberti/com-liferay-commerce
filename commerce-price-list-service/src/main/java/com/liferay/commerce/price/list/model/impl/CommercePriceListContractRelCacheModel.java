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

package com.liferay.commerce.price.list.model.impl;

import com.liferay.commerce.price.list.model.CommercePriceListContractRel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommercePriceListContractRel in entity cache.
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class CommercePriceListContractRelCacheModel
	implements CacheModel<CommercePriceListContractRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommercePriceListContractRelCacheModel)) {
			return false;
		}

		CommercePriceListContractRelCacheModel
			commercePriceListContractRelCacheModel =
				(CommercePriceListContractRelCacheModel)obj;

		if (commercePriceListContractRelId ==
				commercePriceListContractRelCacheModel.
					commercePriceListContractRelId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commercePriceListContractRelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", commercePriceListContractRelId=");
		sb.append(commercePriceListContractRelId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", commerceContractId=");
		sb.append(commerceContractId);
		sb.append(", commercePriceListId=");
		sb.append(commercePriceListId);
		sb.append(", order=");
		sb.append(order);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommercePriceListContractRel toEntityModel() {
		CommercePriceListContractRelImpl commercePriceListContractRelImpl =
			new CommercePriceListContractRelImpl();

		if (uuid == null) {
			commercePriceListContractRelImpl.setUuid("");
		}
		else {
			commercePriceListContractRelImpl.setUuid(uuid);
		}

		commercePriceListContractRelImpl.setCommercePriceListContractRelId(
			commercePriceListContractRelId);
		commercePriceListContractRelImpl.setCompanyId(companyId);
		commercePriceListContractRelImpl.setUserId(userId);

		if (userName == null) {
			commercePriceListContractRelImpl.setUserName("");
		}
		else {
			commercePriceListContractRelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commercePriceListContractRelImpl.setCreateDate(null);
		}
		else {
			commercePriceListContractRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commercePriceListContractRelImpl.setModifiedDate(null);
		}
		else {
			commercePriceListContractRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		commercePriceListContractRelImpl.setCommerceContractId(
			commerceContractId);
		commercePriceListContractRelImpl.setCommercePriceListId(
			commercePriceListId);
		commercePriceListContractRelImpl.setOrder(order);

		if (lastPublishDate == Long.MIN_VALUE) {
			commercePriceListContractRelImpl.setLastPublishDate(null);
		}
		else {
			commercePriceListContractRelImpl.setLastPublishDate(
				new Date(lastPublishDate));
		}

		commercePriceListContractRelImpl.resetOriginalValues();

		return commercePriceListContractRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		commercePriceListContractRelId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		commerceContractId = objectInput.readLong();

		commercePriceListId = objectInput.readLong();

		order = objectInput.readInt();
		lastPublishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(commercePriceListContractRelId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(commerceContractId);

		objectOutput.writeLong(commercePriceListId);

		objectOutput.writeInt(order);
		objectOutput.writeLong(lastPublishDate);
	}

	public String uuid;
	public long commercePriceListContractRelId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long commerceContractId;
	public long commercePriceListId;
	public int order;
	public long lastPublishDate;

}