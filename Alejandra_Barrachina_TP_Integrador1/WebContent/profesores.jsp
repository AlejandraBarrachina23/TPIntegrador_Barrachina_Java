<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Profesor"%>
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

<jsp:include page="menu-administrador.html"></jsp:include>

<section class="section-principal">
	<div class="encabezados"><h3>LISTADO DE PROFESORES</h3></div>
	
	<div id="form-listado-alumnos">
			<input type="button" id="btnAgregarAlumno" class="btnFormulario" value="AGREGAR PROFESOR">		
			<table id="table_id" class="content-table">
				<thead>
					<tr>
						<th>Legajo</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Fecha de Nacimiento</th>
						<th>Direcci�n</th>
						<th>Localidad</th>
						<th>Provincia</th>
						<th>Email</th>
						<th>Tel�fono</th>
						<th>Opciones</th>
					</tr>
				</thead>
				<tbody>
			<% 
		
				
			for(Profesor unProfesor : Profesor.CargarProfesor()){ 
			
				%>
					<tr>  
						  <td><%= unProfesor.getLegajo() %></td>
						  <td><%= unProfesor.getNombre() %></td>
						  <td><%= unProfesor.getApellido() %></td>
						  <td><%= unProfesor.getFechaNacimiento() %></td>
						  <td><%= unProfesor.getDireccion() %></td>
						  <td><%= unProfesor.getLocalidad() %></td>
						  <td><%= unProfesor.getProvincia() %></td>
						  <td><%= unProfesor.getEmail() %></td>
						  <td><%= unProfesor.getTelefono() %></td>
						  <td>
						  	  <input type="button" class="btn-modificar" value="">
						  	  <input type="button" class="btn-eliminar" value="">
						  </td>
					</tr>
	
						  <%	
				}
				
				
			%>
			
			</tbody>
			</table>
					
			</div>
			<div class="modal-fondo" id="modal-fondo">
				<div class="modal-contenido" id="modal-contenido">
					<h3>DATOS PROFESOR</h3><br>
					<form method="post" action="" id="form-datos-alumnos">
						<label>Legajo<br><input type="text" id="tboxLegajo" name="Legajo"></label><br>
						<label>Nombre<br><input type="text" id="tboxNombre" ></label><br>
						<label>Apellido<br><input type="text" id="tboxApellido" ></label><br>
						<label>Fecha de Nacimiento<br><input type="text" id="tboxFechaNacimiento" ></label><br>
						<label>Localidad<br><input type="text" id="tboxLocalidad"></label><br>
						<label>Provincia<br><input type="text" id="tboxProvincia"></label><br>
						<label>E-mail<br><input type="text" id="tboxEmail"></label><br>
						<label>Tel�fono<br><input type="text" id="tboxTelefono" ></label><br>
						<input type="button" class="btn-modal" id="btnAceptar" value="Aceptar">
						<input type="button" class="btn-modal" id="btnCerrar" value="Cancelar">		
					</form>			
				</div>
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