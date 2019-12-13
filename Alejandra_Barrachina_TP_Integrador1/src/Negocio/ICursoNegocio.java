package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Curso;

public interface ICursoNegocio {

	public ArrayList<Curso> CursosxProfesor(int IdProfesor) throws SQLException;
	public ArrayList<Curso> AlumnosxCurso(Curso CursoSeleccionado);
	public void CargarNotas(Curso cursoModificar, int notaUno, int notaDos, int notaTres, int notaCuatro, int Legajo, String Estado);
}
