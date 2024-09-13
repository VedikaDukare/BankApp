package com.techlabs.demo.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techlabs.demo.entity.User;
import com.techlabs.demo.repo.Users;
import com.techlabs.demo.repo.UsersRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UsersRepository userRepo;
	@Override 
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
	  User user = userRepo.findByUserName(username) 
	    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	 
	  Collection<? extends GrantedAuthority> authorities;
	return null;

	 }

}
