package com.lms.util;

import java.sql.Connection;




import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.lms.model.Order;


public class PlaceOrderUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static boolean orderinsert(String Order_ID, int Customer_ID, String CustomerType, String Date, String OrderMethod, String Location, String PaymentAmount) {
		
		boolean isSuccess = false;
		
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql ="insert into insertorder values (0,'"+Customer_ID+"','"+CustomerType+"','"+Date+"','"+OrderMethod+"','"+Location+"','"+PaymentAmount+"')";
			int rs =stmt.executeUpdate(sql);
			
			
			if(rs>0) {
				
				isSuccess = true;
			}
			else {
				isSuccess = false;
				
			}
				
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}
	
	public static boolean updateorder(String Order_ID, int Customer_ID, String CustomerType, String Date, String OrderMethod, String Location, String PaymentAmount) {
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "update order set CustomerType='"+CustomerType+"',Date='"+Date+"',OrderMethod='"+OrderMethod+"',Location='"+Location+"',PaymentAmount='"+PaymentAmount+"'"
					+ "where Order_ID ='"+Order_ID+"', Customer_ID ='"+Customer_ID+"'";
					
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				
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
	
	public static List<Order> getorderDetails(String Id)
	{
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<Order> ord = new ArrayList();
		
		try {
			
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from order where Order_ID = '"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				//type according to the column in database one by one with respect to order java class
				String Order_ID = rs.getString(1);
				String CustomerType = rs.getString(2);
				String Date = rs.getString(3);
				String OrderMethod = rs.getString(4);
				String Location = rs.getString(5);
				String PaymentAmount = rs.getString(6);
				
				
				
				
				Order o = new Order(Order_ID,CustomerType,Date,OrderMethod,Location,PaymentAmount);
				ord.add(o);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ord;
		
	}
	
	public static boolean deleteorder(String id) {
		
		int convId = Integer.parseInt(id);
		
		try {
			
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "delete from order where id ='"+convId+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r>0) {
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
