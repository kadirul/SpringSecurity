package com.nobin.secureapp;

import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nobin.secureapp.repo.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = repo.findByUsername(username);
		if (users==null) 
			throw new UsernameNotFoundException("User 404");
		
		return new com.nobin.secureapp.UserPrincipal(users);
		
		
	}

}
