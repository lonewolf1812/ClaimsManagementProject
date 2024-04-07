package com.claimsmanagement.claimsmodule.boundarytestcases;

import com.claimsmanagement.claimsmodule.Utils.TestUtils.*;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.claimsmanagement.claimsmodule.Utils.MasterData;
import com.claimsmanagement.claimsmodule.Utils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.claimsmanagement.claimsmodule.dto.ClaimDto;

@RunWith(SpringRunner.class)
public class TestEntityValidation {
 
	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		}
		
		@Test
		public void testClaimPostSuccess() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		@Test
		public void testClaimedDate() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setClaimeddate(new Date(23-12-1999));
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		@Test
		public void testClaimHospitalName() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setHospitalName("");
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		@Test
		public void testClaimedHospitalName() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setHospitalName("Sakra");
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		@Test
		public void testClaimedBenefit() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setHospitalName("");
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		@Test
		public void testClaimBenefit() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setHospitalName("2000 for 4years");
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		
		@Test
		public void testClaimedAmount() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setClaimedamount(0);
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		@Test
		public void testClaimedAmount1() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setClaimedamount(3455);
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		@Test
		public void testClaimPolicyId() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setPolicyId((long)2);
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
		@Test
		public void testClaimPolicyId1() throws Exception {
			
			ClaimDto dto = MasterData.getClaimdetails();
			dto.setPolicyId((long)100);
			Set<ConstraintViolation<ClaimDto>> violations = validator.validate(dto);
			TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
		}
}
