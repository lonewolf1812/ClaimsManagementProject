package com.claimsmanagement.policymodule.utilTestClass;

import com.claimsmanagement.policymodule.dto.BenefitDTO;
import com.claimsmanagement.policymodule.dto.MemberDTO;
import com.claimsmanagement.policymodule.dto.PolicyDTO;
import com.claimsmanagement.policymodule.dto.ProviderDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

public class JSONUtils 
{
    public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static PolicyDTO policycheckDTO(Long policyId, String name,int premium, int tenure) 
    {
    	PolicyDTO policydto = new PolicyDTO();

    	policydto.setPolicyId(policyId);
    	policydto.setName(name);
    	policydto.setPremium(premium);
    	policydto.setTenure(tenure);
    	
    	return policydto;
    }
    
    public static ProviderDTO providercheckDTO(Long providerId, String name) 
    {
    	ProviderDTO providerdto = new ProviderDTO();

    	providerdto.setProviderId(providerId);
    	providerdto.setName(name);
    	
    	return providerdto;
    }
    
    public static MemberDTO membercheckDTO(Long memberId, String name, double capamount, Date subscriptiondate) 
    {
    	MemberDTO memberdto = new MemberDTO();

    	memberdto.setMemberId(memberId);
    	memberdto.setName(name);
    	memberdto.setCapAmount(capamount);
    	memberdto.setSubscriptiondate(subscriptiondate);
    	
    	return memberdto;
    }
    
    public static BenefitDTO benefitcheckDTO(Long benefitId, String desc) 
    {
    	BenefitDTO benefitdto = new BenefitDTO();

    	benefitdto.setBenifitId(benefitId);
    	benefitdto.setDesc(desc);
    	
    	return benefitdto;
    }

}