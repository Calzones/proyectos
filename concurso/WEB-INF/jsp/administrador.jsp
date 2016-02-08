<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body > 
		<div id=modificar>
			<table>
				<form action=administrador.do method=post>
				
					<tr>
						<td>Usuario</td><td><input type=text name=usuario autofocus autocomplete=off></td>
					</tr>
					<tr>
						<td>Contraseña</td><td><input type=password name=contrasena></td>
					</tr>
					<tr>
						<td><a href=inicio.do>Atras</a></td><td><input type=submit value=Entrar></td>
				</form>
					</tr>
			</table><br>
			<%=request.getAttribute("errorAdministrador") %>
		</div>
	</body>
</html>