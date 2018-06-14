package com.apps.AppStore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BasicAuthenticationEntryPoint entryPoint;

	@Autowired
	private AccessDeniedHandler handler;

	@Autowired
	private UserDetailsService userDetailsService;

	/*@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.csrf().disable()
         .authorizeRequests()
         .antMatchers("/user/count").permitAll()
         .antMatchers("/user/**").authenticated()
         .and()
         .httpBasic().authenticationEntryPoint(entryPoint)
         .and()
         .exceptionHandling().accessDeniedHandler(handler);
	}*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(entryPoint);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("santhosh").password("santhosh").roles("USER");
	}
}