package com.lms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lms.model.Cancellation;
import com.lms.util.UserDBUtil;

/**
 * Servlet implementation class getCancellationDetails
 */
@WebServlet("/getCancellationDetails")
public class getCancellationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cancellation> cancellationDetails = UserDBUtil.getCancellationDetails();
		request.setAttribute("cancellationDetails", cancellationDetails);
	}

}
