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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommerceRule service. Represents a row in the &quot;CommerceRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.rule.model.impl.CommerceRuleModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.rule.model.impl.CommerceRuleImpl</code>.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommerceRule
 * @generated
 */
@ProviderType
public interface CommerceRuleModel
	extends AuditedModel, BaseModel<CommerceRule>, ShardedModel,
			WorkflowedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce rule model instance should use the {@link CommerceRule} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce rule.
	 *
	 * @return the primary key of this commerce rule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce rule.
	 *
	 * @param primaryKey the primary key of this commerce rule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce rule ID of this commerce rule.
	 *
	 * @return the commerce rule ID of this commerce rule
	 */
	public long getCommerceRuleId();

	/**
	 * Sets the commerce rule ID of this commerce rule.
	 *
	 * @param commerceRuleId the commerce rule ID of this commerce rule
	 */
	public void setCommerceRuleId(long commerceRuleId);

	/**
	 * Returns the company ID of this commerce rule.
	 *
	 * @return the company ID of this commerce rule
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce rule.
	 *
	 * @param companyId the company ID of this commerce rule
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce rule.
	 *
	 * @return the user ID of this commerce rule
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce rule.
	 *
	 * @param userId the user ID of this commerce rule
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce rule.
	 *
	 * @return the user uuid of this commerce rule
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce rule.
	 *
	 * @param userUuid the user uuid of this commerce rule
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce rule.
	 *
	 * @return the user name of this commerce rule
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce rule.
	 *
	 * @param userName the user name of this commerce rule
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce rule.
	 *
	 * @return the create date of this commerce rule
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce rule.
	 *
	 * @param createDate the create date of this commerce rule
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce rule.
	 *
	 * @return the modified date of this commerce rule
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce rule.
	 *
	 * @param modifiedDate the modified date of this commerce rule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the type of this commerce rule.
	 *
	 * @return the type of this commerce rule
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this commerce rule.
	 *
	 * @param type the type of this commerce rule
	 */
	public void setType(String type);

	/**
	 * Returns the type settings of this commerce rule.
	 *
	 * @return the type settings of this commerce rule
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this commerce rule.
	 *
	 * @param typeSettings the type settings of this commerce rule
	 */
	public void setTypeSettings(String typeSettings);

	/**
	 * Returns the description of this commerce rule.
	 *
	 * @return the description of this commerce rule
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this commerce rule.
	 *
	 * @param description the description of this commerce rule
	 */
	public void setDescription(String description);

	/**
	 * Returns the display date of this commerce rule.
	 *
	 * @return the display date of this commerce rule
	 */
	public Date getDisplayDate();

	/**
	 * Sets the display date of this commerce rule.
	 *
	 * @param displayDate the display date of this commerce rule
	 */
	public void setDisplayDate(Date displayDate);

	/**
	 * Returns the expiration date of this commerce rule.
	 *
	 * @return the expiration date of this commerce rule
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this commerce rule.
	 *
	 * @param expirationDate the expiration date of this commerce rule
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Returns the last publish date of this commerce rule.
	 *
	 * @return the last publish date of this commerce rule
	 */
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this commerce rule.
	 *
	 * @param lastPublishDate the last publish date of this commerce rule
	 */
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this commerce rule.
	 *
	 * @return the status of this commerce rule
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this commerce rule.
	 *
	 * @param status the status of this commerce rule
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this commerce rule.
	 *
	 * @return the status by user ID of this commerce rule
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this commerce rule.
	 *
	 * @param statusByUserId the status by user ID of this commerce rule
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this commerce rule.
	 *
	 * @return the status by user uuid of this commerce rule
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this commerce rule.
	 *
	 * @param statusByUserUuid the status by user uuid of this commerce rule
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this commerce rule.
	 *
	 * @return the status by user name of this commerce rule
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this commerce rule.
	 *
	 * @param statusByUserName the status by user name of this commerce rule
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this commerce rule.
	 *
	 * @return the status date of this commerce rule
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this commerce rule.
	 *
	 * @param statusDate the status date of this commerce rule
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this commerce rule is approved.
	 *
	 * @return <code>true</code> if this commerce rule is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this commerce rule is denied.
	 *
	 * @return <code>true</code> if this commerce rule is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this commerce rule is a draft.
	 *
	 * @return <code>true</code> if this commerce rule is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this commerce rule is expired.
	 *
	 * @return <code>true</code> if this commerce rule is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this commerce rule is inactive.
	 *
	 * @return <code>true</code> if this commerce rule is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this commerce rule is incomplete.
	 *
	 * @return <code>true</code> if this commerce rule is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this commerce rule is pending.
	 *
	 * @return <code>true</code> if this commerce rule is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this commerce rule is scheduled.
	 *
	 * @return <code>true</code> if this commerce rule is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CommerceRule commerceRule);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceRule> toCacheModel();

	@Override
	public CommerceRule toEscapedModel();

	@Override
	public CommerceRule toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}