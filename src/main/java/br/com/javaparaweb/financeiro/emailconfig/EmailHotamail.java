package br.com.javaparaweb.financeiro.emailconfig;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailHotamail {

	static Session session; //declarar como um atributo de classe e static(global)
	public static void main(String[] args) {  
        Properties props = new Properties(); 
        
      /*  props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");*/
        
        /** Parâmetros de conexão com servidor gmail */  
        props.put("mail.transport.protocol", "smtp");  
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.socketFactory.port", "465");  
        props.put("mail.smtp.socketFactory.fallback", "false");  
        props.put("mail.smtp.starttls.enable", "true");  
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465");  
       session = Session.getDefaultInstance(props,  
                    new javax.mail.Authenticator() {  
                         protected PasswordAuthentication getPasswordAuthentication()   
                         {  
                               return new PasswordAuthentication("testejava2018@gmail.com", "Meups32014");
                               
                         }  
                    }); 
       
       /*session = Session.getDefaultInstance(props,  
               new javax.mail.Authenticator() {  
                    protected PasswordAuthentication getPasswordAuthentication()   
                    {  
                          return new PasswordAuthentication("ciceroregis3@hotmail.com", "meups32014");
                          
                    }  
               }); */
        /** Ativa Debug para sessão */  
        session.setDebug(true);  
        enviaHotmail(); //chama o método que é declarado como static nesse contexto
  }  
	public static void enviaHotmail() {
		try {  
            Message message = new MimeMessage(session);  
            message.setFrom(new InternetAddress("testejava2018@gmail.com")); //Remetente  
            message.setRecipients(Message.RecipientType.TO,   
                              InternetAddress.parse("ciceregis25@gmail.com")); //Destinatário(s) 
            
           /* message.setFrom(new InternetAddress("ciceroregis3@hotmail.com"));//Remetente 
            message.setRecipients(Message.RecipientType.TO,   
                    InternetAddress.parse("ciceroregis@outlook.com")); //Destinatário(s)  
            message.setSubject("Confirmação de cadastro de usuario");//Assunto  
            message.setText("seu cadastro foi realizado com sucesso" +
            		"\n"); */ 
            /**Método para enviar a mensagem criada*/  
            Transport.send(message);
            System.out.println("Feito!!!");  
       } catch (MessagingException e) {  
            throw new RuntimeException(e);  
      }  
	}

}
