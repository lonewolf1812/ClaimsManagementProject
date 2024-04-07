package com.claimsmanagement.memberportal;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.claimsmanagement.memberportal.controller.*;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class MemberportalApplicationTests {
	
	@Autowired
	private MemberPortalController memberportal;
	
	@Autowired
    private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNull(memberportal);
	}
	
	 @Test
	 void testGetLogin() throws Exception {
	      
	        mvc.perform(MockMvcRequestBuilders
	         .get("/signin"))
	         .andExpect(status().isOk());

	    }
	 
	 @Test
	 void testGetHome() throws Exception {
	      
	        mvc.perform(MockMvcRequestBuilders
	         .get("/home"))
	         .andExpect(status().isOk());

	    }
	 
	  @Test
	  void testGetLogout() throws Exception {
	      
	        mvc.perform(MockMvcRequestBuilders
	         .get("/home/logout"))
	         .andExpect(status().isOk());

	    }
	 

	  @Test
	  void testGetviewBills() throws Exception {
	      
	        mvc.perform(MockMvcRequestBuilders
	         .get("/home/billStatus/viewBills"))
	         .andExpect(status().isOk());

	    }
	  
	  @Test
	  void testGetviewStatus() throws Exception {
	      
	        mvc.perform(MockMvcRequestBuilders
	         .get("/home/claimStatus/claimstatusview"))
	         .andExpect(status().isOk());

	    }
	 
	  @Test
	   public void testmemberPortalControllerBills() throws Exception {
		  mvc.perform(get("/home/billStatus/viewBills"))
          .andExpect(status().is(404))
          .andExpect(view().name("viewBills"))
          .andExpect(forwardedUrl("/WEB-INF/views/home/billStatus/viewBills.jsp"))
          .andExpect(model().attribute("premium", hasItem(
                  allOf(
                          hasProperty("memberId", is(1)),
                          hasProperty("policyId", is(101)),
                          hasProperty("policyName", is("xyz")),
                          hasProperty("premiumDueAmount", is(5000.0)),
                          hasProperty("charges", is(1.0)),
                          hasProperty("dueDate", is(2021-07-21)),
                          hasProperty("premiumPaidDate", is(2021-07-02))
                  )
	  )));
	  }
	  
	  @Test
	   public void testmemberPortalControllerClaimStatus() throws Exception {
		  mvc.perform(get("/home/claimStatus/claimstatusview"))
         .andExpect(status().isOk())
         .andExpect(view().name("claimstatusview"))
         .andExpect(forwardedUrl("/WEB-INF/views/home/claimStatus/claimstatusview.jsp"))
         .andExpect(model().attribute("claims", hasItem(
                 allOf(
                         hasProperty("claimId", is(4)),
                         hasProperty("policyId", is(1)),
                         hasProperty("memberId", is(1)),
                         hasProperty("hospitalName", is("Apollo")),
                         hasProperty("claimeddate", is(1999-12-27)),
                         hasProperty("claimedamount", is(2000)),
                         hasProperty("claimedbenefit", is("3000 for 5years")),
                         hasProperty("claimstatus", is("Pending Action")),
                         hasProperty("remarks", is("it is verified"))
                 )
	  )));
	  }
	      
}
