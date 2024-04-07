package com.claimsmanagement.authorization.model;
/**
 * This is a model class which is passed as an argument to generate token in
 * login method of the JwtAuthenticationController class.This class contains
 * fields like UserId and Password.
 *
 */

public class UserLoginCredential {

	private String userid;

	public UserLoginCredential(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}

	public UserLoginCredential() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserLoginCredential[userid=" + userid + ", password=" + password + "]";
	}

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

	private String password;
}
