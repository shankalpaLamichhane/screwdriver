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
	<h1>Register JSP file</h1>
	<h2 style="color:red;">${errorString}</h2>
	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
   <div class="form-group">
	 <label for="name">Name</label>
    <input type="text" name="name" required class="form-control" value="${userAccount.name}"
    id="name" aria-describedby="name" placeholder="Enter name">
    </div>
   <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" name="email" required class="form-control" value="${userAccount.email}"
    id="email" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" required class="form-control" value="${userAccount.password}"
    id="password" placeholder="Password">
  </div>
  
  <div class="form-group">
    <label for="number">Number</label>
    <input type="text" required name="number" class="form-control" value="${userAccount.number}"
    id="number" aria-describedby="number" placeholder="Enter number">
  </div>
  <div class="form-group">
    <label for="location">location</label>
    <input type="text" required name="location" class="form-control" value="${userAccount.location}"
    id="location" aria-describedby="location" placeholder="Enter location">
  </div>
  
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="check">
    <label class="form-check-label" for="check">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary form-control">Submit</button>
	</form>
</body>
</html>