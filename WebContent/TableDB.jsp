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
					<th>Superficie Totale</th>
					<th>Popolazione Totale</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${continents}" var="c">
						<tr>
								<td>
								<form action="CountryServlet">
									<input type="submit" name="selectedContinent" value="${c.continent}">
								</form>		
								
								</td>					
							<td>${c.totSurfaceArea}</td>
							<td>${c.totPopulation}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>