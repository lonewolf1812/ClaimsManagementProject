package com.claimsmanagement.membermodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Invalid MemberId or PolicyId")
public class MemberOrPolicyNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public MemberOrPolicyNotFoundException(String message) {
		super(message);
	}

}



