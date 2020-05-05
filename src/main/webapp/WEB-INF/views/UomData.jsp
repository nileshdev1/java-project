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
				<h3>Welcome To UOM Data Page</h3>
			</div>


			<div class="card-body">
				<h3></h3>
				<c:choose>
					<c:when test="${!empty list}">
						<a href="excel"><img src="../resources/image/excel.png"
							width="30" hight="30" /></a> | 
<a href="pdf"><img src="../resources/image/pdf.png" width="30"
							hight="30" /></a>


						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">TYPE</th>
									<th scope="col">MODEL</th>
									<th scope="col">NOTE</th>
									<th scope="col"></th>
									<th colspan="3">OPERATION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">

									<tr>
										<td>${ob.uomId}</td>
										<td>${ob.uomType}</td>
										<td>${ob.uomModel}</td>
										<td>${ob.uomDesc}</td>
										<td><a href="delete?uid=${ob.uomId}"><img
												src="../resources/image/delete.png" width="30" hight="30" /></a>
										<td><a href="edit?uid=${ob.uomId}"><img
												src="../resources/image/edit.png" width="30" hight="30" /></a>
										<td><a href="view?uid=${ob.uomId}"><img
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