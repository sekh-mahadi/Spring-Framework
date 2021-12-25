<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<!--  Add a logout Button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>


</body>
</html>