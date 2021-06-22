package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.model.PessoaFisica;

@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica>{

	private static final long serialVersionUID = -3479844067657108273L;

	@Override
	public PessoaFisica getEntity() {
		if (entity == null)
			entity = new PessoaFisica();
		return entity;
	}

//	public void abrirPessoaFisicaListing() {
//		PessoaFisicaListing listing = new PessoaFisicaListing();
//		listing.open();
//	}
//	
//	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
//		setEntity(event.getObject());
//	}
}
