package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.model.Pessoa;

@Named
@ViewScoped
public class PessoaController extends Controller<Pessoa>{

	private static final long serialVersionUID = 1401821123737357649L;

	@Override
	public Pessoa getEntity() {
		if (entity == null)
			entity = new Pessoa(); //////////////
		return entity;
	}

}