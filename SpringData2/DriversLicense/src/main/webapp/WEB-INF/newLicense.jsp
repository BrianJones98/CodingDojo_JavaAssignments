<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New License</title>
	</head>
	<body>
		<h1>New License</h1>
		<form:form method="POST" action="/licenses/new" modelAttribute="license">
			<table>
				<tr>
					<td><form:label path="person">Person:</form:label></td>
					<td>
						<form:select path="person">
							<option value="" disabled selected hidden="true">--Select a Person--</option>
							<c:forEach items="${persons}" var="person">
								<c:if test="${person.getLicense() == null}">
									<form:option value="${person}" label="${person.getFirstName()} ${person.getLastName()}"/>
								</c:if>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="state">State:</form:label></td>
					<td><form:input path="state"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="expirationDate">Expiration Date:</form:label></td>
					<td><form:input type="date" path="expirationDate"></form:input></td>
				</tr>
			</table>
			<button>Create</button>
		</form:form>
	</body>
</html>