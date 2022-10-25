<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Library Item</title>
<style>
body {
	background-color: #f8f8f8;
	margin: 0 auto;
	font-family: Arial;
	font-size:14px;
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
	width: 500px;
	text-align: center;
}

.form-container input {
	margin-bottom: 12px;
}

.form-container .inputButton {
	background-color: pink;
	margin-right: 0 auto;
	margin-left: 4.9rem;
	position: relative;
	align-items: center;
	display: flex;
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

	<div class="container">
		<div class="form-container">
		<div class="headerDiv">
			<h1 class="headerClass"
			style="color: #0B3A38; position: relative; display: flex; justify-content: center;">Fill
			the form to create a library item</h1>
		</div>
		  <form action="create-libraryItem" method="post">
				<table>
					<tr>
						<td><font face="verdana" size="2px">Title:</font></td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td><font face="verdana" size="2px">Author:</font></td>
						<td><input type="text" name="author"></td>
					</tr>
					<tr>
						<td><font face="verdana" size="2px">Pages:</font></td>
						<td><input type="text" name="pages"></td>
					</tr>
					<tr>
					<td><font face="verdana" size="2px">Category Name:</font></td>
					<td>
							<select name="types" id="types">
								<option value="Book">Book</option>
								<option value="Reference">Reference Book</option>
								<option value="DVD">DVD</option>
								<option value="Audio">Audio Book</option>
							</select>
						</td>
						</tr>
						
					<tr>
						<td><font face="verdana" size="2px">Category Name:</font></td>
						<td><input type="text" name="catName"></td>
					</tr>
						
					<tr>
						<td><font face="verdana" size="2px">RunTimeMinutes:</font></td>
						<td><input type="text" name="runTimeMinutes"></td>
					</tr>

					<tr>
						<td><font face="verdana" size="2px">IsBorro:</font> <label>
								<input type="radio" name="isBorrowable" id="" value="True">Yes
						</label></td>

						<td><label> <input type="radio" name="isBorrowable"
								id="" value="False">No
						</label></td>
					</tr>

					<tr>
						<td><font face="verdana" size="2px">Borrower:</font></td>
						<td><input type="text" name="borrower"></td>
					</tr>
					<tr>
						<td><font face="verdana" size="2px">BorrowDate:</font></td>
						<td><input type="date" name="borrowDate" value="2018-07-22"/></td>
					</tr>

					<tr>
						<td><font face="verdana" size="2px">Type:</font></td>
						<td><select name="types" id="types">
								<option value="Book">Book</option>
								<option value="Reference">Reference Book</option>
								<option value="DVD">DVD</option>
								<option value="Audio">Audio Book</option>
						</select></td>
					</tr>

				</table>

				<input class="inputButton" type="submit" value="Create"> 
				
				<input class="inputButton" type="reset" value="Cancel" onclick="home.html"/>
			</form>
		</div>
	</div>
</body>
</html>