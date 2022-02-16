package com.boardimak.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			//Login
			.csrf().disable()
			.formLogin()
			.defaultSuccessUrl("/dashboard", true)
			.loginPage("/login").permitAll()
			.and()
			
			//URL Autherisation user management
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/reset-password").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/users").authenticated()
			.antMatchers("/editUser").authenticated()
			.antMatchers("/saveUser").authenticated()
			.antMatchers("/deleteUser").authenticated()
			.antMatchers("/deleteUser").authenticated()
			.and()
			
			//URL Autherisation support ticket management
			.authorizeRequests()
			.antMatchers("/ticket").authenticated()
			.antMatchers("/create-ticket").authenticated()
			.antMatchers("/save-user").authenticated()
			.antMatchers("/delete-user").authenticated()
			.antMatchers("/edit-user").authenticated()
			.antMatchers("/open-Userticket").authenticated()
			.antMatchers("/ticket-UserReply").authenticated()
			.antMatchers("/show-ticket").authenticated()
			.antMatchers("/delete-ticket").authenticated()
			.antMatchers("/open-ticket").authenticated()
			.antMatchers("/edit-status").authenticated()
			.antMatchers("/edit-status2").authenticated()
			.antMatchers("/replyTicket").authenticated()
			.antMatchers("/replyTicket1").authenticated()
			.antMatchers("/pdfreport").authenticated()
			.and()
			
			// URL Autherisation Payment registration
			.authorizeRequests()
			.antMatchers("/submit/proposal").authenticated()
			.antMatchers("/pay-owner").authenticated()
			.antMatchers("/payment-details").authenticated()
			.antMatchers("/all-payments").authenticated()
			.antMatchers("/sigleProperty").authenticated()
			.and()
			
			//URL Autherisation promotion management
			.authorizeRequests()
			.antMatchers("/show-promotion").authenticated()
			.antMatchers("/new-promotion").authenticated()
			.antMatchers("/add-promotion").authenticated()
			.antMatchers("/delete-promotion").authenticated()
			.antMatchers("/edit-promotion").authenticated()
			.antMatchers("/admin-promotion").authenticated()
			.antMatchers("/show-first").authenticated()
			.antMatchers("/show-real").authenticated()
			.antMatchers("/DeactivatePromotion").authenticated()
			.antMatchers("/ActivatePromotion").authenticated()
			.antMatchers("/open-property").authenticated()
			.and()
			
			//URL Autherisation property management
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/property").permitAll()
			.antMatchers("/owner/").authenticated()
			.antMatchers("/admin/property").authenticated()
			.antMatchers("/owner/property").authenticated()
			.antMatchers("/edit-property").authenticated()
			.antMatchers("/owner/delete-property").authenticated()
			.antMatchers("/admin/delete-property").authenticated()
			.antMatchers("/owner/property/DeactivateProperty").authenticated()
			.antMatchers("/owner/property/ActivateProperty").authenticated()
			.antMatchers("/admin/property/DeactivateProperty").authenticated()
			.antMatchers("/admin/property/ActivateProperty").authenticated()
			.antMatchers("/property/update").authenticated()
			.antMatchers("/owner/edit-property").authenticated()
			.antMatchers("/owner/my-properties").authenticated()
			.antMatchers("/owner/proposal").authenticated()
			.antMatchers("/owner/proposal/delete").authenticated()
			.and()
			
			//Logout
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").permitAll();
	}
}
