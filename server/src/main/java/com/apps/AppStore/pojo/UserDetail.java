package com.apps.AppStore.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDetail {	
	@Id
	private String UserID;
	private String username;
	private String password;
	private UserType userType;		
	private String admin;
	

	public UserDetail( String username, String password) {
		super();
		//UserID = userID;
		this.username = username;
		this.password = password;
		//this.admin = admin;
	}
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUserID() {
		return UserID;
	}



	public void setUserID(String userID) {
		UserID = userID;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserType getUserType() {
		return userType;
	}



	public void setUserType(UserType userType) {
		this.userType = userType;
	}



	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", username=" + username + ",admin=" + admin + ", password=" + password + ", userType="
				+ userType + "]";
	}
	
	
	  
	
}
