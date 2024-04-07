package com.claimsmanagement.membermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberTest {

	Member member=new Member();
 
	@Test
	void setMemberIdTest() {
		member.setMemberId((long) 1);
		assertEquals(1,member.getMemberId());		
	}


	@Test
	void setNameTest() {
		member.setName("Petor");
		assertEquals("Petor",member.getName());		
	}
	

	@Test
	void setAgeTest() {
		member.setAge(35);
		assertEquals(35,member.getAge());
	}

	@Test
	void setPhoneNumberTest() {
		member.setPhoneNumber("9876543210");
		assertEquals("9876543210",member.getPhoneNumber());
	}

}
