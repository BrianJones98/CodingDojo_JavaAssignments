<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><c:out value="${language.langName}"/></title>
	</head>
	<body>
		<h1><c:out value="${language.langName}"/></h1>
		<h2>Creator: <c:out value="${language.creator}"/></h2>
		<h2>Version: <c:out value="${language.version}"/></h2>
		
		<a href="/languages/edit/${language.id}">Edit</a>
		<br>
		<a href="/languages/delete/${language.id}">Delete</a>
	</body>
</html>