package com.lms.util;

import com.lms.model.Plan;
import com.lms.model.RegularPlan;
import com.lms.model.User;

public interface IPlan {
	public Plan getUserPlan(User user);
	
	public boolean unregisterPlan(User user);
	
	public boolean saveUserPlan(User user, int maxOrders, int maxWeight, int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery, double monthlyPayment);
	
	public double calculateMonthlyPayment(int maxOrders, int maxWeight, int pressing, int mending, int oneday,
			int dryclean, int pickupDelivery);

}
