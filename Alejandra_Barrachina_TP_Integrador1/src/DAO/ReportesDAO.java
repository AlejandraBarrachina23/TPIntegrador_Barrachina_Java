package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import Dominio.Alumno;
import Dominio.Curso;
import Dominio.Materia;
import Dominio.Profesor;
import Dominio.Reporte;

public class ReportesDAO {

	private ConexionDB nuevaConexion;
	private Calendar fecha = Calendar.getInstance();
	private int anio = fecha.get(Calendar.YEAR);
	
	public int CantidadAlumnosAnio(int anioSolicitado) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();

		int cantidad=0;
		try {  

			ResultSet TablaResultados= nuevaConexion.query("SELECT COUNT(*) AS total from alumnosxcurso WHERE anio=" + anioSolicitado);
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");
			}

		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
		
		return cantidad;
		
	}
	
	public int DiferenciaAlumnosxAnio(int anioSolicitado, int anioAnterior) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int diferencia=0;
		
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select (count(*) / (select count(*) from alumnosxcurso where anio= " + anioAnterior+ ")*100)-100 as diferencia from alumnosxcurso where anio="+anioSolicitado);
			while(TablaResultados.next()) {

				diferencia  = TablaResultados.getInt("diferencia");

			}

		}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			
			nuevaConexion.close();
		}
		
		return diferencia;
		
	}
	
	public int DiferenciaAlumnosRegularesxAnio(int anioSolicitado, int anioAnterior) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		
		int diferencia=0;
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select (count(*) / (select count(*) from alumnosxcurso where anio=" + anioAnterior + " and estado='Regular')*100)-100 as diferencia from alumnosxcurso where anio=" + anioSolicitado + " and estado='Regular'");
			while(TablaResultados.next()) {

				diferencia  = TablaResultados.getInt("diferencia");

			}

		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			
			nuevaConexion.close();
		}
		
		return diferencia;
		
	}
	
	public int DiferenciaAlumnosLibresxAnio(int anioSolicitado, int anioAnterior) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int diferencia=0;
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select (count(*) / (select count(*) from alumnosxcurso where anio=" + anioAnterior + " and estado='Libre')*100)-100 as diferencia from alumnosxcurso where anio=" + anioSolicitado + " and estado='Libre'");
			while(TablaResultados.next()) {
				diferencia  = TablaResultados.getInt("diferencia");
			}

		}

		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			
			nuevaConexion.close();
		}
		
		return diferencia;
		
	}
	
	
	public int CantidadAlumnosRegulares() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int cantidad=0;
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select count(*) as total from alumnosxcurso WHERE anio=" + anio +" and Estado='Regular'");
			
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");
			}
		}	
		catch (Exception e) {
				e.printStackTrace();
				System.out.print("No cargo "+ e);
		}
			
		finally {
				
				nuevaConexion.close();
		}
		return cantidad;
	}
	
	public int CantidadAlumnosLibres() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int cantidad=0;
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select count(*) as total from alumnosxcurso WHERE anio=" + anio +" and Estado='Libre'");
			while(TablaResultados.next()) {
				 cantidad = TablaResultados.getInt("total");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			
			nuevaConexion.close();
		}
		return cantidad;
	}
	
	public int CantidadProfesoresActivos() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int cantidad=0;
		try {  
			ResultSet TablaResultados= nuevaConexion.query("select count(*) as total from profesores where Estado=1");
			while(TablaResultados.next()) {
				 cantidad = TablaResultados.getInt("total");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			
			nuevaConexion.close();
		}

		return cantidad;
	}
	
	public ArrayList<Reporte> ComparativaAlumnosInscriptos(int AnioActual) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  
			
			ResultSet TablaResultados= nuevaConexion.query("select count(*) as cantidad, anio from alumnosxcurso group by Anio having Anio>="+ (AnioActual-4) + " order by anio asc limit 5");
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}

		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		
		return ListadoReportes;
	}
	
	public ArrayList<Reporte> MateriasMasInscripciones(int AnioActual) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select count(*) as cantidad, Materia.nombre from alumnosxcurso inner join Materia ON Materia.idMateria = alumnosxcurso.idMateria WHERE anio=" + AnioActual +" group by alumnosxcurso.idMateria");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setMateria(TablaResultados.getString("nombre"));
				ListadoReportes.add(unReporte);
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
	

		return ListadoReportes;
	}
	
	public ArrayList<Reporte> EstadosAlumnosxAnio(int AnioActual) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select count(*) as cantidad, anio from alumnosxcurso where estado='Regular' and anio>=" + (AnioActual-4) + " group by anio order by anio asc limit 5");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}

		}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		
		return ListadoReportes;
	}
	
	
	public ArrayList<Reporte> EstadosAlumnosxAnioLibres(int AnioActual) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  
		
			ResultSet TablaResultados= nuevaConexion.query("select count(*) as cantidad, anio from alumnosxcurso where estado='Libre' and anio>=" + (AnioActual-4) + " group by anio order by anio asc limit 5");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		
		return ListadoReportes;
	}
	
	public ArrayList<Reporte> ListadoMateriasMasEgresos(){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Reporte> ListadoReportes = new ArrayList<Reporte>();
		
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select count(*) as cantidad, anio from alumnosxcurso where estado='Libre' group by anio");
			
			while(TablaResultados.next()) {

				Reporte unReporte = new Reporte();
				unReporte.setCantidad(TablaResultados.getInt("cantidad"));
				unReporte.setAnios(TablaResultados.getInt("anio"));
				ListadoReportes.add(unReporte);
			}
		}
			catch (Exception e) {
				
				e.printStackTrace();
				System.out.print("No cargo "+ e);
			}
		
			finally {
			
				nuevaConexion.close();
			}
		return ListadoReportes;

	}
	
	public ArrayList<Curso> MateriasConMasEgresos(){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Curso> ListadoMateriasMasInscriptos = new ArrayList<Curso>();
		
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select alumnosxcurso.idMateria, materia.Nombre, alumnosxcurso.semestre, profesores.nombre, profesores.apellido,count(*) as cantidad from alumnosxcurso inner join materia on materia.idmateria=alumnosxcurso.idmateria inner join profesores on profesores.idprofesor = alumnosxcurso.idprofesor\r\n" + 
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
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		return ListadoMateriasMasInscriptos;
	}
	
