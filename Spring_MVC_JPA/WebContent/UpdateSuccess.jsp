<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully Added Trainee Details</title>
</head>

<body>

Hi,Updated Values are:
<form:form> 
		<c:if test="${traineeRes.traineeName != null}">
Trainee Info
<c:out value="${traineeRes.traineeName}"></c:out>
			<table border="3">
		
					<tr>
						<th bgcolor="bisque">Trainee Id</th>
						<th bgcolor="bisque">Trainee Name</th>
						<th bgcolor="bisque">Trainee Domain</th>
						<th bgcolor="bisque">Trainee Location</th>
					</tr>
					<tr>
						<td><c:out value="${traineeRes.traineeId}"></c:out></td>
						<td><c:out value="${traineeRes.traineeName}"></c:out></td>
						<td><c:out value="${traineeRes.domain}"></c:out></td>
						<td><c:out value="${traineeRes.traineeLocation}"></c:out></td>
					</tr>

					<tr>
						<td colspan="5" align="center">
						<a href="index.jsp">Click Here To Go to Home</a>
						</td>
					</tr>
				</table>
		</c:if>
	</form:form>
<a href="Welcome.jsp">Click here to go to Main Menu</a>

</body>
</html>