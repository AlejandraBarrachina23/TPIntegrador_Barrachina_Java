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
			<img src="img/fondo.png" alt="fondo-universidad">
		</div>	
		<div id="form-login-right">
			
			<div id="login-informacion">
				<h1>Bienvenidos</h1>		
				<p>Inicia sesi�n para acceder a todas las<br> herramientas de gesti�n.</p><br>
				<div class="text-box"><i class="fas fa-user"></i><input type="text" name="tboxUsuario" placeholder="Usuario"></div><br>
				<div class="text-box"><i class="fas fa-lock"></i><input type="password" name="tboxContrasenia" placeholder="Constrase�a"></div><br>
				<input class="main-button" type="submit" name="btnLogin" value="INICIAR SESI�N"><br><br>
				<a href="recuperacion.jsp">�Olvidaste la contrase�a?</a><br>
			</div>
			<div id="login-contacto">
				<p>Contactos</p>
				<a href="https://es-la.facebook.com/UTNRegionalPacheco/" target=_blank><img src="img/facebook.svg" class="iconos-redes" alt="logo-facebook"></a>
				<a href="https://twitter.com/utnfrgpprensa?lang=es" target=_blank><img src="img/twitter.svg" class="iconos-redes" alt="logo-facebook"></a>
				<a href="https://ar.linkedin.com/company/utn-frgp" target=_blank><img src="img/linkedin.svg" class="iconos-redes" alt="logo-facebook"></a>
			</div>
		</div>
		
			
	</form>

</body>
</html>