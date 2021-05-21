package com.lms.servlet;

import com.lms.util.*;
import com.lms.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
/**
 * Servlet implementation class LogInControl
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("usr");
		String password = request.getParameter("pwd");
		boolean isTrue;
		
		isTrue = UserDBUtil.validate(userName, password);
		
		if (isTrue == true) {
			User user = UserDBUtil.getUser(userName);
			Plan plan = PlanDBUtil.getUserPlan(user);

	
			HttpSession session = request.getSession();
			
			session.setAttribute("loggedUser", user);
			session.setAttribute("userPlan", plan);
			
			if(plan.getPlanId() == 2) {
				ArrayList<MonthlyPayment> mp = MonthlyPaymentDBUtil.getMonthlyPaymentHistory(user);
				session.setAttribute("mpHistory", mp);
			}
			
		/*	ArrayList<Order> orderHistory = OrderDBUtil.getOrderHistory(user);
			session.setAttribute("ordHistory", orderHistory);
			
			 Date date = Calendar.getInstance().getTime();  
             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");  
             String strDate = dateFormat.format(date);
             
			session.setAttribute("date", strDate);
			
			response.sendRedirect("dashboard-normal.jsp");
			
			*/
			
			
			
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='Login.jsp'");
			out.println("</script>");
		}
	}

}
