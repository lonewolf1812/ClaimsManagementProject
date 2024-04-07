package com.claimsmanagement.memberportal.boundaryTestcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.claimsmanagement.memberportal.model.UserLoginCredentials;

public class TestUser {
UserLoginCredentials user=new UserLoginCredentials();
	
	@Test
	void testSetUserid() {
		user.setUserid("user1");
		assertEquals("user1", user.getUserid());
	}

	@Test
	void testSetpassword() {
		user.setPassword("pwd");
		assertEquals("pwd", user.getPassword());
	}
	
	@Test
	void testUserDataStringStringStringString() {
	  UserLoginCredentials user_of =new UserLoginCredentials("234","pass123"); 
	}
	
	@Test
	void testUserData() {
		UserLoginCredentials u=new UserLoginCredentials();
	}

}
