package com.lms.servlet;
import com.lms.model.PlaceOrder;
import com.lms.model.User;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.util.PlaceOrderUtil;


@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();				//Obtaining the current session.
		User user = (User)session.getAttribute("loggedUser");	//Getting the logged in information through the attribute set at login.
		int Customer_ID = user.getId();
		
		String Order_ID = request.getParameter("Order_ID");			//Obtaining User entered Information
		String CustomerType = request.getParameter("CustomerType");
		String Date = request.getParameter("Date");
		String OrderMethod = request.getParameter("OrderMethod");
		String Location = request.getParameter("Location");
		String PaymentAmount = request.getParameter("PaymentAmount");
		boolean isTrue;
		
		//Calling the update order method to update details.
		isTrue = PlaceOrderUtil.updateorder(Order_ID, Customer_ID, CustomerType, Date, OrderMethod, Location, PaymentAmount);
		
		if(isTrue == true) {
			
			List<PlaceOrder> ordDetails = PlaceOrderUtil.getorderDetails(Order_ID);
			request.setAttribute("ordDetails", ordDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("OrderDetail.jsp");
			dis.forward(request, response);
		}
		else {
			List<PlaceOrder> ordDetails = PlaceOrderUtil.getorderDetails(Order_ID);
			request.setAttribute("ordDetails", ordDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("OrderDetail.jsp");
			dis.forward(request, response);
		}
	}

}
