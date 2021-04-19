package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class Garagem extends DefaultEntity<Garagem>{
	
	private static final long serialVersionUID = 5224836876589954887L;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
