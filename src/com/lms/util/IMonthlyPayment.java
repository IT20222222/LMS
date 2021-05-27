package com.lms.util;

import java.util.ArrayList;

import com.lms.model.MonthlyPayment;
import com.lms.model.User;

public interface IMonthlyPayment {
	
	public boolean pay(User user, double amount);
	
	public ArrayList<MonthlyPayment> getMonthlyPaymentHistory(User user);
	
	public boolean checkMonth(ArrayList<MonthlyPayment> paymentHistory);
}
