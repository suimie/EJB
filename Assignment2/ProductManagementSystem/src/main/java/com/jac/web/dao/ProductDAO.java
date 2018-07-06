package com.jac.web.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.jac.web.model.Product;
import com.jac.web.model.User;

public class ProductDAO {
	public Product getProductUsingName(String name) {
		Product product = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb", "root", "root");
			String query = "select * from product where name=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			
			ResultSet rs = st.executeQuery();
			
			String result = "Product not found";

			product = new Product();
			if(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				BigDecimal priceFromDB = rs.getBigDecimal("price");
			
				product.setId(idFromDB);
				product.setName(nameFromDB);
				product.setPrice(priceFromDB);
				
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return product;
	}
	
	
	public Product getProductUsingId(int id) {
		Product product = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb", "root", "root");
			String query = "select * from product where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			
			String result = "Product not found";

			product = new Product();
			if(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				BigDecimal priceFromDB = rs.getBigDecimal("price");
			
				product.setId(idFromDB);
				product.setName(nameFromDB);
				product.setPrice(priceFromDB);
				
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return product;
	}
	
	
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb?autoReconnect=true&useLegacyDatetimeCode=false&serverTimezone=MST", "root", "root");
			String query = "select * from product";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			

			while(rs.next()) {
				int idFromDB = rs.getInt("id");
				String nameFromDB = rs.getString("name");
				BigDecimal priceFromDB = rs.getBigDecimal("price");
			
				Product product = new Product();
				product.setId(idFromDB);
				product.setName(nameFromDB);
				product.setPrice(priceFromDB);
				
				productList.add(product);
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return productList;
	}
	
	public void addProduct(String name, BigDecimal price) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb?autoReconnect=true&useLegacyDatetimeCode=false&serverTimezone=MST", "root", "root");
	
			String sql = "INSERT INTO product (name, price) VALUES (?, ?)";

        	PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setBigDecimal(2, price);

            stmt.executeUpdate();
        }catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	public void deleteProduct(int id)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejbdb?autoReconnect=true&useLegacyDatetimeCode=false&serverTimezone=MST", "root", "root");
	
	        String sql = "DELETE FROM product WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setInt(1, id);            
	            stmt.executeUpdate();
        }catch(Exception e) {
			e.printStackTrace();
		}
    }
}
