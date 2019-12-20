package Negocio;
import java.sql.SQLException;

import DAO.UsuarioDAO;
import Dominio.Profesor;
import Dominio.Usuario;

public class UsuarioNegocio implements IUsuario {

	UsuarioDAO unUsuarioDAO = new UsuarioDAO();
	
	public void VerificarExistenciaUsuario(Usuario UsuarioIngresado) throws Exception {
		
		UsuarioDAO usuario = new UsuarioDAO();
		if(usuario.VerificarExistencia(UsuarioIngresado)==null) throw new Exception("El usuario ingresado no existe");
		
	}
	
	public void VerificarInicioSesion(Usuario UsuarioIngresado) throws Exception {
		
		if(UsuarioIngresado.getIntentosIncio()>3) throw new Exception("El usuario ha sido bloqueado");
		
		
	}
	
public void VerificarBloqueo(Usuario UsuarioIngresado) throws Exception {
		
		if(!UsuarioIngresado.getEstado()) throw new Exception("El usuario esta bloqueado");
		
	
	}

public Usuario VerificarExistencia(Usuario unUsuario) throws SQLException {

	return unUsuarioDAO.VerificarExistencia(unUsuario);
}

public void BloquearUsuario(String NombreUsuario) {

	unUsuarioDAO.BloquearUsuario(NombreUsuario);
	
}


public Profesor ComprobarMail(String Mail) {
	
	return unUsuarioDAO.ComprobarMail(Mail);
}

public void AgregarUsuario(Usuario unNuevoUsuario) {

	 unUsuarioDAO.AgregarUsuario(unNuevoUsuario);
}

}
