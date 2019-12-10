package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Localidad;

public interface ILocalidades {
	
	public ArrayList<Localidad> ListadoLocalidadesSegunProvincia(int CodigoProvincia) throws SQLException;
	public ArrayList<Localidad> ListadoLocalidades() throws SQLException;
	
}
