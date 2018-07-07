package com.jac12.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class JPATestMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("punit1");

		EntityManager em = emf.createEntityManager();
		
		//insert
//		Student newS = new Student();
//		newS.setStudentID(10001);
//		newS.setUsername("James");
//		newS.setPassword("aaa");
//		newS.setCity("CSL");
//		
//		em.getTransaction().begin();
//		em.persist(newS);
//		em.getTransaction().commit();

		Student s1 = em.find(Student.class, 101);
		
		System.out.println(s1);
 		// update
//		em.getTransaction().begin();
//		s1.setUsername(s1.getUsername()+"test");
//		em.persist(s1);
//		em.getTransaction().commit();
//		System.out.println(s1);
		
		/*
		// delete
		em.getTransaction().begin();
		em.remove(s1);
		em.getTransaction().commit();
*/
		
		// where name like :user || '%'");
		//Query query = em.createQuery("FROM  Student");
//		Query query = em.createQuery("From Student where username=:user");
//		query.setParameter("user", "suim");
//		List<Student>  sList = (List<Student>)query.getResultList();
//		for (Student student : sList) {			
//			System.out.println(student);
//		}

		
//		Query query = em.createQuery("Select s.username from Student s");
//		List<String>  sList = (List<String>)query.getResultList();
//		for (String student : sList) {			
//			System.out.println(student);
//		}
//		
		em.close();
		emf.close();
	}

}
