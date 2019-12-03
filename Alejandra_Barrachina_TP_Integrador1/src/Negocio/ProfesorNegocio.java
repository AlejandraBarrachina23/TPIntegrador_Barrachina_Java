package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ProfesoresDAO;
import Dominio.Profesor;

public class ProfesorNegocio {

	private ProfesoresDAO unProfesorDAO = new ProfesoresDAO();
	
	public ArrayList<Profesor> ListadoProfesores() throws SQLException{
		
		return unProfesorDAO.ListadoProfesores();
		
	}
}