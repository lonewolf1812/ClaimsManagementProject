package com.claimsmanagement.policymodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.claimsmanagement.policymodule.dto.ProviderDTO;

class ProviderTest {

	ProviderDTO provider = new ProviderDTO();
	
	@Test
	void getHospname() {
		provider.setName("hosp1");
		assertEquals("hosp1",provider.getName());
	}
	
	@Test
	void getHospId() {
		provider.setProviderId((long) 1234);
		assertEquals((long) 1234,provider.getProviderId());
	}

}
