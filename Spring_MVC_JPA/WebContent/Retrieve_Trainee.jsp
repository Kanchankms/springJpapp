<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="trainee" action="retrieve_Trainee">
		<table>
			<tr>
				<td>Retrieve Trainee Id :</td>
				<td><form:input path="traineeId" /></td>
				<td><input type="submit" value="Fetch Trainee" /></td>
		</table>
		${message}
	</form:form>
</body>
</html>