package servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cosas;


public class Buscar extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext app = getServletContext();

		String buscar = req.getParameter("buscar");
		
		req.setAttribute("arboles", Cosas.getBuscar(buscar, "arboles"));
		req.setAttribute("arbustos", Cosas.getBuscar(buscar, "arbustos"));
		req.setAttribute("flores", Cosas.getBuscar(buscar, "flores"));
		req.setAttribute("semillas", Cosas.getBuscar(buscar, "semillas"));
		req.setAttribute("utiles", Cosas.getBuscar(buscar, "utiles"));
		req.setAttribute("mobiliario", Cosas.getBuscar(buscar, "mobiliario"));
		app.getRequestDispatcher("/WEB-INF/jsp/buscar.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}