<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Alumno"%>
    <%@page import="Negocio.ReportesNegocio"%>
    <%@page import="Dominio.Curso"%>
    <%@page import="Dominio.Reporte"%>
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

<nav>
<div id="user">
		<a href="index.jsp"><img id="icon-usuario" src="iconos/usuario-admin.svg" alt="imagen-usuario"></a>
		<h2>�Bienvenido!</h2>
		<p>${usuario.usuario}</p>
		<a href="serveletUsuario">LogOut</a>
	</div>
<jsp:include page="menu-administrador.html"></jsp:include>
</nav>

<section class="section-principal">
	<div class="encabezados"><h3>REPORTES GENERALES</h3></div>
	
	<div id="form-reportes">
			
		<div class="form-reportes-estadisticas-alumnos">
			<div id="form-reportes-fila-uno">
				<div class="fila-uno-items">
					<h2>TOTAL ALUMNOS</h2>
					<p><% ReportesNegocio reporte = new ReportesNegocio();%>
					<%=reporte.CantidadAlumnosAnio() %></p>
					<img alt="total-alumnos" src="img/total.svg">					
					<div class="fila-uno-items-pie">
						<img src="iconos/baja.svg" alt="subida">
						<p></p>
					</div>
				</div>
				<div class="fila-uno-items">
					<h2>ALUMNOS REGULARES</h2>					
					<p><%=reporte.CantidadAlumnosRegulares() %></p>
					<img alt="alumno-regular" src="img/regular.svg">
					<div class="fila-uno-items-pie">
						<img src="iconos/alta.svg" alt="subida">
						<p>10.2%</p>
					</div>
				</div>
				<div class="fila-uno-items">
					<h2>ALUMNOS LIBRES</h2>
					<p><%= reporte.CantidadAlumnosLibres() %></p>
					<img alt="alumno-libre" src="img/libre.svg">
					<div class="fila-uno-items-pie">
						<img src="iconos/baja.svg" alt="subida">
						<p>25.5%</p>
					</div>
				</div>
				<div class="fila-uno-items">
					<h2>TOTAL PROFESORES</h2>
					<p><%= reporte.CantidadProfesoresActivos() %></p>
					<img alt="alumno-libre" src="img/maestros.svg">
					<div class="fila-uno-items-pie">
						<img src="iconos/alta.svg" alt="subida">
						<p>0.01%</p>
					</div>
				</div>		
			</div>	
			<div id="form-reportes-fila-dos">
			<h2>INSCRIPCIONES 2019</h2>
				<div class="form-reportes-graficos">
					<h3>COMPARATIVA ALUMNOS INSCRIPTOS</h3>
					<canvas id="cantidad-inscriptos"></canvas>
				</div>
				<div class="form-reportes-graficos">
					<h3>MATERIAS CON M�S INSCRIPTOS 2019</h3>
					<canvas id="materias-mas-inscriptos"></canvas>
				</div>
				<div class="form-reportes-graficos">
					<h3>COMPARATIVA ALUMNOS REGULARES LIBRES</h3>
					<canvas id="comparativa-alumnos"></canvas>
				</div>
			</div>
			<div id="form-reportes-fila-tres">
				<h2>CARRERAS-MATERIAS</h2>
				<div class="reporte-fila-tres-promedio">
					<h3>MEJORES PROMEDIOS DE LA CARRERA</h3>
				
					<table class="content-table">
						<thead>
							<tr>
								<th>Legajo</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Promedio</th>
							</tr>
						</thead>
						<tbody>
							<tr>  
								  <td></td>
								  <td></td>
								  <td></td>
								  <td>9.8</td>
							</tr>
						</tbody>
					</table>
			</div>
			<div class="reporte-fila-tres-promedio">
				<h3>PEORES PROMEDIOS DE LA CARRERA</h3>
				<table class="content-table">
					<thead>
						<tr>
							<th>Legajo</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Promedio</th>
						</tr>
					</thead>
					<tbody>
				
						<tr>  
							  <td></td>
							  <td></td>
							  <td></td>
							  <td>6.5</td>
						</tr>			
					</tbody>
				</table>
			</div>	
				<div class="reporte-fila-tres-promedio">
				<h3>MATERIAS CON M�S EGRESO</h3>
				<table class="content-table">
					<thead>
						<tr>
							<th>ID Curso</th>
							<th>Materia</th>
							<th>Semestre</th>
							<th>Profesor</th>
							<th>Egresos</th>
						</tr>
					</thead>
					<tbody>
				
						<tr>  
						<% for(Curso unCurso : reporte.MateriasConMasInscriptos()){%>
							 <td><%= unCurso.getMateria().getIdMateria() %></td>
							 <td><%= unCurso.getMateria().getNombre() %></td>
							 <td><%= unCurso.getSemestre() %></td>
							 <td><%= unCurso.getProfesorTitular().getNombre() + " " + unCurso.getProfesorTitular().getApellido() %></td>
							 <td><%= unCurso.getAnio() %></td>
						</tr>			
						<%}%>
					</tbody>
				</table>
			</div>
				<div class="reporte-fila-tres-promedio">
				<h3>MATERIAS CON M�S ABANDONOS</h3>
				<table class="content-table">
					<thead>
						<tr>
							<th>ID Curso</th>
							<th>Materia</th>
							<th>Semestre</th>
							<th>Profesor</th>
							<th>Abandonos</th>
						</tr>
					</thead>
					<tbody>
						<tr>  
							<% for(Curso unCurso : reporte.MateriasConMasAbandono()){%>
							<td><%= unCurso.getMateria().getIdMateria() %></td>
							<td><%= unCurso.getMateria().getNombre() %></td>
							<td><%= unCurso.getSemestre() %></td>
							<td><%= unCurso.getProfesorTitular().getNombre() + " " + unCurso.getProfesorTitular().getApellido() %></td>
							<td><%= unCurso.getAnio() %></td>
						</tr>			
						<%}%>			
					</tbody>
				</table>
			</div>		
		</div>
	</div>	
	<a href="reportes-avanzados.jsp"><input type="button" id="btnAgregarAlumno" class="btnFormulario" value="REPORTES AVANZADOS"></a>		
