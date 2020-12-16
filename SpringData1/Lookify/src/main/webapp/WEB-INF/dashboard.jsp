<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lookify!</title>
		<%--Bootstrap--%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		<%--Additional Styling--%>
		<link rel="stylesheet" href="/style.css" media="all" />
	</head>
	<body>
		<header>
			<div id="links">
				<a href="/songs/new">Add New</a>
				<a href="/search/top-ten">Top Songs</a>
			</div>
			<form action="/search" method="POST">
				<input type="text" placeholder="Enter an Artist" name="search" />
				<button>Search Artists</button>
			</form>
		</header>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
						<td><c:out value="${song.rating}"></c:out></td>
						<td><a href="/delete/${song.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</thead>
		</table>
	</body>
</html>