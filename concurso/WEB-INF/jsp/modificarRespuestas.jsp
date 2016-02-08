<html>
	<HEAD>
		<title>Concurso</title>
		<link rel=stylesheet href=web/css/stilos.css>
	</HEAD>
	
	<body > 
		<%=request.getAttribute("info") %>
		<div>
			<table>
				<tr>
					<td>Id</td><td>Respuestas</td><td>Respuesta correcta</td>
				</tr>
				<%=request.getAttribute("busqueda") %>
			</table>
			<a href=panelControl.do>Atras</a>
		</div>
	</body>
	
</html>