//package com.journalapp.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.journalapp.entity.User;
//import com.journalapp.service.UserService;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//	@Autowired
//	UserService userService;
//
//	@PostMapping("/create")
//	public ResponseEntity<String> createAdmin(@RequestBody User user) {
//		User createUser = userService.createAdmin(user);
//		if (createUser != null) {
//			return new ResponseEntity<String>("admin created successfully...!", HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@GetMapping("/getAll")
//	public ResponseEntity<List<User>> getAllAdmin() {
//		List<User> findAllUser = userService.findAllUser();
//		if (findAllUser != null) {
//			return new ResponseEntity<List<User>>(findAllUser, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//		}
//	}
//}