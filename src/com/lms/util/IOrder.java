package com.lms.util;

import java.util.ArrayList;

import com.lms.model.Order;
import com.lms.model.User;

public interface IOrder {
	public ArrayList<Order> getOrderHistory(User user);
}
