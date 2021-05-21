package com.regular;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	//create database connection
	private static String url = "jdbc:mysql://localhost:3306/packages";
	private static String userName = "root";
	private static String password = "oshan@0765649523";
	private static Connection con;
	
	//validation
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
		}
		catch(Exception e) {
			System.out.println();
		}
		return con;
	}
}
