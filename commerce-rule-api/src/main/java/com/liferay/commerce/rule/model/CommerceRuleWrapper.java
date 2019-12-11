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

package com.liferay.commerce.rule.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CommerceRule}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommerceRule
 * @generated
 */
public class CommerceRuleWrapper
	implements CommerceRule, ModelWrapper<CommerceRule> {

	public CommerceRuleWrapper(CommerceRule commerceRule) {
		_commerceRule = commerceRule;
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceRule.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceRuleId", getCommerceRuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("title", getTitle());
		attributes.put("type", getType());
		attributes.put("typeSettings", getTypeSettings());
		attributes.put("displayDate", getDisplayDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceRuleId = (Long)attributes.get("commerceRuleId");

		if (commerceRuleId != null) {
			setCommerceRuleId(commerceRuleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}

		Date displayDate = (Date)attributes.get("displayDate");

		if (displayDate != null) {
			setDisplayDate(displayDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public Object clone() {
		return new CommerceRuleWrapper((CommerceRule)_commerceRule.clone());
	}

	@Override
	public int compareTo(CommerceRule commerceRule) {
		return _commerceRule.compareTo(commerceRule);
	}

	/**
	 * Returns the commerce rule ID of this commerce rule.
	 *
	 * @return the commerce rule ID of this commerce rule
	 */
	@Override
	public long getCommerceRuleId() {
		return _commerceRule.getCommerceRuleId();
	}

	/**
	 * Returns the company ID of this commerce rule.
	 *
	 * @return the company ID of this commerce rule
	 */
	@Override
	public long getCompanyId() {
		return _commerceRule.getCompanyId();
	}

	/**
	 * Returns the create date of this commerce rule.
	 *
	 * @return the create date of this commerce rule
	 */
	@Override
	public Date getCreateDate() {
		return _commerceRule.getCreateDate();
	}

	/**
	 * Returns the description of this commerce rule.
	 *
	 * @return the description of this commerce rule
	 */
	@Override
	public String getDescription() {
		return _commerceRule.getDescription();
	}

	/**
	 * Returns the display date of this commerce rule.
	 *
	 * @return the display date of this commerce rule
	 */
	@Override
	public Date getDisplayDate() {
		return _commerceRule.getDisplayDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _commerceRule.getExpandoBridge();
	}

	/**
	 * Returns the expiration date of this commerce rule.
	 *
	 * @return the expiration date of this commerce rule
	 */
	@Override
	public Date getExpirationDate() {
		return _commerceRule.getExpirationDate();
	}

	/**
	 * Returns the last publish date of this commerce rule.
	 *
	 * @return the last publish date of this commerce rule
	 */
	@Override
	public Date getLastPublishDate() {
		return _commerceRule.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this commerce rule.
	 *
	 * @return the modified date of this commerce rule
	 */
	@Override
	public Date getModifiedDate() {
		return _commerceRule.getModifiedDate();
	}

	/**
	 * Returns the primary key of this commerce rule.
	 *
	 * @return the primary key of this commerce rule
	 */
	@Override
	public long getPrimaryKey() {
		return _commerceRule.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceRule.getPrimaryKeyObj();
	}

	@Override
	public com.liferay.portal.kernel.util.UnicodeProperties
		getSettingsProperties() {

		return _commerceRule.getSettingsProperties();
	}

	@Override
	public String getSettingsProperty(String key) {
		return _commerceRule.getSettingsProperty(key);
	}

	/**
	 * Returns the status of this commerce rule.
	 *
	 * @return the status of this commerce rule
	 */
	@Override
	public int getStatus() {
		return _commerceRule.getStatus();
	}

	/**
	 * Returns the status by user ID of this commerce rule.
	 *
	 * @return the status by user ID of this commerce rule
	 */
	@Override
	public long getStatusByUserId() {
		return _commerceRule.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this commerce rule.
	 *
	 * @return the status by user name of this commerce rule
	 */
	@Override
	public String getStatusByUserName() {
		return _commerceRule.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this commerce rule.
	 *
	 * @return the status by user uuid of this commerce rule
	 */
	@Override
	public String getStatusByUserUuid() {
		return _commerceRule.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this commerce rule.
	 *
	 * @return the status date of this commerce rule
	 */
	@Override
	public Date getStatusDate() {
		return _commerceRule.getStatusDate();
	}

	/**
	 * Returns the title of this commerce rule.
	 *
	 * @return the title of this commerce rule
	 */
	@Override
	public String getTitle() {
		return _commerceRule.getTitle();
	}

	/**
	 * Returns the type of this commerce rule.
	 *
	 * @return the type of this commerce rule
	 */
	@Override
	public String getType() {
		return _commerceRule.getType();
	}

	/**
	 * Returns the type settings of this commerce rule.
	 *
	 * @return the type settings of this commerce rule
	 */
	@Override
	public String getTypeSettings() {
		return _commerceRule.getTypeSettings();
	}

	/**
	 * Returns the user ID of this commerce rule.
	 *
	 * @return the user ID of this commerce rule
	 */
	@Override
	public long getUserId() {
		return _commerceRule.getUserId();
	}

	/**
	 * Returns the user name of this commerce rule.
	 *
	 * @return the user name of this commerce rule
	 */
	@Override
	public String getUserName() {
		return _commerceRule.getUserName();
	}

	/**
	 * Returns the user uuid of this commerce rule.
	 *
	 * @return the user uuid of this commerce rule
	 */
	@Override
	public String getUserUuid() {
		return _commerceRule.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _commerceRule.hashCode();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is approved.
	 *
	 * @return <code>true</code> if this commerce rule is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _commerceRule.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _commerceRule.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is denied.
	 *
	 * @return <code>true</code> if this commerce rule is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _commerceRule.isDenied();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is a draft.
	 *
	 * @return <code>true</code> if this commerce rule is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _commerceRule.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _commerceRule.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is expired.
	 *
	 * @return <code>true</code> if this commerce rule is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _commerceRule.isExpired();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is inactive.
	 *
	 * @return <code>true</code> if this commerce rule is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _commerceRule.isInactive();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is incomplete.
	 *
	 * @return <code>true</code> if this commerce rule is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _commerceRule.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _commerceRule.isNew();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is pending.
	 *
	 * @return <code>true</code> if this commerce rule is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _commerceRule.isPending();
	}

	/**
	 * Returns <code>true</code> if this commerce rule is scheduled.
	 *
	 * @return <code>true</code> if this commerce rule is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _commerceRule.isScheduled();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce rule model instance should use the <code>CommerceRule</code> interface instead.
	 */
	@Override
	public void persist() {
		_commerceRule.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commerceRule.setCachedModel(cachedModel);
	}

	/**
	 * Sets the commerce rule ID of this commerce rule.
	 *
	 * @param commerceRuleId the commerce rule ID of this commerce rule
	 */
	@Override
	public void setCommerceRuleId(long commerceRuleId) {
		_commerceRule.setCommerceRuleId(commerceRuleId);
	}

	/**
	 * Sets the company ID of this commerce rule.
	 *
	 * @param companyId the company ID of this commerce rule
	 */
	@Override
	public void setCompanyId(long companyId) {
		_commerceRule.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this commerce rule.
	 *
	 * @param createDate the create date of this commerce rule
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_commerceRule.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this commerce rule.
	 *
	 * @param description the description of this commerce rule
	 */
	@Override
	public void setDescription(String description) {
		_commerceRule.setDescription(description);
	}

	/**
	 * Sets the display date of this commerce rule.
	 *
	 * @param displayDate the display date of this commerce rule
	 */
	@Override
	public void setDisplayDate(Date displayDate) {
		_commerceRule.setDisplayDate(displayDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_commerceRule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_commerceRule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_commerceRule.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the expiration date of this commerce rule.
	 *
	 * @param expirationDate the expiration date of this commerce rule
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		_commerceRule.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the last publish date of this commerce rule.
	 *
	 * @param lastPublishDate the last publish date of this commerce rule
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_commerceRule.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this commerce rule.
	 *
	 * @param modifiedDate the modified date of this commerce rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_commerceRule.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_commerceRule.setNew(n);
	}

	/**
	 * Sets the primary key of this commerce rule.
	 *
	 * @param primaryKey the primary key of this commerce rule
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_commerceRule.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_commerceRule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public void setSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties settingsProperties) {

		_commerceRule.setSettingsProperties(settingsProperties);
	}

	/**
	 * Sets the status of this commerce rule.
	 *
	 * @param status the status of this commerce rule
	 */
	@Override
	public void setStatus(int status) {
		_commerceRule.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this commerce rule.
	 *
	 * @param statusByUserId the status by user ID of this commerce rule
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_commerceRule.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this commerce rule.
	 *
	 * @param statusByUserName the status by user name of this commerce rule
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_commerceRule.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this commerce rule.
	 *
	 * @param statusByUserUuid the status by user uuid of this commerce rule
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_commerceRule.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this commerce rule.
	 *
	 * @param statusDate the status date of this commerce rule
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_commerceRule.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this commerce rule.
	 *
	 * @param title the title of this commerce rule
	 */
	@Override
	public void setTitle(String title) {
		_commerceRule.setTitle(title);
	}

	/**
	 * Sets the type of this commerce rule.
	 *
	 * @param type the type of this commerce rule
	 */
	@Override
	public void setType(String type) {
		_commerceRule.setType(type);
	}

	/**
	 * Sets the type settings of this commerce rule.
	 *
	 * @param typeSettings the type settings of this commerce rule
	 */
	@Override
	public void setTypeSettings(String typeSettings) {
		_commerceRule.setTypeSettings(typeSettings);
	}

	/**
	 * Sets the user ID of this commerce rule.
	 *
	 * @param userId the user ID of this commerce rule
	 */
	@Override
	public void setUserId(long userId) {
		_commerceRule.setUserId(userId);
	}

	/**
	 * Sets the user name of this commerce rule.
	 *
	 * @param userName the user name of this commerce rule
	 */
	@Override
	public void setUserName(String userName) {
		_commerceRule.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this commerce rule.
	 *
	 * @param userUuid the user uuid of this commerce rule
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_commerceRule.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CommerceRule>
		toCacheModel() {

		return _commerceRule.toCacheModel();
	}

	@Override
	public CommerceRule toEscapedModel() {
		return new CommerceRuleWrapper(_commerceRule.toEscapedModel());
	}

	@Override
	public String toString() {
		return _commerceRule.toString();
	}

	@Override
	public CommerceRule toUnescapedModel() {
		return new CommerceRuleWrapper(_commerceRule.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _commerceRule.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceRuleWrapper)) {
			return false;
		}

		CommerceRuleWrapper commerceRuleWrapper = (CommerceRuleWrapper)obj;

		if (Objects.equals(_commerceRule, commerceRuleWrapper._commerceRule)) {
			return true;
		}

		return false;
	}

	@Override
	public CommerceRule getWrappedModel() {
		return _commerceRule;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _commerceRule.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _commerceRule.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_commerceRule.resetOriginalValues();
	}

	private final CommerceRule _commerceRule;

}