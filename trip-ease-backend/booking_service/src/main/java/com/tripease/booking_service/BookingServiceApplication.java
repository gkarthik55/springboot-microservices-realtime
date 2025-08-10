package com.tripease.booking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tripease.booking_service.service.BookingService;

@SpringBootApplication
public class BookingServiceApplication
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Trip Ease");
		ConfigurableApplicationContext context = SpringApplication.run(BookingServiceApplication.class, args);
		
		BookingService service = context.getBean(BookingService.class);
	}
}
