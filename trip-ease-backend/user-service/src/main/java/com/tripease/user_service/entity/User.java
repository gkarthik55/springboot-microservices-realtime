package com.tripease.user_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User
{
	@Id
	@Column(name = "userid")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	String userId;
	
	@Column(name = "username")
	String userName;
	
	@Column(name = "gender")
	String gender;
	
	@Column(name = "emailid")
	String emailId;
	
	@Column(name = "phone")
	Long phone;
	
	@Column(name = "usertype")
	String userType;
	
	public User()
	{
		System.out.println("Constructor of User class.");
	}
	
	public User(String userId, String userName, String gender, String emailId, Long phone, String userType) {
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.emailId = emailId;
		this.phone = phone;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", emailId=" + emailId
				+ ", phone=" + phone + ", userType=" + userType + "]";
	}
}
