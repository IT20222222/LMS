package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.util.UserDBUtil;

/**
 * Servlet implementation class getUserProfileData
 */
@WebServlet("/getUserProfileData")
public class getUserProfileData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		List<User> userDetails = UserDBUtil.getProfileData(username);
		request.setAttribute("userDetails", userDetails);
		
	}

}
