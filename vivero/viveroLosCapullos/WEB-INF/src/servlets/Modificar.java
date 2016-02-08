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

public class Modificar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String pass = req.getParameter("contrasena");
		String pass1 = req.getParameter("contrasena1");
		String local = req.getParameter("localidad");
		String direcc = req.getParameter("direccion");
		String postal = req.getParameter("cpostal");

		ServletContext app = getServletContext();

		HttpSession session = req.getSession();
		Clientes c = (Clientes) session.getAttribute("clientes");

		Cosas cosas = new Cosas();
		req.setAttribute("errorModificarRegistro", "");
		if ((pass == null) || (pass1 == null) || (local == null)
				|| (direcc == null) || (postal == null)) {
			req.setAttribute("errorModificarRegistro", "");
			app.getRequestDispatcher("/WEB-INF/jsp/modificar.jsp").forward(req,
					resp);
		} else {
			if (!(pass.equals("")) && (pass.equals(pass1))) {
				cosas.modificar("contrasena", pass, c.getUsuario());
				req.setAttribute("errorModificarRegistro", "Modificado");
			}
			if (!(local.equals(""))) {
				cosas.modificar("localidad", local, c.getUsuario());
				req.setAttribute("errorModificarRegistro", "Modificado");
			}
			if (!(direcc.equals(""))) {
				cosas.modificar("direccion", direcc, c.getUsuario());
				req.setAttribute("errorModificarRegistro", "Modificado");
			}
			if (!(postal.equals(""))) {
				cosas.modificar("cPostal", postal, c.getUsuario());
				req.setAttribute("errorModificarRegistro", "Modificado");
			}
			app.getRequestDispatcher("/WEB-INF/jsp/modificar.jsp").forward(
					req, resp);
			req.setAttribute("errorModificarRegistro", "");
		}
		req.setAttribute("errorModificarRegistro", "");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}