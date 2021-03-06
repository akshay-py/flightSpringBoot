package com.akshay.flightreservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.akshay.flightreservation.entities.User;
import com.akshay.flightreservation.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final User user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found" + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(), user.getRoles());
	}

}
