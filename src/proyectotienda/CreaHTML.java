package proyectotienda;

import java.util.ArrayList;

public class CreaHTML {
public static String crearTabla(ArrayList<Producto> productos)
	{
		//imagen, nombre, precio, stock, comprar
	String table="<table class='estilo_tabla'>";
	table+="<tr><th>Imagen</th><th>Nombre</th><th>Precio</th>"
			+ "<th>Stock</th><th>Comprar</th><tr>";
	for(Producto p: productos)
		{
			table+="<tr><td><img src='"+p.getRuta_imagen()+"'></td>";
			table+="<td>"+p.getNombre()+"</td><td>"+p.getPrecio()+"</td>";
			table+="<td>"+p.getStock()+"</td>";
			table+="<td><a href='MiServlet?accion=comprar&id="+p.getId()+"'>Comprar</a></td>";
			table+="</tr>";
			
		}
	table+="</table>";
	return table;
	}

public static String pintarTablaCarrito(ArrayList<Producto> carrito)
{
	
	String table="<table class='estilo_tabla'>";
	table+="<tr><th>Nombre</th><th>Precio</th>"
			+ "<tr>";
	float total=0;
	
	for(Producto p: carrito)
		{
			//table+="<tr><td><img src='"+p.getRuta_imagen()+"'></td>";
			table+="<tr><td>"+p.getNombre()+"</td><td>"+p.getPrecio()+"</td>";
			//table+="<td>"+p.getStock()+"</td>";
			//table+="<td><a href='MiServlet?accion=comprar&id="+p.getId()+"'>Comprar</a></td>";
			
			table+="</tr>";
			total+=p.getPrecio();
			
		}
	table+="<tr><td>TOTAL:</td><td>"+total+"</td></tr>";
	table+="</table>";
	return table;
}
}
