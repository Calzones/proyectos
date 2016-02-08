	<head>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
	</head>
	<body>
	
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
	
		//Obtener los datos de la base de datos y parsearlos
		PalabrasModel pm = new PalabrasModel(app);
		pm.buscarPalabras(texto);
		String salida = pm.parsePalabras();
		pm.close();
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(salida);