package com.claimsmanagement.membermodule;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.claimsmanagement.membermodule.controller.*;

@AutoConfigureMockMvc
@SpringBootTest
class MemberoduleApplicationTests {
	

		@Autowired
	    private MemberController memberPremiumController;
	 
		@Autowired
	    private MockMvc mvc;
		
		@Test
		void contextLoads() {
			assertNotNull(memberPremiumController);
		}

		@Test
	    void testgetBills() throws Exception {
	        ResultActions actions = mvc.perform(get("/viewBills/1/101"));
	        actions.andExpect(status().isOk());
	        
	        actions.andExpect(jsonPath("$.memberId").exists());
	        actions.andExpect(jsonPath("$.memberId").value(1));
	        
	        actions.andExpect(jsonPath("$.policyId").exists());
	        actions.andExpect(jsonPath("$.policyId").value(101));

	    }	  
	  
		@Test
		void testGetBillsException() throws Exception{
			ResultActions actions=mvc.perform(get("/viewBills/124/10111"));
			actions.andExpect(status().is(404));
			actions.andExpect(status().reason("Invalid MemberId or PolicyId"));
		}

}
