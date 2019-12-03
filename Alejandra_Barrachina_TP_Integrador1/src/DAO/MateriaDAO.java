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
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT * FROM Materia;");
			
			while(TablaResultados.next()) {
				
				Materia unaMateria = new Materia();
				
				
					
					unaMateria.setIdMateria(TablaResultados.getInt("IdMateria"));
					unaMateria.setNombre(TablaResultados.getString("Nombre"));
					ListadoMaterias.add(unaMateria);
						
			}
		}
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoMaterias;
	}
	
	
}
