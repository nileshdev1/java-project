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
				class="card-header bg-info text-center text-white text-uppercase">
				<h3>Welcome To Order Method Data Page</h3>
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
									<th>ORDER ID</th>
									<th>ORDER MODE</th>
									<th>ORDER CODE</th>
									<th>ORDER TYPE</th>
									<th>ORDER ACCEPT</th>
									<th>NOTE</th>
									<th colspan="3">OPERATION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">

									<tr>
										<td>${ob.orderId}</td>
										<td>${ob.orderMode}</td>
										<td>${ob.orderCode}</td>
										<td>${ob.orderType}</td>
										<td>${ob.orderAccept}</td>
										<td>${ob.description}</td>
										<td><a href="delete?oid=${ob.orderId}"><img
												src="../resources/image/delete.png" width="30" hight="30" /></a>
										<td><a href="edit?oid=${ob.orderId}"><img
												src="../resources/image/edit.png" width="30" hight="30" /></a>
										<td><a href="view?oid=${ob.orderId}"><img
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