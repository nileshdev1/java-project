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
				<h3>Welcome To Part Data Page</h3>
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
									<th scope="col">PART ID</th>
									<th scope="col">CODE</th>
									<th scope="col">WIDTH</th>
									<th scope="col">LENGTH</th>
									<th scope="col">HIGHT</th>
									<th scope="col">BASE COST</th>
									<th scope="col">CURRENCY</th>
									<th scope="col">UOM</th>
									<th scope="col">ORDER CODE</th>
									<th scope="col">NOTE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">

									<tr>
										<td>${ob.pid}</td>
										<td>${ob.pcode}</td>
										<td>${ob.dwid}</td>
										<td>${ob.dlen}</td>
										<td>${ob.dhig}</td>
										<td>${ob.bcost}</td>
										<td>${ob.currency}</td>
										<td>${ob.uomob.uomModel}
										<td>${ob.oMethodOb.orderCode}
										<td>${ob.discription}</td>
										<td><a href="delete?sid=${ob.pid}"><img
												src="../resources/image/delete.png" width="30" hight="30" /></a>
										<td><a href="edit?sid=${ob.pid}"><img
												src="../resources/image/edit.png" width="30" hight="30" /></a>
										<td><a href="view?sid=${ob.pid}"><img
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