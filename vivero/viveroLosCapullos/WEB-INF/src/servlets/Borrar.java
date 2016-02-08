package servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cosas;

public class Borrar extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		String nombre = req.getParameter("nombre");
		String usuario = req.getParameter("usuario");
		String borrar = req.getParameter("borrar");
		
		
		if (borrar.equals("si")) {
			Cosas.delPedido(usuario, nombre);
		}
		req.setAttribute("cesta", Cosas.getPedido(usuario));
		app.getRequestDispatcher("/WEB-INF/jsp/cesta.jsp").forward(req, resp);
}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
