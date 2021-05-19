package br.unitins.pmwcars.controller.listing;


import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Municipio;
import br.untinis.pmwcars.repository.MunicipioRepository;

@Named
@ViewScoped
public class MunicipioListing extends Listing<Municipio> {

	private static final long serialVersionUID = -1800622632771618402L;
	private String filtro;
	
	public MunicipioListing() {
		super("municipiolisting", new MunicipioRepository());
	}
	
	public void pesquisar() {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Municipio>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}