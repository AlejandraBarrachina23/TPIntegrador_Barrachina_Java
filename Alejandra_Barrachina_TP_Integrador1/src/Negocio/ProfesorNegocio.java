package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ProfesoresDAO;
import Dominio.Profesor;

public class ProfesorNegocio implements INegocioProfesores {

	private ProfesoresDAO unProfesorDAO = new ProfesoresDAO();
	
	
	public ArrayList<Profesor> ListadoProfesores() throws SQLException{
		
		return unProfesorDAO.ListadoProfesores();
		
	}

	public void AgregarProfesor(Profesor unNuevoProfesor) throws SQLException {
		
		unProfesorDAO.AgregarProfesor(unNuevoProfesor);
		
	}

	public void ModificarProfesor(Profesor modificarProfesor) throws SQLException {
	
		unProfesorDAO.ModificarProfesor(modificarProfesor);
	}

	public void EliminarProfesor(int eliminarProfesor) throws SQLException {
		
		unProfesorDAO.EliminarProfesor(eliminarProfesor);
		
	}

	public int NuevoLegajo() {
		
		return unProfesorDAO.NuevoLegajo();
	}
}
