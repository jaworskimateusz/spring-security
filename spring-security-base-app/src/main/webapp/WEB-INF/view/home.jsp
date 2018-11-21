<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
	<title>Fast and furious website</title>
</head>
<body>
	<h2>Fast and furious website</h2>
	<hr>
	<p>Home Page</p>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"> 
	</form:form>
</body>
</html>