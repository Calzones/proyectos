package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {

	private String sql;
	private PreparedStatement pstmt;
	
	public BaseDatos(String sql) {
		this.sql = sql;
		conectar();
	}
	
	public void setString(int pos, String s) {
		try {
			pstmt.setString(pos, s);
		} catch (SQLException e) {
			System.out.println("Error en BaseDatos.setString");
			e.printStackTrace();
		} 
	}
	
	public void setInt(int pos, int i) {
		try {
			pstmt.setInt(pos, i);
		} catch (SQLException e) {
			System.out.println("Error en BaseDatos.setInt");
			e.printStackTrace();
		} 
	}
	
	private void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String cadena = "jdbc:mysql://localhost/vivero";
			Connection con = DriverManager.getConnection
										(cadena, "root", "");
			pstmt = con.prepareStatement(sql); 
		} catch (Exception e) {
			System.out.println("Error de conección con la Base de datos.");
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery() {
			try {
				System.out.println(pstmt);
				return pstmt.executeQuery();
			} catch (Exception e) {
				System.out.println("Error en la SQL de executeQuery");
				e.printStackTrace();
				return null;
			}
	}
	
	public int executeUpdate() {
			try {
				System.out.println(pstmt.toString());
				return pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error en la SQL de executeUpdate");
				e.printStackTrace();
				return -1;
			}
	}
	
	
	
}












