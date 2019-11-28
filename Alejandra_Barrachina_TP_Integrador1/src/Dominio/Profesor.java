package Dominio;

import java.util.ArrayList;

public class Profesor {
	
	private int Legajo;
	private String Nombre;
	private String Apellido;
	private String FechaNacimiento;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private String Email;
	private int Telefono;
	
	public int getLegajo() {
		return Legajo;
	}
	public void setLegajo(int legajo) {
		Legajo = legajo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
	
	public static ArrayList <Profesor> CargarProfesor() {
		
		 ArrayList<Profesor>ListadoProfesores = new ArrayList<Profesor>();
		
		 for (int i = 0; i<50; i++) {	 
			
			 Profesor profesor = new Profesor();
					
			 profesor.setLegajo(i+95);
			 profesor.setNombre("NombreProfesor"+i);
			 profesor.setApellido("Apellido"+i);
			 profesor.setFechaNacimiento("Fecha"+i);
			 profesor.setDireccion("Direccion"+i);
			 profesor.setLocalidad("Localidad"+i);
			 profesor.setProvincia("Provincia"+i);
			 profesor.setEmail("Email"+i);
			 profesor.setTelefono(Integer.parseInt("111111"+i));	
				
			 ListadoProfesores.add(profesor);
		}	
		
		 return ListadoProfesores;	 
		
	}

}