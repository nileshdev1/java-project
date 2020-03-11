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
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome To SaleOrder Data Page</h3>
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
									<th scope="col">ID</th>
									<th scope="col">CODE</th>
									<th scope="col">REF NUMBER</th>
									<th scope="col">STOCK MODE</th>
									<th scope="col">STOCK SOURCE</th>
									<th scope="col">STATUS</th>
									<th scope="col">DISCRIPTION</th>
									<th colspan="3">OPERATION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">

									<tr>
										<td>${ob.saleOid}</td>
										<td>${ob.saleOcode}</td>
										<td>${ob.refNumber}</td>
										<td>${ob.stockMode}</td>
										<td>${ob.stockSource}</td>
										<td>${ob.status}</td>
										<td>${ob.description}</td>
										<td><a href="delete?sid=${ob.saleOid}"><img
												src="../resources/image/delete.png" width="30" hight="30" /></a>
										<td><a href="edit?sid=${ob.saleOid}"><img
												src="../resources/image/edit.png" width="30" hight="30" /></a>
										<td><a href="view?sid=${ob.saleOid}"><img
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