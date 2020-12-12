<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Person</title>
	</head>
	<body>
		<h1>New Person</h1>
		<form:form action="/person/new" method="POST" modelAttribute="person">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName"></form:input></td>
				<td><form:errors path="firstName"></form:errors></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName"></form:input></td>
				<td><form:errors path="lastName"></form:errors></td>
			</tr>
		</table>
		<button>Create</button>
		</form:form>
	</body>
</html>