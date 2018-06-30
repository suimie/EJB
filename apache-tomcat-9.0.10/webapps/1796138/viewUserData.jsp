<%@page import="UserInfo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>EJB Assignment1 - Suim Park(1796138)</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</head>
<body>		
	<div class="container">
		<h1>EJB Assignment1 - Suim Park(1796138)</h1><br><br>
		<h2>User Information from file(userdata.txt)</h2>
		
		<% User userdata =  (User) request.getAttribute("userdata"); %>
		<table class="table">
		  <tbody>
		    <tr>
		      <th scope="row">User ID</th>
		      <td><%= userdata.getUserID() %></td>
		    </tr>
		    <tr>
		      <th scope="row">User Name</th>
		      <td><%= userdata.getUserName() %></td>
		    </tr>
		    <tr>
		      <th scope="row">Password</th>
		      <td><%= userdata.getPassword() %></td>
		    </tr>
		    <tr>
		      <th scope="row">Email</th>
		      <td><%= userdata.getEmail() %></td>
		    </tr>
		    <tr>
		      <th scope="row">City</th>
		      <td><%= userdata.getCity() %></td>
		    </tr>
		    <tr>
		      <th scope="row">Zip Code</th>
		      <td><%= userdata.getZipcode() %></td>
		    </tr>		    
   		  </tbody>
		</table>

	</div>
</body>
</html>