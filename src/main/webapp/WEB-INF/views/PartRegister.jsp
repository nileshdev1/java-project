<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<h3>Welcome To Part RegisterPage</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="part">



					<div class="row">
						<div class="col-4">
							<label for="">CODE</label>
						</div>

						<div class="col-4">
							<form:input path="pcode" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">DIMENSIONS</label>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="">WIDTH</label>
						</div>
						<div class="col-4">
							<form:input path="dwid" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="">LENGTH</label>
						</div>
						<div class="col-4">
							<form:input path="dlen" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="">HIGHT</label>
						</div>
						<div class="col-4">
							<form:input path="dhig" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">BASE COST</label>
						</div>
						<div class="col-4">
							<form:input path="bcost" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">BASE CURRENCY</label>
						</div>
						<div class="col-4">
							<form:select path="currency">
								<form:option value=" ">-SELECT-</form:option>
								<form:option value="inr">INR</form:option>
								<form:option value="usd">USD</form:option>
								<form:option value="aus">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">UOM</label>
						</div>
						<div class="col-4">
							<form:select path="uomob.uomId">
								<form:option value="">-SELECT</form:option>
								<form:options items="${uomMap}" />
							</form:select>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">SALE ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:select path="oMethodOb.orderId">
								<form:option value="">-SELECT</form:option>
								<form:options items="${omSaleMap}" />
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">PURCHASE ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:select path="oMethodOb.orderId">
								<form:option value="">-SELECT</form:option>
								<form:options items="${omPurchaseMap}" />
							</form:select>

						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="discription" />
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