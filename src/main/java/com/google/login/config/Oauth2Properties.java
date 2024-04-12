package com.google.login.config;

public class Oauth2Properties {

	private String googleClientId;
	private String googleClientSecret;
	private String googleScope;
	
	public String getGoogleClientId() {
		return googleClientId;
	}
	public void setGoogleClientId(String googleClientId) {
		this.googleClientId = googleClientId;
	}
	public String getGoogleClientSecret() {
		return googleClientSecret;
	}
	public void setGoogleClientSecret(String googleClientSecret) {
		this.googleClientSecret = googleClientSecret;
	}
	public String getGoogleScope() {
		return googleScope;
	}
	public void setGoogleScope(String googleScope) {
		this.googleScope = googleScope;
	}
	
	
}
