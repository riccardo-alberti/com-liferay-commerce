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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CommercePriceListRel}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListRel
 * @generated
 */
public class CommercePriceListRelWrapper
	implements CommercePriceListRel, ModelWrapper<CommercePriceListRel> {

	public CommercePriceListRelWrapper(
		CommercePriceListRel commercePriceListRel) {

		_commercePriceListRel = commercePriceListRel;
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceListRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceListRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commercePriceListRelId", getCommercePriceListRelId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("commercePriceListId", getCommercePriceListId());
		attributes.put("order", getOrder());
		attributes.put("lastPublishDate", getLastPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commercePriceListRelId = (Long)attributes.get(
			"commercePriceListRelId");

		if (commercePriceListRelId != null) {
			setCommercePriceListRelId(commercePriceListRelId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long commercePriceListId = (Long)attributes.get("commercePriceListId");

		if (commercePriceListId != null) {
			setCommercePriceListId(commercePriceListId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}
	}

	@Override
	public Object clone() {
		return new CommercePriceListRelWrapper(
			(CommercePriceListRel)_commercePriceListRel.clone());
	}

	@Override
	public int compareTo(CommercePriceListRel commercePriceListRel) {
		return _commercePriceListRel.compareTo(commercePriceListRel);
	}

	/**
	 * Returns the fully qualified class name of this commerce price list rel.
	 *
	 * @return the fully qualified class name of this commerce price list rel
	 */
	@Override
	public String getClassName() {
		return _commercePriceListRel.getClassName();
	}

	/**
	 * Returns the class name ID of this commerce price list rel.
	 *
	 * @return the class name ID of this commerce price list rel
	 */
	@Override
	public long getClassNameId() {
		return _commercePriceListRel.getClassNameId();
	}

	/**
	 * Returns the class pk of this commerce price list rel.
	 *
	 * @return the class pk of this commerce price list rel
	 */
	@Override
	public long getClassPK() {
		return _commercePriceListRel.getClassPK();
	}

	/**
	 * Returns the commerce price list ID of this commerce price list rel.
	 *
	 * @return the commerce price list ID of this commerce price list rel
	 */
	@Override
	public long getCommercePriceListId() {
		return _commercePriceListRel.getCommercePriceListId();
	}

	/**
	 * Returns the commerce price list rel ID of this commerce price list rel.
	 *
	 * @return the commerce price list rel ID of this commerce price list rel
	 */
	@Override
	public long getCommercePriceListRelId() {
		return _commercePriceListRel.getCommercePriceListRelId();
	}

	/**
	 * Returns the company ID of this commerce price list rel.
	 *
	 * @return the company ID of this commerce price list rel
	 */
	@Override
	public long getCompanyId() {
		return _commercePriceListRel.getCompanyId();
	}

	/**
	 * Returns the create date of this commerce price list rel.
	 *
	 * @return the create date of this commerce price list rel
	 */
	@Override
	public Date getCreateDate() {
		return _commercePriceListRel.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _commercePriceListRel.getExpandoBridge();
	}

	/**
	 * Returns the last publish date of this commerce price list rel.
	 *
	 * @return the last publish date of this commerce price list rel
	 */
	@Override
	public Date getLastPublishDate() {
		return _commercePriceListRel.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this commerce price list rel.
	 *
	 * @return the modified date of this commerce price list rel
	 */
	@Override
	public Date getModifiedDate() {
		return _commercePriceListRel.getModifiedDate();
	}

	/**
	 * Returns the order of this commerce price list rel.
	 *
	 * @return the order of this commerce price list rel
	 */
	@Override
	public int getOrder() {
		return _commercePriceListRel.getOrder();
	}

	/**
	 * Returns the primary key of this commerce price list rel.
	 *
	 * @return the primary key of this commerce price list rel
	 */
	@Override
	public long getPrimaryKey() {
		return _commercePriceListRel.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceListRel.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this commerce price list rel.
	 *
	 * @return the user ID of this commerce price list rel
	 */
	@Override
	public long getUserId() {
		return _commercePriceListRel.getUserId();
	}

	/**
	 * Returns the user name of this commerce price list rel.
	 *
	 * @return the user name of this commerce price list rel
	 */
	@Override
	public String getUserName() {
		return _commercePriceListRel.getUserName();
	}

	/**
	 * Returns the user uuid of this commerce price list rel.
	 *
	 * @return the user uuid of this commerce price list rel
	 */
	@Override
	public String getUserUuid() {
		return _commercePriceListRel.getUserUuid();
	}

	/**
	 * Returns the uuid of this commerce price list rel.
	 *
	 * @return the uuid of this commerce price list rel
	 */
	@Override
	public String getUuid() {
		return _commercePriceListRel.getUuid();
	}

	@Override
	public int hashCode() {
		return _commercePriceListRel.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _commercePriceListRel.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _commercePriceListRel.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _commercePriceListRel.isNew();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price list rel model instance should use the <code>CommercePriceListRel</code> interface instead.
	 */
	@Override
	public void persist() {
		_commercePriceListRel.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commercePriceListRel.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(String className) {
		_commercePriceListRel.setClassName(className);
	}

	/**
	 * Sets the class name ID of this commerce price list rel.
	 *
	 * @param classNameId the class name ID of this commerce price list rel
	 */
	@Override
	public void setClassNameId(long classNameId) {
		_commercePriceListRel.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this commerce price list rel.
	 *
	 * @param classPK the class pk of this commerce price list rel
	 */
	@Override
	public void setClassPK(long classPK) {
		_commercePriceListRel.setClassPK(classPK);
	}

	/**
	 * Sets the commerce price list ID of this commerce price list rel.
	 *
	 * @param commercePriceListId the commerce price list ID of this commerce price list rel
	 */
	@Override
	public void setCommercePriceListId(long commercePriceListId) {
		_commercePriceListRel.setCommercePriceListId(commercePriceListId);
	}

	/**
	 * Sets the commerce price list rel ID of this commerce price list rel.
	 *
	 * @param commercePriceListRelId the commerce price list rel ID of this commerce price list rel
	 */
	@Override
	public void setCommercePriceListRelId(long commercePriceListRelId) {
		_commercePriceListRel.setCommercePriceListRelId(commercePriceListRelId);
	}

	/**
	 * Sets the company ID of this commerce price list rel.
	 *
	 * @param companyId the company ID of this commerce price list rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		_commercePriceListRel.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this commerce price list rel.
	 *
	 * @param createDate the create date of this commerce price list rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_commercePriceListRel.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_commercePriceListRel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_commercePriceListRel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_commercePriceListRel.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the last publish date of this commerce price list rel.
	 *
	 * @param lastPublishDate the last publish date of this commerce price list rel
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_commercePriceListRel.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this commerce price list rel.
	 *
	 * @param modifiedDate the modified date of this commerce price list rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_commercePriceListRel.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_commercePriceListRel.setNew(n);
	}

	/**
	 * Sets the order of this commerce price list rel.
	 *
	 * @param order the order of this commerce price list rel
	 */
	@Override
	public void setOrder(int order) {
		_commercePriceListRel.setOrder(order);
	}

	/**
	 * Sets the primary key of this commerce price list rel.
	 *
	 * @param primaryKey the primary key of this commerce price list rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_commercePriceListRel.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_commercePriceListRel.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this commerce price list rel.
	 *
	 * @param userId the user ID of this commerce price list rel
	 */
	@Override
	public void setUserId(long userId) {
		_commercePriceListRel.setUserId(userId);
	}

	/**
	 * Sets the user name of this commerce price list rel.
	 *
	 * @param userName the user name of this commerce price list rel
	 */
	@Override
	public void setUserName(String userName) {
		_commercePriceListRel.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this commerce price list rel.
	 *
	 * @param userUuid the user uuid of this commerce price list rel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_commercePriceListRel.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this commerce price list rel.
	 *
	 * @param uuid the uuid of this commerce price list rel
	 */
	@Override
	public void setUuid(String uuid) {
		_commercePriceListRel.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CommercePriceListRel>
		toCacheModel() {

		return _commercePriceListRel.toCacheModel();
	}

	@Override
	public CommercePriceListRel toEscapedModel() {
		return new CommercePriceListRelWrapper(
			_commercePriceListRel.toEscapedModel());
	}

	@Override
	public String toString() {
		return _commercePriceListRel.toString();
	}

	@Override
	public CommercePriceListRel toUnescapedModel() {
		return new CommercePriceListRelWrapper(
			_commercePriceListRel.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _commercePriceListRel.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommercePriceListRelWrapper)) {
			return false;
		}

		CommercePriceListRelWrapper commercePriceListRelWrapper =
			(CommercePriceListRelWrapper)obj;

		if (Objects.equals(
				_commercePriceListRel,
				commercePriceListRelWrapper._commercePriceListRel)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _commercePriceListRel.getStagedModelType();
	}

	@Override
	public CommercePriceListRel getWrappedModel() {
		return _commercePriceListRel;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _commercePriceListRel.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _commercePriceListRel.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_commercePriceListRel.resetOriginalValues();
	}

	private final CommercePriceListRel _commercePriceListRel;

}