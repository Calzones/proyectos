package servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.Clientes;
import model.Cosas;

public class Comprar extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		HttpSession session = req.getSession();
		Clientes c = (Clientes) session.getAttribute("clientes");
		String usuario = c.getUsuario();
		
		Cosas.algoPorAhora(Cosas.getPedido2(usuario), usuario);
	
		
		app.getRequestDispatcher("/WEB-INF/jsp/buscar.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}