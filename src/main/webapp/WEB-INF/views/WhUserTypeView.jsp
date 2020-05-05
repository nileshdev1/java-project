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
				<h3>Welcome To WhUserType View Page</h3>
			</div>


			<div class="card-body">

				<a href="excel?id=${ob.whUserId}"><img
					src="../resources/image/excel.png" width="30" hight="30" /></a> | <a
					href="pdf?id=${ob.whUserId}"><img
					src="../resources/image/pdf.png" width="30" hight="30" /></a>
				<table class="table">
					
						<tr>

							<th>USER ID</th>
							<td>${ob.whUserId}</td>
						</tr>
						<tr>
							<th>USER TYPE</th>
							<td>${ob.userType}</td>
						</tr>
						<tr>
							<th>USER CODE</th>
							<td>${ob.userCode}</td>
						</tr>
						<tr>
							<th>USER FOR</th>
							<td>${ob.userFor}</td>
						</tr>
						<tr>
							<th>USER EMAIL</th>
							<td>${ob.userEmail}</td>
						</tr>
						<tr>
							<th>USER CONTECT</th>
							<td>${ob.userContect}</td>
						</tr>
						<tr>
							<th>USER IDTYPE</th>
							<td>${ob.userIdType}</td>
						</tr>
						<tr>
							<th>OTHER ID</th>
							<td>${ob.other}</td>
						</tr>
						<tr>
							<th>ID NUMBE</th>
							<td>${ob.idNumber}</td>
						</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>