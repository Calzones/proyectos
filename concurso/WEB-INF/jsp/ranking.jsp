<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body > 
		<div id=ranking>
			<h1>Ranking</h1>
			<br/>
			<form action=ranking.do method=post>
				<table>
					<tr>
						<td>Usuario</td>
						<td>Tiempo</td>
						<td>Fecha</td>
					</tr>
					<tr>
						<%=controller.Usuario.getUsuarios()%>
					</tr>
				</table>
				<a href=inicio.do>Atras</a>
			</form>
		</div>
	</body>
</html>