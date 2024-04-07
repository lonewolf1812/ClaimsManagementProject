package com.claimsmanagement.policymodule.utilTestClass;

import java.util.Date;

import com.claimsmanagement.policymodule.dto.BenefitDTO;
import com.claimsmanagement.policymodule.dto.MemberDTO;
import com.claimsmanagement.policymodule.dto.PolicyDTO;
import com.claimsmanagement.policymodule.dto.ProviderDTO;

public class MasterData
{
	public static PolicyDTO getPolicyDTO() 
	{
		PolicyDTO policydetails = new PolicyDTO();
		
		policydetails.setPolicyId((long)1001);
		policydetails.setName("BSE");
		policydetails.setPremium(1234);
		policydetails.setTenure(200);

		return policydetails;
	}
	
	public static ProviderDTO getProviderDTO() 
	{
		ProviderDTO providerdetails = new ProviderDTO();
		
		providerdetails.setProviderId((long)1000);
		providerdetails.setName("A");
		
		return providerdetails;
	}
	
	public static MemberDTO getMemberDTO() 
	{
		MemberDTO memberdetails = new MemberDTO();
		
		memberdetails.setMemberId((long)2000);
		memberdetails.setName("SU");
		memberdetails.setCapAmount(200);
		memberdetails.setSubscriptiondate(new Date(1999-12-18));
		
		return memberdetails;
	}
	
	public static BenefitDTO getBenefitDTO() 
	{
		BenefitDTO benefitdetails = new BenefitDTO();
		
		benefitdetails.setBenifitId((long)3000);
		benefitdetails.setDesc("okay");
		
		return benefitdetails;
	}
	
}