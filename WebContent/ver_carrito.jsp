<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>
    <%@page import="proyectotienda.*" %>
<!DOCTYPE html>
<%
ArrayList<Producto> carrito=(ArrayList<Producto>)session.getAttribute("carrito");
String texto_comprado="No hay productos en el carrito";
if (carrito!=null)
{
	texto_comprado=CreaHTML.pintarTablaCarrito(carrito);
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="compra">
<%=texto_comprado %>
</div>
</body>
</html>