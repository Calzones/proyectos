package view;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Inicio extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String user = req.getParameter("usuario");
		ServletContext app = getServletContext();
		
		HttpSession session = req.getSession();
		Calendar inicio = Calendar.getInstance();
		long in =  inicio.getTimeInMillis();
		session.setAttribute("inicio", in);
		session.setAttribute("usuario", user);
		
		if (user == null){
			req.setAttribute("errorInicio", "");
			app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);
		}else{
			if (user.equals("")){
				req.setAttribute("errorInicio", "Debes indicar un usuario para acceder");
				app.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(req, resp);
			}else{
				controller.PreguntasRespuestas.generarPreguntas();
				req.setAttribute("respuesta", "");
				req.setAttribute("terminado", "");
				app.getRequestDispatcher("/WEB-INF/jsp/preguntas.jsp").forward(req, resp);
			}			
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}	
}