package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Funcionario;
import br.untinis.pmwcars.repository.FuncionarioRepository;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Funcionario> {
	
	private static final long serialVersionUID = 1067992066000332854L;
	private List<Funcionario> listaFuncionario;

	@Override
	public Funcionario getEntity() {
		if (entity == null)
			entity = new Funcionario();
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		FuncionarioRepository repo = new FuncionarioRepository();
		try {
			listaFuncionario = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	@Override
	public void salvar() {
		FuncionarioRepository repo = new FuncionarioRepository();
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
	
	public List<Funcionario> getListaFuncionario() {
		if (listaFuncionario==null)
			listaFuncionario = new ArrayList<Funcionario>();
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	

}
