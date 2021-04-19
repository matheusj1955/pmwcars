package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class ItemVenda extends DefaultEntity<ItemVenda>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3684236988369469670L;
	private Integer quantidade;
	private double valor;
	
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
