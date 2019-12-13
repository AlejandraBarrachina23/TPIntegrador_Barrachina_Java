package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Curso;
import Dominio.Reporte;

public interface IReportes {

	public int CantidadAlumnosAnio() throws SQLException;
	public int CantidadAlumnosRegulares() throws SQLException;
	public int CantidadAlumnosLibres() throws SQLException;
	public int CantidadProfesoresActivos() throws SQLException;
	public ArrayList<Reporte> ComparativaAlumnosInscriptos() throws SQLException;
	public ArrayList<Reporte> MateriasMasInscripciones() throws SQLException;
	public ArrayList<Reporte> EstadosAlumnosxAnio() throws SQLException;
	public ArrayList<Reporte> EstadosAlumnosxAnioLibres() throws SQLException;
	public ArrayList<Curso> MateriasConMasInscriptos();
	public ArrayList<Curso> MateriasConMasAbandono();
	public int NotasPrimerParcial(Curso CursoSeleccionado);
}
