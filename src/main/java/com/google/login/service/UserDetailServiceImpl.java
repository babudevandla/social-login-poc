package com.google.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.login.dao.UserDetailDAO;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	@Autowired
	UserDetailDAO userDetailDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("UserDetailServiceImpl::loadUserByUsername::username::"+username);
		return userDetailDAO.loadUserByUsername(username);
	}

}
