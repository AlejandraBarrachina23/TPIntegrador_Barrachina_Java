package Negocio;
 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Mail {
	
	   
	   
public void EnviarMail() {
	
	  try {
		  

		   String to = "federicolamas95@gmail.com";
		   String from = "alejandrabarrachina23@gmail.com";
		   String host = "localhost";   
		   
		  Properties properties = System.getProperties();
		  properties.setProperty("mail.smtp.host", host);
		  Session mailSession = Session.getDefaultInstance(properties);
	      MimeMessage message = new MimeMessage(mailSession);
	      
	      message.setFrom(new InternetAddress(from));
	      message.addRecipient(Message.RecipientType.TO,
	                               new InternetAddress(to));
	      message.setSubject("This is the Subject Line!");
	      message.setText("This is actual message");
	      Transport.send(message);

	   } 
	  
	  catch (MessagingException mex) {
	      mex.printStackTrace();
	   }
	
}

	 
}
