<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome To UOM Data Page</h3>
<c:choose>
<c:when test="${!empty list}">
<a href="excel">Excel Export</a>
<table border="1">
<tr>
	<th>ID</th>
	<th>TYPE</th>
	<th>MODEL</th>
	<th>NOTE</th>
	<th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list}" var="ob">

<tr>
	<td>${ob.uomId}</td>
	<td>${ob.uomType}</td>
	<td>${ob.uomModel}</td>
	<td>${ob.uomDesc}</td>
	<td><a href="delete?uid=${ob.uomId}">DELETE</a>
	<td><a href="edit?uid=${ob.uomId}">EDIT</a>
	<td><a href="view?uid=${ob.uomId}">VIEW</a>
	
</tr>

</c:forEach>
</table>
</c:when>
<c:otherwise>
   No Data Found....!!
   ${msg}
</c:otherwise>
</c:choose>

${message}
</body>
</html>