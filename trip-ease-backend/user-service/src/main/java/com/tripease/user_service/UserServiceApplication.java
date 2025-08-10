package com.tripease.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.tripease.user_service.util.JavaToJsonConverter;

//  @SpringBootApplication is the combination of the below 3 annotations:
// 
//	@SpringBootConfiguration
//	@EnableAutoConfiguration
//	@ComponentScan(basePackages = "")

@SpringBootApplication
public class UserServiceApplication
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to User Service");
	
		ConfigurableApplicationContext context = SpringApplication.run(UserServiceApplication.class, args);
		
		System.out.println("Context Details : "+context.getClass().getName());
		
		// UserService service = context.getBean(UserService.class);
		
		// 	   Spring Boot Starter - AnnotationConfigApplicationContext.
		// Spring Boot Web Starter - AnnotationConfigServletWebServerApplicationContext.
		
		//		User user = new User();
		//		user.setUserType("Premium");
		//		List<User> userList = service.getAllUsersByQBE(user);
		//		
		//		for(User u : userList)
		//		{
		//			System.out.println(u);
		//		}
		
		// JavaToJsonConverter Example.
		
		//		User u1 = new User("u113", "Kavya G", "Female", "kavya.g@gmail.com", 9986099860l, "Standard");
		//		JavaToJsonConverter converter = new JavaToJsonConverter();
		//		converter.UserJavaToJson(u1);
		
		// JsonToJavaConverter Example.
		//		JsonToJavaConverter converter = new JsonToJavaConverter();
		//		User u2 = converter.UserJsonToJava("user.json");
		//		System.out.println(u2.toString());
	}
	
	@Bean
	JavaToJsonConverter getInstance()
	{
		return new JavaToJsonConverter();
	}
}