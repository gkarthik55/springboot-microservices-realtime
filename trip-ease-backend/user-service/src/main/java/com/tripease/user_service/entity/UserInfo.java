package com.tripease.user_service.entity;

import org.springframework.hateoas.RepresentationModel;

// Implement the HATEOS Feature for this Class.
public class UserInfo extends RepresentationModel<UserInfo>
{
	String userId;
	String userName;
	String gender;
	String emailId;
	Long phone;
	
	public UserInfo()
	{
	}
	
	public UserInfo(String userId, String userName, String gender, String emailId, Long phone)
	{
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.emailId = emailId;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", emailId=" + emailId
				+ ", phone=" + phone + "]";
	}
}
