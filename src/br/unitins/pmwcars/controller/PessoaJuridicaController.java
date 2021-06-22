package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.model.PessoaJuridica;

@Named
@ViewScoped
public class PessoaJuridicaController extends Controller<PessoaJuridica> {

	private static final long serialVersionUID = -2325244771250907688L;

	@Override
	public PessoaJuridica getEntity() {
		if (entity == null) {
			entity = new PessoaJuridica();
		}
		return entity;
	}
	
//	public void abrirPessoaJuridicaListing() {
//		PessoaJuridicaListing listing = new PessoaJuridicaListing();
//		listing.open();
//	}
//	
//	public void obterPessoaJuridicaListing(SelectEvent<PessoaJuridica> event) {
//		setEntity(event.getObject());
//	}
//	
}