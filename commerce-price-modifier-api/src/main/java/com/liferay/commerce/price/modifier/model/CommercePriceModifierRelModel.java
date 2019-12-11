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
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommercePriceModifierRel service. Represents a row in the &quot;CommercePriceModifierRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.price.modifier.model.impl.CommercePriceModifierRelImpl</code>.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommercePriceModifierRel
 * @generated
 */
@ProviderType
public interface CommercePriceModifierRelModel
	extends AttachedModel, AuditedModel, BaseModel<CommercePriceModifierRel>,
			ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce price modifier rel model instance should use the {@link CommercePriceModifierRel} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce price modifier rel.
	 *
	 * @return the primary key of this commerce price modifier rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce price modifier rel.
	 *
	 * @param primaryKey the primary key of this commerce price modifier rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the commerce price modifier rel ID of this commerce price modifier rel.
	 *
	 * @return the commerce price modifier rel ID of this commerce price modifier rel
	 */
	public long getCommercePriceModifierRelId();

	/**
	 * Sets the commerce price modifier rel ID of this commerce price modifier rel.
	 *
	 * @param commercePriceModifierRelId the commerce price modifier rel ID of this commerce price modifier rel
	 */
	public void setCommercePriceModifierRelId(long commercePriceModifierRelId);

	/**
	 * Returns the company ID of this commerce price modifier rel.
	 *
	 * @return the company ID of this commerce price modifier rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce price modifier rel.
	 *
	 * @param companyId the company ID of this commerce price modifier rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce price modifier rel.
	 *
	 * @return the user ID of this commerce price modifier rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce price modifier rel.
	 *
	 * @param userId the user ID of this commerce price modifier rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce price modifier rel.
	 *
	 * @return the user uuid of this commerce price modifier rel
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce price modifier rel.
	 *
	 * @param userUuid the user uuid of this commerce price modifier rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce price modifier rel.
	 *
	 * @return the user name of this commerce price modifier rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce price modifier rel.
	 *
	 * @param userName the user name of this commerce price modifier rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce price modifier rel.
	 *
	 * @return the create date of this commerce price modifier rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce price modifier rel.
	 *
	 * @param createDate the create date of this commerce price modifier rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce price modifier rel.
	 *
	 * @return the modified date of this commerce price modifier rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce price modifier rel.
	 *
	 * @param modifiedDate the modified date of this commerce price modifier rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce price modifier ID of this commerce price modifier rel.
	 *
	 * @return the commerce price modifier ID of this commerce price modifier rel
	 */
	public long getCommercePriceModifierId();

	/**
	 * Sets the commerce price modifier ID of this commerce price modifier rel.
	 *
	 * @param commercePriceModifierId the commerce price modifier ID of this commerce price modifier rel
	 */
	public void setCommercePriceModifierId(long commercePriceModifierId);

	/**
	 * Returns the fully qualified class name of this commerce price modifier rel.
	 *
	 * @return the fully qualified class name of this commerce price modifier rel
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this commerce price modifier rel.
	 *
	 * @return the class name ID of this commerce price modifier rel
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this commerce price modifier rel.
	 *
	 * @param classNameId the class name ID of this commerce price modifier rel
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this commerce price modifier rel.
	 *
	 * @return the class pk of this commerce price modifier rel
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this commerce price modifier rel.
	 *
	 * @param classPK the class pk of this commerce price modifier rel
	 */
	@Override
	public void setClassPK(long classPK);

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
	public int compareTo(CommercePriceModifierRel commercePriceModifierRel);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommercePriceModifierRel> toCacheModel();

	@Override
	public CommercePriceModifierRel toEscapedModel();

	@Override
	public CommercePriceModifierRel toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}