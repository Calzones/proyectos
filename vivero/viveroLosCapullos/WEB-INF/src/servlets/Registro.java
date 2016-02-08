package servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cosas;

public class Registro extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = req.getParameter("usuario");
		String pass = req.getParameter("contrasena");
		String pass1 = req.getParameter("contrasena1");
		String local = req.getParameter("localidad");
		String direcc = req.getParameter("direccion");
		String postal = req.getParameter("cpostal");
		ServletContext app = getServletContext();
		Cosas cosas = new Cosas();
		req.setAttribute("errorRegistro", "");
		if (!(user != null) && !(pass != null) ){
			app.getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(req, resp);
		}else{
			if (pass.equals(pass1)){
				cosas.registrase(user, pass, pass1, local, direcc, postal );
				req.setAttribute("errorInicio", "Ya estas registrado ahora inicia session");
				app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);
				
			}else{
				req.setAttribute("errorRegistro", "Las contraseñas no coinciden");		
				app.getRequestDispatcher("/WEB-INF/jsp/registro.jsp").forward(req, resp);
			}
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}	
}