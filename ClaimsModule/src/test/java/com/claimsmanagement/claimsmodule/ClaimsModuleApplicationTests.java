package com.claimsmanagement.claimsmodule;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.claimsmanagement.claimsmodule.controller.*;

@AutoConfigureMockMvc
@SpringBootTest
class ClaimsModuleApplicationTests {
	
	 @Autowired
	    private Claimscontroller ClaimsController;
	 
	  @Autowired
	    private MockMvc mvc;
	  
	@Test
	void contextLoads() {
		 assertNotNull(ClaimsController);
	}

	  @Test
	     void testgetClaimStatus_neg() throws Exception {
	        ResultActions actions = mvc.perform(get("/getClaimStatus/1/12345/12346"));
	        actions.andExpect(status().is(404));
	        actions.andExpect(jsonPath("$.claimId").exists());
	        actions.andExpect(jsonPath("$.claimId").value(1));
	        
	        actions.andExpect(jsonPath("$.policyId").exists());
	        actions.andExpect(jsonPath("$.policyId").value(12345));
	        
	        actions.andExpect(jsonPath("$.memberId").exists());
	        actions.andExpect(jsonPath("$.memberId").value(12346));
	    }
	  
	  @Test
	     void testgetClaimStatus_pos() throws Exception {
	        ResultActions actions = mvc.perform(get("/getClaimStatus/4/1/1"));
	        actions.andExpect(status().isOk());
	        actions.andExpect(jsonPath("$.claimId").exists());
	        actions.andExpect(jsonPath("$.claimId").value(4));
	        
	        actions.andExpect(jsonPath("$.policyId").exists());
	        actions.andExpect(jsonPath("$.policyId").value(1));
	        
	        actions.andExpect(jsonPath("$.memberId").exists());
	        actions.andExpect(jsonPath("$.memberId").value(1));
	    }
	  
	  @Test
	  void testgetAllClaims() throws Exception{
		  ResultActions actions = mvc.perform(get("/getAllClaims"));
	        actions.andExpect(status().isOk());
	  }
	  
	  @Test
		void testGetClaimException() throws Exception{
			ResultActions actions=mvc.perform(get("/getClaimStatus/6/4/4"));
			actions.andExpect(status().is(404));
			actions.andExpect(status().reason("Claim Not Found for the given ClaimId,PolicyId,MemberId"));
		}
	  
	  @Test
		void testGetClaimException1() throws Exception{
			ResultActions actions=mvc.perform(get("/getClaimStatus/4/1/1"));
			actions.andExpect(status().is(200));
		}
	  
	  @Test
		void testSubmitClaimException() throws Exception{
			ResultActions actions=mvc.perform(post("/submitClaim"));
			actions.andExpect(status().is(200));
		}
}
