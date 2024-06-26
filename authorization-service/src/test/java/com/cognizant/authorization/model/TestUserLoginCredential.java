package com.cognizant.authorization.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.claimsmanagement.authorization.model.UserLoginCredential;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserLoginCredential {

	@Mock
	public UserLoginCredential userLogin;
	
	@Before
	public void setUp() {
		userLogin=new UserLoginCredential("member","member");
	}
	
	@Test
	public void testAllArgumentConstructor() {
		UserLoginCredential userLog =new UserLoginCredential("member","member");
		assertEquals("member",userLog.getUserid());
	}
	
	@Test
	public void testEquals() {
		boolean res=userLogin.equals(userLogin);
		assertTrue(res);
	}
	
	@Test
	public void testNoArgConstructor() {
		UserLoginCredential ulc=new UserLoginCredential();
		assertEquals(ulc,ulc);
	}
	
	@Test
	public void testToStringMethod() {
		
		assertEquals("UserLoginCredential[userid=" + userLogin.getUserid() + ", password=" + userLogin.getPassword()
				+  "]", userLogin.toString());	
	}
}
