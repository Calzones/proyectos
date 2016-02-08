package view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarRespuestas extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		req.setAttribute("mensajeInsertar", "");
		req.setAttribute("info", "");
		req.setAttribute("busqueda", controller.Administrador.respuestas());
		String eliminar = req.getParameter("eliminar");
		String modificar = req.getParameter("modificar");
		String buscar = req.getParameter("buscar");
		String botonBuscar = req.getParameter("botonBuscar");
		String idP = req.getParameter("di");
		String idS = req.getParameter("id");
		String nueva = req.getParameter("nueva");
		
		if(nueva != null){
			
			app.getRequestDispatcher("/WEB-INF/jsp/crearRespuesta.jsp").forward(req, resp);
			return;
		}
		
		if(idS != null && eliminar != null){
			
			System.out.println("hola holita");
			int id = Integer.parseInt(idS);
			if(controller.Administrador.borrarRespuesta(id)){
				
				
				req.setAttribute("info", "Respuesta borrada correctamente");
				app.getRequestDispatcher("/WEB-INF/jsp/modificarRespuestas.jsp").forward(req, resp);
				return;
			}else{
				req.setAttribute("info", "Error al borrar la pregunta");
			}
		}
		
		if(idP != null && modificar != null){
			
			req.setAttribute("id2", idP);
			app.getRequestDispatcher("/WEB-INF/jsp/modificarRespuestasDos.jsp").forward(req, resp);
			return;
		}
		
		if( buscar != null && botonBuscar != null){
				
			req.setAttribute("busqueda", controller.Administrador.buscarRespuestas(buscar));
			app.getRequestDispatcher("/WEB-INF/jsp/modificarRespuestas.jsp").forward(req, resp);
			return;
		}else{
		
		app.getRequestDispatcher("/WEB-INF/jsp/modificarRespuestas.jsp").forward(req, resp);	
		req.setAttribute("info", "");
		return;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}