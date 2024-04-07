package com.claimsmanagement.policymodule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimsmanagement.policymodule.exception.MemberNotFoundException;
import com.claimsmanagement.policymodule.exception.PolicyNotFoundException;
import com.claimsmanagement.policymodule.model.Benifit;
import com.claimsmanagement.policymodule.model.Member;
import com.claimsmanagement.policymodule.model.Policy;
import com.claimsmanagement.policymodule.model.Provider;
import com.claimsmanagement.policymodule.repository.*;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepo policyRepo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private BenifitRepo benifitRepo;
	
	//----------------------------------------------------------------------------
	
	/**
	 * Dated: 24/06/2021
	 * Author: Sudarshan Senthilkumar
	 * Description: Method for retrieving all the hospital providers
	 * Request URL: @GetMapping("/getChainOfProviders/{policyId}")
	 * @return  List<Provider>
	 */

	public List<Provider> getPolicyProviders(long policyId) throws PolicyNotFoundException{
		
		Optional<Policy> result = policyRepo.findById(policyId);

		if (result.isPresent()) {
			Policy policy = result.get();
			Set<Provider> providersSet = policy.getPolicyProviders();
			List<Provider> providers = new ArrayList<>();
			providers.addAll(providersSet);
			return providers;
		}
		else
			throw new PolicyNotFoundException("No policy found");
	}
	
	//----------------------------------------------------------------------------

	/**
	 * Dated: 24/06/2021
	 * Author: Sudarshan Senthilkumar
	 * Description: Method for retrieving all the eligible benefits
	 * Request URL: @GetMapping("/getEligibleBenefits/{memberId}/{policyId}")
	 * @return  List<Benifit>
	 */
	
	public List<Benifit> getPolicyBenifits(long memberId, long policyId) throws MemberNotFoundException {
		
		Optional<Member> result = memberRepo.findById(memberId);
		if(result.isPresent())
		{
			Optional<Policy> result1 = policyRepo.findById(policyId);

				if (result1.isPresent()) {
					Policy policy = result1.get();
					Set<Benifit> benefitsSet = policy.getBenifits();

					List<Benifit> benifits = new ArrayList<>();
					benifits.addAll(benefitsSet);

					return benifits;
				}
		}
		throw new MemberNotFoundException("Member not found");
	}

	//----------------------------------------------------------------------------
	
	/**
	 * Dated: 24/06/2021
	 * Author: Sudarshan Senthilkumar
	 * Description: Method for retrieving the eligible claim amount
	 * Request URL: @GetMapping("/getEligibleClaimAmount/{memberId}/{policyId}/{benefitId}")
	 * @return  Double(amount)
	 */
	
	public double getEligibleClaimAmount(long memberId, long policyId, long benefitId) throws MemberNotFoundException {
		
		Optional<Member> result = benifitRepo.findById(benefitId);
		if (result.isPresent()) 
		{
		
			Optional<Policy> result1 = policyRepo.findById(policyId);
			if (result1.isPresent()) 
			{
		
				Optional<Member> result2 = memberRepo.findById(memberId);
				if (result2.isPresent()) 
				{
					Member member = result2.get();
					return member.getCapAmount();
				}
			}
		}
		throw new MemberNotFoundException("No member found");
	}
	//----------------------------------------------------------------------------

}
