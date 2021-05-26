package com.lms.servlet;

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


@WebServlet("/InsertOrderServlet")
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		String CustomerType = request.getParameter("CustomerType");
		String Date = request.getParameter("Date");
		String OrderMethod = request.getParameter("OrderMethod");
		String Location = request.getParameter("Location");
		String PaymentAmount = request.getParameter("PaymentAmount");
		
		
		boolean isTrue;
		
		isTrue = PlaceOrderUtil.orderinsert(CustomerType, Date, OrderMethod, Location, PaymentAmount );
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Success.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("orderfail.jsp");
			dis2.forward(request, response);
		}
	}

}
