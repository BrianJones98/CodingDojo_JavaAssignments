<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Ninja</title>
	</head>
	<body>
		<h1>New Ninja</h1>
		
		<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
			<table>
				<tr>
					<td><form:label path="dojo">Dojo:</form:label></td>
					<td>
						<form:select path="dojo">
							<option value="" disabled selected hidden="true">--Choose a Dojo--</option>
							<c:forEach items="${dojos}" var="dojo">
								<form:option value="${dojo}">
									<c:out value="${dojo.name}"></c:out>
								</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td><form:errors path="dojo"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="firstName">First Name:</form:label></td>
					<td><form:input path="firstName"></form:input></td>
					<td><form:errors path="firstName"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name:</form:label></td>
					<td><form:input path="lastName"></form:input></td>
					<td><form:errors path="lastName"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="age">Age:</form:label></td>
					<td><form:input path="age"></form:input></td>
					<td><form:errors path="age"></form:errors></td>
				</tr>
				
			</table>
			<button>Create</button>
		</form:form>
	</body>
</html>