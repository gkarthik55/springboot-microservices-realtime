package com.tripease.welcome_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripease.welcome_api.GreetFiegnClient;

@RestController
public class WelcomeRestController
{
	@Autowired
	GreetFiegnClient greetFiegnClient;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage()
	{
		String welcomeMsg = "Welcome to Ashok IT.";
		String greetMsg = greetFiegnClient.invokeGreetApi();
		
		return greetMsg + ", "+welcomeMsg;
	}
}
