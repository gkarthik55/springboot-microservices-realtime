package com.tripease.sbms_circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbmsCircuitbreakerApplication
{
	public static void main(String[] args)
	{
        System.out.println("Circuit Breaker Demo Started...");
		SpringApplication.run(SbmsCircuitbreakerApplication.class, args);
	}
}
