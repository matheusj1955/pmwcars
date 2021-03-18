package br.unitins.pmwcars.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = -4769257031324340497L;
	private List<Usuario> listaUsuario;
	private Usuario usuario = null;

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void salvar() {
		try {
			UsuarioRepository repo = new UsuarioRepository();
			repo.save(getUsuario());
			limpar();
			Util.addInfoMessage("Cadastro realizado com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			UsuarioRepository repo = new UsuarioRepository();
			repo.remove(getUsuario());
			Util.addInfoMessage("Usuario removido com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar() {
		System.out.println("Entrou no limpar");
		usuario = null;
	}
	
	public void editar(Usuario usuario) {
		System.out.println("Entrou no editar");
		setUsuario(usuario);
	}
	
	public void pesquisar() {
		System.out.println("Pesquisar");
		UsuarioRepository repo = new UsuarioRepository();
		try {
			listaUsuario = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario==null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}
}
