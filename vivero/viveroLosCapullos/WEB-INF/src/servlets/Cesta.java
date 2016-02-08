package servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import forms.Clientes;
import model.Cosas;

public class Cesta extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletContext app = getServletContext();
		HttpSession session = req.getSession();
		Clientes c = (Clientes) session.getAttribute("clientes");
		String cantidadPedido = req.getParameter("cantidadPedido");
		String cantidad = req.getParameter("cantidad");
		String paginaOrigen = req.getParameter("paginaOrigen");
		String nombre = req.getParameter("nombre");
		String precio = req.getParameter("precio");
		String fotos = req.getParameter("fotos");
		String tipo = req.getParameter("tipo");
		String usuario = c.getUsuario();	
		
		
		if (usuario != null){
			if (paginaOrigen !=null) {
				Cosas.setPedido(nombre, cantidadPedido, usuario, precio, fotos, cantidad, tipo);
				if (paginaOrigen.equals("arboles")){
					req.setAttribute("arboles", Cosas.getNombreArboles());
					app.getRequestDispatcher("/WEB-INF/jsp/arboles.jsp").forward(req,resp);
				}
				if (paginaOrigen.equals("arbustos")){
					req.setAttribute("arbustos", Cosas.getNombreArbustos());
					app.getRequestDispatcher("/WEB-INF/jsp/arbustos.jsp").forward(req,resp);
				}
				if (paginaOrigen.equals("flores")){
					req.setAttribute("flores", Cosas.getNombreFlores());
					app.getRequestDispatcher("/WEB-INF/jsp/flores.jsp").forward(req,resp);
				}
				if (paginaOrigen.equals("mobiliario")){
					req.setAttribute("mobiliario", Cosas.getNombreMobiliario());
					app.getRequestDispatcher("/WEB-INF/jsp/mobiliario.jsp").forward(req,resp);
				}
				if (paginaOrigen.equals("semillas")){
					req.setAttribute("semillas", Cosas.getNombreSemillas());
					app.getRequestDispatcher("/WEB-INF/jsp/semillas.jsp").forward(req,resp);
				}
				if (paginaOrigen.equals("servicios")){
					req.setAttribute("servicios", Cosas.getNombreServicios());
					app.getRequestDispatcher("/WEB-INF/jsp/servicios.jsp").forward(req,resp);
				}
				if (paginaOrigen.equals("utiles")){
					req.setAttribute("utiles", Cosas.getNombreUtiles());
					app.getRequestDispatcher("/WEB-INF/jsp/utiles.jsp").forward(req,resp);
				}
				
			} else {
				req.setAttribute("cesta", Cosas.getPedido(usuario));
				app.getRequestDispatcher("/WEB-INF/jsp/cesta.jsp").forward(req, resp);
			}
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}