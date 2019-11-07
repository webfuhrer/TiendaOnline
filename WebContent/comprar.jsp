<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="proyectotienda.*" %>
<!DOCTYPE html>
<%
String nombre=(String)session.getAttribute("usuario");
int rol=(Integer)session.getAttribute("rol");
ArrayList<Producto> lista=(ArrayList<Producto>)request.getAttribute("lista_productos");
String tabla=CreaHTML.crearTabla(lista);
%>
<html>
<head>
<style>
.estilo_tabla
{
border: 2px solid blue;
background-color: cyan;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Bienvenido <%=nombre%>
<a href="ver_carrito.jsp">Ver carrito</a>
<%=tabla%>
<%if (rol==1){ %>
<a href="insertarproductos.jsp">Insertar productos</a>
<%} %>
<div class="comprado">

</div>
</body>
</html>