package com.tripease.user_service.util;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripease.user_service.entity.User;

public class JavaToJsonConverter
{
	public void UserJavaToJson(User user)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		try
		{
			mapper.writeValue(new File("user.json"), user);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
