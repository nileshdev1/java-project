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
<form:form action="save" method="POST" modelAttribute="uom">
<h3>Welcome To UOM RegisterPage</h3>
		<pre>
UOM Type: 
		<form:select path="uomType">
		<form:option value=" ">-SELECT-</form:option>
		<form:option value="Packing">PACKING</form:option>
		<form:option value="NoPacking">NO-PACKING</form:option>
		<form:option value="">-NA-</form:option>
</form:select>

UOM MODEL: <form:input path="uomModel" />

Description:  <form:textarea path="uomDesc" />

<input type="submit" value="create uom" />

</pre>

</form:form>
${message }
</body>
</html>