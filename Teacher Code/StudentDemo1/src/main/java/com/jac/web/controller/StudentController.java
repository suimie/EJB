package com.jac.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Servlet.jsp</title>\r\n" + 
				"<body>\r\n" + 
				"	<h2>Servlet-Print Writer!</h2>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
	rd.include(request, response);
	}


}
