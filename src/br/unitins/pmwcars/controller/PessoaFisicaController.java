package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class PessoaFisicaController extends Controller<PessoaFisica>{

	private static final long serialVersionUID = -3479844067657108273L;
	private List<PessoaFisica> listaPessoaFisica;

	@Override
	public PessoaFisica getEntity() {
		if (entity == null)
			entity = new PessoaFisica();
		return entity;
	}

	public void pesquisar() {
		System.out.println("Pesquisar");
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		try {
			listaPessoaFisica = repo.findAll();
		} catch (RepositoryException e) {
			
		}
	}
	
	public List<PessoaFisica> getListaPessoaFisica() {
		if (listaPessoaFisica==null)
			listaPessoaFisica = new ArrayList<PessoaFisica>();
		return listaPessoaFisica;
	}
}
