<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Popolazione Totale</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${cities}" var="c">
						<c:choose>
					         <c:when test = "${c.capital == true}">
					            <tr style="color: red;">
									<td>${c.name}</td>			
									<td>${c.population}</td>
								</tr>
					         </c:when>					         
					         <c:otherwise>
					            <tr>
									<td>${c.name}</td>			
									<td>${c.population}</td>
								</tr>
					         </c:otherwise>
					      </c:choose>	
					</c:forEach>
			</tbody>
		</table>
		<form action="CountryServlet">
			<input type="hidden" name="back" value="true">
			<input type="submit" value="back">
		</form>
	</div>
</body>
</html>