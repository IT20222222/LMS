package com.lms.util;

import com.lms.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
		}
		
	public static User getUser(String userName) {
			
			User user = null;
			
			try {
				
				con = DBConnectorUtil.getConnection();
				stmt = con.createStatement();
				String sql = "select * from user_profile where username='"+userName+"'";
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
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
					
					user = new User(userId, firstName, lastName, NIC, email, address, gender, mobileNo, DOB, username, password, planId);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			return user;	
		}
	
	public static boolean addUser(String Firstname , String Lastname , String NIC , String email, String address, String gender , int mobile , String dob , String username , String password) {
		
		isSuccess = false;
		try {
		con = DBConnectorUtil.getConnection();
		stmt = con.createStatement();
		String sql2 = "INSERT INTO user_profile (0 , '"+Firstname+"' , '"+Lastname+"' , '"+NIC+"' , '"+email+"' , '"+address+"' , '"+gender+"' , '"+mobile+"' , '"+dob+"' , '"+username+"' , '"+password+"' )";
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
	
	
	
}
