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
<h3>Welcome To Part Edit Page</h3>
<form:form action="update" method="post" modelAttribute="part">
<pre>
Code: <form:input path="pcode" readonly="true" />

Dimensions: W <form:input path="dwid" />  L <form:input path="dlen" /> H <form:input path="dhig" /> 

Base Cost: <form:input path="bcost" />

Base Currency: 
		<form:select path="currency">
		<form:option value=" ">-SELECT-</form:option>
		<form:option value="inr">INR</form:option>
		<form:option value="usd">USD</form:option>
		<form:option value="aus">AUS</form:option>
		<form:option value="ERU">ERU</form:option>
</form:select>

UOM: <form:select path="uomob.uomid">
		<form:option value="">-SELECT</form:option>
		<form:option value="${uomlist}" itemvalue="uomId" itemlabel="uomModel"/>
</form:select>

Description:  <form:textarea path="discription" />

<input type="submit" value="Update" />

</pre>

</form:form>
</body>
</html>