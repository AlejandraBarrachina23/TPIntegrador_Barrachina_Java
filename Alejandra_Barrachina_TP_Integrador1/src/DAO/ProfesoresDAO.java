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
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT * FROM Profesores INNER JOIN Localidades ON Profesores.IdLocalidad = Localidades.IdLocalidad INNER JOIN Provincias ON Provincias.IdProvincia = Profesores.IdProvincia");
			
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
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoProfesores;
	}
	
	/*
	public void AgregarAlumno(Alumno unNuevoAlumno) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {

			 CallableStatement SP_AgregarAlumno = (CallableStatement) nuevaConexion.EstablecerConexion().prepareCall("CALL AgregarAlumno(?,?,?,?,?,?,?,?)");
			 SP_AgregarAlumno.setString(1,unNuevoAlumno.getNombre());
			 SP_AgregarAlumno.setString(2,unNuevoAlumno.getApellido());
			 SP_AgregarAlumno.setString(3,unNuevoAlumno.getFechaNacimiento());
			 SP_AgregarAlumno.setString(4,unNuevoAlumno.getDireccion());
			 SP_AgregarAlumno.setInt(5,unNuevoAlumno.getProvincia().getIdProvincia());
			 SP_AgregarAlumno.setInt(6,unNuevoAlumno.getLocalidad().getIdLocalidad());
			 SP_AgregarAlumno.setString(7,unNuevoAlumno.getEmail());
			 SP_AgregarAlumno.setString(8,unNuevoAlumno.getTelefono());
			 SP_AgregarAlumno.execute();
			
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al cargar "+ e);
		}
	}
	
	public void ModificarAlumno(Alumno modificarAlumno) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {
			
			 System.out.println(modificarAlumno.getLegajo());
			 
			 CallableStatement SP_ModificarAlumno = (CallableStatement) nuevaConexion.EstablecerConexion().prepareCall("CALL ModificarAlumno(?,?,?,?,?,?,?,?,?)");
			
			 SP_ModificarAlumno.setInt(1,modificarAlumno.getLegajo());
			 SP_ModificarAlumno.setString(2,modificarAlumno.getNombre());
			 SP_ModificarAlumno.setString(3,modificarAlumno.getApellido());
			 SP_ModificarAlumno.setString(4,modificarAlumno.getFechaNacimiento());
			 SP_ModificarAlumno.setString(5,modificarAlumno.getDireccion());
			 SP_ModificarAlumno.setInt(6,modificarAlumno.getProvincia().getIdProvincia());
			 SP_ModificarAlumno.setInt(7,modificarAlumno.getLocalidad().getIdLocalidad());
			 SP_ModificarAlumno.setString(8,modificarAlumno.getEmail());
			 SP_ModificarAlumno.setString(9,modificarAlumno.getTelefono());
			 SP_ModificarAlumno.execute();
	
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al modificar "+ e);
		}
	}
	
	public void EliminarAlumo(int eliminarAlumno) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {
			
			 System.out.println(eliminarAlumno);
			 
			 CallableStatement SP_EliminarAlumno = (CallableStatement) nuevaConexion.EstablecerConexion().prepareCall("CALL EliminarAlumno(?)");
			 SP_EliminarAlumno.setInt(1,eliminarAlumno);
			 SP_EliminarAlumno.execute();
	
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al borrar "+ e);
		}
	}
	
	*/
}
