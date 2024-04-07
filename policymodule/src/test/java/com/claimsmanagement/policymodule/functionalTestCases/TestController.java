package com.claimsmanagement.policymodule.functionalTestCases;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.claimsmanagement.policymodule.controller.PolicyController;
import com.claimsmanagement.policymodule.service.PolicyService;
import com.claimsmanagement.policymodule.utilTestClass.MasterData2;
import com.claimsmanagement.policymodule.utilTestClass.TestUtils;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(PolicyController.class)

public class TestController {

		@Autowired
		private MockMvc mockMvc;
		 
		@MockBean
		private PolicyService policyservice;
		
		@Test
		public void testgetPolicyProviders() throws Exception {
			when(policyservice.getPolicyProviders((long)2)).thenReturn(MasterData2.getProvider());
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPolicyProviders/1")
					.contentType(MasterData2.asJsonString(MasterData2.getProvider()))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
					
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			TestUtils.technocratsAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);
			
		}
		
		@Test
		public void testgetEligiblebenefits() throws Exception {
			when(policyservice.getPolicyBenifits((long)1,(long)2)).thenReturn(MasterData2.getBenefit());
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPolicyBenifits/1/2")
					.contentType(MasterData2.asJsonString(MasterData2.getBenefit()))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
					
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			TestUtils.technocratsAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);
			
		}
		
		@Test
		public void testgetEligibleclaimamount() throws Exception {
			when(policyservice.getEligibleClaimAmount((long)1,(long)2,(long)2)).thenReturn(MasterData2.getMember());
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getEligibleClaimAmount/1/2/2")
					.contentType(MasterData2.asJsonString(MasterData2.getBenefit()))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
					
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			TestUtils.technocratsAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);
			
		}
}
