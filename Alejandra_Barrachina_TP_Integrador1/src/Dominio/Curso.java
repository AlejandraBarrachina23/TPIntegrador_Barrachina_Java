package Dominio;

import java.util.ArrayList;

public class Curso {
	
	private int IdCurso;
	private Materia Materia;
	private String Semestre;
	private int anio;
	private Profesor ProfesorTitular;
	ArrayList <Alumno> ListadoAlumnos;
	
	public int getIdCurso() {
		return IdCurso;
	}
	public void setIdCurso(int idCurso) {
		IdCurso = idCurso;
	}
	
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
	
	public static ArrayList <Curso> CargarCurso() {
		
		 ArrayList<Curso>ListadoCursos = new ArrayList<Curso>();
		
		 for (int i = 0; i<10; i++) {	 
			
			 Curso curso = new Curso();
					
				
			 	curso.Materia = new Materia();
			 	curso.ProfesorTitular = new Profesor();
			 	curso.Materia.setIdMateria(i+20);
			 	curso.Materia.setNombre("Programacion"+i);
			 	curso.ProfesorTitular.setNombre("NombreProfesor");
			 	curso.setIdCurso(i);
				curso.setSemestre("Segundo");
				curso.setAnio(2019);
				ListadoCursos.add(curso);
		}	
		
		 return ListadoCursos;	 
		
	}
	
}