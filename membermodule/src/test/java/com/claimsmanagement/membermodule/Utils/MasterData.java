package com.claimsmanagement.membermodule.Utils;

import com.claimsmanagement.membermodule.model.Premium;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;;

public class MasterData {

	public static Premium getPremiumDetails() {

		Premium premiumUser = new Premium();
		premiumUser.setMemberId((long)1);
		premiumUser.setPolicyId((long)101);
		premiumUser.setPolicyName("MyClaims Health Insurance");
		premiumUser.setPremiumDueAmount(10000);
		premiumUser.setCharges(0);
		premiumUser.setDueDate(new Date(2021-07-31));
		premiumUser.setPremiumPaidDate(new Date(2020-07-31));
		
		return premiumUser;
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