<%@page import="br.com.pswmaycon.user.model.Empregado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Empregados</title>
</head>
<body>
	<%
	List<Empregado> empregados = (List<Empregado>) request.getAttribute("empregados");
	%>
	<table border="1" style="width: 50%" height="50%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>SobreNome</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Empregado empregado : empregados) {
			%>
			<tr>
				<td><%=empregado.getId()%></td>
				<td><%=empregado.getNome()%></td>
				<td><%=empregado.getSobreNome()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>