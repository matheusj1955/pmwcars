package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.controller.listing.CarroListing;
import br.unitins.pmwcars.controller.listing.EstadoListing;
import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.model.Estado;
import br.untinis.pmwcars.repository.CarroRepository;

@Named
@ViewScoped
public class CarroController extends Controller<Carro> {

	private static final long serialVersionUID = 4197903813859771716L;

	@Override
	public Carro getEntity() {
		if (entity == null) {
			entity = new Carro();
			entity.setEstado(new Estado());
		}
		return entity;
	}
	
	public void abrirCarroListing() {
		CarroListing listing = new CarroListing();
		listing.open();
	}
	
	public void obterCarroListing(SelectEvent<Carro> event) {
		setEntity(event.getObject());
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
}
