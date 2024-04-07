package com.claimsmanagement.claimsmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benefit")
public class Benefit {

	@Id
	@Column(name = "benefit_id")
	private Long benefitId;

	@Column(name = "benefit_description")
	private String description;

	public Long getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(Long benefitId) {
		this.benefitId = benefitId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Benefit(Long benefitId, String description) {
		super();
		this.benefitId = benefitId;
		this.description = description;
	}

	public Benefit() {
		super();
	}

	@Override
	public String toString() {
		return "Benefit [benefitId=" + benefitId + ", description=" + description + "]";
	}
	
}
