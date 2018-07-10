package com.ipd12.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipd12.model.Product;
import com.ipd12.model.User;

/**
 * Servlet implementation class ProductsController
 */
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {			
			response.sendRedirect("index.jsp");
		}else {
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();

			Query query = em.createQuery("from Product");
			
			ArrayList<Product> productList = (ArrayList<Product>)query.getResultList();

			em.close();
			emf.close();
			
			request.setAttribute("products", productList);
	
		
			RequestDispatcher rd = request.getRequestDispatcher("productsList.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String command = (String)request.getParameter("command");
		
		if(command.equals("add")) {
			// This is the add product operation
			response.setContentType("text/html");
			
			String pname = request.getParameter("pname");
			try {
				BigDecimal pprice = new BigDecimal((request.getParameter("pprice")));
			
				Product product = new Product();
				product.setName(pname);
				product.setPrice(pprice);
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
				EntityManager em = emf.createEntityManager();

				em.getTransaction().begin();
				em.persist(product);
				em.getTransaction().commit();
				

				em.close();
				emf.close();
				
			}catch(NumberFormatException e) {
				request.setAttribute("error", "Digit number only for price!");
				
				RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
				rd.forward(request, response);
				return;
			}
		}else if (command.equals("delete")) {
			// This is the delete product operation
			int id = Integer.parseInt(request.getParameter("pId"));
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();

			Product product = em.find(Product.class, id);
			em.getTransaction().begin();
			em.remove(product);;
			em.getTransaction().commit();
			

			em.close();
			emf.close();
		}else if (command.equals("search")) {
			String keyword = (String)request.getParameter("keyword");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();

			Query query = em.createQuery("from Product where name like :keyword");
			query.setParameter("keyword", "%" + keyword + "%");
			
			ArrayList<Product> productList = (ArrayList<Product>)query.getResultList();

			em.close();
			emf.close();
			
			request.setAttribute("products", productList);
	
		
			RequestDispatcher rd = request.getRequestDispatcher("productsList.jsp");
			rd.forward(request, response);
			return;
		}else if(command.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("pId"));
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();

			Product product = em.find(Product.class, id);
			

			em.close();
			emf.close();	
			
			request.setAttribute("product",  product);
			RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
			rd.forward(request, response);
			return;
		}else if(command.equals("update")) {
			// This is the add product operation
			response.setContentType("text/html");
			
			String pname = request.getParameter("pname");
			int pId = Integer.parseInt(request.getParameter("pId"));
			try {
				BigDecimal pprice = new BigDecimal((request.getParameter("pprice")));
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
				EntityManager em = emf.createEntityManager();

				Product product = em.find(Product.class, pId);

				product.setName(pname);
				product.setPrice(pprice);

				em.getTransaction().begin();
				em.persist(product);
				em.getTransaction().commit();
				
				em.close();
				emf.close();
				
			}catch(NumberFormatException e) {
				Product product = new Product();
				product.setId(pId);
				product.setName(pname);
				
				request.setAttribute("error", "Digit number only for price!");
				request.setAttribute("product", product);
				
				RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
				rd.forward(request, response);
				return;
			}
			
		}
		
		doGet(request, response);
	}

}
