<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body >
		<%=request.getAttribute("mensajeInsertar") %>
		<div>
			<form action=crearRespuesta.do method=post>
				<table>
					<tr>
						<td>Id</td>
						<td>Id Pregunta</td>
						<td>Respuesta</td>
						<td>Correcta</td>
					</tr>
					<tr>
						<td>
							<input type=text name=id autofocus autocomplete=off>
						</td>
						<td>
							<input type=text name='idPregunta' autocomplete=off>
						</td>
						<td>
							<input type=text name=respuesta autocomplete=off>
						</td>
						<td>
							<input type=text name=correcta autocomplete=off>
						</td>
					</tr>
					<tr>
						<td>
							<input type=submit name=enviar value=Enviar>
						</td>
					</tr>
				</table>
			<form>
			<a href=modificarRespuestas.do>Atras</a>
		</div>
	</body>
	
</html>