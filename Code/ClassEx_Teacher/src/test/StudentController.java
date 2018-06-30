package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String ID = request.getParameter("id");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentTest", "root", "root");
			String query = "select * from student where name=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, uname);
			
			ResultSet rs = st.executeQuery();
			String result = "User not found";
			if(rs.next()) {
				String nameFromDB = rs.getString("name");
				String IDFromDB = rs.getString("id");
				
				result = "user found and details are "
						+ "\n Name: "+nameFromDB+" "
								+ "and \n ID: "+IDFromDB;
			}
			PrintWriter pw = response.getWriter();
			pw.write("<html>\r\n" + 
					"<head>\r\n" + 
					"<title>Result page</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" +
					result+
					"</body>\r\n" + 
					"</html>");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
