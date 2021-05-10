package com.lms.model;

public class MonthlyPayment {
	private int User_ID;
	private String month;
	private String date;
	private double amount;
	private String status;
	
	public MonthlyPayment(int user_ID, String month, String date, double amount, String status) {
		super();
		User_ID = user_ID;
		this.month = month;
		this.date = date;
		this.amount = amount;
		this.status = status;
	}

	public String getMonth() {
		return month;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public String getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}
	
	
	
}
