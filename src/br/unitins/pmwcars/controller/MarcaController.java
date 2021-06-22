package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Marca;
import br.untinis.pmwcars.repository.MarcaRepository;


@Named
@ViewScoped
public class MarcaController extends Controller<Marca>{

	private static final long serialVersionUID = -5044487020385226027L;
	private List<Marca> listaMarca;

	@Override
	public Marca getEntity() {
		if (entity == null)
			entity = new Marca(); //////////////
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		MarcaRepository repo = new MarcaRepository();
		try {
			listaMarca = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	
	@Override
	public void salvar() {
		MarcaRepository repo = new MarcaRepository();
		try {
			repo.beginTransaction();
			repo.save(getEntity());
			repo.commitTransaction();
			Util.addInfoMessage("Operação realizada com sucesso.");
			limpar();
		} catch (RepositoryException e) {
			repo.rollbackTransaction();
			System.out.println("Erro ao salvar.");
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
		
	}


	public void pesquisarMarca() {
		EntityManager em = JPAUtil.getEntityManager();
		MarcaRepository repo = new MarcaRepository();
		try {
			setListaMarca(repo.findAll());
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao excluir.");
			setListaMarca(null);
		}
	}
	
	public List<Marca> getListaMarca() {
		if (listaMarca == null)
			listaMarca = new ArrayList<Marca>();
		return listaMarca;
	}

	public void setListaMarca(List<Marca> listaMarca) {
		this.listaMarca = listaMarca;
	}
	
}
