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
	<div>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Città</th>
					<th>Popolazione</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
	</div>
	
	<c:forEach items="${cities}" var="c">
		<p>${c.name} - ${c.district} + ${c.population}</p>
	</c:forEach>
</body>
</html>