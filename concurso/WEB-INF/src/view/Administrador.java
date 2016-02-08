package view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Administrador extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = req.getParameter("usuario");
		String pass = req.getParameter("contrasena");
		ServletContext app = getServletContext();
		
		req.setAttribute("errorAdministrador", "");
		if (!(user != null) || !(pass !=null)){
			req.setAttribute("errorAdministrador", "");
			app.getRequestDispatcher("/WEB-INF/jsp/administrador.jsp").forward(req, resp);
		}else{
			if (user.equals("") || pass.equals("")){
				req.setAttribute("errorAdministrador", "Debes iniciar sesion para acceder");
				app.getRequestDispatcher("/WEB-INF/jsp/administrador.jsp").forward(req, resp);
			}else{
				if (user.equals("admin") && pass.equals("admin")){
					app.getRequestDispatcher("/WEB-INF/jsp/panelControl.jsp").forward(req, resp);
				}else{
					req.setAttribute("errorAdministrador", "Usuario no registrado, inicia sesion con un usuario valido para acceder");
					app.getRequestDispatcher("/WEB-INF/jsp/administrador.jsp").forward(req, resp);
				}	
			}
		}	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}