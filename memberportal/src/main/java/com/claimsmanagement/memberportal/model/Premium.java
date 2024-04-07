package com.claimsmanagement.memberportal.model;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat; 

public class Premium {
	@Id
	@NotNull(message="MemberId should not be empty")
	private Long  memberId;
	
	@NotNull(message="PolicyId should not be empty")
	private Long  policyId;
	
	@NotNull(message="Please provide the Policy name")
	@Length(min=10,max=30)
	private String policyName;
	
	@NotNull	
	private double premiumDueAmount;
	
	@Pattern(regexp="^[0]{1}")
	private double charges;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date dueDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date premiumPaidDate;




	public Premium(@NotNull(message = "MemberId should not be empty") Long memberId,
			@NotNull(message = "PolicyId should not be empty") Long policyId,
			@NotNull(message = "Please provide the Policy name") @Length(min = 10, max = 30) String policyName,
			@NotNull double premiumDueAmount, @Pattern(regexp = "^[0]{1}") double charges,
			@NotNull(message = "Please provide a date.") Date dueDate,
			@NotNull(message = "Please provide a date.") Date premiumPaidDate) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.policyName = policyName;
		this.premiumDueAmount = premiumDueAmount;
		this.charges = charges;
		this.dueDate = dueDate;
		this.premiumPaidDate = premiumPaidDate;
	}


	public Premium() {
		super();
	}


	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public double getPremiumDueAmount() {
		return premiumDueAmount;
	}

	public void setPremiumDueAmount(double premiumDueAmount) {
		this.premiumDueAmount = premiumDueAmount;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPremiumPaidDate() {
		return premiumPaidDate;
	}

	public void setPremiumPaidDate(Date premiumPaidDate) {
		this.premiumPaidDate = premiumPaidDate;
	}

	@Override
	public String toString() {
		return "Premium [memberId=" + memberId + ", policyId=" + policyId + ", policyName=" + policyName
				+ ", premiumDueAmount=" + premiumDueAmount + ", charges=" + charges + ", dueDate=" + dueDate
				+ ", premiumPaidDate=" + premiumPaidDate + "]";
	}		

	
}
