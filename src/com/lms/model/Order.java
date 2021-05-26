package com.lms.model;

public class Order {

	private String Order_ID;
	private String CustomerType;
	private String Date;
	private String OrderMethod;
	private String Location;
	private String PaymentAmount;
	
	public Order(String Order_ID, String CustomerType, String Date, String OrderMethod, String Location,
			String PaymentAmount) {
		super();
		this.Order_ID = Order_ID;
		this.CustomerType = CustomerType;
		this.Date = Date;
		this.OrderMethod = OrderMethod;
		this.Location = Location;
		this.PaymentAmount = PaymentAmount;
	
	}

	public String getId() {
		return Order_ID;
	}

	
	public String getCustomer() {
		return CustomerType;
	}

	

	public String getDay() {
		return Date;
	}



	public String getOrdermethod() {
		return OrderMethod;
	}

	
	public String getLocation() {
		return Location;
	}

	

	public String getDetails() {
		return PaymentAmount;
	}

	

	
	
	
}
