package com.jac.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jac.web.dao.ProductDAO;
import com.jac.web.model.Product;

/**
 * Servlet implementation class getProductsListController
 */
public class getProductsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getProductsListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			
			response.sendRedirect("index.jsp");
		}else {
		
			ArrayList<Product> productList = (new ProductDAO()).getAllProducts();
			
			request.setAttribute("products", productList);
	
		
			RequestDispatcher rd = request.getRequestDispatcher("productList.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("pId"));
		
		ProductDAO pdao = new ProductDAO();
		pdao.deleteProduct(id);
		
		doGet(request, response);
	}
}
