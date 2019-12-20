<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Alumno"%>
     <%@page import="Dominio.Usuario"%>
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

<% 
	if((Usuario) request.getSession(true).getAttribute("usuario")!=null){
		
		Usuario unUsuario = new Usuario();
		unUsuario = (Usuario) request.getSession(true).getAttribute("usuario");
		System.out.println(unUsuario);
		
		if(!unUsuario.getTipoUsuario().equals("administrador")){response.sendRedirect("error404.jsp");}
		
		}
		else {
			response.sendRedirect("error404.jsp");
		}
%>
	
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
					<%=reporte.CantidadAlumnosAnio(2019)%></p>
					<img alt="total-alumnos" src="img/total.svg">					
					<div class="fila-uno-items-pie">
						<img id="img-total-alumnos" src="iconos/baja.svg" alt="subida">
						<p id="total-alumnos"></p>
					</div>
				</div>
				<div class="fila-uno-items">
					<h2>ALUMNOS REGULARES</h2>					
					<p><%=reporte.CantidadAlumnosRegulares() %></p>
					<img alt="alumno-regular" src="img/regular.svg">
					<div class="fila-uno-items-pie">
						<img id="img-alumno-regular" src="iconos/alta.svg" alt="subida">
						<p id="alumno-regular"></p>
					</div>
				</div>
				<div class="fila-uno-items">
					<h2>ALUMNOS LIBRES</h2>
					<p><%= reporte.CantidadAlumnosLibres() %></p>
					<img alt="alumno-libre" src="img/libre.svg">
					<div class="fila-uno-items-pie">
						<img id="img-alumno-libre" src="iconos/baja.svg" alt="subida">
						<p id="alumno-libre"></p>
					</div>
				</div>
				<div class="fila-uno-items">
					<h2>TOTAL PROFESORES</h2>
					<p><%= reporte.CantidadProfesoresActivos() %></p>
					<img alt="profesores" src="img/maestros.svg">
					<div class="fila-uno-items-pie">
						<img src="iconos/alta.svg" alt="subida">
						<p id="profesores">0.00</p>
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
						<%for(Reporte unReporte : reporte.MejoresPromedios(2019)){ %>
							<tr> 
							 
								  <td><%= unReporte.getUnAlumno().getLegajo() %></td>
								  <td><%= unReporte.getUnAlumno().getNombre() %></td>
								  <td><%= unReporte.getUnAlumno().getApellido() %></td>
								  <td><%= unReporte.getPromedio() %></td>
							</tr>
						<%} %>
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
						<%for(Reporte unReporte : reporte.PeoresPromedios(2019)){ %>
							<tr> 
							 
								  <td><%= unReporte.getUnAlumno().getLegajo() %></td>
								  <td><%= unReporte.getUnAlumno().getNombre() %></td>
								  <td><%= unReporte.getUnAlumno().getApellido() %></td>
								  <td><%= unReporte.getPromedio() %></td>
							</tr>
						<%} %>
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
						<% for(Curso unCurso : reporte.MateriasConMasEgresos()){%>
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


CalcularDiferencia();
ComparativaAlumnosInscriptos();
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	
	function CalcularDiferencia(cantidadAlumnosActual,cantidadAlumnosAnterior){
		
		let totalAlumnos = <%=reporte.DiferenciaAlumnosxAnio(2019, 2018) %> ;
		let totalAlumnosRegulares = <%=reporte.DiferenciaAlumnosRegularesxAnio(2019, 2018) %>;
		let totalAlumnosLibres = <%=reporte.DiferenciaAlumnosRegularesxAnio(2018, 2019) %>;
		
		document.getElementById("total-alumnos").innerText= totalAlumnos+ "%";
		document.getElementById("alumno-regular").innerText= totalAlumnosRegulares+ "%";
		document.getElementById("alumno-libre").innerText= totalAlumnosLibres+ "%";
		
		if(totalAlumnos>0) document.getElementById("img-total-alumnos").src= "iconos/alta.svg";
		else document.getElementById("img-total-alumnos").src= "iconos/baja.svg";
		
		if(totalAlumnosRegulares>0) document.getElementById("img-alumno-regular").src= "iconos/alta.svg";
		else document.getElementById("img-alumno-regular").src= "iconos/baja.svg";
		
		if(totalAlumnosLibres>0) document.getElementById("img-alumno-libre").src= "iconos/alta.svg";
		else document.getElementById("img-alumno-libre").src= "iconos/baja.svg";

	}
	
	function ComparativaAlumnosInscriptos(){
	
		Listado = [];
		
		<%ArrayList<Reporte>ListadoComparativaInscriptos = reporte.ComparativaAlumnosInscriptos(2019);%>
		
		<%for(Reporte unReporte : ListadoComparativaInscriptos){ %>
		
			Listado.push(<%=unReporte.getCantidad()%>);
		
			 <%}%>
			 
		return Listado; 
	}
	
	function MateriaConMasInscriptosMateriasCantidad(){
		
		Listado = [];
		<% ArrayList<Reporte>ListadoMateriaMasInscriptos = reporte.MateriasMasInscripciones(2019);%>
		
		<%for(Reporte unReporte : ListadoMateriaMasInscriptos){ %>
		
			Listado.push(<%=unReporte.getCantidad()%>);
	
		 <%}%>
		
		 return Listado;
		
	}
	
	function MateriaConMasInscriptosMateriasNombre(){
		
		Listado = [];
			
		<%for(Reporte unReporte : ListadoMateriaMasInscriptos){ %>
		
			Listado.push('<%=unReporte.getMateria()%>');
	
		 <%}%>
		
		 return Listado;
		
	}
	
	
	function EstadosAlumnosxAnioRegulares(){
		
		Listado = [];
		<% ArrayList<Reporte>EstadosAlumnosxAnioRegulares = reporte.EstadosAlumnosxAnio(2019);%>
		
		<%for(Reporte unReporte : EstadosAlumnosxAnioRegulares){ %>
		
			Listado.push(<%=unReporte.getCantidad()%>);
	
		 <%}%>
		
		 return Listado;
		
	}
	
	
	function EstadosAlumnosxAnioLibres(){
		
		Listado = [];
		
		<% ArrayList<Reporte>ListadoLibres = reporte.EstadosAlumnosxAnioLibres(2019);%>
		
		<%for(Reporte unReporte : ListadoLibres){ %>
		
			Listado.push(<%=unReporte.getCantidad()%>);
	
		 <%}%>
		
		 return Listado;
		
	}
		
	var ctx = document.getElementById('comparativa-alumnos').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: ['2015', '2016', '2017', '2018', '2019'],
	        datasets: [
	        	
	        	{
		        	label:"Libres",
		            data: EstadosAlumnosxAnioLibres(),
		            fill: false,
		            backgroundColor:"rgba(54, 162, 235, 0.2)",
		            lineTension: 0.1,
		            borderColor: "rgba(44,80,96,0.5)",	            
		            borderWidth: 2
	        	},
	        	{
		        	label: "Regular",
		            data: EstadosAlumnosxAnioRegulares(),
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
	            data: ComparativaAlumnosInscriptos(),
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
		type: 'horizontalBar',
	    data: {
	        labels: MateriaConMasInscriptosMateriasNombre(),
	        datasets: [{
	            label: 'Cantidad Inscriptos',
	            data: MateriaConMasInscriptosMateriasCantidad(),
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
	        scales: {
	            xAxes: [{
	                ticks: {
	                    min: 2
	                }
	            }],
	            yAxes: [{
	                stacked: true
	            }]
	        }
	    }
	});


	</script>
</body>
</html>