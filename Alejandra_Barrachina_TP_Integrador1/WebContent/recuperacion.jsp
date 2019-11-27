<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Universitario</title>
<link href="https://fonts.googleapis.com/css?family=Oswald:300,400&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Staatliches&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Fjalla+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,500&display=swap" rel="stylesheet">

<script src="https://kit.fontawesome.com/735f5623c2.js" crossorigin="anonymous"></script>
<link href="estilos.css" type="text/css" rel=stylesheet>
</head>
<body>

	<form id="form-login" method="post" action="index.jsp">
	<div id="form-login-left">				
			<img src="img/fondo-seguridad.png" alt="fondo-universidad">
		</div>	
		<div id="form-login-right">
			
			<div id="login-recuperacion">
				<h1>Recuperación</h1>		
				<p>Recuperaremos tu contraseña, ingresa <br>tu dirección corre electrónico.</p><br>
				<div class="text-box"><i class="fas fa-at"></i><input type="text" name="tboxUsuario" placeholder="correoelectronico@gmail.com"></div><br>
				<input class="restart-button" type="submit" name="btnLogin" value="ENVIAR"><br><br>
		
			</div>
		</div>
		
			
	</form>

</body>
</html>