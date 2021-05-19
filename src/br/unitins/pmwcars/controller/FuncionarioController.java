package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.PessoaFisica;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Funcionario> {
	
	private static final long serialVersionUID = 1067992066000332854L;

	@Override
	public Funcionario getEntity() {
		if (entity == null) {
			entity = new Funcionario();
			entity.setPessoaFisica(new PessoaFisica());
		}
		return entity;
	}

}