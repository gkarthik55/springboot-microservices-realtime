package com.tripease.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripease.user_service.entity.User;
import com.tripease.user_service.service.UserService;

@RestController
public class UserController
{
	private final UserService userservice;
	
	@Autowired
	UserController(UserService userservice)
	{
		this.userservice = userservice;
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMessage()
	{
		String msg = "Welcome to User Service";
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{userId}",
				produces = {"application/json"})
	public ResponseEntity<User> getUserDetailsById(@PathVariable String userId)
	{
		User user = userservice.getUserById(userId);
		
		if(user == null)
		{
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		else 
		{
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/user", 
			  consumes = {"application/json"},
			  produces = {"text/plain"})
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		userservice.addUser(user);
		
		return new ResponseEntity<String>("User is saved successfully.", HttpStatus.CREATED);
	}
	
	@PutMapping( value = "/user", 
			  consumes = {"application/json"},
			  produces = {"text/plain"})
	public ResponseEntity<String> updateUser(@RequestBody User user)
	{
		userservice.updateUser(user);
		
		return new ResponseEntity<String>("User is updated successfully.", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/users/{userId}")
	public ResponseEntity<String> deleteUserDetailsById(@PathVariable String userId)
	{
		userservice.deleteUserById(userId);
		
		return new ResponseEntity<String>("User is deleted.", HttpStatus.OK);
	}
	
}
