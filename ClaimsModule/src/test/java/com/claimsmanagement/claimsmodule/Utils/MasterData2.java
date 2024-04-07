package com.claimsmanagement.claimsmodule.Utils;

import java.sql.Date;

import com.claimsmanagement.claimsmodule.dto.*;
import com.claimsmanagement.claimsmodule.model.Claim;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterData2 
{
  public static Claim getClaimdetails()
  {
	  Claim dto = new Claim();
	  
	  dto.setClaimId((long)(1));
	  dto.setClaimstatus("Claim rejected");
	  dto.setClaimeddate(new Date(1999-23-12));
	  dto.setRemarks("it is verified");
	  dto.setPolicyId((long) 1);
	  dto.setMemberId((long) 1);
	  dto.setHospitalName("Apollo");
	  dto.setClaimedbenefit("2000 for 4years");
	  dto.setClaimedamount(2000);

	  return dto;
    	  
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
