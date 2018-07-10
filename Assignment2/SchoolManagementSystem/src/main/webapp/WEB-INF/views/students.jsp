<!DOCTYPE html>
<%@page import="com.ipd12.model.Student"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to School Management System - Library</title>
<script>
	function deleteaction(){
	    alert("Are you sure you want to delete this student ?");
	    document.delstudent.submit();
	} 

</script>
<jsp:include page="../../header.jsp"></jsp:include>

<div class="container" >
	<h1 class="text-center text-secondary">Welcome to student management!</h1><br><br>
	<form action="searchStudent">
	    <div class="form-group">
	      <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Student's firstname or last name for Search">
	    </div>
	</form>
	<%
		String username = (String)session.getAttribute("username");
		List<Student> students = (List<Student>)request.getAttribute("students");
		if(students.size() > 0){
	%>
		<table class="table">
			<thead>
			    <tr>
			      <th scope="col">Student Id</th>
			      <th scope="col">User Name</th>
			      <th scope="col">Password</th>
			      <th scope="col">First Name</th>
			      <th scope="col">Last Name</th>
			      <th scope="col">City</th>
			      <th scope="col">Postal Code</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
		  	<tbody>
		  	<%
		  		for(Student student : students){ %>
		  			<tr>
		  				<td><%=student.getId() %></td>
		  				<td><%=student.getName() %></td>
		  				<td><%=student.getPassword() %></td>
		  				<td><%=student.getFirstname() %></td>
		  				<td><%=student.getLastname() %></td>
		  				<td><%=student.getCity() %></td>
		  				<td><%=student.getPostal() %></td>
		  				<%if(!student.getName().equals("teacher")){ %>
						<td scope="col" style="text-align:right">
							<form action="deleteStudent" name="delstudent" method="post">
								<input type="hidden" id="sId" name="sId" value="<%= student.getId() %>">
								<button type="submit" class="btn btn-sm btn-danger" onclick="javascript:deleteaction();">Delete</button>
							</form>
						</td><%} else{%>
						<td scope="col" style="text-align:right"></td>
						<%} %>
						<td scope="col" style="text-align:right">
							<form action="editStudent" name="editstudent" method="post">
								<input type="hidden" id="sId" name="sId" value="<%= student.getId() %>">
								<button type="submit" class="btn btn-sm btn-danger">Edit</button>
							</form>
						</td>
		  			</tr>
		  	<%	}
		  	%>
		  	</tbody>
		</table>
	<%} %>
		<a href="editStudent" class="btn btn-primary">Add Student</a>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>
