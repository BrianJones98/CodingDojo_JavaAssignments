<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><c:out value="${person.firstName}"/></title>
	</head>
	<body>
		<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
		<table>
			<tr>
				<td>License Number:</td>
				<td><c:out value="${person.license.getNumber()}"></c:out></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><c:out value="${person.license.getState()}"></c:out></td>
			</tr>
			<tr>
				<td>Expiration Date:</td>
				<td><c:out value="${person.license.getExpirationDate()}"></c:out></td>
			</tr>
		</table>
	</body>
</html>