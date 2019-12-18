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
 * This class is a wrapper for {@link CommercePriceListContractRel}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListContractRel
 * @generated
 */
public class CommercePriceListContractRelWrapper
	implements CommercePriceListContractRel,
			   ModelWrapper<CommercePriceListContractRel> {

	public CommercePriceListContractRelWrapper(
		CommercePriceListContractRel commercePriceListContractRel) {

		_commercePriceListContractRel = commercePriceListContractRel;
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceListContractRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceListContractRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"commercePriceListContractRelId",
			getCommercePriceListContractRelId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commerceContractId", getCommerceContractId());
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

		Long commercePriceListContractRelId = (Long)attributes.get(
			"commercePriceListContractRelId");

		if (commercePriceListContractRelId != null) {
			setCommercePriceListContractRelId(commercePriceListContractRelId);
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

		Long commerceContractId = (Long)attributes.get("commerceContractId");

		if (commerceContractId != null) {
			setCommerceContractId(commerceContractId);
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
		return new CommercePriceListContractRelWrapper(
			(CommercePriceListContractRel)
				_commercePriceListContractRel.clone());
	}

	@Override
	public int compareTo(
		CommercePriceListContractRel commercePriceListContractRel) {

		return _commercePriceListContractRel.compareTo(
			commercePriceListContractRel);
	}

	/**
	 * Returns the commerce contract ID of this commerce price list contract rel.
	 *
	 * @return the commerce contract ID of this commerce price list contract rel
	 */
	@Override
	public long getCommerceContractId() {
		return _commercePriceListContractRel.getCommerceContractId();
	}

	/**
	 * Returns the commerce price list contract rel ID of this commerce price list contract rel.
	 *
	 * @return the commerce price list contract rel ID of this commerce price list contract rel
	 */
	@Override
	public long getCommercePriceListContractRelId() {
		return _commercePriceListContractRel.
			getCommercePriceListContractRelId();
	}

	/**
	 * Returns the commerce price list ID of this commerce price list contract rel.
	 *
	 * @return the commerce price list ID of this commerce price list contract rel
	 */
	@Override
	public long getCommercePriceListId() {
		return _commercePriceListContractRel.getCommercePriceListId();
	}

	/**
	 * Returns the company ID of this commerce price list contract rel.
	 *
	 * @return the company ID of this commerce price list contract rel
	 */
	@Override
	public long getCompanyId() {
		return _commercePriceListContractRel.getCompanyId();
	}

	/**
	 * Returns the create date of this commerce price list contract rel.
	 *
	 * @return the create date of this commerce price list contract rel
	 */
	@Override
	public Date getCreateDate() {
		return _commercePriceListContractRel.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _commercePriceListContractRel.getExpandoBridge();
	}

	/**
	 * Returns the last publish date of this commerce price list contract rel.
	 *
	 * @return the last publish date of this commerce price list contract rel
	 */
	@Override
	public Date getLastPublishDate() {
		return _commercePriceListContractRel.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this commerce price list contract rel.
	 *
	 * @return the modified date of this commerce price list contract rel
	 */
	@Override
	public Date getModifiedDate() {
		return _commercePriceListContractRel.getModifiedDate();
	}

	/**
	 * Returns the order of this commerce price list contract rel.
	 *
	 * @return the order of this commerce price list contract rel
	 */
	@Override
	public int getOrder() {
		return _commercePriceListContractRel.getOrder();
	}

	/**
	 * Returns the primary key of this commerce price list contract rel.
	 *
	 * @return the primary key of this commerce price list contract rel
	 */
	@Override
	public long getPrimaryKey() {
		return _commercePriceListContractRel.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceListContractRel.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this commerce price list contract rel.
	 *
	 * @return the user ID of this commerce price list contract rel
	 */
	@Override
	public long getUserId() {
		return _commercePriceListContractRel.getUserId();
	}

	/**
	 * Returns the user name of this commerce price list contract rel.
	 *
	 * @return the user name of this commerce price list contract rel
	 */
	@Override
	public String getUserName() {
		return _commercePriceListContractRel.getUserName();
	}

	/**
	 * Returns the user uuid of this commerce price list contract rel.
	 *
	 * @return the user uuid of this commerce price list contract rel
	 */
	@Override
	public String getUserUuid() {
		return _commercePriceListContractRel.getUserUuid();
	}

	/**
	 * Returns the uuid of this commerce price list contract rel.
	 *
	 * @return the uuid of this commerce price list contract rel
	 */
	@Override
	public String getUuid() {
		return _commercePriceListContractRel.getUuid();
	}

	@Override
	public int hashCode() {
		return _commercePriceListContractRel.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _commercePriceListContractRel.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _commercePriceListContractRel.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _commercePriceListContractRel.isNew();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price list contract rel model instance should use the <code>CommercePriceListContractRel</code> interface instead.
	 */
	@Override
	public void persist() {
		_commercePriceListContractRel.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commercePriceListContractRel.setCachedModel(cachedModel);
	}

	/**
	 * Sets the commerce contract ID of this commerce price list contract rel.
	 *
	 * @param commerceContractId the commerce contract ID of this commerce price list contract rel
	 */
	@Override
	public void setCommerceContractId(long commerceContractId) {
		_commercePriceListContractRel.setCommerceContractId(commerceContractId);
	}

	/**
	 * Sets the commerce price list contract rel ID of this commerce price list contract rel.
	 *
	 * @param commercePriceListContractRelId the commerce price list contract rel ID of this commerce price list contract rel
	 */
	@Override
	public void setCommercePriceListContractRelId(
		long commercePriceListContractRelId) {

		_commercePriceListContractRel.setCommercePriceListContractRelId(
			commercePriceListContractRelId);
	}

	/**
	 * Sets the commerce price list ID of this commerce price list contract rel.
	 *
	 * @param commercePriceListId the commerce price list ID of this commerce price list contract rel
	 */
	@Override
	public void setCommercePriceListId(long commercePriceListId) {
		_commercePriceListContractRel.setCommercePriceListId(
			commercePriceListId);
	}

	/**
	 * Sets the company ID of this commerce price list contract rel.
	 *
	 * @param companyId the company ID of this commerce price list contract rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		_commercePriceListContractRel.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this commerce price list contract rel.
	 *
	 * @param createDate the create date of this commerce price list contract rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_commercePriceListContractRel.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_commercePriceListContractRel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_commercePriceListContractRel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_commercePriceListContractRel.setExpandoBridgeAttributes(
			serviceContext);
	}

	/**
	 * Sets the last publish date of this commerce price list contract rel.
	 *
	 * @param lastPublishDate the last publish date of this commerce price list contract rel
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_commercePriceListContractRel.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this commerce price list contract rel.
	 *
	 * @param modifiedDate the modified date of this commerce price list contract rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_commercePriceListContractRel.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_commercePriceListContractRel.setNew(n);
	}

	/**
	 * Sets the order of this commerce price list contract rel.
	 *
	 * @param order the order of this commerce price list contract rel
	 */
	@Override
	public void setOrder(int order) {
		_commercePriceListContractRel.setOrder(order);
	}

	/**
	 * Sets the primary key of this commerce price list contract rel.
	 *
	 * @param primaryKey the primary key of this commerce price list contract rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_commercePriceListContractRel.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_commercePriceListContractRel.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this commerce price list contract rel.
	 *
	 * @param userId the user ID of this commerce price list contract rel
	 */
	@Override
	public void setUserId(long userId) {
		_commercePriceListContractRel.setUserId(userId);
	}

	/**
	 * Sets the user name of this commerce price list contract rel.
	 *
	 * @param userName the user name of this commerce price list contract rel
	 */
	@Override
	public void setUserName(String userName) {
		_commercePriceListContractRel.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this commerce price list contract rel.
	 *
	 * @param userUuid the user uuid of this commerce price list contract rel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_commercePriceListContractRel.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this commerce price list contract rel.
	 *
	 * @param uuid the uuid of this commerce price list contract rel
	 */
	@Override
	public void setUuid(String uuid) {
		_commercePriceListContractRel.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<CommercePriceListContractRel> toCacheModel() {

		return _commercePriceListContractRel.toCacheModel();
	}

	@Override
	public CommercePriceListContractRel toEscapedModel() {
		return new CommercePriceListContractRelWrapper(
			_commercePriceListContractRel.toEscapedModel());
	}

	@Override
	public String toString() {
		return _commercePriceListContractRel.toString();
	}

	@Override
	public CommercePriceListContractRel toUnescapedModel() {
		return new CommercePriceListContractRelWrapper(
			_commercePriceListContractRel.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _commercePriceListContractRel.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommercePriceListContractRelWrapper)) {
			return false;
		}

		CommercePriceListContractRelWrapper
			commercePriceListContractRelWrapper =
				(CommercePriceListContractRelWrapper)obj;

		if (Objects.equals(
				_commercePriceListContractRel,
				commercePriceListContractRelWrapper.
					_commercePriceListContractRel)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _commercePriceListContractRel.getStagedModelType();
	}

	@Override
	public CommercePriceListContractRel getWrappedModel() {
		return _commercePriceListContractRel;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _commercePriceListContractRel.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _commercePriceListContractRel.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_commercePriceListContractRel.resetOriginalValues();
	}

	private final CommercePriceListContractRel _commercePriceListContractRel;

}