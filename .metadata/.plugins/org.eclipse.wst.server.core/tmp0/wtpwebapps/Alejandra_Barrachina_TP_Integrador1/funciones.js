$(document).ready( function () {
	    $('#table_id').DataTable();
		
	});
	
	$( function() {
	    $( "#datepicker" ).datepicker();
	});
	
	function cambiaValores(accion) {
		let tipoFormulario = document.getElementById('tipoFormulario');
		tipoFormulario.value = accion;
	}
	
	
	const btnAbrir = document.getElementById('btnAgregarAlumno');
	var btnEliminar = document.getElementsByClassName('btn-eliminar');
	var btnModificar = document.getElementsByClassName('btn-modificar');
	const fondo = document.getElementById('modal-fondo');
	const ventanaEmergente = document.getElementById('modal-contenido');
	const ventanaAdvertencia = document.getElementById('modal-advertencia');
	const fondoAdvertencia = document.getElementById('modal-fondo-advertencia');
	const btnCerrar = document.getElementById('btnCerrar');
	const btnCerrarAdvertencia = document.getElementById('btnCancelar');
	
	btnAbrir.addEventListener('click', function(){
		
		fondo.classList.add('active');
		document.getElementById('form-datos-alumnos').reset();
		cambiaValores('agregar');
		
			
	});
	
	for (var i=0; i< btnModificar.length; i++) {
        
        btnModificar[i].addEventListener("click",function() {
        	
        	fondo.classList.add('active');
        	cambiaValores('modificar');
        	
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