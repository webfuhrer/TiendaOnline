package proyectotienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoDatos {
	private static String usr_bd="root";
	private static String pwd_bd="";
	private static String ruta_bd="jdbc:mysql://localhost:3306/tienda?serverTimeZone=UTC";
public static boolean verificarUsuario(String usr, String pwd)
{
	boolean aux=false;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(ruta_bd, usr_bd, pwd_bd);
		String sql="SELECT * FROM usuarios WHERE usuario=? AND password=?";
		PreparedStatement stmt =c.prepareStatement(sql);
		stmt.setString(1, usr);
		stmt.setString(2, pwd);
		ResultSet rs=stmt.executeQuery();
		if (rs.next())
		{
			aux=true;
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return aux;
}
public static ArrayList<Producto> obtenerProductos() {
	ArrayList<Producto> lista_productos=new ArrayList<>();
	try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c=DriverManager.getConnection(ruta_bd, usr_bd, pwd_bd);
	String sql="SELECT * FROM productos";
	PreparedStatement ps=c.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
			{
				int id=rs.getInt("id");
				int stock=rs.getInt("stock");
				String nombre=rs.getString("nombre");
				String ruta_imagen=rs.getString("ruta_imagen");
				float precio=rs.getFloat("precio");
				Producto p=new Producto(nombre, ruta_imagen, precio, id, stock);
				lista_productos.add(p);
			}
	}
	catch (Exception e)
	{
		
	}
	return lista_productos;
}
public static Producto obtenerProductoPorId(String id) {
	Producto p=null;
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c=DriverManager.getConnection(ruta_bd, usr_bd, pwd_bd);
	String sql="SELECT * FROM productos where id=?";
	PreparedStatement ps=c.prepareStatement(sql);
	ps.setInt(1, Integer.parseInt(id));
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		//int id=rs.getInt("id");
		int stock=rs.getInt("stock");
		String nombre=rs.getString("nombre");
		String ruta_imagen=rs.getString("ruta_imagen");
		float precio=rs.getFloat("precio");
		p=new Producto(nombre, ruta_imagen, precio, Integer.parseInt(id), stock);
		
	}
	
	
	}
	catch(Exception e)
	{
		
	}
	return p;
}

}
