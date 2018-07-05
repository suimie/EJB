package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jac.web.model.Student;

public class StudentDAO {

	public Student getStudent(String username) {
		Student s1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentTest", "root", "root");
			String query = "select * from student2 where username=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				s1 = new Student();
				String nameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
				
				s1.setUsername(nameFromDB);
				s1.setPassword(passwordFromDB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
}
