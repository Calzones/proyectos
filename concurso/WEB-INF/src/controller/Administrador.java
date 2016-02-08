package controller;

import java.sql.ResultSet;

import model.BaseDatos;

public class Administrador {
	
	private static BaseDatos bd;
	private static ResultSet rs;
	
	//-----Preguntas-----
	//ObtenerPreguntas
	public static String preguntas(){
		
		String sql = "SELECT * FROM preguntas";
		bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseoPreguntas(rs);
	}
	
	private static String parseoPreguntas(ResultSet rs){
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<form action=modificarPreguntas.do method=post>");
			sb.append("<input type=submit value=Nueva Pregunta name=nueva>");
			sb.append("<input type=text placeholder=Buscar name=buscar>");
			sb.append("<input type=submit value=Buscar name=botonBuscar>");
			sb.append("</form>");
			while (rs.next()) {
				sb.append("<form action=modificarPreguntas.do method=post>");
				sb.append("<tr>");
				sb.append("<td>" + rs.getString("id") + "</td>");
				sb.append("<td>" + rs.getString("pregunta") + "</td>");
				sb.append("<td><input type=submit value=Eliminar name=eliminar></td>");
				sb.append("<input type=hidden value='" + rs.getString("id") + "' name=id>");
				sb.append("<form action=modificarPreguntas.do method=post>");
				sb.append("<td><input type=submit value=Modificar name=modificar></td>");
				sb.append("<input type=hidden value='" + rs.getString("id") + "' name=di>");
				sb.append("</form>");
				sb.append("</form>");
			}
			
			sb.append("</tr>");
		} catch (Exception e) {

			System.out.println("Error en paseoPregunta");
		}
		return sb.toString();
	}
	
	//-----Respuestas-----
	//ObtenerRespuestas
	public static String respuestas(){
		
		String sql = "SELECT idpreguntas, opcion, correcto FROM opciones";
		bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseoRespuestas(rs);
	}
	
	private static String parseoRespuestas(ResultSet rs){
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<form action=modificarRespuestas.do method=post>");
			sb.append("<input type=submit value=Nueva Pregunta name=nueva>");
			sb.append("<input type=text placeholder=Buscar name=buscar>");
			sb.append("<input type=submit value=Buscar name=botonBuscar>");
			sb.append("</form>");
			while (rs.next()) {
				sb.append("<form action=modificarRespuestas.do method=post>");
				sb.append("<tr>");
				sb.append("<td>" + rs.getString("idpreguntas") + "</td>");
				sb.append("<td>" + rs.getString("opcion") + "</td>");
				sb.append("<td>" + rs.getString("correcto") + "</td>");
				sb.append("<input type=hidden value='" + rs.getString("idpreguntas") + "' name=id>");
				sb.append("<td><input type=submit value=Eliminar name=eliminar></td>");
				sb.append("</form>");
				sb.append("<form action=modificarRespuestas.do method=post>");
				sb.append("<input type=hidden value='" + rs.getString("idpreguntas") + "' name=di>");
				sb.append("<td><input type=submit value=Modificar name=modificar></td>");
				sb.append("</form>");
				
			}
			sb.append("</tr>");
		} catch (Exception e) {

			System.out.println("Error en parseoRespuestas");
		}
		return sb.toString();
	}
	
	//-----Operaciones-----
	//Buscar
	public static String buscarPreguntas(String buscar) {
		String sql;
		try{
			if(!buscar.equals("")){
				sql = "SELECT * FROM preguntas WHERE (id = ?)";
				bd = new BaseDatos(sql);
				//bd.setString(1, "%" + buscar + "%");	
				bd.setInt(1, Integer.parseInt(buscar));		
				rs = bd.executeQuery();
			}else{
				sql = "SELECT * FROM preguntas";
				bd = new BaseDatos(sql);
				rs = bd.executeQuery();
			}
		}catch(NumberFormatException e){
			System.out.println("Formato erroneo");
		}
		
		return parseoPreguntas(rs);
	}
	
	public static String buscarRespuestas(String buscar) {
		String sql;
		try{
			if(!buscar.equals("")){
			sql = "SELECT * FROM opciones WHERE (id =?)";
			bd = new BaseDatos(sql);
			//bd.setString(1, "%" + buscar + "%");
			bd.setInt(1, Integer.parseInt(buscar));
			rs = bd.executeQuery();
			}else{
				sql = "SELECT * FROM opciones";
				bd = new BaseDatos(sql);
				rs = bd.executeQuery();
			}
		}catch(NumberFormatException e){
			System.out.println("Formato erroneo");
		}
		return parseoRespuestas(rs);
	}
	
	//Eliminar
	public static boolean borrarRespuesta (int c) {
		
		String sql = "DELETE FROM opciones WHERE (id = ?)";
		
		BaseDatos bd = new BaseDatos(sql);
		bd.setInt(1, c);
		
		int numRows = bd.executeUpdate();
		if (numRows == 1)
			return true;
		else
			return false;
	}
	
	public static boolean borrarPregunta (int c) {
		
		String sql = "DELETE FROM preguntas WHERE (id = ?)";
		
		BaseDatos bd = new BaseDatos(sql);
		bd.setInt(1, c);
		
		int numRows = bd.executeUpdate();
		if (numRows == 1)
			return true;
		else
			return false;
	}	

	//Crear
	public static void crearPregunta(String pregunta, int id){
		
		String sql = "INSERT INTO preguntas VALUES (?, ?)";
		bd = new BaseDatos(sql);
		bd.setInt(1, id);
		bd.setString(2, pregunta);
		bd.executeUpdate();
	}
	
	public static void crearRespuesta(String respuesta, int id, int idi , String correcto){
		
		String sql = "INSERT INTO opciones VALUES (?, ?, ?, ?)";
		bd = new BaseDatos(sql);
		bd.setInt(1, id);
		bd.setInt(2, idi);
		bd.setString(3, respuesta);
		bd.setString(4, correcto);
		bd.executeUpdate();
	}
	
	//Editar
 	public static void modificarPregunta (String pregunta, int id){
		
		String sql = "UPDATE preguntas SET pregunta = ? WHERE id = ?";
		bd = new BaseDatos(sql);
		bd.setString(1, pregunta);
		bd.setInt(2, id);
		bd.executeUpdate();
	}
	
	public static String preguntaAModificar (int id){
		
		String sql = "SELECT * FROM preguntas where id = ?";
		bd = new BaseDatos(sql);
		bd.setInt(1, id);
		ResultSet rs = bd.executeQuery();
		return parseoPreguntaAModificar(rs);
	}
	
	private static String parseoPreguntaAModificar(ResultSet rs){
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<form action=modificarPreguntasDos.do method=post>");
			sb.append("<table><tr><td>Id</td><td>Pregunta</td></tr><tr><td>");
			while (rs.next()) {
				
				sb.append("<input readonly type=text name=id value='" + rs.getInt("id") + "' autocomplete=off>");
				sb.append("</td><td>");
				sb.append("<input type=text name=pregunta value='" + rs.getString("pregunta") + "'autocomplete=off>");
				sb.append("</td></tr><tr><td>");
				sb.append("<input type=submit name=enviar value=Enviar>");
			}
			sb.append("</td></tr></table>");
			sb.append("</form>");
		} catch (Exception e) {

			System.out.println("Error en parseoPreguntaAModificar");
		}
		return sb.toString();
	}
	
 	public static void modificarRespuesta (String pregunta, String correcta, int id){
		
		String sql = "UPDATE opciones SET opcion = ?, correcto = ? WHERE id = ?";
		bd = new BaseDatos(sql);
		bd.setString(1, pregunta);
		bd.setString(2, correcta);
		bd.setInt(3, id);
		bd.executeUpdate();
	}	
 	
 	public static String respuestaAModificar (int id){
		
		String sql = "SELECT * FROM opciones where id = ?";
		bd = new BaseDatos(sql);
		bd.setInt(1, id);
		ResultSet rs = bd.executeQuery();
		return parseoRespuestaAModificar(rs);
	}
	
	private static String parseoRespuestaAModificar(ResultSet rs){
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<form action=modificarRespuestasDos.do method=post>");
			sb.append("<table><tr><td>Id</td><td>Respuestas</td><td>Respuesta correcta</td></tr><tr><td>");
			while (rs.next()) {
				
				sb.append("<input readonly type=text name=id value='" + rs.getInt("id") + "' autocomplete=off>");
				sb.append("</td><td>");
				sb.append("<input type=text name=pregunta value='" + rs.getString("opcion") + "'autocomplete=off>");
				sb.append("</td><td>");
				sb.append("<input type=text name=correcta value='" + rs.getString("correcto") + "'autocomplete=off>");
				sb.append("</td></tr><tr><td>");
				sb.append("<input type=submit name=enviar value=Enviar>");
				
			}
			sb.append("</td></tr></table>");
			sb.append("</form>");
		} catch (Exception e) {

			System.out.println("Error en parseoRespuestaAModificar");
		}
		return sb.toString();
	}
}