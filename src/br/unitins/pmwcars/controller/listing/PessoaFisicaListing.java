package br.unitins.pmwcars.controller.listing;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class PessoaFisicaListing extends Listing<PessoaFisica> {

	private static final long serialVersionUID = 1753552924233677646L;
	private String filtro;
	
	public PessoaFisicaListing() {
		super("pessoafisicalisting", new PessoaFisicaRepository());
	}
	
	
	public void pesquisar() {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<PessoaFisica>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}