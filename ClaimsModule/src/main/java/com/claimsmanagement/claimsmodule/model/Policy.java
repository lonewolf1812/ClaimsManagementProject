package com.claimsmanagement.claimsmodule.model;

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
	private Long policyId;

	@Column(name = "policy_name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "policy_benifits", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "benifit_id"))
	private Set<Benefit> benefits;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "policy_providers", joinColumns = @JoinColumn(name = "policy_id"), inverseJoinColumns = @JoinColumn(name = "provider_id"))
	private Set<Provider> policyProviders;

	private int premium;
	private int tenure;
	
	public Policy() {
		super();
	}

	public Policy(Long policyId, String name, Set<Benefit> benefits, Set<Provider> policyProviders, int premium, int tenure) {
		super();
		this.policyId = policyId;
		this.name = name;
		this.benefits = benefits;
		this.policyProviders = policyProviders;
		this.premium = premium;
		this.tenure = tenure;
	}

	public int getPremium() {
		return premium;
	}
	
	public void setPremium(int premium) {
		this.premium = premium;
	}
	
	public int getTenure() {
		return tenure;
	}
	
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Benefit> getBenifits() {
		return benefits;
	}

	public void setBenifits(Set<Benefit> benefits) {
		this.benefits = benefits;
	}

	public Set<Provider> getPolicyProviders() {
		return policyProviders;
	}

	public void setPolicyProviders(Set<Provider> policyProviders) {
		this.policyProviders = policyProviders;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", name=" + name + ", benefits=" + benefits + ", policyProviders="
				+ policyProviders + ", premium=" + premium + ", tenure=" + tenure + "]";
	}

}
