<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DELETE TRAIEEE PAGE</title>
</head>

<body>
	<form action="del_Trainee">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="traineeid" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete Trainee" /></td>
			</tr>
		</table>

	</form>
	<!-- ====================================================================== -->
	<form:form modelAttribute="traineeDel" action="del_Trainee">
		<c:if test="${traineeDel.traineeName != null}">
				Trainee Info
		<c:out value="${traineeDel.traineeName}"></c:out>
			<table border="3">

				<tr>
					<th bgcolor="bisque">Trainee Id</th>
					<th bgcolor="bisque">Trainee Name</th>
					<th bgcolor="bisque">Trainee Domain</th>
					<th bgcolor="bisque">Trainee Location</th>
				</tr>
				<tr>
					<td><c:out value="${traineeDel.traineeId}"></c:out></td>
					<td><c:out value="${traineeDel.traineeName}"></c:out></td>
					<td><c:out value="${traineeDel.domain}"></c:out></td>
					<td><c:out value="${traineeDel.traineeLocation}"></c:out></td>
				</tr>

				<tr>
					<td colspan="5" align="center"><input type="submit"
						name="Delete" value="Delete"></td>
				</tr>
			</table>
		</c:if>
	</form:form>

</body>
</html>