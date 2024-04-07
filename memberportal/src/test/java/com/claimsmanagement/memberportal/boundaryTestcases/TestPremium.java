package com.claimsmanagement.memberportal.boundaryTestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.claimsmanagement.memberportal.model.*;

public class TestPremium {
	Premium premium = new Premium();

	@Test
	void setMemberIdTest() {
		premium.setMemberId((long) 1);
		assertEquals(1, premium.getMemberId());
	}

	@Test
	void setPolicyIdTest() {
		premium.setPolicyId((long) 101);
		assertEquals(101, premium.getPolicyId());
	}

	@Test
	void setPolicyNameTest() {
		premium.setPolicyName("Myclaims Health Insurance Policy");
		assertEquals("Myclaims Health Insurance Policy", premium.getPolicyName());
	}

	@Test
	void setPremiumDueAmountTest() {
		premium.setPremiumDueAmount(5000.0);
		assertEquals(5000.0, premium.getPremiumDueAmount());
	}

	@Test
	 void setChargesTest() {
		premium.setCharges(0.0);
		assertEquals(0.0, premium.getCharges());
	}

	
	 @Test
	 void setDueDateTest() { 
		Date date=new Date(2021-07-31);
	  	premium.setDueDate(date);
	  	assertEquals(date,premium.getDueDate()); 
	 }
	  
	 @Test 
	 void setPremiumPaidDateTest() {
		 Date date=new Date(2020-07-31);
		 premium.setPremiumPaidDate(date);
		 assertEquals(date,premium.getPremiumPaidDate()); 
	 }
}
