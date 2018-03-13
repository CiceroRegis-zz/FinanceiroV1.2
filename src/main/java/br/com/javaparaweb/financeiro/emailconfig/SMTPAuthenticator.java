package br.com.javaparaweb.financeiro.emailconfig;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

//Classe necessaria para passar usuario e senha caso precisa de autenticacao
class SMTPAuthenticator extends Authenticator {
	String login;
	String password;

	//Recebendo usuario e senha e guardando nas variaveis
	public SMTPAuthenticator(String login, String password) {
		this.login = login;
		this.password = password;
	}

	//Esse é o metodo usado para enviar usuario e senha
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.login, this.password);
	}
}

/***
 * 
 * @author lucas iorio
 * www.byiorio.com
 *
 */
