package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Pessoa;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.PessoaRepository;

@Named
@ViewScoped
public class PessoaController extends Controller<Pessoa>{

	private static final long serialVersionUID = 1401821123737357649L;
	////////// pessoa
	
	private List<Pessoa> listaPessoa;

	@Override
	public Pessoa getEntity() {
		if (entity == null)
			entity = new PessoaFisica(); //////////////
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		PessoaRepository repo = new PessoaRepository();
		try {
			listaPessoa = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	
	@Override
	public void salvar() {
		PessoaRepository repo = new PessoaRepository();
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


	public void pesquisarPessoa() {
		EntityManager em = JPAUtil.getEntityManager();
		PessoaRepository repo = new PessoaRepository();
		try {
			setListaPessoa(repo.findAll());
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao excluir.");
			setListaPessoa(null);
		}
	}
	
	public List<Pessoa> getListaPessoa() {
		if (listaPessoa == null)
			listaPessoa = new ArrayList<Pessoa>();
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
	

}
