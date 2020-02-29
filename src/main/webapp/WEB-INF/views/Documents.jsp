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
<h3>WELCOME TO DOCUMENT PAGE</h3>
<form action="upload" method="post" enctype="multiPart/form-data">
<pre>
ID: <input type="text" name="fileId">
DOC: <input type="file" name="fileOb">
<input type="submit" value="upload">

</pre>
</form>
${message }
</body>
</html>