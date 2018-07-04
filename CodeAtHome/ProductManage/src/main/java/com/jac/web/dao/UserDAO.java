package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jac.web.model.User;

public class UserDAO {
	public User getUser(String username) {
		User user = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb", "root", "root");
			String query = "select * from user where username=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			
			String result = "User not found";

			user = new User();
			if(rs.next()) {
				String nameFromDB = rs.getString("username");
				String passwordFromDB = rs.getString("password");
			
				user.setUsername(nameFromDB);
				user.setPassword(passwordFromDB);
				
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return user;
	}

}
