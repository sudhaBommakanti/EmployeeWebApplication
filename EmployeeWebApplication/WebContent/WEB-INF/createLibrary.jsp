<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Library Item</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
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
		
		<p style="margin-left: 15px">${result}</p>
	
	</div>
	
	
</body>
</html>