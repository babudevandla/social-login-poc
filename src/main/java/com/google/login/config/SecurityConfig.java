package com.google.login.config;

//@Configuration
//@EnableWebSecurity(debug = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .and()
//                .oauth2Login()
//                .authorizationEndpoint()
//                .baseUri("/oauth2/authorize")
//                .authorizationRequestRepository(customAuthorizationRequestRepository());
//    }
//
//    @Bean
//    public AuthorizationRequestRepository customAuthorizationRequestRepository() {
//    	return new HttpSessionOAuth2AuthorizationRequestRepository();
//    }
//}
