package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ReportesDAO;
import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Reporte;

public class ReportesNegocio implements IReportes{

	ReportesDAO unReporteDAO = new ReportesDAO();
	
	public int CantidadAlumnosAnio(int anio) throws SQLException {
		return unReporteDAO.CantidadAlumnosAnio(anio);
	}

	public int CantidadAlumnosRegulares() throws SQLException {
		
		return unReporteDAO.CantidadAlumnosRegulares();
	}

	public int CantidadAlumnosLibres() throws SQLException {
		
		return unReporteDAO.CantidadAlumnosLibres();
	}

	public int CantidadProfesoresActivos() throws SQLException {
		
		return unReporteDAO.CantidadProfesoresActivos();
	}

	public ArrayList<Reporte> ComparativaAlumnosInscriptos(int AnioActual) throws SQLException {
		
		return unReporteDAO.ComparativaAlumnosInscriptos(AnioActual);
	}
	
	public ArrayList<Reporte> MateriasMasInscripciones(int AnioActual) throws SQLException {
	
		return unReporteDAO.MateriasMasInscripciones(AnioActual);
	}

	public ArrayList<Reporte> EstadosAlumnosxAnio(int AnioActual) throws SQLException{
		
		return unReporteDAO.EstadosAlumnosxAnio(AnioActual);
	}

	public ArrayList<Reporte> EstadosAlumnosxAnioLibres(int AnioActual) throws SQLException {
		
		return unReporteDAO.EstadosAlumnosxAnioLibres(AnioActual);
	}

	public ArrayList<Curso> MateriasConMasEgresos() {
		
		return unReporteDAO.MateriasConMasEgresos();
	}

	public ArrayList<Curso> MateriasConMasAbandono() {
		
		return unReporteDAO.MateriasConMasAbandono();
	}

	public int NotasPrimerParcial(Curso CursoSeleccionado) {
		
		return unReporteDAO.NotasPrimerParcial(CursoSeleccionado);
	}

	public ArrayList<Alumno> EstadoAsistenciasxCurso(Curso CursoSeleccionado) {
		
		return unReporteDAO.EstadoAsistenciasxCurso(CursoSeleccionado);
	}

	public int[] EstadoAsistenciasxCursoGrafico() {
		
		unReporteDAO.EstadoAsistenciasxCursoGrafico();
		
		
		return null;
	}

	public ArrayList<Reporte> MejoresPromedios(int anio) {
		
		return unReporteDAO.MejoresPromedios(anio);
	}

	public ArrayList<Reporte> PeoresPromedios(int anio) {
		
		return unReporteDAO.PeoresPromedios(anio);
	}

	public int DiferenciaAlumnosxAnio(int anioSolicitado, int anioAnterior) throws SQLException {
		
		return unReporteDAO.DiferenciaAlumnosxAnio(anioSolicitado, anioAnterior);
	}

	public int DiferenciaAlumnosRegularesxAnio(int anioSolicitado, int anioAnterior) throws SQLException {
	
		return unReporteDAO.DiferenciaAlumnosRegularesxAnio(anioSolicitado, anioAnterior);
	}

	public int DiferenciaAlumnosLibresxAnio(int anioSolicitado, int anioAnterior) throws SQLException {
		
		return unReporteDAO.DiferenciaAlumnosLibresxAnio(anioSolicitado, anioAnterior);
	}


}
