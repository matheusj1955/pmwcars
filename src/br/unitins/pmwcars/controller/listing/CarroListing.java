package br.unitins.pmwcars.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.application.RepositoryException;
import br.untinis.pmwcars.repository.CarroRepository;

@Named
@ViewScoped
public class CarroListing extends Listing<Carro> {

	
	private static final long serialVersionUID = -773574632356217402L;
	private String filtro;
	
	public CarroListing() {
		super("carrolisting", new CarroRepository());
	}
	
	public void pesquisar() {
		CarroRepository repo = new CarroRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Carro>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
