package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.model.User;
import com.lms.util.UserDBUtil;
import com.lms.util.UserInterface;

/**
 * Servlet implementation class UpdateUserDetails
 */
@WebServlet("/UpdateUserDetailsServlet")
public class UpdateUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("Email");
		String address = request.getParameter("address");
		int number = Integer.parseInt(request.getParameter("number"));
		
		boolean isTrue = UserDBUtil.updateCustomer(username, firstname, lastname, address, number , email);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedUser");

		
		
		if(isTrue == true) {
			
			user.setAddress(address);
			user.setEmail(email);
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setMobileNo(number);
			user.setUsername(username);
			RequestDispatcher dis = request.getRequestDispatcher("UserProfile..jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			dis.forward(request, response);
		}
		
	}





}
