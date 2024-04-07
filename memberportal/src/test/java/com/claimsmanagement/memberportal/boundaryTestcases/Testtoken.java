package com.claimsmanagement.memberportal.boundaryTestcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.claimsmanagement.memberportal.model.UserToken;

public class Testtoken {
UserToken token=new UserToken(null, null);
	
	@Test
	void testSetUserid() {
		token.setUserid("123");
		assertEquals("123", token.getUserid());
	}

	@Test
	void testSetauthToken() {
		token.setAuthToken("xyzyd12234");
		assertEquals("xyzyd12234", token.getAuthToken());
	}
	
	@Test
	void testUserToken()
	{
	   UserToken u=new UserToken("1223445","xcdydufhk123");
	}
	
	@Test
	void testToken()
	{
		UserToken uw = new UserToken(null, null);
		
	}

}
