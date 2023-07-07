<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<title>mtech company Home Page</title>
</head>

<body>
	<h2>mtech company Home Page</h2>
	<p>Welcome to mtech company Home Page</p>

	<!--Add a logout button  -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>