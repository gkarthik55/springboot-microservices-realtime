package com.tripease.welcome_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripease.welcome_api.GreetFiegnClient;

@RestController
public class WelcomeRestController
{
	@Autowired
	GreetFiegnClient greetFiegnClient;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage()
	{
		String port = env.getProperty("server.port");
		
		String welcomeMsg = "Welcome to Ashok IT (" + port + ")";
		String greetMsg = greetFiegnClient.invokeGreetApi();
		
		return greetMsg + ", "+welcomeMsg;
	}
}
