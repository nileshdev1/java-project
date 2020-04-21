<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<h3>Welcome To WHUSERTYPE Data Page</h3>
			</div>


			<div class="card-body">

				<c:choose>
					<c:when test="${!empty list}">
						<a href="excel"><img src="../resources/image/excel.png"
							width="30" hight="40" /></a>
						<a href="pdf"><img src="../resources/image/pdf.png" width="30"
							hight="30" /></a>


						<table class="table">
							<thead>
								<tr>
									<th scope="col">USER ID</th>
									<th scope="col">USER TYPE</th>
									<th scope="col">USER CODE</th>
									<th scope="col">USER FOR</th>
									<th scope="col">USER EMAIL</th>
									<th scope="col">USER CONTECT</th>
									<th scope="col">USER IDTYPE</th>
									<th colspan="3">OTHER ID</th>
									<th colspan="3">ID NUMBE</th>
								</tr>
							</thead>
							<tbody>
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
										<td><a href="delete?sid=${ob.whUserId}"><img
												src="../resources/image/delete.png" width="30" hight="30" /></a>
										<td><a href="edit?sid=${ob.whUserId}"><img
												src="../resources/image/edit.png" width="30" hight="30" /></a>
										<td><a href="view?sid=${ob.whUserId}"><img
												src="../resources/image/view.png" width="30" hight="30" /></a>
									</tr>

								</c:forEach>
						</table>
			</div>
			</c:when>

			<c:otherwise>
   No Data Found....!!
   ${msg}
</c:otherwise>
			</c:choose>
		</div>
		<div
			class="card-footer bg-primary text-center text-white text-uppercase">
			${message }</div>
	</div>

</body>
</html>