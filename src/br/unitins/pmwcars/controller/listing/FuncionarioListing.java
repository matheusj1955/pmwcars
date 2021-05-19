package br.unitins.pmwcars.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Funcionario;
import br.untinis.pmwcars.repository.FuncionarioRepository;

@Named
@ViewScoped
public class FuncionarioListing extends Listing<Funcionario> {

	private static final long serialVersionUID = 1753552924233677646L;
	private String filtro;
	
	public FuncionarioListing() {
		super("funcionariolisting", new FuncionarioRepository());
	}
	
	public void pesquisar() {
		FuncionarioRepository repo = new FuncionarioRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Funcionario>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}