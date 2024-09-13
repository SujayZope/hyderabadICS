package com.example.sms.config;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
        // Get the authorities (roles) of the authenticated user
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		// Iterate through each authority
		authorities.forEach(authority -> {
			// Check if the authority corresponds to an admin role
			if (authority.getAuthority().equals("ROLE_ADMIN")) {
				try {
					// Redirect the user to the admin page
					response.sendRedirect("/admin/"); // Redirect to admin page
				} catch (IOException e) {
					e.printStackTrace(); // Handle redirect exception
				}
			} else {
				try {
					// Redirect the user to the student page
					response.sendRedirect("/students/"); // Redirect to student page
				} catch (IOException e) {
					e.printStackTrace(); // Handle redirect exception
				}
			}
		});
	}

}
