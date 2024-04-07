package com.claimsmanagement.policymodule.model;

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
@Table(name = "policy")
public class Policy {

	@Id
	@Column(name = "policy_id", columnDefinition = "BIGINT")
	private long policyId;

	@Column(name = "policy_name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "policy_benifits", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "benifit_id"))
	private Set<Benifit> benifits;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "policy_providers", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "provider_id"))
	private Set<Provider> policyProviders;

	private int premium;
	private int tenure;
	
	//---------------------------------------------------------------------------------------------------------------------------------
	
	public Policy() {
		super();
	}

	public Policy(long policyId, String name, Set<Benifit> benifits, Set<Provider> policyProviders, int premium, int tenure) {
		super();
		this.policyId = policyId;
		this.name = name;
		this.benifits = benifits;
		this.policyProviders = policyProviders;
		this.premium = premium;
		this.tenure = tenure;
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

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
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

	public Set<Benifit> getBenifits() {
		return benifits;
	}

	public void setBenifits(Set<Benifit> benifits) {
		this.benifits = benifits;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	public Set<Provider> getPolicyProviders() {
		return policyProviders;
	}

	public void setPolicyProviders(Set<Provider> policyProviders) {
		this.policyProviders = policyProviders;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

}
