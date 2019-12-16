package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Alumno;

public interface IAlumno {
	
	public ArrayList<Alumno> ListadoAlumnos() throws SQLException;
	public void AgregarAlumno(Alumno unNuevoAlumno) throws SQLException;
	public void ModificarAlumno(Alumno modificarAlumno) throws SQLException;
	public void EliminarAlumo(int eliminarAlumno) throws SQLException;
	public int NuevoLegajo();
	public int calcularNota(int parcial, int recuperatorio);
	public float calcularPromedio(int notaUno, int notaDos);
	public String EstadoAlumno(float promedio, String estado, int notauno, int notados);

}
