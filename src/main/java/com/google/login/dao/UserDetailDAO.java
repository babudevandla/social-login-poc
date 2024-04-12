package com.google.login.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.login.model.UserTowFactAuth;

public interface UserDetailDAO {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	//public User getUserDetails(String username) throws UsernameNotFoundException;
	public UserTowFactAuth getUserDetails(String username) throws UsernameNotFoundException;	
	public Integer updateSecretCode(UserTowFactAuth user);
	public Integer EnableTwoFa(UserTowFactAuth user);
	public Integer insertUserDetails(UserTowFactAuth user);
}
