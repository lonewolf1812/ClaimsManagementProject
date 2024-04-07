package com.claimsmanagement.membermodule.Dto;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat; 

public class PremiumDto {
	
	@Id
	private Long  memberId;
	
	@NotNull(message = "Please provide a policyId.")
	private Long  policyId;
	
	@NotNull(message = "Please provide a policyName.")
	@Length(min=10,max=30)
	private String policyName;
	
	@NotNull	
	@Pattern(regexp="^[1-5]{1}[0]{3}",message="length must be 4")
	private double premiumDueAmount;
	
	@Pattern(regexp="^[0]{1}")
	private double charges;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date dueDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date premiumPaidDate;

	public PremiumDto(Long memberId, @NotNull Long policyId, @NotNull @Length(min = 10, max = 30) String policyName,
			@NotNull @Pattern(regexp = "^[1-5]{1}[0]{3}", message = "length must be 4") double premiumDueAmount,
			@Pattern(regexp = "^[0]{1}") double charges, @NotNull(message = "Please provide a date.") Date dueDate,
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
		return "PremiumDto [memberId=" + memberId + ", policyId=" + policyId + ", policyName=" + policyName
				+ ", premiumDueAmount=" + premiumDueAmount + ", charges=" + charges + ", dueDate=" + dueDate
				+ ", premiumPaidDate=" + premiumPaidDate + "]";
	}		

	
}
