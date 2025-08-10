package com.tripease.user_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tripease.user_service.entity.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	// findByXXX method - Only we can perform Select Statement and not Insert, Update or Delete.
	User getByPhone(Long phone);
	
	// Custom Queries
	@Query(value = "select * from user_details where usertype='Premium'", nativeQuery = true)
	List<User> getAllPremiumUsers();
	
	@Query(value = "delete from user_details where userid = :userId", nativeQuery = true)
	@Modifying
	@Transactional
	// Since we are performing non-select query, we need to use the above 2 annotations.
	void deleteUser(String userId);
}
