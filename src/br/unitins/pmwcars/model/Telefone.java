package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity<Telefone>{

	private static final long serialVersionUID = 4551594924080125139L;
	private String codigoArea;
	private String numero;
	
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
