package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda extends DefaultEntity<ItemVenda>{

	private static final long serialVersionUID = -3684236988369469670L;
	private Integer quantidade;
	private double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcarro", nullable = false)
	private Carro carro;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
