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
				<h3>Welcome To User Register Page</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="user">


					<div class="row">
						<div class="col-4">
							<label for="">USER NAME</label>
						</div>

						<div class="col-4">
							<form:input path="userName" class="form-control" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">
							<label for="">EMAIL ID</label>
						</div>

						<div class="col-4">
							<form:input path="userEmail" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="">PASSWORD</label>
						</div>

						<div class="col-4">
							<form:input path="userPwd" class="form-control"/>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-4">
							<label for="">ROLES</label>
						</div>

						<div class="col-4">
							<input  type="checkbox" name="roles" value="ADMIN">ADMIN
							<input  type="checkbox" name="roles" value="EMPLOYEE">EMPLOYEE
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