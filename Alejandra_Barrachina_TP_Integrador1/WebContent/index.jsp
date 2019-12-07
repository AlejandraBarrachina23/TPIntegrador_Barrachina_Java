<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<section id="section-index">
	<div id="index-descripcion">
		<div id="index-descripcion-encabezado">
			<img src="img/fondo-index.svg">
			<h2>HERRAMIENTAS DE ADMINISTRACIÓN</h2>
			<p>Campus Virtual proporciona las herramientas necesarias para administrar y rediseñar el flujo de trabajo, haciendo más eficiente la gestión y adaptándolo a tus necesidades.</p>
		</div>
		
		<div id="index-descripcion-contenido">
			<div class="index-item-descripcion"><img src="img/cursos-big.png" alt="cursos">
				<h3>Cursos</h3>
				<p> Agrega cursos a cada una de las carreras dictada en la universidad </p>
				<a href="cursos.jsp" class="btn-index">IR A CURSOS</a>		 
			</div>
			<div class="index-item-descripcion"><img src="img/estudiantes-big.png" alt="cursos">
				<h3>Estudiantes</h3>
				<p> Agregar, modifica, elimina y lista a cada unos de los estudiantes de la
				universidad. </p>
				<a href="alumnos.jsp" class="btn-index">IR A ESTUDIANTES</a>	 		
			</div>
			<div class="index-item-descripcion"><img src="img/profesores-big.png" alt="cursos">
				<h3>Profesores</h3>
				<p> Agregar, modifica, elimina y lista a cada unos de los profesores de la
				universidad. </p>
				<a href="profesores.jsp" class="btn-index">IR A PROFESORES</a>	 		
			</div>
			<div class="index-item-descripcion"><img src="img/reportes-big.png" alt="cursos">
				<h3>Reportes</h3>
				<p> Accede a los informes más reciente de actividad de la universidad. </p> 	
				<a href="reportes.jsp" class="btn-index">IR A REPORTES</a>	
			</div>
		</div>
	</div>
</section>
</body>
</html>