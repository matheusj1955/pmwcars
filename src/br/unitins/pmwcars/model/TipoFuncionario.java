package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public enum TipoFuncionario {

	GERENTE(1, "Gerente"), 
	OPERACIONAL(1, "Operacional");

	@OneToMany(fetch = FetchType.LAZY)
	private List<Funcionario> listafuncionario;
	
	private int id;
	private String label;
	
	TipoFuncionario(int id, String label) {
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
