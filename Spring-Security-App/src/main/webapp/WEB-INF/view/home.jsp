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
	<hr>
	<p>User: <security:authentication property="principal.username" /> <br> <br> Role(s): <security:authentication property="principal.authorities" /> <!--Add a logout button  -->
		<form:form
			action="${pageContext.request.contextPath}/logout"
			method="POST">

			<input
				type="submit"
				value="Logout" />
			<hr>
			<!-- Add a link to point /leaders ....this is for manager -->
			<p><a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(Only for Manager peeps)
			</p>
			<hr>
			<!-- Add a link to point /leaders ....this is for manager -->
			<p><a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
			(Only for ADMIN peeps)
			</p>
		</form:form>
</body>
</html>