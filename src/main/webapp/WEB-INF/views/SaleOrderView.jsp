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
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome To SaleOrder View Page</h3>
			</div>


			<div class="card-body">

<a href="excel?id=${ob.saleOid}"><img src="../resources/image/excel.png"width="30" hight="30"/></a> |
<a href="pdf?id=${ob.saleOid}"><img src="../resources/image/pdf.png"width="30" hight="30"/></a>
<table class="table">
							<thead>
								<tr>
						
	<th>ID</th><td>${ob.saleOid}</td>
</tr>
<tr>
	<th>CODE</th><td>${ob.saleOcode}</td>
</tr>
<tr>
	<th>REF NUMBER</th><td>${ob.refNumber}</td>
</tr>
<tr>
	<th>MODE</th><td>${ob.stockMode}</td>
</tr>
<tr>
	<th>STOCK SOURCE</th><td>${ob.stockSource}</td>
</tr>
<tr>
	<th>STATUS</th><td>${ob.status}</td>
</tr>
<tr>
	<th>DESCRIPTION</th><td>${ob.description}</td>
</tr>

</thead>
</table>
</div>
</body>
</html>