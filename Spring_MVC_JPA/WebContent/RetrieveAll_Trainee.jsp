<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th bgcolor="bisque">Trainee Id</th>
		<th bgcolor="bisque">Trainee Name</th>
		<th bgcolor="bisque">Trainee Domain</th>
		<th bgcolor="bisque">Trainee Location</th>
	</tr>
	<c:forEach var="traineeList" items="${traineeList}">
	<tr>		
	<td><c:out value="${traineeList.traineeId}"></c:out></td>
	<td><c:out value="${traineeList.traineeName}"></c:out></td>
	<td><c:out value="${traineeList.domain}"></c:out></td>
	<td><c:out value="${traineeList.traineeLocation}"></c:out></td>
	
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center"><a href="index.jsp">Click Here To Go to Home</a></td>
	</tr>
	</table>
</body>
</html>
