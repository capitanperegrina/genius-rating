package com.capitanperegrina.geniusrating.core.view.boatListView;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BoatListView implements Serializable {

	private static final long serialVersionUID = 4874151172185211248L;

	protected Integer boatId;
	protected String boatName;
	protected Integer builtYear;
	protected String shipyard;
	protected String model;
	protected BigDecimal loa;
	protected BigDecimal sNumber;
	protected BigDecimal rating;

	public Integer getBoatId() {
		return boatId;
	}

	public void setBoatId(Integer boatId) {
		this.boatId = boatId;
	}

	public String getBoatName() {
		return boatName;
	}

	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}

	public Integer getBuiltYear() {
		return builtYear;
	}

	public void setBuiltYear(Integer builtYear) {
		this.builtYear = builtYear;
	}

	public String getShipyard() {
		return shipyard;
	}

	public void setShipyard(String shipyard) {
		this.shipyard = shipyard;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getLoa() {
		return loa;
	}

	public void setLoa(BigDecimal loa) {
		this.loa = loa;
	}

	public BigDecimal getsNumber() {
		return sNumber;
	}

	public void setsNumber(BigDecimal sNumber) {
		this.sNumber = sNumber;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boatId, boatName, builtYear, loa, model, rating, sNumber, shipyard);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BoatListView)) {
			return false;
		}
		BoatListView other = (BoatListView) obj;
		return Objects.equals(boatId, other.boatId) && Objects.equals(boatName, other.boatName)
				&& Objects.equals(builtYear, other.builtYear) && Objects.equals(loa, other.loa)
				&& Objects.equals(model, other.model) && Objects.equals(rating, other.rating)
				&& Objects.equals(sNumber, other.sNumber) && Objects.equals(shipyard, other.shipyard);
	}

	@Override
	public String toString() {
		return "BoatListView [boatId=" + boatId + ", boatName=" + boatName + ", builtYear=" + builtYear + ", shipyard="
				+ shipyard + ", model=" + model + ", loa=" + loa + ", sNumber=" + sNumber + ", rating=" + rating + "]";
	}
}
