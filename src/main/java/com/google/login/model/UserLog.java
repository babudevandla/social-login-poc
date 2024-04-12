package com.google.login.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component("userLog")
public class UserLog {

	private String username;
	private String requestURI;

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserLog [username=" + username + ", requestURI=" + requestURI + "]";
	}

}
