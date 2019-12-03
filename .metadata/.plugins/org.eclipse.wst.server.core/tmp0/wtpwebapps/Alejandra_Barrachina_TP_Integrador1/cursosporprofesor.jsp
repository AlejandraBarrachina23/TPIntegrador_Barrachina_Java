<%@page import="Dominio.Curso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Alumno"%>
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
	<div class="encabezados"><h3>CURSOS ASOCIADOS</h3></div>	
	<div id="form-listado-calificaciones">
			<h2>LISTADO DE CURSOS</h2>
			<table id="table_id" class="content-table">
				<thead>
					<tr>
						<th>Materia</th>
						<th>Semestre</th>
						<th>A�o</th>
						<th>Alumnos</th>
					</tr>
				</thead>
				<tbody>
					<%CursoNegocio unCursoNegocio = new CursoNegocio();
					for(Curso unCurso : unCursoNegocio.CursosxProfesor(5)){	%>
				<tr>  
					<td><%= unCurso.getMateria().getNombre() %></td>
					<td><%= unCurso.getSemestre() %></td>
					<td><%= unCurso.getAnio() %></td>
				    <td>
				    	<a href="calificaciones.jsp"><input type="button" class="btn-mostrar" value=""></a>
				        <a href="calificaciones.jsp"><input type="button" class="btn-calificaciones" value=""></a>
				    </td>
				</tr><%}%>
			</tbody>
			</table>		
			</div>
</section>

<script>

	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	
	</script>
</body>
</html>