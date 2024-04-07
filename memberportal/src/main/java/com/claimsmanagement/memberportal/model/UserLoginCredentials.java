package com.claimsmanagement.memberportal.model;

import org.springframework.stereotype.Component;

@Component
public class UserLoginCredentials {

	public UserLoginCredentials(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}

	private String userid;

	private String password;
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserLoginCredentials [userid=" + userid + ", password=" + password + "]";
	}

	public UserLoginCredentials() {
		super();
	}
}

