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
				class="card-header bg-info text-center text-white text-uppercase">
				<h3>Welcome To PurchaseOrder View Page</h3>
			</div>


			<div class="card-body">

				<a href="excel?id=${ob.poid}"><img
					src="../resources/image/excel.png" width="30" hight="30" /></a> | <a
					href="pdf?id=${ob.poid}"><img src="../resources/image/pdf.png"
					width="30" hight="30" /></a>
				<table class="table">
						<tr>

							<th>ID</th>
							<td>${ob.poid}</td>
						</tr>
						<tr>
							<th>CODE</th>
							<td>${ob.orderCode}</td>
						</tr>
						<tr>
							<th>REF NUMBER</th>
							<td>${ob.refNo}</td>
						</tr>
						<tr>
							<th>QUALITY CHECK</th>
							<td>${ob.qltyCheck}</td>
						</tr>
						<tr>
							<th>STATUS</th>
							<td>${ob.status}</td>
						</tr>
						<tr>
							<th>DESCRIPTION</th>
							<td>${ob.description}</td>
						</tr>

				</table>
			</div>
		</div>
	</div>
</body>
</html>