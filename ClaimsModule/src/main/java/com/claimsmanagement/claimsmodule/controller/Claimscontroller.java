package com.claimsmanagement.claimsmodule.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import com.claimsmanagement.claimsmodule.exception.ClaimNotFoundException;
import com.claimsmanagement.claimsmodule.model.*;
import com.claimsmanagement.claimsmodule.service.*;


import javax.validation.Valid;
import javax.ws.rs.Produces;

@RestController
public class Claimscontroller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Claimscontroller.class);

    @Autowired
   private RestTemplate resttemplate;
	
	@Autowired
	private Claimdetailservice service;
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for retrieving all the Claim details
	 * Request URL: @GetMapping("/getAllClaims")
	 * @return  List<Claim>
	 */
	// getAllClaims          Define HTTP GET method for fetching all the Claim details
	@GetMapping("/getAllClaims")
	public ResponseEntity<List<Claim>> getAllClaims() throws ClaimNotFoundException
	{
//		if(service.isSessionValid(token))
//		{
		LOGGER.info("Getting all the Claim details");
		return new ResponseEntity<List<Claim>>(service.getAllClaims(),HttpStatus.OK);
		//}
		//return new ResponseEntity<List<Claim>>(HttpStatus.FORBIDDEN);
		
	}
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for retrieving the Claim details based on claimId,policyId,memberId
	 * Request URL: @GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	 * @return  Claim
	 */
	// getClaimStatus        Define HTTP GET method for fetching the Claim details based on ClaimId,PolicyId,MemberId
	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ResponseEntity<Claim> getClaimStatus(@PathVariable Long claimId,@PathVariable Long policyId,@PathVariable Long memberId) throws ClaimNotFoundException
	{
		   //if(service.isSessionValid(token)) {
		     LOGGER.info("Getting the Claim details based on claimId, policyId, memeberId");
		     return new ResponseEntity<Claim>(service.getClaimStatus(claimId, policyId, memberId), HttpStatus.OK);
		   //}
		   
		//	      return new ResponseEntity<Claim>(HttpStatus.FORBIDDEN);
	}
	
	//for testing
	@GetMapping("/getClaimStatus1/{claimId}/{policyId}/{memberId}")
	public Claim getClaimStatus1(@PathVariable Long claimId,@PathVariable Long policyId,@PathVariable Long memberId) throws ClaimNotFoundException
	{
		   
		     LOGGER.info("Getting the Claim details based on claimId, policyId, memeberId");
		     return service.getClaimStatus(claimId, policyId, memberId);
		 
	}
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for retrieving the Claim details based on claimId
	 * Request URL: @GetMapping("/getClaimStatus/{claimId}")
	 * @return  Claim
	 */
	// getClaimStatus1        Define HTTP GET method for fetching the Claim details based on ClaimId
	@GetMapping("/getClaimStatus1/{claimId}")
	public Claim getClaimStatus1(@PathVariable Long claimId) throws ClaimNotFoundException
	{
		try {
		LOGGER.info("Getting the Claim details based on claimId");
		return service.getClaimStatusbasedonClaimId(claimId);
		}
		catch (Exception e)
		{
			throw new ClaimNotFoundException("Claim Not Found for the given ClaimId");
		}
	}
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for retrieving the Claim details based on policyId
	 * Request URL: @GetMapping("/getClaimStatus/{policyId}")
	 * @return  Claim
	 */
	// getClaimStatus2        Define HTTP GET method for fetching the Claim details based on PolicyId
	@GetMapping("/getClaimStatus2/{policyId}")
	public Claim getClaimStatus2(@PathVariable Long policyId) throws ClaimNotFoundException
	{
		try {
		LOGGER.info("Getting the Claim details based on policyId");
		return service.getClaimStatusbasedonPolicyId(policyId);
		}
		catch (Exception e)
		{
			throw new ClaimNotFoundException("Claim Not Found for the given PolicyId");
		}
	}
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for retrieving the Claim details based on memberId
	 * Request URL: @GetMapping("/getClaimStatus3/{memberId}")
	 * @return  Claim
	 */
	// getClaimStatus3       Define HTTP GET method for fetching the Claim details based on MemberId
	@GetMapping("/getClaimStatus3/{memberId}")
	public ResponseEntity<Claim> getClaimStatus3(@RequestHeader("Authorization") String token,@PathVariable Long memberId) throws ClaimNotFoundException
	{
		try {
			if(service.isSessionValid(token))
			{
		       LOGGER.info("Getting the Claim details based on policyId");
		       return new ResponseEntity<Claim>(service.getClaimStatusbasedonMemberId(memberId), HttpStatus.OK);
			}
			else
			{
				LOGGER.info("Claim is forbidden");
				return new ResponseEntity<Claim>(HttpStatus.FORBIDDEN);
			}
		}
		catch (Exception e)
		{
			throw new ClaimNotFoundException("Claim Not Found for the given MemberId");
		}
	}
	
	/**
	 * Dated: 23/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for Storing the Claim details 
	 * Request URL: @PostMapping("/submitClaim")
	 * @return  Claim
	 */
	// storeClaimStatus      Define HTTP POST method for storing the Claim details
	
	@PostMapping("/submitClaim")
	public Claim storeClaimStatus(@RequestBody Claim claim)
	{
//		if(service.isSessionValid(token))
//		{
			System.out.println(claim);
		LOGGER.info("Storing the Claim details");
		Claim c=service.submitClaim(claim);
		return  c;
		// return new ResponseEntity<Claim>(service.submitClaim(claim), HttpStatus.OK);
//		}
//		return new ResponseEntity<Claim>(HttpStatus.FORBIDDEN);
	}	
	
	/**
	 * Dated: 29/06/2021
	 * Author: Sudarshan Senthilkumar Senthilkumar
	 * Description: Method for updating the Claim status 
	 * Request URL: @PostMapping("/updateClaim")
	 * @return Claim
	 * @throws ClaimNotFoundException 
	 */
	//updating the claim status  Define HTTP PUT method for updating the claim status 
	//needs to be tested
	@PutMapping("/updateClaim/{claimId}/{memberId}/{policyId}/{benefitId}")
	public Claim updateClaimStatus(@PathVariable Long claimId,@PathVariable Long memberId,@PathVariable Long policyId,@PathVariable Long benefitId) throws ClaimNotFoundException
	{
	
         Benefit benefitt;
		 Claim claimed =null;
		 Boolean t1=true;
		 Boolean t2=false;
//		
   		claimed = service.getClaimStatus(claimId, policyId, memberId);
//			 HttpHeaders httpHeaders=new HttpHeaders();
//			 httpHeaders.add("Authorization", token);
//			 HttpEntity<?> httpEntity=new HttpEntity<>(httpHeaders);
//			 @SuppressWarnings("unused")
//			 ResponseEntity<Benefit> benefitt= resttemplate.exchange("http://policyservice/getBenefitId/"+benefitId,HttpMethod.GET,httpEntity,Benefit.class);
        	benefitt=resttemplate.getForObject("http://policyservice/getBenefitId/"+benefitId,Benefit.class); 
     		LOGGER.debug("benefit returned: []",benefitt);
			
          //Retrieving the Chain of providers from policy module
		   Provider[] provider=resttemplate.getForObject("http://policyservice/getChainOfProviders/"+policyId,Provider[].class);
         List<Provider> provider1=Arrays.asList(provider);
		// List<Provider> provider1=(List<Provider>) provider.getBody();
         LOGGER.debug("providers returned: []",provider1);
         
         //Retrieving the Eligible Benefits from policy module
         Benefit[] benefit=resttemplate.getForObject("http://policyservice/getEligibleBenefits/"+memberId+"/"+policyId,Benefit[].class);
		 List<Benefit> benefit1=Arrays.asList(benefit);
       //  List<Benefit> benefit1= (List<Benefit>) benefit.getBody();
		 LOGGER.debug("Eligible benefits: []",benefit1);
		
		 //work needs to be done
		 Double aMT=resttemplate.getForObject("http://policyservice/getEligibleClaimAmount/"+memberId+"/"+policyId+"/"+benefitt.getBenefitId(),double.class);
		// double amt=aMT.getBody();
		 
		 boolean flag=false;
		 for(Provider p:provider1)
		 {
			 if(p.getName().equals(claimed.getHospitalName()))
			 {
				 flag=true;
				 break;
			 }
			 else
			 {
				 flag=false;
			 }
		 }
		 
		 boolean bool=false;
		 for(Benefit b:benefit1)
		 {
			 if(b.getDescription().equals(claimed.getClaimedbenefit()))
			 {
				 bool=true;
				 break;
			 }
			 else
			 {
				 bool=false;
			 }
		 }
		 
		 
			if(aMT==(double)claimed.getClaimedamount() && flag==t1 && bool==t1)
			{
				claimed.setClaimstatus("Pending Action");
			}
			else if(aMT==0 && flag==t2 && bool==t2)
			{
				claimed.setClaimstatus("Insufficient Claim Details");
			}
			else {
				claimed.setClaimstatus("Claim Rejected");
			}
			LOGGER.info("Claim is updated");
	         return service.updateClaimStatus(claimed);
		}
}
