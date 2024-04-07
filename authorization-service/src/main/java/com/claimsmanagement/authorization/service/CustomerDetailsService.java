package com.claimsmanagement.authorization.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.claimsmanagement.authorization.exception.GlobalErrorHandler;
import com.claimsmanagement.authorization.exception.UserNotFoundException;
import com.claimsmanagement.authorization.model.MyUser;
import com.claimsmanagement.authorization.repository.MyUserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is used to load the user details from the database and check
 * whether the user resides in database or not based on the given id. 
 * This class implements the UserDetailsService interface. 
 */
@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private MyUserRepository userdao;
	static Logger log = LoggerFactory.getLogger(CustomerDetailsService.class);
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		log.debug("USERID ", uid);
		MyUser custuser = userdao.findById(uid).orElseThrow(() -> new UserNotFoundException(
				"YOU ARE NOT AN AUTHENTICATED USER. PLEASE TRY TO LOGIN WITH THE VALID CREDENTIALS"));
		log.debug("CUSTUSER {}:", custuser);
		return new User(custuser.getUserid(), custuser.getPassword(), new ArrayList<>());

	}

}
