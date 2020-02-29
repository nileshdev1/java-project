<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome To WhUserType View Page</h3>
<a href="excel?id=${ob.whUserId}">Excel Export</a> |
<a href="pdf?id=${ob.whUserId}">PDF Export</a>
<table border="1">

<tr>
	<th>USER ID</th><td>${ob.whUserId}</td>
</tr>
<tr>
	<th>USER TYPE</th><td>${ob.userType}</td>
</tr>
<tr>
	<th>USER CODE</th><td>${ob.userCode}</td>
</tr>
<tr>
	<th>USER FOR</th><td>${ob.userFor}</td>
</tr>
<tr>
	<th>USER EMAIL</th>	<td>${ob.userEmail}</td>
</tr>
<tr>
	<th>USER CONTECT</th><td>${ob.userContect}</td>
</tr>
<tr>
	<th>USER IDTYPE</th><td>${ob.userIdType}</td>
</tr>
<tr>
	<th>OTHER ID</th><td>${ob.other}</td>
</tr>
<tr>
	<th>ID NUMBE</th><td>${ob.idNumber}</td>
</tr>

</table>
</body>
</html>