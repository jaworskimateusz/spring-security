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
	Role(s): <security:authentication property="principal.authorities"/> <hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST" >
		<input type="submit" value="Logout" >
	</form:form>
</body>
</html>