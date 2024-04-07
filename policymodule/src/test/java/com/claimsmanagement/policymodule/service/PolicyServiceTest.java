package com.claimsmanagement.policymodule.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.claimsmanagement.policymodule.model.Provider;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

//@RunWith(Parameterized.class)
//class PolicyServiceTest {

//	private PolicyService policyservice;
//	
//	@Parameterized.Parameters
//	public static List<Object> getPolicyProvidersTest(long policyId) {
//		//ArrayList<Provider> resultlist = new ArrayList<>();
//
//    // Appending new elements at
//    // the end of the list
//		return Arrays.asList(new Object[][] {{5,"hosp5"},{1,"hosp1"},{2,"hosp2"}});
//		
//	}
//	@Test
//	public 
//		assertEquals(resultlist,policyservice.getPolicyProviders(5));
//
//}
