<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddFormServlet">
		<input type="text" name="city" placeholder="Inserisci la città">
		<input type="number" name="population" placeholder="Inserisci la popolazione">
		<select name="nation">
			<c:forEach items="${country}" var="c">
				<option value="${c.countryCode}"> ${c.name}</option>
			</c:forEach>
		</select>
		<input type="submit" name="sub" value="Aggiungi">
	</form>
</body>
</html>