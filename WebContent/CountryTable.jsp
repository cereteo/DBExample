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
					<c:forEach items="${country}" var="c">
						<tr>
								<td>
								<form action="CitiesServlet">
									<input type="hidden" name="selectedCountry" value="${c.countryCode}">
									<input type="submit" value="${c.name}">
								</form>		
								
								</td>					
							<td>${c.surfaceArea}</td>
							<td>${c.population}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		<form action="ContinentServlet">
			<input type="hidden" name="back" value="true">
			<button type="submit" class="button">
				 <i class="fas fa-long-arrow-alt-left"></i>
			</button>
		</form>
	</div>
</body>
</html>