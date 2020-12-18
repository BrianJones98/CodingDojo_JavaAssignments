<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		<link rel="stylesheet" href="/style.css" media="all" />
		<title>Edit <c:out value="${event.name}"></c:out></title>
	</head>
	<body>
		<h1><c:out value="${event.name}"></c:out></h1>
		<h3>Edit Event</h3>
		<form:form action="/events/${event.id}/edit" method="PUT" modelAttribute="event">
			<table class="form-table">
				<tr>
					<td><form:label path="name">Name:</form:label></td>
					<td>
						<form:input path="name"></form:input>
						<form:errors path="name"></form:errors>
					</td>
				</tr>
				<tr>
					<td><form:label path="date">Date:</form:label></td>
					<td>
						<form:input path="date" type="date"></form:input>
						<form:errors path="date"></form:errors>
					</td>
				</tr>
				<tr>
					<td><form:label path="city">Location:</form:label></td>
					<td>
						<form:input path="city"></form:input>
						<form:select path="state">
							<option value="" disabled selected hidden="true">State</option>
							<form:option value="AL">AL</form:option>
							<form:option value="AK">AK</form:option>
							<form:option value="AR">AR</form:option>	
							<form:option value="AZ">AZ</form:option>
							<form:option value="CA">CA</form:option>
							<form:option value="CO">CO</form:option>
							<form:option value="CT">CT</form:option>
							<form:option value="DC">DC</form:option>
							<form:option value="DE">DE</form:option>
							<form:option value="FL">FL</form:option>
							<form:option value="GA">GA</form:option>
							<form:option value="HI">HI</form:option>
							<form:option value="IA">IA</form:option>	
							<form:option value="ID">ID</form:option>
							<form:option value="IL">IL</form:option>
							<form:option value="IN">IN</form:option>
							<form:option value="KS">KS</form:option>
							<form:option value="KY">KY</form:option>
							<form:option value="LA">LA</form:option>
							<form:option value="MA">MA</form:option>
							<form:option value="MD">MD</form:option>
							<form:option value="ME">ME</form:option>
							<form:option value="MI">MI</form:option>
							<form:option value="MN">MN</form:option>
							<form:option value="MO">MO</form:option>	
							<form:option value="MS">MS</form:option>
							<form:option value="MT">MT</form:option>
							<form:option value="NC">NC</form:option>	
							<form:option value="NE">NE</form:option>
							<form:option value="NH">NH</form:option>
							<form:option value="NJ">NJ</form:option>
							<form:option value="NM">NM</form:option>			
							<form:option value="NV">NV</form:option>
							<form:option value="NY">NY</form:option>
							<form:option value="ND">ND</form:option>
							<form:option value="OH">OH</form:option>
							<form:option value="OK">OK</form:option>
							<form:option value="OR">OR</form:option>
							<form:option value="PA">PA</form:option>
							<form:option value="RI">RI</form:option>
							<form:option value="SC">SC</form:option>
							<form:option value="SD">SD</form:option>
							<form:option value="TN">TN</form:option>
							<form:option value="TX">TX</form:option>
							<form:option value="UT">UT</form:option>
							<form:option value="VT">VT</form:option>
							<form:option value="VA">VA</form:option>
							<form:option value="WA">WA</form:option>
							<form:option value="WI">WI</form:option>	
							<form:option value="WV">WV</form:option>
							<form:option value="WY">WY</form:option>
						</form:select>
						<form:errors path="city"></form:errors>
					</td>
				</tr>
			</table>
			<button>Edit</button>
		</form:form>
	</body>
</html>