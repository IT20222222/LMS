package com.lms.util;
import com.lms.model.User;
import com.lms.model.*;
import com.lms.model.Cancellation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDBUtil{
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public static final Logger log = Logger.getLogger(OrderDBUtil.class.getName());
	
	public static boolean validate(String username, String password) {
			
			try {
				con = DBConnectorUtil.getConnection();
				stmt = con.createStatement();
				String sql = "select * from user_profile where username='"+username+"' and password='"+password+"'";
				rs = stmt.executeQuery(sql);
				
				if (rs.next()) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
				
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
	
	
	public static boolean validateUsername(String username) {
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user_profile where username='"+username+"' ";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = false;
			} 
			
			else {
				isSuccess = true;
			}
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
		
	public static User getUser(String userName) {
			
			User user = null;
			
			try {
				
				con = DBConnectorUtil.getConnection();	//create connection
				stmt = con.createStatement(); //create a sql statement
				String sql = "select * from user_profile where username='"+userName+"'";	//sql query
				rs = stmt.executeQuery(sql);	//execute sql query
				
				if(rs.next()) {
					//retrieving user details
					String firstName = rs.getString("First_Name");
				    String lastName = rs.getString("Last_Name");
				    String NIC = rs.getString("NIC");
				    String email = rs.getString("Email");
				    String address = rs.getString("Address");
				    String gender = rs.getString("Gender");
				    int mobileNo = rs.getInt("Mobile_Number");
				    String DOB = rs.getString("DOB");
				    String username = rs.getString("username");
				    String password = rs.getString("password");
				    int planId = rs.getInt("Plan_ID");
				    int userId= rs.getInt("User_ID");
					
				    //creating a user object
					user = new User(userId, firstName, lastName, NIC, email, address, gender, mobileNo, DOB, username, password, planId);
				}
				
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			return user;	//return user object
		}
	
	public static boolean addUser(String Firstname , String Lastname , String NIC , String email, String address, String gender , int mobile , String dob , String username , String password , int pid) {
		
		isSuccess = false;
		
		User user2 = new User();
		user2.GenerateID();
		int idno = user2.getId();
		try {	
		con = DBConnectorUtil.getConnection();
		stmt = con.createStatement();
		String sql2 = "INSERT INTO user_profile values ('"+idno+"', '"+Firstname+"' , '"+Lastname+"' , '"+NIC+"' , '"+email+"' , '"+address+"' , '"+gender+"' , '"+mobile+"' , '"+dob+"' , '"+username+"' , '"+password+"' , '"+pid+"' )";
		int rs2 = stmt.executeUpdate(sql2);
		
		
		if(rs2 > 0) {
			isSuccess = true;
		}
		
		else {
			isSuccess = false;
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static  List<User> getProfileData (String  username){
		
		isSuccess = false;
		
		ArrayList<User> user = new ArrayList<User>();
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql3 = "SELECT * FROM user_profile WHERE Username = '"+username+"'";
			rs = stmt.executeQuery(sql3);
			
			int pid = rs.getInt(12);
			
			
			while(rs.next()) {
				
				int uid = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String NIC = rs.getString(4); 
				String email = rs.getString(5);
				String Address = rs.getString(6);
				String gender = rs.getString(7);
				int  mob = rs.getInt(8);
				String dob = rs.getString(9);
				String username1 = rs.getString(10);
				String password = rs.getString(11); 
				
				if(pid > 0) {
			
						User u = new User(uid , fname , lname , NIC , email , Address , gender , mob , dob , username1 , password , pid);
						user.add(u);
				
						}
				else  {
					
						User u2 = new User(uid , fname , lname , NIC , email , Address , gender , mob , dob , username1 , password);
						user.add(u2);
					}
			
				}
			
			
			
			}
		
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	public static boolean updateCustomer(String username , String fname , String lname , String Address , int pnumber , String email) {
		
		isSuccess = false;
		
		try {
			
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql3 = "UPDATE user_profile SET First_Name = '"+fname+"' , Username = '"+username+"' , Last_Name = '"+lname+"' ,Email = '"+email+"' , Address = '"+Address+"' , Mobile_Number = '"+pnumber+"'  WHERE Username = '"+username+"' ";
			int rs = stmt.executeUpdate(sql3);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	
	public static  boolean DeleteUser(int id) {
		
		
		isSuccess = false;
		try {
			
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql4 = "DELETE FROM user_profile WHERE User_ID = '"+id+"' ";
			int rs = stmt.executeUpdate(sql4);
			
			if (rs > 0){
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
			
		}
		
		catch(Exception e ){
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean setCancellationDetails(int mobileNo , String username , String email , String reason , String description ) {
		
		isSuccess = false;
		try {
			
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql5 = "INSERT into account_deletion values ('"+username+"' , '"+email+"' , '"+mobileNo+"' , '"+reason+"' , '"+description+"' )" ;
			int rs = stmt.executeUpdate(sql5);		
			
			if (rs > 0) {
				isSuccess = true;
				}
			
			else {
				isSuccess = false;
				
				}
			
			}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
	}
	
	public static ArrayList<Cancellation> getCancellationDetails(){
		
		
		ArrayList<Cancellation> cancellation = new ArrayList<Cancellation>();
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql6 = "SELECT * FROM account_deletion";
			rs = stmt.executeQuery(sql6);
			
			while (rs.next()) {
				String username = rs.getString(1);
				String email = rs.getString(2);
				int phoneNumber = rs.getInt(3);
				String reason = rs.getString(4);
				String description = rs.getString(5);
				
			
			
			Cancellation user = new Cancellation(username , email , phoneNumber , reason , description);
			cancellation.add(user);
			
			}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return cancellation;
		
	} 
	
	
}
