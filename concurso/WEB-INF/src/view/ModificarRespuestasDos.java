package view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModificarRespuestasDos extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		String enviar = req.getParameter("enviar");
		String pregunta = req.getParameter("pregunta");
		String correcta = req.getParameter("correcta");
		String id = req.getParameter("id");
		int idi = Integer.parseInt(id);
		
		if(enviar != null && pregunta != null && id != null && correcta != null){
			
			controller.Administrador.modificarRespuesta(pregunta, correcta, idi);
			req.setAttribute("info", "");
			app.getRequestDispatcher("/WEB-INF/jsp/modificarRespuestas.jsp").forward(req, resp);
			return;
		}
		app.getRequestDispatcher("/WEB-INF/jsp/modificarRespuestasDos.jsp").forward(req, resp);
		return;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}