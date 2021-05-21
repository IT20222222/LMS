package com.lms.model;

public class Cancellation {
		
	String username;
	String email;
	int phoneNumber;
	String reason;
	String description;
	
	
	public Cancellation(String username, String email, int phoneNumber , String reason, String description) {
		
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.reason = reason;
		this.description = description;
	}


	public String getUsername() {
		return username;
	}



	public String getEmail() {
		return email;
	}




	public String getReason() {
		return reason;
	}




	public String getDescription() {
		return description;
	}

	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	
}
