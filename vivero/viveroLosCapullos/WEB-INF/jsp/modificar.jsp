<html>
	<head>
		<title>Vivero los Capullos</title>
		<link rel="shortcut icon" href="<%=model.Cosas.obtenerFoto("icono")%>" >
		<link rel ="stylesheet" type="text/css" href="web/css/css.css"/>
		<link rel="stylesheet" href="web/css/menu.css">
		<link rel="stylesheet" href="web/css/paco.css">
	</head>
	<body id="otro">
	<div id='cssmenu'>
			<ul>
			   <li><a href='principal.do' ><span>Principal</span></a></li>
			   <li><a href='cesta.do' "><span>Cesta</span></a></li>
			   <li class='active'><a href='perfil.do' ><span>Perfil</span></a></li>
			   <li class='last'><a href='contacto.do'><span>Contacto</span></a></li>
			   <li><a href='cerrarSesion.do'>Cerrar sesion</a></li>	
				<img id="logo" src="<%=model.Cosas.obtenerFoto("logo")%>" align='right'>
				<form align="right" action="buscar.do" method="get">
					<br/>
					<input type="text" name="buscar"  />
					<button name="buscar" type="submit">
					<img id="icono" src="<%=model.Cosas.obtenerFoto("buscar")%>"/></button>				
				</form>
			</ul>	
		</div>
		<br/><br/>
		<h1>Modificar datos</h1>	
		<form action="modificar.do" method="get"> 
			<table id="principal">
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
						<input type="text" maxlenght="5" name="cpostal">
						<br/><br/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Modificar" name="modificar"></td>
				</tr>
				<tr>
					<td><a id="link" href="perfil.do">Volver</a></td>
				</tr>
			</table>
		</form>		
		<%=request.getAttribute("errorModificarRegistro") %>
		
	</body>
</html>