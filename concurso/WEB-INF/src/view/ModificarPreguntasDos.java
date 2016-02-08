package view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModificarPreguntasDos extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		String enviar = req.getParameter("enviar");
		String id = req.getParameter("id");
		String pregunta = req.getParameter("pregunta");
		int idi = Integer.parseInt(id);
		
		if(enviar != null && id != null && pregunta != null){
			
			controller.Administrador.modificarPregunta(pregunta, idi);
			req.setAttribute("info", "");
			app.getRequestDispatcher("/WEB-INF/jsp/modificarPreguntas.jsp").forward(req, resp);
			return;
		}
		app.getRequestDispatcher("/WEB-INF/jsp/modificarPreguntasDos.jsp").forward(req, resp);
		return;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}