<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Dojo</title>
	</head>
	<body>
		<h1>New Dojo</h1>
		<form:form method="post" action="/dojos/new" modelAttribute="dojo">
			<table>
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td><form:input path="name"></form:input></td>
					<td><form:errors path="name"></form:errors></td>
				</tr>
			</table>
			<button>Create</button>
		</form:form>
	</body>
</html>