<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employment History</title>
</head>
<body>
	<h1>Employee History Screen</h1>
	<h2>${name.firstName} ${name.lastName}(#${name.empId})</h2>
	<hr>

	<br>

	<table align="center" width=50% border=1px solid black width=100%;>
		<tr>
			<th>Organization</th>
			<th>Period</th>
			<th>Location</th>
			<th>Post</th>
		</tr>
		<c:forEach var="history" items="${employeehistory}">
			<tr align="center">
				<td>${history.organization_name}<br></td>
				<td>${history.from_date}~ ${history.until_date}</td>
				<td>${history.location}(${history.country})</td>
				<td>${history.post}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>