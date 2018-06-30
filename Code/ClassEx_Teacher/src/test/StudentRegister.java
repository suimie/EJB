package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<form method=\"post\" action=\"register\">\r\n" + 
				"		Username: <input type=\"text\" name=\"uname\" /> \r\n" + 
				"		Password: <input type=\"password\" name=\"id\" />\r\n" + 
				"		<button type=\"submit\">Register</button>\r\n" + 
				"	</form>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		int ID = Integer.parseInt(request.getParameter("id"));
		
		Student s1 = new Student();
		s1.setName(uname);
		s1.setStudentID(ID);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentTest", "root", "root");
			String query = "insert into student values(?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, s1.getName());
			st.setInt(2, s1.getStudentID());
			
			int res = st.executeUpdate();
			String result = "User save was not successful";
			if(res == 1) {
				result = "User successfully saved!";
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

}
