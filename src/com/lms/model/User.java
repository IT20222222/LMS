package com.lms.model;

import com.lms.util.Generate;

public class User implements Generate {
	private int id;
    private String firstName;
    private String lastName;
    private String NIC;
    private String email;
    private String address;
    private String gender;
    private int mobileNo;
    private String DOB;
    private String username;
    private String password;
    private int planId;
    
    private static int ID = 1000;
    //For users editing their profile
	public User(int id, String firstName, String lastName, String nIC, String email, String address, String gender,
			int mobileNo, String dOB, String username, String password, int planId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		NIC = nIC;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.mobileNo = mobileNo;
		DOB = dOB;
		this.username = username;
		this.password = password;
		this.planId = planId;
	}
	
	
	//For Users who are not registered to a package
	public User(String firstName, String lastName,String email, String address, int mobileNo, String username) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
		this.username = username;
	
	}




	public User() {
	
	}


	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNIC() {
		return NIC;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public String getDOB() {
		return DOB;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getPlanId() {
		return planId;
	}
	
	public void GenerateID() {
		ID++;
		this.id = ID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}


	public void setUsername(String username) {
		this.username = username;
	}
    
	
    

}
