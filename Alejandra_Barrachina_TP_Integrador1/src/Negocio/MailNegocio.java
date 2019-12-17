package Negocio;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailNegocio {

	public void enviarCorreo(String recepient) {
		
		try {
			
			Properties propiedades = System.getProperties();
			propiedades.put("mail.smtp.starttls.enable","true");
			propiedades.put("mail.smtp.auth", "true");
			propiedades.put("mail.smtp.host", "smtp.gmail.com");
			propiedades.put("mail.smtp.port", "587");
			
			String MiMail = "alejandrabarrachina23@gmail.com";
			String Password = "barr1989Share.";
			
			Session session = Session.getInstance(propiedades, new Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication(MiMail,Password);
				}
			});

			
			session.setDebug(true);
			
			Message Mensaje = prepararMensaje(session,MiMail,recepient);
			Transport.send(Mensaje);
			System.out.println("Enviado correctamente");
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}
	
	private static Message prepararMensaje(Session session, String MiMail, String recepient) {
		
		try {
			
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(MiMail));
			mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			mensaje.setSubject("Mi primer mail");
			mensaje.setText("Hola, como estas?");
			return mensaje;
			
		} catch (Exception e) {
			
		}
		return null;
		
		
	}
}
