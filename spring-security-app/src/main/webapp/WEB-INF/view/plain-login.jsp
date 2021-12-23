<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Login Page</title>
<style type="text/css">
.failed {
	color: red;
}
</style>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticatedTheUser"
		method="POST">

		<c:if test="${param.error != null }">
			<i class="failed">Sorry! You Entered invalid username/password.</i>
		</c:if>
		<p>
			User Name: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>