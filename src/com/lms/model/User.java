package com.lms.model;

public class User {
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
    
	
    

}