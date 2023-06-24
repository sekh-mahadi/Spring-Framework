<!DOCTYPE htm>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Manager</h2>
	</div>
</div>
	<div id="continer">
		<div id="content">
			<!-- put new button: Add Customer --> <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button" /> <!-- add out html table -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
			</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<!--  Display the update Link-->
						<td><a href="${updateLink}">Update</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>
</div>
	<h1>List Customers---Coming Soon.</h1>
</body>
</html>