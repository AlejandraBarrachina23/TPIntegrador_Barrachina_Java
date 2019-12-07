package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

import Dominio.Usuario;

public class UsuarioDAO {

	private ConexionDB nuevaConexion;
	
	public Usuario VerificarExistencia(Usuario unUsuario) throws SQLException {
		
		try {
			
			nuevaConexion = new ConexionDB();
			nuevaConexion.EstablecerConexion();
			Usuario usuarioDB = new Usuario();
			Statement st= (Statement) nuevaConexion.EstablecerConexion().createStatement();		
			ResultSet TablaResultados= st.executeQuery("SELECT * from Usuario WHERE Usuario='"+ unUsuario.getUsuario()+"'");
				
			while(TablaResultados.next()) {
				
				usuarioDB.setUsuario(TablaResultados.getString("Usuario"));
				usuarioDB.setContrasenia(TablaResultados.getString("Contrasenia"));
				usuarioDB.setTipoUsuario(TablaResultados.getString("TipoUsuario"));
				usuarioDB.setEstado(TablaResultados.getBoolean("Estado"));
				return usuarioDB;
			}
		}

		catch (Exception e) {

		}
		return null;
	
	}	
	
	public void BloquearUsuario(String NombreUsuario) {
		
	nuevaConexion = new ConexionDB();
		
		try {

			 CallableStatement SP_BloquearUsuario = (CallableStatement) nuevaConexion.EstablecerConexion().prepareCall("CALL BloquearUsuario(?)");
			 SP_BloquearUsuario.setString(1,NombreUsuario);
			 SP_BloquearUsuario.execute();
			
		} 
		
		catch (Exception e) {
			
			System.out.print("Error al bloquear "+ e);
		}
	}
}
