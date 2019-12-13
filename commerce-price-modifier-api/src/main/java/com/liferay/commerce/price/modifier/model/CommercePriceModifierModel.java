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

package com.liferay.commerce.price.modifier.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The base model interface for the CommercePriceModifier service. Represents a row in the &quot;CommercePriceModifier&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierImpl</code>.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifier
 * @generated
 */
@ProviderType
public interface CommercePriceModifierModel
	extends BaseModel<CommercePriceModifier>, ShardedModel, StagedGroupedModel,
			WorkflowedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce price modifier model instance should use the {@link CommercePriceModifier} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce price modifier.
	 *
	 * @return the primary key of this commerce price modifier
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce price modifier.
	 *
	 * @param primaryKey the primary key of this commerce price modifier
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this commerce price modifier.
	 *
	 * @return the uuid of this commerce price modifier
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce price modifier.
	 *
	 * @param uuid the uuid of this commerce price modifier
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this commerce price modifier.
	 *
	 * @return the external reference code of this commerce price modifier
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this commerce price modifier.
	 *
	 * @param externalReferenceCode the external reference code of this commerce price modifier
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the commerce price modifier ID of this commerce price modifier.
	 *
	 * @return the commerce price modifier ID of this commerce price modifier
	 */
	public long getCommercePriceModifierId();

	/**
	 * Sets the commerce price modifier ID of this commerce price modifier.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID of this commerce price modifier
	 */
	public void setCommercePriceModifierId(long commercePriceModifierId);

	/**
	 * Returns the group ID of this commerce price modifier.
	 *
	 * @return the group ID of this commerce price modifier
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce price modifier.
	 *
	 * @param groupId the group ID of this commerce price modifier
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce price modifier.
	 *
	 * @return the company ID of this commerce price modifier
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce price modifier.
	 *
	 * @param companyId the company ID of this commerce price modifier
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce price modifier.
	 *
	 * @return the user ID of this commerce price modifier
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce price modifier.
	 *
	 * @param userId the user ID of this commerce price modifier
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce price modifier.
	 *
	 * @return the user uuid of this commerce price modifier
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce price modifier.
	 *
	 * @param userUuid the user uuid of this commerce price modifier
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce price modifier.
	 *
	 * @return the user name of this commerce price modifier
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce price modifier.
	 *
	 * @param userName the user name of this commerce price modifier
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce price modifier.
	 *
	 * @return the create date of this commerce price modifier
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce price modifier.
	 *
	 * @param createDate the create date of this commerce price modifier
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce price modifier.
	 *
	 * @return the modified date of this commerce price modifier
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce price modifier.
	 *
	 * @param modifiedDate the modified date of this commerce price modifier
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this commerce price modifier.
	 *
	 * @return the description of this commerce price modifier
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this commerce price modifier.
	 *
	 * @param description the description of this commerce price modifier
	 */
	public void setDescription(String description);

	/**
	 * Returns the title of this commerce price modifier.
	 *
	 * @return the title of this commerce price modifier
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this commerce price modifier.
	 *
	 * @param title the title of this commerce price modifier
	 */
	public void setTitle(String title);

	/**
	 * Returns the target of this commerce price modifier.
	 *
	 * @return the target of this commerce price modifier
	 */
	@AutoEscape
	public String getTarget();

	/**
	 * Sets the target of this commerce price modifier.
	 *
	 * @param target the target of this commerce price modifier
	 */
	public void setTarget(String target);

	/**
	 * Returns the modifier amount of this commerce price modifier.
	 *
	 * @return the modifier amount of this commerce price modifier
	 */
	public BigDecimal getModifierAmount();

	/**
	 * Sets the modifier amount of this commerce price modifier.
	 *
	 * @param modifierAmount the modifier amount of this commerce price modifier
	 */
	public void setModifierAmount(BigDecimal modifierAmount);

	/**
	 * Returns the modifier type of this commerce price modifier.
	 *
	 * @return the modifier type of this commerce price modifier
	 */
	@AutoEscape
	public String getModifierType();

	/**
	 * Sets the modifier type of this commerce price modifier.
	 *
	 * @param modifierType the modifier type of this commerce price modifier
	 */
	public void setModifierType(String modifierType);

	/**
	 * Returns the priority of this commerce price modifier.
	 *
	 * @return the priority of this commerce price modifier
	 */
	public double getPriority();

	/**
	 * Sets the priority of this commerce price modifier.
	 *
	 * @param priority the priority of this commerce price modifier
	 */
	public void setPriority(double priority);

	/**
	 * Returns the active of this commerce price modifier.
	 *
	 * @return the active of this commerce price modifier
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this commerce price modifier is active.
	 *
	 * @return <code>true</code> if this commerce price modifier is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this commerce price modifier is active.
	 *
	 * @param active the active of this commerce price modifier
	 */
	public void setActive(boolean active);

	/**
	 * Returns the display date of this commerce price modifier.
	 *
	 * @return the display date of this commerce price modifier
	 */
	public Date getDisplayDate();

	/**
	 * Sets the display date of this commerce price modifier.
	 *
	 * @param displayDate the display date of this commerce price modifier
	 */
	public void setDisplayDate(Date displayDate);

	/**
	 * Returns the expiration date of this commerce price modifier.
	 *
	 * @return the expiration date of this commerce price modifier
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this commerce price modifier.
	 *
	 * @param expirationDate the expiration date of this commerce price modifier
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Returns the last publish date of this commerce price modifier.
	 *
	 * @return the last publish date of this commerce price modifier
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this commerce price modifier.
	 *
	 * @param lastPublishDate the last publish date of this commerce price modifier
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this commerce price modifier.
	 *
	 * @return the status of this commerce price modifier
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this commerce price modifier.
	 *
	 * @param status the status of this commerce price modifier
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this commerce price modifier.
	 *
	 * @return the status by user ID of this commerce price modifier
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this commerce price modifier.
	 *
	 * @param statusByUserId the status by user ID of this commerce price modifier
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this commerce price modifier.
	 *
	 * @return the status by user uuid of this commerce price modifier
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this commerce price modifier.
	 *
	 * @param statusByUserUuid the status by user uuid of this commerce price modifier
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this commerce price modifier.
	 *
	 * @return the status by user name of this commerce price modifier
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this commerce price modifier.
	 *
	 * @param statusByUserName the status by user name of this commerce price modifier
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this commerce price modifier.
	 *
	 * @return the status date of this commerce price modifier
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this commerce price modifier.
	 *
	 * @param statusDate the status date of this commerce price modifier
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this commerce price modifier is approved.
	 *
	 * @return <code>true</code> if this commerce price modifier is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this commerce price modifier is denied.
	 *
	 * @return <code>true</code> if this commerce price modifier is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this commerce price modifier is a draft.
	 *
	 * @return <code>true</code> if this commerce price modifier is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this commerce price modifier is expired.
	 *
	 * @return <code>true</code> if this commerce price modifier is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this commerce price modifier is inactive.
	 *
	 * @return <code>true</code> if this commerce price modifier is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this commerce price modifier is incomplete.
	 *
	 * @return <code>true</code> if this commerce price modifier is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this commerce price modifier is pending.
	 *
	 * @return <code>true</code> if this commerce price modifier is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this commerce price modifier is scheduled.
	 *
	 * @return <code>true</code> if this commerce price modifier is scheduled; <code>false</code> otherwise
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
	public int compareTo(CommercePriceModifier commercePriceModifier);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommercePriceModifier> toCacheModel();

	@Override
	public CommercePriceModifier toEscapedModel();

	@Override
	public CommercePriceModifier toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}