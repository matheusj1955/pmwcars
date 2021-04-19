package br.unitins.pmwcars.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Venda extends DefaultEntity<Venda>{
	
	private static final long serialVersionUID = -1408961887041249252L;
	private Date diaVenda;
	
	public Date getDiaVenda() {
		return diaVenda;
	}
	public void setDiaVenda(Date diaVenda) {
		this.diaVenda = diaVenda;
	}

}
