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
				<h3>Welcome To UOM Register Page</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="uom">


					<div class="row">
						<div class="col-4">
							<label for="">UOM Type</label>
						</div>

						<div class="col-4">
							<form:select path="uomType">
								<form:option value=" ">-SELECT-</form:option>
								<form:option value="Packing">PACKING</form:option>
								<form:option value="NoPacking">NO-PACKING</form:option>
								<form:option value="">-NA-</form:option>
							</form:select>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">UOM MODEL</label>
						</div>

						<div class="col-4">
							<form:input path="uomModel" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">DESCRIPTION</label>
						</div>

						<div class="col-4">
							<form:textarea path="uomDesc" />
						</div>
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