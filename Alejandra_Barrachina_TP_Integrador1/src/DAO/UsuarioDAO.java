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
}
