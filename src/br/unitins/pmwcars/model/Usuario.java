package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends DefaultEntity<Usuario> {
	
	private static final long serialVersionUID = 6662444843042956351L;

//	@JoinColumn(unique = true)
	private String login;
	
	private String senha;
	
	private Perfil perfil;


	@OneToMany
	private List<Telefone> listatelefone;
	
	//é necessario essa ligação com funcionario?
//	@OneToOne(mappedBy = "funcionario")
	
	public List<Telefone> getListatelefone() {
		return listatelefone;
	}

	public void setListatelefone(List<Telefone> listatelefone) {
		this.listatelefone = listatelefone;
	}

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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}