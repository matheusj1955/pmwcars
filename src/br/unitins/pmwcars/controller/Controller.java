package br.unitins.pmwcars.controller;
import java.io.Serializable;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.DefaultEntity;
import br.untinis.pmwcars.repository.Repository;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {
	
	private static final long serialVersionUID = -1316122369754938069L;
	
	protected T entity;

	public Controller() {
		super();
	}
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	

	public void salvar() {
		Repository<T> repo = new Repository<T>();
	
		try {
			repo.beginTransaction();
			repo.save(getEntity());
			repo.commitTransaction();
			
			limpar();
			Util.addInfoMessage("Cadastro realizado com sucesso.");
		} catch (RepositoryException e) {
			repo.rollbackTransaction();
		}
	}

	public void excluir() {
		Repository<T> repo = new Repository<T>();
		try {
			repo.beginTransaction();
			repo.remove(getEntity());
			repo.commitTransaction();
			
			limpar();
			Util.addInfoMessage("Cliente removido com sucesso.");
		} catch (RepositoryException e) {
			Util.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar() {
		entity = null;
	}

	public void editar(T entity) {
		System.out.println("Entrou no editar");
		setEntity(entity);
	}
	

	
}