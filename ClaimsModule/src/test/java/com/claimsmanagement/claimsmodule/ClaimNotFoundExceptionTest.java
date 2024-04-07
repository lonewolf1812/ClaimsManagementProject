package com.claimsmanagement.claimsmodule;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.claimsmanagement.claimsmodule.exception.ClaimNotFoundException;

public class ClaimNotFoundExceptionTest {
	@Test
	public void testClaimNotFoundException1() {
		ClaimNotFoundException claimNotFoundException=new ClaimNotFoundException("Claim Not Found for the given ClaimId,PolicyId,MemberId");
		assertEquals("Claim Not Found for the given ClaimId,PolicyId,MemberId",claimNotFoundException.getMessage());
}
	@Test
	public void testClaimNotFoundException2() {
		ClaimNotFoundException claimNotFoundException=new ClaimNotFoundException("Claim Not Found for the given ClaimId");
		assertEquals("Claim Not Found for the given ClaimId",claimNotFoundException.getMessage());
}
	@Test
	public void testClaimNotFoundException3() {
		ClaimNotFoundException claimNotFoundException=new ClaimNotFoundException("Claim Not Found for the given PolicyId");
		assertEquals("Claim Not Found for the given PolicyId",claimNotFoundException.getMessage());
}
	@Test
	public void testClaimNotFoundException4() {
		ClaimNotFoundException claimNotFoundException=new ClaimNotFoundException("Claim Not Found for the given MemberId");
		assertEquals("Claim Not Found for the given MemberId",claimNotFoundException.getMessage());
}
	
}
