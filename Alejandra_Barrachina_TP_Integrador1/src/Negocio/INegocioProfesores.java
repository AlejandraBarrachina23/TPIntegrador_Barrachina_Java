package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Profesor;

public interface INegocioProfesores {

	public ArrayList<Profesor> ListadoProfesores() throws SQLException;
	public void AgregarProfesor(Profesor unNuevoProfesor) throws SQLException;
	public void ModificarProfesor(Profesor modificarProfesor) throws SQLException;
	public void EliminarProfesor(int eliminarProfesor) throws SQLException;
	public int NuevoLegajo();
	
}
