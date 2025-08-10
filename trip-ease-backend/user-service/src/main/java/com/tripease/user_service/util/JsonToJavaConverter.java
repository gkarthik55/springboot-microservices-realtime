package com.tripease.user_service.util;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripease.user_service.entity.User;

public class JsonToJavaConverter
{
	public User UserJsonToJava(String fileName)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		try
		{
			return mapper.readValue(new File(fileName), User.class);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
}
