<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
<style type="text/css">
.button {
  background-color: #FFD700; 
  border: none;
  color: black;
  font-weight:bold;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 12px;
  margin-right: 10px;
}
.button1 {
  background-color: #F5FFFA; 
  border: none;
  color: black;
  font-weight:bold;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 12px;
  margin-right: 10px;
}

.button:hover {
  color: blue;
}
.line{
	text-decoration: none;
	color: black;
}
.line:hover{
  color: blue;
}
</style>
</head>
<body bgcolor="#FFE5B4" >
	<h1 align="center">Employee Search List Screen</h1>
	<hr>
	<br>
	<br>
	<form action="/search" method="post" class="form1">
		<table align="center">

			<tr>
				<td>Employee ID:</td>
				<td><input type="number" id="empId" name="empId" placeholder="Enter Id" class="button1" /></td>
				<td></td>
				<td>Employee Name:</td>
				<td><input type="text" id="firstname" name="firstname" placeholder="Enter name" class="button1" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td colspan="5" align="center" ><button type="submit" value="submit" class="button" >Submit</button></td>
			</tr>
		</table>
	</form>
	<br>
	<hr><br><br>

	<div class="navi" align="center">
		<button class="button"><a href="${contextRoot}/employee" id="a1" class="line">Add New Employee</a></button>
		<button class="button"><a href="${contextRoot}/export" class="line">Export as CSV</a></button>
	</div>
	<br>
	<br>
	<table align="center" border=1px solid black width=100%;>
		<tr>
			<th>Employee</th>
			<th>Contact</th>
			<th>Level & Post</th>
			<th>Action</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr align="center">
				<td>#${employee.empId}<br>${employee.firstName}
					${employee.lastName}
				</td>
				<td>${employee.mobileNum}<br>${employee.personalEmail}</td>
				<td>${employee.empLevel}<br>${employee.postName}</td>
				<td><a href="${contextRoot}/employments/${employee.empId}">Employments</a>/
					<a href="${contextRoot}/employee/${employee.empId}">Edit</a>/ <a
					href="${contextRoot}/${employee.empId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>