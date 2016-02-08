package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CerrarSesion  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		HttpSession session = req.getSession();
		session.removeAttribute("clientes");
		session.invalidate();
		req.setAttribute("errorInicio", "<br/>Para acceder a la pagina, debes de logearte");
		app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}