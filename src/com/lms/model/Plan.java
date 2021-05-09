package com.lms.user;

import java.util.HashMap;

public class Plan {
	private int planId;
	private String planName;
	private int maxOrders;
	private int maxWeight;
	private double monthlyPayment;
	private boolean isCustomizable;
	private HashMap<String, String> availableServices;
	
	public Plan(int planId, String planName, int maxOrders, int maxWeight, int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery, double monthlyPayment, boolean isCustomizable) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.maxOrders = maxOrders;
		this.maxWeight = maxWeight;
		this.availableServices = new HashMap<>();
		this.monthlyPayment = monthlyPayment;
		this.isCustomizable = isCustomizable;
		
		this.addServices(pressing, mending, oneday, dryclean, pickupDelivery);
	}

	public boolean isCustomizable() {
		return isCustomizable;
	}

	public int getPlanId() {
		return planId;
	}

	public String getPlanName() {
		return planName;
	}

	public int getMaxOrders() {
		return maxOrders;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	
	public HashMap<String, String> getAvailableServices() {
		return availableServices;
	}

	private void addServices(int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery ){
		
		if(pressing == 0) {
			availableServices.put("pressing", "No");
		}
		else {
			availableServices.put("pressing", "Yes");
		}
		
		if(mending == 0) {
			availableServices.put("mending", "No");
		}
		else {
			availableServices.put("mending", "Yes");
		}
		
		if(oneday == 0) {
			availableServices.put("oneday", "No");
		}
		else {
			availableServices.put("oneday", "Yes");
		}
		
		if(dryclean == 0) {
			availableServices.put("dryclean", "No");
		}
		else {
			availableServices.put("dryclean", "Yes");
		}
		
		if(pickupDelivery == 0) {
			availableServices.put("pickupDelivery", "No");
		}
		else {
			availableServices.put("pickupDelivery", "Yes");
		}
		
	}
	
	
	
}
