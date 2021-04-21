package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.OneToMany;

public enum Modelo {

	SEDAN(1, "Sedan"), 
	HATCH(1, "Hatch");

	@OneToMany(mappedBy = "modelo")
	private List<Carro> listacarro;

	private int id;
	private String label;
	
	Modelo(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}



}
