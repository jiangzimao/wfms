package org.jqiaofu.wfms.web.config;

import org.jqiaofu.wfms.web.security.AccessDecisionManager;
import org.jqiaofu.wfms.web.security.FilterSecurityInterceptor;
import org.jqiaofu.wfms.web.security.InvocationSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler loginSuccessHandler;
	@Autowired
	private AccessDecisionManager accessDecisionManager;
	@Autowired
	private InvocationSecurityMetadataSource invocationSecurityMetadataSource;
	@Autowired
	private FilterSecurityInterceptor securityFilter;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder)
			throws Exception {
		authManagerBuilder.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder(-1));
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/resources/**")
		   .and().debug(false);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		securityFilter.setAccessDecisionManager(accessDecisionManager);
		securityFilter.setSecurityMetadataSource(invocationSecurityMetadataSource);
		
		http.csrf().disable().headers().frameOptions().disable()
		.and().authorizeRequests()
		.anyRequest().authenticated()
		.and().formLogin()
			  .loginPage("/auth/login")
			  .usernameParameter("username")
			  .passwordParameter("password")
			  .loginProcessingUrl("/auth/dologin")
			  .failureUrl("/auth/login?status=false")
			  .successHandler(loginSuccessHandler).permitAll()
		.and().logout()
			  .logoutUrl("/auth/logout")
			  .logoutSuccessUrl("/auth/login")
			  .invalidateHttpSession(true).permitAll()
		.and().addFilterBefore(securityFilter, org.springframework.security.web.access.intercept.FilterSecurityInterceptor.class)
			  .httpBasic();
	}

}
