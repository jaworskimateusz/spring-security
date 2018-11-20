<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
	<h2>Home page</h2>
	<hr>
	Welcome to our company home page.
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST" >
		<input type="submit" value="Logout" >
	</form:form>
</body>
</html>