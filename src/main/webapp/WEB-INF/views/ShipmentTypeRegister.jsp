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
<form:form action="save" method="POST" modelAttribute="shipmentType">
<h3>Welcome To ShipmentType RegisterPage</h3>
		<pre>
Shipment Mode: 
		<form:select path="shipMode">
		<form:option value=" ">-SELECT-</form:option>
		<form:option value="Air">Air</form:option>
		<form:option value="Truck">Truck</form:option>
		<form:option value="Ship">Ship</form:option>
		<form:option value="Train">Train</form:option>
</form:select>

Shipment Code: <form:input path="shipCode" />

Enable Shipment:  <form:select path="enbShip">
		<form:option value=" ">-SELECT-</form:option>
		<form:option value="yes">YES</form:option>
		<form:option value="no">NO</form:option>
</form:select>

Shipment Grade: <form:radiobutton path="shipGrade" value="A" />A
Shipment Grade: <form:radiobutton path="shipGrade" value="B" />B
Shipment Grade: <form:radiobutton path="shipGrade" value="C" />C

Description:  <form:textarea path="shipDesc" />

<input type="submit" value="create" />

</pre>

</form:form>
${message }
</body>
</html>