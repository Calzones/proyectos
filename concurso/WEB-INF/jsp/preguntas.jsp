<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body > 
		<div id=preguntas>
		<form action=preguntas.do method=post>
		
			<h1><%=controller.PreguntasRespuestas.getPreguntas()%></h1>
			<br/>
			<table>
				<%=controller.PreguntasRespuestas.getRespuestas()%>
			</table>
			<%=request.getAttribute("respuesta") %>
		</form>
		</div>
	</body>
</html>