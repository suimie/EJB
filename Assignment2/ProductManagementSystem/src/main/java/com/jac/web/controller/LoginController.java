package com.jac.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.UserDAO;
import com.jac.web.model.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Logout
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Login
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		User user = (new UserDAO()).getUser(username);

		if (user != null && password.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//response.sendRedirect("/ProductManagementSystem/Products");
			
			response.sendRedirect(request.getContextPath() + "/Products");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("username", null);
			session.setAttribute("error",  "Wrong username or password.");
			
			response.sendRedirect("index.jsp");
		}
	}

}
