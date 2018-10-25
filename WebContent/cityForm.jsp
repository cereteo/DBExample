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
		<c:choose>
			<c:when test="${city.id == null}">
				<form action="AddFormServlet">
			</c:when>
			<c:otherwise>
				<form action="ModFormServlet">
			</c:otherwise>
		</c:choose>
		<input type="text" name="city" placeholder="Inserisci la città" value="${city.name}">
		<input type="number" name="population" placeholder="Inserisci la popolazione" value="${city.population}">
		<input type="hidden" name="id" value="${city.id}">
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
		<input type="submit" name="sub" value="Aggiungi">
	</form>
</body>
</html>