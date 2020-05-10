package com.capitanperegrina.geniusrating.core.entity.boat;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BoatData implements Serializable {
	private static final long serialVersionUID = -54194740996L;

	protected Integer boatDataId;
	protected Integer edition;
	protected Integer boatId;
	protected String key;
	protected String value;
	protected String type;
	protected Integer createdBy;
	protected Date createdDate;
	protected Integer modifiedBy;
	protected Date modifiedDate;

	public BoatData() {
		super();
	}

	public Integer getBoatDataId() {
		return this.boatDataId;
	}

	public void setBoatDataId(Integer boatDataId) {
		this.boatDataId = boatDataId;
	}

	public Integer getEdition() {
		return this.edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Integer getBoatId() {
		return this.boatId;
	}

	public void setBoatId(Integer boatId) {
		this.boatId = boatId;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
		return ReflectionToStringBuilder.toString(this);
	}
}