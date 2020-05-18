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
				<h3>Welcome To PurchaseOrder Edit Page</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="purchaseOrder">

							<div class="row">
						<div class="col-4">
							<label for="">ID</label>
						</div>

						<div class="col-4">
							<form:input path="poid" readonly="true" class="form-control"/>
						</div>
					</div>
					

						<div class="row">
						<div class="col-4">
							<label for="">ORDER CODE</label>
						</div>

						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">REF. NUMBER</label>
						</div>

						<div class="col-4">
							<form:input path="refNo" class="form-control"/>
						</div>
						</div>

					<div class="row">
						<div class="col-4">
							<label for="">QUALITY CHECK</label>
						</div>

						<div class="col-4">
							<form:radiobutton path="qltyCheck" value="required" />
							REQUIRED
							<form:radiobutton path="qltyCheck" value="notrequired" />
							NOT-REQUIRED

						</div>

						<div class="col-4"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">DEFAULT STATUS</label>
						</div>

						<div class="col-4">
							<form:input path="status" value="OPEN" class="form-control"/>
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
							<input type="submit" value="Update" class="btn btn-success" /> <input
								type="reset" value="Cancel" class="btn btn-danger" />
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