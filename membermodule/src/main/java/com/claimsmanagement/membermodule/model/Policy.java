package com.claimsmanagement.membermodule.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Policy {

	@Id	
	private Long policyId;
	private String policyName;
	private String premiumName;
	private Date premiumduedate;	
	private String topUp;
	private String summary;
		
	
	
	public Policy() {
		super();
	}



	public Policy(Long policyId, String policyName, String premiumName, Date premiumduedate, String topUp,
			String summary) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.premiumName = premiumName;
		this.premiumduedate = premiumduedate;
		this.topUp = topUp;
		this.summary = summary;
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



	public String getPremiumName() {
		return premiumName;
	}



	public void setPremiumName(String premiumName) {
		this.premiumName = premiumName;
	}



	public Date getPremiumduedate() {
		return premiumduedate;
	}



	public void setPremiumduedate(Date premiumduedate) {
		this.premiumduedate = premiumduedate;
	}



	public String getTopUp() {
		return topUp;
	}



	public void setTopUp(String topUp) {
		this.topUp = topUp;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", premiumName=" + premiumName
				+ ", premiumduedate=" + premiumduedate + ", topUp=" + topUp + ", summary=" + summary + "]";
	}	
	
	
	
}