public ArrayList<Curso> MateriasConMasAbandono(){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Curso> ListadoMateriasMasInscriptos = new ArrayList<Curso>();
		
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select alumnosxcurso.idMateria,materia.Nombre,semestre, profesores.nombre, profesores.apellido, count(*) as cantidad from alumnosxcurso inner join materia on materia.idmateria=alumnosxcurso.idmateria inner join profesores on profesores.idprofesor = alumnosxcurso.idprofesor\r\n" + 
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
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		return ListadoMateriasMasInscriptos;
	}

	public int NotasPrimerParcial(Curso CursoSeleccionado) {
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int cantidad = 0;
		try {  

			ResultSet TablaResultados= nuevaConexion.query("select count(*) as total from alumnosxcurso where idMateria=" + CursoSeleccionado.getMateria().getIdMateria()
					+" and semestre='"+CursoSeleccionado.getSemestre()+"' and anio=" + CursoSeleccionado.getAnio() + " and idProfesor=" + CursoSeleccionado.getProfesorTitular().getLegajo()+
					  " and NotaUno>6");
		
			while(TablaResultados.next()) {

				 cantidad = TablaResultados.getInt("total");		
			}

		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		return cantidad;
		
	}
	
public ArrayList<Alumno> EstadoAsistenciasxCurso(Curso CursoSeleccionado){
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Alumno> ListadoAsistencia = new ArrayList<Alumno>();
		
		try {  
			ResultSet TablaResultados= nuevaConexion.query("select alumnos.legajo, alumnos.nombre, alumnos.apellido, alumnosxcurso.estado from alumnosxcurso inner join alumnos on alumnos.legajo = alumnosxcurso.legajo where "
					+ "idMateria=" + CursoSeleccionado.getMateria().getIdMateria() +" and semestre='"+CursoSeleccionado.getSemestre()+"' and anio=" + CursoSeleccionado.getAnio() + " and idProfesor=" 
					+ CursoSeleccionado.getProfesorTitular().getLegajo());

			while(TablaResultados.next()) {
				
				Alumno unAlumno = new Alumno();
				unAlumno.setLegajo(TablaResultados.getInt("legajo"));
				unAlumno.setNombre(TablaResultados.getString("nombre"));
				unAlumno.setApellido(TablaResultados.getString("apellido"));
				unAlumno.setTelefono(TablaResultados.getString("estado"));
				ListadoAsistencia.add(unAlumno);
			}
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
	
		finally {
		
			nuevaConexion.close();
		}
		return ListadoAsistencia;
	}

public ArrayList<Alumno> EstadoAsistenciasxCursoGrafico() {
	
	nuevaConexion = new ConexionDB();
	nuevaConexion.Open();
	ArrayList<Alumno> ListadoAsistenciaCrusoGrafico = new ArrayList<Alumno>();
	
	try {  

		ResultSet TablaResultados= nuevaConexion.query("");

		while(TablaResultados.next()) {

			Alumno unAlumno = new Alumno();
			unAlumno.setLegajo(TablaResultados.getInt("cantidad"));
			unAlumno.setNombre(TablaResultados.getString("estado"));
		}
		
	}
	catch (Exception e) {
		
		e.printStackTrace();
		System.out.print("No cargo "+ e);
	}

	finally {
	
		nuevaConexion.close();
	}

	return ListadoAsistenciaCrusoGrafico;
	
}

public ArrayList<Reporte> MejoresPromedios(int anio) {
	
	nuevaConexion = new ConexionDB();
	nuevaConexion.Open();
	ArrayList<Reporte> ListadoMejoresPromedios = new ArrayList<Reporte>();
	
	try {  

		ResultSet TablaResultados= nuevaConexion.query("select alumnosxcurso.legajo,nombre,apellido,anio, avg(case "
				+ "when (NotaUno>=6 and NotaDos>=6) THEN (NotaUno+ NotaDos) / 2"
				+ " when (NotaUno<6 and NotaDos>6 and NotaUno!=0) THEN (RecuperatorioUno+NotaDos)/2"
				+ " when (NotaUno>=6 and NotaDos<6 and NotaDos!=0) THEN (NotaUno+RecuperatorioDos)/2"
				+ " when (RecuperatorioUno<6 and RecuperatorioDos<6 and RecuperatorioUno!=0 and RecuperatorioDos!=0) THEN (RecuperatorioUno+RecuperatorioDos)/2"
				+ " END)as Promedio"
				+ " from alumnosxcurso inner join Alumnos on alumnosxcurso.legajo = alumnos.legajo"
				+ " group by legajo having Promedio is not null and anio=" + anio +" order by Promedio desc limit 5");

		while(TablaResultados.next()) {
			
			Reporte unReporte = new Reporte();
			Alumno unAlumno = new Alumno();
			unAlumno.setLegajo(TablaResultados.getInt("legajo"));
			unAlumno.setNombre(TablaResultados.getString("nombre"));
			unAlumno.setApellido(TablaResultados.getString("apellido"));
			unReporte.setUnAlumno(unAlumno);
			unReporte.setPromedio(TablaResultados.getFloat("promedio"));
			ListadoMejoresPromedios.add(unReporte);			
		}

	}
	catch (Exception e) {
		
		e.printStackTrace();
		System.out.print("No cargo "+ e);
	}

	finally {
	
		nuevaConexion.close();
	}

	return ListadoMejoresPromedios;
	
}


public ArrayList<Reporte> PeoresPromedios(int anio) {
	
	nuevaConexion = new ConexionDB();
	nuevaConexion.Open();
	ArrayList<Reporte> ListadoMejoresPromedios = new ArrayList<Reporte>();
	
	try {  

		ResultSet TablaResultados= nuevaConexion.query("select alumnosxcurso.legajo,nombre,apellido,anio, avg(case "
				+ "when (NotaUno>=6 and NotaDos>=6) THEN (NotaUno+ NotaDos) / 2"
				+ " when (NotaUno<6 and NotaDos>6 and NotaUno!=0) THEN (RecuperatorioUno+NotaDos)/2"
				+ " when (NotaUno>=6 and NotaDos<6 and NotaDos!=0) THEN (NotaUno+RecuperatorioDos)/2"
				+ " when (RecuperatorioUno<6 and RecuperatorioDos<6 and RecuperatorioUno!=0 and RecuperatorioDos!=0) THEN (RecuperatorioUno+RecuperatorioDos)/2"
				+ " END)as Promedio"
				+ " from alumnosxcurso inner join Alumnos on alumnosxcurso.legajo = alumnos.legajo"
				+ " group by legajo having Promedio is not null and anio=" + anio +" order by Promedio asc limit 5");

		while(TablaResultados.next()) {
			
			Reporte unReporte = new Reporte();
			Alumno unAlumno = new Alumno();
			unAlumno.setLegajo(TablaResultados.getInt("legajo"));
			unAlumno.setNombre(TablaResultados.getString("nombre"));
			unAlumno.setApellido(TablaResultados.getString("apellido"));
			unReporte.setUnAlumno(unAlumno);
			unReporte.setPromedio(TablaResultados.getFloat("promedio"));
			ListadoMejoresPromedios.add(unReporte);			
		}
		

	}
	
	catch (Exception e) {
		
		e.printStackTrace();
		System.out.print("No cargo "+ e);
	}

	finally {
	
		nuevaConexion.close();
	}
	return ListadoMejoresPromedios;
	
}

}
