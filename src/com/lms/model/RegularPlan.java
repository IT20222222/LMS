package com.lms.model;

public class RegularPlan extends Plan {
	private double monthlyPayment;
	
	//for regular plan users
	public RegularPlan(int planId, String planName, int maxOrders, int maxWeight, int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery, double monthlyPayment, boolean isCustomizable) {
		super(planId, planName, maxOrders, maxWeight, pressing, mending, oneday, dryclean, pickupDelivery,
				isCustomizable);
		this.monthlyPayment = monthlyPayment;
	}
	
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	
	
}
