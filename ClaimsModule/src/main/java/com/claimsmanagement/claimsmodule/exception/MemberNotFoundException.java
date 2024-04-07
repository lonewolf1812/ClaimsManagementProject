package com.claimsmanagement.claimsmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Member Not Found")
public class MemberNotFoundException extends Exception{
	public MemberNotFoundException(String message)
	{
		super(message);
	}
}
