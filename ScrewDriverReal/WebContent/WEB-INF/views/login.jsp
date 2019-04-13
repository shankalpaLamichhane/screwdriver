<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body style="margin:20px;">
	<h1>Login JSP file</h1>
	<h2 style="color:red;"> ${errorString}</h2>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
   <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" name="email" required class="form-control" value="${userAccount.email}"
    id="email" aria-describedby="emailHelp" placeholder="Enter email">
     </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" required class="form-control" value="${userAccount.password}"
    id="password" placeholder="Password">
  </div>
 
  <button type="submit" class="btn btn-primary form-control">Submit</button>
	</form>
</body>
</html>