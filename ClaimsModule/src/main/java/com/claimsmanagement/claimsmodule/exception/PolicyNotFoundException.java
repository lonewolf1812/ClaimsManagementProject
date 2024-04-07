package com.claimsmanagement.claimsmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolicyNotFoundException extends Exception {

		public PolicyNotFoundException(String message)
		{
			super(message);
		}
}
