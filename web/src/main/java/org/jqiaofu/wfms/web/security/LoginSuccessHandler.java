package org.jqiaofu.wfms.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler , InitializingBean{
	
	private static final Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);

	private boolean forwardToDestination = false;

	private String defaultTargetUrl = "index";

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	public LoginSuccessHandler() {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(StringUtils.isEmpty(defaultTargetUrl))  
            throw new RuntimeException("You must configure defaultTargetUrl"); 
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		if (this.forwardToDestination) {
			log.info("User["+ authentication.getName() +"] Login success,Forwarding to " + this.defaultTargetUrl);

			request.getRequestDispatcher(this.defaultTargetUrl).forward(
					request, response);
		} else {
			log.info("User["+ authentication.getName() +"] Login success,Redirecting to " + this.defaultTargetUrl);

			this.redirectStrategy.sendRedirect(request, response,
					this.defaultTargetUrl);
		}
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}
  
    public void setForwardToDestination(boolean forwardToDestination) {  
        this.forwardToDestination = forwardToDestination;  
    } 

}
