<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ninja Gold</title>
		<link rel="stylesheet" href="style.css" media="all" />
	</head>
	<body>
		<h1>Your Gold: <c:out value="${gold}"/></h1>
		<div id="actions">
			<div>
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="action" value="farm"/>
					<button>Find Gold!</button>
				</form>
			</div>
			<div>
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="action" value="cave"/>
					<button>Find Gold!</button>
				</form>
			</div>
			<div>
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="action" value="house"/>
					<button>Find Gold!</button>
				</form>
			</div>
			<div>
				<h2>Casino</h2>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="action" value="casino"/>
					<button>Find Gold!</button>
				</form>
			</div>
			<div>
				<h2>Spa</h2>
				<p>(takes 5-20 gold)</p>
				<form action="/process" method="post">
					<input type="hidden" name="action" value="spa"/>
					<button>Find Gold!</button>
				</form>
			</div>
		</div>
		<h1>Activities:</h1>
		<div id="activities">
			${activities}
		</div>
		<a href="/reset" id='button-link'>Reset</a>
	</body>
</html>