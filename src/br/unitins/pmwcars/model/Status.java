package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.OneToMany;

public enum Status {

	VENDIDO(1, "Vendido"),
	EMESTOQUE(1, "Emestoque"),;
	
	@OneToMany(mappedBy = "status")
	private List<Carro> listaCarro;

	private int id;
	private String label;
	
	Status(int id, String label) {
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

//	public List<Carro> getListaCarro() {
//		return listaCarro;
//	}
//
//	public void setListaCarro(List<Carro> listaCarro) {
//		this.listaCarro = listaCarro;
//	}

	
	
}
