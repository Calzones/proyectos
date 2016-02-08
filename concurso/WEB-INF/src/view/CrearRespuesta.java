package view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearRespuesta extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		req.setAttribute("mensajeInsertar", "");
		String enviar = req.getParameter("enviar");
		String id = req.getParameter("id");
		String idPregunta = req.getParameter("idPregunta");
		String respuesta = req.getParameter("respuesta");
		String correcta = req.getParameter("correcta");
		int idi = Integer.parseInt(id);
		int idi2 = Integer.parseInt(idPregunta);
		
		if(enviar != null && id != null && correcta != null && respuesta != null && idPregunta != null){
			
			controller.Administrador.crearRespuesta(respuesta, idi, idi2, correcta);
			req.setAttribute("mensajeInsertar", "Respuesta insertada correctamente");
		}
		app.getRequestDispatcher("/WEB-INF/jsp/crearRespuesta.jsp").forward(req, resp);
		return;
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
