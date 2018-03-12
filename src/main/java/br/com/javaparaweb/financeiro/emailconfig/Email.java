package br.com.javaparaweb.financeiro.emailconfig;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	
	public void EnviarEmail() {
		
	}
	
	public void enviaEmail() {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("ciceroregis25@gmail.com", "Meups32017"));
			email.setSSLOnConnect(true);
			email.setFrom("ciceroregis25@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("ciceroregis3@hotmail.com");
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
