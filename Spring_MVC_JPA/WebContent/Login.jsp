<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<c:url var="myAction" value="/validate" />
<body>
	<h1>Login Page</h1>
	<form:form modelAttribute="login" action="${myAction}">
		<table>
			<tr>
				<th><form:label path="userName">User name:</form:label></th>
				<td><form:input path="userName" placeholder="UserName"/> 
				    <form:errors path="userName" cssStyle="color:red" cssClass="error"/></td>
			</tr>
			<tr>
				<th><form:label path="password" >Password:</form:label></th>
				<td><form:password path="password" placeholder="Password"/> <br /> 
				    <form:errors path="password" cssStyle="color:red" cssClass="error"/></td>
			</tr>
			<tr><td>${msg}</td></tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>