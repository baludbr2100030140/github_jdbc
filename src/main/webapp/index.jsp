<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="index">
<input name="name" />
<input name="email"/>
<button type="submit">hii</button>
</form>
<%= request.getAttribute("email") %>
</body>
</html>