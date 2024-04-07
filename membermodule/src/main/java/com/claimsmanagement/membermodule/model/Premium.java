package com.claimsmanagement.membermodule.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Premium {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  memberId;
	private Long  policyId;
	private String policyName;
	private double premiumDueAmount ;
	private double charges;
	private Date dueDate;
	private Date premiumPaidDate;
	
	
	public Premium() {
		super();
	}


	public Premium(Long memberId, Long policyId, String policyName, double premiumDueAmount, double charges,
			Date dueDate, Date premiumPaidDate) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.policyName = policyName;
		this.premiumDueAmount = premiumDueAmount;
		this.charges = charges;
		this.dueDate = dueDate;
		this.premiumPaidDate = premiumPaidDate;
	}


	@Override
	public String toString() {
		return "Premium [memberId=" + memberId + ", policyId=" + policyId + ", policyName=" + policyName
				+ ", premiumDueAmount=" + premiumDueAmount + ", charges=" + charges + ", dueDate=" + dueDate
				+ ", premiumPaidDate=" + premiumPaidDate + "]";
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



}