package com.tripease.welcome_api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="GREET-API")
// @FeignClient(url="http://localhost:9091/", name="GREET-API")
public interface GreetFiegnClient
{
	@GetMapping("/greet")
	public String invokeGreetApi();
}