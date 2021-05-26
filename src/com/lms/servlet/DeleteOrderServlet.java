package com.lms.servlet;
import com.lms.model.PlaceOrder;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.util.PlaceOrderUtil;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("ordid");
		boolean isTrue;
		
		isTrue = PlaceOrderUtil.deleteorder(id);
		
		if(isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("PlaceOrder.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<PlaceOrder>orddetails = PlaceOrderUtil.getorderDetails(id);
			request.setAttribute("orddetails", orddetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("OrderDetail.jsp");
			dispatcher.forward(request, response);
			
		}
	
	}

}
