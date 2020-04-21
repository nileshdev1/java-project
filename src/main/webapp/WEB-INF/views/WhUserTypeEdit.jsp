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
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome To ORDER METHOD Edit Page</h3>
			</div>

			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="whUserType">


					<div class="row">
						<div class="col-4">
							<label for="">WHUSER ID</label>
						</div>

						<div class="col-4">
							<form:input path="whUserId" readonly="true" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">User Type</label>
						</div>

						<div class="col-4">
							<form:radiobutton path="userType" value="vender" />
							Vender
							<form:radiobutton path="userType" value="customer" />
							Customer
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">User Code</label>
						</div>

						<div class="col-4">
							<form:input path="userCode" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">USER FOR</label>
						</div>

						<div class="col-4">
							<form:select path="userFor">
								<form:option value="ps">Purchase/Sale</form:option>
							</form:select>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">USER EMAIL</label>
						</div>

						<div class="col-4">
							<form:input path="userEmail" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">USER CONTECT</label>
						</div>

						<div class="col-4">
							<form:input path="userContect" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">USER ID TYPE</label>
						</div>

						<div class="col-4">
							<form:select path="userIdType">
								<form:option value="">-SELECT-</form:option>
								<form:option value="pancard">PAN CARD</form:option>
								<form:option value="aadhar">AADHAR</form:option>
								<form:option value="voterid">VOTERID</form:option>
								<form:option value="other">OTHER</form:option>
							</form:select>
						</div>
					</div>


<div class="row">
						<div class="col-4">
							<label for="">IF OTHER</label>
						</div>

						<div class="col-4">
							<form:input path="other" />
						</div>
					</div>
					
					
					
					<div class="row">
						<div class="col-4">
							<label for="">ID NUMBER</label>
						</div>

						<div class="col-4">
							<input Type="submit" value=update>
						</div>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>