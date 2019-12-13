package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Localidad;
import Dominio.Materia;
import Dominio.Profesor;
import Dominio.Provincia;
import Dominio.Reporte;

public class ReportesDAO {

	private ConexionDB nuevaConexion;
	
	public int CantidadAlumnosAnio() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		int cantidad=0;
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT COUNT(*) AS total from alumnosxcurso WHERE anio=2019;");
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");

			}
			
			TablaResultados.close();

		}
		catch (Exception e) {
			
			System.out.print("No consulto "+ e);
		}
		
		nuevaConexion.close();
		return cantidad;
		
	}
	
	public int CantidadAlumnosRegulares() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		int cantidad=0;
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as total from alumnosxcurso where anio=2019 and Estado='Regular'");
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");
	
			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return cantidad;
	}
	
	public int CantidadAlumnosLibres() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		int cantidad=0;
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as total from alumnosxcurso where anio=2019 and Estado='Libre'");
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");

			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return cantidad;
	}
	
	public int CantidadProfesoresActivos() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		int cantidad=0;
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as total from profesores where Estado=1");
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");

			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return cantidad;
	}
	
	public ArrayList<Reporte> ComparativaAlumnosInscriptos() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as cantidad, anio from alumnosxcurso group by Anio;");
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoReportes;
	}
	
	public ArrayList<Reporte> MateriasMasInscripciones() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as cantidad, Materia.nombre from alumnosxcurso inner join Materia ON Materia.idMateria = alumnosxcurso.idMateria where anio=2019 group by alumnosxcurso.idMateria");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setMateria(TablaResultados.getString("nombre"));
				ListadoReportes.add(unReporte);
			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoReportes;
	}
	
	public ArrayList<Reporte> EstadosAlumnosxAnio() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as cantidad, anio from alumnosxcurso where estado='regular' group by anio");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoReportes;
	}
	
	
	public ArrayList<Reporte> EstadosAlumnosxAnioLibres() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as cantidad, anio from alumnosxcurso where estado='Libre' group by anio");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoReportes;
	}
	
	public ArrayList<Reporte> ListadoMateriasMasEgresos(){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as cantidad, anio from alumnosxcurso where estado='Libre' group by anio");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoReportes;

	}
	
	public ArrayList<Curso> MateriasConMasInscriptos(){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Curso> ListadoMateriasMasInscriptos = new ArrayList<Curso>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select alumnosxcurso.idMateria, materia.Nombre, alumnosxcurso.semestre, profesores.nombre, profesores.apellido,count(*) as cantidad from alumnosxcurso inner join materia on materia.idmateria=alumnosxcurso.idmateria inner join profesores on profesores.idprofesor = alumnosxcurso.idprofesor\r\n" + 
					"where ((notaUno>=6 or RecuperatorioUno>=6) and (notaDos>=6 or RecuperatorioDos >=6)) and (alumnosxcurso.estado='regular') group by materia.nombre order by cantidad desc;");
			
			while(TablaResultados.next()) {

				Curso unCurso = new Curso();
				Materia unaMateria = new Materia();
				Profesor unProfesor = new Profesor();
				unaMateria.setIdMateria(TablaResultados.getInt("idMateria"));
				unaMateria.setNombre(TablaResultados.getString("nombre"));
				unCurso.setMateria(unaMateria);
				unCurso.setSemestre(TablaResultados.getString("semestre"));
				unProfesor.setNombre(TablaResultados.getString("profesores.nombre"));
				unProfesor.setApellido(TablaResultados.getString("apellido"));
				unCurso.setProfesorTitular(unProfesor);
				unCurso.setAnio(TablaResultados.getInt("cantidad"));
				ListadoMateriasMasInscriptos.add(unCurso);
			}
			
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoMateriasMasInscriptos;
	}
	
public ArrayList<Curso> MateriasConMasAbandono(){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		ArrayList<Curso> ListadoMateriasMasInscriptos = new ArrayList<Curso>();
		
		try {  

			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select alumnosxcurso.idMateria,materia.Nombre,semestre, profesores.nombre, profesores.apellido, count(*) as cantidad from alumnosxcurso inner join materia on materia.idmateria=alumnosxcurso.idmateria inner join profesores on profesores.idprofesor = alumnosxcurso.idprofesor\r\n" + 
					"where ((notaUno<6 and RecuperatorioUno<6) or (notaDos<6 and RecuperatorioDos<6)) and (notaUno!=0 and notaDos!=0) group by materia.nombre order by cantidad desc;");
			
			while(TablaResultados.next()) {

				Curso unCurso = new Curso();
				Materia unaMateria = new Materia();
				Profesor unProfesor = new Profesor();
				unaMateria.setIdMateria(TablaResultados.getInt("idMateria"));
				unaMateria.setNombre(TablaResultados.getString("nombre"));
				unCurso.setMateria(unaMateria);
				unCurso.setSemestre(TablaResultados.getString("semestre"));
				unProfesor.setNombre(TablaResultados.getString("profesores.nombre"));
				unProfesor.setApellido(TablaResultados.getString("apellido"));
				unCurso.setProfesorTitular(unProfesor);
				unCurso.setAnio(TablaResultados.getInt("cantidad"));
				ListadoMateriasMasInscriptos.add(unCurso);
			}
			
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return ListadoMateriasMasInscriptos;
	}

	public int NotasPrimerParcial(Curso CursoSeleccionado) {
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		int cantidad = 0;
		try {  

			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("select count(*) as total from alumnosxcurso where idMateria=" + CursoSeleccionado.getMateria().getIdMateria()
					+" and semestre='"+CursoSeleccionado.getSemestre()+"'and anio=" + CursoSeleccionado.getAnio() + "and idProfesor=" + CursoSeleccionado.getProfesorTitular().getLegajo()+
					  "and NotaUno>6");
		
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");
				
			}
			
			TablaResultados.close();
		}
		catch (Exception e) {
			System.out.print("No consulto "+ e);
		}
		nuevaConexion.close();
		return cantidad;
		
	}

}
