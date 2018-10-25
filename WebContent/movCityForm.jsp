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
			<c:forEach items="${city}" var="c">
				<span>${c.name}</span><input type="checkbox" name ="city" value=" ${c.id}"><br>
			</c:forEach>
		<select name="nationTo">
			<c:forEach items="${nation}" var="c">
				<option value="${c.countryCode}">${c.name}</option>
			</c:forEach>
		</select>
		<input type="submit" name="sub" value="Trasferisci">
	</form>
</body>
</html>