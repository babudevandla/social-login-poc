package com.google.login.service;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.google.login.dao.IUserRoleDao;
import com.google.login.model.RolesVo;
import com.google.login.model.UsersVo;

@Service("userService")
public class UserRoleService implements IUserRoleService {

	@Value("${valid.login.domain}")
	String validLoginDomainProp;
	
	public String getValidLoginDomainProp() {
		return validLoginDomainProp;
	}

	private static String [] validLoginDomain = null;
	
	private String [] getValidLoginDomain() {
		if(validLoginDomain==null)
			validLoginDomain = validLoginDomainProp.split(",");
		
		return validLoginDomain;
	}
	
	public boolean validateEmail(String email) {
		
		boolean status = false;
		
		if(email.contains("@")) {
			String[] domainSplit = email.split("@");
			String providedDomain = domainSplit[1].toLowerCase();
			
			String[] allowedDomains = getValidLoginDomain();
			for (String domain : allowedDomains) {
				if(domain.equals(providedDomain))
					return true;
			}
		}
		
		return status;

	}
	
	@Autowired
	IUserRoleDao userDao;
	@Autowired
	private UserDetailsService userDetailsService;
	
//	@Autowired
//	private SendMailService sendMailService;
	
	@Value("${user.password.token.expire.minutes}")
	String token_expire_min;
	
	@Value("${user.password.mail.body}")
	String forgortPasswordMailBody;
	
	@Autowired
	private Environment env;
	
	@Override
	public boolean createUser(UsersVo user) {
		UserDetails details = userDetailsService.loadUserByUsername(user.getUsername());
		boolean insertflag = false;
		if (details != null) {
			insertflag = false;
		} else {
			insertflag = userDao.createUser(user);
			insertflag = true;
		}
		return insertflag;
	}

	@Override
	public List<RolesVo> getRoles() {
		return userDao.getRoles();
	}

	@Override
	public int updatePassword(String username,String password) {
		return userDao.updatePassword(username,password);
	}
	
	
	public boolean validateResetToken(String userName, String token){
		boolean result = false;
		
		int exp_min = Integer.parseInt(token_expire_min);
		
		Date tokenDate = userDao.getResetTokenDate(userName, token);
		
		if(tokenDate!=null){
			Date currentDate = new Date();
			
			Calendar valideDate = Calendar.getInstance();
			valideDate.setTime(tokenDate);
			valideDate.add(Calendar.MINUTE, exp_min);
			tokenDate = valideDate.getTime();
			
			if(currentDate.before(tokenDate)){
				result = true;
			}
			
		}
		
		return result;
	}
	
	public Map<String, Object> resetPassword(String userName, String password, String token) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "failed");
		result.put("code", 5000);
		
		if(validateResetToken(userName, token)){
			int updated = updatePassword(userName, password);
			
			if(updated>0){
				result.put("msg", "success");
				result.put("code", 2000);
				userDao.updateUserToken(null, userName);
			}
			else{
				result.put("code", 5001);
				result.put("msg", "Failed to update on Database");
			}
			
		}
		else{
			
			result.put("code", 4000);
			result.put("msg", "Invalid Token");
			
		}
		
		return result;
	}
	
	@Override
	public Map<String, Object> resetToken(String userName, String host) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "failed");
		result.put("code", 5000);
		
		if(validateEmail(userName)){
			
			String token = UUID.randomUUID().toString();
			
			int updated = userDao.updateUserToken(token, userName);
			
			if(updated > 0){
				
				result.put("msg", "success");
				result.put("code", 2000);
				
					try{
						String link = host + "/reset/password?t="+token+"&id="+URLEncoder.encode(userName, "UTF-8");
						String mailBody = forgortPasswordMailBody.replace("{link}", link).replace("{exp}", token_expire_min);
						//sendMailService.sendMail("Nest Admin - Password Reset Initiated", userName, mailBody);
					}
					catch(Exception e){
						result.put("code", 5002);
						result.put("msg", e.toString());
					}
					
					
				
			}
			else{
				result.put("code", 5001);
				result.put("msg", "Database token update failed");
			}
		
		}else{
			
			result.put("code", 4000);
			result.put("msg", "Invalid EmailId : "+userName);
			
		}
		
		return result;
	}
}
