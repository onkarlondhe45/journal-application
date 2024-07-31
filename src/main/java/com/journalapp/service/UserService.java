package com.journalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.journalapp.entity.User;
import com.journalapp.exception.ResourceNotFoundException;
import com.journalapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	public User findById(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}

//	public User findByName(String name) {
//		User userName = userRepository.findByName(name);
//		return userName;
//	}

	public User updateUser(User user, int id) {
		User updatedUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		updatedUser.setName(user.getName());
		updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
		updatedUser.setEmail(user.getEmail());
		updatedUser.setRoles(user.getRoles());
		return userRepository.save(updatedUser);
	}

	public void deleteUser(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);

	}
}
