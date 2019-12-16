package Negocio;
import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Provincia;

public interface IProvinciasNegocio {

	public ArrayList<Provincia> ListadoProvincias() throws SQLException;
}
