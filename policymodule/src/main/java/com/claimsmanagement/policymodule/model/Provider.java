package com.claimsmanagement.policymodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {

	@Id
	@Column(name = "provider_id", columnDefinition = "BIGINT")
	private long providerId;

	@Column(name = "hospital_name")
	private String name;
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public Provider() {
		super();
	}

	public Provider(long providerId, String name) {
		super();
		this.providerId = providerId;
		this.name = name;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

}
