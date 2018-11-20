<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Fast and furious login page</title>
</head>
<body>
	<h2>Fast and furious members login page</h2>
	<hr>
	<form:form action="${pageContext.request.contextPath}/checkUser" method="POST" >
		<p>
			User name: <input type="text" name="username" >
		</p>
		<p>
			Password: <input type="password" name="password" >
		</p>
		<input type="submit" value="Login" >
	</form:form>
</body>
</html>