package controller;

import java.sql.ResultSet;

import model.BaseDatos;

public class Usuario {
	
	private static BaseDatos bd;
	
	public static void setUsuario(String usuario, int tiempo, String fecha) {
		
		String sql = "INSERT INTO ranking (usuario, tiempo, fecha) VALUES(?, ?, ?)";
		bd = new BaseDatos(sql);
		bd.setString(1, usuario);
		bd.setString(2, tiempo + " s");
		bd.setString(3, fecha);
		bd.executeUpdate();
	}
	
	public static String getUsuarios(){
		
		String sql = "SELECT usuario, tiempo, fecha FROM ranking ORDER BY tiempo ASC";
		bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseUsuario(rs);
	}
	
	private static String parseUsuario(ResultSet rs){
		
		StringBuffer sb = new StringBuffer();
	
		try {
			
			while (rs.next()) {
				
				sb.append("<tr>");
				sb.append("<td>" + rs.getString("usuario") + "</td>");
				sb.append("<td>" + rs.getString("tiempo") + "</td>");
				sb.append("<td>" + rs.getString("fecha") + "</td>");
				sb.append("</tr>");
			}
		} catch (Exception e) {

			System.out.println("Error en parseUsuario");
		}
		return sb.toString();
	}
}