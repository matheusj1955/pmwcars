package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public enum FormaPagamento {
	
	DINHEIRO(1, "Dinheiro"), 
	BOLETO(1, "Boleto"),
	DEBITO(1, "Debito"),
	CREDITO(1, "Credito");
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Pagamento> listapagamento;
	
	private int id;
	private String label;
	
	FormaPagamento(int id, String label) {
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
