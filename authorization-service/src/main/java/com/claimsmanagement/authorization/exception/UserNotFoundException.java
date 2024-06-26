package com.claimsmanagement.authorization.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * A User defined exception to throw an exception when an user is not found in
 * the database.
 */
@Slf4j
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
	static Logger log = LoggerFactory.getLogger(UserNotFoundException.class);
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
		log.info("START");
		log.debug("message{}:", message);
		log.info("END");
	}

}
