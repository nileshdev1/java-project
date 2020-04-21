<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<h3>Welcome To Part View Page</h3>
			</div>
			<div class="card-body">

				<a href="excel?id=${ob.whUserId}"><img
					src="../resources/image/excel.png" width="30" hight="30" /></a> | <a
					href="pdf?id=${ob.whUserId}"><img
					src="../resources/image/pdf.png" width="30" hight="30" /></a>

				<table border="1">
					<tr>
						<th>CODE</th>
						<td>${ob.pcode}</td>
					</tr>
					<tr>
						<th>WIDTH</th>
						<td>${ob.dwid}</td>
					</tr>
					<tr>
						<th>LENGTH</th>
						<td>${ob.dlen}</td>
					</tr>
					<tr>
						<th>HIGHT</th>
						<td>${ob.dhig}</td>
					</tr>
					<tr>
						<th>BASE COST</th>
						<td>${ob.bcost}</td>
					</tr>
					<tr>
						<th>CURRENCY</th>
						<td>${ob.currency}</td>
					</tr>
					<tr>
						<th>Note</th>
						<td>${ob.discription}</td>
					</tr>

				</table>
			</div>
		</div>
	</div>

</body>
</html>