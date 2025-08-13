package com.tripease.welcome_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WelcomeApiApplication
{
	public static void main(String[] args)
	{
		System.out.println("Welcome Service..");
		SpringApplication.run(WelcomeApiApplication.class, args);
	}
}
