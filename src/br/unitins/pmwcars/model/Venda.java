package br.unitins.pmwcars.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Venda extends DefaultEntity<Venda>{
	
	private static final long serialVersionUID = -1408961887041249252L;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "Venda_Pagamento", joinColumns = @JoinColumn(name = "idvenda"),
//	inverseJoinColumns = @JoinColumn(name = "idpagamento"))
//	private List<Pagamento> listapagamento;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<ItemVenda> listaItemVenda;
	private LocalDateTime data;

	
	public List<ItemVenda> getListaItemVenda() {
		return listaItemVenda;
	}


	public void setListaItemVenda(List<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


//	public List<Pagamento> getListapagamento() {
//		return listapagamento;
//	}
//
//
//	public void setListapagamento(List<Pagamento> listapagamento) {
//		this.listapagamento = listapagamento;
//	}


	
	
	

}
