package com.capitanperegrina.geniusrating.core.entity.boat;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Boat implements Serializable {
	private static final long serialVersionUID = -48516175667L;

	protected Integer boatId;
	protected Integer ownerId;
	protected String boatName;
	protected Integer designYear;
	protected Integer builtYear;
	protected String shipyard;
	protected String model;
	protected Integer numberMasts;
	protected Integer createdBy;
	protected Date createdDate;
	protected Integer modifiedBy;
	protected Date modifiedDate;

	public Boat() {
		super();
	}

	public Integer getBoatId() {
		return this.boatId;
	}

	public void setBoatId(Integer boatId) {
		this.boatId = boatId;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getBoatName() {
		return this.boatName;
	}

	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}

	public Integer getDesignYear() {
		return this.designYear;
	}

	public void setDesignYear(Integer designYear) {
		this.designYear = designYear;
	}

	public Integer getBuiltYear() {
		return this.builtYear;
	}

	public void setBuiltYear(Integer builtYear) {
		this.builtYear = builtYear;
	}

	public String getShipyard() {
		return this.shipyard;
	}

	public void setShipyard(String shipyard) {
		this.shipyard = shipyard;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getNumberMasts() {
		return this.numberMasts;
	}

	public void setNumberMasts(Integer numberMasts) {
		this.numberMasts = numberMasts;
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