<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>View Library Items</title>
	<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@page import="java.util.List"%>  
<%@page import="java.util.ArrayList"%> 
<%@page import="com.model.LibraryList"%> 
<%@page import="java.util.Iterator"%>

	<ul>
		<li><a href="home.html">Home</a></li>
		<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Create</a>
			<div class="dropdown-content">
				<a href="createLibraryItem.html">Library Item</a> <a
					href="createCategoryItem.html">Category Item</a>
			</div></li>
		<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">View</a>
			<div class="dropdown-content">
				<a href="ViewLibraryItemServlet">Library Item</a> <a
					href="ViewCategoryServlet">Category Item</a>
			</div></li>
		<li style="float: right"><a href="login.html">Logout</a></li>
	</ul>

	<div>
		<h2>Library Items List</h2>
	</div>
	
		

<table class="viewTable" border="2" width="80%"> 
 
<tr> 
<th>Title</th> 
<th>Author</th> 

</tr>  
 
<% ArrayList<LibraryList> libraryList = (ArrayList) request.getAttribute("LibraryItems"); %>
<%
// Iterating through subjectList

if(request.getAttribute("LibraryItems") != null)  // Null check for the object
{
	Iterator<LibraryList> iterator = libraryList.iterator();  // Iterator interface
	
	while(iterator.hasNext())  // iterate through all the data until the last record
	{
		LibraryList libDetails = iterator.next(); //assign individual employee record to the employee class object
	%>
	<tr><td><%=libDetails.getTitle()%></td>
		<td><%=libDetails.getAuthor()%></td>
		
	</tr>
	
	<%
	}
}
%>  
 
</table>
	
</body>
</html>