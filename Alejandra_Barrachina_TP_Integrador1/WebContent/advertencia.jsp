
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Refresh" content="5;url=login.jsp">
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
					<div id="form-advertencia">
						<img src="img/cancel.svg" alt="icono-advertencia" class="icono-advertencia">
						<h2>ACCESO DENEGADO</h2>
						<p>Tu usuario ha sido bloqueado por reiterados intentos de acceso sin éxito. Contacte a un administrador para resolver el problema.</p>
					</div>
			</div>
		</div>
	</form>
</body>
</html>
