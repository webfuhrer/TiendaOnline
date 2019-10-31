package proyectotienda;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		if (accion.equals("comprar"))
		{
			String id=request.getParameter("id");
			Producto p=AccesoDatos.obtenerProductoPorId(id);
			HttpSession s=request.getSession();
			ArrayList<Producto> carrito=(ArrayList<Producto>) s.getAttribute("carrito");
			if (carrito==null)
			{
				carrito=new ArrayList<>();
				carrito.add(p);
				s.setAttribute("carrito",carrito);
			}
			else
			{
				carrito.add(p);
				
			}
			ArrayList<Producto> lista=AccesoDatos.obtenerProductos();
			request.setAttribute("lista_productos", lista);
			request.getRequestDispatcher("comprar.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		boolean usuario_correcto=AccesoDatos.verificarUsuario(usuario, password);
		if (usuario_correcto)
		{
			//Montar los productos en attribute
			ArrayList<Producto> lista=AccesoDatos.obtenerProductos();
			request.setAttribute("lista_productos", lista);
			//Montar al usuario en session
			HttpSession s=request.getSession();
			s.setAttribute("usuario", usuario);
			request.getRequestDispatcher("comprar.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("indice.jsp").forward(request, response);
		}
	}

}
