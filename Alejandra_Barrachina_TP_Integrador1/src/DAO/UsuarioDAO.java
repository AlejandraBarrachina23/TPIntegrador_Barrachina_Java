package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

import Dominio.Profesor;
import Dominio.Usuario;

public class UsuarioDAO {

	private ConexionDB nuevaConexion;
	
	public Usuario VerificarExistencia(Usuario unUsuario) throws SQLException {
		
		try {
			
			nuevaConexion = new ConexionDB();
			nuevaConexion.Open();
			Usuario usuarioDB = new Usuario();
			ResultSet TablaResultados= nuevaConexion.query("SELECT * from Usuario WHERE Usuario='"+ unUsuario.getUsuario()+"'");
				
			while(TablaResultados.next()) {
				
				Profesor unProfesor = new Profesor();
				usuarioDB.setUsuario(TablaResultados.getString("Usuario"));
				usuarioDB.setContrasenia(TablaResultados.getString("Contrasenia"));
				usuarioDB.setTipoUsuario(TablaResultados.getString("TipoUsuario"));
				usuarioDB.setEstado(TablaResultados.getBoolean("Estado"));
				unProfesor.setLegajo(TablaResultados.getInt("IdProfesor"));
				usuarioDB.setUnProfesor(unProfesor);
				return usuarioDB;
			}
		}

		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
		
		return null;
	
	}	
	
	public void BloquearUsuario(String NombreUsuario) {
		
	nuevaConexion = new ConexionDB();
		
		try {

			 CallableStatement SP_BloquearUsuario = (CallableStatement) nuevaConexion.Open().prepareCall("CALL BloquearUsuario(?)");
			 SP_BloquearUsuario.setString(1,NombreUsuario);
			 SP_BloquearUsuario.execute();
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
	
	public Profesor ComprobarMail(String Mail) {
		
		nuevaConexion = new ConexionDB();
		Profesor unProfesor = new Profesor();
		
		try {
			
			nuevaConexion.Open();
			ResultSet TablaResultados= nuevaConexion.query("select nombre, apellido, email, usuario.contrasenia, usuario.estado from profesores inner join usuario on usuario.idprofesor=profesores.idprofesor where email ='" + Mail + "'");
			while(TablaResultados.next()) {
				
				unProfesor.setNombre(TablaResultados.getString("nombre"));
				unProfesor.setApellido(TablaResultados.getString("apellido"));
				unProfesor.setEmail(TablaResultados.getString("email"));
				unProfesor.setDireccion(TablaResultados.getString("contrasenia"));
				unProfesor.setTelefono(TablaResultados.getString("estado"));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
				
		return unProfesor;
	}
	
	public void AgregarUsuario(Usuario unNuevoUsuario) {
		
	nuevaConexion = new ConexionDB();
		
		try {
			System.out.println(unNuevoUsuario.getUsuario());
			System.out.println(unNuevoUsuario.getIntentosIncio());
			 
			CallableStatement SP_AgregarUsuario = (CallableStatement) nuevaConexion.Open().prepareCall("CALL AgregarUsuario(?,?,?,?)");
			 SP_AgregarUsuario.setString(1,unNuevoUsuario.getUsuario());
			 SP_AgregarUsuario.setString(2,unNuevoUsuario.getContrasenia());
			 SP_AgregarUsuario.setString(3,unNuevoUsuario.getTipoUsuario());
			 SP_AgregarUsuario.setInt(4,unNuevoUsuario.getIntentosIncio());
			 SP_AgregarUsuario.execute();
	
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.print("No cargo "+ e);
		}
		
		finally {
			nuevaConexion.close();
		}
	}
		
		
	
}
