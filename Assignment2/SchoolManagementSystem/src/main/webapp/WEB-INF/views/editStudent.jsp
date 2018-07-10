<!DOCTYPE html>
<%@page import="com.ipd12.model.Student"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to School Management System - Edit Student</title>

<jsp:include page="../../header.jsp"></jsp:include>

<div class="container"  style="width:600px;">
	<form action="saveStudent" method="post">
	  <fieldset>
	    <legend>Enter information of new student </legend>
	    
   		<% String error = (String)request.getAttribute("error");
		if(error != null && error != ""){%>
			<p class="text-danger"><%= error %></p>
		<% }
		Student student = (Student)request.getAttribute("studentinfo");
		if(student == null){
			student = new Student();
			student.setId(0);
			student.setName("");
			student.setPassword("");
			student.setFirstname("");
			student.setLastname("");
			student.setCity("");
			student.setPostal("");
		}
		%>
		
		<input type="hidden" id="sId" name="sId" value="<%=student.getId()%>">
	    <div class="form-group">
	      <label for="name">User Name</label>
	      <input type="text" class="form-control" id="name" name="name" placeholder="Title" value="<%= student.getName() %>">
		</div>
	    <div class="form-group">
	      <label for="password">Password</label>
	      <input type="password" class="form-control" id="password" name="password" placeholder="Author"
	      					value="<%=student.getPassword() %>">
	    </div>
	    <div class="form-group">
	      <label for="firstname">First Name</label>
	      <input type="text" class="form-control" id=""firstname"" name="firstname" placeholder="First Name" value="<%= student.getFirstname() %>">
		</div>
	    <div class="form-group">
	      <label for="lastname">Last Name</label>
	      <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Last Name" value="<%= student.getLastname() %>">
		</div>
	    <div class="form-group">
	      <label for="city">City</label>
	      <input type="text" class="form-control" id="city" name="city" placeholder="City" value="<%= student.getCity() %>">
		</div>
	    <div class="form-group">
	      <label for="postal">Postal Code</label>
	      <input type="text" class="form-control" id="postal" name="postal" placeholder="Postal Code" value="<%= student.getPostal() %>">
		</div>
	    <button type="submit" class="btn btn-primary">Save</button>
	  </fieldset>
	</form>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>
