<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="java.util.ArrayList,modelos.Contacto" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>Nombre</td>
			<td>Telefono</td>
		</tr>
		<% ArrayList<Contacto> lista=(ArrayList<Contacto>)request.getAttribute("listado");
		for(Contacto c : lista){
		%>
		<tr>
			<td><%= c.getNombre() %></td>
			<td><%= c.getTelefono() %></td>
		</tr>
		<% } %>
	</table>
	<form action="Principal" method="POST">
		<label for="nombre">Nombre: </label> 
		<input type="text" name="nombre" id="nombre" placeholder="Escriba aqui el nombre" /> 
		<br /> 
		<label for="telefono">Telefono: </label> 
		<input type="text" name="telefono" id="telefono" placeholder="Escriba aqui el telefono" />
		<br/>
		<button type="submit">Enviar</button>
	</form>
	<a href="Principal">Recargar</a>
</body>
</html>