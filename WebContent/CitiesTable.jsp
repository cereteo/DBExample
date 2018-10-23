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
		<div>
			<form action="OpenFormServlet" style="float: left; margin: 0 15px;">
				<input type="hidden" name="form" value="Add">
				<button type="submit" class="button">
					<i class="fas fa-plus"></i>
				</button>
			</form>
			<form action="OpenFormServlet">
				<input type="hidden" name="form" value="Move">
				<button type="submit" class="button">
					<i class="fas fa-exchange-alt"></i>
				</button>
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
											<button type="submit">
												<i class="fas fa-edit"></i>
											</button>
										</form>
									</td>
									<td>
										<form action="DelFormServlet">
											<input type="hidden" value="${c.id}">
											<button type="submit">
												<i class="fas fa-trash-alt"></i>
											</button>
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
											<button type="submit">
												<i class="fas fa-edit"></i>
											</button>
										</form>
									</td>
									<td>
										<form action="DelFormServlet">
											<input type="hidden" name="id" value="${c.id}">
											<button type="submit">
												<i class="fas fa-trash-alt"></i>
											</button>
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
			<button type="submit" class="button">
				 <i class="fas fa-long-arrow-alt-left"></i>
			</button>
		</form>
	</div>
</body>
</html>