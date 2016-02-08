<html>
	<head>
		<title>Vivero los Capullos</title>
		<link rel="shortcut icon" href="<%=model.Cosas.obtenerFoto("icono")%>" >
		<link rel ="stylesheet" type="text/css" href="web/css/css.css"/>
		<link rel="stylesheet" href="web/css/menu.css">
		<link rel="stylesheet" href="web/css/paco.css">
		<script src="http://code.jquery.com/jquery-latest.js"></script>
	</head>
	<body id="otro">
		<div id='cssmenu'>
			<ul>
			   <li class='active'><a href='principal.do' ><span>Principal</span></a></li>
			   <li><a  href='cesta.do' "><span>Cesta</span></a></li>
			   <li><a href='perfil.do' ><span>Perfil</span></a></li>
			   <li class='last'><a href='contacto.do'><span>Contacto</span></a></li>
			   <li><a href='cerrarSesion.do'>Cerrar sesion</a></li>	
				<img id="logo" src="<%=model.Cosas.obtenerFoto("logo")%>" align='right'>
		<script>
			var c = 0;
			$(document).ready(function() {
				$('#bus').on('keyup', function() {
					$.ajax({
						url: "buscar.do",
						data: $('#bus').serialize(),
						success: function(data) {
									$('#respuesta').html(data);						
						}					
					});
					c = c + 1;
					$('#test').html(c);
				});
			});
		</script>
				<form align="right" action="buscar.do" method="get">
					<br/>
					<input type="text" name="buscar"  />
					<button name="buscar" type="submit">
					<img id="icono" src="<%=model.Cosas.obtenerFoto("buscar")%>"/></button>				
				</form>
			</ul>	
		</div>
		<br/><br/>
		<table id="principal">
			<tr>
				<td>
					
					<a href="flores.do"><img id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("florespng")%>"/></a>
				</td>
				<td>
					<a href="arboles.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("arbolespng")%>"/></a>
				</td>
				<td>
					<a href="arbustos.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("arbustospng")%>"/></a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="mobiliario.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("mobiliariopng")%>"/></a>
				</td>
				<td>
					<a href="utiles.do"><img id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("utilespng")%>" /></a>
				</td>
				<td>
					<a href="semillas.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("semillaspng")%>"/></a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="servicios.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("jardinero")%>"/></a>
				</td>
				<td>
					<a href="perfil.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("perfil")%>"/></a>
				</td>
				<td>
					<a href="cesta.do"><img  id="fotosPrincipal" src="<%=model.Cosas.obtenerFoto("cesta")%>"/></a>
				</td>
			</tr>
		</table>
	</body>
	<footer><marquee loop="true" scrollamount="7"><br/>Vivero Los Capullos SL &copy;&nbsp;&nbsp;desarrolladores:&nbsp;&nbsp;Fabricio Rojas, Victor Rivero y con la colaboracion de Miguel de Cervantes </marquee></footer>
</html>