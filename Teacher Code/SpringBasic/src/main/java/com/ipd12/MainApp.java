package com.ipd12;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipd12.model.Student;

public class MainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");
		EntityManager em = emf.createEntityManager();
		
		Student s1 = em.find(Student.class, 102);
		System.out.println(s1);
		
		s1.setCity(s1.getCity()+"-new update");
		em.getTransaction().begin();
		em.persist(s1);
		em.getTransaction().commit();
		em.close();
		emf.close();
		/*em.getTransaction().begin();
		
		Student s2 = new Student();
		s2.setStudentID(1000);
		s2.setUsername("test1");
		s2.setPassword("test-pass");
		s2.setCity("test-city");
		
		em.persist(s2);
		em.getTransaction().commit();
		em.close();
		emf.close();*/
		
		
	}
}
