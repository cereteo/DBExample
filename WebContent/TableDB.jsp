<%@page import="it.objectmethod.jdbc.model.City"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.objectmethod.jdbc.servlets.DBExampleServlet"%>
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
			<%
				ArrayList<City> data = DBExampleServlet.dataFromDB();
				
					for(int i=0; i<data.size(); i++){
						out.print(String.format("<tr>"+
							"<td>"+data.get(i).getName()+"</td>"+
							"<td>"+data.get(i).getDistrict()+"</td>"+
							"<td>"+data.get(i).getPopulation()+"</td>"+
							"</tr>"
						));
					}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>