package com.claimsmanagement.memberportal.model;


public class UserToken {


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	private String userid;

	private String authToken;

	public UserToken(String userid, String authToken) {
		super();
		this.userid = userid;
		this.authToken = authToken;
	}

	@Override
	public String toString() {
		return "UserToken [userid=" + userid + ", authToken=" + authToken + "]";
	}
	
	
}