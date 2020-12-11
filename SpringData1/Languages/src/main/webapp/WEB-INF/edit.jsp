<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit <c:out value="${language.langName}"/></title>
	</head>
	<body>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
		<a href="/languages">Dashboard</a>
		
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<table>
				<tr>
					<td><form:label path="langName">Name</form:label></td>
					<td><form:input path="langName"></form:input></td>
					<td><form:errors path="langName"/></td>
				</tr>
				<tr>
					<td><form:label path="creator">Creator</form:label></td>
					<td><form:input path="creator"></form:input></td>
					<td><form:errors path="creator"/></td>
				</tr>
				<tr>
					<td><form:label path="version">Version</form:label></td>
					<td><form:input path="version"></form:input></td>
					<td><form:errors path="version"/></td>
				</tr>
			</table>
			<button>Submit</button>
		</form:form>
	</body>
</html>