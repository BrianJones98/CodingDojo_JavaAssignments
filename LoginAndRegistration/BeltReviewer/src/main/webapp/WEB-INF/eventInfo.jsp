<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		<link rel="stylesheet" href="/style.css" media="all" />
		<title><c:out value="${event.name}"></c:out></title>
	</head>
	<body>
		<h1><c:out value="${event.name}"></c:out></h1>
		<div id="wrapper">
			<div id="event-info">
				<ul>
					<li><strong>Host: <c:out value="${event.host.fName}"></c:out> <c:out value="${event.host.lName}"></c:out></strong></li>
					<li><strong>Date: <fmt:formatDate value="${event.date}" pattern="MM-dd-yyyy" /></strong></li>
					<li><strong>Location: <c:out value="${event.city}"></c:out>, <c:out value="${event.state}"></c:out></strong></li>
					<li><strong>People who are attending this event:</strong> <c:out value="${event.participants.size()}"></c:out></li>
				</ul>
				<table class="table" id="participant-table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.participants}" var="participant">
							<tr>
								<td><c:out value="${participant.fName}"></c:out> <c:out value="${participant.lName}"></c:out></td>
								<td><c:out value="${participant.city}"></c:out>, <c:out value="${participant.state}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="message-wall">
				<h2>Message Wall</h2>
				<div id="messages">
					<c:forEach items="${event.messages}" var="message">
						<p><strong><c:out value="${message.poster.fName}"></c:out> says:</strong> <c:out value="${message.text}"></c:out></p>
						<p>--------------------------------------------------</p>
					</c:forEach>
				</div>
				<form:form action="/events/${event.id}" method="POST" modelAttribute="message">
					<form:label path="text">Add Comment:</form:label><br>
					<form:textarea path="text" rows="5" cols="50"></form:textarea>
					<button>Submit</button>
				</form:form>
			</div>
		</div>
	</body>
</html>