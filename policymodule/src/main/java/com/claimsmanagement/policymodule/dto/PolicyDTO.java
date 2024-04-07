package com.claimsmanagement.policymodule.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PolicyDTO {
	@NotNull
	private Long policyId;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String name;
	
	@NotNull
	private int premium;
	
	@NotNull
	private int tenure;
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public PolicyDTO() {
		super();
	}
	public PolicyDTO(Long policyId,@Size(min = 3, max = 30) String name, int premium, int tenure) {
		super();
		this.policyId = policyId;
		this.name = name;
		this.premium = premium;
		this.tenure = tenure;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

		
}
