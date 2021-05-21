package com.lms.util;

import com.lms.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;

public class MonthlyPaymentDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ArrayList<MonthlyPayment> monthlyPaymentHistory = new ArrayList<>();
	private static boolean isSuccess = false;
	private static LocalDate date = LocalDate.now();
	
	public static boolean pay(User user, double amount) {
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "insert into monthly_payment values("+user.getId()+",'"+date.getMonth().toString()+"','"+date.toString()+"',"+amount+", 'Completed')";
			int r = stmt.executeUpdate(sql); //execute sql query
			
			if(r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static ArrayList<MonthlyPayment> getMonthlyPaymentHistory(User user) {
		monthlyPaymentHistory.clear();
		
		try {
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from monthly_payment where User_ID="+user.getId()+"";
			rs = stmt.executeQuery(sql); //execute sql query
			
			while(rs.next()) {
				int id = rs.getInt("User_ID");
				String month  = rs.getString("month");
				String date = rs.getString("date");
				Double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				
				monthlyPaymentHistory.add(new MonthlyPayment(id, month, date, amount, status));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return monthlyPaymentHistory;
	}
	
	public static boolean checkMonth(ArrayList<MonthlyPayment> paymentHistory) {
		boolean isTrue = true;
		String currentMonth = date.getMonth().toString();
		
		for(MonthlyPayment mp : paymentHistory) {
			
			if(mp.getMonth() == currentMonth) {
				isTrue = false;
				break;
			}

		}
		
		return isTrue;
	}

}
