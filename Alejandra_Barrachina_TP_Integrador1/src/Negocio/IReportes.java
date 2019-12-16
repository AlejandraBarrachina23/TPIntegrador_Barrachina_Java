package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Reporte;

public interface IReportes {

	public int CantidadAlumnosAnio(int anio) throws SQLException;
	public int DiferenciaAlumnosxAnio(int anioSolicitado, int anioAnterior) throws SQLException;
	public int CantidadAlumnosRegulares() throws SQLException;
	public int DiferenciaAlumnosRegularesxAnio(int anioSolicitado, int anioAnterior) throws SQLException;
	public int CantidadAlumnosLibres() throws SQLException;
	public int DiferenciaAlumnosLibresxAnio(int anioSolicitado, int anioAnterior) throws SQLException;
	public int CantidadProfesoresActivos() throws SQLException;
	public ArrayList<Reporte> ComparativaAlumnosInscriptos(int AnioActual) throws SQLException;
	public ArrayList<Reporte> MateriasMasInscripciones(int AnioActual) throws SQLException;
	public ArrayList<Reporte> EstadosAlumnosxAnio(int AnioActual) throws SQLException;
	public ArrayList<Reporte> EstadosAlumnosxAnioLibres(int AnioActual) throws SQLException;
	public ArrayList<Curso> MateriasConMasEgresos();
	public ArrayList<Curso> MateriasConMasAbandono();
	public int NotasPrimerParcial(Curso CursoSeleccionado);
	public ArrayList<Alumno> EstadoAsistenciasxCurso(Curso CursoSeleccionado);
	public ArrayList<Reporte> MejoresPromedios(int anio);
	public ArrayList<Reporte> PeoresPromedios(int anio);

}
