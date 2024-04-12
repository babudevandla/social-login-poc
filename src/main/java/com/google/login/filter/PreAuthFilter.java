/*package se.frescano.nest.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import se.frescano.nest.bart.admin.constants.CONSTANTS;
import se.frescano.nest.web.util.URLConstants;

public class PreAuthFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		String servletPath = request.getServletPath();
		String allowedUrl = null;
		allowedUrl =servletPath.substring(0, servletPath.substring(1).indexOf("/")+1);
		
		 Authentication  auth=SecurityContextHolder.getContext().getAuthentication();
		  List<GrantedAuthority> roles= (List<GrantedAuthority>) auth.getAuthorities();
		
		if(servletPath.endsWith(URLConstants.VIRIFY_TOTP)){
			chain.doFilter (request, response);
			return ;
		}
		if(!servletPath.equals(URLConstants.AUTH_SUCCESS_RUL)) {
			if(!servletPath.equals(URLConstants.VIEW_TWO_FACTOR_ATHENTICATION_PAGE) && (!servletPath.equals(URLConstants.ENABLE_TWO_FACTOR_AUTHENTICATION))){
			for(GrantedAuthority arole:roles){
				if(arole.getAuthority().startsWith(CONSTANTS.PRE_AUTH_)){
					redirectToTwoFactorAuthenticationPage(request, response);
				}
			}
			}
			chain.doFilter (request, response);
			return ;
		  }
		
	}//doFilter() closing

	  private void redirectToTwoFactorAuthenticationPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  String contextName = request.getRequestURI().substring(1, request.getRequestURI().substring(1).indexOf("/")+1);
		  response.sendRedirect("/"+contextName+URLConstants.VIEW_TWO_FACTOR_ATHENTICATION_PAGE);
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
*/