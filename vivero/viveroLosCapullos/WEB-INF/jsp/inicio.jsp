<html>
	<HEAD>
		<title>Vivero los Capullos</title>
		<link rel="stylesheet" href="web/css/paco.css">
		<link rel="shortcut icon" href="<%=model.Cosas.obtenerFoto("icono")%>" >
	</HEAD>
	
	<body id="ody"> 
		<br/>
		<table id="index">
		

		<form action="inicio.do" method="get">
			<tr>
				<td>Usuario &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="usuario"></td>
				<td rowspan="2"><input type="submit" value="Entrar"></td>
			</tr>
			<tr>
				<td>Contraseña<input type="password" name="contrasena"></td>
			</tr>
			<tr>
				<td><a href="registro.do">Registrate aquí</a></td>
			</tr>
			</form>
		</table>
		
		<div id="inicio">
			<%=request.getAttribute("errorInicio") %>
		</div>
		
		<br/><br/><br/><br/>
		<div id="inicio">
			<img id="imgasdasd" src="<%=model.Cosas.obtenerFoto("logo")%>" />
		</div>
		
	</body>
</html>