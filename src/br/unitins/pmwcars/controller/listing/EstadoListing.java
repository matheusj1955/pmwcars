package br.unitins.pmwcars.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Estado;
import br.untinis.pmwcars.repository.EstadoRepository;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado> {

	private static final long serialVersionUID = 6475571494445721927L;
	private String filtro;
	
	public EstadoListing() {
		super("estadolisting", new EstadoRepository());
	}
	
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Estado>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
