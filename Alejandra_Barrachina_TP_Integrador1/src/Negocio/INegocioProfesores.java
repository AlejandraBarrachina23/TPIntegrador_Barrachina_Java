package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Materia;

public interface INegocioProfesores {

	public ArrayList<Materia> ListadoMaterias() throws SQLException;
}
