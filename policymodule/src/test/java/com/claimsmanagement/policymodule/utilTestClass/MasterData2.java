package com.claimsmanagement.policymodule.utilTestClass;

import java.util.Date;
import java.util.List;
import com.claimsmanagement.policymodule.model.Benifit;
import com.claimsmanagement.policymodule.model.Member;
import com.claimsmanagement.policymodule.model.Policy;
import com.claimsmanagement.policymodule.model.Provider;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterData2 {
	
	public static Policy getPolicy() 
	{
		Policy policydetails = new Policy();
		
		policydetails.setPolicyId((long)2);
		policydetails.setName("BSE");
		policydetails.setPremium(1234);
		policydetails.setTenure(200);

		return policydetails;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Provider> getProvider() 
	{
		Provider providerdetails = new Provider();
		
		providerdetails.setProviderId((long)1);
		providerdetails.setName("A");
		
		return (List<Provider>) providerdetails;
	}
	
	public static double getMember() 
	{
		Member memberdetails = new Member();
		
		memberdetails.setMemberId((long)1);
		memberdetails.setName("SU");
		memberdetails.setCapAmount(200);
		memberdetails.setSubscriptiondate(new Date(1999-12-18));
		
		return memberdetails.getCapAmount();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Benifit> getBenefit() 
	{
		Benifit benefitdetails = new Benifit();
		
		benefitdetails.setBenifitId((long)2);
		benefitdetails.setDescription("okay");
		
		return (List<Benifit>) benefitdetails;
	}


	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}


}
