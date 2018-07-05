package com.ipd12.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipd12.model.Student;

public class StudentManager {

	//@Autowired
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		System.out.println("inside setStudent "+student);
		this.student = student;
	}
	
	public String callStudentManager() {
		return student.toString();
	}
}

