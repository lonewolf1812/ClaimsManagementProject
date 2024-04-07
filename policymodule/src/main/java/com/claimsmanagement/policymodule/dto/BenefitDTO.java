package com.claimsmanagement.policymodule.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BenefitDTO {
	
	@NotNull
	private Long benifitId;
	
	@NotNull
	@Size(min = 6, max = 100)
	private String desc;
	
	//---------------------------------------------------------------------------------------------------------------------------------
	
	public Long getBenifitId() {
		return benifitId;
	}

	public void setBenifitId(Long benifitId) {
		this.benifitId = benifitId;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public BenefitDTO(@NotNull Long benifitId, @NotNull @Size(min = 6, max = 100) String desc) {
		super();
		this.benifitId = benifitId;
		this.desc = desc;
	}

	public BenefitDTO() {
		super();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	
	

}
