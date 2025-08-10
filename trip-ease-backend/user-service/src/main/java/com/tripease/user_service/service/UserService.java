package com.tripease.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tripease.user_service.entity.User;
import com.tripease.user_service.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class UserService
{
	@Value("${user.type}")
	String userType;
	
	// ---Field Injection
	// @Autowired
	private final UserRepository userRepo;
	
	// ---Constructor Injection
	// @Autowired 
	public UserService(UserRepository userRepo)
	{
		System.out.println("Constructor of UserService class.");
		this.userRepo = userRepo;
	}
	
	// ---Setter Injection
	// @Autowired
	public void setUserRepository(UserRepository userRepo)
	{
		System.out.println("Setter Method of UserService class.");
		//this.userRepo = userRepo;
	}

	public void addUser(User user)
	{
		try
		{
			userRepo.save(user);
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while saving the user."+e);
		}
		finally
		{
			System.out.println("In finally block.");
		}
	}
	
	public void addAllUsers(List<User> usersList)
	{
		System.out.println("Now trying to save all the Users..");
		
		try
		{
			userRepo.saveAll(usersList);
			System.out.println("All Users information is saved successfully.");
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while saving all the users."+e);
		}
	}
	
	public User getUserById(String userId)
	{
		System.out.println("Fetching User information by Id.");
		
		try
		{
		  Optional<User> user = userRepo.findById(userId);
		  
		  if(!user.isEmpty())
		  {
			  return user.get();
		  }
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while fetching the user."+e);
		}
		return null;
	}
	
	public List<User> getAllUsers()
	{
		System.out.println("Fetching all the user information.");
		
		try
		{
			return userRepo.findAll();
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while fetching all user information."+e);
		}
		return null;
	}
	
	public void updateUser(User user)
	{
		System.out.println("Now trying to update the User..");
		
		try
		{
			userRepo.save(user);
			System.out.println("User is updated successfully.");
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while saving the user."+e);
		}
	}
	
	public void deleteUserById(String userId)
	{
		System.out.println("Now trying to delete user by Id.");
		
		try
		{
			userRepo.deleteById(userId);
			
			System.out.println("User is deleted successfully.");
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while deleting the user."+e);
		}
	}
	
	public User getUserByPhone(long phone)
	{
		System.out.println("Fetching User information by Phone number.");

		try
		{
			return userRepo.getByPhone(phone);
		} 
		catch (Exception e)
		{
			System.out.println("Exception has occured while fetching the user by phone." + e);
		}
		return null;
	}
	
	public List<User> getAllPremiumUsers()
	{
		System.out.println("Fetching all the Premium User information.");
		
		try
		{
			return userRepo.getAllPremiumUsers();
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while fetching all user information."+e);
		}
		return null;
	}
	
	
	// Pagination Feature
	public List<User> getAllUsersByPagination(int pageNo, int pageSize)
	{
		System.out.println("Fetching all the user information by Pagination.");
		
		try
		{
			// Create a Page Request with Page No and Page Size. 
			PageRequest pageReq = PageRequest.of(pageNo-1, pageSize);
			
			Page<User> pageList = userRepo.findAll(pageReq);
			List<User> usersList = pageList.getContent();
			
			return usersList;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while fetching all user information."+e);
		}
		return null;
	}
	
	// Sorting
	// List<User> userList = service.getAllUsersBySorting("userName");
	//
	// Class Member should be mentioned and not the DB column name.
	// Sort.by("");
	public List<User> getAllUsersBySorting(String sortType)
	{
		System.out.println("Fetching all the user information and performing Sort.");
		
		try
		{
			Sort sort = Sort.by(sortType);
			
			List<User> usersList = userRepo.findAll(sort);
			return usersList;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while fetching all user information."+e);
		}
		return null;
	}
	
	// QBE - Query By Example
	
	//	User user = new User();
	//	user.setUserType("Premium");
	//	List<User> userList = service.getAllUsersByQBE(user);
	//
	// Example.of(User);  --- Flipkart Example
	public List<User> getAllUsersByQBE(User user)
	{
		System.out.println("Fetching all the user information by performing QBE.");
		
		try
		{
			Example<User> exampleObj = Example.of(user);
			List<User> usersList = userRepo.findAll(exampleObj);
			
			return usersList;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured while fetching all user information."+e);
		}
		return null;
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("This is init() method of UserService.");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("This is destroy() method of UserService.");
	}
}
