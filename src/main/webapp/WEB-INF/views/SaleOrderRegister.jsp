<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<h3>Welcome To SaleOrder Register Page</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="saleOrder">


					<div class="row">
						<div class="col-4">
							<label for="">ORDER CODE</label>
						</div>

						<div class="col-4">
							<form:input path="saleOcode" class="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="">SHIPMENT CODE</label>
						</div>

						<div class="col-4">
							
								<form:select path="shipob.shipId" class="form-control">
								<form:option value="">-SELECT</form:option>
								<form:options items="${shipMap}" />
								</form:select>
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="">CUSTOMER CODE</label>
						</div>

						<div class="col-4">
							
								<form:select path="whob.whUserId" class="form-control">
								<form:option value="">-SELECT</form:option>
								<form:options items="${whmap}" />
								</form:select>
						</div>
					</div>
					

					<div class="row">
						<div class="col-4">
							<label for="">REF. NUMBER</label>
						</div>

						<div class="col-4">
							<form:input path="refNumber" class="form-control"/>
						</div>
						</div>

					<div class="row">
						<div class="col-4">
							<label for="">STOCK MODE</label>
						</div>

						<div class="col-4">
							<form:radiobutton path="stockMode" value="grade" />
							Grade
							<form:radiobutton path="stockMode" value="margin" />
							Margin

						</div>

						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="stockMode">STOCK SOURCE</label>
						</div>

						<div class="col-4">
							<form:select path="stockSource" class="form-control">
								<form:option value=" ">-SELECT-</form:option>
								<form:option value="open">OPEN</form:option>
								<form:option value="aval">AVILABLE</form:option>
								<form:option value="refund">REFUND</form:option>
							</form:select>
						</div>

						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">DEFAULT STATUS</label>
						</div>

						<div class="col-4">
							<form:input path="status" value="SALE-OPEN" class="form-control"/>
						</div>

						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">DESCRIPTION</label>
						</div>

						<div class="col-4">
							<form:textarea path="description" class="form-control"/>
						</div>

						<div class="col-4"></div>
					</div>

					<div class="row">
						<div class="col-4"></div>

						<div class="col-4">
							<input type="submit" value="create" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />
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