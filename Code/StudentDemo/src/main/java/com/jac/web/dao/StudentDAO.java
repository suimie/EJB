package com.jac.web.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jac.web.model.Student;

public class StudentDAO {

	public Student getStudent(String username) {
		Student s1 = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb", "root", "root");
			String query = "select * from student2 where username=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			
			String result = "User not found";

			s1 = new Student();
			if(rs.next()) {
				String nameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
			
				s1.setUsername(nameFromDB);
				s1.setPassword(passwordFromDB);
				
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return s1;
	}
}
