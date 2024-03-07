<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<div>
<form action="SaveServlet" method="Post">
<table>
 <tr>
 	<td>Employee Name</td>
 	<td><input type="text" name="name"></td>
 </tr>
 
 <tr>
 	<td>Employee Password</td>
 	<td><input type="password" name="password"></td>
 </tr>
 
 <tr>
 	<td>Employee Email</td>
 	<td><input type="text" name="email"></td>
 </tr>
 
 <tr>
 	<td>Employee Country</td>
 	<td><select name="country">
 	<option>India</option>
 	<option>UK</option>
 	<option>Other</option>
 	</select>
 	</td>
 </tr>
 
 <tr>
 	<td colspan="2"><input type="submit" value="Save Employee"></td>
 </tr>
</table>
</form>
</div>

<a href="ViewServlet">View Employee</a>
</body>
</html>