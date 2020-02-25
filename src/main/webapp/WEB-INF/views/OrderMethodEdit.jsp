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
<form:form action="update" method="post" modelAttribute="ordermethod">
<pre>
ORDER ID:  <form:input path="orderId" readonly="true"/>

OrderMode: <form:radiobutton path="orderMode" value="sale"/>Sale
		   <form:radiobutton path="orderMode" value="purchase"/>Purchase
		   
Order Code: <form:input path="orderCode"/>

OrderType: <form:select path="orderType">
		<form:option value="">-SELECT-</form:option>
		<form:option value="fifo">FIFO</form:option>
		<form:option value="lifo">LIFO</form:option>
		<form:option value="fcfo">FCFO</form:option>
		<form:option value="fefo">FEFO</form:option>
</form:select>

OrderAccept: <form:checkbox path="orderAccept" value="acceptreturn"/>AcceptReturn

Description:  <form:textarea path="description"/>

<input type="submit" value="update" />

</pre>

</form:form>
</body>
</html>