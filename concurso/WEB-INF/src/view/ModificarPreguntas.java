package view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModificarPreguntas extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		req.setAttribute("busqueda", controller.Administrador.preguntas());
		req.setAttribute("mensajeInsertar", "");
		req.setAttribute("info", "");
		String eliminar = req.getParameter("eliminar");
		String modificar = req.getParameter("modificar");
		String buscar = req.getParameter("buscar");
		String botonBuscar = req.getParameter("botonBuscar");
		String idP = req.getParameter("di");
		String idS = req.getParameter("id");
		String nueva = req.getParameter("nueva");
		
		if(nueva != null){
			
			app.getRequestDispatcher("/WEB-INF/jsp/crearPregunta.jsp").forward(req, resp);
			return;
		}
		
		if(idS != null && eliminar != null){
			
			int id = Integer.parseInt(idS);
			if(controller.Administrador.borrarPregunta(id)){
				
				req.setAttribute("info", "Pregunta borrada correctamente");
				app.getRequestDispatcher("/WEB-INF/jsp/modificarPreguntas.jsp").forward(req, resp);
				return;
			}else{
				req.setAttribute("info", "Error al borrar la pregunta");
			}
		}
		
		if(idP != null && modificar != null){
			
			req.setAttribute("id", idP);
			app.getRequestDispatcher("/WEB-INF/jsp/modificarPreguntasDos.jsp").forward(req, resp);
			return;
		}
		
		if( buscar != null && botonBuscar != null){
			
			req.setAttribute("busqueda", controller.Administrador.buscarPreguntas(buscar));
			app.getRequestDispatcher("/WEB-INF/jsp/modificarPreguntas.jsp").forward(req, resp);
			return;
		}else{
		
		app.getRequestDispatcher("/WEB-INF/jsp/modificarPreguntas.jsp").forward(req, resp);	
		req.setAttribute("info", "");
		return;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
