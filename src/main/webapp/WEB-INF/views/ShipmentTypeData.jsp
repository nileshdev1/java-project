<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				class="card-header bg-info text-center text-white text-uppercase">
				<h3>Welcome To ShipmentType Data Page</h3>
			</div>


			<div class="card-body">

				<c:choose>
					<c:when test="${!empty list}">
						<a href="excel"><img src="../resources/image/excel.png"
							width="30" hight="40" /></a>
						<a href="pdf"><img src="../resources/image/pdf.png" width="30"
							hight="30" /></a>


						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">MODE</th>
									<th scope="col">CODE</th>
									<th scope="col">ENABLE</th>
									<th scope="col">GRADE</th>
									<th scope="col">NOTE</th>
									<th scope="col"></th>
									<th colspan="3">OPERATION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">

									<tr>
										<td>${ob.shipId}</td>
										<td>${ob.shipMode}</td>
										<td>${ob.shipCode}</td>
										<td>${ob.enbShip}</td>
										<td>${ob.shipGrade}</td>
										<td>${ob.shipDesc}</td>
										<td><a href="delete?sid=${ob.shipId}"><img
												src="../resources/image/delete.png" width="30" hight="30" /></a>
										<td><a href="edit?sid=${ob.shipId}"><img
												src="../resources/image/edit.png" width="30" hight="30" /></a>
										<td><a href="view?sid=${ob.shipId}"><img
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
			class="card-footer bg-secondary text-center text-white text-uppercase">
			${message }</div>
	</div>

</body>
</html>