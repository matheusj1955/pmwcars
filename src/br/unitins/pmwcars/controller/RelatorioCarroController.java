package br.unitins.pmwcars.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Carro;
import br.untinis.pmwcars.repository.CarroRepository;

@Named
@ViewScoped
public class RelatorioCarroController implements Serializable {

	private static final long serialVersionUID = -6466793482965540067L;
	private String filtro;
	private List<Carro> listaCarro;
	
	public void pesquisar() {
		CarroRepository repo = new CarroRepository();
		try {
			setListaCarro(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			setListaCarro(null);
			e.printStackTrace();
		}
	}
	
	public void limpar() {
		listaCarro = null;
	}
	
	public void gerarRelatorio() {
		Util.redirect("/Pmwcars/carroreportservlet?NOME="+getFiltro());
//		Util.redirect("/Saude/pacientereportservlet");
	}


	public List<Carro> getListaCarro() {
		if (listaCarro == null)
			listaCarro = new ArrayList<Carro>();
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
}