package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.ProductDAO;
import com.jac.web.dao.UserDAO;
import com.jac.web.model.Product;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		User user = (new UserDAO()).getUser(username);

		if (user != null && password.equals(user.getPassword())) {
			ArrayList<Product> productList = (new ProductDAO()).getAllProducts();
			
			request.setAttribute("productList", productList);
			//if (username.equals("admin")) {
				
			//}
			//request.setAttribute("user", user);
			
			//RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			//rd.forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("productList", username);
			response.sendRedirect("welcome.jsp");
		}/*else {
			request.setAttribute("username", null);
			request.setAttribute("error",  "Wrong username or password.");
			
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request, response);
			response.sendRedirect("index.jsp");
		}*/
	}

}
