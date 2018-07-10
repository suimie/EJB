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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipd12.model.Student;

@Controller
public class StudentController {
	@RequestMapping("/student")
	public ModelAndView studentList(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		if (!username.equals("teacher")) {
			ModelAndView mv = new ModelAndView("InvalidAuthority");
			return mv;
		}
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Student s");
		List<Student> sList = (List<Student>)query.getResultList();
		
		System.out.println(sList);
		
		ModelAndView mv = new ModelAndView("students");
		
		mv.addObject("students", sList);
		
		em.close();
		emf.close();
		return mv;
	}
	
	
	@RequestMapping("/editStudent")
	public ModelAndView editStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int sId = 0;
		if (request.getParameter("sId") != null)
			sId = Integer.parseInt(request.getParameter("sId"));
		
		ModelAndView mv = new ModelAndView("editStudent");
		if (sId > 0) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
			EntityManager em = emf.createEntityManager();
			
			Query query = em.createQuery("SELECT s FROM Student s WHERE s.id=" + sId);
			List<Student> sList = (List<Student>)query.getResultList();
			em.close();
			emf.close();
			
			if (sList.size() <= 0) {

				String error = "This student doesn't exist in our system.";
				request.setAttribute("error", error);
				
				response.sendRedirect(request.getContextPath() + "/student");
			}else {
				mv.addObject("studentinfo", sList.get(0));
			}
		}
		
		return mv;
	}
	
	@RequestMapping("/saveStudent")
	public void saveStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		int sId = 0;
		if (request.getParameter("sId") != null)
			sId = Integer.parseInt(request.getParameter("sId"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String city = request.getParameter("city");
		String postal = request.getParameter("postal");
		
		Student student = new Student();
		student.setId(sId);
		student.setName(name);
		student.setPassword(password);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setCity(city);
		student.setPostal(postal);
		
		if (name == null || name == "" || password == null || password == ""){

			String error = "You should enter every field.";
			request.setAttribute("error", error);
			request.setAttribute("studentinfo", student);
			response.sendRedirect(request.getContextPath() + "/editStudent");
		}
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		if(sId > 0) {
			student = em.find(Student.class, sId);
			student.setName(name);
			student.setPassword(password);
			student.setFirstname(firstname);
			student.setLastname(lastname);
			student.setCity(city);
			student.setPostal(postal);
		}
		em.persist(student);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		response.sendRedirect(request.getContextPath() + "/student");		
	}	
	
	@RequestMapping("/deleteStudent")
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int sId = 0;
		try {
			if (request.getParameter("sId") != null) {
				sId = Integer.parseInt(request.getParameter("sId"));
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
				EntityManager em = emf.createEntityManager();

				Student student = em.find(Student.class, sId);
				
				if (student != null) {
					em.getTransaction().begin();
					em.remove(student);
					em.getTransaction().commit();
				}else {
					String error = "This student doesn't exist in our library.";
					request.setAttribute("error", error);
				}
				em.close();
				emf.close();
			}
			
		}catch(NumberFormatException e) {
			request.setAttribute("sId", sId);
			response.sendRedirect(request.getContextPath() + "/editStudent");
		}
		
		response.sendRedirect(request.getContextPath() + "/student");
	}
	


	@RequestMapping("/searchStudent")
	public ModelAndView searchStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String keyword = (String)request.getParameter("keyword");
		
		if (keyword == null || keyword == "") {
			response.sendRedirect(request.getContextPath() + "/student");
		}
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		Query query2 = em.createQuery("SELECT s FROM Student s WHERE s.firstname LIKE '%" + keyword + 
				"%' OR s.lastname LIKE '%" + keyword + "%'");
		List<Student> sList = (List<Student>)query2.getResultList();
		
		System.out.println(sList);
		
		ModelAndView mv = new ModelAndView("students");
		
		mv.addObject("students", sList);
		
		em.close();
		emf.close();
		
		return mv;
	}
}