</section>


<script>

<% ArrayList<Reporte>ListadoAlumnosInscripto = reporte.ComparativaAlumnosInscriptos();%>
<% ArrayList<Reporte>ListadoMateriaMasInscriptos = reporte.MateriasMasInscripciones();%>
<% ArrayList<Reporte>ListadoRegulares = reporte.EstadosAlumnosxAnio();%>
<% ArrayList<Reporte>ListadoLibres = reporte.EstadosAlumnosxAnioLibres();%>
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	

	var ctx = document.getElementById('comparativa-alumnos').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: ['2015', '2016', '2017', '2018', '2019'],
	        datasets: [
	        	
	        	{
		        	label:"Libres",
		            data: [<%= ListadoLibres.get(0).getCantidad()%>, <%= ListadoLibres.get(1).getCantidad()%>, <%= ListadoLibres.get(2).getCantidad()%>, <%= ListadoLibres.get(3).getCantidad()%>, <%= ListadoLibres.get(4).getCantidad()%>],
		            fill: false,
		            backgroundColor:"rgba(54, 162, 235, 0.2)",
		            lineTension: 0.1,
		            borderColor: "rgba(44,80,96,0.5)",	            
		            borderWidth: 2
	        	},
	        	{
		        	label: "Regular",
		            data: [<%= ListadoRegulares.get(0).getCantidad()%>, <%= ListadoRegulares.get(1).getCantidad()%>, <%= ListadoRegulares.get(2).getCantidad()%>, <%= ListadoRegulares.get(3).getCantidad()%>, <%= ListadoRegulares.get(4).getCantidad()%>],
		            fill: false,
		            lineTension: 0.1,
		            borderColor: "rgba(225,108,96,0.5)",
		            borderWidth: 2
	        
	        	}

	        ]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	
	
	var ctx = document.getElementById('cantidad-inscriptos').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: ['2015', '2016', '2017', '2018', '2019'],
	        datasets: [{
	            label: 'Cantidad Alumnos',
	            data: [<%= ListadoAlumnosInscripto.get(0).getCantidad()%>, <%= ListadoAlumnosInscripto.get(1).getCantidad()%>, <%= ListadoAlumnosInscripto.get(2).getCantidad()%>, <%= ListadoAlumnosInscripto.get(3).getCantidad()%>, <%= ListadoAlumnosInscripto.get(4).getCantidad()%>],
	            borderWidth: 1,
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 255, 255, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 255, 255, 1)'
	            ]
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});
	
	var ctx = document.getElementById('materias-mas-inscriptos').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['<%=ListadoMateriaMasInscriptos.get(0).getMateria()%>', '<%=ListadoMateriaMasInscriptos.get(1).getMateria()%>', '<%=ListadoMateriaMasInscriptos.get(2).getMateria()%>', '<%=ListadoMateriaMasInscriptos.get(3).getMateria()%>', '<%=ListadoMateriaMasInscriptos.get(4).getMateria()%>'],
	        datasets: [{
	            label: 'Cantidad Inscriptos',
	            data: [<%=ListadoMateriaMasInscriptos.get(0).getCantidad()%>,<%=ListadoMateriaMasInscriptos.get(1).getCantidad()%>,<%=ListadoMateriaMasInscriptos.get(2).getCantidad()%>,<%=ListadoMateriaMasInscriptos.get(3).getCantidad()%>,<%=ListadoMateriaMasInscriptos.get(4).getCantidad()%>],
	            borderWidth: 1,
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	            ]
	        }]
	    },
	    options: {
	     
	    }
	});


	</script>
</body>
</html>