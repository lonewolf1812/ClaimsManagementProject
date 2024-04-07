package com.claimsmanagement.claimsmodule.functionaltestcases;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.claimsmanagement.claimsmodule.controller.Claimscontroller;
import com.claimsmanagement.claimsmodule.model.Claim;
import com.claimsmanagement.claimsmodule.model.Provider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Claimscontroller.class)
public class TestClaimsController {
	
	
	TestRestTemplate template=new TestRestTemplate();
	
	HttpHeaders headers=new HttpHeaders();
	
	@Test
	public void testChainOfproviders()
	{
		
		Provider response = template.getForObject("http://localhost:8081/getChainOfProviders/1",Provider.class);
		List<Provider> provider1=Arrays.asList(response);

         List <Provider> provider = new ArrayList<>();
         Provider p=new Provider((long) 1,"Apollo");
         provider.add(p);
         Provider q=new Provider((long)2,"Lotus");
         provider.add(q);
         Provider r=new Provider((long)3,"vasan");
         provider.add(r);
         
        assertEquals(provider.toString(),provider1);
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