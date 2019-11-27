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
					</tr>
				</thead>
				<tbody>
			<% 
		
				
			for(Alumno unAlumno : Alumno.CargarAlumnos()){ 
			
				%>
					<tr>  
						  <td><%= unAlumno.getLegajo() %></td>
						  <td><%= unAlumno.getNombre() %></td>
						  <td><%= unAlumno.getApellido() %></td>
						  <td><input type="number"></td>
						  <td><input type="number"></td>
						  <td><input type="number"></td>
						  <td><input type="number"></td>
						  <td><select>
						  	<option>Regular</option>
						  	<option>Libre</option>
						  </select></td>
					</tr>
	
						  <%	
				}
				
				
			%>
			
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