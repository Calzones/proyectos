<html>
	<head>
		<title>Vivero los Capullos</title>
		<link rel="stylesheet" href="web/css/paco.css">
		<link rel="shortcut icon" href="<%=model.Cosas.obtenerFoto("icono")%>" >
	</head>
	<body id="otro">
		<h1>Nuevo Usuario</h1>	
		<form action="registro.do" method="get"> 
			<table id="principal">
				<tr>
					<td>Usuario
						*<input type="text" name="usuario">
						<br/>
					</td>
				</tr>
				<tr>
					<td>Contraseña
					*<input type="password" name="contrasena"><br/><br/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" name="contrasena1">
						<br/><br/>
					</td>
				</tr>
				<tr>
					<td>Localidad
						<input type="text" name="localidad">
						<br/><br/>
					</td>
				</tr>
				<tr>
					<td>Direccion
						<input type="text" name="direccion">
						<br/><br/>
					</td>
				</tr>
				<tr>
					<td>Código Postal
						<input type="text" name="cpostal">
						<br/><br/>
					</td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Registrarme"></td>
				</tr>
				
			</table>
		</form>		
		<%=request.getAttribute("errorRegistro") %>
		
	</body>
</html>