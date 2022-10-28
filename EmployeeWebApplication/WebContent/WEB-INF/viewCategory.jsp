<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Category Item</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%--Importing all the dependent classes--%>
	<%@page import="java.util.ArrayList"%>
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
		<p>Category List:</p>
	</div>


	<table  class="viewTable" border="2" width="60%">

		<tr>
			<th>#</th>
			<th>Category Names</th>

		</tr>

		<%
			int i = 1;
			ArrayList<String> list = (ArrayList) request.getAttribute("categorynames");
		%>

		<%
			for (String u : list) {
		%>
		<tr>
			<td><%=i++%></td>
			<td><%=u%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>