package com.lms.util;

import com.lms.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlanDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static Plan getUserPlan(User user) {
		Plan plan = null;
		String planName;
		int isCustomizable;
		
		try {
			
			con = DBConnectorUtil.getConnection();
			stmt = con.createStatement();
			String sql = "select * from plan where Plan_ID="+user.getPlanId()+"";
			rs = stmt.executeQuery(sql); //execute sql query
			
			if(rs.next()) {
				planName =  rs.getString("Plan_Name");	//retrieve plan name
				isCustomizable = rs.getInt("customizable"); //retrieve customizable
				
				//checking whether the registered plan is customizable or not
				if(isCustomizable == 0) {
					
					//retrieve data from database
					int planId = rs.getInt("Plan_ID");
					int maxOrders =  rs.getInt("Max_Orders");
					int maxWeight =  rs.getInt("Max_Weight");
					int pressing =  rs.getInt("pressing");
					int mending =  rs.getInt("mending");
					int oneday =  rs.getInt("oneday");
					int dryclean =  rs.getInt("dryclean");
					int pickupDelivery =  rs.getInt("pickup_delivery");
					double monthlyPayment =  rs.getDouble("Monthly_Payment");
					
					plan = new Plan(planId, planName, maxOrders, maxWeight, pressing, mending, 
							oneday, dryclean, pickupDelivery,  false);	//create plan object
				}
				else {
					//sql query for customized plans
					String sql2 = "select * from customized_plan where Plan_ID="+user.getPlanId()+" and User_ID="+user.getId()+"";
					rs = stmt.executeQuery(sql2); //execute sql query 
					
					if(rs.next()) {
						//retrieve data from database
						int planId = rs.getInt("Plan_ID");
						int maxOrders =  rs.getInt("Max_Orders");
						int maxWeight =  rs.getInt("Max_Weight");
						int pressing =  rs.getInt("pressing");
						int mending =  rs.getInt("mending");
						int oneday =  rs.getInt("oneday");
						int dryclean =  rs.getInt("dryclean");
						int pickupDelivery =  rs.getInt("pickup_delivery");
						double monthlyPayment =  rs.getDouble("Monthly_Payment");
						
						plan = new RegularPlan(planId, planName, maxOrders, maxWeight, pressing, mending, 
								oneday, dryclean, pickupDelivery, monthlyPayment, true);	//create plan object
					}
				}
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace(); 
			
		}
		
		return plan; //return plan object
	}
	
	public static boolean unregisterPlan(User user){
		boolean isSuccess = false;
		
		try {
			
			con = DBConnectorUtil.getConnection();	//create connection
			stmt = con.createStatement();	//create sql statement
			
			String sql = "delete from customized_plan where Plan_ID =" + user.getPlanId() + " and User_ID =" + user.getId() + "";	//sql query
			int r = stmt.executeUpdate(sql);	//execute query
			
			if(r > 0) {
				//update user-profile table
				String sql2 = "update user_profile set Plan_ID=1 where User_ID =" + user.getId();	
				stmt.executeUpdate(sql2);
				
				if(r > 0) {
					isSuccess = true;
				}
			}
			
			con.close();	//close connection
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean saveUserPlan(User user, int maxOrders, int maxWeight, int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery, double monthlyPayment) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnectorUtil.getConnection();	//create connection
			stmt = con.createStatement();	//create sql statement
			String sql = "update customized_plan set pressing="+pressing+", mending="+mending+", oneday="+oneday+", dryclean="+dryclean+", pickup_delivery="+pickupDelivery+
					", Max_Orders="+maxOrders+", Max_Weight="+maxWeight+", Monthly_Payment="+monthlyPayment+" where User_ID="+user.getId()+" and Plan_ID="+user.getPlanId();
			
			int r = stmt.executeUpdate(sql); //execute sql query
			
			if(r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
			con.close();	//close connection
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static double calculateMonthlyPayment(int maxOrders, int maxWeight, int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery) {
		
		double monthlyPayment = 0;
		
		if(pressing == 1) {
			monthlyPayment += 200;
		}
		if(mending == 1) {
			monthlyPayment += 200;
		}
		if(oneday == 1) {
			monthlyPayment += 200;
		}
		if(dryclean == 1) {
			monthlyPayment += 200;
		}
		if(pickupDelivery == 1) {
			monthlyPayment += 200;
		}
		
		monthlyPayment += 100 * maxOrders;
		monthlyPayment += 100 * maxWeight;
		
		return monthlyPayment;
	}

}
