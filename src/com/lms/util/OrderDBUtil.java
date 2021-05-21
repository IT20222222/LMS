package com.lms.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.lms.model.Order;
import com.lms.model.User;

public class OrderDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ArrayList<Order> orderHistory = new ArrayList<>();
	
	public static ArrayList<Order> getOrderHistory(User user) {
		orderHistory.clear();
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user_order where User_ID="+user.getId()+"";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int OrderID = rs.getInt("Order_ID");
				int UserID = rs.getInt("User_ID");
				String date = rs.getString("date");
				double payment = rs.getDouble("payment");
				String status = rs.getString("status");
				
				orderHistory.add(new Order(OrderID, UserID, date, payment, status));
			}
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderHistory;
	}
}
