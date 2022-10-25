<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Library Item</title>
<style>
body {
	background-color: #f8f8f8;
	margin: 0 auto;
	font-family: Arial;
	color: black;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #38444d;
}

li {
	float: left;
}

li a, .dropbtn {
	display: inline-block;
	color: grey;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
	background-color: white;
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.form-container {
  margin: 3% auto;
  display: block;
  width:500px;
  text-align:center;
}

.form-container input{
  margin-bottom:12px;
}

.form-container .inputButton {
	background-color: pink;
	margin-right: 0 auto;
	margin-left:4.9rem;
	position: relative;
	align-items:center;
	display:flex;
}
</style>
</head>
<body>
	
	<ul>
		<li><a href="login.html">Home</a></li>
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