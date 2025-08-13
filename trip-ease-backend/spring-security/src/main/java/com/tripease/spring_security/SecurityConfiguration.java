package com.tripease.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration
{
    @SuppressWarnings("removal")
	@Bean
    SecurityFilterChain securityFilter(HttpSecurity httpSecurity) throws Exception
    {
	    httpSecurity
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/", "/welcome", "/login").permitAll()
	            .anyRequest().authenticated()
	        ).formLogin();

	    return httpSecurity.build();
	}
}
