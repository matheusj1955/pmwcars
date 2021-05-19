package br.unitins.pmwcars.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Marca;
import br.untinis.pmwcars.repository.MarcaRepository;

@Named
@ViewScoped
public class MarcaListing extends Listing<Marca> {

	
	private static final long serialVersionUID = -4351447665082066449L;
	private String filtro;
	
	public MarcaListing() {
		super("marcalisting", new MarcaRepository());
	}
	
	public void pesquisar() {
		MarcaRepository repo = new MarcaRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Marca>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
