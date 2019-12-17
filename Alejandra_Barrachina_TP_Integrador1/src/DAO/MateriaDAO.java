package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dominio.Materia;

public class MateriaDAO {

	private ConexionDB nuevaConexion;
	
	public ArrayList<Materia> ListadoMateria() throws SQLException{
		
		ArrayList<Materia> ListadoMaterias = new ArrayList<Materia>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		
		try {  
			
			ResultSet TablaResultados= nuevaConexion.query("SELECT * FROM Materia;");
			
			while(TablaResultados.next()) {
				
				Materia unaMateria = new Materia();
				unaMateria.setIdMateria(TablaResultados.getInt("IdMateria"));
				unaMateria.setNombre(TablaResultados.getString("Nombre"));
				ListadoMaterias.add(unaMateria);
			
			}
		}
	catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
		
		return ListadoMaterias;
	}
	
	
}
