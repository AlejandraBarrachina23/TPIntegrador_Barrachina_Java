<%@page import="Dominio.Curso"%>
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
						<th>Código Curso</th>
						<th>Materia</th>
						<th>Semestre</th>
						<th>Año</th>
						<th>Alumnos</th>
					</tr>
				</thead>
				<tbody>
			<% 
		
				
			for(Curso unCurso : Curso.CargarCurso()){ 
			
				%>
					<tr>  
						  <td><%= unCurso.getIdCurso() %></td>
						    <td><%= unCurso.getMateria().getNombre() %></td>
						    <td><%= unCurso.getSemestre() %></td>
						    <td><%= unCurso.getAnio() %></td>
				            <td>
				            <a href="calificaciones.jsp"><input type="button" class="btn-mostrar" value=""></a>
				            <a href="calificaciones.jsp"><input type="button" class="btn-calificaciones" value=""></a>
				            </td>
					</tr>
	
						  <%	
				}
				
			%>
			
			</tbody>
			</table>		
			</div>
			
			<div class="modal-fondo" id="modal-fondo-advertencia">
			
				<div class="modal-contenido" id="modal-advertencia">
					<h3>ELIMINAR REGISTRO</h3><br>
					 <p>¿Está seguro que desea eliminar el legajo<label id="registroEliminar"></label>?</p>
					 <input type="button" class="btn-modal" id="btnBorrar" value="Borrar">
					 <input type="button" class="btn-modal" id="btnCancelar" value="Cancelar">					
				</div>
			</div>
			
</section>


<script>

	/*const flecha = document.getElementById('btn-flecha').addEventListener('click',mostarDiv);
	
	function mostarDiv(){
	
	    document.getElementById('form-agregar-usuario').style.display = 'block';
	
	}*/
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	
	const btnAbrir = document.getElementById('btnAgregarAlumno');
	var btnEliminar = document.getElementsByClassName('btn-eliminar');
	var btnModificar = document.getElementsByClassName('btn-modificar');
	const fondo = document.getElementById('modal-fondo');
	const ventanaEmergente = document.getElementById('modal-contenido');
	const ventanaAdvertencia = document.getElementById('modal-advertencia');
	const fondoAdvertencia = document.getElementById('modal-fondo-advertencia');
	const btnCerrar = document.getElementById('btnCerrar');
	const btnCerrarAdvertencia = document.getElementById('btnCancelar');btnCancelar
	
	btnAbrir.addEventListener('click', function(){
		
		fondo.classList.add('active');
		document.getElementById('form-datos-alumnos').reset();
		
	});
	
	for (var i=0; i< btnModificar.length; i++) {
        
        btnModificar[i].addEventListener("click",function() {
        	
        	fondo.classList.add('active');
        });
    }
	
	for (var i=0; i< btnEliminar.length; i++) {
        
		btnEliminar[i].addEventListener("click",function() {
        	
        	fondoAdvertencia.classList.add('active');
        });
    }
	
	btnCerrar.addEventListener('click', function(){
		
		fondo.classList.remove('active');
	});
	
	btnCerrarAdvertencia.addEventListener('click', function(){
		
		fondoAdvertencia.classList.remove('active');

	});
			
	$("td").click(function(){
			
			$('#tboxLegajo').val($(this).parents("tr").find("td").eq(0).text());
			$('#tboxNombre').val($(this).parents("tr").find("td").eq(1).text());
			$('#tboxApellido').val($(this).parents("tr").find("td").eq(2).text());
			$('#tboxFechaNacimiento').val($(this).parents("tr").find("td").eq(3).text());
			$('#tboxLocalidad').val($(this).parents("tr").find("td").eq(4).text());
			$('#tboxProvincia').val($(this).parents("tr").find("td").eq(5).text());
			$('#tboxEmail').val($(this).parents("tr").find("td").eq(6).text());
			$('#tboxTelefono').val($(this).parents("tr").find("td").eq(7).text());
			$("#registroEliminar").text($(this).parents("tr").find("td").eq(0).text());
			
	});


	</script>
</body>
</html>