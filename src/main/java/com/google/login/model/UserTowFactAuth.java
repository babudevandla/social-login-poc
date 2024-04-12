package com.google.login.model;

import org.jboss.aerogear.security.otp.api.Base32;

public class UserTowFactAuth {
	private String username;
	private boolean twofaenabled;	
	private String secret;
	
	public UserTowFactAuth() {
        this.secret = Base32.random();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isTwofaenabled() {
		return twofaenabled;
	}

	public void setTwofaenabled(boolean twofaenabled) {
		this.twofaenabled = twofaenabled;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	
}
