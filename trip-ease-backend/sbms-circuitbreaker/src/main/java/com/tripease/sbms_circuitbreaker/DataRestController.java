package com.tripease.sbms_circuitbreaker;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController
{
    @GetMapping("/data")
    @CircuitBreaker(name = "redisService", fallbackMethod = "getDataFromDB")
    public String getDataFromRedis()
    {
        System.out.println("**Redis() method called**");

        // Simulate random failure
        if (new Random().nextInt(10) < 5)
        {
            throw new RuntimeException("Redis Server Is Down");
        }

        // Main logic
        return "Data accessed from Redis (main logic)";
    }

    // Fallback method - note the Throwable type
    public String getDataFromDB(Throwable t)
    {
        System.out.println("**DB() method called - fallback**");
        return "Data accessed from Database (fallback logic)";
    }
}