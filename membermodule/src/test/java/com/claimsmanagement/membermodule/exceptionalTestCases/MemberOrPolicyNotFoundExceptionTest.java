package com.claimsmanagement.membermodule.exceptionalTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.claimsmanagement.membermodule.exception.*;

public class MemberOrPolicyNotFoundExceptionTest {
		
	@Test
   	void testMemberOrPolicyNotFoundException() {
		 MemberOrPolicyNotFoundException memberOrPolicyNotFoundException=new MemberOrPolicyNotFoundException("Invalid MemberId or PolicyId");
		 assertEquals("Invalid MemberId or PolicyId",memberOrPolicyNotFoundException.getMessage());
	}
}
