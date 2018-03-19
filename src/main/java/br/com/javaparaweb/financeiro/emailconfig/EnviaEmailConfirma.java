package br.com.javaparaweb.financeiro.emailconfig;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.javaparaweb.financeiro.usuario.Usuario;

public class EnviaEmailConfirma {

	public void enviaEmail(Usuario usuario) {
		try {

			// Variaveis
			String d_email = "testejava2018@gmail.com", d_password = "Meups32014", d_host = "smtp.gmail.com",
					d_port = "465", m_to = usuario.getEmail(), m_subject = "Financeiro Web 2018", m_text = usuario.getNome();

			// Propriedades Necessarias
			Properties props = new Properties();

			/*// Modo debug para verificar os passos do envio
			props.put("mail.debug", "true");*/

			// Servidor SMTP
			props.put("mail.host", d_host);

			// Porta
			props.put("mail.smtp.port", d_port);

			// Necessario autenticacao
			props.put("mail.smtp.auth", "true");

			// Liga o SSL
			props.put("mail.smtp.ssl.enable", "true");

			Session session = Session.getInstance(props, new SMTPAuthenticator(d_email, d_password));

			// Pega a sessao com usuario e senha
			MimeMessage msg = new MimeMessage(session);

			// Coloca O corpo do titulo
			msg.setText(m_text);

			// Coloca o assunto
			msg.setSubject(m_subject);

			// Coloca quem enviou
			msg.setFrom(new InternetAddress(d_email));
			msg.setContent(m_text = "<h2> "+ usuario.getNome() + ",Seu cadastro foi efetuado! </h2>"
					+ "<h3>Agora você já pode usar o sistema Financeiro Tudo Sob Controle 2018. <br />"
					+"<br /> <b>Login:</b> " + usuario.getLogin(),"text/html");

			// Coloca para quem sera enviado
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));

			// Envia a mensagem
			Transport.send(msg);
			

			System.out.println("#>>>O Email foi enviado com sucesso!!");
		} catch (MessagingException mex) {
			System.out.println("#>>>Falha no envio do email, exception: " + mex);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro! Occoreu um erro ao cadastrar usuario.", "Erro"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
