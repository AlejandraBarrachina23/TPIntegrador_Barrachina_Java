package Negocio;
import DAO.UsuarioDAO;
import Dominio.Usuario;

public class UsuarioNegocio {

	
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
}