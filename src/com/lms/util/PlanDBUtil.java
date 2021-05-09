package com.lms.user;

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
							oneday, dryclean, pickupDelivery, monthlyPayment, false);	//create plan object
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
						
						plan = new Plan(planId, planName, maxOrders, maxWeight, pressing, mending, 
								oneday, dryclean, pickupDelivery, monthlyPayment, true);	//create plan object
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
			
		}
		
		return plan; //return plan object
	}
}
