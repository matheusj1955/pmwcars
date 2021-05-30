package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Garagem extends DefaultEntity<Garagem>{
	
	private static final long serialVersionUID = 5224836876589954887L;
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcarro", nullable = false)
	private Carro carro;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
