package com.tripease.spring_security_oauth2.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController
{
	@GetMapping("/")
	public String getMessage()
	{
		return "Welcome to AshokIT";
	}
}
