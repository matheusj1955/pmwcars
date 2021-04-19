package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity<Usuario> {
	
	private static final long serialVersionUID = 6662444843042956351L;

	private String login;
	
	private String senha;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}