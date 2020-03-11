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
<h3>Welcome To Part Data Page</h3>
<c:choose>
<c:when test="${!empty list}">
<table border="1">
<tr>
	<th>CODE</th>
	<th>WIDTH</th>
	<th>LENGTH</th>
	<th>HIGHT</th>
	<th>BASE COST</th>
	<th>CURRENCY</th>
	<th>UOM</th>
	<th>ORDER CODE</th>
	<th>NOTE</th>
	<th colspan="3">OPERATION</th>
</tr>

<c:forEach items="${list}" var="ob">

<tr>
	<td>${ob.pcode}</td>
	<td>${ob.dwid}</td>
	<td>${ob.dlen}</td>
	<td>${ob.dhig}</td>
	<td>${ob.bcost}</td>
	<td>${ob.currency}</td>
	<td>${ob.uomob.uomModel}
	<td>${ob.oMethodOb.orderCode}
	<td>${ob.discription}</td>
	
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