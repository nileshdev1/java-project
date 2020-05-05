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
				<form:form id="myForm" action="save" method="POST" modelAttribute="whUserType">
				
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userType"> USERTYPE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="userType" value="Vendor" />Vendor
							<form:radiobutton path="userType" value="Customer" />Customer
						</div>
						<div class="col-4" id="userTypeError"></div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userCode"> USERCODE</label>
						</div>
						<div class="col-4">
							<form:input path="userCode" class="form-control" />
						</div>
						<div class="col-4" id="userCodeError"></div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userFor"> USERFOR</label>
						</div>
						<div class="col-4">
							<form:input path="userFor" class="form-control" readonly="true"/>
						</div>
						<div class="col-4" id="userForError"></div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userEmail"> USEREMAIL</label>
						</div>
						<div class="col-4">
							<form:input path="userEmail" class="form-control" />
						</div>
						<div class="col-4" id="userEmailError"></div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="userContect"> USERCONTACT</label>
						</div>
						<div class="col-4">
							<form:input path="userContect" class="form-control" />
						</div>
						<div class="col-4" id="userContectError"></div>
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
						<div class="col-4" id="idTypeError"></div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="other"> IFOTHER</label>
						</div>
						<div class="col-4">
							<form:input path="other" class="form-control" readonly="true" />
						</div>
						<div class="col-4" id="ifOtherError"></div>
					</div>
					
					<!--new Row -->
					
					<div class="row">
						<div class="col-4">
							<label for="idNumber"> ID NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="idNumber" class="form-control" />
						</div>
						<div class="col-4" id="idNumError"></div>
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
	
<script type="text/javascript">
$(document).ready(function(){

	$("#userTypeError").hide();
	  $("#userCodeError").hide();
	  $("#userEmailError").hide();
	  $("#userContectError").hide();
	  $("#idTypeError").hide();
	  $("#idNumError").hide();

	  var userTypeError = false;
	  var userCodeError = false;
	  var userMailError = false;
	  var userContactError = false;
	  var idTypeError = false;
	  var idNumError = false;

	  $('input[type="radio"][name="userType"]').change(function(){
		     validate_userType();
			 autoFill_userFor();
		  });
		  $("#userCode").keyup(function(){
		     validate_userCode();
		  });

		  $("#userEmail").keyup(function(){
			 validate_userEmail();
		  });

		  $("#userContect").keyup(function(){
		     validate_userContect();
		  });

		  $("#userIdType").change(function(){
		    validate_userIdType();
		  });

		  $("#idNumber").keyup(function(){
		    validate_idNumber();
		  });

		  function autoFill_userFor(){
			     var val=$('input[type="radio"][name="userType"]:checked').val();
				 if(val=='Vendor'){
				   $("#userFor").val("Purchase");
				   $("#userFor").css("color","blue");
				 }else if(val=='Customer'){
			  	   $("#userFor").val("Sale");
			   	   $("#userFor").css("color","green");
				 }
			  }

		  function validate_userType(){
			    var val=$('input[type="radio"][name="userType"]:checked').length;
				//if one radio button is selected then length=1 else length is zero
				if(val==0){
				  $("#userTypeError").show();
			  	  $("#userTypeError").html("Please choose <b>User Type</b>");
			 	  $("#userTypeError").css("color","red");
				  userTypeError = false;
				}else{
				  $("#userTypeError").hide();
				  userTypeError = true;
				}
			    return userTypeError;
			  }

		  function validate_userCode(){
			    var val=$("#userCode").val();
				var exp=/^[A-Z]{2,8}$/;
			    if(val==''){
				  $("#userCodeError").show();
				  $("#userCodeError").html("Enter <b>User Code</b>");
			   	  $("#userCodeError").css("color","red");
				  userCodeError = false;
				}else if(!exp.test(val)) {
				  $("#userCodeError").show();
				  $("#userCodeError").html("Enter <b>Upper Case (2-8)</b> letters only");
			   	  $("#userCodeError").css("color","red");
				  userCodeError = false;
				}else{
				  $("#userCodeError").hide();
				  userCodeError = true;
				}
			    return userCodeError;
			  }

		  function validate_userEmail(){
			     var val=$("#userEmail").val();
			     var exp=/^[a-zA-Z0-9-_]+\@[a-zA-Z]{2,8}\.[a-z]{2,6}$/;
				 if(val==''){
				   $("#userEmailError").show();
			       $("#userEmailError").html("Enter <b> User Mail</b>");
				   $("#userEmailError").css("color","red");
				   userEmailError = false;
				 }else if(!exp.test(val)){
				   $("#userEmailError").show();
			       $("#userEmailError").html("Not a Valid <b> User Mail</b>");
				   $("#userEmailError").css("color","red");
				   userMailError = false;
				 
				 }else{
			  	   $("#userEmailError").hide();
				    userMailError = true;
			         
				 }
			     return userMailError;
			  }

		  function validate_userContect(){
			    var val = $("#userContect").val();
			    var exp = /^(\+91)?[6-9][0-9]{9}$/;
				if(val==''){
				   $("#userContectError").show();
				   $("#userContectError").html("Enter <b>User Contact</b>");
				   $("#userContectError").css("color","red");
				   userContactError = false;
				}else if(!exp.test(val)){
				   $("#userContectError").show();
				   $("#userContectError").html("Invaild <b>User Contact</b>");
				   $("#userContectError").css("color","red");
				   userContectError = false;
				}else{
				   $("#userContectError").hide();
				   userContactError = true;
				}
			     return userContectError;
			  }

		  function validate_userIdType(){
			    var val = $("#userIdType").val();
				if(val==''){
				  $("#idTypeError").show();
				  $("#idTypeError").html("Choose <b>ID Type </b>");
			  	  $("#idTypeError").css("color","red");
				  idTypeError = false;
				}else{
			      $("#idTypeError").hide();
				  idTypeError = true;

				  if(val=='OTHER') {
				    $("#other").attr("readonly",false);
				  }else{
				    $("#other").val(''); 
				    $("#other").attr("readonly",true);
				  }
				}
				return idTypeError;
			  }
		  function validate_idNumer(){
			     var val= $("#idNumer").val();
				 var exp=/^[A-Za-z0-9-._]{4,20}$/;
				 if(val==''){
				   $("#idNumError").show();
			 	   $("#idNumError").html("Enter <b>ID Number</b>");
			  	   $("#idNumError").css("color","red");
				   idNumError = false;
				 }else if(!exp.test(val)){
				   $("#idNumError").show();
			 	   $("#idNumError").html("Invaild <b>ID Number</b>");
			  	   $("#idNumError").css("color","red");
				   idNumError = false;

				 }else{
				   $("#idNumError").hide();
				   idNumError = true;
				 }
				 return idNumError;
			   }


		  $("#register").click(function(){
		       	userTypeError = false;
				userCodeError = false;
		        userEmailError = false;
		        userContectError = false;
		        idTypeError = false;
		        idNumError = false;

				validate_userType();
		        validate_userCode();
				validate_userEmail();
				validate_userContect();
				validate_userIdType();
				validate_idNum();

				if(userTypeError && userCodeError && userEmailError && userContect
				   && idTypeError && idNumError)
				  return true;
		        else 
				  return false;

			});
			   
});

</script>
	
	
</body>
</html>
