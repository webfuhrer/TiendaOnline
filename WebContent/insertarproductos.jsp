<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    int rol=(Integer)session.getAttribute("rol");
    if(rol!=1)
    {
    	request.getRequestDispatcher("indice.jsp").forward(request, response);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="MiServlet" method="POST">
<INPUT TYPE="text" name="nombre" placeholder="introduzca el nombre">
<INPUT TYPE="number" name="stock" min=0 placeholder="introduzca el nombre">
<INPUT TYPE="number" name="precio" min=0 placeholder="introduzca el nombre">
<INPUT TYPE="text" name="ruta_imagen" min=0 placeholder="introduzca el nombre">
<input type="hidden" name="accion" value="insertarproducto">
<input type="submit" value="Grabar">
</form>
</body>
</html>