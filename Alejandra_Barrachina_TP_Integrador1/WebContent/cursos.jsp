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

<jsp:include page="menu-administrador.html"></jsp:include>

<section class="section-principal">
	<div class="encabezados"><h3>ALTA CURSOS</h3></div>
		<form method="post" action="" id="form-cursos">
			<div id="form-curso-izquierda">				
				<div class="form-cursos-encabezado-izquierda">		
					<h2>1. SELECCIONA LOS DATOS DEL CURSO</h2>	
				</div>
				<label>Materia</label>
					<select>
						<option>Opci�n 1</option>
						<option>Opci�n 2</option>
						<option>Opci�n 3</option>
						<option>Opci�n 4</option>
					</select><br>
					<label>Semestre</label>
					<select>
						<option>Primero</option>
						<option>Segundo</option>
						
					</select><br>
					
					<label>A�o</label><input type="text" name="anio"><br>
					
					<label>Profesor</label>
					<select>
						<option>Opci�n 1</option>
						<option>Opci�n 2</option>
						<option>Opci�n 3</option>
						<option>Opci�n 4</option>
					</select><br>
			
			<div class="form-cursos-encabezado-izquierda">		
				<h2>2. SELECCIONA LOS ALUMNOS DEL CURSO</h2>	
			</div>
				<table id="table_id" class="content-table">
					<thead>
						<tr>
							<th>Agregar</th>
							<th>Legajo</th>
							<th>Nombre</th>
							<th>Apellido</th>
						</tr>
					</thead>
					<tbody>
				<% 
			
					
				for(Alumno unAlumno : Alumno.CargarAlumnos()){ 
		
					%>
						<tr>  
							  <td><input type="checkbox"></input></td>
							  <td><%= unAlumno.getLegajo() %></td>
							  <td><%= unAlumno.getNombre() %></td>
							  <td><%= unAlumno.getApellido() %></td>
						</tr>
		
							  <%	
					}
					
					
				%>
				
				</tbody>
				</table>
				<input type="button" id="btnAgregarAlumno" class="btnFormulario" value="AGREGAR">
			</div>
			<div id="form-curso-derecha">		
				
				<div class="form-cursos-encabezado-izquierda">		
					<h2>3. PREVISUALIZACI�N DE LA SELECCI�N</h2>	
				</div>
				
				<label>Materia: </label><br>
				<input type="text" value="Opcion 2" disabled><br>
				<label>Semestre: </label><br>
				<input type="text" value="Segundo" disabled><br>
				<label>A�o: </label><br>
				<input type="text" value="2019" disabled><br>
				<label>Profesor: </label><br>
				<input type="text" value="Opcion 3" disabled><br>
				<label>Listado de Alumnos: </label><br>
				
				<ul id="listado-alumnos">
					<li>NombreAlumno1</li>
					<li>NombreAlumno2</li>
					<li>NombreAlumno4</li>
				</ul>
					
				
				<input type="button" id="btnAgregarAlumno" class="btnFormulario" value="AGREGAR">	
				<input type="button" id="btnAgregarAlumno" class="btnFormulario" value="RESETEAR">	
			</div>
		
	</form>

			
			
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