<!DOCTYPE html>
<%@page import="com.ipd12.model.Book"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome to School Management System - Edit Book</title>

<jsp:include page="../../header.jsp"></jsp:include>

<div class="container" style="width:600px;">
	<form action="saveBook" method="post">
	  <fieldset>
	    <legend>Enter information of new book </legend>
	    
   		<% String error = (String)request.getAttribute("error");
		if(error != null && error != ""){%>
			<p class="text-danger"><%= error %></p>
		<% }
		Book book = (Book)request.getAttribute("bookinfo");
		if(book == null){
			book = new Book();
			book.setId(0);
			book.setTitle("");
			book.setAuthorname("");
		}
		%>
		
		<input type="hidden" id="bId" name="bId" value="<%=book.getId()%>">
	    <div class="form-group">
	      <label for="title">Title</label>
	      <input type="text" class="form-control" id="title" name="title" placeholder="Title" value="<%= book.getTitle() %>">
		</div>
	    <div class="form-group">
	      <label for="authorname">Author</label>
	      <input type="text" class="form-control" id="authorname" name="authorname" placeholder="Author"
	      					value="<%=book.getAuthorname() %>">
	    </div>
	    <button type="submit" class="btn btn-primary">Save</button>
	  </fieldset>
	</form>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>
