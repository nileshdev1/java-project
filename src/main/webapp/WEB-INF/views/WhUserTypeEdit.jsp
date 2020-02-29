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
<h3>Welcome To ORDER METHOD Edit Page</h3>
<form:form action="update" method="post" modelAttribute="whUserType">
<pre>
WHUSER ID:  <form:input path="whUserId" readonly="true"/>

User Type: <form:radiobutton path="userType" value="vender"/>Vender
		   <form:radiobutton path="userType" value="customer"/>Customer
		   
User Code: <form:input path="userCode"/>

USER FOR: <form:select path="userFor">
		<form:option value="ps">Purchase/Sale</form:option>
</form:select>

USER EMAIL: <form:input path="userEmail"/>

USER CONTECT: <form:input path="userContect"/>

USER ID TYPE: <form:select path="userIdType">
		<form:option value="">-SELECT-</form:option>
		<form:option value="pancard">PAN CARD</form:option>
		<form:option value="aadhar">AADHAR</form:option>
		<form:option value="voterid">VOTERID</form:option>
		<form:option value="other">OTHER</form:option>
</form:select>

IF OTHER: <form:input path="other"/>

ID NUMBER: <form:input path="idNumber"/>

<input Type="submit" value=update>
</pre>

</form:form>
</body>
</html>