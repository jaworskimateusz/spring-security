<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<html>
<head>
	<title>Fast and furious website</title>
</head>
<body>
	<h2>Fast and furious website</h2>
	<hr>
	<p>Home Page</p>
	<br>
	<security:authentication property="principal.username"/>
	<security:authentication property="principal.authorities"/>
	<a href="${pageContext.request.contextPath}/crew">Crew</a><br>
	<a href="${pageContext.request.contextPath}/enemy">Enemy</a><br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"> 
	</form:form>
</body>
</html>