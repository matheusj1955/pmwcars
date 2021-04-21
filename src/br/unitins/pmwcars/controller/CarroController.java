package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Carro;
import br.untinis.pmwcars.repository.CarroRepository;

@Named
@ViewScoped
public class CarroController extends  Controller<Carro>{

	private static final long serialVersionUID = -1419489362181022305L;

	private List<Carro> listaCarro;

	@Override
	public Carro getEntity() {
		if (entity == null) {
			entity = new Carro();
		}
		return entity;
	}
	
	public void pesquisar() {
		System.out.println("Pesquisar");
		CarroRepository repo = new CarroRepository();
		try {
			listaCarro = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	
	@Override
	public void salvar() {
		CarroRepository repo = new CarroRepository();
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


	public void pesquisarCarro() {
		EntityManager em = JPAUtil.getEntityManager();
		CarroRepository repo = new CarroRepository();
		try {
			setListaCarro(repo.findAll());
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao excluir.");
			setListaCarro(null);
		}
	}
	
	public List<Carro> getListaCarro() {
		if (listaCarro == null)
			listaCarro = new ArrayList<Carro>();
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}


}
