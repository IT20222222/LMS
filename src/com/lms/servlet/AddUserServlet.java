package com.lms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("Firstname");
		String lastName = request.getParameter("Lastname");
		String NIC = request.getParameter("NIC");
		String email = request.getParameter("Email");
		String address = request.getParameter("Address");
		String gender = request.getParameter("gender");
		String MobileNumber = request.getParameter("mobile");
		String DOB = request.getParameter("dob");
		String username = request.getParameter("username");
		String password = request.getParameter("Password");
		
		UserDBUtil.
	}

}