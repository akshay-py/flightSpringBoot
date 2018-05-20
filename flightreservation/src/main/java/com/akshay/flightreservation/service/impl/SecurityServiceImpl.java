package com.akshay.flightreservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.akshay.flightreservation.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public boolean login(final String username, final String password) {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(token);

		final boolean result = token.isAuthenticated();

		if (result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}

		return result;
	}

}
