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
		<div>
			<form action="OpenFormServlet">
				<input type="hidden" name="form" value="Add">
				<input type="submit" value="Aggiungi">
			</form>
			<form action="OpenFormServlet">
				<input type="hidden" name="form" value="Move">
				<input type="submit" value="Trasferisci città">
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Popolazione Totale</th>
					<th>Modifica</th>
					<th>Cancella</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${cities}" var="c">
						<c:choose>
					         <c:when test = "${c.capital == true}">
					            <tr style="color: red;">
									<td>${c.name}</td>			
									<td>${c.population}</td>
									<td>
										<form action="OpenFormServlet">
											<input type="hidden" name="name" value="${c.name}">
											<input type="hidden" name="population" value="${c.population}">
											<input type="hidden" name="id" value="${c.id}">
											<input type="hidden" name="form" value="Modify">
											<input type="submit" value="modifica">
										</form>
									</td>
									<td>
										<form action="DelFormServlet">
											<input type="hidden" value="${c.id}">
											<input type="submit" value="rimuovi">
										</form>
									</td>
								</tr>
					         </c:when>					         
					         <c:otherwise>
					            <tr>
									<td>${c.name}</td>			
									<td>${c.population}</td>
									<td>
										<form action="OpenFormServlet">
											<input type="hidden" name="name" value="${c.name}">
											<input type="hidden" name="population" value="${c.population}">
											<input type="hidden" name="id" value="${c.id}">
											<input type="hidden" name="form" value="Modify">
											<input type="submit" value="modifica">
										</form>
									</td>
									<td>
										<form action="DelFormServlet">
											<input type="hidden" name="id" value="${c.id}">
											<input type="submit" value="rimuovi">
										</form>
									</td>
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