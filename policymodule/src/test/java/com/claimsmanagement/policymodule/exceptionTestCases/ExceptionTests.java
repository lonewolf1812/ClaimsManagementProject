package com.claimsmanagement.policymodule.exceptionTestCases;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.claimsmanagement.policymodule.exception.MemberNotFoundException;
import com.claimsmanagement.policymodule.exception.PolicyNotFoundException;

public class ExceptionTests {

	@Test
	public void testMemberNotFoundException1() {
		MemberNotFoundException memberNotFoundException = new MemberNotFoundException("Member not found for the given memberId");
		assertEquals("Member not found for the given memberId",memberNotFoundException.getMessage());
	}
	
	@Test
	public void testPolicyNotFoundException1() {
		PolicyNotFoundException policyNotFoundException = new PolicyNotFoundException("Policy not found for the given policyId");
		assertEquals("Policy not found for the given policyId",policyNotFoundException.getMessage());
	}
	
}
