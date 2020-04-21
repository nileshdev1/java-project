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
				<form:form action="save" method="POST" modelAttribute="whUserType">

					<div class="row">
						<div class="col-4">
							<label for="usertype"> USER TYPE</label>
						</div>
						<div class="col-4">
							<input type="radio" name="usertype" id="usertype1" value="vender" />VENDER
							<input type="radio" name="usertype" id="usertype2" value="customer" />CUSTOMER
						</div>
						<div class="col-4">
							<span id="userTypeError"></span>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="userCode">USER CODE</label>
						</div>
						<div class="col-4">
							<input type="text" name="userCode" id="userCode"
								class="form-control" placeholder="Enter User Code" />
						</div>
						<div class="col-4">
							<span id="userCodeError"></span>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label>USER FOR</label>
						</div>
						<div class="col-4">
							<input type="text" name="userFor" id="userFor"
								readonly="readonly" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="userMail">USER EMAIL</label>
						</div>
						<div class="col-4">
							<input type="text" name="userEmail" id="userMail"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="userMailError"></span>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="userContact">USER CONTACT</label>
						</div>
						<div class="col-4">
							<input type="text" name="userContect" id="userContact"
								class="form-control" />
						</div>
						<div class="col-4">
							<span id="userContactError"></span>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="idType">USER ID TYPE</label>
						</div>
						<div class="col-4">
							<select name="userIdType" id="idType" class="form-control">
								<option value="">-SELECT-</option>
								<option value="PAN">PAN</option>
								<option value="AADHAR">AADHAR</option>
								<option value="VOTERID">VOTERID</option>
								<option value="OTHER">OTHER</option>
							</select>
						</div>
						<div class="col-4">
							<span id="idTypeError"></span>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="ifOther">*IF OTHER</label>
						</div>
						<div class="col-4">
							<input type="text" name="ifOther" id="ifOther"
								class="form-control" readonly />
						</div>
						<div class="col-4">
							<span id="ifOtherError"></span>
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="idNum">ID NUMBER</label>
						</div>
						<div class="col-4">
							<input type="text" name="idNumber" id="idNum" class="form-control" />
						</div>
						<div class="col-4">
							<span id="idNumError"></span>
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
			<div class="card-footer bg-secondary text-center text-white text-uppercase">
				${message }
			</div>
		</div>
	</div>
</body>
</html>
