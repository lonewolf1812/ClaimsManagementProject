package com.claimsmanagement.claimsmodule.functionaltestcases;

import com.claimsmanagement.claimsmodule.Utils.TestUtils.*;
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
import com.claimsmanagement.claimsmodule.Utils.MasterData2;
import com.claimsmanagement.claimsmodule.Utils.TestUtils;
import com.claimsmanagement.claimsmodule.controller.Claimscontroller;
import com.claimsmanagement.claimsmodule.service.*;
import com.claimsmanagement.claimsmodule.dto.*;
import com.claimsmanagement.claimsmodule.model.Claim;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(Claimscontroller.class)
public class TestClaimController {
	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private Claimdetailservice claimservice;
	
	@Test
	public void testGetClaimStatusbasedonId() throws Exception {
		when(claimservice.getClaimStatus((long)1,(long)1,(long)1)).thenReturn(MasterData2.getClaimdetails());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getClaimStatus/1/1/1")
				.content(MasterData2.asJsonString(MasterData2.getClaimdetails()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		TestUtils.technocratsAssert(TestUtils.currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value()? "true" : "false"), TestUtils.businessTestFile);
		
	}
	
}
