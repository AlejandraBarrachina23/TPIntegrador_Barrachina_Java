<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dominio.Alumno"%>
    <%@page import="Dominio.Materia"%>
     <%@page import="DAO.AlumnosDAO"%>
     <%@page import="Dominio.Profesor"%>
     <%@page import="Negocio.MateriaNegocio"%>
     <%@page import="Negocio.ProfesorNegocio"%>
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
<nav>
<div id="user">
		<a href="index.jsp"><img id="icon-usuario" src="iconos/usuario-admin.svg" alt="imagen-usuario"></a>
		<h2>�Bienvenido!</h2>
		<p>${usuario.usuario}</p>
		<a href="ServeletUsuario">LogOut</a>
	</div>
<jsp:include page="menu-administrador.html"></jsp:include>
</nav>

<section class="section-principal">
	<div class="encabezados"><h3>ALTA CURSOS</h3></div>
		<form method="post" action="ServeletCurso" id="form-cursos">
			<!---------------------------------------------------------------------------------------------------------------
					FORM IZQUIERDA - ARRIBA
			<!-------------------------------------------------------------------------------------------------------------->
			<div id="form-curso-izquierda">				
				<div class="form-cursos-encabezado-izquierda">		
					<h2>1. SELECCIONA LOS DATOS DEL CURSO</h2>	
				</div>
				
				<label>Materia</label>
					<select id="cboxMaterias" required>
					<option disabled selected>Seleccione una Materia</option>
					<% MateriaNegocio unaMateriaNegocio = new MateriaNegocio();
					for(Materia unaMateria : unaMateriaNegocio.ListadoMaterias()){ %>
						<option class="opciones" value="<%=unaMateria.getIdMateria()%>"><%= unaMateria.getNombre()%></option><%}%>
					</select><br>
				<label>Semestre</label>
					<select id="cboxSemestre">
					 	<option disabled selected>Seleccione un Semestre</option>
						<option>Primero</option>
						<option>Segundo</option>
					</select><br>
				<label>A�o</label>
				<input type="text" id="tboxAnio" name="anio"><br>
				<label>Profesor</label>
					<select  id="cboxProfesores">
					<option disabled selected>Seleccione un profesor</option>
						<% ProfesorNegocio unProfesorNegocio = new ProfesorNegocio();
						for(Profesor unProfesor : unProfesorNegocio.ListadoProfesores()){ %>
						<option class="opciones" value="<%=unProfesor.getLegajo()%>"><%= unProfesor.getNombre()+" " +unProfesor.getApellido()%></option><%}%>
					</select><br>
			<!---------------------------------------------------------------------------------------------------------------
					FORM IZQUIERDA - ABAJO
			<!-------------------------------------------------------------------------------------------------------------->
		
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
				<% AlumnosDAO unAlumnoDAO = new AlumnosDAO(); 
				for(Alumno unAlumno : unAlumnoDAO.ListadoAlumnos()){ %>
						<tr>  
							  <td><input type="checkbox"></input></td>
							  <td><%= unAlumno.getLegajo() %></td>
							  <td><%= unAlumno.getNombre() %></td>
							  <td><%= unAlumno.getApellido() %></td>
						</tr>
				<%}%>
					</tbody>
				</table>
		</div>
			
			<!---------------------------------------------------------------------------------------------------------------
					FORM DERECHA
			<!-------------------------------------------------------------------------------------------------------------->
			
		<div id="form-curso-derecha">		
				
			<div class="form-cursos-encabezado-izquierda">		
				<h2>3. PREVISUALIZACI�N DE LA SELECCI�N</h2>	
			</div>
			
				<label>Materia: </label><br>
				<input type="text" id="tboxMateria-previsualizacion" name="tboxMateria-previsualizacion" readonly=true><br>
				<label>Semestre: </label><br>
				<input type="text" id="tboxSemestre-previsualizacion" name="tboxSemestre-previsualizacion"  readonly=true><br>
				<label>A�o: </label><br>
				<input type="text" id="tboxAnio-previsualizacion" value="2019" name="tboxAnio-previsualizacion" required readonly=true><br>
				<label>Profesor: </label><br>
				<input type="text" id="tboxProfesor-previsualizacion" name="tboxProfesor-previsualizacion" required readonly=true><br>
				<label>Listado de Alumnos: </label><br>
				<input type="hidden" id="listado-alumnos-oculto" name="listado-alumnos-oculto" required/>
				<ul id="listado-alumnos"></ul>
				<input type="submit" id="btnAgregarCurso" name="btnAgregarCurso" class="btnFormulario" onsubmit="return validacionesFormulario()" value="AGREGAR">	
			</div>
	</form>
