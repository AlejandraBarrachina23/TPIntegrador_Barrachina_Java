<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Alumno"%>
    <%@page import="Dominio.Curso"%>
    <%@page import="Dominio.Materia"%>
    <%@page import="Dominio.Calificaciones"%>
     <%@page import="Dominio.Profesor"%>
    <%@page import="Negocio.CursoNegocio"%>
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
<script src="jquery-3.4.1.min.js"></script>
<script src="jquery.dataTables.min.js"></script>

</head>
<body>

<jsp:include page="menu-profesores.html"></jsp:include>

<section class="section-principal">
	<div class="encabezados"><h3>CALIFICACIONES</h3></div>
	
	<div class="busqueda-califaciones">
		<h2>1. CURSO SELECCIONADO</h2>
			<input type="text" placeholder="Materia" disabled>
			<input type="text" placeholder="Semestre" disabled>
			<input type="number" placeholder="A�o" disabled>
	</div>
	<div id="form-listado-calificaciones">
			<h2>2. CARGUE LAS CALIFICACIONES</h2>
			<table id="table_id" class="content-table">
				<thead>
					<tr>
						<th>Legajo</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Parcial Uno</th>
						<th>Parcial Dos</th>
						<th>Recuperatorio Uno</th>
						<th>Recuperatorio Dos</th>
						<th>Estado</th>
						<br>
					</tr>
				</thead>
				<tbody>
			<% 
						
			CursoNegocio unCursoNegocio = new CursoNegocio();
			Curso cursoSeleccionado = new Curso();
			Materia unaMateria = new Materia();
			Profesor unProfesor = new Profesor();
			
			cursoSeleccionado.setAnio(2019);
			unaMateria.setIdMateria(12);
			unProfesor.setLegajo(5);			
			cursoSeleccionado.setMateria(unaMateria);
			cursoSeleccionado.setProfesorTitular(unProfesor);
			cursoSeleccionado.setSemestre("primero");
			
			for(Curso unCurso : unCursoNegocio.AlumnosxCurso(cursoSeleccionado)){	%>
							
					<tr>
					<% for(Alumno alumnosxcurso : unCurso.getListadoAlumnos()){
							
						%>
						  <td><%= alumnosxcurso.getLegajo()%></td>
						  <td><%= alumnosxcurso.getNombre()%></td>
						  <td><%= alumnosxcurso.getApellido() %></td>
						
						<%for(Calificaciones calificacionxalumno : unCurso.getListadoNotas()){
							
							if(alumnosxcurso.getLegajo()==calificacionxalumno.getLegajoAlumno()){%>
        						  <td><input type="number" value="<%calificacionxalumno.getParcialUno(); %>"></td>
								  <td><input type="number" value="<%calificacionxalumno.getParcialDos(); %>"></td>
								  <td><input type="number" value="<%calificacionxalumno.getRecuperatorioUno(); %>"></td>
								  <td><input type="number" value="<%calificacionxalumno.getRecuperatorioDos(); %>"></td>
								  <td><input type="text" value="vacio"></td>
							<%}
						}
					}%> 
					</tr> 
				<%}%>
			</tbody>
			</table>
				<input type="button" id="btnAgregarCalificacion" class="btnFormulario" value="CARGAR CALIFICACIONES">			
			</div>
			
			<div class="modal-fondo" id="modal-fondo-advertencia">
			
				<div class="modal-contenido" id="modal-advertencia">
					<h3>ELIMINAR REGISTRO</h3><br>
					 <p>�Est� seguro que desea eliminar el legajo<label id="registroEliminar"></label>?</p>
					 <input type="button" class="btn-modal" id="btnBorrar" value="Borrar">
					 <input type="button" class="btn-modal" id="btnCancelar" value="Cancelar">					
				</div>
			</div>
			
</section>
<script>
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );


</script>
</body>
</html>