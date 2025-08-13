package com.tripease.admin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminServerApplication
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Admin Server.");
		
		SpringApplication.run(AdminServerApplication.class, args);
	}

}
