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
<h3>Welcome To Purchase Order Parts</h3>
<table border="1">
	<tr>
		<td>Order Code</td>
		<td><b>${po.orderCode}</b></td>
		
		<td>Order Status</td>
		<td><b>${po.status}</b></td>
	</tr>
</table>
<hr/>
<form:form action="addPart" method="post" modelAttribute="purchaseDtl">
<pre>
SELECT PART: <form:select path="part.id">
				<form:options items="${partsMap}"/>
			</form:select>
Qty  : <form:input path="qty"/>
	<input type="submit" vaalue="Add Part"/>
</pre>
</form:form>

</body>
</html>