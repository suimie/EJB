<!DOCTYPE html>
<%@page import="com.ipd12.model.Book"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to School Management System - Library</title>
<script>
	function deleteaction(){
	    alert("Are you sure you want to delete this book ?");
//	    document.delbook.action = "${pageContext.request.contextPath}/deleteBook";
	    document.delbook.submit();
	} 

</script>
<jsp:include page="../../header.jsp"></jsp:include>

<div class="container" >
	<h1 class="text-center text-secondary">Welcome to library</h1><br><br>
	<form action="searchBook">
	    <div class="form-group">
	      <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Book Title for Search">
	    </div>
	</form>
	<%
		String username = (String)session.getAttribute("username");
		List<Book> books = (List<Book>)request.getAttribute("library");
		if(books.size() > 0){
	%>
		<table class="table">
			<thead>
			    <tr>
			      <th scope="col">Book Id</th>
			      <th scope="col">Name</th>
			      <th scope="col">Author</th>
			      <% if(username != null && username.equals("teacher")){ %>
			      	<th scope="col"></th>
			      	<th scope="col"></th>
			      <%} %>
			    </tr>
			  </thead>
		  	<tbody>
		  	<%
		  		for(Book book : books){ %>
		  			<tr>
		  				<td><%=book.getId() %></td>
		  				<td><%=book.getTitle() %></td>
		  				<td><%=book.getAuthorname() %></td>
		  				<% if(username != null && username.equals("teacher")){ %>
						<td scope="col" style="text-align:right">
							<form action="deleteBook" name="delbook" method="post">
								<input type="hidden" id="bId" name="bId" value="<%= book.getId() %>">
								<button type="submit" class="btn btn-sm btn-danger" onclick="javascript:deleteaction();">Delete</button>
							</form>
						</td>
						<td scope="col" style="text-align:right">
							<form action="editBook" name="editbook" method="post">
								<input type="hidden" id="bId" name="bId" value="<%= book.getId() %>">
								<button type="submit" class="btn btn-sm btn-danger">Edit</button>
							</form>
						</td>
					<%} %>
		  			</tr>
		  	<%	}
		  	%>
		  	</tbody>
		</table>
		<% if(username != null && username.equals("teacher")){ %>
			<a href="editBook" class="btn btn-primary">Add Book</a>
		<%} %>
	<%} %>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>
