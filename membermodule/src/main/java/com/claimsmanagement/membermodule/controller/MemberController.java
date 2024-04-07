package com.claimsmanagement.membermodule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.claimsmanagement.membermodule.exception.MemberOrPolicyNotFoundException;
import com.claimsmanagement.membermodule.model.Claim;
import com.claimsmanagement.membermodule.model.Premium;
import com.claimsmanagement.membermodule.service.MemberService;


@RestController
public class MemberController {

	private static final Logger LOGGER=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders header;
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar S	
	 * Description: Method for retrieving the premium bills of a specific policy.
	 * Request URL: @GetMapping("/viewBills/{memberId}/{policyId}")
	 * @return  Premium
	 */
	@GetMapping("/viewBills/{memberId}/{policyId}")
	public ResponseEntity<Premium> getBills(@PathVariable Long memberId ,@PathVariable Long policyId) throws MemberOrPolicyNotFoundException
	{

		  LOGGER.info("PremiumBills Returned Successfully");		
		  return new ResponseEntity<Premium>(memberService.getPremiumBills(memberId, policyId),HttpStatus.OK);	
 
	}		
	
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar S
	 * Description: Method for retrieving the Claim details based on claimId,policyId,memberId.
	 * Request URL: @GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	 * @return  Claim
	 */
	
	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public Claim getClaimStatus(@PathVariable Long claimId, @PathVariable String policyId, @PathVariable String memberId) 
	{
		Claim c=restTemplate.getForObject("http://claimservice/getClaimStatus/"+claimId+"/"+policyId+"/"+memberId,Claim.class);
		LOGGER.info("Getting the Claim details based on claimId, policyId, memeberId");
		return c;
	}

	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar S
	 * Description: Method for Storing the Claim details.
	 * Request URL: @PostMapping("/submitClaim")
	 * @return  Claim
	 */
	@PostMapping("/submitClaim")
	public Claim storeClaimStatus(@RequestBody Claim claim)
	{
		System.out.println(claim);
		LOGGER.info("Storing the Claim details");
		Claim c=restTemplate.postForObject("http://claimservice/submitClaim",claim,Claim.class);		
		return c;
		
	}
}

