package com.claimsmanagement.policymodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benifit")
public class Benifit {

	@Id
	@Column(name = "benifit_id")
	private long benifitId;

	@Column(name = "benifit_description")
	private String description;
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public long getBenifitId() {
		return benifitId;
	}

	public void setBenifitId(long benifitId) {
		this.benifitId = benifitId;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public Benifit(long benifitId, String description) {
		super();
		this.benifitId = benifitId;
		this.description = description;
	}

	public Benifit() {
		super();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

}
