package com.google.login.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.login.filter.CustomAccessDeniedHandler;
import com.google.login.filter.CustomAuthenticationSuccessHandler;
import com.google.login.filter.CustomFailureHandler;
import com.google.login.oauth2.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@Profile({"dev"})
@EnableGlobalMethodSecurity(prePostEnabled  = true)
public class Oauth2SecurityConfig extends WebSecurityConfigurerAdapter{

	 @Autowired
	 private CustomOAuth2UserService customOAuth2UserService;
	 private static List<String> clients = Arrays.asList("google");
	 Logger logger=Logger.getLogger(Oauth2SecurityConfig.class.getName());
	 @Autowired Oauth2Properties oauth2Properties;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Loading GOOGLE login security config::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		http.oauth2Login()
		.loginPage("/login")
		.successHandler(myAuthenticationSuccessHandler())
		.failureHandler(getAuthFailureHandeler())
		.userInfoEndpoint()
			.userService(customOAuth2UserService)
			.and()
		.clientRegistrationRepository(clientRegistrationRepository())
	    .authorizedClientService(authorizedClientService());
		
		http.authorizeRequests().antMatchers("/").permitAll();
		
		onlyAdminUserAccessUrl(http);

		onlyDevUserAccessUrl(http);
		
		http.authorizeRequests().antMatchers("/admin/**").authenticated()
		.and().logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/login")
		.and()
		.exceptionHandling().accessDeniedPage("/acessdenied");
		
		http.csrf().disable();
	}
	
	
	private void onlyAdminUserAccessUrl(HttpSecurity http)  throws Exception {
		http.authorizeRequests().antMatchers(
				"/admin/thema/upload**", 
				"/admin/isbnthema/upload**", 
				"/admin/isbnthema/bisacupload**",
				"/admin/thema/bookmapping**",
				"/admin/thema/export**",
				"/admin/thema/viewCustomThemaCodes**",
				"/admin/product/book-popularitys**",
				"/admin/product/authorpopularity**",
				"/admin/title/statistics**",
				"/admin/status/bulkInactivate**",
				"/admin/order/**"
				)
		.hasAnyRole("DEV","ADMIN");
	}
	
	private void onlyDevUserAccessUrl(HttpSecurity http) throws Exception  {
		
		http.authorizeRequests().antMatchers(
				"/admin/userrole/**",
				"/admin/monitoring/**", 
				"/monitoring/**"
				)
		.hasAnyRole("DEV");
		
	}
	

	 private AuthenticationFailureHandler getAuthFailureHandeler() {
		return new CustomFailureHandler();
	}


	@Bean
	 public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new CustomAuthenticationSuccessHandler();
	 }
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
	    return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		List<ClientRegistration> registrations = clients.stream().map(c -> getRegistration(c)).filter(reg -> reg!=null).collect(Collectors.toList());
		return new InMemoryClientRegistrationRepository(registrations);
	}
	
	private ClientRegistration getRegistration(String client) {
	  
	    if (client.equals("google")) {

	    	return CommonOAuth2Provider.GOOGLE.getBuilder(client)
	          .clientId(oauth2Properties.getGoogleClientId()).clientSecret(oauth2Properties.getGoogleClientSecret()).scope(oauth2Properties.getGoogleScope()).build();
	    	
	    }
	    
	    return null;
	}
	
	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
	    return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}
}
