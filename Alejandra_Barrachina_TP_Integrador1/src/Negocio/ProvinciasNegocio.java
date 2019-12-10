package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.MateriaDAO;
import DAO.ProvinciasDAO;
import Dominio.Materia;
import Dominio.Provincia;

public class ProvinciasNegocio implements IProvinciasNegocio {

	private ProvinciasDAO unaProvinciaDAO = new ProvinciasDAO();

	public ArrayList<Provincia> ListadoProvincias() throws SQLException {
		
		return unaProvinciaDAO.ListadoProvincias();
	}

}
