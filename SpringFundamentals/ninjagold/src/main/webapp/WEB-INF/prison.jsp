<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Prison</title>
		<link rel="stylesheet" href="style.css" media="all" />
	</head>
	<body>
		<div id="loss-message">
			<h1>Sorry!</h1>
			<h2>You have been sent to a debtor's prison due to your extreme debt.</h2>
			<a href="/reset" id='button-link'>Click to play again!</a>
		</div>
	</body>
</html>