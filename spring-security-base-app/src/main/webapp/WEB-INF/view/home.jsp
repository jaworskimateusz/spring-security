<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
	<h2>Home page</h2>
	<hr>
	Welcome to our company home page.
	<br>
	
	<!-- Display current user id(who is logged in) -->
	User: <security:authentication property="principal.username"/> <br>
	Role(s): <security:authentication property="principal.authorities"/> <br>
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Manager)<br>
	</security:authorize>
	
	<security:authorize access="hasRole('HR')">
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>(Only for Admin)<hr>
	</security:authorize>
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST" >
		<input type="submit" value="Logout" >
	</form:form>
</body>
</html>