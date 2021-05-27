package com.lms.util;
import java.util.ArrayList;
import java.util.List;

import com.lms.model.*;
public interface UserInterface {
	public boolean addUser(String Firstname , String Lastname , String NIC , String email, String address, String gender , int mobile , String dob , String username , String password , int pid);
	
	public List<User> getProfileData (String  username);
	
	public boolean updateCustomer(String username , String fname , String lname , String Address , int pnumber , String email);
	
	public boolean DeleteUser(int id);
	
	public boolean setCancellationDetails(int mobileNo , String username , String email , String reason , String description );
	
	public ArrayList<Cancellation> getCancellationDetails();
	
	public boolean validateUsername(String username);
	
	public boolean validate(String username, String password);
	
	public User getUser(String userName);
}
