package com.claimsmanagement.membermodule.functionalTestCases;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.claimsmanagement.membermodule.model.Claim;
import com.claimsmanagement.membermodule.Utils.MasterData;
import com.claimsmanagement.membermodule.Utils.TestUtils;
import com.claimsmanagement.membermodule.controller.MemberController;
import com.claimsmanagement.membermodule.service.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(MemberController.class)
public class TestMemberController {
	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private MemberService memberpremiumservice;
	
	TestRestTemplate template=new TestRestTemplate();
	
	HttpHeaders headers=new HttpHeaders();
	
	@Test
	public void testgetPremiumBillsbasedonId() throws Exception {
		when(memberpremiumservice.getPremiumBills((long)1,(long)101)).thenReturn(MasterData.getPremiumDetails());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPremiumBills/1/101")
				.content(MasterData.asJsonString(MasterData.getPremiumDetails()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		TestUtils.technocratsAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);
		
	}
	@Test
	public void TestgetClaimStatus() throws URISyntaxException
	{
		final String baseUrl = "http://localhost:8081/getClaimStatus/";
		URI uri = new URI(baseUrl);
		     
		HttpHeaders headers = new HttpHeaders();
		headers.set("claimId", "1");  
		headers.set("policyId", "101");
		headers.set("memberId", "1");  
		 
		HttpEntity<Claim> requestEntity = new HttpEntity<>(null, headers);
		 
		ResponseEntity<String> result = template.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		String actual=result.getHeaders().get(HttpHeaders.LOCATION).get(0);
		
		assertTrue(actual.contains("http://localhost:8081/submitClaim"));
	}
	
	
	@Test
	public void TestsubmitClaim()
	{
		Claim c=new Claim((long)6, "Claim Rejected", new Date(1999-12-25), "It is verified", (long) 4,
				(long) 2, "Global", "2000 for 2years", (long)2500);
	        
		    
		HttpEntity<Claim> entity=new HttpEntity<Claim>(c,headers);
		ResponseEntity<String> response= template.exchange("http://localhost:8081/submitClaim",HttpMethod.POST,entity,String.class);
		
		String actual=response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		
		assertTrue(actual.contains("http://localhost:8081/submitClaim"));
	}
}