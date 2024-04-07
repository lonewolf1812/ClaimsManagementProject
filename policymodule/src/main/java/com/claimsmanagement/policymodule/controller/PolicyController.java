package com.claimsmanagement.policymodule.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.claimsmanagement.policymodule.exception.MemberNotFoundException;
import com.claimsmanagement.policymodule.exception.PolicyNotFoundException;
import com.claimsmanagement.policymodule.model.Benifit;
import com.claimsmanagement.policymodule.model.Provider;
import com.claimsmanagement.policymodule.service.PolicyService;

@RestController
public class PolicyController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PolicyController.class);
	
	@Autowired
	private PolicyService policyservice;

	//---------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar
	 * Description: Method for retrieving all the hospital providers
	 * Request URL: @GetMapping("/getChainOfProviders/{policyId}")
	 * @return  List<Provider>
	 */
	
	//getPolicyProviders        Define Http Get for retrieving the hospital providers for a specific policy. 
	@GetMapping("/getChainOfProviders/{policyId}")
	public List<Provider> getPolicyProviders(@PathVariable(name = "policyId") long policyId) throws PolicyNotFoundException {
		
		LOGGER.info("Providers List Returned Successfully");
		return policyservice.getPolicyProviders(policyId);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar
	 * Description: Method for retrieving all the eligible benefits
	 * Request URL: @GetMapping("/getEligibleBenefits/{memberId}/{policyId}")
	 * @return  List<Benifit>
	 */
	
	//getPolicyBenifits        Define Http Get for retrieving the eligible benefits for a specific member, for a specific policy. 
	@GetMapping("/getEligibleBenefits/{memberId}/{policyId}")
	public List<Benifit> getPolicyBenifits(@PathVariable(name = "memberId") long memberId,
			@PathVariable(name = "policyId") long policyId) throws MemberNotFoundException {
		
		LOGGER.info("Eligible Benefits Returned Successfully");
		return policyservice.getPolicyBenifits(memberId,policyId);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar
	 * Description: Method for retrieving the eligible claim amount
	 * Request URL: @GetMapping("/getEligibleClaimAmount/{memberId}/{policyId}/{benefitId}")
	 * @return  Double(amount)
	 */

	//getEligibleClaimAmount   Define Http Get for retrieving the eligible claim amount for a specific member. 
	@GetMapping("/getEligibleClaimAmount/{memberId}/{policyId}/{benefitId}")
	public double getEligibleClaimAmount(@PathVariable(name = "memberId") long memberId,
			@PathVariable(name = "policyId") long policyId, @PathVariable(name = "benefitId") long benefitId)
			throws MemberNotFoundException {
		
		LOGGER.info("Eligible Claim Amount Returned Successfully");
		return policyservice.getEligibleClaimAmount(memberId,policyId,benefitId);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------

}
