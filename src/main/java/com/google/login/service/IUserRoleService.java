package com.google.login.service;

import java.util.List;
import java.util.Map;

import com.google.login.model.RolesVo;
import com.google.login.model.UsersVo;

public interface IUserRoleService {

	/**
	 * Create User and the Role for a User.
	 * @param user
	 * @return success
	 */
	boolean createUser(UsersVo user);

	/**
	 * Get the unique list of Roles.
	 * @return
	 */
	List<RolesVo> getRoles();
	
	/**
	 * Update the Password for a user.
	 * @param username
	 * @return  updated rowCount
	 */
	int updatePassword(String username,String password);
	
	
	/**
	 * Generate reset token for forgot password link
	 * @param userName
	 * @return
	 */
	Map<String, Object> resetToken(String userName, String host);
	
	Map<String, Object> resetPassword(String userName, String password, String token);
	
	boolean validateResetToken(String userName, String token);
	
	public boolean validateEmail(String email);
	
	public String getValidLoginDomainProp();
}
