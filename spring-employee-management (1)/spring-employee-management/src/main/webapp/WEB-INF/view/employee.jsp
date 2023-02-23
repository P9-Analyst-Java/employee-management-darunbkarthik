<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error{
	color :red;
}
.button {
  background-color: #C2E5D3; 
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
  background-color: #C2E5D3; 
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

<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body bgcolor="#F5FFFA" align="center">
	<h1>Add/Update an Employee Record</h1>
	<hr>

	<form:form action="${contextRoot}/employee" method="post"
		modelAttribute="employee">
		<br>
		<table align="center" width=60%>
			<tr>
				<td>Employee No#</td>
				<td><br><form:input path="empId" /><br>
				<form:errors path="empId" cssClass="error"/><br></td>
			</tr>
			<tr>
				<td>Firstname</td>
				<td><br><form:input path="firstName" /><br>
				<form:errors path="firstName" cssClass="error"/><br></td>
				
				<td>Lastname</td>
				<td><br><form:input path="lastName" /><br>
				<form:errors path="lastName" cssClass="error"/><br></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><br><form:input type = "date" data-date-inline-picker="false"
				 data-date-open-on-focus="true" path="dob" placeholder="(YYYY/MM/DD)" /><br><br></td>
				<td>Gender</td>
				<td><br><form:input path="gender" placeholder="M/F" /></td>
			</tr>
			<tr>
				<td>Mobile num</td> 
				<td><br><form:input path="mobileNum" /><br>
				<form:errors path="mobileNum" cssClass="error"/><br></td>
				<td>Email(Personal)</td>
				<td><br><form:input path="personalEmail" /><br>
				<form:errors path="personalEmail" cssClass="error"/><br></td>
				
			</tr>
			<tr>
				<td>Office mail</td>
				<td><br><form:input path="officeMail" /></td>		
			</tr>
			<tr>
				<td>Joining date</td>
				<td><br><form:input type = "date" data-date-inline-picker="false" 
				data-date-open-on-focus="true" path="doj" placeholder="(YYYY/MM/DD)" /><br><br></td>
				<td>Employee Level</td>
				<td><br><form:input path="empLevel" /><br>
				<form:errors path="empLevel" cssClass="error"/><br></td>
			<tr>
				<td>Post</td>
				<td><br><form:input path="postName" /><br>
				<form:errors path="postName" cssClass="error"/><br></td>
				<td>Blood group</td>
				<td><br><form:input path="bloodGroup" /></td>
			</tr>
			<tr>
				<td>Basic pay</td> 
				<td><br><form:input path="basicPay" /><br>
				<form:errors path="basicPay" cssClass="error"/><br></td>
				<td>Home allowance</td>
				<td><br><form:input path="houseAllowance" /><br>
				<form:errors path="houseAllowance" cssClass="error"/><br></td>
			</tr>
			<tr>
				<td>Pan card no</td>
				<td><br><form:input path="panCardNo" /><br>
				<form:errors path="PanCardNo" cssClass="error"/><br></td>
				<td>Aadhaar card no</td>
				<td><br><form:input path="aadhaarCardNo" /><br>
				<form:errors path="aadhaarCardNo" cssClass="error"/><br></td>
			</tr>
			<tr>
				<td>Permanent address</td>
				<td><br><form:input path="permanentAddress" /><br>
				<form:errors path="permanentAddress" cssClass="error"/><br></td>
				<td>Present address</td>
				<td><br><form:input path="presentAddress" /><br>
				<form:errors path="presentAddress" cssClass="error"/><br></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td colspan="2"><button type="submit" class="button">Submit</button></td>
				<td colspan="2">
				<button class="button"><a href="${contextRoot}/" class="line" >Cancel</a></button>
				</td>
			</tr>

		</table>
	</form:form>

</body>
</html>

