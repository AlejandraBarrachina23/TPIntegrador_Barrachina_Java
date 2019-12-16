package DAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.CallableStatement;
import Dominio.Alumno;
import Dominio.Calificaciones;
import Dominio.Curso;
import Dominio.Materia;


public class CursoDAO {

	private ConexionDB nuevaConexion;
	
	public void AgregarCuros(Curso unNuevoCurso, int LegajoAlumno) {
		
	nuevaConexion = new ConexionDB();
		
		try {
			
			 CallableStatement SP_AgregarCurso = (CallableStatement) nuevaConexion.EstablecerConexion().prepareCall("CALL AgregarCurso(?,?,?,?,?)");
			 SP_AgregarCurso.setInt(1,unNuevoCurso.getMateria().getIdMateria());
			 SP_AgregarCurso.setString(2,unNuevoCurso.getSemestre());
			 SP_AgregarCurso.setInt(3,unNuevoCurso.getAnio());
			 SP_AgregarCurso.setInt(4,unNuevoCurso.getProfesorTitular().getLegajo());
			 SP_AgregarCurso.setInt(5,LegajoAlumno);
			 SP_AgregarCurso.execute();
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al cargar "+ e);
		}		
	}
	
	public ArrayList<Curso> CursosxProfesor(int IdProfesor) {
		
		ArrayList<Curso> ListadoCursos = new ArrayList<Curso>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT DISTINCT materia.IdMateria,materia.nombre, alumnosxcurso.semestre, alumnosxcurso.anio FROM alumnosxcurso INNER JOIN materia ON alumnosxcurso.idMateria = materia.idMateria\r\n" + 
					"WHERE IdProfesor = " + IdProfesor);
			
			while(TablaResultados.next()) {
				
				Curso unCurso = new Curso();
				Materia unaMateria = new Materia();
				unaMateria.setIdMateria(TablaResultados.getInt("IdMateria"));
				unaMateria.setNombre(TablaResultados.getString("nombre"));
				unCurso.setAnio(TablaResultados.getInt("anio"));
				unCurso.setSemestre(TablaResultados.getString("semestre"));
				unCurso.setMateria(unaMateria);
				ListadoCursos.add(unCurso);		
			}
	
		}
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoCursos;
	}
	
public ArrayList<Curso> AlumnosxCurso(Curso CursoSeleccionado) {
		
		ArrayList<Curso> ListadoAlumnosxCurso = new ArrayList<Curso>();
		ArrayList<Alumno> ListadoAlumnos = new ArrayList<Alumno>();
		ArrayList<Calificaciones> ListadoNotas = new ArrayList<Calificaciones>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT Alumnos.Legajo,Alumnos.Nombre, Alumnos.Apellido,NotaUno,NotaDos,RecuperatorioUno,RecuperatorioDos,alumnosxcurso.Estado FROM alumnosxcurso INNER JOIN "
					+ "Alumnos ON Alumnos.Legajo = alumnosxcurso.legajo WHERE idMateria="+ CursoSeleccionado.getMateria().getIdMateria() + " AND Semestre= '"+ CursoSeleccionado.getSemestre()
					+ "' AND Anio = " + CursoSeleccionado.getAnio() + " AND Idprofesor =" + CursoSeleccionado.getProfesorTitular().getLegajo());
		
			while(TablaResultados.next()) {
				
				Alumno unAlumno = new Alumno();
				Calificaciones notas = new Calificaciones();
				
				unAlumno.setLegajo(TablaResultados.getInt("alumnos.legajo"));
				unAlumno.setNombre(TablaResultados.getString("alumnos.nombre"));
				unAlumno.setApellido(TablaResultados.getString("alumnos.apellido"));
				notas.setParcialUno(TablaResultados.getInt("NotaUno"));
				notas.setParcialDos(TablaResultados.getInt("NotaDos"));
				notas.setRecuperatorioUno(TablaResultados.getInt("RecuperatorioUno"));
				notas.setRecuperatorioDos(TablaResultados.getInt("RecuperatorioDos"));				
				notas.setEstado(TablaResultados.getString("alumnosxcurso.Estado"));
				notas.setLegajoAlumno(TablaResultados.getInt("alumnos.legajo"));
				ListadoAlumnos.add(unAlumno);
				ListadoNotas.add(notas);
				
			}
			
			Curso unCurso = new Curso();
			unCurso.setListadoAlumnos(ListadoAlumnos);
			unCurso.setListadoNotas(ListadoNotas);
			ListadoAlumnosxCurso.add(unCurso);	
			
		}
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoAlumnosxCurso;
	}
	
	public void CargarNotas(Curso cursoModificar, int notaUno, int notaDos, int notaTres, int notaCuatro, int Legajo, String Estado) {
		
		nuevaConexion = new ConexionDB();
		
		try {

			 CallableStatement SP_ModificarNotas = (CallableStatement) nuevaConexion.EstablecerConexion().prepareCall("CALL ModificarNotas(?,?,?,?,?,?,?,?,?,?)");
			 SP_ModificarNotas.setInt(1,cursoModificar.getMateria().getIdMateria());
			 SP_ModificarNotas.setString(2,cursoModificar.getSemestre());
			 SP_ModificarNotas.setInt(3,cursoModificar.getAnio());
			 SP_ModificarNotas.setInt(4,cursoModificar.getProfesorTitular().getLegajo());
			 SP_ModificarNotas.setInt(5,Legajo);
			 SP_ModificarNotas.setInt(6,notaUno);
			 SP_ModificarNotas.setInt(7,notaDos);
			 SP_ModificarNotas.setInt(8,notaTres);
			 SP_ModificarNotas.setInt(9,notaCuatro);
			 SP_ModificarNotas.setString(10,Estado);
			 SP_ModificarNotas.execute(); 
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al modificar "+ e);
		}
		
	}
	
}
