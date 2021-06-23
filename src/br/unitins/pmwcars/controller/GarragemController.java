package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.model.Garragem;
import br.untinis.pmwcars.repository.CarroRepository;


@Named
@ViewScoped
public class GarragemController extends  Controller<Garragem> {

	private static final long serialVersionUID = -6278450723084578888L;
	
	@Override
	public Garragem getEntity() {
		if (entity == null) {
			entity = new Garragem();
		}
		return entity;
	}
	
	private List<Carro> listaCarro = null;
	
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

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

}
