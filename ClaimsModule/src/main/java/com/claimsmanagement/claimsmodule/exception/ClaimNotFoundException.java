package com.claimsmanagement.claimsmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Claim Not Found")
public class ClaimNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ClaimNotFoundException(String message)
	{
		super(message);
	}

}

