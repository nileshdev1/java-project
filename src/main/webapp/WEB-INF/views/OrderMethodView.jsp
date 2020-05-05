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
<%@include file="UserMenu.jsp"%>

	<div class="container">
		<div class="card">

			<div
				class="card-header bg-info text-center text-white text-uppercase">
				<h3>Welcome To ORDER METHOD View Page</h3>
			</div>


			<div class="card-body">

<a href="excel?id=${ob.orderId}"><img src="../resources/image/excel.png"width="30" hight="30"/></a> |
<a href="pdf?id=${ob.orderId}"><img src="../resources/image/pdf.png"width="30" hight="30"/></a>
<table class="table">
							
<tr>
	<th>ORDER ID</th><td>${ob.orderId}</td>
</tr>
<tr>
	<th>ORDER MODE</th><td>${ob.orderMode}</td>
</tr>
<tr>
	<th>ORDER CODE</th><td>${ob.orderCode}</td>
</tr>
<tr>
	<th>ORDER TYPE</th><td>${ob.orderType}</td>
</tr>
<tr>
	<th>ORDER ACCEPT</th><td>${ob.orderAccept}</td>
</tr>
<tr>
	<th>Note</th><td>${ob.description}</td>
</tr>

</table>
</div>
</div>
</div>

</body>
</html>