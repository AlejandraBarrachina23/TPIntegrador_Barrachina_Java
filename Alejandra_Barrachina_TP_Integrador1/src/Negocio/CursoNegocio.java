package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.CursoDAO;
import Dominio.Curso;

public class CursoNegocio implements ICursoNegocio {
	
private CursoDAO unCursoDAO = new CursoDAO();

	public ArrayList<Curso> CursosxProfesor(int IdProfesor) throws SQLException {
		
		return unCursoDAO.CursosxProfesor(IdProfesor);
	}
	
	public ArrayList<Curso> AlumnosxCurso(Curso CursoSeleccionado) {
		
		return unCursoDAO.AlumnosxCurso(CursoSeleccionado);
	}

	public void CargarNotas(Curso cursoModificar, int notaUno, int notaDos, int notaTres, int notaCuatro, int Legajo,
			String Estado) {
		
		unCursoDAO.CargarNotas(cursoModificar, notaUno, notaDos, notaTres, notaCuatro, Legajo, Estado);

	}

}
