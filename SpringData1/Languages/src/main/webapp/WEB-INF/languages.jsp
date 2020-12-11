<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Languages</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="lang">
				<tr>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.langName}"/></a></td>
					<td><c:out value="${lang.creator}"/></td>
					<td><c:out value="${lang.version}"/></td>
					<td>
						<a href="/languages/edit/${lang.id}">Edit</a>
						<form action="/languages/${lang.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		    				<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/languages" method="post" modelAttribute="language">
			<table>
				<tr>
					<td><form:label path="langName">Name</form:label></td>
					<td>
						<form:input path="langName"/>
						<form:errors path="langName"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="creator">Creator</form:label></td>
					<td>
						<form:input path="creator"/>
						<form:errors path="creator"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="version">Version</form:label></td>
					<td>
						<form:input path="version"/>
						<form:errors path="version"/>
					</td>
				</tr>
			</table>
			
			<button>Submit</button>
		</form:form>
	</body>
</html>