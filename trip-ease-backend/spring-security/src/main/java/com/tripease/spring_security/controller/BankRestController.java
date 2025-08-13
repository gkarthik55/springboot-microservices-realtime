package com.tripease.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController
{
	@GetMapping("/welcome")
	public String getMessage()
	{
		return "Hello World Message";
	}
	
	@GetMapping("/balance")
	public String getBalance()
	{
		//Logic to check balance
		return "Your Balance is INR 7898";
	}
	
	@GetMapping("/transfer")
	public String amountTransfer()
	{
		//Logic to transfer amount.
		return "Your Amount is transferred successfully.";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "Your login is successfully.";
	}
}
