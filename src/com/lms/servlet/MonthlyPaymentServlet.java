package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.model.MonthlyPayment;
import com.lms.model.Plan;
import com.lms.model.RegularPlan;
import com.lms.model.User;
import com.lms.util.MonthlyPaymentDBUtil;

/**
 * Servlet implementation class MonthlyPaymentServlet
 */
@WebServlet("/MonthlyPaymentServlet")
public class MonthlyPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("loggedUser");
		RegularPlan plan = (RegularPlan) session.getAttribute("userPlan");
		@SuppressWarnings("unchecked")
		ArrayList<MonthlyPayment> historyList = (ArrayList<MonthlyPayment>) session.getAttribute("mpHistory");
		boolean isTrue;
		
		if(MonthlyPaymentDBUtil.checkMonth(historyList)) {
			isTrue = MonthlyPaymentDBUtil.pay(user, plan.getMonthlyPayment());
			
			if (isTrue == true) {

				session.removeAttribute("mpHistory");
				ArrayList<MonthlyPayment> mp = MonthlyPaymentDBUtil.getMonthlyPaymentHistory(user);
				session.setAttribute("mpHistory", mp);
				
				out.println("<script type='text/javascript'>");
				out.println("alert('Successfull!');");
				out.println("location='my-plan-regular.jsp'");
				out.println("</script>");
				
				
				
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Error!');");
				out.println("location='my-plan-regular.jsp'");
				out.println("</script>");
			}
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('You've already paid this month due!');");
			out.println("location='my-plan-regular.jsp'");
			out.println("</script>");
		}
		
		
	}

}
