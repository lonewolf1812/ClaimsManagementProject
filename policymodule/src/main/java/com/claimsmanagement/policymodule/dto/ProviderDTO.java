package com.claimsmanagement.policymodule.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProviderDTO {

	@NotNull
	private Long providerId;
	
	@NotNull
	@Size(min = 3, max = 30)
	private String name;
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
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

	public ProviderDTO(Long providerId, @Size(min = 3, max = 30) String name) {
		super();
		this.providerId = providerId;
		this.name = name;
	}

	public ProviderDTO() {
		super();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	
}
