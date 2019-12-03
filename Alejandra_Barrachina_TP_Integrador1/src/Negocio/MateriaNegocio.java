package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.MateriaDAO;
import Dominio.Materia;

public class MateriaNegocio implements INegocioMateria {

	private MateriaDAO unaMateriaDAO = new MateriaDAO();
	
	public ArrayList<Materia> ListadoMaterias() throws SQLException{
		
		return unaMateriaDAO.ListadoMateria();
		
	}
	
}
