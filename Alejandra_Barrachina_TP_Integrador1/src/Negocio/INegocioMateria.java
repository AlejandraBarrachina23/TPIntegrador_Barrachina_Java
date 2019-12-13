package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.MateriaDAO;
import Dominio.Materia;

public interface INegocioMateria {
	
	public ArrayList<Materia> ListadoMaterias() throws SQLException;


}
