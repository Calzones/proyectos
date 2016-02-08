package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Cosas;

public class Utiles extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		ServletContext app = getServletContext();
				
		req.setAttribute("utiles", Cosas.getNombreUtiles());
		app.getRequestDispatcher("/WEB-INF/jsp/utiles.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		doGet(req, resp);
	}	
}