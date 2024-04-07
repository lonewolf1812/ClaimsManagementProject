package com.claimsmanagement.claimsmodule.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "member_id", columnDefinition = "BIGINT")
	private Long memberId;

	@Column(name = "member_name")
	private String name;

	@Column(name = "cap_amount")
	private double capAmount;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "policy_subscribed", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "policy_id"))
	private Set<Policy> policiesSubscribed;

	private Date subscriptiondate;
	
	public Member() {
		super();
	}

	public Date getSubscriptiondate() {
		return subscriptiondate;
	}

	public void setSubscriptiondate(Date subscriptiondate) {
		this.subscriptiondate = subscriptiondate;
	}


	public Member(Long memberId, String name, double capAmount, Set<Policy> policiesSubscribed, Date subscrpitiondate) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.capAmount = capAmount;
		this.policiesSubscribed = policiesSubscribed;
		this.subscriptiondate = subscrpitiondate;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCapAmount() {
		return capAmount;
	}

	public void setCapAmount(double capAmount) {
		this.capAmount = capAmount;
	}

	public Set<Policy> getPoliciesSubscribed() {
		return policiesSubscribed;
	}

	public void setPoliciesSubscribed(Set<Policy> policiesSubscribed) {
		this.policiesSubscribed = policiesSubscribed;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", capAmount=" + capAmount + ", policiesSubscribed="
				+ policiesSubscribed + ", subscriptiondate=" + subscriptiondate + "]";
	}
	
	

}
