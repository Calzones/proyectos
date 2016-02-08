package view;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.PreguntasRespuestas;


public class Preguntas extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		ServletContext app = getServletContext();
		
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("usuario");
		
		String respuesta1 = req.getParameter("opcion1");
		String respuesta2 = req.getParameter("opcion2");
		String respuesta3 = req.getParameter("opcion3");
		String respuesta4 = req.getParameter("opcion4");
		String correcta = req.getParameter("respuesta");
		
		if(respuesta1 != null){
			if(respuesta1.equals(correcta)){
					
				PreguntasRespuestas.cont = PreguntasRespuestas.cont + 1;
				req.setAttribute("respuesta", "correcta");
			}else{
					
				PreguntasRespuestas.cont = 1;
				req.setAttribute("respuesta", "incorrecta");
			}
		}
		if(respuesta2 != null){
			if(respuesta2.equals(correcta)){
					
				PreguntasRespuestas.cont = PreguntasRespuestas.cont + 1;
				req.setAttribute("respuesta", "correcta");
			}else{
					
				PreguntasRespuestas.cont = 1;
				req.setAttribute("respuesta", "incorrecta");
			}
		}
		if(respuesta3 != null){
			if(respuesta3.equals(correcta)){
					
				PreguntasRespuestas.cont = PreguntasRespuestas.cont + 1;
				req.setAttribute("respuesta", "correcta");
			}else{
					
				PreguntasRespuestas.cont = 1;
				req.setAttribute("respuesta", "incorrecta");
			}
		}
		if(respuesta4 != null){
			if(respuesta4.equals(correcta)){
					
				PreguntasRespuestas.cont = PreguntasRespuestas.cont + 1;
				req.setAttribute("respuesta", "correcta");
			}else{
					
				PreguntasRespuestas.cont = 1;
				req.setAttribute("respuesta", "incorrecta");
			}
		}
		if(PreguntasRespuestas.cont == 11){
			
			Calendar fin = Calendar.getInstance();
			long fn = fin.getTimeInMillis();
			long in = (long) session.getAttribute("inicio");
			long diff = fn - in;
			int diffsegundos = (int) (diff / (1000));
			int min = diffsegundos / 60;  
	        int seg = diffsegundos -((min * 60));
	        
	        Date fech = new Date();
	        String fecha = fech.toString();
	        
			userName = (String) session.getAttribute("usuario");
			String cadena = "El usuario " + userName + " ha tardado: " + min + " minuto/s y " + seg + "segundo/s.";
			req.setAttribute("terminado", cadena);
			controller.Usuario.setUsuario(userName, diffsegundos, fecha);
			app.getRequestDispatcher("/WEB-INF/jsp/fin.jsp").forward(req, resp);
		}else{
			req.setAttribute("respuesta", "");
			app.getRequestDispatcher("/WEB-INF/jsp/preguntas.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}