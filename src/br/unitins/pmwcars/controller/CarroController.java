package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.SelectEvent;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.controller.listing.CarroListing;
import br.unitins.pmwcars.controller.listing.MarcaListing;
import br.unitins.pmwcars.controller.listing.PessoaFisicaListing;
import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.model.Marca;
import br.unitins.pmwcars.model.Modelo;
import br.unitins.pmwcars.model.Municipio;
import br.unitins.pmwcars.model.Perfil;
import br.unitins.pmwcars.model.PessoaFisica;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.CarroRepository;
import br.untinis.pmwcars.repository.MunicipioRepository;
import br.untinis.pmwcars.repository.UsuarioRepository;

@Named
@ViewScoped
public class CarroController extends  Controller<Carro>{

	private static final long serialVersionUID = -1419489362181022305L;

	private List<Carro> listaCarro;
	
	private List<Marca> listaMarca = null;

	@Override
	public Carro getEntity() {
		if (entity == null) {
			entity = new Carro();
			entity.setMarca(new Marca());
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
	
//	public List<Marca> filtrarMarcas() {
//		MunicipioRepository repo = new MunicipioRepository();
//		try {
//			listaMarca =  repo.findByEstado(getMarca().getId());
//		} catch (RepositoryException e) {
//			listaMunicipio =  new ArrayList<Municipio>();
//		}
//		return listaMunicipio;
//	}
//	
		
	public void abrirMarcaListing() {
		MarcaListing listing = new MarcaListing();
		listing.open();
	}
	
	public void obterMarcaListing(SelectEvent<Marca> event) {
		getEntity().setMarca(event.getObject());
	}
	
	public Modelo[] getListaModelo() {
		return Modelo.values();
	}
	
	public List<Marca> getListaMunicipio() {
		if (listaMarca == null) {
			listaMarca =  new ArrayList<Marca>();
		}
		return listaMarca;
	}
	
	public List<Carro> getListaCarro() {
		if (listaCarro == null) 
			listaCarro = new ArrayList<Carro>();
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}
}
