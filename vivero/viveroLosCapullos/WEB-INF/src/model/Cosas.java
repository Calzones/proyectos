package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cosas {
	
	
	public static void comprar(String nombre, String cantidad, String tabla){
		try {
			String sql = "UPDATE " + tabla + " SET cantidad = ? WHERE(nombre = ?)";
			BaseDatos bd = new BaseDatos(sql);
			bd.setString(1, cantidad);
			bd.setString(2, nombre);
			bd.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en el modificar");
			e.printStackTrace();
		}
	}
	
	public static void algoPorAhora(ResultSet rs, String usuario){
		StringBuffer sb = new StringBuffer();
		int precioTotal = 0;
		int cantidadFinal = 0;
		String tabla;
		String nombre;
		try {
			while (rs.next()) {
				
				int precio = Integer.parseInt(rs.getString("precio"));
				int cantidad = Integer.parseInt(rs.getString("cantidad"));
				int cantidadPedido = Integer.parseInt(rs.getString("cantidadPedido"));
				tabla = rs.getString("tipo");
				nombre = rs.getString("nombre");
				
				if (cantidad >= cantidadPedido)
					precio = precio * cantidadPedido;
				else
					precio = precio * cantidad;					
				
				cantidadFinal = cantidad - cantidadPedido;
				if (cantidadFinal < 0 )
					cantidadFinal = 0;
				precioTotal = precioTotal + precio;
				String cantidadFinalS = Integer.toString(cantidadFinal);
				comprar(nombre, cantidadFinalS, tabla);
			}
					sb.append("<table id='principal'>");
					sb.append("<tr>");
					sb.append("<td>Direccion de envio:<br/></td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td><form action='principal.do'><input type='text' value='" + getLocalidad(usuario) + "'<br/> </td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td> Total: " + precioTotal + "<br/></td>");
					sb.append("</tr>");
					sb.append("<input type='submit'>");
					sb.append("</form>");
					sb.append("</table>");
		} catch (SQLException e) {
			System.out.println("error en algoPorAhora");
			e.printStackTrace();
		}
	}
	
	public static String getBuscar(String nombre, String tabla){
		System.out.println(tabla);
		String sql = "SELECT * FROM " + tabla + " WHERE(nombre LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, "%" + nombre + "%");
		ResultSet rs = bd.executeQuery();
		return parseBuscar(rs);
	
	}
	public static String parseBuscar(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		try {
			while (rs.next()) {
				
				sb.append("<tr>");
				sb.append("<form action='cesta.do' method='get'>");
				sb.append("<td><img id='producto' src='" + rs.getString("fotos") + "'/></td>");
				sb.append("<td>" + rs.getString("nombre") + "</td>");
				sb.append("<td>" + rs.getString("cantidad") + "</td>");
				sb.append("<td>" + rs.getString("precio") + "</td>");
				sb.append("<td>" + "<input maxlength='2' name='cantidadPedido' value='1' size='1px' type='text' >" + "</td>");
				sb.append("<td>" + "<input type='hidden' name='cantidad' value='" + rs.getString("cantidad") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='nombre' value='" + rs.getString("nombre") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='precio' value='" + rs.getString("precio") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='fotos' value='" + rs.getString("fotos") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='paginaOrigen' value='" +  rs.getString("tipo") + "'>" + "</td>");
				sb.append("<td>" + "<button name='añadir' type='submit'><img width='15' height='15' src='"+ obtenerFoto("agregar") + "'/></button></td>");
				sb.append("</form>");
				sb.append("</tr>");
				
			}
		} catch (Exception e) {
			System.out.println("Error en parseBuscar");
		}
		return sb.toString();
	}
	
	public void modificar(String campo, String valor, String usuario){
		String id = obtenerId(usuario);
		try {
			String sql = "UPDATE clientes SET "+ campo +" = ? WHERE( id = ?)";
			BaseDatos bd = new BaseDatos(sql);
			bd.setString(1, valor);
			bd.setString(2, id);
			bd.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en el modificar");
			e.printStackTrace();
		}
	}
	public static String obtenerId(String usuario){
		String sql = "SELECT id FROM clientes WHERE(usuario LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, usuario);
		ResultSet rs = bd.executeQuery();
		return parseId(rs);	
	}
	
	public static String parseId(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		try {
			while (rs.next()){
				sb.append(rs.getInt("id"));
			}
		} catch (Exception e) {
			System.out.println("Error en parseId");
		}
		return sb.toString();
	}
	
	public void registrase(String usuario, String contraseña, String contraseña1, String localidad, String direccion, String cpostal) {
		try {
			if (contraseña.equals(contraseña1)) {
				String sql = "INSERT INTO clientes (usuario, contrasena, localidad, direccion, cpostal) VALUES( ?, ?, ?, ?, ?)";
				BaseDatos bd = new BaseDatos(sql);
				bd.setString(1, usuario);
				bd.setString(2, contraseña);
				bd.setString(3, localidad);
				bd.setString(4, direccion);
				bd.setString(5, cpostal);
				bd.executeUpdate();
			}		
		} catch (Exception e) {
			System.out.println("Error en el registrase");
			e.printStackTrace();
		}
	}

	public boolean iniciarSesion(String usuario, String contraseña) {
		String sql = "SELECT * FROM clientes WHERE ((usuario LIKE ?) AND (contrasena LIKE ?))";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, usuario);
		bd.setString(2, contraseña);
		ResultSet rs = bd.executeQuery();
		try {
			if (rs.first())
				return true;
		} catch (SQLException e) {
			System.out.println("Error en el iniciarSesion");
			e.printStackTrace();
		}
		return false;	
	}
	
	public static String getNombreFlores() {
		String sql = "SELECT * FROM flores";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseProductos(rs);
	}
	public static String getNombreArboles() {
		String sql = "SELECT * FROM arboles";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseProductos(rs);
	}
	public static String getNombreArbustos() {
		String sql = "SELECT * FROM arbustos";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseProductos(rs);
	}
	public static String getNombreUtiles() {
		String sql = "SELECT * FROM utiles";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseProductos(rs);
	}
	public static String getNombreMobiliario() {
		String sql = "SELECT * FROM mobiliario";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseProductos(rs);
	}
	public static String getNombreSemillas() {
		String sql = "SELECT * FROM semillas";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseProductos(rs);
	}
	public static String getNombreServicios() {
		String sql = "SELECT * FROM servicios ";
		BaseDatos bd = new BaseDatos(sql);
		ResultSet rs = bd.executeQuery();
		return parseServicios(rs);
	}
	
	public static String getDatosPerfil(String nombre){
		String sql = "SELECT * FROM clientes WHERE(usuario LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, nombre);
		ResultSet rs = bd.executeQuery();
		return parsePerfil(rs);
	}
	public static String getLocalidad(String nombre){
		String sql = "SELECT localidad FROM clientes WHERE(usuario LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, nombre);
		ResultSet rs = bd.executeQuery();
		String sb = null;
		try {
			while (rs.next()){
				sb=(rs.getString("localidad"));	
			}
		} catch (Exception e) {
			System.out.println("Error en getLocalidad");
		}
		return sb;
	}
	
	public static void delPedido(String usuario, String nombre){
		String sql = "DELETE FROM pedidos WHERE ((usuario LIKE ?) AND (nombre LIKE ?))";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, usuario);
		bd.setString(2, nombre);
		bd.executeUpdate();
	}
	public static void setPedido(String nombre, String cantidadPedido, String usuario, String precio, String fotos, String cantidad, String tipo ){
		
		try {
			String sql = "INSERT INTO pedidos (nombre, cantidadPedido, usuario ,precio, fotos, cantidad, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
			BaseDatos bd = new BaseDatos(sql);
			bd.setString(1, nombre);
			bd.setString(2, cantidadPedido);	
			bd.setString(3, usuario);
			bd.setString(4, precio);
			bd.setString(5, fotos);
			bd.setString(6, cantidad);
			bd.setString(7, tipo);
			bd.executeUpdate();	
		} catch (Exception e) {
			System.out.println("Error en el setPedido");
			e.printStackTrace();
		}
	}
	
	public static ResultSet getPedido2(String nombre){
		String sql = "SELECT * FROM pedidos WHERE(usuario LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, nombre);
		ResultSet rs = bd.executeQuery();
		return rs;
	}
	
	public static String getPedido(String nombre){
		String sql = "SELECT * FROM pedidos WHERE(usuario LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, nombre);
		ResultSet rs = bd.executeQuery();
		try {
			if (rs.first())
				return parsePedido(rs);
			else{
				return "<tr><td>No has realizado ningun pedido</td></tr>" ;
				
			}
		} catch (SQLException e) {
			System.out.println("Error en el getPedido");
			e.printStackTrace();
		}
		return "";
	}
	public static String parsePedido(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr><td></td><td>Nombre</td><td>Cantidad</td><td>Importe</td></tr>");
		try {
			sb.append("<form action='borrar.do' method='get'>");
			sb.append("<tr>");
			sb.append("<td><img id='producto' src='" + rs.getString("fotos") + "'/></td>");
			sb.append("<td>" + rs.getString("nombre") + "</td>");
			sb.append("<td>" + rs.getString("cantidadPedido") + "</td>");
			sb.append("<td>" + rs.getString("precio") + "</td>");
			sb.append("<td>" + "<input type='hidden' name='borrar' value='si'></td>");
			sb.append("<td>" + "<input type='hidden' name='nombre' value='" + rs.getString("nombre") + "'></td>");
			sb.append("<td>" + "<input type='hidden' name='usuario' value='" + rs.getString("usuario") + "'></td>");
			sb.append("<td>" + "<button name='eliminar' type='submit'><img width='15' height='15' src='"+ obtenerFoto("eliminar") + "'/></button></td>");
			sb.append("</tr>");
			sb.append("</form>");
			while (rs.next()) {
				sb.append("<form action='borrar.do' method='get'>");
				sb.append("<tr>");
				sb.append("<td><img id='producto' src='" + rs.getString("fotos") + "'/></td>");
				sb.append("<td>" + rs.getString("nombre") + "</td>");
				sb.append("<td>" + rs.getString("cantidadPedido") + "</td>");
				sb.append("<td>" + rs.getString("precio") + "</td>");
				sb.append("<td>" + "<input type='hidden' name='borrar' value='si'></td>");
				sb.append("<td>" + "<input type='hidden' name='nombre' value='" + rs.getString("nombre") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='usuario' value='" + rs.getString("usuario") + "'></td>");
				sb.append("<td>" + "<button type='submit' name='eliminar' ><img width='15' height='15' src='"+ obtenerFoto("eliminar") + "'/></button></td>");
				sb.append("</tr>");
				sb.append("</form>");
			}
			sb.append("<form action='comprar.do' method='get'>");
			sb.append("<td>" + "<input type='submit' name='comprar' value='Comprar'></td>");
			sb.append("</form>");
			sb.append("</table>");
		} catch (Exception e) {
			System.out.println("Error en parsePedido");
		}
		return sb.toString();
	} 
	public static String obtenerFoto(String foto){
		String sql = "SELECT foto FROM fotos WHERE(nombre LIKE ?)";
		BaseDatos bd = new BaseDatos(sql);
		bd.setString(1, foto);
		ResultSet rs = bd.executeQuery();
		return parseFoto(rs);		
	}
	
	public static String parseFoto(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		try {
			while (rs.next()){
				sb.append(rs.getString("foto"));
			}
		} catch (Exception e) {
			System.out.println("Error en parseFoto");
		}
		return sb.toString();
	}
	
	public static String parseProductos(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr><td></td><td>Nombre</td><td>Disponible</td><td>Precio</td><td>Cantidad</td></tr>");
		try {
			
			while (rs.next()) {
				sb.append("<form action='cesta.do' method='get'>");
				sb.append("<tr>");
				sb.append("<td><img id='producto' src='" + rs.getString("fotos") + "'/></td>");
				sb.append("<td>" + rs.getString("nombre") + "</td>");
				sb.append("<td>" + rs.getString("cantidad") + "</td>");
				sb.append("<td>" + rs.getString("precio") + "</td>");
				sb.append("<td>" + "<input maxlength='2' name='cantidadPedido' value='1' size='1px' type='text' >" + "</td>");
				sb.append("<td>" + "<input type='hidden' name='cantidad' value='" + rs.getString("cantidad") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='nombre' value='" + rs.getString("nombre") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='precio' value='" + rs.getString("precio") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='fotos' value='" + rs.getString("fotos") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='paginaOrigen' value='" +  rs.getString("tipo") + "'>" + "</td>");
				sb.append("<td>" + "<button name='añadir' type='submit'><img width='15' height='15' src='"+ obtenerFoto("agregar") + "'/></button></td>");
				sb.append("</tr>");
				sb.append("</form>");
			}
			sb.append("</table>");
		} catch (Exception e) {
			System.out.println("Error en parseProductos");
		}
		return sb.toString();
	} 
	public static String parseServicios(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr><td></td><td>Nombre</td><td></td><td></td><td>Precio</td></tr>");
		try {
			while (rs.next()) {
				sb.append("<form action='cesta.do' method='get'>");
				sb.append("<tr>");
				sb.append("<td><img id='producto' src='" + rs.getString("fotos") + "'/></td>");
				sb.append("<td>" + rs.getString("nombre") + "</td>");
				sb.append("<td></td>");
				sb.append("<td></td>");
				sb.append("<td>" + rs.getString("precio") + "</td>");
				sb.append("<td>" + "<input type='hidden' name='nombre' value='" + rs.getString("nombre") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='precio' value='" + rs.getString("precio") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='fotos' value='" + rs.getString("fotos") + "'></td>");
				sb.append("<td>" + "<input type='hidden' name='cantidadPedido' value='1'></td>");
				sb.append("<td>" + "<input type='hidden' name='paginaOrigen' value='" +  rs.getString("tipo") + "'>" + "</td>");
				sb.append("<td>" + "<button name='añadir' type='submit'><img width='15' height='15' src='"+ obtenerFoto("agregar") + "'/></button></td>");
				sb.append("</tr>");
				sb.append("</form>");	
			}
			sb.append("</table>");
		} catch (Exception e) {
			System.out.println("Error en parseServicios");
		}
		return sb.toString();
	}
	
	public static String parsePerfil(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		try {
			while (rs.next()){
				sb.append("<tr><td>Usuario: </td><td>" + rs.getString("usuario") + "</td></tr>");
				sb.append("<tr><td>Contraseña: </td><td>" + rs.getString("contrasena") + "</td></tr>");
				sb.append("<tr><td>Localidad: </td><td>" + rs.getString("localidad") + "</td></tr>");
				sb.append("<tr><td>Direccion: </td><td>" + rs.getString("direccion") + "</td></tr>");
				sb.append("<tr><td>Código Postal: </td><td>" + rs.getString("cPostal") + "</td></tr>");
				
			}
		} catch (Exception e) {
			System.out.println("Error en parsePerfil");
		}
		return sb.toString();
	}
	

}
