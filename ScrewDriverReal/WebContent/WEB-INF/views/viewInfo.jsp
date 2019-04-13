<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${errorString}</h2>
	<table  border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Info</th>
		<th>Description</th>
	</tr>
	<c:forEach items="${infoList}" var="infos">
		<tr>
			<td>${infos.info}</td>
			<td>${infos.description}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>