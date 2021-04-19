package br.unitins.pmwcars.controller.listing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.PrimeFaces;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.DefaultEntity;
import br.unitins.pmwcars.model.Estado;
import br.untinis.pmwcars.repository.EstadoRepository;
import br.untinis.pmwcars.repository.Repository;

public abstract class Listing<T extends DefaultEntity<T>> implements Serializable {

	private static final long serialVersionUID = 3137547480654871438L;
	private String page;
	private Repository<T> repository;
	private List<T> list;

	public Listing(String page, Repository<T> repository) {
		super();
		this.page = page;
		this.repository = repository;
	}

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", true);
		options.put("resizable", true);
		options.put("width", 800);
		options.put("height", 400);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
	
		PrimeFaces.current().dialog().openDynamic(page, options, null);
	}
	
	public void select(int id) {
		T obj = null;
		try {
			obj = repository.findById(id);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		PrimeFaces.current().dialog().closeDynamic(obj);
	}
	
	public abstract void pesquisar();
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}