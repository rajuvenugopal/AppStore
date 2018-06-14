package com.apps.AppStore.pojo;

public class UserType {
	
	private String  guest;
	private String admin;
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserType [guest=" + guest + ", admin=" + admin + "]";
	}
	
	

}
