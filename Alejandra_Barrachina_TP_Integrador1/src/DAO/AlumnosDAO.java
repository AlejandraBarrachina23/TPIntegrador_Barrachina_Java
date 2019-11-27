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
		
		ArrayList<Alumno> ListadoAlumnos = new ArrayList<Alumno>();
		nuevaConexion = new ConexionDB();
		nuevaConexion.EstablecerConexion();
		
		try {  
			
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();
			ResultSet TablaResultados= st.executeQuery("SELECT * FROM Alumnos INNER JOIN Localidades ON Alumnos.IdLocalidad = Localidades.IdLocalidad INNER JOIN Provincias ON Provincias.IdProvincia = Alumnos.IdProvincias");
			
			while(TablaResultados.next()) {
				
				Alumno unAlumno = new Alumno();
				Localidad unaLocalidad = new Localidad();
				Provincia unaProvincia = new Provincia();
				
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
		catch (Exception e) {
			
			System.out.print("No cargo "+ e);
		}
		
		return ListadoAlumnos;
	}
	
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
}
