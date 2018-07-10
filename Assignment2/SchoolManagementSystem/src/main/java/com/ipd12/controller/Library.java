package com.ipd12.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipd12.model.Book;

@Controller
public class Library {
	@RequestMapping("/library")
	public ModelAndView getBooksList(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		Query query2 = em.createQuery("SELECT b FROM Book b");
		List<Book> bList = (List<Book>)query2.getResultList();
		
		System.out.println(bList);
		
		ModelAndView mv = new ModelAndView("library");
		
		mv.addObject("library", bList);
		
		em.close();
		emf.close();
		return mv;
	}
	
	@RequestMapping("/editBook")
	public ModelAndView editBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int bId = 0;
		if (request.getParameter("bId") != null)
			bId = Integer.parseInt(request.getParameter("bId"));
		
		ModelAndView mv = new ModelAndView("editBook");
		if (bId > 0) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();
			
			Query query2 = em.createQuery("SELECT b FROM Book b WHERE b.id=" + bId);
			List<Book> bList = (List<Book>)query2.getResultList();
			em.close();
			emf.close();
			
			if (bList.size() <= 0) {

				String error = "This book doesn't exist in our library.";
				request.setAttribute("error", error);
				
				response.sendRedirect(request.getContextPath() + "/library");
			}else {
				mv.addObject("bookinfo", bList.get(0));
			}
		}
		
		return mv;
	}
	
	@RequestMapping("/deleteBook")
	public void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int bId = 0;
		try {
			if (request.getParameter("bId") != null) {
				bId = Integer.parseInt(request.getParameter("bId"));
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
				EntityManager em = emf.createEntityManager();

				Book book = em.find(Book.class, bId);
				
				if (book != null) {
					em.getTransaction().begin();
					em.remove(book);
					em.getTransaction().commit();
				}else {
					String error = "This book doesn't exist in our library.";
					request.setAttribute("error", error);
				}
				em.close();
				emf.close();
			}
			
		}catch(NumberFormatException e) {
			request.setAttribute("bId", bId);
			response.sendRedirect(request.getContextPath() + "/editBook");
		}
		
		response.sendRedirect(request.getContextPath() + "/library");
	}
	
	@RequestMapping("/saveBook")
	public void saveBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		int bId = 0;
		if (request.getParameter("bId") != null)
			bId = Integer.parseInt(request.getParameter("bId"));
		String title = request.getParameter("title");
		String author = request.getParameter("authorname");
		
		Book book = new Book();
		book.setId(bId);
		book.setTitle(title);
		book.setAuthorname(author);
		
		if (title == null || title == "" || author == null || author == ""){

			String error = "Title and Author must not be empty.";
			request.setAttribute("error", error);
			request.setAttribute("bookinfo", book);
			response.sendRedirect(request.getContextPath() + "/editBook");
		}
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		if(bId > 0) {
			book = em.find(Book.class, bId);
			book.setTitle(title);
			book.setAuthorname(author);
		}
		em.persist(book);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		response.sendRedirect(request.getContextPath() + "/library");		
	}
	
	@RequestMapping("/searchBook")
	public ModelAndView searchBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String keyword = (String)request.getParameter("keyword");
		
		if (keyword == null || keyword == "") {
			response.sendRedirect(request.getContextPath() + "/library");
		}
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		Query query2 = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE '%" + keyword + "%'");
		List<Book> bList = (List<Book>)query2.getResultList();
		
		System.out.println(bList);
		
		ModelAndView mv = new ModelAndView("library");
		
		mv.addObject("library", bList);
		
		em.close();
		emf.close();
		
		return mv;
	}
}
