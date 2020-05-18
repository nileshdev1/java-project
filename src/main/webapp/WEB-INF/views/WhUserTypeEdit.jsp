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
				<h3>WELCOME TO WHUSERTYPE REGISTRATION PAGE</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="whUserType">
					
					<div class="row">
						<div class="col-4">
							<label for="whUserId"> USER ID</label>
						</div>
						<div class="col-4">
							<form:input path="whUserId" class="form-control" readonly="true" />
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userType"> USERTYPE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="userType" value="Vendor" />Vendor
							<form:radiobutton path="userType" value="Customer" />Customer
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userCode"> USERCODE</label>
						</div>
						<div class="col-4">
							<form:input path="userCode" class="form-control" />
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userFor"> USERFOR</label>
						</div>
						<div class="col-4">
							<form:input path="userFor" class="form-control" readonly="true"/>
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userEmail"> USEREMAIL</label>
						</div>
						<div class="col-4">
							<form:input path="userEmail" class="form-control" />
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userContect">USER CONTACT</label>
						</div>
						<div class="col-4">
							<form:input path="userContect" class="form-control" />
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userIdType"> USERIDTYPE</label>
						</div>
						<div class="col-4">
							<form:select path=
							"userIdType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="PANCARD">PANCARD</form:option>
								<form:option value="AADHAR">AADHAR</form:option>
								<form:option value="OTHER">OTHER</form:option>
							</form:select>
						</div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="other"> IFOTHER</label>
						</div>
						<div class="col-4">
							<form:input path="other" class="form-control" readonly="true" />
						</div>
					</div>
					
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="idNumber"> ID NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="idNumber" class="form-control" />
						</div>
					</div>
					
					

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Update" class="btn btn-success" /> 
						</div>
					</div>
					
				</form:form>
			</div>
			<div class="card-footer bg-secondary text-center text-white text-uppercase">
				${message }
			</div>
		</div>
	</div>
</body>
</html>