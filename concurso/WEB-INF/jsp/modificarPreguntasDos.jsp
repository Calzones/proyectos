<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body >
		<div>
			<%=controller.Administrador.preguntaAModificar(Integer.parseInt(request.getAttribute("id").toString()))%>
			<a href=modificarPreguntas.do>Atras</a>
		</div>
	</body>
	
</html>