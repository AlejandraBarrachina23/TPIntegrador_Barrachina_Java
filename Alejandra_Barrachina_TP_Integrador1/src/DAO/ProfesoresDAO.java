package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.CallableStatement;
import Dominio.Profesor;
import Dominio.Localidad;
import Dominio.Provincia;

public class ProfesoresDAO {

	private ConexionDB nuevaConexion;
	
	public ArrayList<Profesor> ListadoProfesores() throws SQLException{
		
		ArrayList<Profesor> ListadoProfesores = new ArrayList<Profesor>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		
		try {  
			
			ResultSet TablaResultados= nuevaConexion.query("SELECT * FROM Profesores INNER JOIN Localidades ON Profesores.IdLocalidad = Localidades.IdLocalidad INNER JOIN Provincias ON Provincias.IdProvincia = Profesores.IdProvincia");
			
			while(TablaResultados.next()) {
				
				Profesor unProfesor = new Profesor();
				Localidad unaLocalidad = new Localidad();
				Provincia unaProvincia = new Provincia();
				
				if(TablaResultados.getInt("Estado")==1) 
				{
					
					unProfesor.setLegajo(TablaResultados.getInt("IdProfesor"));
					unProfesor.setNombre(TablaResultados.getString("Nombre"));
					unProfesor.setApellido(TablaResultados.getString("Apellido"));
					unProfesor.setFechaNacimiento(TablaResultados.getString("FechaNacimiento"));
					unProfesor.setDireccion(TablaResultados.getString("Direccion"));
					unProfesor.setEmail(TablaResultados.getString("Email"));
					unProfesor.setTelefono(TablaResultados.getString("Telefono"));
					
					unaProvincia.setIdProvincia(TablaResultados.getInt("idProvincia"));
					unaProvincia.setNombre(TablaResultados.getString("Provincias.Nombre"));
					
					unaLocalidad.setIdLocalidad(TablaResultados.getInt("Localidades.idLocalidad"));
					unaLocalidad.setNombre(TablaResultados.getString("Localidades.Nombre"));
					unaLocalidad.setProvincia(unaProvincia);
					
					unProfesor.setLocalidad(unaLocalidad);
					
					ListadoProfesores.add(unProfesor);
					
				}
	
			}
	
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
		
		return ListadoProfesores;
	}
	
	public void AgregarProfesor(Profesor unNuevoProfesor) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {

			 CallableStatement SP_AgregarProfesor = (CallableStatement) nuevaConexion.Open().prepareCall("CALL AgregarProfesor(?,?,?,?,?,?,?,?)");
			 SP_AgregarProfesor.setString(1,unNuevoProfesor.getNombre());
			 SP_AgregarProfesor.setString(2,unNuevoProfesor.getApellido());
			 SP_AgregarProfesor.setString(3,unNuevoProfesor.getFechaNacimiento());
			 SP_AgregarProfesor.setString(4,unNuevoProfesor.getDireccion());
			 SP_AgregarProfesor.setInt(5,unNuevoProfesor.getProvincia().getIdProvincia());
			 SP_AgregarProfesor.setInt(6,unNuevoProfesor.getLocalidad().getIdLocalidad());
			 SP_AgregarProfesor.setString(7,unNuevoProfesor.getEmail());
			 SP_AgregarProfesor.setString(8,unNuevoProfesor.getTelefono());
			 SP_AgregarProfesor.execute();
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
	
	public void ModificarProfesor(Profesor modificarProfesor) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {
						 
			 CallableStatement SP_ModificarProfesor = (CallableStatement) nuevaConexion.Open().prepareCall("CALL ModificarProfesor(?,?,?,?,?,?,?,?,?)");
			
			 SP_ModificarProfesor.setInt(1,modificarProfesor.getLegajo());
			 SP_ModificarProfesor.setString(2,modificarProfesor.getNombre());
			 SP_ModificarProfesor.setString(3,modificarProfesor.getApellido());
			 SP_ModificarProfesor.setString(4,modificarProfesor.getFechaNacimiento());
			 SP_ModificarProfesor.setString(5,modificarProfesor.getDireccion());
			 SP_ModificarProfesor.setInt(6,modificarProfesor.getProvincia().getIdProvincia());
			 SP_ModificarProfesor.setInt(7,modificarProfesor.getLocalidad().getIdLocalidad());
			 SP_ModificarProfesor.setString(8,modificarProfesor.getEmail());
			 SP_ModificarProfesor.setString(9,modificarProfesor.getTelefono());
			 SP_ModificarProfesor.execute();
	
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
	
	public void EliminarProfesor(int eliminarProfesor) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {
			 
			 CallableStatement SP_EliminarProfesor = (CallableStatement) nuevaConexion.Open().prepareCall("CALL EliminarProfesor(?)");
			 SP_EliminarProfesor.setInt(1,eliminarProfesor);
			 SP_EliminarProfesor.execute();
	
		} 
		
	catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
	
	public int NuevoLegajo() {
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		int Legajo=0;
		
		try {
			

			ResultSet TablaResultados= nuevaConexion.query("select idProfesor from profesores as legajo order by idProfesor desc limit 1");
					
			while(TablaResultados.next()) {
				
					Legajo=TablaResultados.getInt("idProfesor");
			}

		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
			
		return Legajo+1;

	}
	
}
