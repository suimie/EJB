package com.jac12;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");

		EntityManager em = emf.createEntityManager();
		
		
		Student s1 = em.find(Student.class, 101);
		
		System.out.println(s1);
		
		// Insert
//		Student newStudent = new Student();
//		newStudent.setId(201);
//		newStudent.setName("Jooeun");
//		newStudent.setPwd("abc");
//		newStudent.setCity("Cote Saint Luc");
//		
//		em.getTransaction().begin();
//		em.persist(newStudent);
//		em.getTransaction().commit();
//		
//		
//		s1 = em.find(Student.class, 201);
//		
//		System.out.println(s1);
		

		// Update
//		s1 = em.find(Student.class, 201);
//		s1.setCity("Montreal");
//		em.getTransaction().begin();
//		em.persist(s1);
//		em.getTransaction().commit();
//		
//		s1 = em.find(Student.class, 201);
//		System.out.println(s1);
		
		
		// Delete
		s1 = em.find(Student.class, 201);
		em.getTransaction().begin();
		em.remove(s1);
		em.getTransaction().commit();
		
		Query query = em.createQuery("Select s FROM Student s");
		ArrayList<Student> studentList = (ArrayList<Student>)query.getResultList();
		
		for(Student s : studentList) {
			System.out.println(s);
		}
		
		em.close();
		emf.close();
	}

}
