package Negocio;

import java.util.Properties;//
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;//
import javax.mail.Message;//
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;//
import javax.mail.Session;//
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;//
import javax.mail.internet.AddressException;

 
public class Mail {
	
	   
	   
	public static void EnviarMail(String recibe, String envia, String contrasenia, String asunto, String contenido) throws Exception{
		
		System.out.println("PREPARANDO PARA ENVIAR MAIL");
		
		Properties properties = new Properties();
		  
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		  
		Session session = Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(envia, contrasenia);
			}
		});
		  
		Message mensaje = prepararMensaje(session, envia, recibe, asunto, contenido);
		
		Transport.send(mensaje);
		System.out.println("MENSAJE ENVIADO SATISFACTORAMENTE");
	}

	private static Message prepararMensaje(Session session, String envia, String recibe, String asunto, String contenido) {
		try {
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(envia));
			mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(recibe));
			mensaje.setSubject(asunto);//Carga el asunto del mensahe
			mensaje.setText(contenido);//Carga el texto del mensaje
			return mensaje;
		} catch (Exception ex) {
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	 
}