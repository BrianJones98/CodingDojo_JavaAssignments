<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Counter</title>
		<link rel="stylesheet" href="style.css" />
	</head>
	<body>
	<p>You have visited <a href="/">http://localhost:8080</a> <c:out value="${count}"/> times.</p>
	<a href="/">Test another visit?</a>
	<a href="/plusTwo">Increment by two</a>
	<a href="/reset">Reset Counter</a>
	</body>
</html>