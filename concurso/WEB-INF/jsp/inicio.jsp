<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	<body > 
		<div id=modificar>
		<table>
			<form action=inicio.do method=post>
			<tr>
			<td>Usuario</td>
			</tr>
				<tr>
					<td><input type=text name=usuario autofocus autocomplete=off>
					</td><td><input type=submit value=Entrar></td>
				</tr>
			</form>
				<tr>
					<td><a href=ranking.do>Ranking</a></td><td><a href=administrador.do>Modo admnistrador</a></td>
				</tr>
				<tr>
					<td><%=request.getAttribute("errorInicio") %></td>
				</tr>
		</table>
		</div>	
	</body>
</html>