<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h1>Enter Trainee Details</h1>
	<f:form modelAttribute="trainee" action="save" method="post">
		<table>
			<tr>
				<td>Trainee Id</td>
				<td><f:input path="traineeId" size="15" placeholder="Trainee ID" /> 
					<f:errors path="traineeId" cssStyle="color:red" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Trainee Name</td>
				<td><f:input path="traineeName" size="15" placeholder="Trainee Name" /> 
				<f:errors path="traineeName" cssStyle="color:red" cssClass="error" /></td>
			</tr>
			<tr>
				<td><f:label path="traineeLocation">Trainee Location</f:label></td>
				<td><f:radiobuttons path="traineeLocation" items="${traineeLocation}" /></td>
				<td><f:errors path="traineeLocation" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="domain">Trainee Domain</label></td>
				<td><div>
						<f:select path="domain">
							<f:option value="">Please Select Domain</f:option>
							<f:options items="${domain}" />
						</f:select>
					</div></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="Add Trainee" /></td>
			</tr>
		</table>
	</f:form>

</body>
</html>