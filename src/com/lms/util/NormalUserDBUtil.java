package com.normal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NormalUserDBUtil {
	public static List<NormalUser> validate (String uname, String pword) {

		ArrayList<NormalUser> nuser = new ArrayList<>();
		
		//create database connection
		
		String url = "jdbc:mysql://localhost:3306/packages";
		String user = "root";
		String pass = "oshan@0765649523";
		
		//validation
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select * from customer where username='"+uname+"' and password='"+pword+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				int maxo = rs.getInt(2); 
				int maxw = rs.getInt(3);
				byte[] w = rs.getBytes(4);
				byte[] wd = rs.getBytes(5);
				byte[] ods = rs.getBytes(6);
				byte[] pad = rs.getBytes(7);
				String useru = rs.getString(8);
				String passu = rs.getString(9);
				
				NormalUser nu = new NormalUser(id,maxo,maxw,w,wd,ods,pad,useru,passu);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return nuser;
	}
}

