package com.google.login.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.login.config.NestUserRoles;
import com.google.login.dao.IUserRoleDao;
import com.google.login.util.URLConstants;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired private IUserRoleDao userRoleDao;
	Logger logger=Logger.getLogger(CustomAuthenticationSuccessHandler.class.getName());
	@SuppressWarnings("unchecked")
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		/*System.out.println("From CustomAuthenticationSuccessHandler:::::::::::::::::");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
		grantPreAuthorizeAuthority(roles);
		redirectStrategy.sendRedirect(request, response, URLConstants.VIEW_TWO_FACTOR_ATHENTICATION_PAGE);*/
		//System.out.println("From success handler:::::::"+ ((DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttributes().get("email"));
		String userEmail =((DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttributes().get("email").toString();
		request.getSession().setAttribute("userName", ((DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttributes().get("email"));
		/*System.out.println("from Authentication success handler:::::::::::::::::::: Redirecting to product search page");*/
		/*System.out.println(request.getHeader("HTTP_X_FORWARDED_FOR"));
		System.out.println(request.getRemoteAddr());*/
		boolean isUserExists=isUserExists(authentication, userEmail,request.getRemoteAddr());
		logger.info("from Authentication success handler:::::::::::::::::::: Redirecting to product search page");
		if(isUserExists){
			redirectStrategy.sendRedirect(request, response, URLConstants.PRODUCT_SEARCH);
		}else{
			
			 /*try{
				 Authentication  auth=SecurityContextHolder.getContext().getAuthentication();
				 if(auth==null){
					 redirectStrategy.sendRedirect(request, response, "/nonexisingtuser");
				 }else{
					 DefaultOAuth2User outhUser= ((DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
					 if(outhUser.getAuthorities() ==null ||outhUser.getAuthorities().size()==0){
						 redirectStrategy.sendRedirect(request, response, "/nonexisingtuser");
					 }else{
						 redirectStrategy.sendRedirect(request, response, "/login");
					 }
				 }
			 }catch(Exception e){
				 redirectStrategy.sendRedirect(request, response, "/login");
			 }*/
			
			redirectStrategy.sendRedirect(request, response, "/nonexisingtuser");
		}
			
		
		//redirectStrategy.sendRedirect(request, response, URLConstants.PRODUCT_SEARCH);
			
	}
	private boolean isUserExists(Authentication auth, String email ,String ip) {

		boolean isUserExists =true;
		 if(auth!=null){
		        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>(auth.getAuthorities());
			  
		        List<String> rolesList = new ArrayList<String>();
		        for(GrantedAuthority a :roles){
		        	rolesList.add(a.getAuthority());
		        }
		        List<String> roleEnumList = Stream.of(NestUserRoles.values()).map(Enum::name).collect(Collectors.toList());
		        
		        if(rolesList.size()==1 && rolesList.contains("ROLE_USER")){
		        	String remarks="Non Existing User";
		        	userRoleDao.logUnautherizedUser(email, remarks,ip);
		        	isUserExists=false;
		        }else{
		        	 rolesList.retainAll(roleEnumList);
				        
				       if(rolesList==null || rolesList.size()==0){
				    	    String remarks="No valid role found";
				        	userRoleDao.logUnautherizedUser(email, remarks, ip);
				        	isUserExists=true;
				       }
		        }
		  }
		 
		 return isUserExists;
	}

/*	private void grantPreAuthorizeAuthority(List<GrantedAuthority> actualRoles) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(auth.getAuthorities());
		for (GrantedAuthority arole : actualRoles) {
			authorities.remove(arole);
			authorities.add(new SimpleGrantedAuthority(CONSTANTS.PRE_AUTH_ + arole));
		}
		Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(),
				authorities);
		SecurityContextHolder.getContext().setAuthentication(newAuth);
	}*/
}