</section>

<script>
	
	$(document).ready( function () {
	    $('#table_id').DataTable();
	    
	} );
		
	//A�O POR DEFECTO
	let fecha = new Date();
	let anio = fecha.getFullYear();
	document.getElementById('tboxAnio').value= anio;
	
	//CAMBIO VALORES INPUTS
	document.getElementById("tboxAnio").addEventListener('keyup', autoCompletar);
	document.getElementById("cboxSemestre").addEventListener('change', autoCompletarSemestre);
	document.getElementById("cboxMaterias").addEventListener('change', autoCompletarMateria);
	document.getElementById("cboxProfesores").addEventListener('change', autoCompletarProfesor);
	
	function autoCompletar(){
		
		$("#tboxAnio").keyup(autoCompletar); 
		var valor = $(this).val();
		$("#tboxAnio-previsualizacion").val(valor);
	}
	
	function autoCompletarSemestre(){
		
		let combobox = document.getElementById("cboxSemestre");
		let opcionSeleccionada = combobox.options[combobox.selectedIndex].text;
		document.getElementById("tboxSemestre-previsualizacion").value = opcionSeleccionada;
	}
	
	function autoCompletarMateria(){

		let combobox = document.getElementById("cboxMaterias");	
		let opcionSeleccionada = combobox.options[combobox.selectedIndex].text;
		let indiceSeleccionado = document.getElementById("cboxMaterias").value;
		document.getElementById("tboxMateria-previsualizacion").value = indiceSeleccionado + "-" + opcionSeleccionada;
	}
	
	function autoCompletarProfesor(){
		
		let combobox = document.getElementById("cboxProfesores");	
		let opcionSeleccionada = combobox.options[combobox.selectedIndex].text;
		let indiceSeleccionado = document.getElementById("cboxProfesores").value;
		document.getElementById("tboxProfesor-previsualizacion").value = indiceSeleccionado + "-" + opcionSeleccionada;
	}
	
	//RECORRE TABLA Y AGREGAR/ELIMINA VALORES EN LA LISTA DE ALUMNOS
	let listadoAlumnos=[];
	let listadoLegajoAlumnos=[];
	
	$('input[type=checkbox]').click(function() {

		 const legajo = $(this).parents("tr").find("td").eq(1).text();
		 const nombre = $(this).parents("tr").find("td").eq(2).text();
		 const apellido = $(this).parents("tr").find("td").eq(3).text();
		 const itemSeleccionado = legajo+"-"+nombre+" "+apellido;
		 const lista = document.getElementById("listado-alumnos");
		 $('#listado-alumnos li').remove();
		 document.getElementById("listado-alumnos-oculto").value="";
		
		if($(this).is(":checked")){
			listadoAlumnos.push(itemSeleccionado);
			listadoLegajoAlumnos.push(legajo);	
			
		}
		else {
			
			 let posicion;
			 let posicionLegajo;
			 
			 for (let i = 0; i < listadoAlumnos.length; i++) {
				 if(itemSeleccionado===listadoAlumnos[i]) posicion=i;
			 }
			
			 for (let j = 0; j < listadoLegajoAlumnos.length; j++) {
				 if(legajo===listadoLegajoAlumnos[j]) posicionLegajo=j;
			 }

			 listadoAlumnos.splice(posicion,1);
			 listadoLegajoAlumnos.splice(posicionLegajo,1);
			 $('#listado-alumnos li').remove();
			 document.getElementById("listado-alumnos-oculto").value="";

		}
		 for (let i = 0; i < listadoAlumnos.length; i++) {
			 let item = document.createElement("li");
			 item.appendChild(document.createTextNode(listadoAlumnos[i]));
			 lista.appendChild(item);
		 }
		 
		 for (let j = 0; j < listadoLegajoAlumnos.length; j++) {
			
			 let tboxListadoLegajoAlumnos = document.getElementById("listado-alumnos-oculto");
			 tboxListadoLegajoAlumnos.value += listadoLegajoAlumnos[j] +"-";
		 }
	});
	


	</script>
</body>
</html>