package com.claimsmanagement.membermodule.service;

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

import com.claimsmanagement.membermodule.exception.MemberOrPolicyNotFoundException;
import com.claimsmanagement.membermodule.model.Premium;
import com.claimsmanagement.membermodule.repository.MemberPremiumRepo;

@Service
public class MemberService {

	@Autowired	
	private MemberPremiumRepo repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	static Logger log = LoggerFactory.getLogger(MemberService.class);
		
	@Transactional
	public Premium getPremiumBills(Long memberId,Long policyId)throws MemberOrPolicyNotFoundException
	{
		Premium result =repository.findByMemberIdAndPolicyId(memberId,policyId);
		if(result!=null)
		{
			return result;
			
		}
		throw new MemberOrPolicyNotFoundException("Invalid MemberId or PolicyId");
	}
	
	 public boolean isSessionValid(String token) 
	 {
		 log.info("Inside isSessionValid Method");
		 try {
			 HttpHeaders httpHeaders=new HttpHeaders();
			 httpHeaders.add("Authorization", token);
			 HttpEntity<?> httpEntity=new HttpEntity<>(httpHeaders);
			 @SuppressWarnings("unused")
			 ResponseEntity<String> response= restTemplate.exchange("http://authorizationservice/validate",HttpMethod.GET,httpEntity,String.class);
             log.info("Token is valid");
             return true;
		 }catch(Exception e) {
			 log.info("Token is invalid");
			 System.out.println(false);
			 System.out.println(token);
			 return false;
		 }
	 }
	
}