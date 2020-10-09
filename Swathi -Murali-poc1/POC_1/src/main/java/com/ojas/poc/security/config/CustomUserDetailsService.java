package com.ojas.poc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ojas.poc.model.User;
import com.ojas.poc.repositories.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("user name : " + username);
		User user = userRepo.findByUsername(username);
		CustomUserDetails userDetails = null;
		if (user != null) {

			userDetails = new CustomUserDetails();
			userDetails.setUser(user);

		} else {
			throw new UsernameNotFoundException("User not exists with name" + username);
		}
		return userDetails;
	}

}
