package com.journalapp.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.journalapp.entity.User;
import com.journalapp.repository.UserRepository;

@Service
public class UserDetailsInfoService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<User> user = userRepository.findByName(username);
		return user.map(UserInfo::new)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	}

}
