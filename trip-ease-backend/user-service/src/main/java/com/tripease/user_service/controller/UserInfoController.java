package com.tripease.user_service.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripease.user_service.entity.UserInfo;

@RestController
public class UserInfoController
{
	@GetMapping("/userinfo")
	public ResponseEntity<UserInfo> getUser()
	{
		UserInfo user = new UserInfo();
		user.setUserId("101");
		user.setUserName("Karthik G");
		user.setGender("Male");
		user.setEmailId("gkarthik.55@gmail.com");
		user.setPhone(9916099160l);
		
		// HATEOAS Response
		user.add(linkTo(methodOn(UserInfoController.class).getUser()).withSelfRel());
		
		ResponseEntity<UserInfo> response = new ResponseEntity<UserInfo>(user, HttpStatus.OK);
		return response;
	}
}	
