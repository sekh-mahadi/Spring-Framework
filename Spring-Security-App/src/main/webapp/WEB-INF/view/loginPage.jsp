<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Welcome to Login Page</title>
<style type="text/css">
.failed {
	color: red;
}
</style>
</head>
<body>
	<h3>Custom Login Page</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

		<!-- Check for login error -->
		<c:if test="${param.error !=null }">
			<i class="failed"> Sorry! You have entered invalid username/password</i>
		</c:if>

		<p>User Name: <input type="text" name="username" /></p>
		<p>Password: <input type="text" name="password" /></p>

		<input type="submit" value="Login" />
	</form:form>
</body>
</html>