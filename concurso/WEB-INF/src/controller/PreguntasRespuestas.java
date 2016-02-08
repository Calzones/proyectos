package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.BaseDatos;

public class PreguntasRespuestas {
	
	private static BaseDatos bd;
	private static int num;
	public static int cont = 1;
	public static int cantidadPreguntas;
	private static int[] vector;
	private static String correct;
	private static String[] respuesta;
	private static int[] respues;
	
	public static void cuentar(){
		
		String sql = "SELECT COUNT(*) FROM preguntas";
		bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		try {
			rs.next();
			cantidadPreguntas = rs.getInt(1);
			
		} catch (SQLException e1) {
			System.out.println("Error en el cuentar");
		}
	}
	
	//-----Preguntas-----
	//Metodos preguntas aleatorias
 	public static void generarPreguntas() {
 		
		int[] victor = new int[10];
		int numero;
		cuentar();
		for (int i = 0; i < victor.length; i++) {
			
			do {
				
				numero = (int) ((Math.random()) * cantidadPreguntas + 1);
			} while (comprobarDiferentes(victor, i, numero));
			
			victor[i] = numero;
		}
		vector = victor;
	}

	public static boolean comprobarDiferentes(int[] victor, int i, int numero) {

		for (int j = 0; j < i; j++) {
			if (victor[j] == numero) {

				return true;
			}
		}
		return false;
	}

	public static int darPregunta(int numPregunta) {

		int pregunta = 0;

		for (int i = 0; i < 10; i++) {
			if (i == numPregunta-1) {
				pregunta = vector[i];
			}
		}
		return pregunta;
	}

	// Metodos obtener preguntas
	public static String getPreguntas() {
		if(cont > 10){
			cont = 1;
		}
		switch (cont) {

		case 1:
			num = darPregunta(1);
			break;
		case 2:
			num = darPregunta(2);
			break;
		case 3:
			num = darPregunta(3);
			break;
		case 4:
			num = darPregunta(4);
			break;
		case 5:
			num = darPregunta(5);
			break;
		case 6:
			num = darPregunta(6);
			break;
		case 7:
			num = darPregunta(7);
			break;
		case 8:
			num = darPregunta(8);
			break;
		case 9:
			num = darPregunta(9);
			break;
		case 10:
			num = darPregunta(10);
			break;
		case 11:
			num = 0;
			break;
		}
			
			String sql = "SELECT pregunta FROM preguntas WHERE (id LIKE " + num	+ ")";
			bd = new BaseDatos(sql);
			ResultSet rs = bd.executeQuery();
			return parsePreguntas(rs, cont);
		
	}
	
	public static String parsePreguntas(ResultSet rs, int cont) {

		StringBuffer sb = new StringBuffer();

		try {
			
			while (rs.next()) {
				
				sb.append(rs.getString("pregunta"));
				sb.append("<input type=hidden value=" + cont + " name=id>");
			}
		} catch (Exception e) {

			System.out.println("Error en parsePreguntas");
		}
		return sb.toString();
	}
	
	//-----Respuestas-----
	//Metodos respuestas aleatorias
	public static void generarRespuestas() {
		
		int[] victor = new int[4];
		int numero;
		for (int i = 0; i < victor.length; i++) {
			do {
				numero = (int)((Math.random()) * 4);
			} while (comprobarDiferentesR(victor, i, numero));
			victor[i] = numero;
		}
		respues = victor;
	}

	public static boolean comprobarDiferentesR(int[] victor, int i, int numero) {

		for (int j = 0; j < i; j++) {
			if (victor[j] == numero) {

				return true;
			}
		}
		return false;
	}
	
	// Metodos obtener respuestas
	public static String getRespuestas() {

		String sql = "SELECT opcion, correcto FROM opciones WHERE (idPreguntas LIKE " + num + ")";
		bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseRespuestas(rs);
	}
	
	public static void cortarRespuestas(ResultSet rs){
		String respuestas;
		String correcto = null;
		
		try {
			
			while(rs.next()){
				
				correcto = rs.getString("correcto");
				respuestas = rs.getString("opcion");
				respuesta = respuestas.split(";");
			}
			
			correct = correcto;
		} catch (SQLException e) {
			
			System.out.println("Problema al cortar");
		}
	}
	
	public static String parseRespuestas(ResultSet rs) {

		StringBuffer sb = new StringBuffer();
		cortarRespuestas(rs);
		generarRespuestas();
		try {				
				sb.append("<tr>");
					sb.append("<td>");
						sb.append("<input type=submit value='" + respuesta[respues[0]] + "' name=opcion1>");
					sb.append("</td>");
					sb.append("<td>");
						sb.append("<input type=submit value='" + respuesta[respues[1]] + "' name=opcion2>");
					sb.append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
					sb.append("<td>");
						sb.append("<input type=submit value='" + respuesta[respues[2]] + "' name=opcion3>");
					sb.append("</td>");
					sb.append("<td>");
						sb.append("<input type=submit value='" + respuesta[respues[3]] + "' name=opcion4>");
					sb.append("</td>");
					sb.append("<input type=hidden value='" + correct +  "' name=respuesta>");
				sb.append("</tr>");
		} catch (Exception e) {

			System.out.println("Error en parseRespuestas");
		}
		return sb.toString();
	}
}