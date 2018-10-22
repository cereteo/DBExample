<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Move</title>
</head>
<body>
	<form action="MovFormServlet">
		<select name="nationFrom">
			<c:forEach items="${country}" var="c">
				<option value="${c.countryCode}"> ${c.name}</option>
			</c:forEach>
		</select>
		<select name="nationTo">
			<c:forEach items="${country}" var="c">
				<option value="${c.countryCode}"> ${c.name}</option>
			</c:forEach>
		</select>
		<input type="submit" name="sub" value="Trasferisci">
	</form>
</body>
</html>