package com.claimsmanagement.membermodule.boundaryTestCases;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.claimsmanagement.membermodule.Utils.MasterData;
import com.claimsmanagement.membermodule.Utils.TestUtils;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.claimsmanagement.membermodule.model.Premium;

@RunWith(SpringRunner.class)
public class TestEntityValidation {
 
	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		}
	
	//--- Test 1 --------------------------------------------------------------------------------------
	@Test
	public void testPremiumSuccess() throws Exception {
		
		Premium dto = MasterData.getPremiumDetails();
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 2 --------------------------------------------------------------------------------------
	@Test
	public void testPremiumMemberId() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setMemberId((long)1234);
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 3 --------------------------------------------------------------------------------------
	@Test
	public void testPremiumPolicyId() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setPolicyId((long)101);
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 4 --------------------------------------------------------------------------------------
	@Test
	public void testPolicyName() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setPolicyName("MyClaims Health Insurance");
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 5 --------------------------------------------------------------------------------------
	@Test
	public void testPremiumDueAmount() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setPremiumDueAmount(10000);
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 6 --------------------------------------------------------------------------------------
	@Test
	public void testCharges() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setCharges(0);
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 7 --------------------------------------------------------------------------------------
	@Test
	public void testDueDate() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setDueDate(new Date(2021-07-31));
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
	
	//--- Test 8 --------------------------------------------------------------------------------------
	@Test
	public void testPremiumPaidDate() throws Exception {

		Premium dto = MasterData.getPremiumDetails();
		dto.setPremiumPaidDate(new Date(2020-07-31));
		Set<ConstraintViolation<Premium>> violations = validator.validate(dto);
		TestUtils.technocratsAssert(TestUtils.currentTest(), violations.isEmpty()? true : false, TestUtils.boundaryTestFile);
	}
}