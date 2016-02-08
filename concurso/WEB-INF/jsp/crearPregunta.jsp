<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body >
		<%=request.getAttribute("mensajeInsertar") %>
		<div>
			<form action=crearPregunta.do method=post>
				<table>
					<tr>
						<td>Id</td>
						<td>Pregunta</td>
					</tr>
					<tr>
						<td>
							<input type=text name=id autofocus autocomplete=off>
						</td>
						<td>
							<input type=text name=pregunta autocomplete=off>
						</td>
					</tr>
					<tr>
						<td>
							<input type=submit name=enviar value=Enviar>
						</td>
					</tr>
				</table>
			</form>
			<a href=modificarPreguntas.do>Atras</a>
		</div>
	</body>
	
</html>