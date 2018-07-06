package com.ipd12.service;

import com.ipd12.model.Student;

public class StudentManager {

	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String callStudentManager() {
		return student.toString();
	}
}
