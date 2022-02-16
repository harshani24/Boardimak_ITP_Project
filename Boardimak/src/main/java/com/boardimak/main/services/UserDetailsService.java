package com.boardimak.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boardimak.main.UserPrincipal;
import com.boardimak.main.model.User;
import com.boardimak.main.repository.UserDetailsRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDetailsRepository.findByUserName(username);
		
		if (user == null )
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(user);
	}
}
