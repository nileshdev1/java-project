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
<h3>Welcome To UOM View Page</h3>
<table border="1">
<tr>
	<th>ID</th><td>${ob.uomId}</td>
</tr>
<tr>
	<th>TYPE</th><td>${ob.uomType}</td>
</tr>
<tr>
	<th>MODEL</th><td>${ob.uomModel}</td>
</tr>
<tr>
	<th>Note</th><td>${ob.uomDesc}</td>
</tr>

</table>
</body>
</html>