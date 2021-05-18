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
	
	public String getMonth() {
		String month = null;
		
		try {
			
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(this.date);  
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
	        month = dateFormat.format(date1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
        return month;
	}
	
	
	
}
