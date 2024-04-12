package com.google.login.oauth2.user;

import java.util.Map;

public class GoogleOAuth2UserInfo {
	protected Map<String, Object> attributes;
	
	public GoogleOAuth2UserInfo(){
		
	}
	public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        
    }
	

    
    public String getId() {
        return (String) attributes.get("sub");
    }

    
    public String getName() {
        return (String) attributes.get("name");
    }

    
    public String getEmail() {
        return (String) attributes.get("email");
    }

    
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}
