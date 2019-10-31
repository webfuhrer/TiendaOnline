package proyectotienda;

public class Producto {
private String nombre, ruta_imagen;
private float precio;
private int id, stock;
public Producto(String nombre, String ruta_imagen, float precio, int id, int stock) {
	super();
	this.nombre = nombre;
	this.ruta_imagen = ruta_imagen;
	this.precio = precio;
	this.id = id;
	this.stock = stock;
}
public String getNombre() {
	return nombre;
}
public String getRuta_imagen() {
	return ruta_imagen;
}
public float getPrecio() {
	return precio;
}
public int getId() {
	return id;
}
public int getStock() {
	return stock;
}
@Override
public String toString() {
	return "Producto [nombre=" + nombre + ", ruta_imagen=" + ruta_imagen + ", precio=" + precio + ", id=" + id
			+ ", stock=" + stock + "]";
}

}
