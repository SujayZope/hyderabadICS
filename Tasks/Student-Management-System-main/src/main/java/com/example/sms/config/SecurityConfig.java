package com.example.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Bean
	public UserDetailsService getUserDetailsService() {
		// Define and return a bean for the custom implementation of UserDetailsService
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		// Define and return a bean for BCryptPasswordEncoder for password encoding
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuthProvider() {
		// Configure DaoAuthenticationProvider
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		// Set the user details service and password encoder
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

		return daoAuthenticationProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Start configuring access rules for different URL patterns
		http.authorizeHttpRequests()
				// Restrict access to URLs starting with "/admin" to users with role "ADMIN"
				.requestMatchers("/admin/**").hasRole("ADMIN")
				// Restrict access to URLs starting with "/students" to users with role "STUDENT"
				.requestMatchers("/students/**").hasRole("STUDENT")
				// Allow access to all other URLs without any role requirement
				.requestMatchers("/**").permitAll()
				// Configure form-based authentication
				.and().formLogin()
				// Specify the login page URL
				.loginPage("/signin")
				// Specify the URL where the login form should be submitted
				.loginProcessingUrl("/login")
				// Set a custom success handler after successful login
				.successHandler(customAuthenticationSuccessHandler)
				// Disable CSRF protection
				.and().csrf().disable();

		// Build the configuration and return it as a SecurityFilterChain bean
		return http.build();
	}

}