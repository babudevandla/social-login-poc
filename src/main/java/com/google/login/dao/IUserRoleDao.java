package com.google.login.dao;

import java.util.Date;
import java.util.List;

import com.google.login.model.RolesVo;
import com.google.login.model.UsersVo;

public interface IUserRoleDao {

	/**
	 * Create new User.
	 * @param user
	 * @return true
	 */
	boolean createUser(UsersVo user);

	/**
	 * Get unique roles.
	 * @return
	 */
	List<RolesVo> getRoles();
	
	List<String> getRolesByUserId(String userId);
	

	/**
	 * Check if User is present with existing username.
	 * @param user
	 * @return true if present else false
	 */
	boolean checkUserExist(UsersVo user);

	/**
	 * Update the password of a User.
	 * 
	 * @param user
	 * @return updated rowCount
	 */
	int updatePassword(String username,String password);

	int updateUserToken(String token, String userName);
	
	Date getResetTokenDate(String userName, String token);

	void logUnautherizedUser(String email, String remarks, String ip);
}
