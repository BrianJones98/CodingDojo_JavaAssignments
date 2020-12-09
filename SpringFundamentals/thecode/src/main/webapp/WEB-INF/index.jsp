<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Secret Code</title>
		<link rel="stylesheet" href="style.css" media="all" />
	</head>
	<body>
		<p id="red"><c:out value="${error}"/></p>
		<p>What is the code?</p>
		<form action="/tryCode" method="POST">
			<input type="text" name="code" id="code">
			<button>Try Code</button>
		</form>
	</body>
</html>