package com.lms.servlet;
import com.lms.model.PlaceOrder;

import com.lms.model.User;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.util.PlaceOrderUtil;


@WebServlet("/InsertOrder")
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedUser");
		int Customer_ID = user.getId();
		
		String Order_ID = request.getParameter("Order_ID");
		String CustomerType = request.getParameter("CustomerType");
		String Date = request.getParameter("Date");
		String OrderMethod = request.getParameter("OrderMethod");
		String Location = request.getParameter("Location");
		String PaymentAmount = request.getParameter("PaymentAmount");
		
		
		boolean isTrue;
		
		isTrue = PlaceOrderUtil.orderinsert(Order_ID, Customer_ID, CustomerType, Date, OrderMethod, Location, PaymentAmount );
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("ordersuccess.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("orderfail.jsp");
			dis2.forward(request, response);
		}
	}

}
