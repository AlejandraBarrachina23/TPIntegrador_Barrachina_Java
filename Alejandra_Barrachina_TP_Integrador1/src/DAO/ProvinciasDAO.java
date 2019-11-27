package DAO;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dominio.Provincia;

public class ProvinciasDAO {
	
	private ConexionDB nuevaConexion;
	
	public ArrayList<Provincia> ListadoProvincias() throws SQLException{
		
		ArrayList<Provincia> ListadoProvincias = new ArrayList<Provincia>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT * FROM Provincias");
			
			while(TablaResultados.next()) {
				Provincia unaProvincia = new Provincia();
				unaProvincia.setIdProvincia(TablaResultados.getInt("idProvincia"));
				unaProvincia.setNombre(TablaResultados.getString("Nombre"));
				ListadoProvincias.add(unaProvincia);		
			}
	
		}
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoProvincias;
	}

}
