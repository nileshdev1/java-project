<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="orderMethod">
<h3>Welcome To OrderMethod RegisterPage</h3>
<pre>
OrderMode: <form:radiobutton path="orderMode" value="Sale"/>Sale
		   <form:radiobutton path="orderMode" value="Purchase"/>Purchase
		   
Order Code: <form:input path="orderCode"/>

OrderType: <form:select path="orderType">s
		<form:option value="">-SELECT-</form:option>
		<form:option value="fifo">FIFO</form:option>
		<form:option value="lifo">LIFO</form:option>
		<form:option value="fcfo">FCFO</form:option>
		<form:option value="fefo">FEFO</form:option>
</form:select>

OrderAccept: <form:checkbox path="orderAccept" value="acceptreturn"/>AcceptReturn

Description:  <form:textarea path="description"/>

<input Type="submit" value=create>


</pre>

</form:form>
${message }
</body>
</html>