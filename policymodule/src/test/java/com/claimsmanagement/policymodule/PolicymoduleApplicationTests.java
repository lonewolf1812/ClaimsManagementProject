package com.claimsmanagement.policymodule;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.claimsmanagement.policymodule.controller.PolicyController;

@ContextConfiguration
@SpringBootTest
class PolicymoduleApplicationTests {
	
	@Autowired
	private PolicyController pc;

	@Test
	void contextLoads() {
		assertNotNull(pc);
	}

}
