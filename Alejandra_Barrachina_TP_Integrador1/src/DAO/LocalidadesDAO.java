package DAO;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dominio.Localidad;
import Dominio.Provincia;

public class LocalidadesDAO {
	
	private ConexionDB nuevaConexion;
	
	public ArrayList<Localidad> ListadoLocalidadesSegunProvincia(int CodigoProvincia) throws SQLException{
		
		ArrayList<Localidad> ListadoLocalidades = new ArrayList<Localidad>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT * FROM Localidades WHERE IdProvincia = " + CodigoProvincia);
			
			while(TablaResultados.next()) {
				Localidad unaLocalidad = new Localidad();
				unaLocalidad.setIdLocalidad(TablaResultados.getInt("idLocalidad"));
				unaLocalidad.setNombre(TablaResultados.getString("Nombre"));
				ListadoLocalidades.add(unaLocalidad);		
			}
	
		}
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoLocalidades;
	}
	
	
	public ArrayList<Localidad> ListadoLocalidades() throws SQLException{
		
		ArrayList<Localidad> ListadoLocalidades = new ArrayList<Localidad>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT * FROM Localidades");
			
			while(TablaResultados.next()) {
				Localidad unaLocalidad = new Localidad();
				Provincia unaProvincia = new Provincia();
				unaLocalidad.setIdLocalidad(TablaResultados.getInt("idLocalidad"));
				unaLocalidad.setNombre(TablaResultados.getString("Nombre"));
				unaProvincia.setIdProvincia(TablaResultados.getInt("idProvincia"));
				unaLocalidad.setProvincia(unaProvincia);
				ListadoLocalidades.add(unaLocalidad);		
			}
	
		}
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoLocalidades;
	}
	
	

}
