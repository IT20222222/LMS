package com.regular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegularUserDBUtil {
	public static List<RegularUser> validate (String uname, String pword) {
		
		ArrayList<RegularUser> ruser = new ArrayList<>();
		
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
				byte[] wdp = rs.getBytes(6);
				byte[] mend = rs.getBytes(7);
				byte[] ods = rs.getBytes(8);
				byte[] pad = rs.getBytes(9);
				String useru = rs.getString(10);
				String passu = rs.getString(11);
				
				RegularUser ru = new RegularUser(id,maxo,maxw,w,wd,wdp,mend,ods,pad,useru,passu);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ruser;
	}
}
