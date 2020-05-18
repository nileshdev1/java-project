<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      
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
				<h3>Welcome To UOM Edit Page</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="uom">


	<div class="row">
						<div class="col-4">
							<label for="shipMode">UOM ID</label>
						</div>
				<div class="col-4">
					<form:input path="uomId" readonly="true" class="form-control"/>
				</div>
				</div>
				
					<div class="row">
						<div class="col-4">
							<label for="">UOM Type</label>
						</div>

						<div class="col-4">
							<form:select path="uomType" class="form-control">
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
							<form:input path="uomModel" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">DESCRIPTION</label>
						</div>

						<div class="col-4">
							<form:textarea path="uomDesc" class="form-control" />
						</div>
					</div>


					<div class="row">
						<div class="col-4"></div>

						<div class="col-4">
							<input type="submit" value="Update" class="btn btn-success" /> <input
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