package com.claimsmanagement.claimsmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {

	@Id
	@Column(name = "provider_id", columnDefinition = "BIGINT")
	private Long providerId;

	@Column(name = "hospital_name")
	private String name;

	public Provider() {
		super();
	}

	public Provider(Long providerId, String name) {
		super();
		this.providerId = providerId;
		this.name = name;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
