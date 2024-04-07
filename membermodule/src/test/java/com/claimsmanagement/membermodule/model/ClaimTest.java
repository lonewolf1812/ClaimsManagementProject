package com.claimsmanagement.membermodule.model;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ClaimTest {
	
	
	Claim claim=new Claim((long)1,"Submitted",new Date(1999-05-21),"Verified",(long)101,(long)11,"KMCH","4000 for 2years",5000);
	
	@Test
	void testClaim() {
	
		assertEquals(1,claim.getClaimId());
		assertEquals("Submitted",claim.getClaimstatus());
		assertEquals(new Date(1999-05-21),claim.getClaimeddate());
		assertEquals("Verified", claim.getRemarks());
		assertEquals(101,claim.getPolicyId());
		assertEquals(11,claim.getMemberId());
		assertEquals("KMCH",claim.getHospitalName());
		assertEquals("4000 for 2years",claim.getClaimedbenefit());
		assertEquals(5000,claim.getClaimedamount());
		
	}
	
	
	

}
