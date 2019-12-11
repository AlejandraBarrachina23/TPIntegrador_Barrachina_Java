package Dominio;

import java.util.ArrayList;

public class Curso {
	
	private Materia Materia;
	private String Semestre;
	private int anio;
	private Profesor ProfesorTitular;
	private ArrayList <Alumno> ListadoAlumnos;
	private ArrayList <Calificaciones> ListadoNotas;
	
	public Materia getMateria() {
		return Materia;
	}
	public void setMateria(Materia materia) {
		Materia = materia;
	}
	public String getSemestre() {
		return Semestre;
	}
	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Profesor getProfesorTitular() {
		return ProfesorTitular;
	}
	public void setProfesorTitular(Profesor profesorTitular) {
		ProfesorTitular = profesorTitular;
	}
	public ArrayList<Alumno> getListadoAlumnos() {
		return ListadoAlumnos;
	}
	public void setListadoAlumnos(ArrayList<Alumno> listadoAlumnos) {
		ListadoAlumnos = listadoAlumnos;
	}
	
	public ArrayList<Calificaciones> getListadoNotas() {
		return ListadoNotas;
	}
	public void setListadoNotas(ArrayList<Calificaciones> listadoNotas) {
		ListadoNotas = listadoNotas;
	}
	

}
