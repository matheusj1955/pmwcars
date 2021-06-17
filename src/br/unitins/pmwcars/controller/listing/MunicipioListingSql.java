package br.unitins.pmwcars.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Municipio;
import br.untinis.pmwcars.repository.MunicipioRepository;

@Named
@ViewScoped
public class MunicipioListingSql extends ListingSql<Municipio> {

	private static final long serialVersionUID = 7051066688912408549L;
	private String filtro;
	
	public MunicipioListingSql() {
		super("municipiolistingsql", new MunicipioRepository());
	}
	
	public void pesquisar() {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			setList(repo.findByNomeSQL(filtro));
		} catch (RepositoryException e) {
			setList(new ArrayList<Object[]>());
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}