package com.claimsmanagement.claimsmodule.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="claimdetails")
public class Claim {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long claimId;
	@NotNull
	@NotBlank(message="Claim Status must not be empty")
	private String claimstatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date claimeddate;
	
	@NotNull(message="Remarks should not be empty")
	private String remarks;
	
	@NotNull(message="PolicyId should not be empty")
	private Long policyId;
	
	@NotNull(message="memberd should not be empty")
	private Long memberId;
	
	@NotNull(message="Please provide the Hospital name")
	private String hospitalName;
	
	@NotNull(message="Mention your Benefit")
	private String claimedbenefit;
	
	@NotNull(message="Mention your Claimed Amount")
	private long claimedamount;
	
	public Claim(Long claimId, String claimstatus, Date claimeddate, String remarks, Long policyId,
			Long memberId, String hospitalName, String claimedbenefit, long claimedamount) {
		super();
		this.claimId = claimId;
		this.claimstatus = claimstatus;
		this.claimeddate = claimeddate;
		this.remarks = remarks;
		this.policyId = policyId;
		this.memberId = memberId;
		this.hospitalName = hospitalName;
		this.claimedbenefit = claimedbenefit;
		this.claimedamount = claimedamount;
	}
	
	public Claim()
	{
		
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getClaimstatus() {
		return claimstatus;
	}

	public void setClaimstatus(String claimstatus) {
		this.claimstatus = claimstatus;
	}

	public Date getClaimeddate() {
		return claimeddate;
	}

	public void setClaimeddate(Date claimeddate) {
		this.claimeddate = claimeddate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getClaimedbenefit() {
		return claimedbenefit;
	}

	public void setClaimedbenefit(String claimedbenefit) {
		this.claimedbenefit = claimedbenefit;
	}

	public long getClaimedamount() {
		return claimedamount;
	}

	public void setClaimedamount(long claimedamount) {
		this.claimedamount = claimedamount;
	}

	@Override
	public String toString() {
		return "claimdetails [claimId=" + claimId + ", claimstatus=" + claimstatus + ", claimeddate=" + claimeddate
				+ ", remarks=" + remarks + ", policyId=" + policyId + ", memberId=" + memberId + ", hospitalName="
				+ hospitalName + ", claimedbenefit=" + claimedbenefit + ", claimedamount=" + claimedamount + "]";
	}

	

	
}
