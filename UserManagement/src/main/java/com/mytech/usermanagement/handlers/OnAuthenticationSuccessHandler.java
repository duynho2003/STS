package com.mytech.usermanagement.handlers;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OnAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//Add more logic to check user: -> reset login failure count = 0.
		String name = authentication.getName();
		System.out.println("username: " + name);
		
		Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
		
		for (GrantedAuthority role : roles) {
			System.out.println("Role: " + role.getAuthority());
		}
		
		request.getSession().setAttribute("name", name);
		response.sendRedirect("/login_success");
		
	}

}
