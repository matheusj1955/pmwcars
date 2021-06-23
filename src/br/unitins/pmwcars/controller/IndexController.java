package br.unitins.pmwcars.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.FlashStorage;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Carro;
import br.untinis.pmwcars.repository.CarroRepository;

@Named
@RequestScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = -3372383158657174357L;
	
	private List<Carro> listaCarro;

	private String pesquisar;
	
	public List<Carro> getListaCarro() {
		if (listaCarro == null) {
			listaCarro = new ArrayList<Carro>();
			CarroRepository repo = new CarroRepository();
			try {
				listaCarro = repo.findAll();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaCarro;
	}
	
	public List<Carro> getCarrosDisponiveis(){
		return getListaCarro().stream()
				.filter(c -> c.getEstoque() > 0)
				.filter(c -> c.getNome().toLowerCase().contains(getPesquisar().toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public void comprarCarro(Carro carro) {
		
		FlashStorage.setItem("carroSelecionado", carro);
		
		Util.redirect("/Pmwcars/pages/item.xhtml");
		
	}

	public String getPesquisar() {
		if(pesquisar == null)
			pesquisar = "";
		return pesquisar;
	}

	public void setPesquisar(String pesquisar) {
		this.pesquisar = pesquisar;
	}
	


	
}
