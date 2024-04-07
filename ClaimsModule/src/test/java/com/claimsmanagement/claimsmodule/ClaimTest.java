package com.claimsmanagement.claimsmodule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.claimsmanagement.claimsmodule.model.Claim;

public class ClaimTest {
	Claim claim=new Claim();
	@Test
	public void testgetClaimId() {
		claim.setClaimId((long)1);
		assertEquals(1, claim.getClaimId());
	}
	
	@Test
	 void testgetClaimstatus() {
		claim.setClaimstatus("notsettled");
		assertEquals("notsettled", claim.getClaimstatus());
	}
	
	@Test
	 void testgetClaimeddate() {
		claim.setClaimeddate(new java.util.Date(1999-12-23));
		assertEquals(new java.util.Date(1999-12-23), claim.getClaimeddate());
	}
	
	@Test
    void testgetremarks()
	{
		claim.setRemarks("it is verified");
		assertEquals("it is verified",claim.getRemarks());
	}
	
	@Test
	 void testgetpolicyId()
	{
		claim.setPolicyId((long)12345);
		assertEquals((long)12345,claim.getPolicyId());
	}
	
	@Test
	 void testgetmemberId()
	{
		claim.setMemberId((long)12346);
		assertEquals((long)12346,claim.getMemberId());
	}
	
	@Test
	 void testgethospitalName()
	{
		claim.setHospitalName("Apollo");
		assertEquals("Apollo",claim.getHospitalName());
	}
	
	@Test
	 void testgetClaimedbenefit()
	{
		claim.setRemarks("2000 for 4years");
		assertEquals("2000 for 4years",claim.getClaimedbenefit());
	}
	
	@Test
	 void testgetClaimedAmount()
	{
		claim.setClaimedamount(600000);
		assertEquals(600000,claim.getClaimedamount());
	}
	
	@Test
	public void testgetClaim()
	{
		Claim cl=new Claim((long)1,"notsettled",new java.util.Date(1999-12-23),"it is verified",(long)12345,(long)12346,"Apollo","2000 for 4years",600000);
		assertEquals("settled",cl.getClaimstatus());
		assertEquals("it is not verified",cl.getRemarks());
		assertEquals("2000 for 4years",cl.getClaimedbenefit());
		assertEquals(500000,cl.getClaimedamount());
	}

}
