<%@ taglib
	prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib
	prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<title>mtech company Home Page</title>
</head>

<body>
	<h2>mtech company Home Page</h2>
	<p>Welcome to mtech company Home Page</p>
	<hr>
	<!--Display  user name and role -->
	<p>User: <security:authentication property="principal.username" /> <br> <br> Role(s): <security:authentication property="principal.authorities" /> <!--Add a logout button  -->
		<form:form
			action="${pageContext.request.contextPath}/logout"
			method="POST">

			<!-- Add a link to point /leaders ....this is for manager -->
			<security:authorize access="hasRole('MANAGER')">
				<p><a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a> (Only for Manager peeps)</p>
			</security:authorize>

			<!-- Add a link to point /leaders ....this is for manager -->
			<security:authorize access="hasRole('ADMIN')">
				<p><a href="${pageContext.request.contextPath}/systems">IT System Meeting</a> (Only for ADMIN peeps)</p>
			</security:authorize>
			<hr>
			<input
				type="submit"
				value="Logout" />
		</form:form>
</body>
</html>