package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.LocalidadesDAO;
import Dominio.Localidad;

public class LocalidadesNegocio implements ILocalidades {
	
	private LocalidadesDAO unaLocalidad = new LocalidadesDAO();
	
	public ArrayList<Localidad> ListadoLocalidadesSegunProvincia(int CodigoProvincia) throws SQLException {
		return unaLocalidad.ListadoLocalidadesSegunProvincia(CodigoProvincia);
	}

	public ArrayList<Localidad> ListadoLocalidades() throws SQLException {
		return unaLocalidad.ListadoLocalidades();
	}

}
