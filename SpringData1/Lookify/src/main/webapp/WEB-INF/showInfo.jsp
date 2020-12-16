<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><c:out value="${song.title}"></c:out> | Info</title>
		<%--Bootstrap--%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		<%--Additional Styling--%>
		<link rel="stylesheet" href="/style.css" media="all" />
	</head>
	<body>
		<header>
			<a href="/dashboard">Dashboard</a>
		</header>
		<table class="table">
			<tr>
				<td>Title</td>
				<td><c:out value="${song.title}"></c:out></td>
			</tr>
			<tr>
				<td>Artist</td>
				<td><c:out value="${song.artist}"></c:out></td>
			</tr>
			<tr>
				<td>Rating</td>
				<td><c:out value="${song.rating}"></c:out></td>
			</tr>
		</table>
		<a href="/delete/${song.id}">Delete</a>
	</body>
</html>