package com.google.login.oauth2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.login.dao.IUserRoleDao;
import com.google.login.oauth2.user.GoogleOAuth2UserInfo;

@Component
public class CustomOAuth2UserService extends DefaultOAuth2UserService{

	@Autowired private IUserRoleDao userRoleDao;
	Logger logger=Logger.getLogger(CustomOAuth2UserService.class.getName());
	@Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
		//System.out.println("::::::::loading the user details");
        logger.info("::::::::loading the user details");
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        
        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }
	
	private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) throws Exception {
		 /*System.out.println("::::::::processOAuth2User the user details - start");*/
		 logger.info("::::::::processOAuth2User the user details - start::::::::::");
        GoogleOAuth2UserInfo oAuth2UserInfo = new GoogleOAuth2UserInfo(oAuth2User.getAttributes());
        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationException(null, "Email not found from OAuth2 provider");
        }
        List<String> userRoles=userRoleDao.getRolesByUserId(oAuth2UserInfo.getEmail());
        Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
        
        if(userRoles!=null && userRoles.size()>0 ) {
        	GrantedAuthority authority = new OAuth2UserAuthority(userRoles.get(0),oAuth2User.getAttributes());
        	mappedAuthorities.add(authority);
        	oAuth2User = new DefaultOAuth2User( mappedAuthorities, oAuth2User.getAttributes(), userNameAttributeName);
        }
       /* else{
        	String remarks="NO ROLE FOUND FOR THE USER";
        	userRoleDao.logUnautherizedUser(oAuth2UserInfo.getEmail(), remarks,null);
        	//throw new Exception();
        }
       */
        //System.out.println("::::::::processOAuth2User the user details - ending");
        logger.info("::::::::processOAuth2User the user details - ending::::::"+oAuth2UserInfo.getEmail());
        return oAuth2User;
    }
	
}
