package com.google.login.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.google.login.util.CONSTANTS;
import com.google.login.util.URLConstants;

public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	 @Override
	    public void handle(
	      HttpServletRequest request,
	      HttpServletResponse response, 
	      AccessDeniedException exc) throws IOException, ServletException {
	         
	        Authentication auth 
	          = SecurityContextHolder.getContext().getAuthentication();
	      /*  if (auth != null) {
	            LOG.warn("User: " + auth.getName() 
	              + " attempted to access the protected URL: "
	              + request.getRequestURI());
	        }
	 */
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(auth.getAuthorities());
	        if(!Objects.isNull(authorities) || authorities.size()>0){
		        for(GrantedAuthority role:authorities){
		        	if(role.getAuthority().startsWith(CONSTANTS.PRE_AUTH_)){
		        		 response.sendRedirect(request.getContextPath() + URLConstants.VIEW_TWO_FACTOR_ATHENTICATION_PAGE);
		        		 break;
		        	}else{
		        		response.sendRedirect(request.getContextPath() + URLConstants.ACCESS_DENIED);
		        	}
		        }
		        
	        }else{
	        	response.sendRedirect(request.getContextPath() + URLConstants.ACCESS_DENIED);
	        }
	        
	    }
}
