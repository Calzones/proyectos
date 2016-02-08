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

public class Inicio extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String user = req.getParameter("usuario");
		String pass = req.getParameter("contrasena");
		ServletContext app = getServletContext();
		Clientes c = new Clientes();
		Cosas cosas = new Cosas();
		
		
			
		
		if (!(user != null) || !(pass !=null)){
			req.setAttribute("errorInicio", "<br/>Para acceder a la pagina, debes de logearte");
			session.invalidate();
			app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);
		}else{
			if (user.equals("") || pass.equals("")){
				req.setAttribute("errorInicio", "Debes iniciar sesion para acceder");
				app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);
			}else{
				if (cosas.iniciarSesion(user, pass)){
					c.setContrasena(pass);
					c.setUsuario(user);
					session.setAttribute("clientes", c);
					app.getRequestDispatcher("/WEB-INF/jsp/principal.jsp").forward(req, resp);
				}else{
					req.setAttribute("errorInicio", "Usuario no registrado, registrate o inicia sesion para acceder");
					app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);
				}	
			}
			
		}	
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}	
}