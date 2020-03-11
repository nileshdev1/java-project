<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="part">
<h3>Welcome To Part RegisterPage</h3>
		<pre>
Code: <form:input path="pcode" />

Dimensions: 
	W <form:input path="dwid" />
	  
	L <form:input path="dlen" /> 
			
	H <form:input path="dhig" /> 

Base Cost: <form:input path="bcost" />

Base Currency: 
		<form:select path="currency">
		<form:option value=" ">-SELECT-</form:option>
		<form:option value="inr">INR</form:option>
		<form:option value="usd">USD</form:option>
		<form:option value="aus">AUS</form:option>
		<form:option value="ERU">ERU</form:option>
</form:select>

UOM: 	<form:select path="uomob.uomId">
		<form:option value="">-SELECT</form:option>
		<form:options items="${uomMap}"/>
</form:select>

SALE ORDER CODE: <form:select path="oMethodOb.orderId">
		<form:option value="">-SELECT</form:option>
		<form:options items="${omSaleMap}"/>
</form:select>

PURCHASE ORDER CODE: <form:select path="oMethodOb.orderId">
		<form:option value="">-SELECT</form:option>
		<form:options items="${omPurchaseMap}"/>
</form:select>



Description:  <form:textarea path="discription" />

<input type="submit" value="create" />

</pre>

</form:form>
${message }
</body>
</html>