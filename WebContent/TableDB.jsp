<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="SearchServlet" style="max-width:800px; margin: 5px auto;">
		<input type="search" class="search" name="search" placeholder="Ricerca città">
		<button class="buttonsearch"><i class="fas fa-search"></i></button>
	</form>
</div>
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