package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import Dominio.Alumno;
import Dominio.Localidad;
import Dominio.Provincia;

public class AlumnosDAO {
	
	private ConexionDB nuevaConexion;
	
	public ArrayList<Alumno> ListadoAlumnos() throws SQLException{
		
		nuevaConexion = new ConexionDB();
		nuevaConexion.Open();
		ArrayList<Alumno> ListadoAlumnos = new ArrayList<Alumno>();
		
		
		try {  
			
			ResultSet TablaResultados = nuevaConexion.query("SELECT * FROM Alumnos INNER JOIN Localidades ON Alumnos.IdLocalidad = Localidades.IdLocalidad INNER JOIN Provincias ON Provincias.IdProvincia = Alumnos.IdProvincias");
			while(TablaResultados.next()) {
				
				Alumno unAlumno = new Alumno();
				Localidad unaLocalidad = new Localidad();
				Provincia unaProvincia = new Provincia();
				
				if(TablaResultados.getInt("Estado")==1) 
				{
					
					unAlumno.setLegajo(TablaResultados.getInt("Legajo"));
					unAlumno.setNombre(TablaResultados.getString("Nombre"));
					unAlumno.setApellido(TablaResultados.getString("Apellido"));
					unAlumno.setFechaNacimiento(TablaResultados.getString("FechaNacimiento"));
					unAlumno.setDireccion(TablaResultados.getString("Direccion"));
					unAlumno.setEmail(TablaResultados.getString("Email"));
					unAlumno.setTelefono(TablaResultados.getString("Telefono"));
					
					unaProvincia.setIdProvincia(TablaResultados.getInt("idProvincia"));
					unaProvincia.setNombre(TablaResultados.getString("Provincias.Nombre"));
					
					unaLocalidad.setIdLocalidad(TablaResultados.getInt("Localidades.idLocalidad"));
					unaLocalidad.setNombre(TablaResultados.getString("Localidades.Nombre"));
					unaLocalidad.setProvincia(unaProvincia);
					
					unAlumno.setLocalidad(unaLocalidad);
					
					ListadoAlumnos.add(unAlumno);
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
		
		return ListadoAlumnos;
	}
	
	public void AgregarAlumno(Alumno unNuevoAlumno) throws SQLException{
		
		nuevaConexion = new ConexionDB();
				
		try {
			
			 CallableStatement SP_AgregarAlumno = (CallableStatement) nuevaConexion.Open().prepareCall("CALL AgregarAlumno(?,?,?,?,?,?,?,?");
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
			
			e.printStackTrace();
			System.out.print("Error al cargar "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
	
	public void ModificarAlumno(Alumno modificarAlumno) throws SQLException{
		
		nuevaConexion = new ConexionDB();
		
		try {
						 
			 CallableStatement SP_ModificarAlumno = (CallableStatement) nuevaConexion.Open().prepareCall("CALL ModificarAlumno(?,?,?,?,?,?,?,?,?)");
			
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
			 
			 CallableStatement SP_EliminarAlumno = (CallableStatement) nuevaConexion.Open().prepareCall("CALL EliminarAlumno(?)");
			 SP_EliminarAlumno.setInt(1,eliminarAlumno);
			 SP_EliminarAlumno.execute();
	
		} 
		
	catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("Error al cargar "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
	
	public int NuevoLegajo() {
		
		nuevaConexion = new ConexionDB();
		int Legajo=0;
		
		try {
			
			Statement st= (Statement) nuevaConexion.Open().createStatement();
			ResultSet TablaResultados= st.executeQuery("select legajo from alumnos order by legajo desc limit 1");
					
			while(TablaResultados.next()) {
				
					Legajo=TablaResultados.getInt("legajo");
			}

		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("Error al cargar "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
			
		return Legajo+1;

	}
}
