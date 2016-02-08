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

public class Perfil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tabla;
		ServletContext app = getServletContext();
		HttpSession session = req.getSession();
		Clientes c = (Clientes) session.getAttribute("clientes");
		
		tabla = Cosas.getDatosPerfil(c.getUsuario());
		req.setAttribute("perfil", tabla);
		app.getRequestDispatcher("/WEB-INF/jsp/perfil.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
