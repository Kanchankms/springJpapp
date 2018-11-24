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
	<form:form modelAttribute="trainee" action="Update_trainee" >
		<table>
			<tr>
				<td>Update Trainee Id :</td>
				<td><form:input path="traineeId" /></td>
				<td><input type="submit" value="Fetch To Update" /></td>
		</table>
	</form:form>


	<form:form modelAttribute="traineeRes"  action="Update_Persisted_trainee">
		<c:if test="${traineeRes.traineeName != null}">
				Trainee Info
	<table border="2">
				<tr>
					<th>Trainee ID</th>
					<td><form:input path="traineeId" /></td>
				</tr>
				<tr>
					<th>Trainee Name</th>
					<td><form:input path="traineeName" size="15" /></td>
				</tr>
				<tr>
					<th>Trainee Domain</th>
					<td><div>
						<form:select path="domain" required="true">
							<form:option value="">Please Select Domain</form:option>
							<form:options items="${domain}" />
						</form:select>
					</div></td>
			</tr>
			 <tr>
               <td><form:label path = "traineeLocation">Trainee Location</form:label></td>
               	<td><form:radiobuttons element="li" path="traineeLocation" items="${traineeLocation}" /></td>
			</tr> 
				<tr>
					<td colspan="2" align="right">
					<input type="submit" value="Update" /></td>
				</tr>
			</table>
		</c:if>

	</form:form>
</body>
</html>