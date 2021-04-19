package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class Marca  extends DefaultEntity<Marca>{

	private static final long serialVersionUID = 5630456718670379495L;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
