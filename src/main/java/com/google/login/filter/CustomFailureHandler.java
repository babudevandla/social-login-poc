package com.google.login.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class CustomFailureHandler implements AuthenticationFailureHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		 try{
			  redirectStrategy.sendRedirect(request, response, "/login");
		 }catch(Exception e){
			 redirectStrategy.sendRedirect(request, response, "/login");
		 }
	}

}
