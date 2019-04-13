<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color:red;">${errorString}</h2>
	<form action="${pageContext.request.contextPath}/InfoServlet" method="post">
		<input type="text" name="info" placeholder="info">
		<input type="text" name="description" placeholder="description">
		<button type="submit" value="submit"></button>
	</form>
</body>
</html>