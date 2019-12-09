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

import com.liferay.commerce.rule.model.CommerceRule;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommerceRule in entity cache.
 *
 * @author Riccardo Alberti
 * @generated
 */
public class CommerceRuleCacheModel
	implements CacheModel<CommerceRule>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceRuleCacheModel)) {
			return false;
		}

		CommerceRuleCacheModel commerceRuleCacheModel =
			(CommerceRuleCacheModel)obj;

		if (commerceRuleId == commerceRuleCacheModel.commerceRuleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commerceRuleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{commerceRuleId=");
		sb.append(commerceRuleId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append(", description=");
		sb.append(description);
		sb.append(", displayDate=");
		sb.append(displayDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommerceRule toEntityModel() {
		CommerceRuleImpl commerceRuleImpl = new CommerceRuleImpl();

		commerceRuleImpl.setCommerceRuleId(commerceRuleId);
		commerceRuleImpl.setCompanyId(companyId);
		commerceRuleImpl.setUserId(userId);

		if (userName == null) {
			commerceRuleImpl.setUserName("");
		}
		else {
			commerceRuleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commerceRuleImpl.setCreateDate(null);
		}
		else {
			commerceRuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commerceRuleImpl.setModifiedDate(null);
		}
		else {
			commerceRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			commerceRuleImpl.setType("");
		}
		else {
			commerceRuleImpl.setType(type);
		}

		if (typeSettings == null) {
			commerceRuleImpl.setTypeSettings("");
		}
		else {
			commerceRuleImpl.setTypeSettings(typeSettings);
		}

		if (description == null) {
			commerceRuleImpl.setDescription("");
		}
		else {
			commerceRuleImpl.setDescription(description);
		}

		if (displayDate == Long.MIN_VALUE) {
			commerceRuleImpl.setDisplayDate(null);
		}
		else {
			commerceRuleImpl.setDisplayDate(new Date(displayDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			commerceRuleImpl.setExpirationDate(null);
		}
		else {
			commerceRuleImpl.setExpirationDate(new Date(expirationDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			commerceRuleImpl.setLastPublishDate(null);
		}
		else {
			commerceRuleImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		commerceRuleImpl.setStatus(status);
		commerceRuleImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			commerceRuleImpl.setStatusByUserName("");
		}
		else {
			commerceRuleImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			commerceRuleImpl.setStatusDate(null);
		}
		else {
			commerceRuleImpl.setStatusDate(new Date(statusDate));
		}

		commerceRuleImpl.resetOriginalValues();

		return commerceRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		commerceRuleId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
		typeSettings = objectInput.readUTF();
		description = objectInput.readUTF();
		displayDate = objectInput.readLong();
		expirationDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(commerceRuleId);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(displayDate);
		objectOutput.writeLong(expirationDate);
		objectOutput.writeLong(lastPublishDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long commerceRuleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;
	public String typeSettings;
	public String description;
	public long displayDate;
	public long expirationDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}