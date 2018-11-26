package com.springsecurity.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	// configure users(in memory, databse, etc)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	//configure security of web paths in application, login, logout etc
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() //restrict access based on the HttpServletRequest
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")	
			.antMatchers("/systems/**").hasRole("ADMIN")	
								//.anyRequest()
								//.authenticated() any request to the app must be authenticated(must log in)
			.and()
			.formLogin()     	 //form customization 
			.loginPage("/login")    //show custom form
			.loginProcessingUrl("/authenticateUser") //login form should POST data to this URL for processing (check id and password)
			.permitAll()		 //allow everyone to see login page. No need to be logged in
			.and()
			.logout()			 //logout support for default URL
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}

}
