<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Alumno"%>
    <%@page import="java.util.ArrayList"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Universitarios</title>
<link href="estilos.css" type="text/css" rel=stylesheet>
<link href="https://fonts.googleapis.com/css?family=Oswald&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Francois+One&display=swap" rel="stylesheet">
<link href="jquery.dataTables.min.css" type="text/css" rel=sytlesheet>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js"></script>
<script src="jquery-3.4.1.min.js"></script>
<script src="jquery.dataTables.min.js"></script>

</head>
<body>

<jsp:include page="menu-administrador.html"></jsp:include>

<section class="section-principal">
	<div class="encabezados">
		<h3>REPORTES AVANZADOS</h3>
	</div>
	<div id="form-reportes-avanzados">
			<div class="busqueda-califaciones">
				<h2>SELECCIONE CURSO</h2>
				<input type="text" placeholder="Materia">
				<input type="text" placeholder="Semestre">
				<input type="number" placeholder="A�o">
				<input type="button" value="Buscar">
			</div>
			<div class="resultado-busqueda">
			<h2 class="titulos">ESTADO DE CALIFICACIONES DE LOS ALUMNOS</h2>
				<div class="tabla-resultado-busqueda">				
					<table class="content-table" id="table_id">
						<thead>
							<tr>
								<th>Legajo</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Parcial 1</th>
								<th>Parcial 2</th>
								<th>Nota Final</th>
								<th>Estado</th>
							</tr>
						</thead>
						<tbody>
							<% for(Alumno unAlumno : Alumno.CargarAlumnos()){%>
							<tr>  
								  <td><%= unAlumno.getLegajo() %></td>
								  <td><%= unAlumno.getNombre() %></td>
								  <td><%= unAlumno.getApellido() %></td>
								  <td>9</td>
								  <td>7</td>
								  <td>8</td>
								  <td>Promoci�n</td>
							</tr>
						    <%}%>
						</tbody>
					</table>
				</div>	
				<div class="graficos-resultado-busqueda">
					<div class="form-reportes-graficos">
						<h3>RESULTADO GENERAL</h3>
						<canvas id="estado-alumnos"></canvas>
					</div>
					<div class="form-reportes-graficos">
						<h3>RESULTADO PRIMER PARCIAL</h3>
						<canvas id="notas-primer-parcial"></canvas>	
					</div>
					<div class="form-reportes-graficos">
						<h3>RESULTADO SEGUNDO PARCIAL</h3>
						<canvas id="notas-segundo-parcial"></canvas>
					</div>
				</div>	
			</div>
			<div class="resultado-busqueda-asistencias">
			<h2 class="titulos">ESTADO DE ASISTENCIA DE LOS ALUMNOS</h2>
				<div class="graficos-resultado-busqueda">
					<div class="form-reportes-graficos-asistencias">
						<h3>TOTAL ESTADO ASISTENCIAS</h3>
						<canvas id="estado-asistencias"></canvas>
					</div>				
				</div>	
					<div class="tabla-resultado-busqueda">				
					<table class="content-table">
						<thead>
							<tr>
								<th>Legajo</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Cantidad de Faltas</th>
								<th>Estado</th>
							</tr>
						</thead>
						<tbody>
							<% for(Alumno unAlumno : Alumno.CargarAlumnos()){%>
							<tr>  
								  <td><%= unAlumno.getLegajo() %></td>
								  <td><%= unAlumno.getNombre() %></td>
								  <td><%= unAlumno.getApellido() %></td>
								  <td>5</td>
								  <td>Regular</td>
							</tr>
						    <%}%>
						</tbody>
					</table>
				</div>
			</div>		
	</div>		
</section>
<script>
var ctx = document.getElementById('estado-alumnos').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Aprobados','Desaprobados', 'Promocionados'],
        datasets: [
        	
        	{
	        	label:"Alumnos",
	            data: [5, 2, 1],
	            fill: false,            
	            borderWidth: 1, 
	            backgroundColor: [
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)'
	            ],
	            borderColor: [
	            	
	            	'rgba(255, 206, 86, 1)',
	            	'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'

	            ]
        	}

        ]
    }
});

var ctx = document.getElementById('notas-segundo-parcial').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Aprobados','Desaprobados', 'Ausentes'],
        datasets: [
        	
        	{
	        	label:"Alumnos",
	            data: [10, 3, 1],
	            fill: false,            
	            borderWidth: 1, 
	            backgroundColor: [
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)'
	            ],
	            borderColor: [
	            	
	            	'rgba(255, 206, 86, 1)',
	            	'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'

	            ]
        	}

        ]
    }
});

var ctx = document.getElementById('notas-primer-parcial').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Aprobados','Desaprobados', 'Ausentes'],
        datasets: [
        	
        	{
	        	label:"Alumnos",
	            data: [1, 10, 1],
	            fill: false,            
	            borderWidth: 1, 
	            backgroundColor: [
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)'
	            ],
	            borderColor: [
	            	
	            	'rgba(255, 206, 86, 1)',
	            	'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)'

	            ]
        	}

        ]
    }
});

var ctx = document.getElementById('estado-asistencias').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Regulares','Libres'],
        datasets: [
        	
        	{
	        	label:"Alumnos",
	            data: [5, 2],
	            fill: false,            
	            borderWidth: 1, 
	            backgroundColor: [
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(255, 99, 132, 0.2)'
	            ],
	            borderColor: [
	            	
	            	'rgba(255, 206, 86, 1)',
	            	'rgba(255, 99, 132, 1)'

	            ]
        	}

        ]
    }
});

</script>
</body>
</html>