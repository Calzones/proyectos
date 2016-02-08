<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body >
		<div>
			<%=controller.Administrador.respuestaAModificar(Integer.parseInt(request.getAttribute("id2").toString()))%>
			<a href=modificarRespuestas.do>Atras</a>
		</div>
	</body>
	
</html>