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
<h3>Welcome To WHUSERTYPE Data Page</h3>
<c:choose>
<c:when test="${!empty list}">
<a href="excel">Excel Export</a> |
<a href="pdf">PDF Export</a> 
<table border="1">
<tr>
	<th>USER ID</th>
	<th>USER TYPE</th>
	<th>USER CODE</th>
	<th>USER FOR</th>
	<th>USER EMAIL</th>
	<th>USER CONTECT</th>
	<th>USER IDTYPE</th>
	<th>OTHER ID</th>
	<th>ID NUMBE</th>
	<th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list}" var="ob">

<tr>
	<td>${ob.whUserId}</td>
	<td>${ob.userType}</td>
	<td>${ob.userCode}</td>
	<td>${ob.userFor}</td>
	<td>${ob.userEmail}</td>
	<td>${ob.userContect}</td>
	<td>${ob.userIdType}</td>
	<td>${ob.other}</td>
	<td>${ob.idNumber}</td>
	<td><a href="delete?sid=${ob.whUserId}">DELETE</a>
	<td><a href="edit?sid=${ob.whUserId}">EDIT</a>
	<td><a href="view?sid=${ob.whUserId}">VIEW</a>
	
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