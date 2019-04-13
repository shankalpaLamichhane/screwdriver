<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body style="padding:40px 60px;">
	<h2 style="color:red">hey ${errorString}</h2>

	<table class="table-hover" border="2" cellpadding="5" cellspacing="1" >
       <tr>
          <th>name</th>
          <th>email</th>
          <th>password</th>
          <th>number</th>
          <th>location</th>
          <th>delete</th>
       </tr>
       <c:forEach items="${userList}" var="user" >
          <tr>
             <td>${user.name}</td>
             <td>${user.email}</td>
             <td>${user.password}</td>
             <td>${user.number}</td>
             <td>${user.location}</td>
             <td><a href="deleteProduct?id=${user.id}">Delete</a></td>
          </tr>
       </c:forEach>
    </table>
</body>
</html>