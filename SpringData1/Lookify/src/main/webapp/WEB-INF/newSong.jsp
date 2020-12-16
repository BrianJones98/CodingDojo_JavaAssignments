<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Song</title>
		<%--Bootstrap--%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		<%--Additional Styling--%>
		<link rel="stylesheet" href="/style.css" media="all" />
	</head>
	<body>
		<header>
			<a href="/dashboard">Dashboard</a>
		</header>
		<form:form action="/songs/new" method="POST" modelAttribute="song">
			<table>
				<tr>
					<td><form:label path="title">Title</form:label></td>
					<td><form:input path="title"></form:input></td>
					<td><form:errors path="title"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="artist">Artist</form:label></td>
					<td><form:input path="artist"></form:input></td>
					<td><form:errors path="artist"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="rating">Rating</form:label></td>
					<td><form:input path="rating" type="number"></form:input></td>
					<td><form:errors path="rating"></form:errors></td>
				</tr>
			</table>
			<button>Add Song</button>
		</form:form>
	</body>
</html>