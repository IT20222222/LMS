package com.lms.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Order {
	private int OrderID;
	private int UserID;
	private String date;
	private double payment;
	private String status;
	
	public Order(int orderID, int userID, String date, double payment, String status) {
		super();
		OrderID = orderID;
		UserID = userID;
		this.date = date;
		this.payment = payment;
		this.status = status;
	}

	public int getOrderID() {
		return OrderID;
	}

	public int getUserID() {
		return UserID;
	}

	public String getDate() {
		return date;
	}

	public double getPayment() {
		return payment;
	}

	public String getStatus() {
		return status;
	}
	
	//to get the month of the order
	public String getMonth() {
		String month = null;
		
		try {
			
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(this.date); 	//create a date object using order's date 
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");	//create a date format object
	        month = dateFormat.format(date1);	//convert date to a string
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
        return month;	//return month
	}
	
	
	
}
