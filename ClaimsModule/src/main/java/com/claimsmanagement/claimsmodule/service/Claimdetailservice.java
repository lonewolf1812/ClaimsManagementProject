package com.claimsmanagement.claimsmodule.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.claimsmanagement.claimsmodule.exception.ClaimNotFoundException;
import com.claimsmanagement.claimsmodule.model.Claim;
import com.claimsmanagement.claimsmodule.respository.*;


@Service
public class Claimdetailservice {
	static Logger log = LoggerFactory.getLogger(Claimdetailservice.class);
	
	@Autowired
	private ClaimStatusRepo repository;
	
	 @Autowired
	   private RestTemplate resttemplate;
	 
	@Transactional
	public List<Claim> getAllClaims()
	{
		return repository.findAll();
	}
	
	@Transactional
	public Claim getClaimStatus(Long claimId, Long policyId,Long memberId) throws ClaimNotFoundException
	{
		Claim claim = repository.findByClaimIdAndPolicyIdAndMemberId(claimId, policyId, memberId);
		if(claim == null)
		{
			throw new ClaimNotFoundException("Claim Not Found");
		}
		return claim;
	}
	
	@Transactional
	public Claim getClaimStatusbasedonClaimId(Long claimId)
	{
		return repository.findByClaimId(claimId);
	}
	

	@Transactional
	public Claim getClaimStatusbasedonPolicyId(Long policyId)
	{
		return repository.findByPolicyId(policyId);
	}
	

	@Transactional
	public Claim getClaimStatusbasedonMemberId(Long memberId)
	{
		return repository.findByMemberId(memberId);
	}
	
	 public Claim submitClaim(Claim claim) {
		 
	        return repository.save(claim);
	    }
	 
	 public Claim updateClaimStatus(Claim claim1)
	 {
		 return repository.save(claim1);
	 }

	 public boolean isSessionValid(String token) 
	 {
		 log.info("Inside isSessionValid Method");
		 try {
			 HttpHeaders httpHeaders=new HttpHeaders();
			 httpHeaders.add("Authorization", token);
			 HttpEntity<?> httpEntity=new HttpEntity<>(httpHeaders);
			 @SuppressWarnings("unused")
			 ResponseEntity<String> response= resttemplate.exchange("http://authorizationservice/validate",HttpMethod.GET,httpEntity,String.class);
             log.info("Token is valid");
             return true;
		 }catch(Exception e) {
			 log.info("Token is invalid");
			 log.info("false");
			 log.info("token :",token);
			 return false;
		 }
	 }
}
