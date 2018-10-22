<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mod</title>
</head>
<body>
	<form action="ModFormServlet">
		<input type="text" name="city" placeholder="Inserisci la città" value="${name}">
		<input type="number" name="population" placeholder="Inserisci la popolazione" value="${population}">
		<select name="nation">
			<c:forEach items="${country}" var="c">
				<c:choose>
						<c:when test="${c.countryCode == selectedCountry}">
			            	 <option value="${c.countryCode}" selected> ${c.name}</option>
				         </c:when>         
				         <c:otherwise>
				            <option value="${c.countryCode}"> ${c.name}</option>
				         </c:otherwise>
				 </c:choose>
			</c:forEach>
		</select>
		<input type="hidden" name="id" value="${id}">
		<input type="submit" name="sub" value="Aggiungi">
	</form>
</body>
</html>