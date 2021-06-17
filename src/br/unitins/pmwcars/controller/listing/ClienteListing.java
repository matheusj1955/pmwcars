package br.unitins.pmwcars.controller.listing;

import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Cliente;
import br.untinis.pmwcars.repository.ClienteRepository;


@Named
@ViewScoped
public class ClienteListing extends Listing<Cliente> {

	private static final long serialVersionUID = -6128267932386553283L;
	
	
		private String filtro;
		
		public ClienteListing() {
			super("clientelisting", new ClienteRepository());
		}
		
		public void pesquisar() {
			ClienteRepository repo = new ClienteRepository();
			try {
				setList(repo.findByNome(filtro));
			} catch (RepositoryException e) {
				setList(new ArrayList<Cliente>());
			}
		}

		public String getFiltro() {
			return filtro;
		}

		public void setFiltro(String filtro) {
			this.filtro = filtro;
		}


}
