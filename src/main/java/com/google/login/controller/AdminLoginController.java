package com.google.login.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.access.prepost.PreAuthorize;
/*import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;*/
//import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.login.model.ActiveUser;
import com.google.login.model.UsersVo;

@Controller
public class AdminLoginController {
	
	Logger logger=Logger.getLogger(AdminLoginController.class.getName());
	
	/*@Autowired
	PreloginService preloginService;
	
	@Autowired
	LdapUserDetailsManager manager;*/
	
	@Autowired  private ClientRegistrationRepository clientRegistrationRepository;
	 Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
	 private static String authorizationRequestBaseUri  = "oauth2/authorization";
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showLoginForm(HttpSession session,Principal principal){		
		logger.info(new Date() + ": AdminLoginController ::: showLoginForm ::: Start ");
		logger.info(new Date() + ": show the login page for the admin URI : / ");
		String url= null;
		if(principal!=null)
			url = "redirect:/admin/product/search";
		else 
			url = "redirect:/login";
		logger.info(new Date() + ": AdminLoginController ::: showLoginForm ::: End ");
		return url;

	}
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "/login";
 
	}
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showLoginForm(){
		ModelAndView mv = new ModelAndView("/login");
		return mv;
	}*/
	
	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public ModelAndView showAccessDenied(){
		ModelAndView mv = new ModelAndView("/access-denied");
		return mv;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session)
			throws Exception {
		if(session.isNew())
		{
			
		}
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/login");	
		return mav;
	}
	
	
	@RequestMapping(value = "/acessdenied", method = RequestMethod.GET)
	public ModelAndView acessDenied(){
		ModelAndView mav = new ModelAndView("/acessdenied");
		return mav;
	}
	
	@RequestMapping(value = "/invalidresetlink", method = RequestMethod.GET)
	public ModelAndView invalidResetLink(){
		ModelAndView mav = new ModelAndView("/invalidresetlink");
		return mav;
	}
	
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showPreLoginForm(){
		ModelAndView mv = new ModelAndView("/login");
		return mv;
	}
	*/
	@RequestMapping(value="/localLogin", method=RequestMethod.GET)
	public ModelAndView showLocalLoginForm(){
		ModelAndView mv = new ModelAndView("/local-login");
		return mv;
	}
	
	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public ModelAndView setupForm(@RequestParam(value= "usernotexists", required=false) boolean usernotexists)
			throws ServletException {
		
		ModelAndView mav = new ModelAndView();
		getClientURLs(mav);
		if(usernotexists){
			mav.addObject("isUserNotExists",true);
		}
		mav.setViewName("/login");
		return mav;
	}
	
	
	@RequestMapping(value = { "/norolesassigned"}, method = RequestMethod.GET)
	public ModelAndView noRolesAssigned(			
			HttpServletRequest req, HttpSession session, Locale local,
			HttpServletResponse response, @ActiveUser UsersVo user)
			throws ServletException {
		/*if (user != null) {
			return new ModelAndView("redirect:/login");
		}*/
		
		ModelAndView mav = new ModelAndView();
		getClientURLs(mav);
		mav.addObject("noRolesFound",true);
		mav.setViewName("/login");
		return mav;
	}
	
	@RequestMapping(value = { "/nonexisingtuser"}, method = RequestMethod.GET)
	public ModelAndView nonExistUser( HttpSession session)
			throws ServletException {
		/*if (user != null) {
			return new ModelAndView("redirect:/login");
		}*/
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/login?usernotexists=true");
		getClientURLs(mav);
		//mav.addObject("isUserNotExists",true);
		//mav.setViewName("/login");
		return mav;
	}
	
	
	
	/*@RequestMapping(value=URLConstants.VIRIFY_TOTP,  method=RequestMethod.POST)
	public ModelAndView viewTwoFactorAuthPage(@ModelAttribute TwoFaUser twoFactorAuth){
		ModelAndView mav =new ModelAndView();
		boolean istotpValid=preloginService.validateTwoFactorAuth(twoFactorAuth);
		if(istotpValid){
			//mav.setViewName("/product/product-search");
			boolean granted =grantAuthority();
			if(granted){
				mav=new ModelAndView("redirect:"+URLConstants.PRODUCT_SEARCH);
			}else{
				mav=new ModelAndView("redirect:"+URLConstants.ACCESS_DENIED);
			}
			
			
		}else{
			//grantAuthority();
			mav=new ModelAndView("redirect:"+URLConstants.VIEW_TWO_FACTOR_ATHENTICATION_PAGE+"?istwofaenabled=true");
		}
		
		return mav;
	}
	
	 private boolean grantAuthority() {
		 boolean granted=false;
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(auth.getAuthorities());
	        if(!authorities.isEmpty()){
	        	granted=true;
	        }
	        List<GrantedAuthority> updatedAuthorities = new ArrayList<GrantedAuthority>();
	        for(GrantedAuthority a :authorities){
	        	if(a.getAuthority().startsWith(CONSTANTS.PRE_AUTH_)){
	        		String originalRole = a.getAuthority().replace(CONSTANTS.PRE_AUTH_, "");
	        		updatedAuthorities.add(new SimpleGrantedAuthority(originalRole));
	        	}else{
	        		updatedAuthorities.add(new SimpleGrantedAuthority(a.getAuthority()));
	        	}
	        }
	        authorities=null;
	        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
	        SecurityContextHolder.getContext().setAuthentication(newAuth);
	        return granted;
	    }
	
	@RequestMapping(value=URLConstants.VIEW_TWO_FACTOR_ATHENTICATION_PAGE, method=RequestMethod.GET)
	public ModelAndView viewtwofapage(@RequestParam(name ="istwofaenabled", required=false) 
																boolean istwofaenabled){
		TwoFaUser twoFactorAuth =new TwoFaUser();
		ModelAndView mav =new ModelAndView();
		Authentication  auth=SecurityContextHolder.getContext().getAuthentication();
		
		twoFactorAuth.setJ_username(auth.getName());
		if(!istwofaenabled){
			preloginService.get2FactoryAuthDetails(twoFactorAuth);
		}else{
			twoFactorAuth.setTwoFaEnabled(true);
			mav.addObject("invalidPasscode", true);
		}
			
			if(twoFactorAuth.isTwoFaEnabled()){
				mav.setViewName("/twofa");
			}else{
				mav.setViewName("/enabletwofa");
			}
			mav.addObject("user", twoFactorAuth);
		
		return mav;
	}
	
	@RequestMapping(value=URLConstants.ENABLE_TWO_FACTOR_AUTHENTICATION, method=RequestMethod.POST)
	public ModelAndView showPreLoginForm(@ModelAttribute TwoFaUser twoFactorAuth){
		ModelAndView mav = new ModelAndView();
		preloginService.verifyTwoFactorAuth(twoFactorAuth);
		if(twoFactorAuth.isTwoFaVerified()){
			//mav.setViewName("/login");
			//mav = new ModelAndView("redirect:/login");
			boolean granted =grantAuthority();
			if(granted){
				mav = new ModelAndView("redirect:"+URLConstants.PRODUCT_SEARCH);
			}else{
				mav=new ModelAndView("redirect:"+URLConstants.ACCESS_DENIED);
			}
			
		}else{
			mav.setViewName("/enabletwofa");
			mav.addObject("isTwoFactorAuthVerificationFails",true);
			mav.addObject("user", twoFactorAuth);
		}
		
		return mav;
	}
	
	@RequestMapping(value=URLConstants.GET_OTP, method=RequestMethod.GET)
	public ModelAndView getTotp(){
		ModelAndView mav = new ModelAndView();
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		preloginService.SendTotpToUser(auth.getName());
		mav.setViewName("/twofa");
		
		TwoFaUser twoFactorAuth =new TwoFaUser();
		twoFactorAuth.setJ_username(auth.getName());
		twoFactorAuth.setTwoFaEnabled(true);
		mav.addObject("mailSent", true);
		mav.addObject("user", twoFactorAuth);
		return mav;
	}
	*/
	
	private void getClientURLs(ModelAndView mav ){
		 Iterable<ClientRegistration> clientRegistrations = null;
		    ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
		      .as(Iterable.class);
		    if (type != ResolvableType.NONE && 
		      ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
		        clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
		    }
		 
		    clientRegistrations.forEach(registration -> 
		      oauth2AuthenticationUrls.put(registration.getClientName(), 
		      authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
		    mav.addObject("urls", oauth2AuthenticationUrls);
	}
	
}