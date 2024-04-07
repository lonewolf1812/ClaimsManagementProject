package com.claimsmanagement.policymodule.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {
	
	@NotNull
	private Long memberId;
	
	@NotNull
	@Size(min = 3, max = 30)
	private String name;
	
	@NotNull
	private double capAmount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date subscriptiondate;
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public double getCapAmount() {
		return capAmount;
	}

	public void setCapAmount(double capAmount) {
		this.capAmount = capAmount;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public Date getSubscriptiondate() {
		return subscriptiondate;
	}

	public void setSubscriptiondate(Date subscriptiondate) {
		this.subscriptiondate = subscriptiondate;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public MemberDTO(@NotNull Long memberId, @NotNull @Size(min = 3, max = 30) String name, @NotNull double capAmount,
			@NotNull(message = "Please provide a date.") Date subscriptiondate) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.capAmount = capAmount;
		this.subscriptiondate = subscriptiondate;
	}

	public MemberDTO() {
		super();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	
	
	
}
