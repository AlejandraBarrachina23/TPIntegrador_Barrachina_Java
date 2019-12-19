<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="Dominio.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Universitario</title>
<link href="estilos.css" type="text/css" rel=stylesheet>
<link href="https://fonts.googleapis.com/css?family=Oswald&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Staatliches&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap" rel="stylesheet">
</head>
<body>
<% 
	if((Usuario) request.getSession(true).getAttribute("usuario")!=null){
		
		Usuario unUsuario = new Usuario();
		unUsuario = (Usuario) request.getSession(true).getAttribute("usuario");
		if(!unUsuario.getTipoUsuario().equals("administrador")){response.sendRedirect("error404.jsp");}
	
	}

	else {
		response.sendRedirect("error404.jsp");
	}%>
<section id="section-index">
	<div id="index-descripcion">
		<div id="index-descripcion-encabezado">
			<img src="img/fondo-index.svg">
			<h2>HERRAMIENTAS DE ADMINISTRACI�N</h2>
			<p>Campus Virtual proporciona las herramientas necesarias para administrar y redise�ar el flujo de trabajo, haciendo m�s eficiente la gesti�n y adapt�ndolo a tus necesidades.</p>
		</div>
		<div id="index-descripcion-contenido">
			<div class="index-item-descripcion"><a href="cursos.jsp"><img src="img/cursos-big.png" alt="cursos"></a>
				<h3>Cursos</h3>
				<p> Agrega cursos a cada una de las carreras dictada en la universidad </p>	 
			</div>
			<div class="index-item-descripcion"><a href="alumnos.jsp"><img src="img/estudiantes-big.png" alt="cursos"></a>
				<h3>Estudiantes</h3>
				<p> Agrega, modifica, elimina y lista a cada unos de los estudiantes de la
				universidad. </p>		
			</div>
			<div class="index-item-descripcion"><a href="profesores.jsp"><img src="img/profesores-big.png" alt="cursos"></a>
				<h3>Profesores</h3>
				<p> Agrega, modifica, elimina y lista a cada unos de los profesores de la
				universidad. </p>	
			</div>
			<div class="index-item-descripcion"><a href="reportes.jsp"><img src="img/reportes-big.png" alt="cursos"></a>
				<h3>Reportes</h3>
				<p> Acced� a los informes m�s reciente de actividad de la universidad. </p> 	
			</div>
		</div>
	</div>
</section>
</body>
</html>