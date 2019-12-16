package Dominio;

public class Reporte {

	private int Anios;
	private int Cantidad;
	private String Materia;
	private Alumno unAlumno;
	
	public Alumno getUnAlumno() {
		return unAlumno;
	}
	public void setUnAlumno(Alumno unAlumno) {
		this.unAlumno = unAlumno;
	}
	public float getPromedio() {
		return Promedio;
	}
	public void setPromedio(float promedio) {
		Promedio = promedio;
	}
	private float Promedio;
	
	public String getMateria() {
		return Materia;
	}
	public void setMateria(String materia) {
		Materia = materia;
	}
	public int getAnios() {
		return Anios;
	}
	public void setAnios(int anios) {
		Anios = anios;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
}
