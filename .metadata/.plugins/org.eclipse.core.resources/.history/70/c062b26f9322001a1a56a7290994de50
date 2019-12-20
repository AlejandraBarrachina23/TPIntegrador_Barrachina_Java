package Presentacion;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UsuarioDAO;
import Dominio.Profesor;
import Dominio.Usuario;
import Negocio.Mail;
import Negocio.UsuarioNegocio;

@WebServlet("/serveletUsuario")
public class serveletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serveletUsuario() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		RequestDispatcher Request = request.getRequestDispatcher("login.jsp");
		Request.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			
			if(request.getParameter("btnLogin")!=null) {
				
				Usuario UsuarioIngresado = new Usuario();
				Usuario UsuarioDB = new Usuario();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				UsuarioIngresado.setUsuario(request.getParameter("tboxUsuario"));
				UsuarioIngresado.setContrasenia(request.getParameter("tboxContrasenia"));
				UsuarioDB = usuarioDAO.VerificarExistencia(UsuarioIngresado);
				String Estado ="";
				HttpSession estadoLogin = request.getSession();	
				estadoLogin.setAttribute("EstadoLogin", Estado);
				
				if(UsuarioDB!=null) {  //VERIFICA EXISTENCIA USUARIO
					
					HttpSession sesion = request.getSession();
					
					if((Usuario) request.getSession(true).getAttribute("usuario")!=null){ //ASIGNA EL USUARIO A LA SESSION
								  	
						if(!((Usuario) request.getSession(true).getAttribute("usuario")).getUsuario().equals(UsuarioIngresado.getUsuario())){  //REASIGNA SI EL USUARIO CAMBIO
							
							UsuarioIngresado.setIntentosIncio(0);
							sesion.setAttribute("usuario", UsuarioIngresado);
						}
						
						else {}
					}
					  
					 else {
						  	
							UsuarioIngresado.setIntentosIncio(0);
							sesion.setAttribute("usuario", UsuarioIngresado);
					  }
					  
					if(((Usuario) sesion.getAttribute("usuario")).getIntentosIncio()<3) {
						
						if(UsuarioDB.getEstado()) { //VERIFICA SI ESTA BLOQUEADO
							
							if(UsuarioDB.getContrasenia().equals(UsuarioIngresado.getContrasenia())) { //VERIFICA CONTRASEÑA
								
								UsuarioIngresado = UsuarioDB;
								sesion.setAttribute("usuario", UsuarioIngresado);
																	
									if(UsuarioIngresado.getTipoUsuario().equals("administrador")) {
										RequestDispatcher Request = request.getRequestDispatcher("index.jsp");
										Request.forward(request, response);
									}
									else {
										
										RequestDispatcher Request = request.getRequestDispatcher("index-profesores.jsp");
										Request.forward(request, response);
									}
							}
							
							else { //AUMENTAR EL CONTADOR DE INTENTOS

								Estado ="Contrasenia Incorrecta";
								UsuarioIngresado = (Usuario) sesion.getAttribute("usuario");
								UsuarioIngresado.setIntentosIncio(UsuarioIngresado.getIntentosIncio()+1);
								sesion.setAttribute("usuario", UsuarioIngresado);
								estadoLogin.setAttribute("EstadoLogin", Estado);
								RequestDispatcher Request = request.getRequestDispatcher("login.jsp");
								Request.forward(request, response);
								
							}
						}
						else {
							
							request.getSession().invalidate();
							RequestDispatcher Request = request.getRequestDispatcher("advertencia.jsp");
							Request.forward(request, response);
						}			
					}
					
					else {
					
						RequestDispatcher Request = request.getRequestDispatcher("advertencia.jsp");
						Request.forward(request, response);
						usuarioDAO.BloquearUsuario(((Usuario) request.getSession(true).getAttribute("usuario")).getUsuario());
					}
				}
				
				else {
					
					Estado ="No existe";
					estadoLogin.setAttribute("EstadoLogin", Estado);
					RequestDispatcher Request = request.getRequestDispatcher("login.jsp");
					Request.forward(request, response);
				}
				
			}
		} 
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		if(request.getParameter("btnEnviarMail")!=null) {
			

			try {
				String email= request.getParameter("tboxEmail");
				UsuarioNegocio unUsuarioNegocio = new UsuarioNegocio();
				Profesor unProfesor = new Profesor();
				unProfesor = unUsuarioNegocio.ComprobarMail(email);
				System.out.println(unProfesor.getNombre());
				
				if(unProfesor.getNombre()!=null) {
					
					System.out.println("entro");
					Mail.EnviarMail(email, "alejandrabarrachina23@gmail.com", "barr1989Share.", "Recuperación Contraseña", "Hola "+ unProfesor.getNombre()+" "+unProfesor.getApellido() + "tu constraseña es: " + unProfesor.getDireccion() );
					RequestDispatcher Request = request.getRequestDispatcher("advertencia2.jsp");
					Request.forward(request, response);
					
				}
			
			}
			
			catch (Exception e) {
	
				e.printStackTrace();
			}
			
			HttpSession MailIncorrecto = request.getSession();	
			MailIncorrecto.setAttribute("MailIncorrecto", "NoExiste");
			RequestDispatcher Request = request.getRequestDispatcher("recuperacion.jsp");
			Request.forward(request, response);
		}
	
	}
	

}
