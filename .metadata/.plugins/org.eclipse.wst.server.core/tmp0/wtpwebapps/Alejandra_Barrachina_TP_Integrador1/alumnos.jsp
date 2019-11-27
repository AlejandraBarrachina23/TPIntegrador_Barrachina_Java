<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.*"%>
        <%@page import="Dominio.Provincia"%>
        <%@page import="DAO.*"%>
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
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="jquery.dataTables.min.js"></script>

</head>
<body>
<jsp:include page="menu-administrador.html"></jsp:include>
<section class="section-principal">
	<div class="encabezados"><h3>LISTADO DE ALUMNOS</h3></div>
	<div id="form-listado-alumnos">
			<input type="button" id="btnAgregarAlumno" class="btnFormulario" value="AGREGAR ALUMNO">		
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
			
			AlumnosDAO unAlumnoDAO = new AlumnosDAO(); 
			for(Alumno unAlumno : unAlumnoDAO.ListadoAlumnos()){%>
					<tr>  
						  <td><%= unAlumno.getLegajo() %></td>
						  <td><%= unAlumno.getNombre() %></td>
						  <td><%= unAlumno.getApellido() %></td>
						  <td><%= unAlumno.getFechaNacimiento() %></td>
						  <td><%= unAlumno.getDireccion() %></td>
						  <td><%= unAlumno.getLocalidad() %></td>
						  <td><%= unAlumno.getLocalidad().getProvincia() %></td>
						  <td><%= unAlumno.getEmail() %></td>
						  <td><%= unAlumno.getTelefono() %></td>
						  <td>
						  	  <input type="button" class="btn-modificar" value="">
						  	  <input type="button" class="btn-eliminar" value="">
						  </td>
					</tr>
			  <%}%>
				</tbody>
			</table>
					
			</div>
			<div class="modal-fondo" id="modal-fondo">
				<div class="modal-contenido" id="modal-contenido">
					<h3>DATOS ALUMNO</h3><br>
					<form method="post" action="ServeletAlumno" id="form-datos-alumnos">
						<label>Legajoe<br><input type="text" id="tboxLegajo" name="tboxLegajo" required  ></label><br>
						<label>Nombre<br><input type="text" id="tboxNombre" name="tboxNombre" required  ></label><br>
						<label>Apellido<br><input type="text" id="tboxApellido" name="tboxApellido" required></label><br>
						<label>Fecha de Nacimiento</label><br><input type="date" id="tboxFechaNacimiento" name="tboxFechaNacimiento" required><br>
						<label>Direccion<br><input type="text" id="tboxDireccion" name="tboxDireccion" required></label><br>
						<label>Provincias</label><br>
						<select name="cboxProvincias" id="cboxProvincias" required>
							<%
							ProvinciasDAO Provincias = new ProvinciasDAO();
							for(Provincia unaProvincia : Provincias.ListadoProvincias()){%>
							<option class="opciones" value="<%=unaProvincia.getIdProvincia()%>"><%= unaProvincia.getNombre()%></option><%}%>
						</select><br>											
						<label>Localidades</label><br>
						<select name="cboxLocalidades" id="cboxLocalidades" required></select>
						<br>
						<label>E-mail<br><input type="email" id="tboxEmail" name="tboxEmail" required></label><br>
						<label>Tel�fono<br><input type="number" id="tboxTelefono" name="tboxTelefono" required></label><br>
						<input type="submit" class="btn-modal" id="btnAceptar" name="btnAceptar" value="Aceptar">
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

	$(document).ready( function () {
	    $('#table_id').DataTable();
		
	});
	
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
        	const desplegableLocalidad = document.getElementById("cboxLocalidades");	

			<% LocalidadesDAO Localidad = new LocalidadesDAO();
			 for(Localidad unaLocalidad : Localidad.ListadoLocalidades()){%>	
			
			 	var item = document.createElement('option');
				item.value = '<%=unaLocalidad.getIdLocalidad()%>';
				item.innerHTML = '<%=unaLocalidad.getNombre()%>';
				desplegableLocalidad.appendChild(item);
			 		
			 <%}%>
        	
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
			$('#tboxDireccion').val($(this).parents("tr").find("td").eq(4).text());
			$('#tboxEmail').val($(this).parents("tr").find("td").eq(7).text());
			$('#tboxTelefono').val($(this).parents("tr").find("td").eq(8).text());
			
			var select=document.getElementById("cboxProvincias");
			var buscar=$(this).parents("tr").find("td").eq(6).text();
			
			for(var i=1;i<select.length;i++)
			{
				if(select.options[i].text==buscar)
				{
					select.selectedIndex=i;
				}
			}
					
			$("#registroEliminar").text($(this).parents("tr").find("td").eq(0).text());
			
	});
	
	
		$('#cboxProvincias').change(function(){
			
			$('#cboxLocalidades option').remove();
			LocalidadSeleccionada(this,'cboxLocalidades');
		
		});
		
		function LocalidadSeleccionada(cboxProvincias, cboxLocalidades){
			
			const provinciaSeleccionada = document.getElementById("cboxProvincias").value;
			const desplegableLocalidad = document.getElementById("cboxLocalidades");	
	
			 <%
			 for(Localidad unaLocalidad : Localidad.ListadoLocalidades()){%>	
			
			 if(provinciaSeleccionada==<%=unaLocalidad.getProvincia().getIdProvincia()%>){
			 	var item = document.createElement('option');
				item.value = '<%=unaLocalidad.getIdLocalidad()%>';
				item.innerHTML = '<%=unaLocalidad.getNombre()%>';
				desplegableLocalidad.appendChild(item);
			 }		
			 <%}%>
			
		}
	
	
	$( function() {
			    $( "#datepicker" ).datepicker();
			  } );


	</script>
</body>
</html>