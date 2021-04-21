package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity<Usuario> {
	
	private static final long serialVersionUID = 6662444843042956351L;

//	@JoinColumn(unique = true)
	private String login;
	
	private String senha;
	

	@OneToMany
	private List<Telefone> listatelefone;
	
	//é necessario essa ligação com funcionario?
//	@OneToOne(mappedBy = "funcionario")
	
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