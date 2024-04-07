package com.claimsmanagement.memberportal.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.claimsmanagement.memberportal.model.Claim;
import com.claimsmanagement.memberportal.model.JwtResponse;
import com.claimsmanagement.memberportal.model.Premium;

@RestController
public class MemberPortalController {
	
	@Autowired
	private RestTemplate resttemplate;
	
	private static final Logger log = LoggerFactory.getLogger(MemberPortalController.class);
	
	@RequestMapping("/signin")
	public ModelAndView userLogin() {

		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/validate")
	public void check() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token);
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		System.out.println("hi");
		@SuppressWarnings("unused")
		ResponseEntity<JwtResponse> response1 = resttemplate.exchange("http://authorizationservice/validate", HttpMethod.GET,httpEntity, JwtResponse.class);
	}
	
	String token;
	@RequestMapping(value="/generate")
	public ModelAndView userLogin(HttpServletRequest request) {	

		ModelAndView model=new ModelAndView();
		try{
			String token1 = resttemplate.getForObject("http://authorizationservice/login/"+request.getParameter("userid")+"/"+request.getParameter("password"), String.class);
		}catch(Exception e) {
			model.addObject("Message", "Invalid Credentials!"); 
		    model.setViewName("login");
		    return model;
		}
	    
		model.setViewName("home");
	    return model;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView goToHomePage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping(value = "/home/logout")
	public ModelAndView goTologinPage() {
		ModelAndView mv = new ModelAndView("logout");
		return mv;
	}
	
	@RequestMapping("/home/aboutUs")
	public ModelAndView gotoAboutUs() {

		ModelAndView modelAndView = new ModelAndView("aboutUs");
		return modelAndView;
	}

	@RequestMapping("/home/billStatus")
	public ModelAndView gotobillStatus() {

		ModelAndView modelAndView = new ModelAndView("billStatus");
		return modelAndView;
	}
	
	@RequestMapping("/home/billStatus/viewBills")
	public ModelAndView getpremiumBill(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		Premium premium = null;
		
			try {
				premium= resttemplate.getForObject("http://memberservice/viewBills/"+request.getParameter("Member Id")+"/"+request.getParameter("Policy Id"),Premium.class);	
			}
			catch(Exception e){
				model.addObject("Message", "Member or Policy not found"); 
			    model.setViewName("billStatus");
			    return model;
			}
			model.addObject("premium",premium);
			model.setViewName("viewBills");
			return model;
	}

	@RequestMapping("/home/claimStatus")
	public ModelAndView gotoclaimStatus() {

		ModelAndView modelAndView = new ModelAndView("claimStatus");
		return modelAndView;
	}

	@RequestMapping("/home/claimStatus/claimstatusview")
	public ModelAndView getclaim(HttpServletRequest request) {
			 ModelAndView model=new ModelAndView();
			 Claim claims= null; 
			 try{
				 claims = resttemplate.getForObject("http://memberservice/getClaimStatus/"+request.getParameter("Claim Id")+"/"+request.getParameter("Policy Id")+"/"+request.getParameter("Member Id"),Claim.class);	 
			 }
			 catch(Exception e) {
				 model.addObject("Message", "Claim or Member or Policy not found"); 
				 model.setViewName("claimStatus");
				 return model;
			 }
			 model.setViewName("claimstatusview");
			 model.addObject("claims",claims);
			 return model;
	}

	
	
	
	@RequestMapping("/home/newClaim")
	public ModelAndView gotonewClaim() {

		ModelAndView modelAndView = new ModelAndView("newClaim");
		return modelAndView;
	}

	@PostMapping("/home/newClaim/submit")	
	public ModelAndView gotosubmit( HttpServletRequest request) throws ParseException {
		Claim c=new Claim();
		Long policyId = Long.parseLong(request.getParameter("policyId"));
		Long memberId = Long.parseLong(request.getParameter("memberId"));
		String claimstatus = request.getParameter("claimstatus");
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date claimeddate = df.parse(request.getParameter("claimeddate"));
		Long claimedamount = Long.parseLong(request.getParameter("claimedamount"));
		String hospitalName = request.getParameter("hospitalName");
		String claimedbenefit = request.getParameter("claimedbenefit");
		String remarks = request.getParameter("remarks");
		
		c.setPolicyId(policyId);
		c.setMemberId(memberId);
		c.setClaimstatus(claimstatus);
		c.setClaimeddate(claimeddate);
		c.setClaimedamount(claimedamount);
		c.setHospitalName(hospitalName);
		c.setClaimedbenefit(claimedbenefit);
		c.setRemarks(remarks);
		
	  
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<Claim> req=new HttpEntity<Claim>(c,headers);
	    ResponseEntity<Claim> cc = resttemplate.exchange("http://memberservice/submitClaim/",HttpMethod.POST,req,Claim.class);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("Message", "Your ClaimId : "+cc.getBody().getClaimId());
		modelAndView.setViewName("submit");
		return modelAndView;
	}
	
	@RequestMapping("/home/newClaim/sumbit/updateClaim")
	public ModelAndView updateclaim() {

		ModelAndView modelAndView = new ModelAndView("updateClaim");
		return modelAndView;
	}
	
	@RequestMapping("/home/newClaim/sumbit/updateClaim/claimsubmit")
	public ModelAndView submitupdateClaim(HttpServletRequest request) throws ParseException {
		 ModelAndView model=new ModelAndView();
		 try{
			 HttpHeaders headers=new HttpHeaders();
			headers.add("Content-Type", "application/json");
			HttpEntity<String> reqentity=new HttpEntity<String>(headers);
			resttemplate.exchange("http://claimservice/updateClaim/"+request.getParameter("Claim Id")+"/"+request.getParameter("Member Id")+"/"+request.getParameter("Policy Id")+"/"+request.getParameter("Benefit Id"),HttpMethod.PUT,reqentity,Claim.class);	 
		
		 }
		 catch(Exception e) {
			 model.addObject("Message", "Insufficient Claim Details"); 
			 model.setViewName("updateClaim");
			 return model;
		 }
		ModelAndView modelAndView = new ModelAndView("claimsubmit");
		return modelAndView;
	}
	
}
