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
<h3>Welcome To OrderMethod Data Page</h3>
<c:choose>
<c:when test="${!empty list}">
<a href="excel">Excel Export</a>
<table border="1">
<tr>
	<th>ORDER ID</th>
	<th>ORDER MODE</th>
	<th>ORDER CODE</th>
	<th>ORDER TYPE</th>
	<th>ORDER ACCEPT</th>
	<th>NOTE</th>
	<th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list}" var="ob">

<tr>
	<td>${ob.orderId}</td>
	<td>${ob.orderMode}</td>
	<td>${ob.orderCode}</td>
	<td>${ob.orderType}</td>
	<td>${ob.orderAccept}</td>
	<td>${ob.description}</td>
	<td><a href="delete?oid=${ob.orderId}">DELETE</a>
	<td><a href="edit?oid=${ob.orderId}">EDIT</a>
	<td><a href="view?oid=${ob.orderId}">VIEW</a>
	
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