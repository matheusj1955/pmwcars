package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Perfil;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = 8086276094345653703L;
	
	private List<Usuario> listaUsuario;

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		UsuarioRepository repo = new UsuarioRepository();
		try {
			listaUsuario = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	
	@Override
	public void salvar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			repo.beginTransaction();
			repo.save(getEntity());
			repo.commitTransaction();
			Util.addInfoMessage("Opera??o realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			repo.rollbackTransaction();
			System.out.println("Erro ao salvar.");
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
		
	}


	public void pesquisarUsuario() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioRepository repo = new UsuarioRepository();
		try {
			setListaUsuario(repo.findAll());
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao excluir.");
			setListaUsuario(null);
		}
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}



}