package com.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// configure users(in memory, databse, etc)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//adding users for authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("John").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("Mary").password("test123").roles("MANAGER"))
			.withUser(users.username("Su").password("test123").roles("ADMIN"));
	}
	
	//configure security of web paths in application, login, logout etc
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() //restrict access basen od the HttpServletRequest
			.anyRequest()		 //
			.authenticated()	 //any request to the app must be authenticated(must log in)
			.and()
			.formLogin()     	 //form customization 
			.loginPage("/showLoginPage")    //show custom form
			.loginProcessingUrl("/authenticateUser") //login form should POST data to this URL for processing (check id and password)
			.permitAll();		 //allow everyone to see login page. No need to be logged in
	}

}
