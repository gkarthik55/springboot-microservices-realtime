package com.tripease.train_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainServiceApplication
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Train Ticket Booking Service");

		SpringApplication.run(TrainServiceApplication.class, args);
	}
}
