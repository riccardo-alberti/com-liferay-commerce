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
import com.liferay.commerce.rule.model.CommerceRuleModel;
import com.liferay.commerce.rule.model.CommerceRuleSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceRule service. Represents a row in the &quot;CommerceRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceRuleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceRuleImpl}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see CommerceRuleImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceRuleModelImpl
	extends BaseModelImpl<CommerceRule> implements CommerceRuleModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce rule model instance should use the <code>CommerceRule</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceRule";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceRuleId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"description", Types.VARCHAR}, {"title", Types.VARCHAR},
		{"type_", Types.VARCHAR}, {"typeSettings", Types.VARCHAR},
		{"displayDate", Types.TIMESTAMP}, {"expirationDate", Types.TIMESTAMP},
		{"lastPublishDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceRuleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("displayDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expirationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceRule (commerceRuleId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null,title VARCHAR(75) null,type_ VARCHAR(75) null,typeSettings VARCHAR(75) null,displayDate DATE null,expirationDate DATE null,lastPublishDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table CommerceRule";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceRule.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceRule.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.rule.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.rule.model.CommerceRule"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.rule.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.rule.model.CommerceRule"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.rule.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.rule.model.CommerceRule"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long DISPLAYDATE_COLUMN_BITMASK = 2L;

	public static final long EXPIRATIONDATE_COLUMN_BITMASK = 4L;

	public static final long STATUS_COLUMN_BITMASK = 8L;

	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceRule toModel(CommerceRuleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceRule model = new CommerceRuleImpl();

		model.setCommerceRuleId(soapModel.getCommerceRuleId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDescription(soapModel.getDescription());
		model.setTitle(soapModel.getTitle());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());
		model.setDisplayDate(soapModel.getDisplayDate());
		model.setExpirationDate(soapModel.getExpirationDate());
		model.setLastPublishDate(soapModel.getLastPublishDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceRule> toModels(CommerceRuleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceRule> models = new ArrayList<CommerceRule>(
			soapModels.length);

		for (CommerceRuleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.rule.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.rule.model.CommerceRule"));

	public CommerceRuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Map<String, Function<CommerceRule, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceRule, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceRule)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceRule, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceRule, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceRule)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceRule, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceRule, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceRule>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceRule.class.getClassLoader(), CommerceRule.class,
			ModelWrapper.class);

		try {
			Constructor<CommerceRule> constructor =
				(Constructor<CommerceRule>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CommerceRule, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceRule, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceRule, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CommerceRule, Object>>();
		Map<String, BiConsumer<CommerceRule, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CommerceRule, ?>>();

		attributeGetterFunctions.put(
			"commerceRuleId",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getCommerceRuleId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceRuleId",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object commerceRuleIdObject) {

					commerceRule.setCommerceRuleId((Long)commerceRuleIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object companyIdObject) {

					commerceRule.setCompanyId((Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object userIdObject) {

					commerceRule.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object userNameObject) {

					commerceRule.setUserName((String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object createDateObject) {

					commerceRule.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object modifiedDateObject) {

					commerceRule.setModifiedDate((Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object descriptionObject) {

					commerceRule.setDescription((String)descriptionObject);
				}

			});
		attributeGetterFunctions.put(
			"title",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"title",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object titleObject) {

					commerceRule.setTitle((String)titleObject);
				}

			});
		attributeGetterFunctions.put(
			"type",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getType();
				}

			});
		attributeSetterBiConsumers.put(
			"type",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object typeObject) {

					commerceRule.setType((String)typeObject);
				}

			});
		attributeGetterFunctions.put(
			"typeSettings",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getTypeSettings();
				}

			});
		attributeSetterBiConsumers.put(
			"typeSettings",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object typeSettingsObject) {

					commerceRule.setTypeSettings((String)typeSettingsObject);
				}

			});
		attributeGetterFunctions.put(
			"displayDate",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getDisplayDate();
				}

			});
		attributeSetterBiConsumers.put(
			"displayDate",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object displayDateObject) {

					commerceRule.setDisplayDate((Date)displayDateObject);
				}

			});
		attributeGetterFunctions.put(
			"expirationDate",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getExpirationDate();
				}

			});
		attributeSetterBiConsumers.put(
			"expirationDate",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object expirationDateObject) {

					commerceRule.setExpirationDate((Date)expirationDateObject);
				}

			});
		attributeGetterFunctions.put(
			"lastPublishDate",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getLastPublishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object lastPublishDateObject) {

					commerceRule.setLastPublishDate(
						(Date)lastPublishDateObject);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object statusObject) {

					commerceRule.setStatus((Integer)statusObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object statusByUserIdObject) {

					commerceRule.setStatusByUserId((Long)statusByUserIdObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object statusByUserNameObject) {

					commerceRule.setStatusByUserName(
						(String)statusByUserNameObject);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<CommerceRule, Object>() {

				@Override
				public Object apply(CommerceRule commerceRule) {
					return commerceRule.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<CommerceRule, Object>() {

				@Override
				public void accept(
					CommerceRule commerceRule, Object statusDateObject) {

					commerceRule.setStatusDate((Date)statusDateObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceRuleId() {
		return _commerceRuleId;
	}

	@Override
	public void setCommerceRuleId(long commerceRuleId) {
		_commerceRuleId = commerceRuleId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@JSON
	@Override
	public Date getDisplayDate() {
		return _displayDate;
	}

	@Override
	public void setDisplayDate(Date displayDate) {
		_columnBitmask |= DISPLAYDATE_COLUMN_BITMASK;

		if (_originalDisplayDate == null) {
			_originalDisplayDate = _displayDate;
		}

		_displayDate = displayDate;
	}

	public Date getOriginalDisplayDate() {
		return _originalDisplayDate;
	}

	@JSON
	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		_columnBitmask |= EXPIRATIONDATE_COLUMN_BITMASK;

		if (_originalExpirationDate == null) {
			_originalExpirationDate = _expirationDate;
		}

		_expirationDate = expirationDate;
	}

	public Date getOriginalExpirationDate() {
		return _originalExpirationDate;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceRule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceRule toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceRule>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceRuleImpl commerceRuleImpl = new CommerceRuleImpl();

		commerceRuleImpl.setCommerceRuleId(getCommerceRuleId());
		commerceRuleImpl.setCompanyId(getCompanyId());
		commerceRuleImpl.setUserId(getUserId());
		commerceRuleImpl.setUserName(getUserName());
		commerceRuleImpl.setCreateDate(getCreateDate());
		commerceRuleImpl.setModifiedDate(getModifiedDate());
		commerceRuleImpl.setDescription(getDescription());
		commerceRuleImpl.setTitle(getTitle());
		commerceRuleImpl.setType(getType());
		commerceRuleImpl.setTypeSettings(getTypeSettings());
		commerceRuleImpl.setDisplayDate(getDisplayDate());
		commerceRuleImpl.setExpirationDate(getExpirationDate());
		commerceRuleImpl.setLastPublishDate(getLastPublishDate());
		commerceRuleImpl.setStatus(getStatus());
		commerceRuleImpl.setStatusByUserId(getStatusByUserId());
		commerceRuleImpl.setStatusByUserName(getStatusByUserName());
		commerceRuleImpl.setStatusDate(getStatusDate());

		commerceRuleImpl.resetOriginalValues();

		return commerceRuleImpl;
	}

	@Override
	public int compareTo(CommerceRule commerceRule) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), commerceRule.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceRule)) {
			return false;
		}

		CommerceRule commerceRule = (CommerceRule)obj;

		long primaryKey = commerceRule.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceRuleModelImpl commerceRuleModelImpl = this;

		commerceRuleModelImpl._originalCompanyId =
			commerceRuleModelImpl._companyId;

		commerceRuleModelImpl._setOriginalCompanyId = false;

		commerceRuleModelImpl._setModifiedDate = false;

		commerceRuleModelImpl._originalDisplayDate =
			commerceRuleModelImpl._displayDate;

		commerceRuleModelImpl._originalExpirationDate =
			commerceRuleModelImpl._expirationDate;

		commerceRuleModelImpl._originalStatus = commerceRuleModelImpl._status;

		commerceRuleModelImpl._setOriginalStatus = false;

		commerceRuleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceRule> toCacheModel() {
		CommerceRuleCacheModel commerceRuleCacheModel =
			new CommerceRuleCacheModel();

		commerceRuleCacheModel.commerceRuleId = getCommerceRuleId();

		commerceRuleCacheModel.companyId = getCompanyId();

		commerceRuleCacheModel.userId = getUserId();

		commerceRuleCacheModel.userName = getUserName();

		String userName = commerceRuleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceRuleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceRuleCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceRuleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceRuleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceRuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceRuleCacheModel.description = getDescription();

		String description = commerceRuleCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			commerceRuleCacheModel.description = null;
		}

		commerceRuleCacheModel.title = getTitle();

		String title = commerceRuleCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			commerceRuleCacheModel.title = null;
		}

		commerceRuleCacheModel.type = getType();

		String type = commerceRuleCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			commerceRuleCacheModel.type = null;
		}

		commerceRuleCacheModel.typeSettings = getTypeSettings();

		String typeSettings = commerceRuleCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			commerceRuleCacheModel.typeSettings = null;
		}

		Date displayDate = getDisplayDate();

		if (displayDate != null) {
			commerceRuleCacheModel.displayDate = displayDate.getTime();
		}
		else {
			commerceRuleCacheModel.displayDate = Long.MIN_VALUE;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			commerceRuleCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			commerceRuleCacheModel.expirationDate = Long.MIN_VALUE;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commerceRuleCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			commerceRuleCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		commerceRuleCacheModel.status = getStatus();

		commerceRuleCacheModel.statusByUserId = getStatusByUserId();

		commerceRuleCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = commerceRuleCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			commerceRuleCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			commerceRuleCacheModel.statusDate = statusDate.getTime();
		}
		else {
			commerceRuleCacheModel.statusDate = Long.MIN_VALUE;
		}

		return commerceRuleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceRule, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceRule, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CommerceRule)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CommerceRule, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceRule, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceRule, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CommerceRule)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceRule>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _commerceRuleId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _description;
	private String _title;
	private String _type;
	private String _typeSettings;
	private Date _displayDate;
	private Date _originalDisplayDate;
	private Date _expirationDate;
	private Date _originalExpirationDate;
	private Date _lastPublishDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private CommerceRule _escapedModel;

}