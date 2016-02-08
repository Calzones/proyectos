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
			   <li ><a href='principal.do' ><span>Principal</span></a></li>
			   <li><a href='cesta.do' "><span>Cesta</span></a></li>
			   <li><a href='perfil.do' ><span>Perfil</span></a></li>
			   <li class='active''><a href='contacto.do'><span>Contacto</span></a></li>
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
		<h1>Contacta con nosotros</h1>
		<form action="contacto.do" method="get">
			<table id="principal">
				<tr>
					<td>Staff del Vivero Los Capullos, estará dispuesto a resolver cualquier duda<br/><br/></td>
				</tr>
				<tr>
					<td>Localidad: c/El Sauce Boxeador nº69 Polígono el Bosque Frondoso<br/><br/></td>
				</tr>
				<tr>
					<td>Nº de contacto: 654798732 // 928654123<br/><br/></td>
				</tr>
				<tr>
					<td>E-mail: viveroloscapullos@eucamail.seto<br/><br/></td>
				</tr>
				<tr>
					<td><textarea name="comentarios" rows="10" cols="40">Escribe aquí tus comentarios o dudas</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="enviar"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>