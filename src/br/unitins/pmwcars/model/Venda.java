package br.unitins.pmwcars.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Venda extends DefaultEntity<Venda>{
	
	private static final long serialVersionUID = -1408961887041249252L;
	private Date diaVenda;
	
	@ManyToMany
	@JoinTable(name = "Venda_Pagamento", joinColumns = @JoinColumn(name = "idvenda"),
	inverseJoinColumns = @JoinColumn(name = "idpagamento"))
	private List<Pagamento> listapagamento;
	
	
	
	public Date getDiaVenda() {
		return diaVenda;
	}
	public void setDiaVenda(Date diaVenda) {
		this.diaVenda = diaVenda;
	}

}
