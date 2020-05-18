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
				<h3>Welcome To Order Method Register Page</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="orderMethod">

					<div class="row">
						<div class="col-4">
							<label for="orderMode">OrderMode</label>
						</div>

						<div class="col-4">
							<form:radiobutton path="orderMode" value="Sale" />
							Sale
							<form:radiobutton path="orderMode" value="Purchase" />
							Purchase
						</div>
					</div>
					<div class="row">

						<div class="col-4">
							<label for="shipMode">Order Code</label>
						</div>

						<div class="col-4">
							<form:input path="orderCode" class="form-control"/>
						</div>
					</div>
					<div class="row">

						<div class="col-4">
							<label for="shipMode">OrderType</label>
						</div>

						<div class="col-4">
							<form:select path="orderType" class="form-control">
		<form:option value="">-SELECT-</form:option>
								<form:option value="fifo">FIFO</form:option>
								<form:option value="lifo">LIFO</form:option>
								<form:option value="fcfo">FCFO</form:option>
								<form:option value="fefo">FEFO</form:option>
							</form:select>

						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipMode">OrderAccept</label>
						</div>

						<div class="col-4">
							<form:checkbox path="orderAccept" value="acceptreturn" />
							AcceptReturn
						</div>

					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipMode">Description</label>
						</div>

						<div class="col-4">
							<form:textarea path="description" class="form-control"/>
						</div>
					</div>





					<div class="row">
						<div class="col-4"></div>

						<div class="col-4">
							<input type="submit" value="create" class="btn btn-success" /> 
							<input type="reset" value="Clear" class="btn btn-danger" />
						</div>

					</div>
				</form:form>
			</div>
			<div
				class="card-footer bg-secondary text-center text-white text-uppercase">
				${message }</div>
		</div>
	</div>
</body>
</html>