package Dominio;

public class Localidad {

	private int IdLocalidad;
	private Provincia Provincia;
	private String Nombre;
	
	public int getIdLocalidad() {
		return IdLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		IdLocalidad = idLocalidad;
	}
	public Provincia getProvincia() {
		return Provincia;
	}
	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	@Override
	public String toString() {
		return Nombre;
	}
}
