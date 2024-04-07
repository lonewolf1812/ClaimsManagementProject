package com.claimsmanagement.policymodule.boundaryTestCases;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.claimsmanagement.policymodule.dto.BenefitDTO;
import com.claimsmanagement.policymodule.dto.MemberDTO;
import com.claimsmanagement.policymodule.dto.PolicyDTO;
import com.claimsmanagement.policymodule.dto.ProviderDTO;
import com.claimsmanagement.policymodule.utilTestClass.MasterData;
import com.claimsmanagement.policymodule.utilTestClass.TestUtils;

@ExtendWith(SpringExtension.class)
class BoundaryTests 
{
		
		@SuppressWarnings("unused")
		private static final long serialVersionUID = -6544854658457780865L;

		private Validator validator;

	    //---------------------------------------------------------------------------------------------
		
	    @BeforeEach
	    public void setUp() {
	    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	        validator = factory.getValidator();
	    }
	    
	    //=============================================================================================
	    //									1. ProviderDTO - Validations
	    //=============================================================================================
	    
	    @Test
	    void testProviderId() throws Exception 
	    {
	    	
	    	ProviderDTO providerdto = MasterData.getProviderDTO();
	    	providerdto.setProviderId(null);
	    	Set<ConstraintViolation<ProviderDTO>> violations = validator.validate(providerdto);
	    	TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	    }
	    
	    //--------------------------------------------------------------------------------------------
	    
	    @Test
	    void testHopsname() throws Exception 
	    {
	    	
	    	ProviderDTO providerdto = MasterData.getProviderDTO();
	    	providerdto.setName("GH");
	    	Set<ConstraintViolation<ProviderDTO>> violations = validator.validate(providerdto);
	    	TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	    }
	    
	    //--------------------------------------------------------------------------------------------
	    
	    //=============================================================================================
		//									2. PolicyDTO - Validations
	    //=============================================================================================
	    
		@Test
		void testPolicyId() throws Exception 
		{

				PolicyDTO policydto = MasterData.getPolicyDTO();
				policydto.setPolicyId((Long) null);
				Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policydto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}

		//--------------------------------------------------------------------------------------------
		
		@Test
		void testName() throws Exception 
		{

				PolicyDTO policydto = MasterData.getPolicyDTO();
				policydto.setName("SE");
				Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policydto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
		@Test
		void testPremium() throws Exception 
		{

				PolicyDTO policydto = MasterData.getPolicyDTO();
				policydto.setPremium(700);
				Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policydto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
		@Test
		void testTenure() throws Exception 
		{

				PolicyDTO policydto = MasterData.getPolicyDTO();
				policydto.setTenure(200);
				Set<ConstraintViolation<PolicyDTO>> violations = validator.validate(policydto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
	    //=============================================================================================
		//									3. MemberDTO - Validations
	    //=============================================================================================

		@Test
		void testMemberId() throws Exception 
		{

				MemberDTO memberdto = MasterData.getMemberDTO();
				memberdto.setMemberId(null);
				Set<ConstraintViolation<MemberDTO>> violations = validator.validate(memberdto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
		@Test
		void testCapamount() throws Exception 
		{

				MemberDTO memberdto = MasterData.getMemberDTO();
				memberdto.setCapAmount(0.0000);
				Set<ConstraintViolation<MemberDTO>> violations = validator.validate(memberdto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
		@Test
		void testDate() throws Exception 
		{

				MemberDTO memberdto = MasterData.getMemberDTO();
				memberdto.setSubscriptiondate(new Date(20-12-1999));
				Set<ConstraintViolation<MemberDTO>> violations = validator.validate(memberdto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
		//=============================================================================================
		//									4. BenefitDTO - Validations
        //=============================================================================================
		
		@Test
		void testBenefitId() throws Exception 
		{

				BenefitDTO benefitdto = MasterData.getBenefitDTO();
				benefitdto.setBenifitId(null);
				Set<ConstraintViolation<BenefitDTO>> violations = validator.validate(benefitdto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
		@Test
		void testDesc() throws Exception 
		{

				BenefitDTO benefitdto = MasterData.getBenefitDTO();
				benefitdto.setDesc("not bad");
				Set<ConstraintViolation<BenefitDTO>> violations = validator.validate(benefitdto);
				TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		//--------------------------------------------------------------------------------------------
		
}

