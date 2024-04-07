package com.claimsmanagement.membermodule.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PolicyTest {

	Policy policy = new Policy();

	@Test
	void setPolicyIdTest() {
		policy.setPolicyId((long) 101);
		assertEquals(101, policy.getPolicyId());
	}

	@Test
	void setPolicyNameTest() {
		policy.setPolicyName("Myclaims Health Insurance Policy");
		assertEquals("Myclaims Health Insurance Policy", policy.getPolicyName());
	}

	@Test
	void setPremiumNameTest() {
		policy.setPremiumName("Health Premium");
		assertEquals("Health Premium", policy.getPremiumName());
	}

	 @Test 
	 void setPremiumduedateTest() { 
	 Date date=new Date(2021-07-31);
	 policy.setPremiumduedate(date);
	 assertEquals(date,policy.getPremiumduedate()); 
	 }
	 

	@Test
	void setTopupTest() {
		policy.setTopUp("10000 rs");
		assertEquals("10000 rs", policy.getTopUp());
	}

	@Test
	void setSummaryTest() {
		policy.setSummary("premium amount is 10000 per year.20 years agreement.For health");
		assertEquals("premium amount is 10000 per year.20 years agreement.For health", policy.getSummary());
	}

}
