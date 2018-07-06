package com.ipd12.DAO;

import com.ipd12.model.Student;

public class StudentDAO {

	public Student getStudentByStudentID(int ID) {
		Student student = new Student();
		student.setUsername("user1");
		student.setPassword("pass1");
		student.setCity("Montreal");
		return student;
	}
}
