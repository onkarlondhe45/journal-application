package com.journalapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journalapp.entity.User;
import com.journalapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User createUser = userService.createUser(user);
		if(createUser!=null) {
			return new ResponseEntity<String>("user created successfully...!", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> findAllUser = userService.findAllUser();
		if(findAllUser!=null) {
			return new ResponseEntity<List<User>>(findAllUser, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User findById = userService.findById(id);
		if(findById!=null) {
			return new ResponseEntity<User>(findById, HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name){
		User findByUserName = userService.findByName(name);
		if(findByUserName!=null) {
			return new ResponseEntity<User>(findByUserName, HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id){
		User updateUser = userService.updateUser(user, id);
		if(updateUser!=null) {
			return new ResponseEntity<User>(updateUser, HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted successfully...!", HttpStatus.OK);
	}

}
