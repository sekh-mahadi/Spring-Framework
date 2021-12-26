<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MTech Company Home Page</title>
</head>
<body>
	<h2>MTech Company Home Page--Yoohoo!!!</h2>
	<hr>
	<p>Welcome to the MTech Company Home Page!</p>

	<!-- Display User name and Role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath }/leaders">LeaderShip
				Meeting</a> (Only for manager Peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /systems .... this is for the admin -->
		<a href="${pageContext.request.contextPath }/systems">IT System
			Meeting</a> (Only for Admins Peeps)
			
	</security:authorize>
	<!--  Add a logout Button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>